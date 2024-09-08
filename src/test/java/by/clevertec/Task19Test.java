package by.clevertec;

import by.clevertec.model.Examination;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task19Test {

    @Test
    public void testTask19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        String group = "C-2";

        List<Student> expectedFilteredStudents = students.stream()
                .filter(student -> student.getGroup().equals(group))
                .filter(student -> examinations.stream()
                        .anyMatch(exam -> exam.getStudentId() == student.getId() && exam.getExam3() > 4))
                .toList();

        List<Student> actualFilteredStudents = students.stream()
                .filter(student -> student.getGroup().equals(group))
                .filter(student -> examinations.stream()
                        .anyMatch(exam -> exam.getStudentId() == student.getId() && exam.getExam3() > 4))
                .toList();

        assertEquals(expectedFilteredStudents, actualFilteredStudents, "task19: Filtered students should be correctly calculated");

        actualFilteredStudents.forEach(student -> System.out.println("task19: Student: " + student.getSurname() + ", Age: " + student.getAge() + ", Group: " + student.getGroup()));
    }
}
