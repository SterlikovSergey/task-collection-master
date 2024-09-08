package by.clevertec;

import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Task13Test {

    private static int getAge(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Test
    public void testTask13() {
        List<House> houses = Util.getHouses();
        List<Person> evacuees = houses.stream()
                .flatMap(house -> house.getPersonList().stream())
                .sorted((p1, p2) -> {
                    if ("Hospital".equals(p1.getOccupation()) && !"Hospital".equals(p2.getOccupation())) {
                        return -1;
                    } else if (!"Hospital".equals(p1.getOccupation()) && "Hospital".equals(p2.getOccupation())) {
                        return 1;
                    } else if ((getAge(p1) < 18 || getAge(p1) >= 65) && !(getAge(p2) < 18 || getAge(p2) >= 65)) {
                        return -1;
                    } else if (!(getAge(p1) < 18 || getAge(p1) >= 65) && (getAge(p2) < 18 || getAge(p2) >= 65)) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .limit(500)
                .toList();

        assertTrue(evacuees.size() <= 500, "task13: The number of evacuees should not exceed 500");

        evacuees.forEach(person -> System.out.println("task13: " + person));
    }
}

