package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scan = new Scanner(System.in);
    private double coffee, milk, water; //privat модификатор доступа (видимость данных и методов только внутри объявленного класса)
    private int Coffee_Count = 0;


    public CoffeeMachine() { //конструктор с параметрами
        this.coffee = 0; //this - указывает на конкретный предмет, работает с переменной, которая принадлежит классу, в нее вкладываем значение параметр
        this.milk = 0;
        this.water = 0;
    },
    private void SetIngredient() { //запрос на заправку ингредиентов setтеры присваивают значения
        System.out.println("Заполнение");
        this.coffee = 500.0;
        this.milk = 1;
        this.water = 2;
        System.out.println("Заполнение завершено");
    }
    private void GetIngredient(){ //getтеры возвращают значение
        System.out.println("Кофе(грамм) " + String.format("%.1f",this.coffee));
        System.out.println("Молоко(литры) "+String.format("%.1f", this.milk));
        System.out.println("Вода(литры) "+String.format("%.1f", this.water));
    }
    private void CleanMachine(){
        System.out.println("Очистка Кофемашины");
        this.coffee = 0;
        this.milk = 0;
        this.water= 0;
        System.out.println("Очистка закончена");
    }
    private void makecoffee(){
        System.out.println("Выберите кофе: \n 1.Cappuccino \n 2.Espresso");
        char t =  scan.next().charAt(0);
        switch(t){
            case '1':
                this.Cappuccino();
                break;
            case '2':
                this.Espresso();
                break;
            case '0':
                break;
        }
    }
    private void Cappuccino(){
        if(this.coffee >= 10 && this.water >= 0.2) {
            System.out.println("Делаю Cappuccino");
            System.out.println("Добавляю 10 грамм кофе");
            this.coffee = this.coffee - 10;
            System.out.println("Добавляю 0,2 л воды");
            this.water = this.water - 0.2;
            System.out.println("Кофе готово");
            this.coffee++;
        }
        else{
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
        }
    }
    public void start() {
        System.out.println("Выберите операцию!");
        this.GetIngreditnt();
        bolean t = true;
        while (t) {
            System.out.println("1. Количество ингредиентов \n 2. Заполнить ингредиенты \n 3.Очистить машину \n 4.Сделать кофе \n 5.Сколько кофе вы хотите сделать? \n 6.Выход  ");
            char c = CoffeeMachine.scan.next().charAt(0);
            switch (c) {
                case '1':
                    System.out.println("Количество");
                    this.GetIngredient();
                    System.out.println("-----");
                case '2':
                    this.SetIngredient();
                    break;
                case '3':
                    this.CleanMachine();
                    break;
                case '4':
                    this.makecoffee();
                    break;
                case '5':
                    System.out.println("Делаю " + this.Coffee_Count + "кофе.");
                    break;
                case '6':
                    System.out.println("Выход");
                    t = false;
                    break;
            }
        }
    }
    public class MakeCoffee {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Включить кофемашину Y или N?");
            char press = scan.next().charAt(0); //charAt() возвращает первое значение выбранное пользователем
            if (press == 'Y' || press == 'y') {
                CoffeeMachine cm = new CoffeeMachine();
                cm.start();
                System.out.println("Кофемашина включена");
            } else
                System.out.println("Кофемашина выключена");
        }


       /* CoffeeRecipe cappuccino = new CoffeeRecipe(300 , 50, 20, 40);

        CoffeeRecipe espresso = new CoffeeRecipe(100, 0, 40,40);

        System.out.println();*/


    }
}

