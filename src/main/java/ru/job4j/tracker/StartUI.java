package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                System.out.println("=== All items ====");
                for (Item item : items) {
                    System.out.println("id: " + item.getId() + " name: " + item.getName());
                }
                System.out.println();
            } else if (select == 2) {
                System.out.print("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Found: id - " + item.getId() + ", name - " + item.getName());
                    System.out.print("Set new name: ");
                    String newName = scanner.nextLine();
                    Item newItem = new Item();
                    newItem.setName(newName);
                    tracker.replace(id, newItem);
                    System.out.println("Successfully saved");
                } else {
                    System.out.println("Item not found");
                }
                System.out.println();

            } else if (select == 3) {
                System.out.print("Enter id of the item you want to delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("successfully deleted");
                } else {
                    System.out.println("Item not found");
                }
                System.out.println();
            } else if (select == 4) {
                System.out.print("Enter id of the item you want to find: ");
                int input = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(input);
                if(item != null) {
                    System.out.println("Found: id - " + item.getId() + " name - " + item.getName());
                } else {
                    System.out.println("Item not found");
                }
                System.out.println();
            } else if (select == 5) {
                System.out.print("Enter name of the item(s) you want to find: ");
                String input = scanner.nextLine();
                Item[] items = tracker.findByName(input);
                if (items[0] != null) {
                    for(Item item : items) {
                        System.out.println("Found: id - " + item.getId() + " name - " + item.getName());
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}