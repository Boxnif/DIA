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

import java.util.LinkedList;

public class Modul_6 extends AppCompatActivity
{
    Button btn1, ibtn0, ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6;
    DisplayMetrics dm;
    Utility utility;
    LinkedList<Spinner> spin;
    Context con;
    Spinner spin1, spin2, spin3, spin4, spin5, spin6;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_6);
        btn1 = (Button) findViewById(R.id.modul_6_button);
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
        spin1 = (Spinner)(findViewById(R.id.spinner1));
        setUp(spin1, Save.m601);
        spin2 = (Spinner)(findViewById(R.id.spinner2));
        setUp(spin2, Save.m602);
        spin3 = (Spinner)(findViewById(R.id.spinner3));
        setUp(spin3, Save.m603);
        spin4 = (Spinner)(findViewById(R.id.spinner4));
        setUp(spin4, Save.m604);
        spin5 = (Spinner)(findViewById(R.id.spinner5));
        setUp(spin5, Save.m605);
        spin6 = (Spinner)(findViewById(R.id.spinner6));
        setUp(spin6, Save.m606);

        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (utility.SpinnerAusgewaelt(spin))
                {
                    //Gibst die Punkte in einer Liste weiter an die Utility,
                    //die dann die Assetpunkte brechnet und sie als statische Variablen in die Klasse Schreibt
                    saveSpinner();
                    if(utility.month<30)
                    {
                        utility.Modul_6_1830();
                    }
                    if(utility.month>=30 && utility.month<36)
                    {
                        utility.Modul_6_3036();
                    }
                    if(utility.month>=36 && utility.month<60)
                    {
                        utility.Modul_6_3660();
                    }
                    if(utility.month>=60 && utility.month<84)
                    {
                        utility.Modul_6_6084();
                    }
                    if(utility.month>=84 && utility.month<132)
                    {
                        utility.Modul_6_84132();
                    }
                    if(utility.month>=132)
                    {
                        utility.Modul_6_132();
                    }
                    showAlert(view);

                } else
                {
                    Toast.makeText(getApplicationContext(), "Bitte füllen sie alles aus", Toast.LENGTH_LONG).show();
                }
            }
        });
        if(utility.age>=18)
        {
            //Angezeigte infotexte
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext600), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext601), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext602), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext603), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext604), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext605), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext606), con);
                }
            });
        }
        else
        {
            //Angezeigte infotexte
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext600k), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext601k), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext602k), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext603k), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext604k), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext605k), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext606k), con);
                }
            });
        }
    }
    public void onBackPressed() {
        super.onBackPressed();
        saveSpinner();
    }
    public void saveSpinner()
    {
        Save.m601 = spin1.getSelectedItemPosition();
        Save.m602 = spin2.getSelectedItemPosition();
        Save.m603 = spin3.getSelectedItemPosition();
        Save.m604 = spin4.getSelectedItemPosition();
        Save.m605 = spin5.getSelectedItemPosition();
        Save.m606 = spin6.getSelectedItemPosition();
    }

    public void setUp(Spinner sp,int sptxt)
    {
        sp.setAdapter(ArrayAdapter.createFromResource(this, com.KM.boxnif.dia.R.array.selbststaendig_array, com.KM.boxnif.dia.R.layout.spinner_item));
        spin.add(sp);
        sp.setSelection(sptxt);
    }

    //Fenster was vorm Weitergang zu einer Neuen aktivität auftaucht
    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(com.KM.boxnif.dia.R.string.gassm6) + Utility.gib6()));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                Intent i = new Intent(getApplicationContext(), Modul_Auswertung.class);
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