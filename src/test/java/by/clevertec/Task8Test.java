package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class Task8Test {

    @Test
    public void testTask8() {
        List<Animal> animals = Util.getAnimals();
        Animal oldestAnimal = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);

        assertNotNull(oldestAnimal, "task8: Oldest animal should not be null");
        System.out.println("task8: Oldest animal age: " + oldestAnimal.getAge());
    }
}

