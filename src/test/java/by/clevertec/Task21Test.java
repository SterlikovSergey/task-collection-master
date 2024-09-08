package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task21Test {

    @Test
    public void testTask21() {
        List<Student> students = Util.getStudents();

        Map<String, Long> expectedStudentCountByGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));

        Map<String, Long> actualStudentCountByGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));

        assertEquals(expectedStudentCountByGroup, actualStudentCountByGroup, "task21: Student count by group should be correctly calculated");

        actualStudentCountByGroup.forEach((group, count) ->
                System.out.println("task21: Group: " + group + ", Number of Students: " + count));
    }
}
