package rUBERn.Categories;

// Created by nico on 11/2/16.

public class Standard implements CarCategory {
    @Override
    public double getCoefficient() {
        return 1;
    }

    @Override
    public String toString() {
        return "Standard";
    }
}
