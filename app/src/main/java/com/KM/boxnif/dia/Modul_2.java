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

public class Modul_2 extends AppCompatActivity
{
    Button btn1, ibtn0, ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6, ibtn7, ibtn8, ibtn9, ibtn10, ibtn11;
    DisplayMetrics dm;
    Utility utility;
    LinkedList<Spinner> spin;
    Spinner spin1, spin2, spin3, spin4, spin5, spin6, spin7, spin8, spin9, spin10, spin11;
    Context con;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_2);
        btn1 = (Button) findViewById(R.id.modul_2_button);
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

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        utility = new Utility();
        con = getApplicationContext();
        spin = new LinkedList<>();

        spin1 = (Spinner)(findViewById(R.id.spinner1));
        setUp(spin1,Save.m201);
        spin2 = (Spinner)(findViewById(R.id.spinner2));
        setUp(spin2,Save.m202);
        spin3 = (Spinner)(findViewById(R.id.spinner3));
        setUp(spin3,Save.m203);
        spin4 = (Spinner)(findViewById(R.id.spinner4));
        setUp(spin4,Save.m204);
        spin5 = (Spinner)(findViewById(R.id.spinner5));
        setUp(spin5,Save.m205);
        spin6 = (Spinner)(findViewById(R.id.spinner6));
        setUp(spin6,Save.m206);
        spin7 = (Spinner)(findViewById(R.id.spinner7));
        setUp(spin7,Save.m207);
        spin8 = (Spinner)(findViewById(R.id.spinner8));
        setUp(spin8,Save.m208);
        spin9 = (Spinner)(findViewById(R.id.spinner9));
        setUp(spin9,Save.m209);
        spin10 = (Spinner)(findViewById(R.id.spinner10));
        setUp(spin10,Save.m210);
        spin11 = (Spinner)(findViewById(R.id.spinner11));
        setUp(spin11,Save.m211);


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
                    if(utility.month<24)
                    {
                        utility.Modul_2_24();
                    }
                    if(utility.month>=24 && utility.month<30)
                    {
                        utility.Modul_2_2430();
                    }
                    if(utility.month>=30 && utility.month<36)
                    {
                        utility.Modul_2_3036();
                    }
                    if(utility.month>=36 && utility.month<48)
                    {
                        utility.Modul_2_3648();
                    }
                    if(utility.month>=48 && utility.month<54)
                    {
                        utility.Modul_2_4854();
                    }
                    if(utility.month>=54 && utility.month<60)
                    {
                        utility.Modul_2_5460();
                    }
                    if(utility.month>=60 && utility.month<66)
                    {
                        utility.Modul_2_6066();
                    }
                    if(utility.month>=66 && utility.month<72)
                    {
                        utility.Modul_2_6672();
                    }
                    if(utility.month>=72 && utility.month<78)
                    {
                        utility.Modul_2_7278();
                    }
                    if(utility.month>=78 && utility.month<84)
                    {
                        utility.Modul_2_7884();
                    }
                    if(utility.month>=84 && utility.month<120)
                    {
                        utility.Modul_2_84120();
                    }
                    if(utility.month>=120)
                    {
                        utility.Modul_2_120();
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
                    utility.infoPopup(getString(R.string.infotext200), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext201), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext202), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext203), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext204), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext205), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext206), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext207), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext208), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext209), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext210), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext211), con);
            }
            });
        }
        else
        {
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext200k), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext201k), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext202k), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext203k), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext204k), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext205k), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext206k), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext207k), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext208k), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext209k), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext210k), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext211k), con);
                }
            });
        }
    }

    private  void saveSpinner()
    {
        Save.m201 = spin1.getSelectedItemPosition();
        Save.m202 = spin2.getSelectedItemPosition();
        Save.m203 = spin3.getSelectedItemPosition();
        Save.m204 = spin4.getSelectedItemPosition();
        Save.m205 = spin5.getSelectedItemPosition();
        Save.m206 = spin6.getSelectedItemPosition();
        Save.m207 = spin7.getSelectedItemPosition();
        Save.m208 = spin8.getSelectedItemPosition();
        Save.m209 = spin9.getSelectedItemPosition();
        Save.m210 = spin10.getSelectedItemPosition();
        Save.m211 = spin11.getSelectedItemPosition();
    }
    public void setUp(Spinner sp,int sptxt)
    {
        sp.setAdapter(ArrayAdapter.createFromResource(this, R.array.faehigkeiten_array, R.layout.spinner_item));
        spin.add(sp);
        sp.setSelection(sptxt);
    }
    public void onBackPressed() {
        super.onBackPressed();
        saveSpinner();
    }


    //Fenster was vorm Weitergang zu einer Neuen aktivität auftaucht
    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.gassm2) + Utility.gib2()+getString(R.string.ergebnis2)));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                Intent i = new Intent(getApplicationContext(), Modul_3.class);
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