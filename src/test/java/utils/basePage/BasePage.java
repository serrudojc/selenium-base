package utils.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Esta clase tiene metodos comunes que herada a las demas paginas (protected para pasar por herencia)
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Constructor. Paramentro: necesito el driver, pq si no no puedo interactuar con la verdadera pagina web
    public BasePage(WebDriver driver){
        this.driver = driver;
        //usamos un complemento al Page Object Model, el Page Factory
        //Es para inicializar previamente los elementos de la pagina apenas se construya
        PageFactory.initElements(driver, this);
        //Configuramos un timeout global
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    //Creamos unos waits genericos
    public void waitToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    //Espera implicitas. Mala practica, solo usar en caso de ser necesario.
    public void waitSomeSeconds(int time) {
        try{
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}