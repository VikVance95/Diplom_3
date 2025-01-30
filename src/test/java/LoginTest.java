import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.UserApi;
import org.example.UserData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AuthorizationPage;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;

import static pageobject.MainPage.URL_MAIN_PAGE;

public class LoginTest extends BaseClassTest {
    UserData user;
    @Before
    @Step("set Up")
    public void settUp(){
        RestAssured.baseURI = URL_MAIN_PAGE;
        userApi = new UserApi();
        user = new UserData(random + "@ya.ru", random, random);
        Response response = userApi.createUser(user);
    }

    @Test
    @DisplayName("login With Login Account Button Test")
    @Description("Проверка входа по кнопке «Войти в аккаунт» на главной странице")
    public void loginWithLoginAccountButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLoginAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInputData(random + "@ya.ru", random);
        objMainPage.waitAuthorization();
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("login With Personal Account Button Test")
    @Description("Проверка входа через кнопку «Личный кабинет»")
    public void loginWithPersonalAccountButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInputData(random + "@ya.ru", random);
        objMainPage.waitAuthorization();
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("login With Registration Form Login Button Test")
    @Description("Проверка входа через кнопку в форме регистрации")
    public void loginWithRegistrationFormLoginButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegisterButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.clickLoginButton();
        objLoginPage.setInputData(random + "@ya.ru", random);
        objMainPage.waitAuthorization();
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("login With Password Recovery Button Test")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void loginWithPasswordRecoveryButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickPasswordRecoveryButton();
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        objForgotPasswordPage.clickLoginButton();
        objLoginPage.setInputData(random + "@ya.ru", random);
        objMainPage.waitAuthorization();
        Assert.assertTrue(objMainPage.isCreateOrderButtonVisible());
    }
}