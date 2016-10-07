package rUBERn;

// Created by nico on 10/3/16.

public class ImageCalculator {

    private double imageCostPerMeter;
    private CategoriesCatalogue catalogue;
    private Journey journey;
    private Car car;
    public ImageCalculator(CategoriesCatalogue catalogue, Journey journey, Car car){ // calculate image cost for a journey and a car using a Car CategoriesCatalog
        this.catalogue = catalogue;
        this.journey = journey;
        this.car = car;
    }
    public double evaluateCarImageCost() {
        int percentage = catalogue.getPercentage(car.getCategory());
        return percentage * journey.getDistance();
    }
    public double calculateImageCost(Driver driver, Journey journey) {
        return driver.getLocation().distanceTo(journey.getOrigin()) * imageCostPerMeter + evaluateCarImageCost();
    }
}
