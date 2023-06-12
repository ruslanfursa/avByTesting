package by.av.model;

import by.av.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openModelsList() {
        new Actions(getDriver())
                .moveToElement(getWait10().until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//span[contains(text(), 'Все марки')]"))))
                .doubleClick()
                .perform();
        return this;
    }
    public boolean isCarInList(String brand){
        List <WebElement> brands = getDriver().findElements(By.xpath("//span[@class = 'catalog__title']"));
        for(WebElement element : brands){
            if(brand.equals(element.getText())){
                return true;
            }
        }
        System.out.println(brand + " - There is no such brand in list");
        return false;
    }

    public MainPage login() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Войти')]")).click();
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//input[@id = 'authPhone']"))).sendKeys("298467758");
        getDriver().findElement(By.xpath("//input[@id = 'passwordPhone']"))
                .sendKeys("password");
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver()
                .findElement(By.xpath("//span[contains(text(), 'Войти')]"))).click().perform();
        return this;
    }
}
