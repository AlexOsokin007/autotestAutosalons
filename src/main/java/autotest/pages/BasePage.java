package autotest.pages;

import autotest.util.Init;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(){
        this.driver = Init.getDriver();
        PageFactory.initElements(driver, this);//Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса
        wait = new WebDriverWait(driver, 15);
    }

    public WebElement waitForElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element){
        int elementPosition = element.getLocation().getY();
        String js = String.format("window.scroll(0, %s)", elementPosition);
        ((JavascriptExecutor)driver).executeScript(js);
    }
    public void waitForInvisibilityElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
