package autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.TreeMap;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//a[contains(text(),'Войти')]")
    private WebElement enter;

    @FindBy(xpath = "//input[contains(@name,'username')]")
    private WebElement login;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private WebElement entrance;

    public void login(String login, String password){
        waitForClickableElement(enter).click();

        waitForElement(this.login).sendKeys(login);
        waitForElement(this.password).sendKeys(password);

        waitForClickableElement(entrance).click();
    }
}