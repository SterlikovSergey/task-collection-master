package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Task16Test {

    @Test
    public void testTask16() {
        List<Student> students = Util.getStudents();
        List<Student> filteredAndSortedStudents = students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .toList();

        assertTrue(filteredAndSortedStudents.stream().allMatch(student -> student.getAge() < 18), "task16: All students should be younger than 18");

        for (int i = 1; i < filteredAndSortedStudents.size(); i++) {
            assertTrue(filteredAndSortedStudents.get(i - 1).getSurname().compareTo(filteredAndSortedStudents.get(i).getSurname()) <= 0, "task16: Students should be sorted by surname");
        }

        filteredAndSortedStudents.forEach(student -> System.out.println("task16 : " + student.getSurname() + ", Age: " + student.getAge()));
    }
}

