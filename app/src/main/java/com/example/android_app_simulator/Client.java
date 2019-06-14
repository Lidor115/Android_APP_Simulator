package com.example.android_app_simulator;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static android.content.ContentValues.TAG;

public class Client {
    private String ip;
    private int port;
    private Socket socket;


    public Client() {
    }

    public void connection(String temp_ip, int temp_port) {
        this.ip = temp_ip;
        this.port = temp_port;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    InetAddress serverAddr = InetAddress.getByName(ip);
                    socket = new Socket(serverAddr, port);
                } catch (IOException e) {
                    Log.e("TCP", "C: Error", e);
                    System.out.println((e.toString()));
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    public void SendToSimulator(float aileronN, float elevatorN) {
        final String aileronS = "/controls/flight/aileron " + Float.toString(aileronN) + "\r\n";
        final String elevatorS = "controls/flight/elevator " + Float.toString(elevatorN) + "\r\n";
        Send(aileronS);
        Send(elevatorS);
    }

    public void Send(final String toSend) {
        final PrintWriter sender;
        try {
            sender = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    if (sender != null) {
                        Log.d(TAG, "Sending: " + toSend);
                        sender.println(toSend);
                        sender.flush();
                    }
                }
            }; Thread thread = new Thread(r);
            thread.start();

        } catch (IOException e) {
            Log.e("TCP", "C: Error", e);
            System.out.println((e.toString()));
        }
    }

    public void close() {
        try {
            this.socket.close();
        } catch (IOException e) {
            Log.e("TCP", "C: Error", e);
            System.out.println((e.toString()));
        }
    }
}
