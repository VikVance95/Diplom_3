import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import pageobject.AuthorizationPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthorizationTest extends BaseClassTest {

    @Before
    @Step("beginning")
    public void beginning() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegisterButton();
    }

    @Test
    @DisplayName("check Successful Registration Test")
    @Description("Проверка успешной регистрации")
    public void checkSuccessfulRegistrationTest(){
        LoginPage objLoginPage = new LoginPage(driver);
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.setInputData(random,random + "@ya.ru", random);
        objLoginPage.waitLoadingLoginPage();
        Assert.assertTrue(objLoginPage.checkLoadingLoginPage());
    }

    @Test
    @DisplayName("check Bad Password Error Registration Test")
    @Description("вывод ошибки для некорректного пароля")
    public void checkBadPasswordErrorRegistrationTest(){
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.setInputData(random,random + "@ya.ru", random1);
        Assert.assertTrue(objAuthorizationPage.isVisibleUncorrectPassInscription());
    }
}