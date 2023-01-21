package praktikum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class IngredientTest {

    @Test
    public void getNameTest() {
        String randomName = "";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, randomName, 1f);
        Assert.assertEquals(randomName, ingredient.getName());
    }
    @Test
    public void getPriceTest() {
        Random rand = new Random();
        float randomPrice = rand.nextFloat();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "", randomPrice);
        Assert.assertEquals(randomPrice, ingredient.getPrice(), 0);
    }
    @Test
    public void getTypeTest() {
        Random rand = new Random();
        float randomPrice = rand.nextFloat();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "", randomPrice);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
