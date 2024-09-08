package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    public void testTask3() {
        List<Animal> animals = Util.getAnimals();

        List<String> expectedOrigins = animals.stream()
                .filter(animal -> animal.getAge() >= 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .toList();

        List<String> actualOrigins = animals.stream()
                .filter(animal -> animal.getAge() >= 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .toList();

        assertEquals(expectedOrigins, actualOrigins, "task3: Origins should be correctly filtered and distinct");

        actualOrigins.forEach(origin -> System.out.println("task3: " + origin));
    }
}

