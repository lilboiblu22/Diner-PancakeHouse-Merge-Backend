package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Iterator;

@Repository
public class MergerRepository {
    public  List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return records;
    }

public List<MenuItemRecord> getVegetarianMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

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
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined", false, 0.0);
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getName() == "K&B's Pancake Breakfast" || item.getName() == "Regular Pancake Breakfast" || item.getName() == "Blueberry Pancakes" || item.getName() == "Waffles"){
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }
        return records;
    }

    public List<MenuItemRecord> getLunchMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getName() == "Vegetarian BLT" || item.getName() == "BLT" || item.getName() == "Soup of the day" || item.getName() == "Hotdog" || item.getName() == "Steamed Veggies and Brown Rice" || item.getName() == "Pasta") {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }
        return records;
    }

    public List<MenuItemRecord> getDinnerMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0);
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

        //only get the items in cafe menu as they are the only dinner items
        //don't get it by description as it is not unique
        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getName() == "Veggie Burger and Air Fries" || item.getName() == "Soup of the day" || item.getName() == "Burrito"){
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }
        return records;
    }


}