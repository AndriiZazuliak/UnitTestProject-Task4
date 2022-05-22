package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamesByMonthsPage extends BasePage{

    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-05')]")
    private WebElement may;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-06')]")
    private WebElement june;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-07')]")
    private WebElement july;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-08')]")
    private WebElement august;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-09')]")
    private WebElement september;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-10')]")
    private WebElement october;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-11')]")
    private WebElement november;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2021-12')]")
    private WebElement december;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2022-01')]")
    private WebElement january;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2022-02')]")
    private WebElement february;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2022-03')]")
    private WebElement march;
    @FindBy(xpath = "//ul/li/a[contains(@href, '2022-04')]")
    private WebElement april;
    @FindBy(xpath = "//li[contains(@data-reactid,'.2.0.0.1.4.0.1.0.1.$11')]")
    private WebElement monthCase;


    public GamesByMonthsPage(WebDriver driver){
        super(driver);
    }
    public WebElement getMonth(){
        return monthCase;
    }

    public void selectMonth(final String month){
        switch (month){
            case ("january"): january.click(); break;
            case ("february"): february.click(); break;
            case ("march"): march.click(); break;
            case ("april"): april.click(); break;
            case ("may"): may.click(); break;
            case ("june"): june.click(); break;
            case ("july"): july.click(); break;
            case ("august"): august.click(); break;
            case ("september"): september.click(); break;
            case ("october"): october.click(); break;
            case ("november"): november.click(); break;
            case ("december"): december.click(); break;
        }
    }

}
