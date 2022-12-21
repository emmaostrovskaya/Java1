package bsu.rfe.java.group9.lab1.ostrovskaya.varB6;

import java.util.Objects;

public class Cheese extends Food {


    public static int cheeseAmount = 0;

    public Cheese() {
        this.name = "cheese";
        cheeseAmount++;
        calories = 50;
    }


    public int Amount() {
        return cheeseAmount;
    }

    @Override
    public String toString() {
        return "coffee{" +
                " calories=" + calories +
                '}';
    }

    @Override
    public void consume() {
        System.out.println(name + " has been eaten.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tea Tea = (Tea) o;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int calculateCalories() {
        return calories;
    }
}

