package rUBERn;

// Created by nico on 10/1/16.

public class Logger {
    public Logger(){
    }

    public void log(Operation operation){
        System.out.println(operation.getDescription());
    }
}
