package com.KM.boxnif.dia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Modul_Auswertung extends AppCompatActivity
{
    TextView tv1,tv2,tv3,tv4,tv5,tv6,vorName,nachName,alter,gebDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul__auswertung);
        tv1 = (TextView) findViewById(R.id.endauswertung_01);
        tv1.setText(tv1.getText().toString() +" "+ Utility.gib1());
        tv2 = (TextView) findViewById(R.id.endauswertung_02);
        tv2.setText(tv2.getText().toString() +" "+ Utility.gib2());
        tv3 = (TextView) findViewById(R.id.endauswertung_03);
        tv3.setText(tv3.getText().toString() +" "+ Utility.gib3());
        tv4 = (TextView) findViewById(R.id.endauswertung_04);
        tv4.setText(tv4.getText().toString() +" "+ Utility.gib4());
        tv5 = (TextView) findViewById(R.id.endauswertung_05);
        tv5.setText(tv5.getText().toString() +" "+ Utility.gib5());
        tv6 = (TextView) findViewById(R.id.endauswertung_06);
        tv6.setText(tv6.getText().toString() +" "+ Utility.gib6());

        vorName = (TextView) findViewById(R.id.vName);
        vorName.setText(Utility.vor);
        nachName = (TextView) findViewById(R.id.nName);
        nachName.setText(Utility.nach);
        alter = (TextView) findViewById(R.id.alter);
        alter.setText(Utility.alter);
        gebDatum = (TextView) findViewById(R.id.gDatum);
        gebDatum.setText(Utility.gebT+"."+Utility.gebM+"."+Utility.gebY);
    }
}
