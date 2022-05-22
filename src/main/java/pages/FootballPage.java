package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FootballPage extends BasePage{
    @FindBy(xpath = "//a[@data-stat-title='Scores & Fixtures']")
    private WebElement scoresFixturesTab;



    public FootballPage(WebDriver driver){
        super(driver);
    }

    public void clickScoresFixturesTab() {
        scoresFixturesTab.click();
    }

    public boolean isScoresFixturesTabVisible(){
        return scoresFixturesTab.isDisplayed();
    }

}
