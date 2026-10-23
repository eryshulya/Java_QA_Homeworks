package org.example;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>(); //коллекция объектов класса student

        students.add(new Student("Анна", "QA-1", 1,
                Map.of("Java", 5, "SQL", 4, "Testing", 5)));

        students.add(new Student("Иван", "QA-1", 2,
                Map.of("Java", 2, "SQL", 3, "Testing", 2)));

        students.add(new Student("Мария", "QA-2", 2,
                Map.of("Java", 3, "SQL", 3, "Testing", 3)));

        students.add(new Student("Алексей", "QA-2", 5,
                Map.of("Java", 4, "SQL", 5, "Testing", 4)));

        students.add(new Student("Елена", "QA-3", 6,
                Map.of("Java", 2, "SQL", 2, "Testing", 3)));
        Set<Student> st = Student.delete(students); // удаляем студентов со средним баллом меньше 3
        Student.transferStudents(st); // переводим студентов на следующий курс со средним баллом больше или равно 3
       Student.printStudents(st,3);// печатаем тех, кто учится на данном курсе
        }
    }
