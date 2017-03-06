package com.KM.boxnif.dia;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 05.03.2017.
 */

public class LoginAnfrage extends StringRequest
{
    private static final String loginURL = "https://anastigmatic-cones.000webhostapp.com/Login.php";
    private Map<String, String> params;

    public LoginAnfrage(String email, String password, Response.Listener<String> listener)
    {
        super(Method.POST, loginURL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}