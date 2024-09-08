package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task22Test {

    @Test
    public void testTask22() {
        List<Student> students = Util.getStudents();

        Map<String, Optional<Integer>> expectedMinAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.mapping(Student::getAge, Collectors.minBy(Integer::compareTo))
                ));

        Map<String, Optional<Integer>> actualMinAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.mapping(Student::getAge, Collectors.minBy(Integer::compareTo))
                ));

        assertEquals(expectedMinAgeByFaculty, actualMinAgeByFaculty, "task22: Min age by faculty should be correctly calculated");

        actualMinAgeByFaculty.forEach((faculty, minAge) ->
                System.out.println("task22: Faculty: " + faculty + ", Min Age: " + minAge.orElse(-1))
        );
    }
}
