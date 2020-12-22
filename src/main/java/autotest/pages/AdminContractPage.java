package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

public class AdminContractPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'card my')]")
    private List<WebElement> cars;

    public void checkLastContract(String name){
        Assert.that(
                cars.get(cars.size() - 1).findElement(By.xpath(".//li[contains(text(), 'Имя')]")).getText().contains(name),
                "Имя покупателя не " + name);
    }
}
