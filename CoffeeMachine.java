package CoffeeMachine;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);
    static int coffee = 100, milk = 100, water = 1000, bin = 0;
    final int COFFEE_MAX = 501, MILK_MAX = 200, WATER_MAX = 2000;
    static int Coffee_Count = 0;
    static int Coffee_Count1 = 0;


    static int delMachine;
    String coffeeName;
    static int volume;
    String profileName;
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
        System.out.println("����(��) " + String.format("%d", coffee));
        System.out.println("������� ������� ���� ��������(��)");
        while(!scan.hasNextInt()) scan.next();
        int volumeCoffee = Integer.parseInt(scan.next());
        if (coffee + volumeCoffee > COFFEE_MAX) {
            System.out.println("����� �������� max:  " + (COFFEE_MAX - coffee) + " �� \n \n \n");
        } else {
            coffee = coffee + volumeCoffee;
            logger.info("���������" + volumeCoffee + "�� ����");
            System.out.println("�������� ���� \n \n \n");
        }
    }



    private void setMilk() {
        System.out.println("������(��) " + String.format("%d", milk));
        System.out.println("������� ������� ������ ��������(��)");
        try{
            int volumeMilk = scan.nextInt();
        if (milk + volumeMilk > MILK_MAX) {
            System.out.println("����� �������� max:  " + (MILK_MAX - milk) + " �� \n \n \n");
        } else {
            milk = milk + volumeMilk;
            logger.info("���������" + volumeMilk + " �� ������");
            System.out.println("�������� ������ \n \n \n");
        }
        }catch (NumberFormatException | InputMismatchException e){
            System.out.println("������� ���������� ��������!");

        }
    }

    private void setWater() {
        System.out.println("����(��) " + String.format("%d", water));
        System.out.println("������� ������� ���� ��������(��)");
        try{
            int volumeWater = scan.nextInt();
        if (water + volumeWater > WATER_MAX) {
            System.out.println("����� �������� max:  " + (WATER_MAX - water) + " �� \n \n \n");
        } else {
            water = water + volumeWater;
            logger.info("���������" + volumeWater + " �� ����");
            System.out.println("�������� ���� \n \n \n");
        }
        }catch (NumberFormatException | InputMismatchException e){
            System.out.println("������� ���������� ��������!\n \n \n");

        }
    }

    private void setCleanMachine() {
        System.out.println("�������(%)  " + String.format("%d", bin));
        if (bin > 100) {
            System.out.println("������� ����������\n \n \n");
            bin = 0;
            logger.info("������� ������");
        } else {
            System.out.println("������� �� ��������� \n \n \n");
        }
    }

    private void GetIngredient() {
        System.out.println("����(��) " + String.format("%d", coffee));
        System.out.println("������(��) " + String.format("%d", milk));
        System.out.println("����(��) " + String.format("%d", water));
        System.out.println("�������(%)  " + String.format("%d", bin));
    }

    private void Espresso() {
        System.out.println("������� ������ ���� ��� ����������? \n 1. 3 ������ \n 2.������ ������ ���������� \n 3.������ Espresso");
        while(!scan.hasNextInt()) scan.next();
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
                    System.out.println("������ Espresso:" + Espresso_Rice.WATER + Espresso_Rice.WATER.getValue() + "\n" + Espresso_Rice.COFFEE + Espresso_Rice.COFFEE.getValue() + "\n \n \n");
                    logger.info("������� ������");
                    end = true;
                    break;
                default:
                    System.out.println("�������� ��������  \n \n \n");
            }
        }
    }

    private void addEspresso() {
        if (coffee >= 30 && water >= 90 && bin <= 15) {
            System.out.println("����� Espresso");
            System.out.println("�������� ����");
            coffee = coffee - 30;
            System.out.println("�������� ����");
            water = water - 90;
            bin = bin + 15;
            System.out.println("���� ������\n \n \n");
            logger.info("������������ 3 ������ Espresso");
            Coffee_Count1 = Coffee_Count1 + 3;
        } else {
            System.out.println("����(�����) " + String.format("%d", coffee));
            System.out.println("����(����) " + String.format("%d", water));
            System.out.println("��������� ������ ����������! " + String.format("%d", bin) + " %");
            System.out.println("��������� ����������� ����������, ���������� ��������� ����� �������������� ����\n \n \n");
        }
    }

    private void addEspressoChoice() {
        while(!scan.hasNextInt()) scan.next();
        int choiceVoliume = scan.nextInt();
        if (coffee >= 10 * choiceVoliume && water >= 30 * choiceVoliume && bin <= (5 * choiceVoliume)) {
            System.out.println("����� Espresso");
            System.out.println("�������� 10 ����� ����");
            coffee = coffee - (10 * choiceVoliume);
            System.out.println("�������� 0,2 � ����");
            water = water - (30 * choiceVoliume);
            bin = bin + (5 * choiceVoliume);
            System.out.println("���� ������\n \n \n");
            logger.info("������������" + choiceVoliume + "������ Espresso");
            Coffee_Count1 = Coffee_Count1 + choiceVoliume;
        } else {
            System.out.println("����(�����) " + String.format("%d", coffee));
            System.out.println("����(����) " + String.format("%d", water));
            System.out.println("��������� ������ ����������! " + String.format("%d", bin) + " %");
            System.out.println("��������� ����������� ����������, ���������� ��������� ����� �������������� ����\n \n \n");
        }
    }

    public void allCoffee() {
        System.out.println("����� ������������ Espresso: " + Coffee_Count1 + " ��\n \n \n");
        System.out.println("����� ������������ Cappuccino: " + Coffee_Count + " ��\n \n \n");
    }

    private void Cappuccino() {
           System.out.println("������� ������ ���� ��� ����������? \n 1. 3 ������ \n 2.������ ������ ���������� \n 3.������ Cappuccino\n ");
           while(!scan.hasNextInt()) scan.next();
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
                       System.out.println("������ Cappuccino \n" + Cappuccino_Rice.WATER + Cappuccino_Rice.WATER.getValue() + "\n" + Cappuccino_Rice.COFFEE + Cappuccino_Rice.COFFEE.getValue() + "\n" + Cappuccino_Rice.MILK + Cappuccino_Rice.MILK.getValue() + "\n \n \n");
                       end = true;
                       logger.info("������� ������");
                       break;
                   default:
                       System.out.println("�������� ��������\n \n \n");
               }
           }
    }
    private void addCappuccino() {
        if (coffee >= 30 && milk >= 15 && water >= 150 && bin <= 15) {
            System.out.println("����� Cappuccino");
            System.out.println("�������� 30����� ����");
            coffee = coffee - 30;
            System.out.println("�������� 15�� ������");
            milk = milk - 15;
            System.out.println("�������� 150�� ����");
            water = water - 150;
            bin = bin + 15;
            System.out.println("Cappuccino ������! \n \n \n");
            Coffee_Count = Coffee_Count + 3;
            logger.info("������������ 3 ������ Cappuccino");
        } else {
            System.out.println("����(�����) " + String.format("%d", coffee));
            System.out.println("������(����) " + String.format("%d", milk));
            System.out.println("����(����) " + String.format("%d", water));
            System.out.println("��������� ������ ����������! " + String.format("%d", bin) + " %");
            System.out.println("��������� ����������� ����������, ���������� ��������� ����� �������������� ����\n \n \n");
        }
    }

    private void addCappuccinoChoice() {
        while(!scan.hasNextInt()) scan.next();
        int choiceVoliume = scan.nextInt();
        if (coffee >= 10 * choiceVoliume && milk >= 5 * choiceVoliume && water >= 50 * choiceVoliume && bin <= (5 * choiceVoliume)){
            System.out.println("����� Cappuccino");
            System.out.println("�������� ����");
            coffee = coffee - (10 * choiceVoliume);
            System.out.println("�������� ������");
            milk = milk - (5 * choiceVoliume);
            System.out.println("�������� ����");
            water = water - (50 * choiceVoliume);
            bin = bin + (5 * choiceVoliume);
            System.out.println("Cappuccino ������! \n \n \n");
            logger.info("������������" + choiceVoliume + "������ Cappuccino");
            Coffee_Count = Coffee_Count + choiceVoliume;
        } else {
            System.out.println("����(�����) " + String.format("%d", coffee));
            System.out.println("������(����) " + String.format("%d", milk));
            System.out.println("����(����) " + String.format("%d", water));
            System.out.println("��������� ������ ����������! " + String.format("%d", bin) + " %");
            System.out.println("��������� ����������� ����������, ���������� ��������� ����� �������������� ����\n \n \n");
        }
    }
    public void addProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������� �������� � ������� ���� �� ������: \n 1.add profile \n 2.choice profile");
        delMachine = scanner.nextInt();
        if (delMachine == 1){
        HashMap<String, Integer> coffeeChoice = new HashMap<>();
        coffeeName = scanner.nextLine();
        System.out.println ("�������� �������: \n cappuccino \n espresso ");
        System.out.println ("������� ������� ������ ��� �������� � �������? ");
        volume = scanner.nextInt();
        coffeeChoice.put(coffeeName, volume);

        HashMap<String, HashMap<String,Integer>> profile = new HashMap<>();
        System.out.println ("������� ��� ");
        profileName = scanner.nextLine();
        profile.put(profileName, coffeeChoice);
        System.out.println("������� ��������:" + profile);
        }
        /*else if(delMachine == 2) {
            for( HashMap<String, HashMap<String,Integer>> item : states.entrySet()){

                System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
            }
        System.out.println ("������� ��� ");
        String profileChoice = scanner.nextLine();
        }

         v get(Object k)


       /* System.out.println("�������� ����� ����: \n 1.Cappuccino \n 2.Espresso ");
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
                    System.out.println("�������� ���� ����\n \n \n");
            }
        }
    }
    public void addCappuccinoPerson(){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> profile = new HashMap<>();
        System.out.println ("������� ��� ");
        String choice = scanner.nextLine();
        System.out.println ("������� ������� ������ ��� �������� � �������? ");
        int volt = scanner.nextInt();
        profile.put(choice, volt);
        System.out.println("������� ��������:" + profile);
        }
    public  void addEspressoPerson() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> profile1 = new HashMap<>();
        System.out.println ("������� ��� ");
        String choice = scanner.nextLine();
        System.out.println ("������� ������� ������ ��� �������� � �������? ");
        int volt = scanner.nextInt();
        profile1.put(choice, volt);
        System.out.println("������� ��������:" + profile1);
    }
    public void addChoiceProfile(){
        System.out.println ("������� ��� ������ �������: ");
        System.out.println();*/
    }
    public void startIO() {
        System.out.println("�������� ��������!");
        boolean t = true;
        while (t) {
            this.GetIngredient();
            System.out.println(" 1.Cappuccino \n 2.Espresso \n 3.�������� ���� \n 4.�������� ������ \n 5.�������� ���� \n 6.�������� \n 7.���������� ��������������� ���� \n 8.�������� �������  \n 9.���������  ");
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
                    System.out.println("���������");
                    t = false;
                    break;
            }
        }
    }
    static class MakeCoffee {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            System.out.println("�������� ���������� Y ��� N?");
           // try {
                char press = scan.next().charAt(0);
                if (press == 'Y' || press == 'y' || press == '�' || press == '�') {
                    CoffeeMachine cm = new CoffeeMachine();
                    logger.info("���������� ��������");
                    cm.startIO();
                    System.out.println("���������� ���������");
                } else
                    System.out.println("���������� ���������!");
            //} catch (NumberFormatException a) {
                    System.out.println("��� ��������� ������� Y");
            //}
        }
    }
}
