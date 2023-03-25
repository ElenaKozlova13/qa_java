import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    Feline feline = Mockito.mock(Feline.class);
    private String sex;
    private boolean expectedHasMane;
    public LionTest (String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }
    @Parameterized.Parameters //
    public static Object[][] getSexData() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false },
        };
    }
    @Test
    public void setHaveManeValidSexTest() throws Exception{
        Lion lion = new Lion(sex);
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, actualHasMane);
    }
    @Test
    public void setHaveManeThrowsExceptionTest() throws Exception {
        try {
            Lion lion = new Lion("Не определился");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
        }
    }
    @Test
    public void doesHaveManeTest()  {
        Lion lion = new Lion(feline);
        lion.hasMane = false;
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(lion.hasMane, actualHasMane);
    }
    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(100);
        int actualResult = lion.getKittens();
        Assert.assertEquals(100, actualResult);
    }
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("1", "2", "3"));
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        Assert.assertEquals(List.of("1", "2", "3"), lion.getFood());
    }
}