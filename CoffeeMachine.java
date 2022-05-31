package CoffeeMachine;

import java.util.*;
import java.util.logging.Logger;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);
    static Integer coffee = 100, milk = 100, water = 1000, bin = 0;
    final int COFFEE_MAX = 501, MILK_MAX = 200, WATER_MAX = 2000;
    static int Coffee_Count = 0;
    static int Coffee_Count1 = 0;

    HashMap<String, HashMap<Integer, Integer>> profile =  new HashMap<>();
    static String nameUsers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    static int drinkLove;

    static int volt;

    private static final Logger logger = Logger.getLogger(CoffeeMachine.class.getName());


    enum Cappuccino_Recipe {
        WATER(50),
        COFFEE(10),
        MILK(5);
        private final int value;

        Cappuccino_Recipe(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    enum Espresso_Recipe {
        WATER(30),
        COFFEE(10);

        private final int value_1;

        Espresso_Recipe(int value_1) {
            this.value_1 = value_1;
        }

        public int getValue() {
            return value_1;
        }
    }

    public CoffeeMachine() {
    }

    private void setCoffee() {
        System.out.println("Кофе(мг) " + String.format("%d", coffee));
        System.out.println("Введите сколько кофе добавить(мг)");
        while (!scan.hasNextInt()) scan.next();
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
        try {
            int volumeMilk = scan.nextInt();
            if (milk + volumeMilk > MILK_MAX) {
                System.out.println("Можно добавить max:  " + (MILK_MAX - milk) + " мл \n \n \n");
            } else {
                milk = milk + volumeMilk;
                logger.info("Добавлено" + volumeMilk + " мл молока");
                System.out.println("Добавляю молоко \n \n \n");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Введите корректное значение!");
        }
    }

    private void setWater() {
        try {
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
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Введите корректное значение!");
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
        while (!scan.hasNextInt()) scan.next();
        int choice = scan.nextInt();
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
                    System.out.println("Рецепт Espresso:" + Espresso_Recipe.WATER + Espresso_Recipe.WATER.getValue() + "\n" + Espresso_Recipe.COFFEE + Espresso_Recipe.COFFEE.getValue() + "\n \n \n");
                    logger.info("Выведен рецепт");
                    end = true;
                    break;
                default:
                    System.out.println("Выберите значение  \n \n \n");
            }
        }
    }

    private void addEspresso() {
        if (coffee >= 30 && water >= 90 && bin <= (100 - 15)) {
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
        while (!scan.hasNextInt()) scan.next();
        int choiceVoliume = scan.nextInt();
        if (coffee >= 10 * choiceVoliume && water >= 30 * choiceVoliume && bin <= (100 - (5 * choiceVoliume))) {
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
        while (!scan.hasNextInt()) scan.next();
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
                    System.out.println("Рецепт Cappuccino \n" + Cappuccino_Recipe.WATER + Cappuccino_Recipe.WATER.getValue() + "\n" + Cappuccino_Recipe.COFFEE + Cappuccino_Recipe.COFFEE.getValue() + "\n" + Cappuccino_Recipe.MILK + Cappuccino_Recipe.MILK.getValue() + "\n \n \n");
                    end = true;
                    logger.info("Выведен рецепт");
                    break;
                default:
                    System.out.println("Выберите значение\n \n \n");
            }
        }
    }

    private void addCappuccino() {
        if (coffee >= 30 && milk >= 15 && water >= 150 && bin <= (100 - 15)) {
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
        if (coffee >= 10 * choiceVoliume && milk >= 5 * choiceVoliume && water >= 50 * choiceVoliume && bin <= (100 - (5 * choiceVoliume))) {
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
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> coffeeNumber = new HashMap<>();
        System.out.println("Выберите какой напиток вы предпочитаете:  \n 1.Cappuccino \n 2. Espresso \n 3.Выбрать профиль");
        drinkLove = scanner.nextInt();
        if(drinkLove == 3){
            choiceProfile();
        }
        System.out.println("Введите сколько порций вам добавить в профиль? ");
        volt = scanner.nextInt();
        coffeeNumber.put(drinkLove, volt);
        System.out.println("Введите имя ");
        name = (scanner.next());
        profile.put(name, coffeeNumber);
        System.out.println("Профиль добавлен:" + name + "\n" + profile + "\n");

        System.out.println("Выберите пункт меню: \n 1.Выйти в меню \n 2. Выбрать профиль");
        while (!scan.hasNextInt()) scan.next();
        int choice = scan.nextInt();
        boolean end = false;
        for (int i = 1; i <= 4; i++) {
            if (end)
                break;
            switch (choice) {
                case 1:
                    this.startIO();
                    end = true;
                    break;
                case 2:
                    this.choiceProfile();
                    end = true;
                    break;
                default:
                    System.out.println("Выберите значение\n \n \n");
            }
        }
    }
        public void choiceProfile () {
            System.out.println("Для быстрого набора введите имя");
            nameUsers = (scan.next());
            if (Objects.equals(nameUsers, getName())) {
                if (drinkLove == 1) {
                    makeCoffeeCappuccino();
                } else if (drinkLove == 2) {
                    makeCoffeeEspresso();
                }
            }
        }
    public void makeCoffeeCappuccino(){
        if (coffee >= 10 * volt && milk >= 5 * volt && water >= 50 * volt && bin <= (100 - (5 * volt))) {
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю кофе");
            coffee = coffee - (10 * volt);
            System.out.println("Добавляю молоко");
            milk = milk - (5 * volt);
            System.out.println("Добавляю воду");
            water = water - (50 * volt);
            bin = bin + (5 * volt);
            System.out.println("Cappuccino готово! \n \n \n");
            logger.info("Приготовлено" + volt + "порции Cappuccino");
            Coffee_Count = Coffee_Count + volt;
            logger.info("Приготовлено Cappuccino");
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Молоко(литр) " + String.format("%d", milk));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины! " + String.format("%d", bin) + " %");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
    }
    public void makeCoffeeEspresso(){
        if (coffee >= 10 * volt && water >= 50 * volt && bin <= (100 - (5 * volt))) {
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю кофе");
            coffee = coffee - (10 * volt);
            System.out.println("Добавляю воду");
            water = water - (50 * volt);
            bin = bin + (5 * volt);
            System.out.println("Espresso готово! \n \n \n");
            logger.info("Приготовлено" + volt + "порции Espresso");
            Coffee_Count = Coffee_Count + volt;
            logger.info("Приготовлено Espresso");
        } else {
            System.out.println("Кофе(грамм) " + String.format("%d", coffee));
            System.out.println("Вода(литр) " + String.format("%d", water));
            System.out.println("Требуется чистка Кофемашины! " + String.format("%d", bin) + " %");
            System.out.println("Некоторые ингридиенты недоступны, необходимо заполнить перед приготовлением кофе\n \n \n");
        }
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
        public static void main(String[] args) {
            boolean t = true;
            while (t) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Включить кофемашину Y");
                char press = scan.next().charAt(0);
                if (press == 'Y' || press == 'y' || press == 'н' || press == 'Н') {
                    CoffeeMachine cm = new CoffeeMachine();
                    logger.info("Кофемашина запущена");
                    cm.startIO();
                    break;
                }else
                    System.out.println("Кофемашина выключена!");

            }
        }
    }
}

