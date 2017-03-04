package com.KM.boxnif.dia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;


import static com.KM.boxnif.dia.R.id.emailW;
import static com.KM.boxnif.dia.R.id.view;

public class Registrierung extends AppCompatActivity
{
    Spinner spin;
    TextView tv;
    Button btn, agbB,lizenzB;
    //$email, $name, $password, $macadresse, $lizenzen);
    String name, email, emailW, password, passwordW, macadresse, position;
    int  lizenz;
    Utility utility;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung);
        tv = (TextView) findViewById(R.id.textView1);
        utility = new Utility();
        btn = (Button) findViewById(R.id.loadButton);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (checkInputs())
                {
                    showAlert(view);

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

        SpannableString ss = new SpannableString(getResources().getString(R.string.bestätigung));
        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                utility.infoPopup(getString(R.string.infotextAGB), getApplication());
            }
        };

        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                utility.infoPopup(getString(R.string.infotextDatenschutz), getApplication());
            }
        };

        ss.setSpan(span1, 26, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 34, 54, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView tv = (TextView) findViewById(R.id.agbText);
        tv.setText(ss);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
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
            if(((RadioButton)findViewById(R.id.privat)).isChecked())
            {
                position = "Privatperson";
            }
            else
            {
                position = "Firma";
            }
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
        if(((CheckBox) findViewById(R.id.agbCb)).isChecked())
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
    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.privat:
                if (checked)
                    tv.setText("Vor-/Nachname");
                    break;
            case R.id.firma:
                if (checked)
                    tv.setText("Firmenname");
                    break;
        }
    }
    private void showAlert(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(Html.fromHtml(getString(R.string.reginf1)+name+getString(R.string.reginf2)+email+getString(R.string.reginf3)+password+getString(R.string.reginf4)+lizenz));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();

                macadresse = getMacAddr();
                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                RegistrierungsAnfrage ra = new RegistrierungsAnfrage(email,name,password,macadresse,lizenz,position,responseListener );
                //Registrierungsanfrage_Test ra = new Registrierungsanfrage_Test("finn@something", "kappa",3, "kgfkfg","kappa123","chef",responseListener);
                RequestQueue queue = Volley.newRequestQueue(Registrierung.this);
                queue.add(ra);

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
