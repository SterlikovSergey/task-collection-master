package by.clevertec;

import by.clevertec.model.Car;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task14Test {

    @Test
    public void testTask14() {
        List<Car> cars = Util.getCars();

        Map<String, List<Car>> sortedCars = cars.stream()
                .collect(Collectors.groupingBy(car -> {
                    if ("Jaguar".equals(car.getCarMake()) || "White".equals(car.getColor())) {
                        return "Turkmenistan";
                    } else if (car.getMass() <= 1500 && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())) {
                        return "Uzbekistan";
                    } else if ("Black".equals(car.getColor()) && car.getMass() > 4000 || List.of("GMC", "Dodge").contains(car.getCarMake())) {
                        return "Kazakhstan";
                    } else if (car.getReleaseYear() <= 1982 || List.of("Civic", "Cherokee").contains(car.getCarModel())) {
                        return "Kyrgyzstan";
                    } else if (!List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor()) || car.getPrice() > 40000) {
                        return "Russia";
                    } else if (car.getVin().contains("59")) {
                        return "Mongolia";
                    } else {
                        return "Discard";
                    }
                }));

        double totalRevenue = 0;
        double expectedTotalRevenue = 0;

        for (String country : List.of("Turkmenistan", "Uzbekistan", "Kazakhstan", "Kyrgyzstan", "Russia", "Mongolia")) {
            List<Car> countryCars = sortedCars.getOrDefault(country, List.of());
            int totalMass = countryCars.stream().mapToInt(Car::getMass).sum();
            double transportCost = totalMass / 1000.0 * 7.14;
            totalRevenue += transportCost;
            expectedTotalRevenue += transportCost;
            System.out.println("task14: " + country + ": " + transportCost + " $");
        }

        System.out.println("task14: " + "Total Revenue: " + totalRevenue + " $");

        assertEquals(expectedTotalRevenue, totalRevenue, "task14: " + "Total revenue should be correctly calculated");
    }
}

