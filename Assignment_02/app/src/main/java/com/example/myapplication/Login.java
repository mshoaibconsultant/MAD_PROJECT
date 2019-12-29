package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.annotation.SuppressLint;

public class Login extends AppCompatActivity {
    TextView tv;
    EditText password;
    EditText email;
    myDbAdapter helper;
    String a;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv = findViewById(R.id.textView);
        email = (EditText) findViewById(R.id.editText);
        password = findViewById(R.id.editText1);
        helper = new myDbAdapter(this);
    }
    public void viewdata(View view)
    {   String b = email.getText().toString().trim();
        String a = helper.getData(b);
        if (!b.equals(a)) {
            Message.message(getApplicationContext(),"Incorrect username, please create username first");
            Intent intent = new Intent(this,a_4_signup.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this,BeautyandBeast.class);
            startActivity(intent);
        }
    }
}
