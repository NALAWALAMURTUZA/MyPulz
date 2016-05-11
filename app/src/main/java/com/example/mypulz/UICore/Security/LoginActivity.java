package com.example.mypulz.UICore.Security;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mypulz.R;

import DataProvider.SecurityDataProvider;
import Interface.HttpCallback;

public class LoginActivity extends Activity {

    @Nullable
    AsyncTask HttpServiceCallInit = null;
    @Nullable
    Activity activity = null;
    Button btnlogin,btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;
        setView();
        setData();
        httpServiceCall();
        //HttpServiceCallInit.execute(null);
    }
    private void setView() {
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnsignup = (Button)findViewById(R.id.btnsignup);
    }
    private void setData() {

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void httpServiceCall() {
        HttpServiceCallInit = new AsyncTask() {
            @Nullable
            @Override
            protected Object doInBackground(Object[] params) {
                SecurityDataProvider.Init(activity,"", new HttpCallback() {
                    @Override
                    public void callbackFailure(Object result) {
                        System.out.println(result);
                    }
                    @Override
                    public void callbackSuccess(Object result) {
                        System.out.println(result);
                    }
                });
                return null;
            }
        };
    }

}

