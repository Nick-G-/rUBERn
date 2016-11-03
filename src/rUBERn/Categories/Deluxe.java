package rUBERn.Categories;

// Created by nico on 11/2/16.

public class Deluxe implements CarCategory {
    @Override
    public double getCoefficient() {
        return 1.5;
    }

    @Override
    public String toString(){
        return "Deluxe";
    }
}
