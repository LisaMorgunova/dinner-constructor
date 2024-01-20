package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerList;

    public DinnerConstructor() {
        dinnerList = new HashMap<>();
        ArrayList<String> first = new ArrayList<>();
        dinnerList.put("Первое", first);

        ArrayList<String> second = new ArrayList<>();
        dinnerList.put("Второе", second);

        ArrayList<String> third = new ArrayList<>();
        dinnerList.put("Напиток", third);
    }

    public void addDish(String dishType, String dishName) {
        if (dinnerList.get(dishType) != null)  // Добавлена проверка на существование ключа
        {
            ArrayList<String> dishes = dinnerList.get(dishType);
            dishes.add(dishName);
            dinnerList.put(dishType, dishes);
        } else {
            dinnerList.put(dishType, new ArrayList<String>());
            ArrayList<String> dishes = dinnerList.get(dishType);
            dishes.add(dishName);
            dinnerList.put(dishType, dishes);
        }
    }

    public ArrayList<String> generateCombo(ArrayList<String> types) {
        ArrayList<String> combo = new ArrayList<>();
        Random random = new Random();

        for (String type : types) {
            if (dinnerList.get(type) != null) {
                ArrayList<String> dishes = dinnerList.get(type);
                if (dishes.size() > 0) {
                    int index = random.nextInt(dishes.size());
                    String dish = dishes.get(index);
                    combo.add(dish);
                }

            }
        }
        return combo;
    }
}