package rUBERn;

// Created by nico on 10/1/16.

import java.util.HashMap;

public class CategoriesCatalogue {
    private HashMap<Car,String> catalogue = new HashMap<Car, String>();

    public CategoriesCatalogue(HashMap catalogue) {
        this.catalogue = catalogue;
    }

    public CategoriesCatalogue(){} //me parece que si ya como private arriba le creas un hashMap en el constructor no haria falta ponerlo devuelta

    public double evaluateCarImageCost(Car car) {
        return car.getCategory().getCoefficient();
    }
}
