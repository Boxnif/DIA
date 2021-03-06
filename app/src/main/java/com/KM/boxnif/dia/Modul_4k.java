package com.KM.boxnif.dia;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Modul_4k extends AppCompatActivity
{
    Button btn1, ibtn0, ibtn1;
    DisplayMetrics dm;
    Utility utility;
    Context con;
    Spinner spin1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_4k);
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        utility = new Utility();
        con = getApplicationContext();
        btn1 = (Button) findViewById(R.id.modul_4_button);
        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (!(((Spinner) findViewById(R.id.spinner1)).getSelectedItem().toString()).equals("Bitte auswählen"))
                {
                    //berechnung muss stattfinden
                    Save.m4k = spin1.getSelectedItemPosition();
                    utility.Modul_4_uKinder();
                    showAlert(view);

                } else
                {
                    Toast.makeText(getApplicationContext(), "Bitte füllen sie alles aus", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Angezeigte infotexte
        ibtn0 = (Button) findViewById(R.id.ibtn);
        ibtn0.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                utility.infoPopup(getString(R.string.infotext400kn), con);
            }
        });
        ibtn1 = (Button) findViewById(R.id.ibtn1);
        ibtn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                utility.infoPopup(getString(R.string.infotext40k), con);
            }
        });
        spin1 = (Spinner) findViewById(R.id.spinner1);
        spin1.setAdapter(ArrayAdapter.createFromResource(this, R.array.janein_array, R.layout.spinner_item));
        spin1.setSelection(Save.m4k);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Save.m4k = spin1.getSelectedItemPosition();
    }


    //Fenster was vorm Weitergang zu einer Neuen aktivität auftaucht
    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.gassm4) + Utility.gib4()));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();

                Intent i = new Intent(getApplicationContext(), Modul_5.class);
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
