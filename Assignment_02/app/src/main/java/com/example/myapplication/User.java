package com.example.myapplication;

import android.widget.EditText;

public class User {
    int id;
    String email;
    String password;

    public User(EditText email, EditText password){   }
    public User(int id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
