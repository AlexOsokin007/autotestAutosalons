package autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage{
    @FindBy(xpath = "//select[@name='type']")
    private WebElement selectManufacturer;

    @FindBy(xpath = "//input[contains(@name, 'name')]")
    private WebElement name;

    @FindBy(xpath = "//input[contains(@name, 'vin')]")
    private WebElement vin;

    @FindBy(xpath = "//input[contains(@name, 'engine')]")
    private WebElement engine;

    @FindBy(xpath = "//input[contains(@name, 'old')]")
    private WebElement old;

    @FindBy(xpath = "//input[contains(@name, 'price')]")
    private WebElement price;

    @FindBy(xpath = "//button[contains(text(), 'Добавить')]")
    private WebElement add;

    @FindBy(xpath = "//a[contains(text(), 'Вернуться')]")
    private WebElement beak;

    @FindBy(xpath = "//a[contains(text(), 'Список контрактов')]")
    private WebElement contract;

    public void addCar(String manufacturer,
                        String name,
                        String vin,
                        String engine,
                        String old,
                        String price) {
        new Select(selectManufacturer).selectByVisibleText(manufacturer);

        this.name.sendKeys(name);
        this.vin.sendKeys(vin);
        this.engine.sendKeys(engine);
        this.old.sendKeys(old);
        this.price.sendKeys(price);

        waitForClickableElement(add).click();
        waitForClickableElement(beak).click();
    }

    public void goToContracts() {
        waitForClickableElement(contract).click();
    }
}
