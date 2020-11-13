package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FridayModel extends AppCompatActivity {

    private String name;
    private String firstName;
    private int age;
    private String email;

    public FridayModel(String name, String firstName,String email, int age) {
        this.name = name;
        this.firstName = firstName;
        this.age = age;
        this.email=email;
    }

    public FridayModel(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}