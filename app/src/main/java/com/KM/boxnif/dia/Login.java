package com.KM.boxnif.dia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.KM.boxnif.dia.Anfragen.LoginAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity
{

    Button btn,pwButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = (Button) findViewById(R.id.loginButton);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)

            {
                final String email = ((EditText) findViewById(R.id.anzahl)).getText().toString();
                final String password = ((EditText) findViewById(R.id.password)).getText().toString();
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
                                Utility.logedIn = true;
                                Utility.email = email;
                                Intent i = new Intent(getApplicationContext(), StartUp.class);
                                startActivity(i);
                            } else
                            {
                                Toast.makeText(getApplicationContext(), "Email oder Passwort falsch", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                LoginAnfrage loginAnfrage = new LoginAnfrage(email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(loginAnfrage);
            }


        });
        pwButton = (Button) findViewById(R.id.pwButton);
        pwButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), PasswordVergessen.class);
                startActivity(i);
            }
        });
    }
}
