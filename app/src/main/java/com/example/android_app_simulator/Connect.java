package com.example.android_app_simulator;

import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Connect {
    private String ip;
    private int port;
    private Thread t;

    public Connect(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connection() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    InetAddress serverAddr = InetAddress.getByName(ip);
                    Socket socket = new Socket(serverAddr, port);
                } catch (IOException e) {
                    Log.e("TCP", "C: Error", e);
                    System.out.println((e.toString()));
                }
            }
        };
        this.t = new Thread(r);
        this.t.start();
    }
}