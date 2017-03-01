package com.KM.boxnif.dia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartUp extends AppCompatActivity
{

    Button startB,loginB;

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
                Intent i = new Intent(getApplicationContext(), PatientenInfo.class);
                startActivity(i);
            }
        });

        loginB = (Button) findViewById(R.id.loginButton);
        loginB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), Registrierung.class);
                startActivity(i);
            }
        });
    }
}