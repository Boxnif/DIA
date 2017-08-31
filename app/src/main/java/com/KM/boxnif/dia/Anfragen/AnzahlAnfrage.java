package com.KM.boxnif.dia.Anfragen;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 28.08.2017.
 */

public class AnzahlAnfrage extends StringRequest
{
    private static final String loginURL = "https://anastigmatic-cones.000webhostapp.com/AnzahlAnfrage.php";
    private Map<String, String> params;

    public AnzahlAnfrage(String EMail, Response.Listener<String> listener)
    {
        super(Method.POST, loginURL, listener, null);
        params = new HashMap<>();
        params.put("EMail", EMail);
    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
