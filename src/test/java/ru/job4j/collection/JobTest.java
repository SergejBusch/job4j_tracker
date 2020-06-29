package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameDescAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobNameDescSort()
                .thenComparing(new JobPriorityDescSort());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 2)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenCompatorByProrityAscAndNameDesc() {
        Comparator<Job> cmpNamePriority = new JobPriorityAscSort()
                .thenComparing(new JobNameDescSort());
        int rsl = cmpNamePriority.compare(
                new Job("AA", 0),
                new Job("CC", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByDescPrority() {
        Comparator<Job> cmpNamePriority = new JobPriorityDescSort();
        int rsl = cmpNamePriority.compare(
                new Job("AA", 3),
                new Job("CC", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByAscName() {
        int rsl =  new Job("AA", 3).compareTo(new Job("CC", 0));
        assertThat(rsl, lessThan(0));
    }
}