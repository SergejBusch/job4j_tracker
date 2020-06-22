package ru.job4j.tracker;

public class FindByIdAction  implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id of the item you want to find: ");
        Item item = tracker.findById(id);
        if(item != null) {
            System.out.println("Found: " + item.toString());
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
