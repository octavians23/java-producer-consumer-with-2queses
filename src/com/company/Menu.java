package com.company;

import java.util.Random;

public class Menu {
    private final String burgers;
    private final String fries;
    private final String drinks;
    private final static String[] burgerChoices = new String[] {"Cheeseburger", "Double cheeseburger", "Chicken burger", "Vegan burger", "Big Mac"};
    private final static String[] friesChoices = new String[] {"Normal size", "Family size", "Chilly cheese fries"};
    private final static String[] drinkChoices = new String[] {"Water", "Beer", "Cola", "Fanta", "Iced tea"};

    public Menu() {
        Random no = new Random();
        this.burgers = burgerChoices[no.nextInt(4)];
        this.fries = friesChoices[no.nextInt(2)];
        this.drinks = drinkChoices[no.nextInt(4)];
    }

    @Override
    public String toString() {
        return "Menu{" +
                "burgers='" + burgers + '\'' +
                ", fries='" + fries + '\'' +
                ", drinks='" + drinks + '\'' +
                '}';
    }
}
