package by.clevertec;

import by.clevertec.model.Flower;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task15Test {

    @Test
    public void testTask15() {
        List<Flower> flowers = Util.getFlowers();
        Double expectedTotalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed())
                .sorted(Comparator.comparingInt(Flower::getPrice).reversed())
                .sorted(Comparator.comparingDouble(Flower::getWaterConsumptionPerDay).reversed())
                .filter(plant -> {
                    String name = plant.getCommonName().toUpperCase();
                    return name.compareTo("S") >= 0 || name.compareTo("C") <= 0;
                })
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().stream()
                        .anyMatch(material -> material.equals("Aluminum") || material.equals("Steel") || material.equals("Glass")))
                .map(flower -> {
                    double waterCostPerYear = flower.getWaterConsumptionPerDay() * 365 * 1.39;
                    double waterCostForFiveYears = waterCostPerYear * 5;
                    return flower.getPrice() + waterCostForFiveYears;
                })
                .reduce((double) 0, Double::sum);

        Double actualTotalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed())
                .sorted(Comparator.comparingInt(Flower::getPrice).reversed())
                .sorted(Comparator.comparingDouble(Flower::getWaterConsumptionPerDay).reversed())
                .filter(plant -> {
                    String name = plant.getCommonName().toUpperCase();
                    return name.compareTo("S") >= 0 || name.compareTo("C") <= 0;
                })
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().stream()
                        .anyMatch(material -> material.equals("Aluminum") || material.equals("Steel") || material.equals("Glass")))
                .map(flower -> {
                    double waterCostPerYear = flower.getWaterConsumptionPerDay() * 365 * 1.39;
                    double waterCostForFiveYears = waterCostPerYear * 5;
                    return flower.getPrice() + waterCostForFiveYears;
                })
                .reduce((double) 0, Double::sum);

        assertEquals(expectedTotalCost, actualTotalCost, "task15: Total cost should be correctly calculated");
    }
}
