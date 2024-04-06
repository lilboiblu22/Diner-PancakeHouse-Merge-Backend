package edu.iu.habahram.DinerPancakeHouseMerge.model;

public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    public String getMealType() {
        throw new UnsupportedOperationException();
    }

    public MenuItem[] getItems() {
        throw new UnsupportedOperationException();
    }

    public Iterator<MenuComponent> createIterator(){
        throw new UnsupportedOperationException();
    }

    public MenuComponent add(MenuComponent menuComponent, String name, String description, boolean vegetarian, double price) {
        throw new UnsupportedOperationException();
    }

    public void add(CafeMenu cafeMenu) {
    }

    public void add(PancakeHouseMenu pancakeHouseMenu) {
    }

    public void add(DinerMenu dinerMenu) {

    }
}