package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int id = input.askInt("Enter id of the item you want to delete: ");
        if (memTracker.delete(id)) {
            out.println("successfully deleted");
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
