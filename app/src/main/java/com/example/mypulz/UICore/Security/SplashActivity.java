package com.example.mypulz.UICore.Security;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import com.example.mypulz.R;

import DataProvider.SecurityDataProvider;
import Interface.HttpCallback;


public class SplashActivity extends Activity {

    boolean internet_flag=false;
    ProgressBar p;
    long sp_time = 3000;
    long ms = 0;
    boolean sp_Activity = true;
    boolean pause = false;
    @Nullable
    AsyncTask HttpServiceCallInit = null;
    @Nullable
    Activity activity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activity = this;
        setView();
        setData();
        httpServiceCall();
        //HttpServiceCallInit.execute(null);
        reDirection();
    }

    private void reDirection() {
        Thread my = new Thread() {
            public void run() {
                try {
                    while (sp_Activity && ms < sp_time) {
                        if (!pause)
                            ms = ms + 100;
                        sleep(100);
                    }
                }
                catch (Exception e) {
                } finally {
                    internet_flag = true;
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        };
        my.start();
    }

    private void setView() {

    }
    private void setData() {

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




