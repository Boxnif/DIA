package com.KM.boxnif.dia;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.KM.boxnif.dia.Anfragen.BestaetigungAnfrage;
import com.KM.boxnif.dia.Anfragen.EmailAnfrage;
import com.KM.boxnif.dia.Anfragen.LizenzenAnfrage;
import com.KM.boxnif.dia.Anfragen.NutzerAnfrage;
import com.KM.boxnif.dia.Anfragen.RegistrierungsAnfrage;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class Registrierung extends AppCompatActivity
{
    Spinner spin;
    TextView tv;
    Button btn, agbB;
    //$email, $name, $password, $macadresse, );
    String name, email, emailW, password, passwordW, position;

    Utility utility;
    public static boolean nutzer = false;
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
                    nutzer();
                    showAlert(view);

                }
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
                String url = "https://anastigmatic-cones.000webhostapp.com/data-privacy.html";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        };

        //ss.setSpan(span1, 26, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 26, 46, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView tv = (TextView) findViewById(R.id.agbText);
        tv.setText(ss);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }



    public boolean checkInputs()
    {
        if(name()&&email()&&password()&&agb())
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
        email = ((EditText)(findViewById(R.id.anzahl))).getText().toString();
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

    public boolean agb()
    {
        if(((CheckBox) findViewById(R.id.agbCb)).isChecked())
        {
            return true;
        }
        Toast.makeText(getApplicationContext(), "Bitte bestätigen sie das sie die AGB gelesen haben",Toast.LENGTH_LONG).show();
        return false;
    }

    public static final Pattern emailPattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
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
        alert.setMessage(Html.fromHtml(getString(R.string.reginf1)+name+getString(R.string.reginf2)+email+getString(R.string.reginf3)+password));
        alert.setPositiveButton("Weiter", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                if(!nutzer)
                {
                    registriere();
                    dialog.dismiss();
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Diese E-Mail Adresse wird schon verwendet.",Toast.LENGTH_LONG).show();
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
    //checked ob die email schon in Benutzung ist
    private void nutzer()
    {

        Response.Listener<String> rListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if(success)
                    {
                        Registrierung.nutzer = true;
                    }
                    else
                    {
                        Registrierung.nutzer = false;
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        NutzerAnfrage na = new NutzerAnfrage(email,rListener );
        RequestQueue queue = Volley.newRequestQueue(Registrierung.this);
        queue.add(na);
    }
    //registriert den benutzer
    private void registriere()
    {
        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if(success)
                    {
                        // TODO: 05.03.2017 aktion für nach der Registrierung eingügen
                        sendEmail(email,password);
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registrierung.this);
                        builder.setMessage("Registrierung fehlgeschlagen").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        RegistrierungsAnfrage ra = new RegistrierungsAnfrage(email,name,password,position,responseListener );
        RequestQueue queue = Volley.newRequestQueue(Registrierung.this);
        queue.add(ra);
    }
    public void sendEmail(String _email, String _password)
    {
        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    /*boolean success = jsonObject.getBoolean("success");
                    if (success)
                    {
                        Toast.makeText(getApplicationContext(), "La", Toast.LENGTH_LONG).show();
                    } else
                    {
                        //Toast.makeText(getApplicationContext(), "Keine Antwort", Toast.LENGTH_LONG).show();
                    }*/
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        BestaetigungAnfrage bestaetigungAnfrage= new BestaetigungAnfrage(_email,_password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Registrierung.this);
        queue.add(bestaetigungAnfrage);
    }



}
