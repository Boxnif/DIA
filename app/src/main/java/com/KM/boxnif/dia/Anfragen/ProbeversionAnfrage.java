package com.KM.boxnif.dia.Anfragen;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 21.08.2017.
 */

public class ProbeversionAnfrage extends StringRequest
{
    private static final String lizenzURL = "https://anastigmatic-cones.000webhostapp.com/ProbeversionAktiv.php";
    private Map<String, String> params;

    public ProbeversionAnfrage(String email, Response.Listener<String> listener)
    {
        super(Request.Method.POST, lizenzURL, listener, null);
        params = new HashMap<>();
        params.put("email", email);

    }
    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
