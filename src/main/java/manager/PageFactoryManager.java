package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SportPage getSportPage() {
        return new SportPage(driver);
    }

    public FootballPage getFootballPage() {
        return new FootballPage(driver);
    }

    public ScoresFixturesPage getScoresFixturesPage() {
        return new ScoresFixturesPage(driver);
    }

    public GamesByMonthsPage getGamesByMonthsPage() {
        return new GamesByMonthsPage(driver);
    }

    public GamesByDatesPage getGamesByDatesPage() {
        return new GamesByDatesPage(driver);
    }

    public GamesPage getGamesPage() {
        return new GamesPage(driver);
    }

    public ScoreBoard getScoreBoard() {
        return new ScoreBoard(driver);
    }

}