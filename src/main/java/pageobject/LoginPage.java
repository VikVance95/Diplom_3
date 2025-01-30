package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    //поле для ввода почты
    private By inputEmail = By.xpath(".//label[contains(text(),'Email')]/parent::div/input");
    //поле для ввода пароля
    private By inputPass = By.xpath(".//label[contains(text(),'Пароль')]/parent::div/input");
    //кнопка Войти
    private By loginButton = By.xpath(".//button[contains(text(),'Войти')]");
    // кнопка Зарегистрироваться
    private By registerButton = By.xpath(".//a[contains(text(),'Зарегистрироваться')]");
    //надпись Вход
    private By inscriptionLogin = By.xpath(".//main/div/h2");
    //кнопка Восстановить пароль
    private By passwordRecoveryButton = By.xpath(".//a[contains(text(),'Восстановить пароль')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("click Register Button")
    public void clickRegisterButton(){
        driver.findElement(registerButton).isEnabled();
        driver.findElement(registerButton).click();
    }

    @Step("check Loading Login Page")
    public boolean checkLoadingLoginPage() {
        return driver.findElement(inscriptionLogin).isDisplayed();
    }

    @Step("set Input Email")
    public void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("set Input Password")
    public void setInputPassword(String password) {
        driver.findElement(inputPass).sendKeys(password);
    }

    @Step("click Login Button")
    public void clickLoginButton(){
        driver.findElement(loginButton).isEnabled();
        driver.findElement(loginButton).click();
    }

    @Step("set Input Data")
    public void setInputData(String email, String password){
        setInputEmail(email);
        setInputPassword(password);
        clickLoginButton();
    }

    @Step("click Password Recovery Button")
    public void clickPasswordRecoveryButton(){
        driver.findElement(passwordRecoveryButton).isEnabled();
        driver.findElement(passwordRecoveryButton).click();
    }

    @Step("wait Loading Login Page")
    public void waitLoadingLoginPage(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(inscriptionLogin));
    }
}