package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;


public class MainPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), 'Управление')]")
    private WebElement admin;

    @FindBy(xpath = "//input[@name='filter']")
    private WebElement filterManufacturer;

    @FindBy(xpath = "//button[text()='Найти по типу']")
    private WebElement searchManufacturer;

    @FindBy(xpath = "//div[contains(@class, 'card my')]")
    private List<WebElement> cars;

    public void goToAdmin(){
        waitForClickableElement(admin).click();
    }

    public void checkCar(String name){
        Assert.that(
                cars.get(cars.size() - 1).findElement(By.xpath(".//li[contains(text(), 'Название')]")).getText().contains(name),
                "Название последний модели не " + name);
    }

    public int getLastCar(){
        cars.get(cars.size() - 1).findElement(By.xpath(".//a")).click();
        return cars.size();
    }

    public void checkCount(int count){
        Assert.that( cars.size() == cars.size() + count, "Колличество автомобилей не уменьшилось на 1");
    }

    public void checkFilterManufacturer(String manufacturer){
        waitForElement(filterManufacturer).sendKeys(manufacturer);
        waitForClickableElement(searchManufacturer).click();

        for (WebElement car : cars){
            Assert.that(
                    car.findElement(By.xpath(".//li[contains(text(), 'Марка')]")).getText().contains(manufacturer),
                    "Есть автомобиль с маркой не " + manufacturer);
        }
    }
}
