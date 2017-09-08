package com.KM.boxnif.dia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.KM.boxnif.dia.Anfragen.EmailAnfrage;
import com.KM.boxnif.dia.Anfragen.PasswordAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;


public class PasswordVergessen extends AppCompatActivity
{
    Button resetB;
    String semail;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_vergessen);
        resetB = (Button) findViewById(R.id.resetButton);
        resetB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if(email())
                {
                    Log.e("email",semail);
                    getPassword(semail);
                }
            }
        });
    }
    public boolean email()
    {
        semail = ((EditText)(findViewById(R.id.email))).getText().toString();
        if(emailPattern.matcher(semail).matches())
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Email Adresse ist ungültig",Toast.LENGTH_LONG).show();
        return false;
    }
    public static final Pattern emailPattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    public void getPassword(String _email)
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
                        String password = jsonObject.getString("password");
                        Toast.makeText(getApplicationContext(), password, Toast.LENGTH_LONG).show();
                        sendEmail(password);
                    } else
                    {
                        Toast.makeText(getApplicationContext(), "Bitte probieren sie es erneut", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        PasswordAnfrage passwordAnfrage= new PasswordAnfrage(_email, responseListener);
        RequestQueue queue = Volley.newRequestQueue(PasswordVergessen.this);
        queue.add(passwordAnfrage);
    }
    public void sendEmail(String _password)
    {
        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    /*boolean success = jsonObject.getBoolean("success");
                    if (success)
                    {
                        Toast.makeText(getApplicationContext(), "La", Toast.LENGTH_LONG).show();
                    } else
                    {
                        //Toast.makeText(getApplicationContext(), "Keine Antwort", Toast.LENGTH_LONG).show();
                    }*/
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        EmailAnfrage emailAnfrage= new EmailAnfrage(semail,_password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(PasswordVergessen.this);
        queue.add(emailAnfrage);
    }
}
