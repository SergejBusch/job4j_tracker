package ru.job4j.tracker;

public class EditAction  implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = new Item();
        item.setName(input.askStr("Set new name: "));
        if (tracker.replace(id, item)) {
            System.out.println("Successfully saved");
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
