package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        input.nextLine();
        int number = new Random().nextInt(3);
        if (number == 0) {
            System.out.println("yes");
        } else if (number == 1) {
            System.out.println("no");
        } else {
            System.out.println("maybe");
        }

    }
}
