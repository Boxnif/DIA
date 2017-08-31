package com.KM.boxnif.dia;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.KM.boxnif.dia.Anfragen.LizenzenAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;


public class Lizenz extends AppCompatActivity
{
    Button btn;
    String anzahl;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lizenz);
        btn = (Button) findViewById(R.id.loginButton);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                anzahl = ((EditText) findViewById(R.id.anzahl)).getText().toString();
                if(lizenz())
                {
                for(int i=0; i<Integer.parseInt(anzahl); i++)
                {
                    lizenzen(Utility.email);
                }
                }
            }
        });
    }
    public void lizenzen(String email )
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
                    if(success)
                    {
                        Toast.makeText(getApplicationContext(), anzahl+" Lizenzen gekauft", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), StartUp.class);
                        startActivity(i);
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Lizenz.this);
                        builder.setMessage("Registrierung fehlgeschlagen").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        LizenzenAnfrage ra = new LizenzenAnfrage(email,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Lizenz.this);
        queue.add(ra);
    }
    public boolean lizenz()
    {
        if (lizenzPattern.matcher(((EditText) findViewById(R.id.anzahl)).getText().toString()).matches())
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Lizenz darf nicht leer oder 0 sein",Toast.LENGTH_LONG).show();
        return false;
    }
    private static final Pattern lizenzPattern = Pattern.compile
            (
                    "[1-9]"+"[0-9]*"
            );
}
