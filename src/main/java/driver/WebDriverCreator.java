package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {
    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    public static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    public static WebDriver createYandexDriver() {
        System.setProperty ("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("src/main/resources/webdriver/yandexdriver.exe");
        return new ChromeDriver(options);
    }
}
