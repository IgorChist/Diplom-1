import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Русская", 500.0f},
                {"Latin", 587.0f},
                {"123Цифровая", 380.0f},
                {"@Специальная", 628.0f},
                {"С пробелом", 580.6f},
                {"СамоеБольшоеНазваниеБулочкиВНашемМеню", 80.6f},
                {null, 500.0f},
                {"Бесплатная", 0.0f},
                {"Дешевая", Float.MIN_VALUE},
                {"Дорогая", Float.MAX_VALUE},
                {"Джекпот", -500.0f}
        };
    }


    @Test
    public void shouldReturnName() {
        Bun bun = new Bun(bunName, bunPrice);
        String actualName = bun.getName();
        Assert.assertEquals("Передаваемое имя должно совпадать с получаемым", bunName, actualName);
    }

    @Test
    public void shouldReturnPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Передаваемая цена должна совпадать с получаемой", bunPrice, actualPrice, 0);
    }

}
