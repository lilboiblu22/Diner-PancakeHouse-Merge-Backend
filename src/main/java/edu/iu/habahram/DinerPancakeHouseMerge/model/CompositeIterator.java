package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Stack;
public class CompositeIterator implements Iterator<MenuComponent>{

    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

    public CompositeIterator(java.util.Iterator<MenuItem> iterator) {
        stack.push((Iterator<MenuComponent>) iterator);
    }


    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<MenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public MenuComponent next() {
        if (hasNext()){
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent component = iterator.next();
            stack.push(component.createIterator());
            return component;
        } else {
            return null;
        }
    }

    @Override
    public void remove() {
        stack.pop();
    }
}



