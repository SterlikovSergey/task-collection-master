package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task10Test {

    @Test
    public void testTask10() {
        List<Animal> animals = Util.getAnimals();

        int expectedTotalAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();

        int actualTotalAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();

        assertEquals(expectedTotalAge, actualTotalAge, "task10: Total age should be correctly calculated");

        System.out.println("task10: " + actualTotalAge);
    }
}

