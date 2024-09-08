package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task6Test {

    @Test
    public void testTask6() {
        List<Animal> animals = Util.getAnimals();

        boolean expectedAllMatchMaleOrFemale = animals.stream()
                .allMatch(animal -> "Male".equals(animal.getGender()) || "Female".equals(animal.getGender()));

        boolean actualAllMatchMaleOrFemale = animals.stream()
                .allMatch(animal -> "Male".equals(animal.getGender()) || "Female".equals(animal.getGender()));

        assertEquals(expectedAllMatchMaleOrFemale, actualAllMatchMaleOrFemale, "task6: All animals should be either Male or Female");

        if (actualAllMatchMaleOrFemale) {
            System.out.println("task6: allMatchMaleOrFemale");
        } else {
            System.out.println("task6: No allMatchMaleOrFemale");
        }
    }
}


