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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class Modul_5 extends AppCompatActivity
{
    Button btn1, ibtn0, ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6, ibtn7, ibtn8, ibtn9, ibtn10, ibtn11, ibtn12, ibtn13, ibtn14, ibtn15, ibtn16, ibtn17;
    Spinner spin1, spin2, spin3, spin4, spin5, spin6, spin7, spin8, spin9, spin10, spin11, spin12, spin13, spin14, spin15, spin16, spin17;
    DisplayMetrics dm;
    Utility utility;
    LinkedList<Spinner> spin;
    LinkedList<EditText> edit;
    Context con;
    EditText edit101,edit201,edit301,edit102,edit202,edit302,edit103,edit203,edit303,edit104,edit204,edit304,edit105,edit205,edit305,edit106,edit206,edit306,edit107,edit207,edit307,edit108,edit208,edit308,edit109,edit209,edit309,edit110,edit210,edit310,edit111,edit211,edit311,edit112,edit212,edit312,edit113,edit213,edit114,edit214,edit115,edit215,edit1k,edit2k;
    LinkedList<EditText> mod51t,mod51w,mod51m,mod52t,mod52w,mod52m,mod54w,mod54m;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_5);


        btn1 = (Button) findViewById(R.id.modul_5_button);
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
        ibtn15 = (Button) findViewById(R.id.ibtn15);
        ibtn16 = (Button) findViewById(R.id.ibtn16);
        ibtn17 = (Button) findViewById(R.id.ibtn17);

        edit101 = (EditText) findViewById(R.id.editText101);

        setUp(edit101, Save.me101);
        edit201 = (EditText) findViewById(R.id.editText201);
        setUp(edit201, Save.me201);
        edit301 = (EditText) findViewById(R.id.editText301);
        setUp(edit301, Save.me301);
        edit102 = (EditText) findViewById(R.id.editText102);
        setUp(edit102, Save.me102);
        edit202 = (EditText) findViewById(R.id.editText202);
        setUp(edit202, Save.me202);
        edit302 = (EditText) findViewById(R.id.editText302);
        setUp(edit302, Save.me302);
        edit103 = (EditText) findViewById(R.id.editText103);
        setUp(edit103, Save.me103);
        edit203 = (EditText) findViewById(R.id.editText203);
        setUp(edit203, Save.me203);
        edit303 = (EditText) findViewById(R.id.editText303);
        setUp(edit303, Save.me303);
        edit104 = (EditText) findViewById(R.id.editText104);
        setUp(edit104, Save.me104);
        edit204 = (EditText) findViewById(R.id.editText204);
        setUp(edit204, Save.me204);
        edit304 = (EditText) findViewById(R.id.editText304);
        setUp(edit304, Save.me304);
        edit105 = (EditText) findViewById(R.id.editText105);
        setUp(edit105, Save.me105);
        edit205 = (EditText) findViewById(R.id.editText205);
        setUp(edit205, Save.me205);
        edit305 = (EditText) findViewById(R.id.editText305);
        setUp(edit305, Save.me305);
        edit106 = (EditText) findViewById(R.id.editText106);
        setUp(edit106, Save.me106);
        edit206 = (EditText) findViewById(R.id.editText206);
        setUp(edit206, Save.me206);
        edit306 = (EditText) findViewById(R.id.editText306);
        setUp(edit306, Save.me306);
        edit107 = (EditText) findViewById(R.id.editText107);
        setUp(edit107, Save.me107);
        edit207 = (EditText) findViewById(R.id.editText207);
        setUp(edit207, Save.me207);
        edit307 = (EditText) findViewById(R.id.editText307);
        setUp(edit307, Save.me307);
        edit108 = (EditText) findViewById(R.id.editText108);
        setUp(edit108, Save.me108);
        edit208 = (EditText) findViewById(R.id.editText208);
        setUp(edit208, Save.me208);
        edit308 = (EditText) findViewById(R.id.editText308);
        setUp(edit308, Save.me308);
        edit109 = (EditText) findViewById(R.id.editText109);
        setUp(edit109, Save.me109);
        edit209 = (EditText) findViewById(R.id.editText209);
        setUp(edit209, Save.me209);
        edit309 = (EditText) findViewById(R.id.editText309);
        setUp(edit309, Save.me309);
        edit110 = (EditText) findViewById(R.id.editText110);
        setUp(edit110, Save.me110);
        edit210 = (EditText) findViewById(R.id.editText210);
        setUp(edit210, Save.me210);
        edit310 = (EditText) findViewById(R.id.editText310);
        setUp(edit310, Save.me310);
        edit111 = (EditText) findViewById(R.id.editText111);
        setUp(edit111, Save.me111);
        edit211 = (EditText) findViewById(R.id.editText211);
        setUp(edit211, Save.me211);
        edit311 = (EditText) findViewById(R.id.editText311);
        setUp(edit311, Save.me311);
        edit112 = (EditText) findViewById(R.id.editText112);
        setUp(edit112, Save.me112);
        edit212 = (EditText) findViewById(R.id.editText212);
        setUp(edit212, Save.me212);
        edit312 = (EditText) findViewById(R.id.editText312);
        setUp(edit312, Save.me312);
        edit113 = (EditText) findViewById(R.id.editText113);
        setUp(edit113, Save.me113);
        edit213 = (EditText) findViewById(R.id.editText213);
        setUp(edit213, Save.me213);
        edit114 = (EditText) findViewById(R.id.editText114);
        setUp(edit114, Save.me114);
        edit214 = (EditText) findViewById(R.id.editText214);
        setUp(edit214, Save.me214);
        edit115 = (EditText) findViewById(R.id.editText115);
        setUp(edit115, Save.me115);
        edit215 = (EditText) findViewById(R.id.editText215);
        setUp(edit215, Save.me215);
        edit1k = (EditText) findViewById(R.id.editText1k);
        setUp(edit1k, Save.me1k);
        edit2k = (EditText) findViewById(R.id.editText2k);
        setUp(edit2k, Save.me2k);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        utility = new Utility();
        con = getApplicationContext();
        spin = new LinkedList<>();
        mod51t = new LinkedList<>();
        mod51w = new LinkedList<>();
        mod51m = new LinkedList<>();
        mod52t = new LinkedList<>();
        mod52w = new LinkedList<>();
        mod52m = new LinkedList<>();
        mod54w = new LinkedList<>();
        mod54m = new LinkedList<>();

        spin1 = (Spinner)(findViewById(R.id.spinner1));
        setUp(spin1, Save.m501);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin1.getSelectedItem().toString().equals("entfällt oder selbständig")||spin1.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit101.setEnabled(false);
                    edit101.setText("");
                    edit201.setEnabled(false);
                    edit201.setText("");
                    edit301.setEnabled(false);
                    edit301.setText("");
                }else{
                    edit101.setEnabled(true);
                    edit201.setEnabled(true);
                    edit301.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin2= (Spinner) findViewById(R.id.spinner2);
        setUp(spin2, Save.m502);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin2.getSelectedItem().toString().equals("entfällt oder selbständig")||spin2.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit102.setEnabled(false);
                    edit102.setText("");
                    edit202.setEnabled(false);
                    edit202.setText("");
                    edit302.setEnabled(false);
                    edit302.setText("");
                }else{
                    edit102.setEnabled(true);
                    edit202.setEnabled(true);
                    edit302.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin3= (Spinner) findViewById(R.id.spinner3);
        setUp(spin3, Save.m503);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin3.getSelectedItem().toString().equals("entfällt oder selbständig")||spin3.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit103.setEnabled(false);
                    edit103.setText("");
                    edit203.setEnabled(false);
                    edit203.setText("");
                    edit303.setEnabled(false);
                    edit303.setText("");
                }else{
                    edit103.setEnabled(true);
                    edit203.setEnabled(true);
                    edit303.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin4= (Spinner) findViewById(R.id.spinner4);
        setUp(spin4, Save.m504);
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin4.getSelectedItem().toString().equals("entfällt oder selbständig")||spin4.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit104.setEnabled(false);
                    edit104.setText("");
                    edit204.setEnabled(false);
                    edit204.setText("");
                    edit304.setEnabled(false);
                    edit304.setText("");
                }else{
                    edit104.setEnabled(true);
                    edit204.setEnabled(true);
                    edit304.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin5= (Spinner) findViewById(R.id.spinner5);
        setUp(spin5, Save.m505);
        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin5.getSelectedItem().toString().equals("entfällt oder selbständig")||spin5.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit105.setEnabled(false);
                    edit105.setText("");
                    edit205.setEnabled(false);
                    edit205.setText("");
                    edit305.setEnabled(false);
                    edit305.setText("");
                }else{
                    edit105.setEnabled(true);
                    edit205.setEnabled(true);
                    edit305.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin6= (Spinner) findViewById(R.id.spinner6);
        setUp(spin6, Save.m506);
        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin6.getSelectedItem().toString().equals("entfällt oder selbständig")||spin6.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit106.setEnabled(false);
                    edit106.setText("");
                    edit206.setEnabled(false);
                    edit206.setText("");
                    edit306.setEnabled(false);
                    edit306.setText("");
                }else{
                    edit106.setEnabled(true);
                    edit206.setEnabled(true);
                    edit306.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin7= (Spinner) findViewById(R.id.spinner7);
        setUp(spin7, Save.m507);
        spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin7.getSelectedItem().toString().equals("entfällt oder selbständig")||spin7.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit107.setEnabled(false);
                    edit107.setText("");
                    edit207.setEnabled(false);
                    edit207.setText("");
                    edit307.setEnabled(false);
                    edit307.setText("");
                }else{
                    edit107.setEnabled(true);
                    edit207.setEnabled(true);
                    edit307.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin8= (Spinner) findViewById(R.id.spinner8);
        setUp(spin8, Save.m508);
        spin8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin8.getSelectedItem().toString().equals("entfällt oder selbständig")||spin8.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit108.setEnabled(false);
                    edit108.setText("");
                    edit208.setEnabled(false);
                    edit208.setText("");
                    edit308.setEnabled(false);
                    edit308.setText("");
                }else{
                    edit108.setEnabled(true);
                    edit208.setEnabled(true);
                    edit308.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin9= (Spinner) findViewById(R.id.spinner9);
        setUp(spin9, Save.m509);
        spin9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin9.getSelectedItem().toString().equals("entfällt oder selbständig")||spin9.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit109.setEnabled(false);
                    edit109.setText("");
                    edit209.setEnabled(false);
                    edit209.setText("");
                    edit309.setEnabled(false);
                    edit309.setText("");
                }else{
                    edit109.setEnabled(true);
                    edit209.setEnabled(true);
                    edit309.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin10= (Spinner) findViewById(R.id.spinner10);
        setUp(spin10, Save.m510);
        spin10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin10.getSelectedItem().toString().equals("entfällt oder selbständig")||spin10.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit110.setEnabled(false);
                    edit110.setText("");
                    edit210.setEnabled(false);
                    edit210.setText("");
                    edit310.setEnabled(false);
                    edit310.setText("");
                }else{
                    edit110.setEnabled(true);
                    edit210.setEnabled(true);
                    edit310.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin11= (Spinner) findViewById(R.id.spinner11);
        setUp(spin11, Save.m511);
        spin11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin11.getSelectedItem().toString().equals("entfällt oder selbständig")||spin11.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit111.setEnabled(false);
                    edit111.setText("");
                    edit211.setEnabled(false);
                    edit211.setText("");
                    edit311.setEnabled(false);
                    edit311.setText("");
                }else{
                    edit111.setEnabled(true);
                    edit211.setEnabled(true);
                    edit311.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin12= (Spinner) findViewById(R.id.spinner12);
        setUp(spin12, Save.m512);
        spin12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin12.getSelectedItem().toString().equals("entfällt oder selbständig")||spin12.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit112.setEnabled(false);
                    edit112.setText("");
                    edit212.setEnabled(false);
                    edit212.setText("");
                    edit312.setEnabled(false);
                    edit312.setText("");
                }else{
                    edit112.setEnabled(true);
                    edit212.setEnabled(true);
                    edit312.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        spin13= (Spinner) findViewById(R.id.spinner13);
        setUp(spin13, Save.m513);
        spin13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin13.getSelectedItem().toString().equals("entfällt oder selbständig")||spin13.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit113.setEnabled(false);
                    edit113.setText("");
                    edit213.setEnabled(false);
                    edit213.setText("");
                }else{
                    edit113.setEnabled(true);
                    edit213.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        spin14 = (Spinner) findViewById(R.id.spinner14);
        setUp(spin14, Save.m514);
        spin14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin14.getSelectedItem().toString().equals("entfällt oder selbständig")||spin14.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit114.setEnabled(false);
                    edit114.setText("");
                    edit214.setEnabled(false);
                    edit214.setText("");
                }else{
                    edit114.setEnabled(true);
                    edit214.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin15 = (Spinner) findViewById(R.id.spinner15);
        setUp(spin15, Save.m515);
        spin15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(spin15.getSelectedItem().toString().equals("entfällt oder selbständig")||spin15.getSelectedItem().toString().equals("Bitte auswählen")){
                    edit115.setEnabled(false);
                    edit115.setText("");
                    edit215.setEnabled(false);
                    edit215.setText("");
                }else{
                    edit115.setEnabled(true);
                    edit215.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spin16 = (Spinner) findViewById(R.id.spinner16);
        spin16.setAdapter(ArrayAdapter.createFromResource(this, R.array.selbststaendig_array, R.layout.spinner_item));
        spin.add(spin16);
        spin16.setSelection(Save.m516);

        if(utility.age<18)
        {
            spin17 = (Spinner) findViewById(R.id.spinner17);
            setUp(spin17, Save.m517);
            spin17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
                {
                    if (spin17.getSelectedItem().toString().equals("entfällt oder selbständig") || spin17.getSelectedItem().toString().equals("Bitte auswählen"))
                    {
                        edit1k.setEnabled(false);
                        edit1k.setText("");
                        edit2k.setEnabled(false);
                        edit2k.setText("");
                    } else
                    {
                        edit1k.setEnabled(true);
                        edit2k.setEnabled(true);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView)
                {
                    // your code here
                }

            });
            mod54w.add(edit1k);
            mod54m.add(edit2k);
        }
        else
        {
            spin17 = (Spinner) findViewById(R.id.spinner17);
            spin17.setVisibility(View.INVISIBLE);
        }
        mod51t.add(edit101);
        mod51t.add(edit102);
        mod51t.add(edit103);
        mod51t.add(edit104);
        mod51t.add(edit105);
        mod51t.add(edit106);
        mod51t.add(edit107);
        mod51w.add(edit201);
        mod51w.add(edit202);
        mod51w.add(edit203);
        mod51w.add(edit204);
        mod51w.add(edit205);
        mod51w.add(edit206);
        mod51w.add(edit207);
        mod51m.add(edit301);
        mod51m.add(edit302);
        mod51m.add(edit303);
        mod51m.add(edit304);
        mod51m.add(edit305);
        mod51m.add(edit306);
        mod51m.add(edit307);

        mod52t.add(edit108);
        mod52t.add(edit109);
        mod52t.add(edit110);
        mod52t.add(edit111);
        mod52w.add(edit208);
        mod52w.add(edit209);
        mod52w.add(edit210);
        mod52w.add(edit211);
        mod52m.add(edit308);
        mod52m.add(edit309);
        mod52m.add(edit310);
        mod52m.add(edit311);

        mod54w.add(edit113);
        mod54w.add(edit114);

        mod54m.add(edit213);
        mod54m.add(edit214);


        TextView tv17 = (TextView) (findViewById(R.id.textView17));
        TextView tv117 = (TextView) (findViewById(R.id.textView117));
        TextView tv217 = (TextView) (findViewById(R.id.textView217));
        View v16 = (View) (findViewById(R.id.view16));
        View v17 = (View) (findViewById(R.id.view17));

        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                if (utility.SpinnerAusgewaelt(spin))
                {
                    //Gibst die Punkte in einer Liste weiter an die Utility,
                    //die dann die Assetpunkte brechnet und sie als statische Variablen in die Klasse Schreibt
                    utility.mod_5(mod51t , mod51w, mod51m, mod52t, mod52w, mod52m, edit112, edit212, edit312, mod54w, mod54m, edit115, edit215, spin16);
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
                    utility.infoPopup(getString(R.string.infotext500), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext501), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext502), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext503), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext504), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext505), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext506), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext507), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext508), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext509), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext510), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext511), con);
                }
            });
            ibtn12.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext512), con);
                }
            });
            ibtn13.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext513), con);
                }
            });
            ibtn14.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext514), con);
                }
            });
            ibtn15.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext515), con);
                }
            });
            ibtn16.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext516), con);
                }
            });
            ibtn17.setVisibility(View.INVISIBLE);

            edit1k.setVisibility(View.INVISIBLE);
            edit2k.setVisibility(View.INVISIBLE);
            tv117.setVisibility(View.INVISIBLE);
            tv217.setVisibility(View.INVISIBLE);
            v16.setVisibility(View.INVISIBLE);
            tv17.setVisibility(View.INVISIBLE);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v17.getLayoutParams();
            params.addRule(RelativeLayout.BELOW ,(R.id.spinner16));
            v17.setLayoutParams(params);
        }
        else
        {
            //Angezeigte infotexte
            ibtn0.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext500k), con);
                }
            });
            ibtn1.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext501k), con);
                }
            });
            ibtn2.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext502k), con);
                }
            });
            ibtn3.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext503k), con);
                }
            });
            ibtn4.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext504k), con);
                }
            });
            ibtn5.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext505k), con);
                }
            });
            ibtn6.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext506k), con);
                }
            });
            ibtn7.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext507k), con);
                }
            });
            ibtn8.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext508k), con);
                }
            });
            ibtn9.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext509k), con);
                }
            });
            ibtn10.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext510k), con);
                }
            });
            ibtn11.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext511k), con);
                }
            });
            ibtn12.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext512k), con);
                }
            });
            ibtn13.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext513k), con);
                }
            });
            ibtn14.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext514k), con);
                }
            });
            ibtn15.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext515k), con);
                }
            });
            ibtn16.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext516k), con);
                }
            });

            tv17.setText(getString(R.string.m5k));

            ibtn17.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {
                    utility.infoPopup(getString(R.string.infotext5k), con);
                }
            });

        }
    }
    public void setUp(Spinner sp,int sptxt)
    {
        sp.setAdapter(ArrayAdapter.createFromResource(this, R.array.entselbststaendig_array, R.layout.spinner_item));
        spin.add(sp);
        sp.setSelection(sptxt);
    }

    public void setUp(EditText ed, Integer i)
    {
        if(i != 0)
        {
            ed.setText(i.toString());
        }
    }
    public void onBackPressed() {
        super.onBackPressed();
        Save.m501 = spin1.getSelectedItemPosition();
        if(!edit101.getText().toString().equals(""))
        {
            Save.me101 = Integer.parseInt(edit101.getText().toString());
        }
        if(!edit201.getText().toString().equals(""))
        {
            Save.me201 = Integer.parseInt(edit201.getText().toString());
        }
        if(!edit301.getText().toString().equals(""))
        {
            Save.me301 = Integer.parseInt(edit301.getText().toString());
        }
        Save.m502 = spin2.getSelectedItemPosition();
        if(!edit102.getText().toString().equals(""))
        {
            Save.me102 = Integer.parseInt(edit102.getText().toString());
        }
        if(!edit202.getText().toString().equals(""))
        {
            Save.me202 = Integer.parseInt(edit202.getText().toString());
        }
        if(!edit302.getText().toString().equals(""))
        {
            Save.me302 = Integer.parseInt(edit302.getText().toString());
        }
        Save.m503 = spin3.getSelectedItemPosition();
        if(!edit103.getText().toString().equals(""))
        {
            Save.me103 = Integer.parseInt(edit103.getText().toString());
        }
        if(!edit203.getText().toString().equals(""))
        {
            Save.me203 = Integer.parseInt(edit203.getText().toString());
        }
        if(!edit303.getText().toString().equals(""))
        {
            Save.me303 = Integer.parseInt(edit303.getText().toString());
        }
        Save.m504 = spin4.getSelectedItemPosition();
        if(!edit104.getText().toString().equals(""))
        {
            Save.me104 = Integer.parseInt(edit104.getText().toString());
        }
        if(!edit204.getText().toString().equals(""))
        {
            Save.me204 = Integer.parseInt(edit204.getText().toString());
        }
        if(!edit304.getText().toString().equals(""))
        {
            Save.me304 = Integer.parseInt(edit304.getText().toString());
        }
        Save.m505 = spin5.getSelectedItemPosition();
        if(!edit105.getText().toString().equals(""))
        {
            Save.me105 = Integer.parseInt(edit105.getText().toString());
        }
        if(!edit205.getText().toString().equals(""))
        {
            Save.me205 = Integer.parseInt(edit205.getText().toString());
        }
        if(!edit301.getText().toString().equals(""))
        {
            Save.me305 = Integer.parseInt(edit305.getText().toString());
        }
        Save.m506 = spin6.getSelectedItemPosition();
        if(!edit106.getText().toString().equals(""))
        {
            Save.me106 = Integer.parseInt(edit106.getText().toString());
        }
        if(!edit206.getText().toString().equals(""))
        {
            Save.me206 = Integer.parseInt(edit206.getText().toString());
        }
        if(!edit306.getText().toString().equals(""))
        {
            Save.me306 = Integer.parseInt(edit306.getText().toString());
        }
        Save.m507 = spin7.getSelectedItemPosition();
        if(!edit107.getText().toString().equals(""))
        {
            Save.me107 = Integer.parseInt(edit107.getText().toString());
        }
        if(!edit207.getText().toString().equals(""))
        {
            Save.me207 = Integer.parseInt(edit207.getText().toString());
        }
        if(!edit301.getText().toString().equals(""))
        {
            Save.me307 = Integer.parseInt(edit307.getText().toString());
        }
        Save.m508 = spin8.getSelectedItemPosition();
        if(!edit108.getText().toString().equals(""))
        {
            Save.me108 = Integer.parseInt(edit108.getText().toString());
        }
        if(!edit208.getText().toString().equals(""))
        {
            Save.me208 = Integer.parseInt(edit208.getText().toString());
        }
        if(!edit308.getText().toString().equals(""))
        {
            Save.me308 = Integer.parseInt(edit308.getText().toString());
        }
        Save.m509 = spin9.getSelectedItemPosition();
        if(!edit109.getText().toString().equals(""))
        {
            Save.me109 = Integer.parseInt(edit109.getText().toString());
        }
        if(!edit209.getText().toString().equals(""))
        {
            Save.me209 = Integer.parseInt(edit209.getText().toString());
        }
        if(!edit309.getText().toString().equals(""))
        {
            Save.me309 = Integer.parseInt(edit309.getText().toString());
        }
        Save.m510 = spin10.getSelectedItemPosition();
        if(!edit110.getText().toString().equals(""))
        {
            Save.me110 = Integer.parseInt(edit110.getText().toString());
        }
        if(!edit210.getText().toString().equals(""))
        {
            Save.me210 = Integer.parseInt(edit210.getText().toString());
        }
        if(!edit310.getText().toString().equals(""))
        {
            Save.me310 = Integer.parseInt(edit310.getText().toString());
        }
        Save.m511 = spin11.getSelectedItemPosition();
        if(!edit111.getText().toString().equals(""))
        {
            Save.me111 = Integer.parseInt(edit111.getText().toString());
        }
        if(!edit211.getText().toString().equals(""))
        {
            Save.me211 = Integer.parseInt(edit211.getText().toString());
        }
        if(!edit311.getText().toString().equals(""))
        {
            Save.me311 = Integer.parseInt(edit311.getText().toString());
        }
        Save.m512 = spin12.getSelectedItemPosition();
        if(!edit112.getText().toString().equals(""))
        {
            Save.me112 = Integer.parseInt(edit112.getText().toString());
        }
        if(!edit212.getText().toString().equals(""))
        {
            Save.me212 = Integer.parseInt(edit212.getText().toString());
        }
        if(!edit312.getText().toString().equals(""))
        {
            Save.me312 = Integer.parseInt(edit312.getText().toString());
        }
        Save.m513 = spin13.getSelectedItemPosition();
        if(!edit113.getText().toString().equals(""))
        {
            Save.me113 = Integer.parseInt(edit113.getText().toString());
        }
        if(!edit213.getText().toString().equals(""))
        {
            Save.me213 = Integer.parseInt(edit213.getText().toString());
        }
        Save.m514 = spin14.getSelectedItemPosition();
        if(!edit114.getText().toString().equals(""))
        {
            Save.me114 = Integer.parseInt(edit114.getText().toString());
        }
        if(!edit214.getText().toString().equals(""))
        {
            Save.me214 = Integer.parseInt(edit214.getText().toString());
        }
        Save.m515 = spin15.getSelectedItemPosition();
        if(!edit115.getText().toString().equals(""))
        {
            Save.me115 = Integer.parseInt(edit115.getText().toString());
        }
        if(!edit215.getText().toString().equals(""))
        {
            Save.me215 = Integer.parseInt(edit215.getText().toString());
        }
        Save.m516 = spin16.getSelectedItemPosition();
        if(!edit1k.getText().toString().equals(""))
        {
            Save.me1k = Integer.parseInt(edit1k.getText().toString());
        }
        if(!edit2k.getText().toString().equals(""))
        {
            Save.me2k = Integer.parseInt(edit2k.getText().toString());
        }
        Save.m517 = spin17.getSelectedItemPosition();
    }
    //Fenster was vorm Weitergang zu einer Neuen aktivität auftaucht
    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.gassm5) + Utility.gib5()));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                if(utility.month<19)
                {
                    utility.modul_6_assPkt=0;
                    Intent i = new Intent(getApplicationContext(), Modul_Auswertung.class);
                    startActivity(i);
                }else
                {
                    Intent i = new Intent(getApplicationContext(), Modul_6.class);
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
    private void saveEdit(int i, EditText ed)
    {
        if(!ed.getText().toString().equals(""))
        {
            i = Integer.parseInt(ed.getText().toString());
        }
    }


}
