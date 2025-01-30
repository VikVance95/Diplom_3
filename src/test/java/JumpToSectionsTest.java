import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class JumpToSectionsTest extends BaseClassTest{

    @Test
    @DisplayName("jump To Section Sauces")
    @Description("Проверка работы перехода к разделу «Соусы»")
    public void jumpToSectionSauces(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSaucesButton();
        assertEquals("Не сработал переход к разделу Соусы", "Соусы", objMainPage.getButtonText());
    }

    @Test
    @DisplayName("jump To Section Fillings")
    @Description("Проверка работы перехода к разделу «Начинки»")
    public void jumpToSectionFillings(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillingsButton();
        assertEquals("Не сработал переход к разделу Начинки", "Начинки", objMainPage.getButtonText());
    }

    @Test
    @DisplayName("jump To Section Buns")
    @Description("Проверка работы перехода к разделу «Булки»")
    public void jumpToSectionBuns(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSaucesButton();
        objMainPage.clickBunsButton();
        assertEquals("Не сработал переход к разделу Булки", "Булки", objMainPage.getButtonText());
    }
}