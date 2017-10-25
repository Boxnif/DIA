package com.KM.boxnif.dia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.KM.boxnif.dia.Anfragen.AnzahlAnfrage;
import com.KM.boxnif.dia.Anfragen.AuswertungAnfrage;
import com.KM.boxnif.dia.Anfragen.DatenLaden;
import com.KM.boxnif.dia.Anfragen.loeschenAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;


public class AuswertungsAbfrage extends AppCompatActivity
{
    Button lButton, pmsB;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,vorName,nachName,alter,gebDatum, estDatum;
    String Vorname, Nachname, Geburtsdatum, Alt, ErstelltDatum, Modul1, Modul2, Modul3, Modul4, Modul5, Modul6, AssPunkte, BBC, Pflegegrad, EMail;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auswertungs_abfrage);
        Intent intent = getIntent();
        final String Auswertungs_ID = intent.getStringExtra("Auswertungs_ID");
        Vorname = intent.getStringExtra("Vorname");
        Nachname = intent.getStringExtra("Nachname");
        Geburtsdatum = intent.getStringExtra("Geburtsdatum");
        Alt = intent.getStringExtra("Alt");
        ErstelltDatum = intent.getStringExtra("ErstelltDatum");
        Modul1 = intent.getStringExtra("Modul1");
        Modul2 = intent.getStringExtra("Modul2");
        Modul3 = intent.getStringExtra("Modul3");
        Modul4 = intent.getStringExtra("Modul4");
        Modul5 = intent.getStringExtra("Modul5");
        Modul6 = intent.getStringExtra("Modul6");
        AssPunkte = intent.getStringExtra("AssPunkte");
        BBC = intent.getStringExtra("BBC");
        Pflegegrad = intent.getStringExtra("Pflegegrad");
        EMail = intent.getStringExtra("EMail");


        tv1 = (TextView) findViewById(R.id.endauswertung_01);
        tv1.setText(tv1.getText().toString() +" "+ Modul1);
        tv2 = (TextView) findViewById(R.id.endauswertung_02);
        tv2.setText(tv2.getText().toString() +" "+ Modul2);
        tv3 = (TextView) findViewById(R.id.endauswertung_03);
        tv3.setText(tv3.getText().toString() +" "+ Modul3);
        tv4 = (TextView) findViewById(R.id.endauswertung_04);
        tv4.setText(tv4.getText().toString() +" "+ Modul4);
        tv5 = (TextView) findViewById(R.id.endauswertung_05);
        tv5.setText(tv5.getText().toString() +" "+ Modul5);
        tv6 = (TextView) findViewById(R.id.endauswertung_06);
        tv6.setText(tv6.getText().toString() +" "+ Modul6);
        tv7 = (TextView) findViewById(R.id.endauswertung_Alle);
        tv7.setText(tv7.getText().toString() +" "+ AssPunkte);
        tv8 = (TextView) findViewById(R.id.endauswertung_bc);
        tv8.setText(tv8.getText().toString() +" "+ BBC);
        tv9 = (TextView) findViewById(R.id.endauswertung_ps);
        tv9.setText(tv9.getText().toString() +" "+ Pflegegrad);

        estDatum = (TextView) findViewById(R.id.erDatum);
        estDatum.setText("Begutachtet am: "+ErstelltDatum);
        vorName = (TextView) findViewById(R.id.vName);
        vorName.setText("Vorname: "+Vorname);
        nachName = (TextView) findViewById(R.id.nName);
        nachName.setText("Nachname: "+Nachname);
        alter = (TextView) findViewById(R.id.alter);
        alter.setText("Alter: "+Alt+" Jahre");
        gebDatum = (TextView) findViewById(R.id.gDatum);
        gebDatum.setText("Geburtsdatum: "+Geburtsdatum);

        lButton = (Button) findViewById(R.id.loeschenButton);
        lButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showAlert(view,Auswertungs_ID);
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
    }

    private void showAlert(View view, final String id)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Möchten Sie den Eintrag wirklich löschen?");
        alert.setPositiveButton("Ja Löschen", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                loeschen(id);
            }
        });
        alert.setNegativeButton("Nein", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        alert.create();
        alert.show();
    }

    private void loeschen(final String id)
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
                        Intent i = new Intent(getApplicationContext(), StartUp.class);
                        startActivity(i);
                        //Toast.makeText(getApplicationContext(), "La", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        loeschenAnfrage loeschenAnfrage = new loeschenAnfrage(id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(AuswertungsAbfrage.this);
        queue.add(loeschenAnfrage);
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
                String emailBody = "Begutachtet am: "+ErstelltDatum+"\n<br>" +
                        "Vorname: "+Vorname+"\n<br>" +
                        "Nachname: "+Nachname+"\n<br>" +
                        "Geburtsdatum: "+Geburtsdatum+"\n<br>" +
                        "Alter: "+Alt+"\n<br>" +
                        "Modul 1: "+Modul1+"\n<br>" +
                        "Modul 2: "+Modul2+"\n<br>" +
                        "Modul 3: "+Modul3+"\n<br>" +
                        "Modul 4: "+Modul4+"\n<br>" +
                        "Modul 5: "+Modul5+"\n<br>" +
                        "Modul 6: "+Modul6+"\n<br>" +
                        "Summe der gewichteten Assessmentpunkte: "+AssPunkte+"\n<br>" +
                        "Besondere Bedarfskonstellation: "+BBC+"\n<br>" +
                        "Pflegegrad: "+Pflegegrad+"";
                new GMailSender(AuswertungsAbfrage.this).execute(fromEmail,
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
}
