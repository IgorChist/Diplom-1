import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {SAUCE, "Горчица", 500.0f},
                {SAUCE, "Mustard", 587.0f},
                {SAUCE, "123Цифровая", 380.0f},
                {SAUCE, "@Специальная", 628.0f},
                {SAUCE, "С пробелом", 580.6f},
                {SAUCE, "СамоеБольшоеНазваниеСоусаВНашемМеню", 80.6f},
                {SAUCE, null, 500.0f},
                {SAUCE, "Бесплатный", 0.0f},
                {SAUCE, "Дешевый", Float.MIN_VALUE},
                {SAUCE, "Дорогой", Float.MAX_VALUE},
                {SAUCE, "Джекпот", -500.0f},
                {FILLING, "Котлета", 500.0f},
                {FILLING, "cutlet", 587.0f},
                {FILLING, "123Цифровая", 380.0f},
                {FILLING, "@Специальная", 628.0f},
                {FILLING, "С пробелом", 580.6f},
                {FILLING, "СамоеБольшоеНазваниеНачинкиВНашемМеню", 80.6f},
                {FILLING, null, 500.0f},
                {FILLING, "Бесплатная", 0.0f},
                {FILLING, "Дешевая", Float.MIN_VALUE},
                {FILLING, "Дорогая", Float.MAX_VALUE},
                {FILLING, "Джекпот", -500.0f},
                {null, null, 500.0f},
        };
    }

    @Test
    public void shouldReturnName() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String actualName = ingredient.getName();
        Assert.assertEquals("Передаваемое имя должно совпадать с получаемым", ingredientName, actualName);
    }
    @Test
    public void shouldReturnPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Передаваемая цена должна совпадать с получаемой", ingredientPrice, actualPrice, 0);
        }
    @Test
    public void shouldReturnType() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Передаваемый тип должен совпадать с получаемым", ingredientType, actualType);
    }

}
