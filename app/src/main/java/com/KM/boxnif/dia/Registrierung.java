package com.KM.boxnif.dia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Registrierung extends AppCompatActivity
{
    Spinner spin;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung);
        tv = (TextView) findViewById(R.id.textView1);
        spin = (Spinner) findViewById(R.id.spinner);
        spin.setAdapter(ArrayAdapter.createFromResource(this, R.array.postitions_array, R.layout.spinner_item));
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position==0)
                {
                    tv.setText("Firmenname");
                }
                if(position==1)
                {
                    tv.setText("Vor-Nachname");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
        {
           @Override
            public void onClick(View view)
            {
                finish();
            }
        });

    }
}
