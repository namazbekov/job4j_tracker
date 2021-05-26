package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
            String name = input.nextLine();
            int answer = new Random().nextInt(3);
            if (name.equals("end") || name.equals("хватит")) {
            } else if (answer == 1) {
                System.out.println("Нет");
            } else if (answer == 0) {
                System.out.println("Да");
            } else {
                System.out.println("Может быть");
            }
        }

    }
}
