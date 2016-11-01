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
        double aDriverImage = imageToClient(aDriver)* catalogue.evaluateCarImageCost(aDriver.getCar());
        double anotherDriverImage = imageToClient(anotherDriver) * catalogue.evaluateCarImageCost(anotherDriver.getCar());

        if (aDriverImage < anotherDriverImage)
            return -1;
        if (aDriverImage > anotherDriverImage)
            return 1;
        return 0;

    }
    public double imageToClient(Driver driver){
        double imageCost = 0;
        Location locationToCalculateFrom = driver.getCurrentLocation();
        if (driver.getStatus().isWorking()) {
            imageCost += driver.currentLocation.distanceTo(driver.getCurrentDestination()) * imageCostPerMeter;
        }
        imageCost += locationToCalculateFrom.distanceTo(journey.getOrigin()) * imageCostPerMeter;
        return imageCost;
    }

}
