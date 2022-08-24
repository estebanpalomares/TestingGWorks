@REGRESSION @UI

@CITIZEN_LOGIN
Feature: Test all the scenarios of the Log In Citizen site

  @CITIZEN_LOGIN_SUCCESS
  Scenario: Do a success log in
    Given I have the Citizen Log In page open
    When I use a "valid" credentials in Citizen
    Then I am logged in Citizen

  @CITIZEN_LOGIN_FAIL
  Scenario Outline: Fail scenarios of Citizen Log In
    Given I have the Citizen Log In page open
    When I use a "<testCase>" credentials in Citizen
    Then I am not logged in Citizen

    Examples:
      | testCase |
      | Wrong eMail  |
      | Wrong Pass   |
      | Blank eMail  |
      | Blank Pass   |
