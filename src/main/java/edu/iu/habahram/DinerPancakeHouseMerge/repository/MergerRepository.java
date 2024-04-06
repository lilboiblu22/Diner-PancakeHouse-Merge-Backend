package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Iterator;

@Repository
public class MergerRepository {
    public  List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

public List<MenuItemRecord> getVegetarianMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.isVegetarian()) {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }
        return records;
    }

    public List<MenuItemRecord> getBreakfastMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getDescription().equals("Breakfast")) {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }

        return records;
    }

    public List<MenuItemRecord> getLunchMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getDescription().equals("Lunch")) {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }

        return records;
    }

    public List<MenuItemRecord> getDinnerMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getDescription().equals("Dinner")) {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }

        return records;
    }
}