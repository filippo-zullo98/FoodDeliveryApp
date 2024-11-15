package org.app;


public class Engine {
    private JDBC db;

    public Engine() {
        this.db = JDBC.getDbInstance();
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}