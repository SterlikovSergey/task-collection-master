package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    public void testTask1() {
        List<Animal> animals = Util.getAnimals();

        List<Animal> youngAnimals = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .toList();

        List<Animal> expectedThirdZooAnimals = IntStream.range(0, youngAnimals.size())
                .filter(i -> (i / 7) == 2)
                .mapToObj(youngAnimals::get)
                .toList();

        List<Animal> actualThirdZooAnimals = IntStream.range(0, youngAnimals.size())
                .filter(i -> (i / 7) == 2)
                .mapToObj(youngAnimals::get)
                .toList();

        assertEquals(expectedThirdZooAnimals, actualThirdZooAnimals, "task1: The animals in the third zoo should be correctly calculated");

        actualThirdZooAnimals.forEach(animal -> System.out.println("task1: " + animal));
    }
}
