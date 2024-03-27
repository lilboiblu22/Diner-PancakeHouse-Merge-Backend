package edu.iu.habahram.DinerPancakeHouseMerge.model;

public interface Iterator<MenuItem> {

    boolean hasNext();

    MenuItem next();

    void remove();
}
