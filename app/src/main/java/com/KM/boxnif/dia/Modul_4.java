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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.LinkedList;

public class Modul_4 extends AppCompatActivity
{


    Button btn1, ibtn0, ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6, ibtn7, ibtn8, ibtn9, ibtn10, ibtn11, ibtn12, ibtn13,ibtn14;
    DisplayMetrics dm;
    Utility utility;
    LinkedList<Spinner> spin123,spin369,spin246,spin63;
    Context con;
    RelativeLayout rLayout;
    Spinner spin1, spin2, spin3, spin4, spin5, spin6, spin7, spin8, spin9, spin10, spin11, spin12, spin13, spin14;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_4);
        btn1 = (Button) findViewById(R.id.modul_4_button);
        ibtn0 = (Button) findViewById(R.id.ibtn);
        ibtn1 = (Button) findViewById(R.id.ibtn1);
        ibtn2 = (Button) findViewById(R.id.ibtn2);
        ibtn3 = (Button) findViewById(R.id.ibtn3);
        ibtn4 = (Button) findViewById(R.id.ibtn4);
        ibtn5 = (Button) findViewById(R.id.ibtn5);
        ibtn6 = (Button) findViewById(R.id.ibtn6);
        ibtn7 = (Button) findViewById(R.id.ibtn7);
        ibtn8 = (Button) findViewById(R.id.ibtn8);
        ibtn9 = (Button) findViewById(R.id.ibtn9);
        ibtn10 = (Button) findViewById(R.id.ibtn10);
        ibtn11 = (Button) findViewById(R.id.ibtn11);
        ibtn12 = (Button) findViewById(R.id.ibtn12);
        ibtn13 = (Button) findViewById(R.id.ibtn13);
        ibtn14 = (Button) findViewById(R.id.ibtn14);
        rLayout= (RelativeLayout) findViewById(R.id.rLayout);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        utility = new Utility();
        con = getApplicationContext();
        spin123 = new LinkedList<>();
        spin369 = new LinkedList<>();
        spin246 = new LinkedList<>();
        spin63 = new LinkedList<>();


        spin1 = (Spinner)(findViewById(R.id.spinner1));
        setUp(spin1, Save.m401, spin123);
        spin2 = (Spinner)(findViewById(R.id.spinner2));
        setUp(spin2, Save.m402, spin123);
        spin3 = (Spinner)(findViewById(R.id.spinner3));
        setUp(spin3, Save.m403, spin123);
        spin4 = (Spinner)(findViewById(R.id.spinner4));
        setUp(spin4, Save.m404, spin123);
        spin5 = (Spinner)(findViewById(R.id.spinner5));
        setUp(spin5, Save.m405, spin123);
        spin6 = (Spinner)(findViewById(R.id.spinner6));
        setUp(spin6, Save.m406, spin123);
        spin7 = (Spinner)(findViewById(R.id.spinner7));
        setUp(spin7, Save.m407, spin123);
        spin8 = (Spinner)(findViewById(R.id.spinner8));
        setUp(spin8, Save.m408, spin369);
        spin9 = (Spinner)(findViewById(R.id.spinner9));
        setUp(spin9, Save.m409, spin246);
        spin10 = (Spinner)(findViewById(R.id.spinner10));
        setUp(spin10, Save.m410, spin246);
        spin11 = (Spinner)(findViewById(R.id.spinner11));
        setUp(spin11, Save.m411, spin123);
        spin12 = (Spinner)(findViewById(R.id.spinner12));
        setUp(spin12, Save.m412, spin123);
        spin13 = (Spinner)(findViewById(R.id.spinner13));
        setUp(spin13, Save.m413, spin63);

        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (utility.SpinnerAusgewaelt(spin123)&&utility.SpinnerAusgewaelt(spin369)&&utility.SpinnerAusgewaelt(spin246)&&utility.SpinnerAusgewaelt(spin63))
                {
                    //Gibst die Punkte in einer Liste weiter an die Utility,
                    //die dann die Assetpunkte brechnet und sie als statische Variablen in die Klasse Schreibt
                    //utility.mod_4(spin123,spin369,spin246,spin63);
                    saveSpinner();
                    if(utility.month<20)
                    {
                        utility.Modul_4_1820();
                    }
                    if(utility.month>=20 && utility.month<24)
                    {
                    utility.Modul_4_2024();
                    }
                    if(utility.month>=24 && utility.month<30)
                    {
                        utility.Modul_4_2430();
                    }
                    if(utility.month>=30 && utility.month<42)
                    {
                        utility.Modul_4_3042();
                    }
                    if(utility.month>=42 && utility.month<48)
                    {
                        utility.Modul_4_4248();
                    }
                    if(utility.month>=48 && utility.month<60)
                    {
                        utility.Modul_4_4860();
                    }
                    if(utility.month>=60 && utility.month<66)
                    {
                        utility.Modul_4_6066();
                    }
                    if(utility.month>=66 && utility.month<72)
                    {
                        utility.Modul_4_6672();
                    }
                    if(utility.month>=72 && utility.month<96)
                    {
                        utility.Modul_4_7296();
                    }
                    if(utility.month>=96)
                    {
                        utility.Modul_4_96();
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
                    utility.infoPopup(getString(R.string.infotext400), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext401), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext402), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext403), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext404), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext405), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext406), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext407), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext408), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext409), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext410), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext411), con);
                }
            });
            ibtn12.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext412), con);
                }
            });
            ibtn13.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext413), con);
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
                    utility.infoPopup(getString(R.string.infotext400k), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext401k), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext402k), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext403k), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext404k), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext405k), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext406k), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext407k), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext408k), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext409k), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext410k), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext411k), con);
                }
            });
            ibtn12.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext412k), con);
                }
            });
            ibtn13.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext413k), con);
                }
            });
        }
    }

    public void setUp(Spinner sp,int sptxt, LinkedList<Spinner> spin)
    {
        sp.setAdapter(ArrayAdapter.createFromResource(this, R.array.haufigkeiten_array, R.layout.spinner_item));
        spin.add(sp);
        sp.setSelection(sptxt);
    }
    public void onBackPressed() {
        super.onBackPressed();
        saveSpinner();
    }
    private  void saveSpinner()
    {
        Save.m401 = spin1.getSelectedItemPosition();
        Save.m402 = spin2.getSelectedItemPosition();
        Save.m403 = spin3.getSelectedItemPosition();
        Save.m404 = spin4.getSelectedItemPosition();
        Save.m405 = spin5.getSelectedItemPosition();
        Save.m406 = spin6.getSelectedItemPosition();
        Save.m407 = spin7.getSelectedItemPosition();
        Save.m408 = spin8.getSelectedItemPosition();
        Save.m409 = spin9.getSelectedItemPosition();
        Save.m410 = spin10.getSelectedItemPosition();
        Save.m411 = spin11.getSelectedItemPosition();
        Save.m412 = spin12.getSelectedItemPosition();
        Save.m413 = spin13.getSelectedItemPosition();
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

    private boolean kfrage()
    {
        if(utility.age<3&& ((Spinner)findViewById(R.id.spinner14)).getSelectedItem().toString().equals("Bitte auswählen"))
        {
            return false;
        }
        return true;
    }

}