package com.example.android_app_simulator;

public class Singleton {
    private volatile Client client;

    public Singleton() {
    }

    public Client getClient() {
        if (this.client == null) {
            this.client = new Client();
        }
        return this.client;
    }
}
