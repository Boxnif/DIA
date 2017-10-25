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

import java.util.Arrays;
import java.util.List;
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
        String fromEmail = "uw.b.nbi@gmail.com";
        String fromPassword = "UWnba2016";
        String toEmails = semail;
        List toEmailList = Arrays.asList(toEmails
                .split("\\s*,\\s*"));
        Log.i("SendMailActivity", "To List: " + toEmailList);
        String emailSubject = "Password vergessen";
        String emailBody = "<p>Guten Tag,</p>\n" +
                " \n" +
                "<p>in dieser Mail erhalten Sie nun noch mal Ihr Passwort.</p>\n" +
                "<p>Bewahren Sie diese Mail und Ihr Passwort immer sicher auf.</p>\n" +
                " \n" +
                "<p>Ihr Passwort ist: "+_password+"</p>\n" +
                " \n" +
                "<p>Falls Sie Ihr Passwort nicht vergessen hatten, ignorieren Sie diese Mail bitte einfach.</p>\n" +
                " \n" +
                "<p>Für weitere Fragen melden Sie sich bitte unter info@uw-b.de.</p>\n" +
                " \n" +
                "<p>Viele Grüße aus der Südheide</p>\n" +
                "\n" +
                "<p>Ralph Wißgott</p>\n" +
                "<p>Unternehmensberatung Wißgott</p>\n" +
                "<p>Getreidering 3</p>\n" +
                "<p>29308 Winsen (Aller)</p>\n" +
                "\n" +
                "<p>Tel.: 05143 / 669627</p>\n" +
                "<p>Fax: 05143 / 6690834</p>\n" +
                "\n" +
                "<p>Email: rw@uw-b.de</p>\n" +
                "<p>URL: http://www.uw-b.de</p>";
        new GMailSender(PasswordVergessen.this).execute(fromEmail,
                fromPassword, toEmailList, emailSubject, emailBody);
        /*Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    *//*boolean success = jsonObject.getBoolean("success");
                    if (success)
                    {
                        Toast.makeText(getApplicationContext(), "La", Toast.LENGTH_LONG).show();
                    } else
                    {
                        //Toast.makeText(getApplicationContext(), "Keine Antwort", Toast.LENGTH_LONG).show();
                    }*//*
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        EmailAnfrage emailAnfrage= new EmailAnfrage(semail,_password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(PasswordVergessen.this);
        queue.add(emailAnfrage);*/
    }
}
