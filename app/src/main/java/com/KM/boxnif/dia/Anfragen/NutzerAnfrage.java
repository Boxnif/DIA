package com.KM.boxnif.dia.Anfragen;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 06.03.2017.
 */

public class NutzerAnfrage extends StringRequest
{
    private static final String loginURL = "https://anastigmatic-cones.000webhostapp.com/Nutzer.php";
    private Map<String, String> params;

    public NutzerAnfrage(String email, Response.Listener<String> listener)
    {
        super(Request.Method.POST, loginURL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}