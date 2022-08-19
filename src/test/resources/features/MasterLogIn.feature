@REGRESSION @UI

  @MASTER_LOGIN
  Feature: Test all the scenarios of the Log In Master site

    Scenario: Do a success log in
      Given I have the Master Log In page open
      When I use a valid credentials
      Then I am logged in