package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task11Test {

    @Test
    public void testTask11() {
        List<Animal> animals = Util.getAnimals();
        double expectedAverageAge = animals.stream()
                .filter(animal -> "Indonesian".equals(animal.getOrigin()))
                .mapToDouble(Animal::getAge)
                .average()
                .orElse(0.0);

        double actualAverageAge = animals.stream()
                .filter(animal -> "Indonesian".equals(animal.getOrigin()))
                .mapToDouble(Animal::getAge)
                .average()
                .orElse(0.0);

        assertEquals(expectedAverageAge, actualAverageAge, "The average age should be correctly calculated");
        System.out.println("task11: Average age of Indonesian animals: " + actualAverageAge);
    }
}

