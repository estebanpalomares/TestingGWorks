@REGRESSION @UI

  @MASTER_LOGIN
  Feature: Test all the scenarios of the Log In Master site

    @MASTER_LOGIN_SUCCESS
    Scenario: Do a success log in
      Given I have the Master Log In page open
      When I use a "valid" credentials
      Then I am logged in

    @MASTER_LOGIN_FAIL
    Scenario Outline: Fail scenarios of Master Log In
      Given I have the Master Log In page open
      When I use a "<testCase>" credentials
      Then I am not logged in

      Examples:
      | testCase |
      | Wrong eMail  |
      | Wrong Pass   |
      | Blank eMail  |
      | Blank Pass   |
