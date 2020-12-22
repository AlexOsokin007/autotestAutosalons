package autotest.steps;

import autotest.pages.*;
import cucumber.api.java.bs.A;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;


public class PageSteps {
    static int countCars = 0;
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    ContractPage contractPage = new ContractPage();
    AdminContractPage adminContractPage = new AdminContractPage();

    @Когда("Залогиниться под пользователем \"(.*)\" с паролем \"(.*)\"")
    public void inputItemStep(String login, String password){
        loginPage.login(login, password);
    }

    @Тогда("Добавить автомобиль макри \"(.*)\" с названием \"(.*)\", с ВИН номером \"(.*)\", мощностью \"(.*)\", с \"(.*)\" годом выпуска, за \"(.*)\" рублей")
    public void clickSearchButtonStep(String manufacturer,
                                      String name,
                                      String vin,
                                      String engine,
                                      String old,
                                      String price){
        mainPage.goToAdmin();
        adminPage.addCar(manufacturer, name, vin, engine, old, price);
    }

    @Тогда("Провенряем, что модель последней добавленнной машины \"(.*)\"")
    public void clickSearchButtonStep(String name){
        mainPage.checkCar(name);
    }

    @Тогда("Бронируем поледний добавленный автомобиль")
    public void getLastCarStep(){
        countCars = mainPage.getLastCar();
    }

    @Когда("Заполняем контракт на \"(.*)\" с телефоном \"(.*)\" и почтой \"(.*)\"")
    public void createContractStep(String name, String phoneNumber, String email){
        contractPage.createContract(name, phoneNumber, email);
        contractPage.backMenu();
    }

    @Тогда("Проверяем, колличество автомобилей уменьшилось на 1")
    public void checkCountCarsStep(){
        mainPage.checkCount(countCars);
    }

    @Тогда("Перейдем на страницу контарктов")
    public void goToContractsStep(){
        mainPage.goToAdmin();
        adminPage.goToContracts();
    }

    @Тогда("Провенряем, что имя последнего покупателя \"(.*)\"")
    public void checkLastContractStep(String name){
        adminContractPage.checkLastContract(name);
    }

    @Тогда("Сортируем автомобили по марке \"(.*)\" и проверяем сортировку")
    public void checkFilterManufacturer(String manufacturer){
        mainPage.checkFilterManufacturer(manufacturer);
    }



    /*@Тогда("Нажимаем кнопку поиска")
    public void clickSearchButtonStep(){
        mainPage.clickSearchButton();
    }

    @Когда("Ограничиваем цену до: \"(.*)\"")
    public void inputRangeFilterToStep(String item){
        itemsPage.inputRangeFilterTo(item);
    }

    @Когда("Кликаем на чекбокс: \"(.*)\"")
    public void clickCheckBoxStep(String item){
        itemsPage.clickCheckBox(item);
    }

    @Когда("Откроем все бренды")
    public void  brandShowAllStep(){
        itemsPage.brandShowAll();
    }

    @Когда("Ищем по всем значениям бренда: \"(.*)\"")
    public void  brandShowAllStep(String item){
        itemsPage.brandClick(item);
    }



    @Тогда("Выбираем товары с четностью: \"(.*)\"")
    public void inputInBusketStep(String item){
        boolean parity;
        if(item.equalsIgnoreCase("четные")){
            parity = true;
        }
        else{
            parity = false;
        }
        items = itemsPage.inputInBusket(parity);
        for (String it : items){
            System.out.println(it);
        }
    }

    @Когда("Кликаем на корзину")
    public void clickBusketStep(){
        itemsPage.clickBusket();
    }
    @Тогда("Преверяем товары в корзине")
    public void checkItemsStep(){
        busketPage.checkItems(items);
    }
    @Тогда("Проверка: Ваша корзина - \"(.*)\"")
    public void checkTotalItemsStep(String totalItems){
        busketPage.checkTotalItems(totalItems);
    }
    @Когда("Выполняем действие: \"(.*)\"")
    public void busketActionStep(String аctionItem){
        busketPage.busketAction(аctionItem);
    }
    @Тогда("Проверка, что страница содержит эелемент: \"(.*)\"")
    public void checkTitleStep(String item){
        busketPage.checkTitle(item);
    }
    @Тогда("Приложить файл отчет")
    public void attachmentStep(){
        Busket busket = new Busket();
        saveTextLog("Busket contents", busket.toString() + " Товар с максимальной ценой: " + busket.getMaxPrice());

    }
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        return message;
    }*/
}
