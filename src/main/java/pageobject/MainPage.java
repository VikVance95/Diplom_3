package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final static String mainPage = "https://stellarburgers.nomoreparties.site/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginAccountButton = By.xpath(".//*[text() = 'Войти в аккаунт']"); //кнопка "Войти в аккаунт"
    private final By personalAreaButton = By.xpath(".//*[text() = 'Личный Кабинет']"); //кнопка "Личный Кабинет"

    private final By bunsButton = By.xpath(".//span[text()='Булки']/.."); //вкладка "Булки"

    private final By sauceButton = By.xpath("//span[text()='Соусы']/.."); //вкладка "Соусы"

    private final By fillingButton = By.xpath("//span[text()='Начинки']/.."); //вкладка "Начинки"

    private final By orderButton = By.className("button_button__33qZ0"); //кнопка "Оформить заказ"

    private final By bunElement = By.xpath(".//*/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By sauceElement = By.xpath(".//*/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingElement = By.xpath(".//*/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    @Step("Открыть главную страницу")
    public void openMainPage(){
        driver.get(mainPage);
    }

    @Step("Войти в аккаунт на главной странице")
    public void checkAuthorization() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginAccountButton));

        Object elementLoginAccountButton = driver.findElement(loginAccountButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementLoginAccountButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(loginAccountButton));

        driver.findElement(loginAccountButton).click();
    }

    @Step("Войти в личный кабинет")
    public void checkPersonalArea() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(personalAreaButton));

        driver.findElement(personalAreaButton).click();
    }

    @Step("Загрузка главной страницы, отображение кнопки <Оформить заказ>")
    public Object checkOrderButton () {
        WebElement textButton = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));

        return textButton.getText();
    }

    @Step("Открытие вкладки с булками")
    public boolean checkBuns() {
        driver.findElement(sauceButton).click();
        driver.findElement(bunsButton).click();
        return driver.findElement(bunElement).isDisplayed();
    }
    @Step("Открытие вкладки с соусами")
    public boolean checkSauce() {
        driver.findElement(sauceButton).click();
        return driver.findElement(sauceElement).isDisplayed();
    }

    @Step("Открытие вкладки с начинками")
    public boolean checkFillings() {
        driver.findElement(fillingButton).click();
        return driver.findElement(fillingElement).isDisplayed();
    }
}
