package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;

public class PancakeHouseIterator {
    ArrayList<MenuItem> items;

    public PancakeHouseIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public boolean hasNext() {
        return !items.isEmpty();
    }

    public MenuItem next() {
        return items.remove(0);
    }
}
