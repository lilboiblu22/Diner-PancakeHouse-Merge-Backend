package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CafeMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class CafeRepository {
    public Map<String, MenuItem> getTheMenu() {
        CafeMenu cafeMenu = new CafeMenu();
        return cafeMenu.getItems();
    }
}
