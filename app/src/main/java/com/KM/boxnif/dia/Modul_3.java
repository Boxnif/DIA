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

public class Modul_3 extends AppCompatActivity
{
    Button btn1, ibtn0, ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6, ibtn7, ibtn8, ibtn9, ibtn10, ibtn11, ibtn12, ibtn13;
    DisplayMetrics dm;
    Utility utility;
    LinkedList<Spinner> spin;
    Context con;
    Spinner spin1, spin2, spin3, spin4, spin5, spin6, spin7, spin8, spin9, spin10, spin11, spin12, spin13;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_3);
        btn1 = (Button) findViewById(R.id.modul_3_button);
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

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        utility = new Utility();
        con = getApplicationContext();
        spin = new LinkedList<>();

        spin1 = (Spinner)(findViewById(R.id.spinner1));
        setUp(spin1, Save.m301);
        spin2 = (Spinner)(findViewById(R.id.spinner2));
        setUp(spin2, Save.m302);
        spin3 = (Spinner)(findViewById(R.id.spinner3));
        setUp(spin3, Save.m303);
        spin4 = (Spinner)(findViewById(R.id.spinner4));
        setUp(spin4, Save.m304);
        spin5 = (Spinner)(findViewById(R.id.spinner5));
        setUp(spin5, Save.m305);
        spin6 = (Spinner)(findViewById(R.id.spinner6));
        setUp(spin6, Save.m306);
        spin7 = (Spinner)(findViewById(R.id.spinner7));
        setUp(spin7, Save.m307);
        spin8 = (Spinner)(findViewById(R.id.spinner8));
        setUp(spin8, Save.m308);
        spin9 = (Spinner)(findViewById(R.id.spinner9));
        setUp(spin9, Save.m309);
        spin10 = (Spinner)(findViewById(R.id.spinner10));
        setUp(spin10, Save.m310);
        spin11 = (Spinner)(findViewById(R.id.spinner11));
        setUp(spin11, Save.m311);
        spin12 = (Spinner)(findViewById(R.id.spinner12));
        setUp(spin12, Save.m312);
        spin13 = (Spinner)(findViewById(R.id.spinner13));
        setUp(spin13, Save.m313);


        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (utility.SpinnerAusgewaelt(spin))
                {
                    //Gibst die Punkte in einer Liste weiter an die Utility,
                    //die dann die Assetpunkte brechnet und sie als statische Variablen in die Klasse Schreibt
                    utility.mod_3(spin);
                    showAlert(view);

                } else
                {
                    Toast.makeText(getApplicationContext(), "Bitte füllen sie alles aus", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Angezeigte infotexte
        if(utility.age>=18)
        {
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext300), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext301), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext302), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext303), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext304), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext305), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext306), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext307), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext308), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext309), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext310), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext311), con);
                }
            });
            ibtn12.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext312), con);
                }
            });
            ibtn13.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext313), con);
                }
            });
        }else
        {
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext300k), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext301k), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext302k), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext303k), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext304k), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext305k), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext306k), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext307k), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext308k), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext309k), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext310k), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext311k), con);
                }
            });
            ibtn12.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext312k), con);
                }
            });
            ibtn13.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext313k), con);
                }
            });
        }
    }

    public void setUp(Spinner sp,int sptxt)
    {
        sp.setAdapter(ArrayAdapter.createFromResource(this, R.array.haufigkeiten_array, R.layout.spinner_item));
        spin.add(sp);
        sp.setSelection(sptxt);
    }
    public void onBackPressed() {
        super.onBackPressed();
        Save.m301 = spin1.getSelectedItemPosition();
        Save.m302 = spin2.getSelectedItemPosition();
        Save.m303 = spin3.getSelectedItemPosition();
        Save.m304 = spin4.getSelectedItemPosition();
        Save.m305 = spin5.getSelectedItemPosition();
        Save.m306 = spin6.getSelectedItemPosition();
        Save.m307 = spin7.getSelectedItemPosition();
        Save.m308 = spin8.getSelectedItemPosition();
        Save.m309 = spin9.getSelectedItemPosition();
        Save.m310 = spin10.getSelectedItemPosition();
        Save.m311 = spin11.getSelectedItemPosition();
        Save.m312 = spin12.getSelectedItemPosition();
        Save.m313 = spin13.getSelectedItemPosition();
    }
    //Fenster was vorm Weitergang zu einer Neuen aktivität auftaucht
    private void showAlert(View view)
    {
        String s = "";
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        if(utility.month>=19)
        {
            if(utility.modul_2_assPkt>utility.modul_3_assPkt)
            {
                s = getString(R.string.mod2groesser);
            }else if((utility.modul_2_assPkt<utility.modul_3_assPkt))
            {
                s = getString(R.string.mod3groesser);
            }
            else
            {
                s = getString(R.string.mod23gleich);
            }
        }
        alert.setMessage(Html.fromHtml(getString(R.string.gassm3) + Utility.gib3()+s));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                dialog.dismiss();
                if(utility.month>=19)
                {
                    Intent i = new Intent(getApplicationContext(), Modul_4.class);
                    startActivity(i);
                }else
                {
                    Intent i = new Intent(getApplicationContext(), Modul_4k.class);
                    startActivity(i);
                }
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