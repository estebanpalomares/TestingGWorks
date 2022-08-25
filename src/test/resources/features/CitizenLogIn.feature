@REGRESSION @UI

  @CITIZEN_LOGIN
  Feature: Test all the scenarios of the Log In Citizen site

    @CITIZEN_LOGIN_SUCCESS
    Scenario: Do a success log in
      Given The user has the Citizen Log In page open in "chrome" browser
      When The user uses a "valid" credentials in Citizen page
      Then The user is logged in Citizen

    @CITIZEN_LOGIN_FAIL
    Scenario Outline: Fail scenarios of Citizen Log In
      Given The user has the Citizen Log In page open in "chrome" browser
      When The user uses a "<testCase>" credentials in Citizen page
      Then The user is not logged in Citizen

      Examples:
      | testCase     |
      | Wrong eMail  |
      | Wrong Pass   |
      | Blank eMail  |
      | Blank Pass   |
