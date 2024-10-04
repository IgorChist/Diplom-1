import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient, secondIngredient;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test

    public void shouldSetBun() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Русская");
        String expectedName = "Русская";
        String actualName = burger.bun.getName();
        Assert.assertEquals("Должно вернуться значение - " + expectedName, expectedName, actualName);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(firstIngredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Assert.assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldMoveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(0));
        burger.moveIngredient(0, 1);
        Assert.assertEquals(firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void shouldGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getPrice()).thenReturn(500.0f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(100.0f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(200.0f);
        float expectedPrice = (500.0f * 2) + 100.0f + 200.0f;
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void shouldGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        Mockito.when(bun.getName()).thenReturn("Русская");
        Mockito.when(bun.getPrice()).thenReturn(500.0f);
        Mockito.when(firstIngredient.getName()).thenReturn("Горчица");
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getPrice()).thenReturn(100.0f);
        Mockito.when(secondIngredient.getName()).thenReturn("Котлета");
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getPrice()).thenReturn(200.0f);
        String expectedReceipt = String.format("(==== Русская ====)%n= sauce Горчица =%n= filling Котлета =%n(==== Русская ====)%n%nPrice: 1300,000000%n");
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}