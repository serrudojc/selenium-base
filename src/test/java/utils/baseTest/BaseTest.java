package utils.baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utils.MyDriver;

public class BaseTest {

    MyDriver driver;

    //Con BeforeMethod me permite hacer una accion antes que se ejecute un metodo de test
    //Parameters, nos permite enviar parametros al test

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "url" })
    public void beforeMethod(String browser, String url) {
        driver = new MyDriver(browser);
        driver.getDriver().manage().window().maximize();
        navigateTo(url);
    }

    public void navigateTo(String url) {
        driver.getDriver().get(url);
    }

    public HomePage loadFirstPage() {
        return new HomePage(driver.getDriver());
    }

    @AfterMethod()
    public void afterMethod() {
        driver.getDriver().close();
    }
}
