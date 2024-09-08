package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task4Test {

    @Test
    public void testTask4() {
        List<Animal> animals = Util.getAnimals();

        long expectedFemaleCount = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();

        long actualFemaleCount = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();

        assertEquals(expectedFemaleCount, actualFemaleCount, "task4: Female count should be correctly calculated");

        System.out.println("task4: " + actualFemaleCount);
    }
}

