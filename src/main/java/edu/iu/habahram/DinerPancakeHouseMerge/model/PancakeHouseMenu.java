package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class PancakeHouseMenu implements Menu {
    MenuItem[] menuItems;
    int numberOfItems = 0;
    static final int MAX_ITEMS = 6;
    String pancakeHouseMenu;
    String breakfast;

    public PancakeHouseMenu() {
        this.pancakeHouseMenu = "PANCAKE HOUSE MENU";
        this.breakfast = "Breakfast";
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99);

        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);

        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);

        addItem("Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public PancakeHouseMenu(String pancakeHouseMenu, String breakfast) {
       this.pancakeHouseMenu = pancakeHouseMenu;
         this.breakfast = breakfast;
    }


    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }



    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MenuItem item: getMenuItems()) {
            stringBuilder.append(item.toString());
        }
        return  stringBuilder.toString();
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return (Iterator<MenuItem>) new PancakeHouseIterator(menuItems);
    }


    // other menu methods here
}