package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.HashMap;

public class CafeMenuIterator implements Iterator<MenuItem>{

    HashMap<String, MenuItem> menuItems;

    public CafeMenuIterator(MenuItem[] items) {
       this.menuItems = new HashMap<>();
         for(MenuItem item: items) {
              menuItems.put(item.getName(), item);
         }
    }

    @Override
    public boolean hasNext() {
        return !menuItems.isEmpty();
    }

    @Override
    public MenuItem next() {
        return menuItems.remove(0);
    }

    @Override
    public void remove() {
        if (menuItems.isEmpty()) {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one next()");
        }
        if (menuItems != null) {
            for (int i = 0; i < (menuItems.size()-1); i++) {
                menuItems.put(i, menuItems.get(i+1));
            }
            menuItems.remove(menuItems.size()-1);
        }
    }

    public Iterator<MenuItem> createIterator() {
        return (Iterator<MenuItem>) menuItems.values().iterator();
    }
}
