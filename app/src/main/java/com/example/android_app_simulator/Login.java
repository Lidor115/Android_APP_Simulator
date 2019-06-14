package com.example.android_app_simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button connectB;
    private EditText[] values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        connectB = findViewById(R.id.connectB);
        connectB.setOnClickListener(this);
    }

    protected void connection(String ip, int port){
        Singleton s = new Singleton();
        s.getClient().connection(ip,port);
    }

    @Override
    public void onClick(View view) {
        values = new EditText[]{findViewById(R.id.ip),findViewById(R.id.port)};
        connection(values[0].getText().toString()
                ,Integer.parseInt(values[1].getText().toString()));
        Intent intent = new Intent(this, JoystickAct.class);
        startActivity(intent);
    }
}
