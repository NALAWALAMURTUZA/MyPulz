package Model;

import org.json.*;

/**
 * Created by Murtuza on 5/1/2016.
 */
public class LoginModel {

    public static String LoginPostModel(String mobile_number, String otp_number)
    {
        JSONObject object = new JSONObject();
        try {
            object.put("mobile_number",mobile_number);
            object.put("otp_number",otp_number);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return object.toString();
    }
}

