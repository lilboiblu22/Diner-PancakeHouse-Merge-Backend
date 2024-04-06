package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator<MenuItem>{
    MenuItem[] menuItems;
    int position = 0;

    public PancakeHouseIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public boolean hasNext() {
        if(position >= menuItems.length || (menuItems[position] == null)) {
            return false;
        }
        return true;
    }

    public MenuItem next() {
        MenuItem menuItem = menuItems[position];
        position += 1;
        return menuItem;
    }

    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one next()");
        }
        if (menuItems[position-1] != null) {
            for (int i = position-1; i < (menuItems.length-1); i++) {
                menuItems[i] = menuItems[i+1];
            }
            menuItems[menuItems.length-1] = null;
        }
    }
}
