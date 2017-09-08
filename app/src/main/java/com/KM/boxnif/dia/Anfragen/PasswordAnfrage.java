package com.KM.boxnif.dia.Anfragen;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 06.09.2017.
 */

public class PasswordAnfrage extends StringRequest
{
    private static final String registriertURL = "https://anastigmatic-cones.000webhostapp.com/PasswordAnfrage.php";
    private Map<String, String> params;

    public PasswordAnfrage(String email, Response.Listener<String> listener)
    {
        super(Request.Method.POST, registriertURL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
    }
    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}