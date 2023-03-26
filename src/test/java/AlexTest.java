import com.example.Alex;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class AlexTest {
   @Mock
    Feline feline;

    @Test
    public void getFriendsTest() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedFriendList = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actualFriendList = alex.getFriends();
        Assert.assertEquals(expectedFriendList, actualFriendList);
    }
    @Test
    public void getPlaceOfLivingTest() throws Exception {
        Alex alex = new Alex(feline);
        String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";
        String actualPlaceOfLiving = alex.getPlaceOfLiving();
        Assert.assertEquals(expectedPlaceOfLiving, actualPlaceOfLiving);
    }
    @Test
    public void getKittensReturn0Test() throws Exception {
        Alex alex = new Alex(feline);
        alex.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(0);
    }
}
