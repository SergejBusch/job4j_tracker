package ru.job4j.tracker;


public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                System.out.println("=== All items ====");
                for (Item item : items) {
                    System.out.println(item.toString());
                }
                System.out.println();
            } else if (select == 2) {
                int id = input.askInt("Enter id: ");
                Item item = new Item();
                item.setName(input.askStr("Set new name: "));
                if (tracker.replace(id, item)) {
                    System.out.println("Successfully saved");
                } else {
                    System.out.println("Item not found");
                }
                System.out.println();

            } else if (select == 3) {
                int id = input.askInt("Enter id of the item you want to delete: ");
                if (tracker.delete(id)) {
                    System.out.println("successfully deleted");
                } else {
                    System.out.println("Item not found");
                }
                System.out.println();
            } else if (select == 4) {
                int id = input.askInt("Enter id of the item you want to find: ");
                Item item = tracker.findById(id);
                if(item != null) {
                    System.out.println("Found: " + item.toString());
                } else {
                    System.out.println("Item not found");
                }
                System.out.println();
            } else if (select == 5) {
                String name = input.askStr("Enter name of the item(s) you want to find: ");
                Item[] items = tracker.findByName(name);
                if (items[0] != null) {
                    for(Item item : items) {
                        System.out.println("Found: " + item.toString());
                    }
                } else {
                    System.out.println("Nothing not found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println();
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}