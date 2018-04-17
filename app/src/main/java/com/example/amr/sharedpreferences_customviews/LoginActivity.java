package com.example.amr.sharedpreferences_customviews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();

        sharedPreferences= getSharedPreferences(getString(R.string.login_shared_preferences), MODE_PRIVATE );//get the paper

        sharedPreferences.contains(getString(R.string.auto_login)); //no need for the check just for practice
        {
            boolean autoLogin = sharedPreferences.getBoolean(getString(R.string.auto_login),false); //default value in the second parameter if the key doesn't exist
            if(autoLogin)
            {
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        }
        Button button=(Button) findViewById(R.id.login_btn);
        final TextView userName=(TextView) findViewById(R.id.name_editTxt);
        final TextView userEmail=(TextView) findViewById(R.id.email_editTxt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor=sharedPreferences.edit(); //get the pen
                editor.putBoolean(getString(R.string.auto_login),true);
                editor.putString(getString(R.string.user_email),userEmail.getText().toString());
                editor.putString(getString(R.string.user_name),userName.getText().toString());
                editor.apply();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
