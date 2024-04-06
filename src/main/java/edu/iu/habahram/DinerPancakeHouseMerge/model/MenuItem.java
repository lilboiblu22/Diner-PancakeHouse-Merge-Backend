package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.HashMap;

public class MenuItem extends MenuComponent{
    String name;
    String description;
    boolean vegetarian;
    double price;
    String mealType;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price,
                    String mealType)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
        this.mealType = mealType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String getMealType() {
        return mealType;
    }

    public String toString() {
        return (name + ", $" + price + "\n   " + description);
    }

    public MenuItem[] getItems(){
        MenuItem[] items = new MenuItem[1];
        items[0] = this;
        return items;
    }

}
