package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StepsDefinitions {
    WebDriver driver;
    HomePage homePage;
    FootballPage footballPage;
    ScoresFixturesPage scoresFixturesPage;
    GamesByDatesPage gamesByDatesPage;
    GamesByMonthsPage gamesByMonthsPage;
    GamesPage gamesPage;
    SportPage sportPage;
    ScoreBoard scoreBoard;

    PageFactoryManager pageFactoryManager;

    private static final long WAIT_TIME = 20;

    @Before
    public void setupForTests(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(WAIT_TIME);
    }
    @And("User clicks Sport Tab")
    public void openSportTab(){
        homePage.clickSportTab();
    }
    @And("User clicks Football Tab")
    public void openFootballTab(){
        sportPage = pageFactoryManager.getSportPage();
        sportPage.waitForPageLoadComplete(WAIT_TIME);
        sportPage.clickFootballTab();
    }
    @And("User clicks Scores & Fixtures Tab")
    public void openScoresFixturesTab(){
        footballPage = pageFactoryManager.getFootballPage();
        footballPage.waitForPageLoadComplete(WAIT_TIME);
        assertTrue(footballPage.isScoresFixturesTabVisible());
        footballPage.clickScoresFixturesTab();
    }
    @And("User searches {string}")
    public void searchChampionshipOrTeam(final String championship){
        scoresFixturesPage = pageFactoryManager.getScoresFixturesPage();
        scoresFixturesPage.enterTextToSearchField(championship);
        scoresFixturesPage.waitForPageLoadComplete(WAIT_TIME);
        if(championship.equals("Scottish Championship")){
        scoresFixturesPage.clickSearchScottishChampionship();
        }else if(championship.equals("Bayern Munich")){
            scoresFixturesPage.clickSearchBayernMunich();
        }
        scoresFixturesPage.waitForPageLoadComplete(WAIT_TIME);
    }
    @And("User chooses {string}")
    public void searchMonth(final String month){
        gamesByMonthsPage = pageFactoryManager.getGamesByMonthsPage();
        gamesByMonthsPage.waitForPageLoadComplete(WAIT_TIME);
        gamesByMonthsPage.waitForVisibility(WAIT_TIME, gamesByMonthsPage.getMonth());
        gamesByMonthsPage.selectMonth(month);
    }
    @And("User chooses one {string}")
    public void searchGameDate(final String game){
        gamesByDatesPage = pageFactoryManager.getGamesByDatesPage();
        gamesByDatesPage.waitForPageLoadComplete(WAIT_TIME);
        assertTrue(gamesByDatesPage.isAreaOfGamesVisible());
        gamesByDatesPage.waitForVisibility(WAIT_TIME, gamesByDatesPage.getAreaOfGames());
        gamesByDatesPage.waitForClickable(WAIT_TIME, gamesByDatesPage.getAreaOfGames());
        assertTrue(gamesByDatesPage.isMainTitleVisible());
        gamesByDatesPage.selectGameDate(game);
    }
    @And("User checks {string}")
    public void checkScore(final String score){
        gamesPage = pageFactoryManager.getGamesPage();
        gamesPage.waitForClickable(WAIT_TIME, gamesPage.getHeaderSection());
        String title1 = gamesPage.getCommand1Title();
        String title2 = gamesPage.getCommand2Title();
        String score1 = gamesPage.getCommand1Score();
        String score2 = gamesPage.getCommand2Score();
        String foundScore = score1 + " : " + score2;
        System.out.println(title1 + " - " + score1 + " : " + score2 + " - " + title2);
        assertEquals(foundScore, score);
    }

    @And("User input two team titles: {string} and {string} and search score")
    public void checkScore(final String team1, final String team2){
        scoreBoard = pageFactoryManager.getScoreBoard();
        String score = scoreBoard.getScore(team1, team2);
        System.out.println(score);
    }

    @After
    public void tearDown(){driver.quit();}
}