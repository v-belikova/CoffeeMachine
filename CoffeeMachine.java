package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);
    static double coffee = 0, milk = 0, water = 0, bin = 0; // модификатор доступа (видимость данных и методов только внутри объявленного класса)
    static int Coffee_Count = 0; //счетчик кофе

    public CoffeeMachine() {
    }
    private void setCoffee() {
        if (coffee > 10) {
            System.out.println("Кофе достаточно");
        } else {
            System.out.println("Добавляю кофе");
            coffee = 490.0;
            System.out.println("-------");
            System.out.println("-------");
            System.out.println("-------");
        }
    }
    private void setMilk() {
        if (milk > 0.4) {
            System.out.println("Молока достаточно");
        } else {
            System.out.println("Добавляю молоко");
            milk = 0.6;
            System.out.println("-------");
            System.out.println("-------");
            System.out.println("-------");
        }
    }
    private void setWater() {
        if (water > 0.4) {
            System.out.println("Воды достаточно");
        } else {
            System.out.println("Добавляю воду");
            water = 1.6;
            System.out.println("-------");
            System.out.println("-------");
            System.out.println("-------");
        }
    }
    private void GetIngredient() { //getтеры возвращают значение
        System.out.println("Кофе(грамм) " + String.format("%.1f", coffee));// %.1f указывает число в строке с одним числом после запятой
        System.out.println("Молоко(литр) " + String.format("%.1f", milk));
        System.out.println("Вода(литр) " + String.format("%.1f", water));
    }
    private void CleanMachine() {
        if (bin > 2) {
            System.out.println("Очистка Кофемашины");
            coffee = 0;
            milk = 0;
            water = 0;
            bin = 0;
        } else {
            System.out.println("Очистка не требуется");
            System.out.println("-------");
            System.out.println("-------");
            System.out.println("-------");
        }
    }
    private void Espresso() {
        System.out.println("Сколько порций кофе вам необходимо? \n 1. 3 порции \n 2.Ввести нужное количество");
        int choice = scan.nextInt();
        switch (choice) {
            case '1' -> this.addEspresso();
            case '2' -> this.addEspressoChoice();
            default -> {
                while (choice > 3) {
                    System.out.println("Выберите значение 1 или 2");
                    choice = scan.nextInt();
                }
            }
        }
    }
    private void addEspresso() {
        if (coffee >= 10 && water >= 0.2) {
            System.out.println("Делаю Espresso");
            System.out.println("Добавляю 10 грамм кофе");
            coffee = coffee - 10;
            System.out.println("Добавляю 0,2 л воды");
            water = water - 0.2;
            bin = bin + 0.3;
            System.out.println("Кофе готово");
            coffee++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%.1f", coffee));
            System.out.println("Вода(литр) " + String.format("%.1f", water));
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе");
        }
    }
    private void addEspressoChoice() {
        if (coffee >= 10 && water >= 0.2) {
            System.out.println("Делаю Espresso");
            System.out.println("Добавляю 10 грамм кофе");
            coffee = coffee - 10;
            System.out.println("Добавляю 0,2 л воды");
            water = water - 0.2;
            bin = bin + 0.3;
            System.out.println("Кофе готово");
            coffee++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%.1f", coffee));
            System.out.println("Вода(литр) " + String.format("%.1f", water));
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе");
        }
    }
    private void Cappuccino() {
        System.out.println("Сколько порций кофе вам необходимо? \n 1. 3 порции \n 2.Ввести нужное количество");
        int choice = scan.nextInt();
        switch (choice) {
            case '1' -> this.addCappuccino();
            case '2' -> this.addCappuccinoChoice();
            default -> {
                while(choice > 3) {
                    System.out.println("Выберите значение 1 или 2");
                    choice = scan.nextInt();
                }
            }
        }
    }
    private void addCappuccino() {
        if (coffee >= 30 && milk >= 1.2 && water >= 0.6 && bin <= 1.7) {
            System.out.println("Делаю Cappuccino");
            coffee = coffee - 10;
            milk = milk - 0.4;
            water = water - 0.2;
            bin = bin + 0.3;
            System.out.println("Cappuccino готово!");
            Coffee_Count++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%.1f", coffee));
            System.out.println("Молоко(литр) " + String.format("%.1f", milk));
            System.out.println("Вода(литр) " + String.format("%.1f", water));
            System.out.println("Требуется чистка Кофемашины!");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе");
            }
        }
    private void addCappuccinoChoice() {
        if (coffee >= 10 && milk >= 0.4 && water >= 0.2) {
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю 10грамм кофе");
            coffee = coffee - 10;
            System.out.println("Добавляю 0,4 молока");
            milk = milk - 0.4;
            System.out.println("Добавляю 0,2 л воды");
            water = water - 0.2;
            bin = bin + 0.3;
            System.out.println("Cappuccino готово!");
            Coffee_Count++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%.1f", coffee));
            System.out.println("Молоко(литр) " + String.format("%.1f", milk));
            System.out.println("Вода(литр) " + String.format("%.1f", water));
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе");
        }
    }
    public void start() {
        System.out.println("Выберите операцию!");
        boolean t = true;
        while (t) {
            this.GetIngredient();
            System.out.println(" 1.Cappuccino \n 2.Espresso \n 3.Добавить кофе \n 4.Добавить молоко \n 5.Добавить воду \n 6.Очистить \n 7.Выключить  ");
            char c = CoffeeMachine.scan.next().charAt(0);
            switch (c) {
                case '1':
                    this.Cappuccino();
                case '2':
                    this.Espresso();
                case '3':
                    this.setCoffee();
                case '4':
                    this.setMilk();
                    break;
                case '5':
                    this.setWater();
                    break;
                case '6':
                    this.CleanMachine();
                    break;
                case '7':
                    System.out.println("Выключить");
                    t = false;
                    break;
            }
        }
    }
    static class MakeCoffee {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Включить кофемашину Y или N?");
            char press = scan.next().charAt(0); //charAt() возвращает первое значение выбранное пользователем
            if (press == 'Y' || press == 'y' || press == 'н' || press == 'Н') {
                CoffeeMachine cm = new CoffeeMachine();
                cm.start();
                System.out.println("Кофемашина выключена");
            } else
                System.out.println("Кофемашина выключена");
        }
    }
}

