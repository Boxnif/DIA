package com.KM.boxnif.dia.Anfragen;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 30.08.2017.
 */

public class loeschenAnfrage extends StringRequest
{
    private static final String registriertURL = "https://anastigmatic-cones.000webhostapp.com/LoeschenAnfrage.php";
    private Map<String, String> params;

    public loeschenAnfrage(String Auswertungs_ID, Response.Listener<String> listener)
    {
        super(Request.Method.POST, registriertURL, listener, null);
        params = new HashMap<>();
        params.put("Auswertungs_ID", Auswertungs_ID);

    }
    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}