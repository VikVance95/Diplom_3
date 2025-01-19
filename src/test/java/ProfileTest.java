import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import pageobject.RegisterPage;

import static org.junit.Assert.assertEquals;

public class ProfileTest {

    private LoginPage objLoginPage;
    private MainPage objMainPage;
    private WebDriver driver;
    private String email;
    private String password;
    String accessToken;

    @Before
    public void before() {
        driver = WebDriverCreator.createWebDriver();

        UserData userData = new UserData();
        String name = userData.getRandomName();
        email = userData.getRandomEmail();
        password = userData.getRandomPassword();
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.createUser(name,email,password);
        objLoginPage = new LoginPage(driver);
        objMainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Login to personal account")
    public void personalAccountTest() {
        objLoginPage.login(email, password);
        objMainPage.checkPersonalArea();
        ProfilePage objProfilePage = new ProfilePage(driver);
        assertEquals("Entering was  Failed", "Выход", objProfilePage.checkLogInPersonalAccount());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void checkExitTest() {
        objLoginPage.login(email, password);
        objMainPage.checkPersonalArea();
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.clickExitButton();
        assertEquals("ExitFailed", "Войти", objLoginPage.checkLoginButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void checkLogoTest() {
        objLoginPage.login(email, password);
        objMainPage.checkPersonalArea();
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.clickLogoButton();
        assertEquals("LogoButtonFailed", "Оформить заказ", objMainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void checkConstructorTest() {
        objLoginPage.login(email, password);
        objMainPage.checkPersonalArea();
        ProfilePage objProfilePage = new ProfilePage(driver);
        objProfilePage.clickConstructorButton();
        assertEquals("ConstructorButtonFailed", "Оформить заказ", objMainPage.checkOrderButton());
    }
    @After
    public void tearDown() {
        if (accessToken != null) {
            UserData.deleteUser(accessToken);
        }
        driver.quit();
    }
}
