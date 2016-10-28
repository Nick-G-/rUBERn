package rUBERn;

// Created by nico on 10/3/16.

import java.util.Comparator;

public class DriverComparatorByImageForJourney implements Comparator<Driver> {
    private Journey journey;

    double imageCostPerMeter;
    private CategoriesCatalogue catalogue;

    public DriverComparatorByImageForJourney(Journey journey){
        imageCostPerMeter = 0.004; // 2/500
        catalogue = new CategoriesCatalogue();
        this.journey = journey;
    }

    @Override
    public int compare(Driver aDriver, Driver anotherDriver) {
        double aDriverImage = aDriver.getCurrentLocation().distanceTo(journey.getOrigin()) * imageCostPerMeter * catalogue.evaluateCarImageCost(aDriver.getCar());
        double anotherDriverImage = anotherDriver.getCurrentLocation().distanceTo(journey.getOrigin()) * imageCostPerMeter * catalogue.evaluateCarImageCost(anotherDriver.getCar());

        if (aDriverImage < anotherDriverImage)
            return -1;
        if (aDriverImage > anotherDriverImage)
            return 1;
        return 0;

    }
}
