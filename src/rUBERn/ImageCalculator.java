package rUBERn;

// Created by nico on 10/3/16.

public class ImageCalculator {
    double imageCostPerMeter;
    private CategoriesCatalogue catalogue;
    public ImageCalculator(){
    imageCostPerMeter = 0.004; // 2/500
    catalogue = new CategoriesCatalogue();
    }
    public double calculateImageCost(Driver driver, Journey journey) {
        return driver.getCurrentLocation().distanceTo(journey.getOrigin()) * imageCostPerMeter * catalogue.evaluateCarImageCost(driver.getCar());
    }
}
