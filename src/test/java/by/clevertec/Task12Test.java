package by.clevertec;

import by.clevertec.model.Person;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Task12Test {

    @Test
    public void testTask12() {
        List<Person> persons = Util.getPersons();
        List<Person> selectedPersons = persons.stream()
                .filter(person -> "Male".equals(person.getGender()))
                .filter(person -> {
                    LocalDate birthday = person.getDateOfBirth();
                    int age = Period.between(birthday, LocalDate.now()).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .toList();

        assertTrue(selectedPersons.size() <= 200, "The number of selected persons should not exceed 200");
        assertTrue(selectedPersons.stream().allMatch(person -> "Male".equals(person.getGender())), "All selected persons should be male");
        assertTrue(selectedPersons.stream().allMatch(person -> {
            int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
            return age >= 18 && age <= 27;
        }), "task12: All selected persons should be between 18 and 27 years old");
        assertTrue(isSortedByRecruitmentGroup(selectedPersons), "task12: Persons should be sorted by recruitment group");

        selectedPersons.forEach(person -> System.out.println("task12: " + person));
    }

    private boolean isSortedByRecruitmentGroup(List<Person> persons) {
        for (int i = 1; i < persons.size(); i++) {
            if (persons.get(i).getRecruitmentGroup() < persons.get(i - 1).getRecruitmentGroup()) {
                return false;
            }
        }
        return true;
    }
}


