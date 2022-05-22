Feature: Unit
  As a user
  I want to test all some site units
  So that I can be sure that site works correctly

  Scenario Outline: 1 Check games
    Given User opens '<homePage>' page
    And User clicks Sport Tab
    And User clicks Football Tab
    And User clicks Scores & Fixtures Tab
    And User searches '<championship>'
    And User chooses '<month>'
    And User chooses one '<game>'
    And User checks '<score>'
    Examples:
      | homePage            | championship          | month    | game     | score |
      | https://www.bbc.com | Scottish Championship | april    | 61185126 | 3 : 0 |
      | https://www.bbc.com | Scottish Championship | april    | 60903648 | 0 : 1 |
      | https://www.bbc.com | Scottish Championship | november | 59187626 | 1 : 2 |
      | https://www.bbc.com | Bayern Munich         | march    | 60667847 | 7 : 1 |

  Scenario Outline: 2 Check scores
    Given User opens '<homePage>' page
    And User input two team titles: '<team1>' and '<team2>' and search score

    Examples:
      | homePage            | team1             | team2                |
      | https://www.bbc.com | Bayern Munich     | FC Red Bull Salzburg |
      | https://www.bbc.com | Manchester United | Liverpool            |
      | https://www.bbc.com | Barcelona         | Sevilla              |
