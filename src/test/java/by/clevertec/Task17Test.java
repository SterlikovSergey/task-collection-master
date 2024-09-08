package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task17Test {

    @Test
    public void testTask17() {
        List<Student> students = Util.getStudents();
        List<String> uniqueGroups = students.stream()
                .map(Student::getGroup)
                .distinct()
                .toList();

        long distinctCount = uniqueGroups.stream().distinct().count();
        assertEquals(uniqueGroups.size(), distinctCount, "task17: All groups should be unique");


        uniqueGroups.forEach(System.out::println);
    }
}

