package autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractPage extends BasePage{

    @FindBy(xpath = "//input[contains(@name,'u_name')]")
    private WebElement name;

    @FindBy(xpath = "//input[contains(@name,'tel')]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    private WebElement email;

    @FindBy(xpath = "//button[contains(text(),'Купить')]")
    private WebElement buy;

    @FindBy(xpath = "//a[contains(text(), 'вернуться')]")
    private WebElement back;

    public void createContract(String name, String phoneNumber, String email){
        waitForElement(this.name).sendKeys(name);
        waitForElement(this.phoneNumber).sendKeys(phoneNumber);
        waitForElement(this.email).sendKeys(email);
        buy.click();
    }

    public void backMenu(){
        waitForClickableElement(this.back).click();
    }
}
