package com.KM.boxnif.dia.Anfragen;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 20.08.2017.
 */

public class GeraetRegistrierenAnfrage extends StringRequest
{
    private static final String registriertURL = "https://anastigmatic-cones.000webhostapp.com/Registriert.php";
    private Map<String, String> params;

    public GeraetRegistrierenAnfrage(String email,String macadresse, Response.Listener<String> listener)
    {
        super(Request.Method.POST, registriertURL, listener, null);
        params = new HashMap<>();
        params.put("macadresse", macadresse);
        params.put("email", email);

    }
    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
