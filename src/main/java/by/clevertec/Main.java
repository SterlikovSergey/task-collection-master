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
import java.util.stream.Collectors;

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
        animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .forEach(animal -> System.out.println("task1: " + animal));
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
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        flowers.stream()
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
                .forEach(flower -> System.out.println("task15: " + flower));
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
