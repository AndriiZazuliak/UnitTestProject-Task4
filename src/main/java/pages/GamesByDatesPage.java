package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamesByDatesPage extends BasePage{
    @FindBy(xpath = "//h1")
private WebElement mainTitle;
    @FindBy(xpath = "//a[@href='/sport/football/61185126']")
    private WebElement on29AprilPlay;
    @FindBy(xpath = "//a[@href='/sport/football/60903648']")
    private WebElement on16AprilPlay;
    @FindBy(xpath = "//a[@href='/sport/football/59187626']")
    private WebElement on13NovemberPlay;
    @FindBy(xpath = "//a[@href='/sport/football/60667847']")
    private WebElement on8MarchPlay;
    @FindBy(xpath = "//span[@role='region']")
    private WebElement areaOfGames;


    public GamesByDatesPage(WebDriver driver){
        super(driver);
    }

    public WebElement getAreaOfGames(){
        return areaOfGames;
    }
    public boolean isAreaOfGamesVisible(){
        return areaOfGames.isDisplayed();
    }
    public boolean isMainTitleVisible(){
        return mainTitle.isDisplayed();
    }

    public void selectOn29AprilPlay(){
        on29AprilPlay.click();
    }
    public WebElement getOn29AprilPlay(){
        return on29AprilPlay;
    }

    public void selectOn16AprilPlay(){
        on16AprilPlay.click();
    }
    public WebElement getOn16AprilPlay() {
        return on16AprilPlay;
    }

    public void selectOn13NovemberPlay(){
        on13NovemberPlay.click();
    }
    public WebElement getOn13NovemberPlay() {
        return on13NovemberPlay;
    }

    public void selectOn8MarchPlay(){
        on8MarchPlay.click();
    }
    public WebElement getOn8MarchPlay() {
        return on8MarchPlay;
    }

    public void selectGameDate(final String game){
        switch (game){
            case ("61185126"): on29AprilPlay.click(); break;
            case ("60903648"):on16AprilPlay.click(); break;
            case ("59187626"):on13NovemberPlay.click(); break;
            case ("60667847"):on8MarchPlay.click(); break;
        }
    }

}
