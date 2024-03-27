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

    }

    @Override
    public void remove() {

    }

    public Iterator<MenuItem> createIterator() {
        return (Iterator<MenuItem>) menuItems.values().iterator();
    }
}
