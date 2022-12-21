package bsu.rfe.java.group9.lab1.ostrovskaya.varB6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        boolean cals = Arrays.stream(args).anyMatch("-calories"::equals);
        boolean isSort = Arrays.stream(args).anyMatch("-sort"::equals);
        int size = args.length;
        if (cals) size--;
        if (isSort) size--;
        try {

            Food[] food = new Food[size];

            for (int i = 0; i < size; i++) {
                String[] params = args[i].split("/");
                switch (params[0]) {
                    case ("Coffee"):
                        food[i] = new Coffee(params[1]);
                        break;
                    case ("Milk"):
                        food[i] = new Milk(params[1]);
                        break;
                    case ("Pie"):
                        food[i] = new Pie(params[1]);
                        break;
                    case ("Cheese"):
                        food[i] = new Cheese();
                        break;
                    default:
                        if (params[0].charAt(0) == '-') {
                            break;
                        }
                }
            }

            if (isSort) {
                Arrays.sort(food, (Food x, Food y) -> {
                    return y.calculateCalories() - x.calculateCalories();
                });
            }

            int sumCalories = 0;
            for (int i = 0; i < size; i++) {
                int curCalories = food[i].calculateCalories();
                food[i].consume();
                sumCalories += curCalories;
            }

            System.out.println((Milk.Fat15Amount + Milk.Fat25Amount + Milk.Fat50Amount) + " glasses of milk has been drunk.");
            System.out.println((Coffee.greenCoffeeAmount + Coffee.blackCoffeeAmount+ Coffee.redCoffeeAmount) + " cups of Coffee has been drunk.");
            System.out.println((Pie.applePiesAmount + Pie.cherryPiesAmount + Pie.strawberryPiesAmount) + " pies has been eaten.");
            System.out.println((Cheese.cheeseAmount) + " pieces of cheese has been eaten.");

            if (cals) {
                System.out.printf("Sum of calories: " + sumCalories);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}