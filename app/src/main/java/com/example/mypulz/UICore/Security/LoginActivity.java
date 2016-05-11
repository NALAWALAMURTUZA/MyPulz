package com.example.mypulz.UICore.Security;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mypulz.R;

import DataProvider.SecurityDataProvider;
import Interface.HttpCallback;
import Model.LoginModel;

public class LoginActivity extends Activity {

    AsyncTask HttpServiceCallLogin = null;
    Activity activity = null;
    Button btnlogin,btnsignup;
    TextView txtOtpPassword,txtMobileNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;
        setView();
        setData();
        //HttpServiceCallInit.execute(null);
    }
    private void setView() {
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnsignup = (Button)findViewById(R.id.btnsignup);
        txtOtpPassword = (TextView)findViewById(R.id.txtOtpPassword);
        txtMobileNumber = (TextView)findViewById(R.id.txtMobileNumber);

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

                if(validation() == true)
                {
                    httpServiceCall();
                    HttpServiceCallLogin.execute(null);
                }

            }
        });
    }

    private boolean validation()
    {
        boolean flage = true;
        if(txtMobileNumber.getText().length() == 0)
        {
            flage = false;
        }
        else if(txtOtpPassword.getText().length() == 0)
        {
            flage = false;
        }
        return  flage;
    }
    private void httpServiceCall() {
        HttpServiceCallLogin = new AsyncTask() {
            String loginPostModel = LoginModel.LoginPostModel(txtMobileNumber.getText().toString(),txtOtpPassword.getText().toString());
            @Override
            protected Object doInBackground(Object[] params) {
                SecurityDataProvider.Login(activity,loginPostModel, new HttpCallback() {
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

