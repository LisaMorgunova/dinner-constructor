package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> DinnerList;

    public DinnerConstructor() {
        DinnerList = new HashMap<>();
        ArrayList<String> first = new ArrayList<>();
        DinnerList.put("Первое", first);

        ArrayList<String> second = new ArrayList<>();
        DinnerList.put("Второе", second);

        ArrayList<String> third = new ArrayList<>();
        DinnerList.put("Напиток", third);
    }

    public void addDish(String dishType, String dishName) {
        ArrayList<String> dishes = DinnerList.get(dishType);
        dishes.add(dishName);
        DinnerList.put(dishType, dishes);
    }

    public ArrayList<String> generateCombo(ArrayList<String> types) {
        ArrayList<String> combo = new ArrayList<>();
        Random random = new Random();

        for (String type : types) {
            ArrayList<String> dishes = DinnerList.get(type);
            int index = random.nextInt(dishes.size());
            String dish = dishes.get(index);
            combo.add(dish);
        }

        return combo;
    }
}
