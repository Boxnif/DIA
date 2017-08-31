package com.KM.boxnif.dia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.KM.boxnif.dia.Anfragen.AnzahlAnfrage;
import com.KM.boxnif.dia.Anfragen.AuswertungAnfrage;
import com.KM.boxnif.dia.Anfragen.DatenLaden;
import com.KM.boxnif.dia.Anfragen.loeschenAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class AuswertungsAbfrage extends AppCompatActivity
{
    Button lButton;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,vorName,nachName,alter,gebDatum, estDatum;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auswertungs_abfrage);
        Intent intent = getIntent();
        final String Auswertungs_ID = intent.getStringExtra("Auswertungs_ID");
        String Vorname = intent.getStringExtra("Vorname");
        String Nachname = intent.getStringExtra("Nachname");
        String Geburtsdatum = intent.getStringExtra("Geburtsdatum");
        String Alt = intent.getStringExtra("Alt");
        String ErstelltDatum = intent.getStringExtra("ErstelltDatum");
        String Modul1 = intent.getStringExtra("Modul1");
        String Modul2 = intent.getStringExtra("Modul2");
        String Modul3 = intent.getStringExtra("Modul3");
        String Modul4 = intent.getStringExtra("Modul4");
        String Modul5 = intent.getStringExtra("Modul5");
        String Modul6 = intent.getStringExtra("Modul6");
        String AssPunkte = intent.getStringExtra("AssPunkte");
        String BBC = intent.getStringExtra("BBC");
        String Pflegegrad = intent.getStringExtra("Pflegegrad");
        String EMail = intent.getStringExtra("EMail");


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
}
