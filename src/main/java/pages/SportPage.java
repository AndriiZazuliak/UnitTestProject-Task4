package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportPage extends BasePage{

    @FindBy(xpath = "//ul[@class='ssrcss-min3p3-StyledMenuList e14xdrat1']//a[@href='/sport/football']/span")
    private WebElement footballTab;

    public SportPage(WebDriver driver){
        super(driver);
    }

    public void clickFootballTab(){
        footballTab.click();
    }
}
