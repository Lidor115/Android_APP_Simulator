package com.example.android_app_simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Login extends AppCompatActivity {

    private Joystick js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        js = new Joystick(this);
        setContentView(R.layout.login);

    }
}
