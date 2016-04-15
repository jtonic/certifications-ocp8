package ro.jtonic.cert.ocp8.ch2.pkg;

import java.util.*;


/**
 * Created by antonelpazargic on 15/04/16.
 */
public final class Animal {

    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new IllegalArgumentException("favoriteFoods is required.");
        }
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public String getSpecies() {
        return this.species;
    }

    public int getAge() {
        return this.age;
    }

    public int getFavoriteFoodsCount() {
        return this.favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return this.favoriteFoods.get(index);
    }


}
