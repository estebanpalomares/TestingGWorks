@REGRESSION @UI

  @MASTER_LOGIN
  Feature: Test all the scenarios of the Log In Master site

    @MASTER_LOGIN_SUCCESS
    Scenario: Do a success log in
      Given A user has the Master Log In page open in "chrome" browser
      When The user uses a "valid" credentials in Master page
      Then The user is logged in

    @MASTER_LOGIN_FAIL
    Scenario Outline: Fail scenarios of Master Log In
      Given A user has the Master Log In page open in "chrome" browser
      When The user uses a "<testCase>" credentials in Master page
      Then The user is not logged in

      Examples:
      | testCase     |
      | Wrong eMail  |
      | Wrong Pass   |
      | Blank eMail  |
      | Blank Pass   |
