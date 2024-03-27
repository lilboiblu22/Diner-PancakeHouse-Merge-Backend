package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu extends MenuComponent{
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, MenuItem> getItems() {
        List<MenuItem> menuItemList = new ArrayList<MenuItem>();
        Iterator<MenuComponent> iterator = (Iterator<MenuComponent>) menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            MenuItem[] items = menuComponent.getItems();
            for (MenuItem item : items) {
                menuItemList.add(item);
            }
        }
        return menuItemList.toArray(new MenuItem[0]);
    }
}