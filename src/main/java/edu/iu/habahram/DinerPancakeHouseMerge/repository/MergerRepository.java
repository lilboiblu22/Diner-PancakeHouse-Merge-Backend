package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Iterator;

@Component
@Repository
public class MergerRepository {
    public  List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0, "All");
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
            MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0, "All");
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
    // Get breakfast menu items
    public List<MenuItemRecord> getBreakfastMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined", false, 0.0, "All");
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getMealType().equals("Breakfast")) {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }
        return records;
    }

    public List<MenuItemRecord> getLunchMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0, "All");
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getMealType().equals("Lunch")) {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }
        return records;
    }

    public List<MenuItemRecord> getDinnerMenuItemsWithIterator() {
        MenuComponent allMenus = new MenuItem("ALL MENUS", "All menus combined" , false, 0.0, "All");
        allMenus.add(new DinerMenu());
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new CafeMenu());

        CompositeIterator iterator = new CompositeIterator((Iterator<MenuItem>) allMenus.createIterator());
        List<MenuItemRecord> records = new ArrayList<>();

        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem) {
                MenuItem item = (MenuItem) component;
                if (item.getMealType().equals("Dinner")) {
                    records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
                }
            }
        }
        return records;
    }
}