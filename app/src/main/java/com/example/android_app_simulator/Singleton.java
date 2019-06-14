package com.example.android_app_simulator;

public class Singleton {
    private static volatile Client client;

    private Singleton() {}

    public static Client getClient() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }
}
