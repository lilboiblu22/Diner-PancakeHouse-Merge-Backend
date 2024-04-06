package edu.iu.habahram.DinerPancakeHouseMerge.model;


import java.util.Iterator;

public class CafeMenu implements Menu {
    MenuItem[] menuItems = new MenuItem[3];
    int numberOfItems = 0;
    static final int MAX_ITEMS = 6;
    String cafeMenu;
    String dinner;

    public CafeMenu() {
        this.cafeMenu = "CAFE MENU";
        this.dinner = "Dinner";
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);
    }

    public CafeMenu(String cafeMenu, String dinner) {
        this.cafeMenu = cafeMenu;
        this.dinner = dinner;
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

    public MenuItem[] getItems() {
        return menuItems;
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return (Iterator<MenuItem>) new CafeMenuIterator(menuItems);
    }



}