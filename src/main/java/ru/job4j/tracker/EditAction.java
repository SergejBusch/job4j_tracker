package ru.job4j.tracker;

public class EditAction  implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int id = input.askInt("Enter id: ");
        Item item = new Item();
        item.setName(input.askStr("Set new name: "));
        if (memTracker.replace(id, item)) {
            out.println("Successfully saved");
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
