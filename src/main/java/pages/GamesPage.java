package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamesPage extends BasePage{
    @FindBy(xpath = "//section[contains(@class, 'header')]")
    private WebElement headerSection;

    @FindBy(xpath = "//div[@class='football-oppm-header chameleon-branding-colours']//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--home']")
    private WebElement command1;
    @FindBy(xpath = "//div[@class='football-oppm-header chameleon-branding-colours']//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--away']")
    private WebElement command2;
    @FindBy(xpath = "//div[@class='football-oppm-header chameleon-branding-colours']//span[@class='sp-c-fixture__block']")
    private WebElement scoreCommand1;
    @FindBy(xpath = "//div[@class='football-oppm-header chameleon-branding-colours']//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft']")
    private WebElement scoreCommand2;

    public GamesPage(WebDriver driver){
        super(driver);
    }

    public WebElement getHeaderSection(){
        return headerSection;
    }
    public String getCommand1Title(){
        return command1.getAttribute("innerText");
    }
    public String getCommand2Title(){
        return command2.getAttribute("innerText");
    }
    public String getCommand1Score(){
        return scoreCommand1.getAttribute("innerText");
    }
    public String getCommand2Score(){
        return scoreCommand2.getAttribute("innerText");
    }

}
