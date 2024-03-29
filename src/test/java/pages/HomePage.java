package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchInput")
    private WebElement searchInput;
    @FindBy(css = ".pure-button-primary-progressive")
    private WebElement searchButton;

    public ResultPage searchText(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
        return new ResultPage(super.getDriver());
    }
}
