import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    Feline feline;
    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        System.out.println(cat.getSound());
        Assert.assertEquals("Мяу", cat.getSound());
    }
    @Test
    public void getFoodTest () throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
