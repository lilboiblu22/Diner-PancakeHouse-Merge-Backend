package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Iterator;
import java.util.stream.Collectors;

@Component
@Repository
public class MergerRepository {
    ArrayList<MenuItem[]> allMenus;

    public MergerRepository() {
        allMenus = new ArrayList<>();
        MenuItem[] pancakeHouseMenuItems = new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast").getMenuItems();
        MenuItem[] dinerMenuItems = new DinerMenu("DINER MENU", "Lunch").getMenuItems();
        MenuItem[] cafeMenuItems = new CafeMenu("CAFE MENU", "Dinner").getMenuItems();

        if (pancakeHouseMenuItems != null) {
            allMenus.add(pancakeHouseMenuItems);
        }
        if (dinerMenuItems != null) {
            allMenus.add(dinerMenuItems);
        }
        if (cafeMenuItems != null) {
            allMenus.add(cafeMenuItems);
        }
    }

    public List<MenuItemRecord> getTheMenuItems() {
        return allMenus.stream()
                .flatMap(Arrays::stream)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()))
                .sorted(Comparator.comparing(MenuItemRecord::name))
                .collect(Collectors.toList());
    }

    public List<MenuItemRecord> getVegetarianMenuItemsWithIterator() {
        List<MenuItemRecord> records = allMenus.stream()
                .flatMap(Arrays::stream)
                .filter(MenuItem::isVegetarian)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()))
                .sorted(Comparator.comparing(MenuItemRecord::name))
                .collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getBreakfastMenuItemsWithIterator() {
        MenuItem[] menuItems = allMenus.get(0);
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()))
                .sorted(Comparator.comparing(MenuItemRecord::name))
                .collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getLunchMenuItemsWithIterator() {
        MenuItem[] menuItems = allMenus.get(1);
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()))
                .sorted(Comparator.comparing(MenuItemRecord::name))
                .collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getDinnerMenuItemsWithIterator() {
        MenuItem[] menuItems = allMenus.get(2);
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()))
                .sorted(Comparator.comparing(MenuItemRecord::name))
                .collect(Collectors.toList());
        return records;
    }
}