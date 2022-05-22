package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//nav[@class='orbit-header-links international']//a[@href='https://www.bbc.com/news']")
    private WebElement newsTab;
    @FindBy(xpath = "//a[@id='orbit-search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//nav[@class='orbit-header-links international']//a[@href='https://www.bbc.com/sport']")
    private WebElement sportTab;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void openHomePage(String url){
        driver.get(url);
    }

    public void clickSportTab(){
        sportTab.click();
    }



}
