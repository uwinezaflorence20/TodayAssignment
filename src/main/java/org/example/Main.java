package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "https://www.example.com";

        Thread thread = new Thread(new URLFetcherThread(url));
        thread.setName("FetcherThread-1");
        thread.start();

        System.out.println("Main thread continues processing...");
    }
}