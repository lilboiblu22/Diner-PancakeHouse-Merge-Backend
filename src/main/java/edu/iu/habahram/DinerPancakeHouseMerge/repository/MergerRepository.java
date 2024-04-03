package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class MergerRepository {
    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        HashMap<String, MenuItem> menuItems = allMenus.getItems();
        MenuItemRecord[] records = new MenuItemRecord[menuItems.size()];
        int i = 0;
        for (MenuItem menuItem : menuItems.values()) {
            records[i] = new MenuItemRecord(menuItem.getName(), menuItem.getDescription(), menuItem.isVegetarian(), menuItem.getPrice());
            i++;
        }
        return Arrays.asList(records);
    }
}