package com.KM.boxnif.dia.Anfragen;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boxnif on 18.08.2017.
 */

public class LizenzenAnfrage extends StringRequest
{
    private static final String lizenzURL = "https://anastigmatic-cones.000webhostapp.com/Lizenz.php";
    private Map<String, String> params;

    public LizenzenAnfrage(String email, Response.Listener<String> listener)
    {
        super(Method.POST, lizenzURL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("macadresse", "-");

    }
    @Override
    public Map<String, String> getParams()
    {
        return params;
    }
}
