package com.KM.boxnif.dia.Anfragen;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.KM.boxnif.dia.AuswertungsAbfrage;
import com.KM.boxnif.dia.Login;
import com.KM.boxnif.dia.R;
import com.KM.boxnif.dia.StartUp;
import com.KM.boxnif.dia.Utility;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class DatenLaden extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daten_laden);
        Intent intent = getIntent();
        int anzahl = intent.getIntExtra("anzahl", -1);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        for(int i = 1; i< anzahl+1; i++)
        {
            datenLaden(i,ll);
        }


    }
    private void datenLaden(final int i,final LinearLayout ll)
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
                        String Auswertungs_ID = jsonObject.getString("Auswertungs_ID");
                        String Vorname = jsonObject.getString("Vorname");
                        String Nachname = jsonObject.getString("Nachname");
                        String Geburtsdatum = jsonObject.getString("Geburtsdatum");
                        String Alt = jsonObject.getString("Alt");
                        String ErstelltDatum = jsonObject.getString("ErstelltDatum");
                        String Modul1 = jsonObject.getString("Modul1");
                        String Modul2 = jsonObject.getString("Modul2");
                        String Modul3 = jsonObject.getString("Modul3");
                        String Modul4 = jsonObject.getString("Modul4");
                        String Modul5 = jsonObject.getString("Modul5");
                        String Modul6 = jsonObject.getString("Modul6");
                        String AssPunkte = jsonObject.getString("AssPunkte");
                        String BBC = jsonObject.getString("BBC");
                        String Pflegegrad = jsonObject.getString("Pflegegrad");
                        String EMail = jsonObject.getString("EMail");
                        addButton(i, ll,Auswertungs_ID,Vorname,Nachname,Geburtsdatum,Alt,ErstelltDatum,Modul1,Modul2,Modul3,Modul4,Modul5,Modul6,AssPunkte,BBC,Pflegegrad,EMail);
                    }
                    else
                    {
                        datenLaden(i,ll);
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        SpeicherungAnfrage speicherungAnfrage = new SpeicherungAnfrage(Utility.email, i, responseListener);
        RequestQueue queue = Volley.newRequestQueue(DatenLaden.this);
        queue.add(speicherungAnfrage);
    }
    private void addButton(final int i,LinearLayout ll,final String Auswertungs_ID, final String Vorname, final String Nachname, final String Geburtsdatum, final String Alt,final String ErstelltDatum,  final String Modul1, final String Modul2, final String Modul3, final String Modul4, final String Modul5, final String Modul6, final String AssPunkte, final String BBC, final String Pflegegrad, final String EMail)
    {
        Button btn = new Button(this);
        btn.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btn.setId(i);
        btn.setText(Vorname+" "+Nachname+" "+ErstelltDatum);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), AuswertungsAbfrage.class);
                i.putExtra("Auswertungs_ID", Auswertungs_ID);
                i.putExtra("Vorname",Vorname);
                i.putExtra("Nachname",Nachname );
                i.putExtra("Geburtsdatum",Geburtsdatum );
                i.putExtra("Alt", Alt);
                i.putExtra("ErstelltDatum",ErstelltDatum );
                i.putExtra("Modul1",Modul1 );
                i.putExtra("Modul2",Modul2 );
                i.putExtra("Modul3",Modul3 );
                i.putExtra("Modul4",Modul4 );
                i.putExtra("Modul5",Modul5 );
                i.putExtra("Modul6",Modul6 );
                i.putExtra("AssPunkte",AssPunkte );
                i.putExtra("BBC",BBC );
                i.putExtra("Pflegegrad",Pflegegrad );
                i.putExtra("EMail",EMail );
                startActivity(i);
            }
        });
        ll.addView(btn);
    }
}
