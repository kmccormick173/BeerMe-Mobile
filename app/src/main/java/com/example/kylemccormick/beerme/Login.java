package com.example.kylemccormick.beerme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private String eemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signUp(View v){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void loginClicked(View v) {
        EditText emailName = (EditText) findViewById(R.id.email);
        EditText passwordName = (EditText) findViewById(R.id.password);
        eemail = emailName.getText().toString();
        String ppassword = passwordName.getText().toString();
        //onLogin(eemail, ppassword);
        onLogin();
    }


    public void onLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    /*
    public void onLogin(String email, String password) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/

}
