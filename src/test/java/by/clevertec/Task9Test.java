package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task9Test {
    @Test
    public void testTask9() {
        List<Animal> animals = Util.getAnimals();
        int minLength = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(arr -> arr.length)
                .min()
                .orElseThrow(() -> new AssertionError("task9: No animals found"));

        assertTrue(minLength > 0, "task9: The length of the shortest array should be greater than 0");
        System.out.println("task9: Length of the shortest array: " + minLength);
    }
}
