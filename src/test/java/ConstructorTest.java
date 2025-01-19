import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private MainPage objMainPage;
    private WebDriver driver;
    String accessToken;

    @Before
    public void before() {
        driver = WebDriverCreator.createWebDriver();
        objMainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Открыть вкладку 'Соусы'")
    public void checkSauce() {
        objMainPage.openMainPage();
        assertTrue("Ошибка", objMainPage.checkSauce());
    }

    @Test
    @DisplayName("Открыть вкладку 'Булки'")
    public void checkBuns() {
        objMainPage.openMainPage();
        assertTrue("Ошибка", objMainPage.checkBuns());
    }

    @Test
    @DisplayName("Открыть вкладку 'Начинки'")
    public void checkFillings() {
        objMainPage.openMainPage();
        assertTrue("Ошибка", objMainPage.checkFillings());
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserData.deleteUser(accessToken);
        }
        driver.quit();
    }
}
