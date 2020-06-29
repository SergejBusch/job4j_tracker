package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenIncreaseSort() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        tracker.add(item3);
        tracker.add(item2);
        tracker.add(item1);
        Collections.sort(tracker.findAll(), new IncreaseItemSort());
        Assert.assertThat(tracker.findAll(), is(new ArrayList<>(List.of(item1, item2, item3))));
    }

    @Test
    public void whenDecreaseSort() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Collections.sort(tracker.findAll(), new DecreaseItemSort());
        Assert.assertThat(tracker.findAll(), is(new ArrayList<>(List.of(item3, item2, item1))));
    }
}