package com.KM.boxnif.dia.Anfragen;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 26.08.2017.
 */

public class AuswertungAnfrage extends StringRequest
{
    private static final String lizenzURL = "https://anastigmatic-cones.000webhostapp.com/AuswertungAnfrage.php";
    private Map<String, String> params;

    public AuswertungAnfrage(String Vorname,String Nachname,String Geburtsdatum,String Alt,String ErstelltDatum,String Modul1,String Modul2,String Modul3,String Modul4,String Modul5,String Modul6,String AssPunkte,String BBC,String Pflegegrad,String EMail, Response.Listener<String> listener)
    {
        super(Method.POST, lizenzURL, listener, null);
        params = new HashMap<>();
        params.put("Vorname", Vorname);
        params.put("Nachname", Nachname);
        params.put("Geburtsdatum", Geburtsdatum);
        params.put("Alt", Alt);
        params.put("ErstelltDatum", ErstelltDatum);
        params.put("Modul1", Modul1);
        params.put("Modul2", Modul2);
        params.put("Modul3", Modul3);
        params.put("Modul4", Modul4);
        params.put("Modul5", Modul5);
        params.put("Modul6", Modul6);
        params.put("AssPunkte", AssPunkte);
        params.put("BBC", BBC);
        params.put("Pflegegrad", Pflegegrad);
        params.put("EMail", EMail);
    }
    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
