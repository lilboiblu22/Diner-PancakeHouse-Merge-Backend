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
        CafeMenu cafeMenu = new CafeMenu();
        DinerMenu dinerMenu = new DinerMenu();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        List<MenuItemRecord> records = new ArrayList<>();
        records.addAll(getVegetarianCafeMenuItems(cafeMenu));
        records.addAll(getVegetarianDinerMenuItems(dinerMenu));
        records.addAll(getVegetarianPancakeHouseMenuItems(pancakeHouseMenu));
        return records;
    }

    public List<MenuItemRecord> getBreakfastMenuItemsWithIterator() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        Iterator<MenuItem> iterator = pancakeHouseMenu.createIterator();
        List<MenuItemRecord> records = new ArrayList<>();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.getDescription().equals("Breakfast")) {
                records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getLunchMenuItemsWithIterator() {
        DinerMenu dinerMenu = new DinerMenu();
        Iterator<MenuItem> iterator = dinerMenu.createIterator();
        List<MenuItemRecord> records = new ArrayList<>();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.getDescription().equals("Lunch")) {
                records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getDinnerMenuItemsWithIterator() {
        CafeMenu cafeMenu = new CafeMenu();
        Iterator<MenuItem> iterator = cafeMenu.createIterator();
        List<MenuItemRecord> records = new ArrayList<>();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.getDescription().equals("Dinner")) {
                records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return records;
}
    //Following methods are to find vegetarian menu items in each menu
    public Collection<MenuItemRecord> getVegetarianCafeMenuItems(CafeMenu cafeMenu) {
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuItem> iterator = cafeMenu.createIterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.isVegetarian()) {
                records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return records;
    }

    public Collection<MenuItemRecord> getVegetarianDinerMenuItems(DinerMenu dinerMenu) {
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuItem> iterator = dinerMenu.createIterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.isVegetarian()) {
                records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return records;
    }

    public Collection<MenuItemRecord> getVegetarianPancakeHouseMenuItems(PancakeHouseMenu pancakeHouseMenu) {
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuItem> iterator = pancakeHouseMenu.createIterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.isVegetarian()) {
                records.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return records;
    }

}