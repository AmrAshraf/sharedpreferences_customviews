package com.example.amr.sharedpreferences_customviews;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final TextView user_name=(TextView) findViewById(R.id.nameMainAct_txt);
        final TextView user_email=(TextView) findViewById(R.id.emailMainAct_txt);
        sharedPreferences=getSharedPreferences(getString(R.string.login_shared_preferences), MODE_PRIVATE );//get the paper
        String userName=sharedPreferences.getString(getString(R.string.user_name),""); //second parameter is a default
        String userEmail=sharedPreferences.getString(getString(R.string.user_email),""); //second parameter is a default
        user_email.setText(userEmail);
        user_name.setText(userName);

        Button logoutBtn=(Button)findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor=sharedPreferences.edit();
                editor.putBoolean(getString(R.string.auto_login),false);
                editor.commit();
                finish();
            }
        });
    }
}
