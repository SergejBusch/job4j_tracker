package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner input = new Scanner(System.in);
        boolean playerNumber = true;
        while (true) {
            System.out.println("Игрок " + (playerNumber ? 1 : 2) + " ходит");
            System.out.println("возьмите от 1 до 3 спичек");
            int number = input.nextInt();
            if (number > 0 && number < 4) {
                matches -= number;
                System.out.println("Осталось " + matches + " спичек");
                playerNumber = playerNumber ? false : true;
            }
            if (matches <= 0) {
                System.out.println("Игрок " + (playerNumber ? 2 : 1) + " победил");
                break;
            }
        }
    }
}
