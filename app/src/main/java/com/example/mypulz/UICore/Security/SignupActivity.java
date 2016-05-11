package com.example.mypulz.UICore.Security;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mypulz.R;

public class SignupActivity extends Activity {

    Activity activity = null;
    AsyncTask HttpServiceCallInit = null;
    RadioGroup radioUserType;
    RadioButton radioSelectedType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        activity = this;
        setView();
        setData();
        httpServiceCall();
    }

    private void setView() {
       // radioUserType = (RadioGroup) findViewById(R.id.radioUserType);
    }
    private void setData() {
       /* radioUserType.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioUserType.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSelectedType = (RadioButton) findViewById(selectedId);

                Toast.makeText(SignupActivity.this,
                        radioSelectedType.getText(), Toast.LENGTH_SHORT).show();

            }

        });*/
    }


    private void httpServiceCall() {

    }
}
