package rUBERn;

// Created by nico on 10/3/16.

public class ImageCalculator {

    double imageCostPerMeter;
    private CategoriesCatalogue catalogue;

    public double calculateImageCost(Driver driver, Journey journey) {
        return driver.getLocation().distanceTo(journey.getOrigin()) * imageCostPerMeter + catalogue.evaluateCarImageCost(driver.getCar());
    }
}
