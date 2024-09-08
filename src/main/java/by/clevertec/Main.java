package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;

import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
        List<Animal> youngAnimals = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .collect(Collectors.toList());

        List<Animal> thirdZooAnimals = IntStream.range(0, youngAnimals.size())
                .filter(i -> (i / 7) == 2) // 2 because we need the third zoo (index starts from 0)
                .mapToObj(youngAnimals::get)
                .collect(Collectors.toList());

        thirdZooAnimals.forEach(animal -> System.out.println("task1: " + animal));
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> {
                    if ("Female".equals(animal.getGender())) {
                        return animal.getBread().toUpperCase();
                    } else {
                        return animal.getBread();
                    }
                })
                .forEach(animal -> System.out.println("task2: " + animal));
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() >= 30)
                .map(Animal::getOrigin)
                .filter(animal -> animal.startsWith("A"))
                .distinct()
                .forEach(animal -> System.out.println("task3: " + animal));
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        long female = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println("task 4: " + female);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30 && animal.getOrigin().equals("Hungarian"))
                .forEach(animal -> System.out.println("task5: " + animal));
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        boolean allMatchMaleOrFemale = animals.stream()
                .allMatch(animal -> "Male".equals(animal.getGender()) || "Female".equals(animal.getGender()));
        if (allMatchMaleOrFemale) {
            System.out.println("task6" + " allMatchMaleOrFemale");
        } else {
            System.out.println("task6" + " No allMatchMaleOrFemale");
        }
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean oceania = animals.stream()
                .anyMatch(animal -> animal.getOrigin().equals("Oceania"));
        if (oceania) {
            System.out.println("task7" + " oceania");
        } else {
            System.out.println("task7" + " No oceania");
        }
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparingInt(Animal::getAge))
                .ifPresent(animal -> System.out.println("task8: " + animal.getAge()));
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(arr -> arr.length)
                .min()
                .ifPresent(length -> System.out.println("task9: " + length));

    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .map(Animal::getAge)
                .reduce(Integer::sum)
                .ifPresent(age -> System.out.println("task10: " + age));
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> "Indonesian".equals(animal.getOrigin()))
                .mapToDouble(Animal::getAge)
                .average()
                .ifPresent(age -> System.out.println("task11: " + age));
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> {
                    LocalDate birthday = person.getDateOfBirth();
                    int age = Period.between(birthday, LocalDate.now()).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(person -> System.out.println("task12: " + person));
    }

    public static void task13() {
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

        evacuees.forEach(person -> System.out.println("task13: " + person));
    }

    private static int getAge(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }


    public static void task14() {
        List<Car> cars = Util.getCars();
        Map<String, List<Car>> sortedCars = cars.stream()
                .collect(Collectors.groupingBy(car -> {
                    if ("Jaguar".equals(car.getCarMake()) || "White".equals(car.getColor())) {
                        return "Turkmenistan";
                    } else if (car.getMass() <= 1500 && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())) {
                        return "Uzbekistan";
                    } else if ("Black".equals(car.getColor()) && car.getMass() > 4000 || List.of("GMC", "Dodge").contains(car.getCarMake())) {
                        return "Kazakhstan";
                    } else if (car.getReleaseYear() <= 1982 || List.of("Civic", "Cherokee").contains(car.getCarModel())) {
                        return "Kyrgyzstan";
                    } else if (!List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor()) || car.getPrice() > 40000) {
                        return "Russia";
                    } else if (car.getVin().contains("59")) {
                        return "Mongolia";
                    } else {
                        return "Discard";
                    }
                }));

        double totalRevenue = 0;

        for (String country : List.of("Turkmenistan", "Uzbekistan", "Kazakhstan", "Kyrgyzstan", "Russia", "Mongolia")) {
            List<Car> countryCars = sortedCars.getOrDefault(country, List.of());
            int totalMass = countryCars.stream().mapToInt(Car::getMass).sum();
            double transportCost = totalMass / 1000.0 * 7.14;
            totalRevenue += transportCost;
            System.out.println("task14: " + country + ": " + transportCost + " $");
        }

        System.out.println("task14: " + "Total Revenue: " + totalRevenue + " $");
    }


    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        Double totalCost = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed())
                .sorted(Comparator.comparingInt(Flower::getPrice).reversed())
                .sorted(Comparator.comparingDouble(Flower::getWaterConsumptionPerDay).reversed())
                .filter(plant -> {
                    String name = plant.getCommonName().toUpperCase();
                    return name.compareTo("S") >= 0 || name.compareTo("C") <= 0;
                })
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().stream()
                        .anyMatch(material -> material.equals("Aluminum") || material.equals("Steel") || material.equals("Glass")))
                .map(flower -> {
                    double waterCostPerYear = flower.getWaterConsumptionPerDay() * 365 * 1.39;
                    double waterCOstForFiveYears = waterCostPerYear * 5;
                    return flower.getPrice() + waterCOstForFiveYears;
                })
                .reduce((double) 0, Double::sum);
        System.out.println("task15: " + totalCost);
    }


    public static void task16() {
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(student -> student.getAge() < 19)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println("task16: " + student.getSurname() + ", Age: " + student.getAge()));
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        List<String> uniqueGroups = students.stream()
                .map(Student::getGroup)
                .distinct()
                .collect(Collectors.toList());

        uniqueGroups.forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> averageAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(Student::getAge)));

        averageAgeByFaculty.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.println("task18: Faculty: " + entry.getKey() + ", Average Age: " + entry.getValue()));
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        List<Student> filteredStudents = students.stream()
                .filter(student -> false)
                .filter(student -> examinations.stream()
                        .anyMatch(exam -> exam.getStudentId() == student.getId() && exam.getExam3() > 4))
                .toList();

        filteredStudents.forEach(student -> System.out.println("task19: " + "Student: " + student.getSurname() + ", Age: " + student.getAge() + ", Group: " + student.getGroup()));
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<String, Double> averageScoreByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingDouble(student -> examinations.stream()
                                .filter(exam -> exam.getStudentId() == student.getId())
                                .mapToInt(Examination::getExam1)
                                .average()
                                .orElse(0.0)
                        )
                ));

        Optional<Map.Entry<String, Double>> maxAverageScoreFaculty = averageScoreByFaculty.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxAverageScoreFaculty.ifPresent(entry ->
                System.out.println("task20: Faculty: " + entry.getKey() + ", Average Score: " + entry.getValue())
        );
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
        Map<String, Long> studentCountByGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));

        studentCountByGroup.forEach((group, count) ->
                System.out.println("task21: Group: " + group + ", Number of Students: " + count));
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
        Map<String, Optional<Integer>> minAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.mapping(Student::getAge, Collectors.minBy(Integer::compareTo))
                ));

        minAgeByFaculty.forEach((faculty, minAge) ->
                System.out.println("task22: Faculty: " + faculty + ", Min Age: " + minAge.orElse(-1))
        );
    }
}
