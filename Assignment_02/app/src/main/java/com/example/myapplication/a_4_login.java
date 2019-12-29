package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class a_4_login extends AppCompatActivity {
    TextView tv;
    EditText username;
    EditText password;
    EditText email;
    myDbAdapter db = new myDbAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_4_login);
        tv = findViewById(R.id.textView);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText1);
        email = findViewById(R.id.editText2);
    }

    public void EmailValidate1(View v){
        String str = email.getText().toString();
        String str1 = password.getText().toString();
        boolean isError= false;
        if (!str.contains("@")){
            email.setError("@ is missing");
            isError = true;}

        else if (!str.contains(".com"))
        {
            email.setError(".com is missing");
            isError = true;
        }

        if (str1.length() < 5 || str1.length() > 8){
            password.setError("invalid pass");
            isError = true;}

        if(!isError){
            Intent intent = new Intent(this,BeautyandBeast.class);
            startActivity(intent);
        }
    }
}
