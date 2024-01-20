package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) { //привет, Кирилл! Здесь находится один из нюансов, на который ты обращаешь внимание, в этом месте у тебя работает некорректно, хотя у меня все правильно рабоет. Честно :) Если что, я сижу на 11 JDK.

                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> types = new ArrayList<>();

        String nextItem = scanner.nextLine();
        while (!nextItem.isEmpty()) {
            types.add(nextItem);
            nextItem = scanner.nextLine();
        }

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = dc.generateCombo(types);
            System.out.println("Комбинация " + (i + 1) + ": " + combo);
        }
    }
}