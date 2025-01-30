import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.UserApi;
import org.example.UserData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AccountProfilePage;
import pageobject.LoginPage;
import pageobject.MainPage;

import static pageobject.MainPage.URL_MAIN_PAGE;

public class FollowsTest extends BaseClassTest{
    UserData user;
    @Before
    @Step("set Up")
    public void settUp(){
        RestAssured.baseURI = URL_MAIN_PAGE;
        userApi = new UserApi();
        user = new UserData(random + "@ya.ru", random, random);
        userApi.createUser(user);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLoginAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setInputData(random + "@ya.ru", random);
    }

    @Test
    @DisplayName("follow Personal Account Button Test")
    @Description("проверка перехода по клику на «Личный кабинет»")
    public void followPersonalAccountButtonTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.waitLoadingProfilePage();
        Assert.assertTrue(objAccountProfilePage.checkLoadingProfilePage());
    }

    @Test
    @DisplayName("follow Constructor Button Test")
    @Description("Проверка перехода по клику на «Конструктор»")
    public void followConstructorButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.clickConstructorButton();
        objMainPage.waitLoadingMainPage();
        Assert.assertTrue(objMainPage.isInscriptionCollectBurgerVisible());
    }

    @Test
    @DisplayName("follow Logo Test")
    @Description("Проверка перехода по клику на логотип")
    public void followLogoTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.clickLogo();
        objMainPage.waitLoadingMainPage();
        Assert.assertTrue(objMainPage.isInscriptionCollectBurgerVisible());
    }

    @Test
    @DisplayName("follow Exit Button Test")
    @Description("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void followExitButtonTest(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.clickExitButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitLoadingLoginPage();
        Assert.assertTrue(objLoginPage.checkLoadingLoginPage());
    }
}