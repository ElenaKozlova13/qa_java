import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class FelineTest {
    Feline feline = new Feline();
    Feline felineSpy  = Mockito.spy(feline);
    private int kittensCount;
    private int expectedKittensCount;
    public FelineTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }
    @Test
    public void eatMeatTest() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }
    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", felineSpy.getFamily());
    }
    @Parameterized.Parameters //
    public static Object[][] getKittensCount() {
        return new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 2 },
        };
    }
    @Test
    public void getKittensWithParamInvokeReturnParamTest() {
        felineSpy.getKittens(kittensCount);
        Assert.assertEquals(expectedKittensCount, felineSpy.getKittens(kittensCount));
    }
    @Test
    public void getKittensNoParamInvokeReturn1Test() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }
}
