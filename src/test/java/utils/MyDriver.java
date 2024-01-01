package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Clase para manejar el driver
public class MyDriver {
    private WebDriver driver;

    //Constructor, Parametro que identifica el browser
    public MyDriver(String browser){
        if("Firefox".equals(browser)){
            driver = new FirefoxDriver();
        }else{
            //String con el path donde estamos
            String path = System.getProperty("user.dir");
            System.out.println(path);
            //Seteamos el path donde esta el chromedriver, con un path relativo
            System.setProperty("webdriver.chrome.driver", path+"\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}