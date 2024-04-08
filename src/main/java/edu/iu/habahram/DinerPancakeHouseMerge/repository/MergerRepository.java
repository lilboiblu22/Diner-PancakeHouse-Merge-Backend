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
    MenuItem allMenus;

    public MergerRepository() {
        ArrayList<Menu> allMenus = new ArrayList<>();
        allMenus.add(new PancakeHouseMenu());
        allMenus.add(new DinerMenu());
        allMenus.add(new CafeMenu());
    }

    public  List<MenuItemRecord> getTheMenuItems() {
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getVegetarianMenuItemsWithIterator() {
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).filter(MenuItemRecord::vegetarian).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getBreakfastMenuItemsWithIterator() {
        MenuItem[] menuItems = allMenus.getChild(0).getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getLunchMenuItemsWithIterator() {
        MenuItem[] menuItems = allMenus.getChild(1).getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getDinnerMenuItemsWithIterator() {
        MenuItem[] menuItems = allMenus.getChild(2).getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }
}