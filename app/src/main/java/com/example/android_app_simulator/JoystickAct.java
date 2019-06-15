package com.example.android_app_simulator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

public class JoystickAct extends AppCompatActivity implements Joystick.JoystickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joystick);
    }

    @Override
    public void onJoystickMoved(float xPercent, float yPercent, int source) {
        Singleton.getClient().SendToSimulator(xPercent,yPercent);
        Log.d("Main Method", "X percent: " + xPercent + " Y percent: " + yPercent);
    }
}