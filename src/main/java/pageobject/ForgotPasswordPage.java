package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    //кнопка Войти
    private By loginButton = By.xpath(".//a[contains(text(),'Войти')]");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("click Login Button")
    public void clickLoginButton(){
        driver.findElement(loginButton).isEnabled();
        driver.findElement(loginButton).click();
    }
}