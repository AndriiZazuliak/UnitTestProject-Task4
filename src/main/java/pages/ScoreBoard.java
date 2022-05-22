package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ScoreBoard extends BasePage{
    private static final long WAIT_TIME = 20;
    public ScoreBoard(WebDriver driver){
        super(driver);
    }

    public String getScore(final String team1, final String team2){
        String score = "empty";
        driver.findElement(By.xpath("//nav[@class='orbit-header-links international']//a[@href='https://www.bbc.com/sport']")).click();
        waitForPageLoadComplete(WAIT_TIME);
        driver.findElement(By.xpath("//ul[@class='ssrcss-min3p3-StyledMenuList e14xdrat1']//a[@href='/sport/football']")).click();
        waitForPageLoadComplete(WAIT_TIME);
        driver.findElement(By.xpath("//a[@data-stat-title='Scores & Fixtures']")).click();
        waitForPageLoadComplete(WAIT_TIME);
        driver.findElement(By.xpath("//input[@id='downshift-0-input']")).sendKeys(team1);
        String xPathTeam1 = "//a//mark[text()='" + team1 + "']";
        WebElement element1 = (new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathTeam1))));
        element1.click();

        waitForPageLoadComplete(WAIT_TIME);
        for(int i = 11; i >= 0; i--){
            String monthXpath = "//li[contains(@data-reactid,'.2.0.0.1.4.0.1.0.1.$" + i + "')]";
            waitForClickable(WAIT_TIME, driver.findElement(By.xpath(monthXpath)));
            driver.findElement(By.xpath(monthXpath)).click();
            waitForVisibility(WAIT_TIME, driver.findElement(By.xpath("//span[@role='region']")));
            waitForPageLoadComplete(WAIT_TIME);

            List<WebElement> monthGames = driver.findElements(By.xpath("//li[@class='gs-o-list-ui__item gs-u-pb-']"));
            int countOfMonthGames = monthGames.size();
            for(int j = 0; j <countOfMonthGames - 1; j++){
                String comm1Xpath = "(//a//span/abbr[contains(@class, 'team')])[" + ( 2 * j + 1 ) + "]";
                String comm2Xpath = "(//a//span/abbr[contains(@class, 'team')])[" + ( 2 * j + 2 ) + "]";
                String score1Xpath = "(//a//span[@class='sp-c-fixture__block'])[" + ( 2 * j + 1 ) + "]";
                String score2Xpath = "(//a//span[@class='sp-c-fixture__block'])[" + ( 2 * j + 2 ) + "]";
              
                String command1 = driver.findElement(By.xpath(comm1Xpath)).getAttribute("title");
                String command2 = driver.findElement(By.xpath(comm2Xpath)).getAttribute("title");
                String score1 = driver.findElement(By.xpath(score1Xpath)).getAttribute("innerText");
                String score2 = driver.findElement(By.xpath(score2Xpath)).getAttribute("innerText");

                if(command1.equals(team2)){
                    score = team2 + " - " + score2 + " : " + score1 + " - " + team1;
                    return score;
                }else if(command2.equals(team2)){
                    score = team1 + " - " + score1 + " : " + score2 + " - " + team2;
                    return score;
                }
            }
        }
        return score;
    }
}
