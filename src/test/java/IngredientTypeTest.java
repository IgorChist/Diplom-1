import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void checkTypeSauce() {
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.name());
    }
        @Test
        public void checkTypeFilling() {
            Assert.assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
