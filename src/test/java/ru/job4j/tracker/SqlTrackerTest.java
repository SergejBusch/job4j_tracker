package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    @Test
    public void whenAddNewItem() {
        var sqlTracker = new SqlTracker();
        sqlTracker.init();
        var item = new Item("X");
        var result = sqlTracker.add(item);
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenAddThenReplaceName() {
        var sqlTracker = new SqlTracker();
        sqlTracker.init();
        var item = sqlTracker.add(new Item("W"));
        var item2 = new Item("R");
        boolean result = sqlTracker.replace(String.valueOf(item.getId()), item2);
        assertThat(result, is(true));
    }

    @Test
    public void whenAddThenDelete() {
        var sqlTracker = new SqlTracker();
        sqlTracker.init();
        var item = sqlTracker.add(new Item("O"));
        var item2 = new Item("R");
        boolean result = sqlTracker.delete(String.valueOf(item.getId()));
        assertThat(result, is(true));
    }

    @Test
    public void whenAddThenFindByName() {
        var sqlTracker = new SqlTracker();
        sqlTracker.init();
        var item = sqlTracker.add(new Item("OOO"));
        List<Item> result = sqlTracker.findByName("OOO");
        assertThat(result, Matchers.notNullValue());
    }

    @Test
    public void whenAddThenFindById() {
        var sqlTracker = new SqlTracker();
        sqlTracker.init();
        var item = sqlTracker.add(new Item("AAA"));
        Item result = sqlTracker.findById(String.valueOf(item.getId()));
        assertThat(result, is(item));
    }
}
