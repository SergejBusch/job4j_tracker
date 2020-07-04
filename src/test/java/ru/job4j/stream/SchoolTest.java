package ru.job4j.stream;

import org.junit.Assert;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SchoolTest {
    private List<Student> studentList = new ArrayList<>(List.of(
            new Student("Bobbi", 10),
            new Student("Toni", 60),
            new Student("Franc", 80)
    ));
    @Test
    public void whenScoreRangeFrom70until100() {
        Predicate<Student> from = Student -> Student.getScore() >= 70;
        Predicate<Student> until = Student -> Student.getScore() <= 100;
        Predicate<Student> combine = from.and(until);
        List<Student> students = new School()
                .collect(studentList, combine);
        Assert.assertThat(students, is(new ArrayList<>(
                List.of(new Student("Franc", 80)))));
    }

    @Test
    public void whenScoreRangeFrom50until70() {
        Predicate<Student> from = Student -> Student.getScore() >= 50;
        Predicate<Student> until = Student -> Student.getScore() <= 70;
        Predicate<Student> combine = from.and(until);
        List<Student> students = new School()
                .collect(studentList, combine);
        Assert.assertThat(students, is(new ArrayList<>(
                List.of(new Student("Toni", 60)))));
    }

    @Test
    public void whenScoreRangeFrom0until50() {
        Predicate<Student> from = Student -> Student.getScore() >= 0;
        Predicate<Student> until = Student -> Student.getScore() <= 50;
        Predicate<Student> combine = from.and(until);
        List<Student> students = new School()
                .collect(studentList, combine);
        Assert.assertThat(students, is(new ArrayList<>(
                List.of(new Student("Bobbi", 10)))));
    }
}
