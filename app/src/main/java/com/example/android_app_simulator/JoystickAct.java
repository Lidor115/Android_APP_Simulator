package com.example.android_app_simulator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

public class JoystickAct extends AppCompatActivity implements Joystick.JoystickListener{

    private Joystick js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        js = new Joystick(this);
        setContentView(js);
    }

    @Override
    public void onJoystickMoved(float xPercent, float yPercent, int source) {
        Log.d("Main Method", "X percent: " + xPercent + " Y percent: " + yPercent);
    }
}