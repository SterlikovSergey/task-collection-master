package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void testTask2() {
        List<Animal> animals = Util.getAnimals();

        List<String> expectedBreeds = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> {
                    if ("Female".equals(animal.getGender())) {
                        return animal.getBread().toUpperCase();
                    } else {
                        return animal.getBread();
                    }
                })
                .toList();

        List<String> actualBreeds = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> {
                    if ("Female".equals(animal.getGender())) {
                        return animal.getBread().toUpperCase();
                    } else {
                        return animal.getBread();
                    }
                })
                .toList();

        assertEquals(expectedBreeds, actualBreeds, "task2: Breeds should be correctly filtered");

        actualBreeds.forEach(breed -> System.out.println("task2: " + breed));
    }
}
