@REGRESSION @UI

  @CITY_LOGIN
  Feature: Test all the scenarios of the Log In City site

    @CITY_LOGIN_SUCCESS
    Scenario: Do a success log in
      Given A user has the FrontDesk Log In page open in "chrome" browser
      When The user uses a "valid" credentials in FrontDesk page
      Then The user is logged in FrontDesk

    @CITY_LOGIN_FAIL
    Scenario Outline: Fail scenarios of City Log In
      Given A user has the FrontDesk Log In page open in "chrome" browser
      When The user uses a fail "<testCase>" credentials in FrontDesk page
      Then The user is not logged in FrontDesk

      Examples:
      | testCase     |
      | Wrong eMail  |
      | Wrong Pass   |
      | Blank eMail  |
      | Blank Pass   |
