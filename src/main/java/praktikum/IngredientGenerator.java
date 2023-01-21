package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class IngredientGenerator {
    public static Ingredient createRandom()
    {
        return new Ingredient(IngredientType.values()[new Random().nextInt(IngredientType.values().length)], RandomStringUtils.randomAlphabetic(1, 15), new Random().nextFloat());
    }
}
