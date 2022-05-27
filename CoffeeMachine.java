package CoffeeMachine;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);
    static int coffee = 100, milk = 100, water = 1000, bin = 0;
    final int COFFEE_MAX = 501, MILK_MAX = 200, WATER_MAX = 2000;
    static int Coffee_Count = 0;
    static int Coffee_Count1 = 0;


    private static final Logger logger = Logger.getLogger(CoffeeMachine.class.getName());

    enum Cappuccino_Rice{
        WATER(50),
        COFFEE(10),
        MILK(5);
        private final int value;
        Cappuccino_Rice(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    enum Espresso_Rice{
        WATER(30),
        COFFEE(10);

        private final int value_1;
        Espresso_Rice(int value_1) {
            this.value_1 = value_1;
        }
        public int getValue() {
            return value_1;
        }
    }

    public CoffeeMachine(){
    }

    private void setCoffee() {
        System.out.println("Кофе(мг) " + String.format("%d", coffee));
        System.out.println("Введите сколько кофе добавить(мг)");
        int volumeCoffee = scan.nextInt();
        if (coffee + volumeCoffee > COFFEE_MAX) {
            System.out.println("Можно добавить max:  " + (COFFEE_MAX - coffee) + " мг \n \n \n");
        } else {
            coffee = coffee + volumeCoffee;
            logger.info("Добавлено" + volumeCoffee + "мг кофе");
            System.out.println("Добавляю кофе \n \n \n");
        }
    }

    private void setMilk() {
        System.out.println("Молоко(мл) " + String.format("%d", milk));
        System.out.println("Введите сколько молока добавить(мл)");
        int volumeMilk = scan.nextInt();
        if (milk + volumeMilk > MILK_MAX) {
            System.out.println("Можно добавить max:  " + (MILK_MAX - milk) + " мл \n \n \n");
        } else {
            milk = milk + volumeMilk;
            logger.info("Добавлено" + volumeMilk + " мл молока");
            System.out.println("Добавляю молоко \n \n \n");
        }
    }

    private void setWater() {
        System.out.println("Вода(мл) " + String.format("%d", water));
        System.out.println("Введите сколько воды добавить(мл)");
        int volumeWater = scan.nextInt();
        if (water + volumeWater > WATER_MAX) {
            System.out.println("Можно добавить max:  " + (WATER_MAX - water) + " мл \n \n \n");
        } else {
            water = water + volumeWater;
            logger.info("Добавлено" + volumeWater + " мл воды");
            System.out.println("Добавляю воду \n \n \n");
        }
    }

    private void setCleanMachine() {
        System.out.println("Корзина(%)  " + String.format("%d", bin));
        if (bin > 70) {
            System.out.println("Очистка Кофемашины\n \n \n");
            bin = 0;
            logger.info("Очистка машины");
        } else {
            System.out.println("Очистка не требуется \n \n \n");
        }
    }

    private void GetIngredient() {
        System.out.println("Кофе(мг) " + String.format("%d", coffee));
        System.out.println("Молоко(мл) " + String.format("%d", milk));
        System.out.println("Вода(мл) " + String.format("%d", water));
        System.out.println("Корзина(%)  " + String.format("%d", bin));
    }

    private void Espresso() {
        System.out.println("Сколько порций кофе вам необходимо? \n 1. 3 порции \n 2.Ввести нужное количество \n 3.Рецепт Espresso");
        int choice = scan.nextInt();
        ;
        boolean end = false;
        for (int i = 1; i <= 3; i++) {
            if (end)
                break;
            switch (choice) {
                case 1:
                    this.addEspresso();
                    end = true;
                    break;
                case 2:
                    this.addEspressoChoice();
                    end = true;
                    break;
                case 3:
                    System.out.println("Рецепт Espresso:" + Espresso_Rice.WATER + Espresso_Rice.WATER.getValue() + "\n" + Espresso_Rice.COFFEE + Espresso_Rice.COFFEE.getValue() + "\n \n \n");
                    logger.info("Выведен рецепт");
                    end = true;
                    break;
                default:
                    System.out.println("Выберите значение  \n \n \n");
            }
        }
    }

    private void addEspresso() {
        if (coffee >= 30 && water >= 90 && bin <= 15) {
            System.out.println("Делаю Espresso");
            System.out.println("Добавляю кофе");
            coffee = coffee - 30;
            System.out.println("Добавляю воду");
            water = water - 90;
            bin = bin + 15;
            System.out.println("Кофе готово\n \n \n");
            logger.info("Приготовлено 3 порции Espresso");
            Coffee_Count1 = Coffee_Count1 + 3;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины! " + String.format("%d", bin) + " %");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
    }

    private void addEspressoChoice() {
        int choiceVoliume = scan.nextInt();
        if (coffee >= 10 * choiceVoliume && water >= 30 * choiceVoliume && bin <= (5 * choiceVoliume)) {
            System.out.println("Делаю Espresso");
            System.out.println("Добавляю 10 грамм кофе");
            coffee = coffee - (10 * choiceVoliume);
            System.out.println("Добавляю 0,2 л воды");
            water = water - (30 * choiceVoliume);
            bin = bin + (5 * choiceVoliume);
            System.out.println("Кофе готово\n \n \n");
            logger.info("Приготовлено" + choiceVoliume + "порции Espresso");
            Coffee_Count1 = Coffee_Count1 + choiceVoliume;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины! " + String.format("%d", bin) + " %");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
    }

    public void allCoffee() {
        System.out.println("Всего приготовлено Espresso: " + Coffee_Count1 + " шт\n \n \n");
        System.out.println("Всего приготовлено Cappuccino: " + Coffee_Count + " шт\n \n \n");
    }

    private void Cappuccino() {
        System.out.println("Сколько порций кофе вам необходимо? \n 1. 3 порции \n 2.Ввести нужное количество \n 3.Рецепт Cappuccino\n ");
        int choice = scan.nextInt();
        boolean end = false;
        for (int i = 1; i <= 4; i++) {
            if (end)
                break;
            switch (choice) {
                case 1:
                    this.addCappuccino();
                    end = true;
                    break;
                case 2:
                    this.addCappuccinoChoice();
                    end = true;
                    break;
                case 3:
                    System.out.println("Рецепт Cappuccino \n" + Cappuccino_Rice.WATER + Cappuccino_Rice.WATER.getValue() + "\n" + Cappuccino_Rice.COFFEE + Cappuccino_Rice.COFFEE.getValue() + "\n" + Cappuccino_Rice.MILK + Cappuccino_Rice.MILK.getValue()  + "\n \n \n");
                    end = true;
                    logger.info("Выведен рецепт");
                    break;
                default:
                    System.out.println("Выберите значение\n \n \n");
            }
        }
    }
    private void addCappuccino() {
        if (coffee >= 30 && milk >= 15 && water >= 150 && bin <= 15) {
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю 30грамм кофе");
            coffee = coffee - 30;
            System.out.println("Добавляю 15мл молока");
            milk = milk - 15;
            System.out.println("Добавляю 150мл воды");
            water = water - 150;
            bin = bin + 15;
            System.out.println("Cappuccino готово! \n \n \n");
            Coffee_Count = Coffee_Count + 3;
            logger.info("Приготовлено 3 порции Cappuccino");
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Молоко(литр) " + String.format("%d", milk));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины! " + String.format("%d", bin) + " %");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
    }

    private void addCappuccinoChoice() {
        int choiceVoliume = scan.nextInt();
        if (coffee >= 10 * choiceVoliume && milk >= 5 * choiceVoliume && water >= 50 * choiceVoliume && bin <= (5 * choiceVoliume)){
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю кофе");
            coffee = coffee - (10 * choiceVoliume);
            System.out.println("Добавляю молоко");
            milk = milk - (5 * choiceVoliume);
            System.out.println("Добавляю воду");
            water = water - (50 * choiceVoliume);
            bin = bin + (5 * choiceVoliume);
            System.out.println("Cappuccino готово! \n \n \n");
            logger.info("Приготовлено" + choiceVoliume + "порции Cappuccino");
            Coffee_Count = Coffee_Count + choiceVoliume;
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Молоко(литр) " + String.format("%d", milk));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины! " + String.format("%d", bin) + " %");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
    }

    public void addProfile() {
        /*Scanner scanner = new Scanner(System.in);
        Hashmap<String, Hashmap<String, Integer>> profile =  new Hashmap<>();
        System.out.println ("Введите имя ");
        String choice = scanner.nextLine();
        System.out.println ("Введите какой напиток вы предпочитаете: ? ");
        System.out.println ("Введите сколько порций вам добавить в профиль? ");
        int volt = scanner.nextInt();
        profile.put(choice, volt);
        System.out.println("Профиль добавлен:" + profile);*/

        System.out.println("Выберите пнукт меню: \n 1.Cappuccino \n 2.Espresso ");
        int choice = scan.nextInt();
        boolean end = false;
        for (int i = 1; i <= 4; i++) {
            if (end)
                break;
            switch (choice) {
                case 1:
                    this.addCappuccinoPerson();
                    end = true;
                    break;
                case 2:
                    this.addEspressoPerson();
                    end = true;
                    break;
                case 3:
                    this.addChoiceProfile();
                    end = true;
                    break;
                default:
                    System.out.println("Выберите пунк меню\n \n \n");
            }
        }
    }
    public void addCappuccinoPerson(){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> profile = new HashMap<>();
        System.out.println ("Введите имя ");
        String choice = scanner.nextLine();
        System.out.println ("Введите сколько порций вам добавить в профиль? ");
        int volt = scanner.nextInt();
        profile.put(choice, volt);
        System.out.println("Профиль добавлен:" + profile);
        }
    public  void addEspressoPerson() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> profile1 = new HashMap<>();
        System.out.println ("Введите имя ");
        String choice = scanner.nextLine();
        System.out.println ("Введите сколько порций вам добавить в профиль? ");
        int volt = scanner.nextInt();
        profile1.put(choice, volt);
        System.out.println("Профиль добавлен:" + profile1);
    }
    public void addChoiceProfile(){
        System.out.println ("Введите имя своего профиля: ");
        System.out.println();
    }
    public void startIO() {
        System.out.println("Выберите операцию!");
        boolean t = true;
        while (t) {
            this.GetIngredient();
            System.out.println(" 1.Cappuccino \n 2.Espresso \n 3.Добавить кофе \n 4.Добавить молоко \n 5.Добавить воду \n 6.Очистить \n 7.Количество приготовленного кофе \n 8.Добавить профиль  \n 9.Выключить  ");
            char c = CoffeeMachine.scan.next().charAt(0);
            switch (c) {
                case '1':
                    this.Cappuccino();
                    break;
                case '2':
                    this.Espresso();
                    break;
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
                    this.setCleanMachine();
                    break;
                case '7':
                    this.allCoffee();
                    break;
                case '8':
                    this.addProfile();
                    break;
                case '9':
                    System.out.println("Выключить");
                    t = false;
                    break;
            }
        }
    }
    static class MakeCoffee {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            System.out.println("Включить кофемашину Y или N?");
            try {
                char press = scan.next().charAt(0);
                if (press == 'Y' || press == 'y' || press == 'н' || press == 'Н') {
                    CoffeeMachine cm = new CoffeeMachine();
                    logger.info("Кофемашина запущена");
                    cm.startIO();
                    System.out.println("Кофемашина выключена");
                } else
                    System.out.println("Кофемашина выключена!");
                throw new IllegalStateException("Неверно введена команда!");
            } catch (IllegalStateException a) {
                a.printStackTrace();
                    System.out.println("Для включения нажмите Y");
            }
        }
    }
}
