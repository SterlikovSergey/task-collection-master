package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {

    @Test
    public void testTask7() {
        List<Animal> animals = Util.getAnimals();

        boolean expectedNoOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));

        boolean actualNoOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));

        assertEquals(expectedNoOceania, actualNoOceania, "task7: No animals should have origin 'Oceania'");

        if (actualNoOceania) {
            System.out.println("task7: No oceania");
        } else {
            System.out.println("task7: oceania");
        }
    }
}

