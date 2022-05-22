package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScoresFixturesPage extends BasePage{
    @FindBy(xpath = "//input[@id='downshift-0-input']")
    private WebElement searchField;
    @FindBy(xpath = "//a//mark[text()='Scottish Championship']")
    private WebElement searchScottishChampionship;
    @FindBy(xpath = "//a//mark[text()='Bayern Munich']")
    private WebElement searchBayernMunich;

    public ScoresFixturesPage(WebDriver driver){
        super(driver);
    }

    public void enterTextToSearchField(final String searchText){
        searchField.clear();
        searchField.sendKeys(searchText);
    }
    public void clickSearchScottishChampionship(){
        searchScottishChampionship.click();
    }
    public void clickSearchBayernMunich(){
        searchBayernMunich.click();
    }
}
