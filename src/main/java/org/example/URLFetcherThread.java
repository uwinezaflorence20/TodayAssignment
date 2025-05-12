package org.example;

import java.io.*;
import java.net.*;

public class URLFetcherThread implements Runnable {
    private String url;

    public URLFetcherThread(String url) {
        this.url = url;
    }

    public void run() {
        BufferedReader reader = null;
        try {
            URL website = new URL(url);
            reader = new BufferedReader(new InputStreamReader(website.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Thread [" + Thread.currentThread().getName() + "]: " + line);
            }
        } catch (Exception e) {
            System.out.println("Thread [" + Thread.currentThread().getName() + "] Error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Thread [" + Thread.currentThread().getName() + "] Error closing reader");
            }
        }
    }
}
