package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Map<String, Student> studentMap = (List.of(
                new Student("Smith", 50),
                new Student("Fisher", 66))
                .stream()
                .collect(Collectors.toMap(
                                Student::getSurname,
                                student -> student
                )));
    }
}

