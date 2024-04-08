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
        MenuItem[] pancakeHouseMenuItems = new PancakeHouseMenu().getMenuItems();
        MenuItem[] dinerMenuItems = new DinerMenu().getMenuItems();
        MenuItem[] cafeMenuItems = new CafeMenu().getMenuItems();

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
                .filter(Objects::nonNull)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()))
                .sorted(Comparator.comparing(MenuItemRecord::name))
                .collect(Collectors.toList());
    }

    public List<MenuItemRecord> getVegetarianMenuItemsWithIterator() {
        return allMenus.stream()
                .flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .filter(MenuItem::isVegetarian)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice()))
                .sorted(Comparator.comparing(MenuItemRecord::name))
                .collect(Collectors.toList());
    }

    public List<MenuItemRecord> getBreakfastMenuItemsWithIterator() {
        if (!allMenus.isEmpty() && allMenus.get(0) != null) {
            MenuItem[] menuItems = allMenus.get(0);
            return Arrays.stream(menuItems)
                    .filter(Objects::nonNull)
                    .map(x -> new MenuItemRecord(x.getName(),
                            x.getDescription(),
                            x.isVegetarian(),
                            x.getPrice()))
                    .sorted(Comparator.comparing(MenuItemRecord::name))
                    .collect(Collectors.toList());
        } else {
            // handle the case where allMenus is empty or the first item is null
            return new ArrayList<>();
        }
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