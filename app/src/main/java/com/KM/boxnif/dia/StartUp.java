package com.KM.boxnif.dia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartUp extends AppCompatActivity
{

    Button startB, loginB, loadB, regisB;

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
                if (Utility.logedIn)
                {
                    Intent i = new Intent(getApplicationContext(), PatientenInfo.class);
                    startActivity(i);
                } else
                {
                    Toast.makeText(getApplicationContext(), "Bitte Loggen sie sich ein", Toast.LENGTH_LONG).show();
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

}