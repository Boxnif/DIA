package com.KM.boxnif.dia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static com.KM.boxnif.dia.R.id.agbButton;
import static com.KM.boxnif.dia.R.id.emailW;
import static com.KM.boxnif.dia.R.id.view;

public class Registrierung extends AppCompatActivity
{
    Spinner spin;
    TextView tv;
    Button btn, agbB,lizenzB;
    //$email, $name, $password, $macadresse, $lizenzen);
    String name, email, emailW, password, passwordW;
    int macadresse, lizenz;
    Utility utility;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung);
        utility = new Utility();
        btn = (Button) findViewById(R.id.loadButton);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (checkInputs())
                {
                    finish();
                }
            }
        });
        lizenzB = (Button) findViewById(R.id.lizenzButton);
        lizenzB.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                utility.infoPopup(getString(R.string.infotextLizenzen), getApplication());
            }
        });
        agbB = (Button) findViewById(R.id.agbButton);
        agbB.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                utility.infoPopup(getString(R.string.infotextAGB), getApplication());
            }
        });


    }
    public boolean checkInputs()
    {
        if(name()&&email()&&password()&&lizenz()&&agb())
        {
            return true;
        }
        return false;
    }

    public boolean name()
    {
        name = ((EditText)(findViewById(R.id.name))).getText().toString();
        if(!name.equals(""))
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Bitte geben sie einen Namen ein",Toast.LENGTH_LONG).show();
        return false;
    }
    public boolean email()
    {
        email = ((EditText)(findViewById(R.id.email))).getText().toString();
        emailW = ((EditText)(findViewById(R.id.emailW))).getText().toString();
        if(emailPattern.matcher(email).matches()&&email.equals(emailW))
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Email Adresse ist entweder ungültig oder unterschiedlich",Toast.LENGTH_LONG).show();
        return false;
    }
    public boolean password()
    {
        password = ((EditText)(findViewById(R.id.password))).getText().toString();
        passwordW = ((EditText)(findViewById(R.id.passwordW))).getText().toString();
        if(password.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Passwort darf nicht leer sein",Toast.LENGTH_LONG).show();
            return false;
        }
        if(!password.equals(passwordW))
        {
            Toast.makeText(getApplicationContext(), "Passwort und wiederholung sind nicht gleich",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
    public boolean lizenz()
    {
        if (lizenzPattern.matcher(((EditText) findViewById(R.id.lizenzen)).getText().toString()).matches())
        {
            lizenz = Integer.parseInt(((EditText) findViewById(R.id.lizenzen)).getText().toString());
            return true;
        }
        Toast.makeText(getApplicationContext(), "Lizenz darf nicht leer oder 0 sein",Toast.LENGTH_LONG).show();
        return false;
    }
    public boolean agb()
    {
        if(((CheckBox) findViewById(R.id.agb)).isChecked())
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Bitte bestätigen sie das sie die AGB gelesen haben",Toast.LENGTH_LONG).show();
        return false;
    }
    private static final Pattern lizenzPattern = Pattern.compile
    (
            "[1-9]"+"[0-9]*"
    );
    public static final Pattern emailPattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    private static String getMacAddr()
    {
        try
        {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all)
            {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null)
                {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes)
                {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0)
                {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex)
        {
        }
        return "02:00:00:00:00:00";
    }
    /*public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.privat:
                if (checked)
                    tv.setText("Privat");
                    break;
            case R.id.firma:
                if (checked)
                    tv.setText("Firma");
                    break;
        }
    }*/
}
