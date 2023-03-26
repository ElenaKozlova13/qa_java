import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
@RunWith(Parameterized.class)
public class AnimalTest {

    private String animalKind;
    private List<String> expectedFoodList;

    public AnimalTest (String animalKind, List<String> expectedFoodList) {
        this.animalKind = animalKind;
        this.expectedFoodList = expectedFoodList;
    }

    @Parameterized.Parameters //
    public static Object[][] foodListByAnimalKind() {
        return new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") },
        };
    }
    @Test
    public void getFoodValidAnimalKindTest() throws Exception{
        Animal animal = new Animal();
        List<String> actualFoodList = animal.getFood(animalKind);
        Assert.assertEquals(expectedFoodList, actualFoodList);
    }
    @Test
    public void getFoodThrowsExceptionTest() {
        try {
            Animal animal = new Animal();
            animal.getFood("неведома зверушка");
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
        }
    }
    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String actualFamily = animal.getFamily();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamily, actualFamily);
    }
}
