package bsu.rfe.java.group9.lab1.ostrovskaya.varB6;


import java.util.Objects;

public class Coffee extends Food{

    private String aroma = "";
    public static int intenseCoffeeAmount = 0;
    public static int bitterCoffeeAmount = 0;
    public static int easternCoffeeAmount = 0;
    static final String intense = "intense";
    static final String bitter = "bitter";
    static final String eastern = "eastern";

    public Coffee(String aroma)  {
        this.aroma = aroma;
        this.name = "Coffee";

        switch (aroma) {
            case (intense):
                this.calories = 10;
                intenseCoffeeAmount++;
                break;
            case (bitter):
                this.calories = 20;
                bitterCoffeeAmount++;
                break;
            case (eastern):
                this.calories = 30;
                easternCoffeeAmount++;
                break;
            default:
                break;
        }
    }

    public int Amount(){
        return switch (aroma){
            case(intense) -> intenseCoffeeAmount;
            case(bitter) -> bitterCoffeeAmount;
            case(eastern) -> easternCoffeeAmount;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "aroma='" + aroma + '\'' +
                ", calories=" + calories +
                '}';
    }

    @Override
    public void consume(){
        System.out.println(aroma + " " + name + " has been drunk.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee Coffee = (Coffee) o;
        return Objects.equals(aroma, Coffee.aroma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aroma);
    }

    @Override
    public int calculateCalories() {
        return calories;
    }
}
