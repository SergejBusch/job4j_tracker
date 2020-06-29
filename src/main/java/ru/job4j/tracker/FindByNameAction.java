package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction  implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name of the item(s) you want to find: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println("Found: " + item.toString());
            }
        } else {
            out.println("Nothing found");
        }
        return true;
    }
}
