package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        System.out.println("=== All items ====");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println();
    }

    public static void editItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = new Item();
        item.setName(input.askStr("Set new name: "));
        if (tracker.replace(id, item)) {
            System.out.println("Successfully saved");
        } else {
            System.out.println("Item not found");
        }
        System.out.println();
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter id of the item you want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("successfully deleted");
        } else {
            System.out.println("Item not found");
        }
        System.out.println();
    }

    public static void findItemById(Input input, Tracker tracker) {
        int id = input.askInt("Enter id of the item you want to find: ");
        Item item = tracker.findById(id);
        if(item != null) {
            System.out.println("Found: " + item.toString());
        } else {
            System.out.println("Item not found");
        }
        System.out.println();
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String name = input.askStr("Enter name of the item(s) you want to find: ");
        Item[] items = tracker.findByName(name);
        if (items[0] != null) {
            for(Item item : items) {
                System.out.println("Found: " + item.toString());
            }
        } else {
            System.out.println("Nothing not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
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