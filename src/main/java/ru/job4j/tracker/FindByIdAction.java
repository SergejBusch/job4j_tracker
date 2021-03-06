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
    public boolean execute(Input input, MemTracker memTracker) {
        int id = input.askInt("Enter id of the item you want to find: ");
        Item item = memTracker.findById(id);
        if (item != null) {
            out.println("Found: " + item.toString());
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
