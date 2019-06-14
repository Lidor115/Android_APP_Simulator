package com.example.android_app_simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobScheduler;
import android.os.Bundle;

public class JoystickAct extends AppCompatActivity {

    private Joystick js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        js = new Joystick(this);
        setContentView(js);
    }
}
