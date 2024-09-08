package by.clevertec;

import by.clevertec.model.Examination;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task20Test {

    @Test
    public void testTask20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        Map<String, Double> expectedAverageScoreByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingDouble(student -> examinations.stream()
                                .filter(exam -> exam.getStudentId() == student.getId())
                                .mapToInt(Examination::getExam1)
                                .average()
                                .orElse(0.0)
                        )
                ));

        Optional<Map.Entry<String, Double>> expectedMaxAverageScoreFaculty = expectedAverageScoreByFaculty.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        Map<String, Double> actualAverageScoreByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingDouble(student -> examinations.stream()
                                .filter(exam -> exam.getStudentId() == student.getId())
                                .mapToInt(Examination::getExam1)
                                .average()
                                .orElse(0.0)
                        )
                ));

        Optional<Map.Entry<String, Double>> actualMaxAverageScoreFaculty = actualAverageScoreByFaculty.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        assertEquals(expectedMaxAverageScoreFaculty, actualMaxAverageScoreFaculty, "task20: Faculty with max average score should be correctly calculated");

        actualMaxAverageScoreFaculty.ifPresent(entry ->
                System.out.println("task20: Faculty: " + entry.getKey() + ", Average Score: " + entry.getValue())
        );
    }
}
