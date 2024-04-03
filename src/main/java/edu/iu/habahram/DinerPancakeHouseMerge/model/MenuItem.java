package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.HashMap;

public class MenuItem extends MenuComponent{
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
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
    public String toString() {
        return (name + ", $" + price + "\n   " + description);
    }
    public HashMap<String, MenuItem> getItems() {
        MenuItem[] items = new MenuItem[1];
        items[0] = this;
        HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();

        for (MenuItem menuItem : items) {
            menuItems.put(menuItem.getName(), menuItem);
        }
        return menuItems;
    }
}
