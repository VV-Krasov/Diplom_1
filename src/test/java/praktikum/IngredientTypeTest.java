package praktikum;

import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void IngredientTypeFillingIsNotNull() { assert IngredientType.FILLING != null; }

    @Test
    public void IngredientTypeSauceIsNotNull()
    {
        assert IngredientType.SAUCE != null;
    }
}
