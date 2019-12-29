package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class a_4_signup extends AppCompatActivity {
    TextView tv;
    EditText username;
    EditText password;
    EditText email;
    CheckBox cb;
    myDbAdapter helper;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_4_signup);
        tv = findViewById(R.id.textView);
        username = findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        cb = findViewById(R.id.checkbox);
        helper = new myDbAdapter(this);
    }
    public void EmailValidate(View v){
        String str = email.getText().toString();
        String str1 = password.getText().toString();
        boolean isError= false;
        if (!str.contains("@"))
        {
            email.setError("@ is missing");
            isError = true;
        }

        else if (!str.contains(".com"))
        {
            email.setError(".com is missing");
            isError = true;
        }

        if (str1.length() < 5 || str1.length() > 8){
            password.setError("invalid pass");
            isError = true;}
    }
    public void addUser(View view)
    {
        String t1 = email.getText().toString();
        String t2 = password.getText().toString();
        if(t1.isEmpty() || t2.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Both Name and Password");
        }
        else
        {
            long id = helper.insertData(t1,t2);
            if(id<=0)
            {
                Message.message(getApplicationContext(),"Insertion Unsuccessful");
                email.setText("");
                password.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                Intent intent = new Intent(this,Login.class);
                startActivity(intent);
                email.setText("");
                password.setText("");
            }
        }
    }
}
