@REGRESSION @UI

@CITY_LOGIN
Feature: Test all the scenarios of the Log In City site

  @CITY_LOGIN_SUCCESS
  Scenario: Do a success log in
    Given I have the FrontDesk Log In page open
    When I use a "valid" credentials in FrontDesk
    Then I am logged in FrontDesk

  @CITY_LOGIN_FAIL
  Scenario Outline: Fail scenarios of City Log In
    Given I have the FrontDesk Log In page open
    When I use a "<testCase>" credentials in FrontDesk
    Then I am not logged in FrontDesk

    Examples:
      | testCase |
      | Wrong eMail  |
      | Wrong Pass   |
      | Blank eMail  |
      | Blank Pass   |
