import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.UserApi;
import org.example.UserData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static pageobject.MainPage.URL_MAIN_PAGE;

public class BaseClassTest {
    protected WebDriver driver;
    UserApi userApi;
    String random = RandomStringUtils.randomAlphabetic(6);
    String random1 = RandomStringUtils.randomAlphabetic(5);

    @Before
    @Step("set Up")
    public void setUp() {
        //initChrome();
        initYandexBrowser();
        driver.get(URL_MAIN_PAGE);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    @Step("clean Up")
    public void cleanUp(){
        driver.quit();
        RestAssured.baseURI = URL_MAIN_PAGE;
        userApi = new UserApi();
        UserData user;
        user = new UserData(random + "@ya.ru", random);
        userApi.loginUser(user);
        userApi.deleteUser();
    }

    public void initChrome(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public void initYandexBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
    }
}