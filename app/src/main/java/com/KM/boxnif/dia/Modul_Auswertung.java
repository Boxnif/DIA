package com.KM.boxnif.dia;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.KM.boxnif.dia.Anfragen.AuswertungAnfrage;
import com.KM.boxnif.dia.Anfragen.LoginAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class Modul_Auswertung extends AppCompatActivity
{
    Button speichernB,zuruekB, pmsB;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,vorName,nachName,alter,gebDatum,werbeB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul__auswertung);
        tv1 = (TextView) findViewById(R.id.endauswertung_01);
        tv1.setText(tv1.getText().toString() +" "+ Utility.gib1());
        tv2 = (TextView) findViewById(R.id.endauswertung_02);
        tv2.setText(tv2.getText().toString() +" "+ Utility.gib2());
        tv3 = (TextView) findViewById(R.id.endauswertung_03);
        tv3.setText(tv3.getText().toString() +" "+ Utility.gib3());
        tv4 = (TextView) findViewById(R.id.endauswertung_04);
        tv4.setText(tv4.getText().toString() +" "+ Utility.gib4());
        tv5 = (TextView) findViewById(R.id.endauswertung_05);
        tv5.setText(tv5.getText().toString() +" "+ Utility.gib5());
        tv6 = (TextView) findViewById(R.id.endauswertung_06);
        tv6.setText(tv6.getText().toString() +" "+ Utility.gib6());
        tv7 = (TextView) findViewById(R.id.endauswertung_Alle);
        tv7.setText(tv7.getText().toString() +" "+ berechnung());
        tv8 = (TextView) findViewById(R.id.endauswertung_bc);
        tv8.setText(tv8.getText().toString() +" "+ Utility.bbc);
        tv9 = (TextView) findViewById(R.id.endauswertung_ps);
        tv9.setText(tv9.getText().toString() +" "+ umrechnung());

        vorName = (TextView) findViewById(R.id.vName);
        vorName.setText("Vorname: "+Utility.vor);
        nachName = (TextView) findViewById(R.id.nName);
        nachName.setText("Nachname: "+Utility.nach);
        alter = (TextView) findViewById(R.id.alter);
        alter.setText("Alter: "+Utility.age+" Jahre");
        gebDatum = (TextView) findViewById(R.id.gDatum);
        gebDatum.setText("Geburtsdatum: "+Utility.gebT+"."+Utility.gebM+"."+Utility.gebY);
        speichernB = (Button) findViewById(R.id.saveButton);
        speichernB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(Utility.logedIn)
                {
                    showAlert(v);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Sie müssen eingelogged sein um die Daten speichern zu können.", Toast.LENGTH_LONG).show();
                }
            }
        });
        zuruekB = (Button) findViewById(R.id.backstartButton);
        zuruekB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), StartUp.class);
                startActivity(i);
            }
        });
        pmsB = (Button) findViewById(R.id.emailButton);
        pmsB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(Utility.logedIn)
                {
                    showEmail(v);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Sie müssen eingelogged sein um sich eine Email senden zu können.", Toast.LENGTH_LONG).show();
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



    }

    private double berechnung()
    {
        double wert = 0;
        wert = Double.parseDouble(Utility.gib1());
        if(Double.parseDouble(Utility.gib2())> Double.parseDouble(Utility.gib3()))
        {
            wert += Double.parseDouble(Utility.gib2());
        }
        else
        {
            wert +=Double.parseDouble(Utility.gib3());
        }
        wert +=Double.parseDouble(Utility.gib4());
        wert +=Double.parseDouble(Utility.gib5());
        wert +=Double.parseDouble(Utility.gib6());
        return wert;
    }

    private int umrechnung()
    {
        double wert = berechnung();
        if(Utility.bbc.equals("Ja"))
        {
            return 5;
        }
        else if (wert<12.5)
        {
            return 0;
        }
        else if(wert>=12.5 && wert<27)
        {
            return 1;
        }
        else if(wert>=27 && wert<47.5)
        {
            return 2;
        }
        else if(wert>=47.5 && wert<70)
        {
            return 3;
        }
        else if(wert>=70 && wert<90)
        {
            return 4;
        }
        else if(wert>=90 && wert<100)
        {
            return 5;
        }
        else return 0;
    }
    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.speichern)));
        alert.setPositiveButton("Speichern", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                speichern();
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
    private void showEmail(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.pmsSecure)));
        alert.setPositiveButton("Senden", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String fromEmail = "uw.b.nbi@gmail.com";
                String fromPassword = "UWnba2016";
                String toEmails = Utility.email;
                List toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                Log.i("SendMailActivity", "To List: " + toEmailList);
                String emailSubject = "Auswertung";
                String emailBody = "Begutachtet am: "+Utility.heuteT+"."+Utility.heuteM+"."+Utility.heuteY+"\n<br>" +
                        "Vorname: "+Utility.vor+"\n<br>" +
                        "Nachname: "+Utility.nach+"\n<br>" +
                        "Geburtsdatum: "+Utility.gebT+"."+Utility.gebM+"."+Utility.gebY+"\n<br>" +
                        "Alter: "+Utility.age+"\n<br>" +
                        "Modul 1: "+Utility.gib1()+"\n<br>" +
                        "Modul 2: "+Utility.gib2()+"\n<br>" +
                        "Modul 3: "+Utility.gib3()+"\n<br>" +
                        "Modul 4: "+Utility.gib4()+"\n<br>" +
                        "Modul 5: "+Utility.gib5()+"\n<br>" +
                        "Modul 6: "+Utility.gib6()+"\n<br>" +
                        "Summe der gewichteten Assessmentpunkte: "+berechnung()+"\n<br>" +
                        "Besondere Bedarfskonstellation: "+Utility.bbc+"\n<br>" +
                        "Pflegegrad: "+umrechnung()+"";
                new GMailSender(Modul_Auswertung.this).execute(fromEmail,
                        fromPassword, toEmailList, emailSubject, emailBody);
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
        private void speichern()
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
                            Toast.makeText(getApplicationContext(), "Daten wurden erfolgreich gespeichert.", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
            };

            AuswertungAnfrage awa = new AuswertungAnfrage(Utility.vor,Utility.nach,Utility.gebT+"."+Utility.gebM+"."+Utility.gebY,""+Utility.age,Utility.heuteT+"."+Utility.heuteM+"."+Utility.heuteY, Utility.gib1(),Utility.gib2(),Utility.gib3(),Utility.gib4(),Utility.gib5(),Utility.gib6(), ""+berechnung(),Utility.bbc,""+umrechnung(),Utility.email, responseListener);
            RequestQueue queue = Volley.newRequestQueue(Modul_Auswertung.this);
            queue.add(awa);
        }

}
