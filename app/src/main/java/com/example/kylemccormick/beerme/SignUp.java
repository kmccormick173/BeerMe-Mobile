package com.example.kylemccormick.beerme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    private String mFullName, mUser, mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

    public void onSubmit(View v) {

        //set text for errors
        TextView nameError = (TextView) findViewById(R.id.nameError);
        TextView userError = (TextView) findViewById(R.id.userError);
        TextView emError = (TextView) findViewById(R.id.emailError);
        TextView passError = (TextView) findViewById(R.id.passError);

        //name error check
        EditText fullName = (EditText) findViewById(R.id.fullName);
        if (fullName.getText().equals("")) {
            nameError.setText("Enter a Name");
            return;
        } else {
            nameError.setText("");
        }

        //user name error check
        EditText userName = (EditText) findViewById(R.id.userName);
        if (userName.getText().equals("")) {
            userError.setText("Enter Username");
            return;
        } else {
            userError.setText("");
        }

        //email error check
        EditText emailName = (EditText) findViewById(R.id.email);
        if (emailName.getText().equals("")) {
            emError.setText("Enter Valid Email");
            return;
        } else {
            emError.setText("");
        }

        //password error check
        EditText passwordName = (EditText) findViewById(R.id.password);
        if (passwordName.getText().equals("")) {
            passError.setText("Enter Password");
            return;
        } else {
            passError.setText("");
        }

        mFullName = fullName.getText().toString();
        mUser = userName.getText().toString();
        mEmail = emailName.getText().toString();
        mPassword = passwordName.getText().toString();

        makeUser();
        //makeUser(mFullName, mUser, mEmail, mPassword);
    }

    public void makeUser(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    //need make user function
    //public void makeUser(String fullName, String username, String email, String password) {}

}
