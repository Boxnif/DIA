package com.KM.boxnif.dia;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 03.03.2017.
 */

public class RegistrierungsAnfrage extends StringRequest
{
    private static final String requestURL = "https://anastigmatic-cones.000webhostapp.com/Register.php";
    private Map<String, String>params;

    public RegistrierungsAnfrage(String email, String name, String password,String macadresse,int lizenz,String position, Response.Listener<String> listener)
    {
        super(Method.POST, requestURL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("name", name);
        params.put("password", password);
        params.put("lizenz", lizenz+"");
        params.put("macadresse", macadresse);
        params.put("position", position);



    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
