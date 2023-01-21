package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Random;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;
    @Spy
    Burger burger;
    @Test
    public void getReceiptTest() {
        burger = Mockito.spy(new Burger());
        bun = BunGenerator.createRandom();
        ingredient = IngredientGenerator.createRandom();
        float burgerPriceRandom = new Random().nextFloat();
        Mockito.doReturn(burgerPriceRandom).when(burger).getPrice();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt = String.format("(==== %s ====)\n", bun.name) +String.format(
                "= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) + String.format(
                "(==== %s ====)\n", bun.name) +
                "\n" +
                String.format("Price: %f%n", burger.getPrice());
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void setBunsTest() {
        bun = BunGenerator.createRandom();
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        ingredient = IngredientGenerator.createRandom();
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        ingredient = IngredientGenerator.createRandom();
        ingredient2 = IngredientGenerator.createRandom();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        Assert.assertFalse(burger.ingredients.contains(ingredient2));
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        ingredient = IngredientGenerator.createRandom();
        ingredient2 = IngredientGenerator.createRandom();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(125F);
        when(ingredient.getPrice()).thenReturn(340F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(590F, burger.getPrice(), 0);
    }

}
