package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task5Test {

    @Test
    public void testTask5() {
        List<Animal> animals = Util.getAnimals();

        boolean expectedHungarianExists = animals.stream()
                .anyMatch(animal -> animal.getAge() >= 20 && animal.getAge() <= 30 && animal.getOrigin().equals("Hungarian"));

        boolean actualHungarianExists = animals.stream()
                .anyMatch(animal -> animal.getAge() >= 20 && animal.getAge() <= 30 && animal.getOrigin().equals("Hungarian"));

        assertEquals(expectedHungarianExists, actualHungarianExists, "task5: Hungarian animal existence should be correctly determined");

        System.out.println("task5: " + actualHungarianExists);
    }
}

