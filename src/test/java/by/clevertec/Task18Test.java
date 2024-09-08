package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task18Test {

    @Test
    public void testTask18() {
        List<Student> students = Util.getStudents();

        Map<String, Double> expectedAverageAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(Student::getAge)));

        Map<String, Double> actualAverageAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(Student::getAge)));

        assertEquals(expectedAverageAgeByFaculty, actualAverageAgeByFaculty, "Average age by faculty should be correctly calculated");

        actualAverageAgeByFaculty.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.println("task18: Faculty: " + entry.getKey() + ", Average Age: " + entry.getValue()));
    }
}
