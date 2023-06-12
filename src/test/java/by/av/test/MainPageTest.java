package by.av.test;

import by.av.base.BaseTest;
import by.av.model.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void testIsBrandPresentOnMainPage() {
        Assert.assertTrue(new MainPage(getDriver())
                .openModelsList().isCarInList("Opel"));
    }
}
