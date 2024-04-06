package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.model.User;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    String DATABASE_PATH = "data/database.txt";

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarian() {
        List<MenuItemRecord> items = mergerRepository.getVegetarianMenuItemsWithIterator();
        return items;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast() {
        List<MenuItemRecord> items = mergerRepository.getBreakfastMenuItemsWithIterator();
        return items;
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunch() {
        List<MenuItemRecord> items = mergerRepository.getLunchMenuItemsWithIterator();
        return items;
    }

    @GetMapping("/dinner")
    public List<MenuItemRecord> getDinner() {
        List<MenuItemRecord> items = mergerRepository.getDinnerMenuItemsWithIterator();
        return items;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        try{
            appendToDatabase(user.getUsername(), user.getEmail(), user.getPassword());
            return "User added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add user!";
        }
    }

    public void appendToDatabase(String username, String email, String password) {
        // Append the user to the database text file
        Path path = Paths.get(DATABASE_PATH);
        String userInfo = username + "," + email + "," + password + "\n";

        try{
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
            }
            Files.writeString(path, userInfo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}