package com.KM.boxnif.dia;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.LinkedList;



public class Modul_1 extends AppCompatActivity
{
    Button btn1, ibtn0, ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6;
    DisplayMetrics dm;
    Utility utility;
    LinkedList<Spinner> spin;
    Context con;
    Spinner spin1, spin2, spin3, spin4, spin5, spin6;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_1);
        btn1 = (Button) findViewById(R.id.modul_1_button);
        ibtn0 = (Button) findViewById(R.id.ibtn);
        ibtn1 = (Button) findViewById(R.id.ibtn1);
        ibtn2 = (Button) findViewById(R.id.ibtn2);
        ibtn3 = (Button) findViewById(R.id.ibtn3);
        ibtn4 = (Button) findViewById(R.id.ibtn4);
        ibtn5 = (Button) findViewById(R.id.ibtn5);
        ibtn6 = (Button) findViewById(R.id.ibtn6);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        utility = new Utility();
        con = getApplicationContext();
        spin = new LinkedList<>();

        spin1 = (Spinner) findViewById(R.id.spinner1);
        setUp(spin1, Save.m101);
        spin2 = (Spinner) findViewById(R.id.spinner2);
        setUp(spin2, Save.m102);
        spin3 = (Spinner) findViewById(R.id.spinner3);
        setUp(spin3, Save.m103);
        spin4 = (Spinner) findViewById(R.id.spinner4);
        setUp(spin4, Save.m104);
        spin5 = (Spinner) findViewById(R.id.spinner5);
        setUp(spin5, Save.m105);
        spin6 = (Spinner) findViewById(R.id.spinner6);
        spin6.setAdapter(ArrayAdapter.createFromResource(this, R.array.janein_array, R.layout.spinner_item));
        spin6.setSelection(Save.m106);

        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (utility.SpinnerAusgewaelt(spin) && !(((Spinner) findViewById(R.id.spinner6)).getSelectedItem().toString()).equals("Bitte auswählen"))
                {
                    utility.bbc = ((Spinner) findViewById(R.id.spinner6)).getSelectedItem().toString();
                    saveSpinner();
                    if(utility.month<30)
                    {
                        utility.Modul_1_Kinder();
                    }
                    else if(utility.month>=30)
                    {
                        utility.Modul_1_Erwachsene();
                    }


                    showAlert(view);

                } else
                {
                    Toast.makeText(getApplicationContext(), "Bitte füllen sie alles aus", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Angezeigte infotexte
        if(Utility.age>=18)
        {
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext100), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext101), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext102), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext103), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext104), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext105), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext106), con);
                }
            });
        }else{
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext100k), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext101k), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext102k), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext103k), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext104k), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext105k), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext106k), con);
                }
            });
        }
    }

    //spinner werden weiter verfeinert
    public void setUp(Spinner sp,int sptxt)
    {
        sp.setAdapter(ArrayAdapter.createFromResource(this, R.array.selbststaendig_array, R.layout.spinner_item));
        spin.add(sp);
        sp.setSelection(sptxt);
    }


    public void onBackPressed() {
        super.onBackPressed();
        saveSpinner();
    }
    private  void saveSpinner()
    {
        Save.m101 = spin1.getSelectedItemPosition();
        Save.m102 = spin2.getSelectedItemPosition();
        Save.m103 = spin3.getSelectedItemPosition();
        Save.m104 = spin4.getSelectedItemPosition();
        Save.m105 = spin5.getSelectedItemPosition();
        Save.m106 = spin6.getSelectedItemPosition();
    }


    //Fenster was vorm Weitergang zu einer Neuen aktivität auftaucht
    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.gassm1) + Utility.gib1() + (getString(R.string.bb) + utility.bbc)));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();

                Intent i = new Intent(getApplicationContext(), Modul_2.class);
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