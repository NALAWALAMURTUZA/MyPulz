package DataProvider;

import android.app.Activity;
import android.support.annotation.NonNull;

import Comman.Constant;
import Comman.HttpConnection;
import Comman.ServiceUrl;
import Interface.HttpCallback;

/**
 * Created by Murtuza on 5/1/2016.
 */


public class SecurityDataProvider {

    public static void Login(Activity activity, String InputString, @NonNull HttpCallback callback) {
        // Run callback callback.run();
        HttpConnection.HttpConnect(activity,ServiceUrl.Login + "/" + InputString,1000,"", Constant.MethodNameGet,callback);
    }
}
