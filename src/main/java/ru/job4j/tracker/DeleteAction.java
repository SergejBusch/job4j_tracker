package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id of the item you want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("successfully deleted");
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
