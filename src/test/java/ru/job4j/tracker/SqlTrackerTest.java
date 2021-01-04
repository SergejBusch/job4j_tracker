package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    public Connection init() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(10);
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    @Test
    public void whenCreateItem() throws Exception {
        try (var tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void whenAddThenReplaceName() throws Exception {
        try (var tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            var item = tracker.add(new Item("W"));
            var item2 = new Item("R");
            boolean result = tracker.replace(String.valueOf(item.getId()), item2);
            assertThat(result, is(true));
        }
    }

    @Test
    public void whenAddThenDelete() throws Exception {
        try (var tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            var item = tracker.add(new Item("O"));
            var item2 = new Item("R");
            boolean result = tracker.delete(String.valueOf(item.getId()));
            assertThat(result, is(true));
        }
    }

    @Test
    public void whenAddThenFindByName() throws Exception {
        try (var tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            var item = tracker.add(new Item("OOO"));
            List<Item> result = tracker.findByName("OOO");
            assertThat(result, Matchers.notNullValue());
        }
    }

    @Test
    public void whenAddThenFindById() throws Exception {
        try (var tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.init();
            var item = tracker.add(new Item("AAA"));
            Item result = tracker.findById(String.valueOf(item.getId()));
            assertThat(result, is(item));
        }
    }

    @Test
    public void whenOutOfMemory() throws InterruptedException {
        var list = new LinkedList<>();
        while (true) {
            list.add(new int[65536]); // an arbitrary number
            TimeUnit.SECONDS.sleep(7);
        }
    }
}
