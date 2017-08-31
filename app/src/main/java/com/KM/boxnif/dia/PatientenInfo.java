package com.KM.boxnif.dia;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class PatientenInfo extends AppCompatActivity
{

    Button btn1;
    static Button dpButton;
    String vor,nach;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patienten_info);


        btn1 = (Button) findViewById(R.id.modulStartButton);
        // es wird erst geprüft ob keins der Felder leer ist
        // dann wird alles in die Utilitydatei übertragen
        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                vor= ((EditText)findViewById(R.id.vorname)).getText().toString();
                nach= ((EditText)findViewById(R.id.nachname)).getText().toString();
                if(vor.equals("")|| nach.equals("")||dpButton.getText().equals("Bitte Geburtsdatum auswählen"))
                {
                    Toast.makeText(getApplicationContext(), "Bitte füllen sie alles aus",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Utility.vor=vor;
                    Utility.nach=nach;
                    Utility.age();
                    Utility.ageMonth();
                    if(Utility.month<19)
                    {
                        showAlert(view, getString((R.string.u18m)));

                    }
                    else if(Utility.month>=19 && Utility.age<18)
                    {
                        showAlert(view, getString((R.string.ue18m)));
                    }
                    else
                    {
                        showAlert(view, getString((R.string.ue18j)));
                    }


                }
            }
        });

        dpButton= (Button) findViewById(R.id.datePickerButton);
        dpButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                showDatePickerDialog(view);
            }
        });

    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();

        newFragment.show(getFragmentManager(), "datePicker");
    }
    public static void gebSetzen()
    {
        dpButton.setText(Utility.gebT+"."+Utility.gebM+"."+Utility.gebY);
    }
    private void showAlert(View view, String str)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.patientenname)+Utility.vor+" "+Utility.nach+(getString(R.string.patientenalter))+(Utility.age)+" Jahre und "+(Utility.monthfor())+" Monate"+ str));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                if(Utility.month<19)
                {
                    Intent i = new Intent(getApplicationContext(), Modul_1k.class);
                    startActivity(i);
                    dialog.dismiss();
                }else{
                dialog.dismiss();
                Intent i = new Intent(getApplicationContext(), Modul_1.class);
                startActivity(i);
            }}
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
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), StartUp.class);
        startActivity(i);
    }




}
