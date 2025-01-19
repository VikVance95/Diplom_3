import driver.WebDriverCreator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.ForgotPassPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private RegisterPage objRegisterPage;
    private LoginPage objLoginPage;
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
        objRegisterPage = new RegisterPage(driver);
        objRegisterPage.openRegisterPage();
        objRegisterPage.createUser(name,email,password);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void mainPageTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.checkAuthorization();
        objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        assertEquals("Ошибка", "Войти", objMainPage.checkOrderButton());
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void personalAccountTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.checkPersonalArea();
        objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        assertEquals("Ошибка", "Войти", objMainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void registrationLinkTest() {
        objRegisterPage.openRegisterPage();
        objRegisterPage.clickAuthLinkLogin();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email, password);
        MainPage objMainPage = new MainPage(driver);
        assertEquals("Ошибка", "Войти", objMainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void restorePasswordLinkTest() {
        ForgotPassPage objForgotPassPage = new ForgotPassPage(driver);
        objForgotPassPage.openRestorePage();
        objForgotPassPage.clickForgotPassword();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(email,password);
        MainPage objMainPage = new MainPage(driver);
        assertEquals("Ошибка", "Войти", objMainPage.checkOrderButton());
    }
    @After
    public void tearDown() {
        if (accessToken != null) {
            UserData.deleteUser(accessToken);
        }
        driver.quit();
    }
}
