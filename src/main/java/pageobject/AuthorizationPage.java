package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage {
    private WebDriver driver;

    //поле для ввода имени
    private By inputName = By.xpath(".//label[contains(text(),'Имя')]/parent::div/input");
    //поле для ввода почты
    private By inputEmail = By.xpath(".//label[contains(text(),'Email')]/parent::div/input");
    //поле для ввода пароля
    private By inputPassword = By.xpath(".//label[contains(text(),'Пароль')]/parent::div/input");
    //кнопка Зарегистрироватся
    private By authButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    //надпись Некорректный пароль
    private By uncorrectPassInscription = By.xpath(".//p[contains(text(), 'Некорректный пароль')]");
    //кнопка Войти
    private By loginButton = By.xpath(".//a[contains(text(),'Войти')]");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("set Input Name")
    public void setInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("set Input Email")
    public void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("set Input Password")
    public void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("click Auth Button")
    public void clickAuthButton(){
        driver.findElement(authButton).isEnabled();
        driver.findElement(authButton).click();
    }

    @Step("set Input Data")
    public void setInputData(String name, String email, String password){
        setInputName(name);
        setInputEmail(email);
        setInputPassword(password);
        clickAuthButton();
    }

    @Step("is Visible Uncorrect Pass Inscription")
    public boolean isVisibleUncorrectPassInscription(){
        return driver.findElement(uncorrectPassInscription).isDisplayed();
    }

    @Step("click Login Button")
    public void clickLoginButton(){
        driver.findElement(loginButton).isEnabled();
        driver.findElement(loginButton).click();
    }

}