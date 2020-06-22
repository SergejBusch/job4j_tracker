package ru.job4j.tracker;

public class FindByNameAction  implements UserAction {
    @Override
    public String name() {
        return "=== Find by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name of the item(s) you want to find: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for(Item item : items) {
                System.out.println("Found: " + item.toString());
            }
        } else {
            System.out.println("Nothing found");
        }
        return true;
    }
}
