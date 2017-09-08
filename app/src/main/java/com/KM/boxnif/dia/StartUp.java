package com.KM.boxnif.dia;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.KM.boxnif.dia.Anfragen.AnzahlAnfrage;
import com.KM.boxnif.dia.Anfragen.AuswertungAnfrage;
import com.KM.boxnif.dia.Anfragen.BestaetigungAnfrage;
import com.KM.boxnif.dia.Anfragen.DatenLaden;
import com.KM.boxnif.dia.Anfragen.DeminischAnfrage;
import com.KM.boxnif.dia.Anfragen.EmailAnfrage;
import com.KM.boxnif.dia.Anfragen.GeraetRegistrierenAnfrage;
import com.KM.boxnif.dia.Anfragen.LizenzenAnfrage;
import com.KM.boxnif.dia.Anfragen.ProbeversionAnfrage;
import com.KM.boxnif.dia.Anfragen.RegistriertAnfrage;
import com.KM.boxnif.dia.Anfragen.RegistrieungOffenAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class StartUp extends AppCompatActivity
{

    Button startB, loginB, loadB, regisB, werbeB, dsB;
    int anzahl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        startB = (Button) findViewById(R.id.startButton);
        startB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Save.setZero();
                if(Utility.logedIn)
                {
                    Intent i = new Intent(getApplicationContext(), PatientenInfo.class);
                    startActivity(i);
                }
                else
                {
                    showAllert(view);
                }
            }
        });
        loginB = (Button) findViewById(R.id.loginButton);
        if(Utility.logedIn== false)
        {
            loginB.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                }
            });
            Utility.email = "";
        }
        else
        {
            loginB.setText("Logout");
            loginB.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Utility.logedIn = false;
                    loginB.setText("Login");
                    Intent i = new Intent(getApplicationContext(), StartUp.class);
                    startActivity(i);
                }
            });
        }
        regisB = (Button) findViewById(R.id.registrierenButton);
        regisB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showAlert(v);
            }
        });

        loadB = (Button) findViewById(R.id.loadButton);
        loadB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(Utility.logedIn)
                {
                    Anzahl();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Sie müssen eingelogged sein um Daten abzurufen", Toast.LENGTH_LONG).show();
                }
            }
        });
        werbeB = (Button) findViewById(R.id.werbeButton);
        werbeB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String url = "http://www.unternehmensberatung-wissgott.de/index.php?option=com_matukio&view=eventlist&Itemid=151";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
        dsB = (Button) findViewById(R.id.dsButton);
        dsB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String url = "https://anastigmatic-cones.000webhostapp.com/data-privacy.html";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

    }

    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.infotextRegistrierung)));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent i = new Intent(getApplicationContext(), Registrierung.class);
                startActivity(i);
            }
        });
        alert.setNegativeButton("Zurück", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        alert.create();
        alert.show();
    }

    private void Anzahl()
    {
        {
            Response.Listener<String> responseListener = new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    try
                    {
                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        if (success)
                        {
                            String count = jsonObject.getString("count");
                            Intent i = new Intent(getApplicationContext(), DatenLaden.class);
                            i.putExtra("anzahl", anzahl = Integer.parseInt(count));
                            startActivity(i);
                            //Toast.makeText(getApplicationContext(), "La", Toast.LENGTH_LONG).show();
                        } else
                        {
                            //Toast.makeText(getApplicationContext(), "Keine Antwort", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            AnzahlAnfrage anzahlAnfrage = new AnzahlAnfrage(Utility.email, responseListener);
            RequestQueue queue = Volley.newRequestQueue(StartUp.this);
            queue.add(anzahlAnfrage);
        }
    }

    private void showAllert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Um im Anschluss die Berechnung speichern zu können, müssen Sie eingelogged sein.");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent i = new Intent(getApplicationContext(), PatientenInfo.class);
                startActivity(i);
            }
        });
        alert.setNegativeButton("Zurück", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        alert.create();
        alert.show();
    }
}