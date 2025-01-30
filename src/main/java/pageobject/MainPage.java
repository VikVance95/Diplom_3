package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public static final String URL_MAIN_PAGE = "https://stellarburgers.nomoreparties.site";

    //кнопка Личный кабинет
    private By personalAccountButton = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    //кнопка Войти в аккаунт
    private By loginAccountButton = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");
    //Кнопка Оформить заказ
    private By createOrderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");
    //надпись Соберите бургер
    private By inscriptionCollectBurger = By.xpath(".//h1[contains(text(),'Соберите бургер')]");
    //кнопка Булки
    private By bunsButton = By.xpath(".//span[contains(text(),'Булки')]/parent::div");
    //кнопка Соусы
    private By saucesButton = By.xpath(".//span[contains(text(),'Соусы')]/parent::div");
    //кнопка Начинки
    private By fillingsButton = By.xpath(".//span[contains(text(),'Начинки')]/parent::div");
    //активная вкладка раздела
    private By activeSection = By.xpath(".//div[contains(@class,'current')]/span");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("click Personal Account Button")
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).isEnabled();
        driver.findElement(personalAccountButton).click();
    }

    @Step("click Login Account Button")
    public void clickLoginAccountButton(){
        driver.findElement(loginAccountButton).isEnabled();
        driver.findElement(loginAccountButton).click();
    }

    @Step("is Create Order Button Visible")
    public boolean isCreateOrderButtonVisible(){
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("is Inscription Collect Burger Visible")
    public boolean isInscriptionCollectBurgerVisible(){
        return driver.findElement(inscriptionCollectBurger).isDisplayed();
    }

    @Step("click Buns Button")
    public void clickBunsButton(){
        driver.findElement(bunsButton).isEnabled();
        driver.findElement(bunsButton).click();
    }

    @Step("click Sauces Button")
    public void clickSaucesButton(){
        driver.findElement(saucesButton).isEnabled();
        driver.findElement(saucesButton).click();
    }

    @Step("click Fillings Button")
    public void clickFillingsButton(){
        driver.findElement(fillingsButton).isEnabled();
        driver.findElement(fillingsButton).click();
    }

    @Step("get Button Text")
    public String getButtonText(){
        return driver.findElement(activeSection).getText();
    }

    @Step("wait Loading Main Page")
    public void waitLoadingMainPage(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(inscriptionCollectBurger));
    }

    @Step("wait Authorization")
    public void waitAuthorization (){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }
}
