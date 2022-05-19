package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);
    static int coffee = 100, milk = 100, water = 1000, bin = 0; // модификатор доступа (видимость данных и методов только внутри объявленного класса)
    final int COFFEE_MAX = 501, MILK_MAX = 200, WATER_MAX = 2000, BIN_MAX = 100;
    static int Coffee_Count = 0; //счетчик кофе

    public CoffeeMachine() {
    }
    private void setCoffee() {
        System.out.println("Кофе(мг) " + String.format("%d", coffee));
        System.out.println("Введите сколько кофе добавить(мг)");
        int volumeCoffee = scan.nextInt();
        if (coffee + volumeCoffee > COFFEE_MAX) {
            System.out.println("Столько кофе не могу добавить, максимальный объем 500 мг.");
        } else {
            coffee = coffee + volumeCoffee;
            System.out.println("Добавляю кофе \n \n \n");
        }
    }
    private void setMilk() {
        System.out.println("Молоко(мл) " + String.format("%d", milk));
        System.out.println("Введите сколько молока добавить(мл)");
        int volumeMilk = scan.nextInt();
        if (milk + volumeMilk > MILK_MAX) {
            System.out.println("Столько молока не могу добавить, максимальный объем 200 мг.\n \n \n");
        } else {
            milk = milk + volumeMilk;
            System.out.println("Добавляю молоко \n \n \n");
        }
    }
    private void setWater() {
        System.out.println("Вода(мл) " + String.format("%d", water));
        System.out.println("Введите сколько воды добавить(мл)");
        int volumeWater = scan.nextInt();
        if (water + volumeWater > WATER_MAX) {
            System.out.println("Столько воды не могу добавить, максимальный объем 2000 мг.\n \n \n");
        } else {
            water = water + volumeWater;
            System.out.println("Добавляю воду \n \n \n");
        }
    }
    private void GetIngredient() { //getтеры возвращают значение
        System.out.println("Кофе(мг) " + String.format("%d", coffee));// %.1f указывает число в строке с одним числом после запятой
        System.out.println("Молоко(мл) " + String.format("%d", milk));
        System.out.println("Вода(мл) " + String.format("%d", water));
    }
    private void CleanMachine() {
        if (bin > 50) {
            System.out.println("Очистка Кофемашины\n \n \n");
            coffee = 0;
            milk = 0;
            water = 0;
            bin = 0;
        } else {
            System.out.println("Очистка не требуется \n \n \n");
        }
    }
    private void Espresso() {
        System.out.println("Сколько порций кофе вам необходимо? \n 1. 3 порции \n 2.Ввести нужное количество \n 3.Рецепт Espresso");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                this.addEspresso();
                break;
            case 2:
                this.addEspressoChoice();
                break;
            case 3:
                System.out.println("Рецепт Espresso:\n 1.Коффе 10гр;\n 3.Вода 30мл;\n \n \n");
                break;
            default:
                System.out.println("Выберите значение 1 или 2 \n \n \n" );
        }
    }
    private void addEspresso() {
        if (coffee >= 30 && water >= 90 && bin < 15) {
            System.out.println("Делаю Espresso");
            System.out.println("Добавляю кофе");
            coffee = coffee - 30;
            System.out.println("Добавляю воду");
            water = water - 90;
            bin = bin + 15;
            System.out.println("Кофе готово\n \n \n");
            coffee++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины!");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
    }
    private void addEspressoChoice() {
        int choiceVoliume = scan.nextInt();
        if (coffee >= 10 * choiceVoliume && water >= 30 * choiceVoliume && bin < 5 * choiceVoliume) {
            System.out.println("Делаю Espresso");
            System.out.println("Добавляю 10 грамм кофе");
            coffee = coffee - (10 * choiceVoliume);
            System.out.println("Добавляю 0,2 л воды");
            water = water - (30 * choiceVoliume);
            bin = bin + (5 * choiceVoliume);
            System.out.println("Кофе готово\n \n \n");
            coffee++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины!");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
    }
    private void Cappuccino() {
        System.out.println("Сколько порций кофе вам необходимо? \n 1. 3 порции \n 2.Ввести нужное количество \n 3.Рецепт Cappuccino");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                this.addCappuccino();
                break;
            case 2:
                this.addCappuccinoChoice();
                break;
            case 3:
                System.out.println("Рецепт Cappuccino\n 1.Коффе 10гр;\n 2.Молоко 5мл; \n 3.Вода 50мл;\n \n \n");
                break;
            default:
                System.out.println("Выберите значение\n \n \n");
        }
    }
    private void addCappuccino() {
        if (coffee > 30 && milk > 15 && water > 150 && bin < 15) {
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю 30грамм кофе");
            coffee = coffee - 30;
            System.out.println("Добавляю 15мл молока");
            milk = milk - 15;
            System.out.println("Добавляю 150мл воды");
            water = water - 150;
            bin = bin + 15;
            System.out.println("Cappuccino готово! \n \n \n");
            Coffee_Count++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Молоко(литр) " + String.format("%d", milk));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины!");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
            }
        }
    private void addCappuccinoChoice() {
        int choiceVoliume = scan.nextInt();
        if (coffee >= 10 * choiceVoliume && milk >= 5 * choiceVoliume && water >= 50 * choiceVoliume && bin < 5 * choiceVoliume) {
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю кофе");
            coffee = coffee - (10 * choiceVoliume) ;
            System.out.println("Добавляю молоко");
            milk = milk - (5 * choiceVoliume);
            System.out.println("Добавляю воду");
            water = water - (50 * choiceVoliume);
            bin = bin + (5 * choiceVoliume);
            System.out.println("Cappuccino готово! \n \n \n");
            Coffee_Count++;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Молоко(литр) " + String.format("%d", milk));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
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
                    break;
                case '2':
                    this.Espresso();
                case '3':
                    this.setCoffee();
                    break;
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

