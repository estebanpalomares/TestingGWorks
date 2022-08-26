@REGRESSION @UI

  @CITIZEN_LOGIN
  Feature: Test all the scenarios of the Log In Citizen site

    @CITIZEN_LOGIN_SUCCESS
    Scenario Outline: Do a Citizen success log in on "<browser>"
      Given The user has the Citizen Log In page open in "<browser>" browser
      When The user uses a "valid" credentials in Citizen page
      Then The user is logged in Citizen

      Examples:
        | browser |
        | chrome  |
        | firefox |
        | edge    |
#        | safari  |

    @CITIZEN_LOGIN_FAIL
    Scenario Outline: "<testCase>" scenarios of Citizen Log In on "<browser>" browser
      Given The user has the Citizen Log In page open in "<browser>" browser
      When The user uses a "<testCase>" credentials in Citizen page
      Then The user is not logged in Citizen

      Examples:
      | testCase     | browser |
      | Wrong eMail  | chrome  |
      | Wrong Pass   | chrome  |
      | Blank eMail  | chrome  |
      | Blank Pass   | chrome  |
      | Wrong eMail  | firefox |
      | Wrong Pass   | firefox |
      | Blank eMail  | firefox |
      | Blank Pass   | firefox |
      | Wrong eMail  | edge    |
      | Wrong Pass   | edge    |
      | Blank eMail  | edge    |
      | Blank Pass   | edge    |
#      | Wrong eMail  | safari  |
#      | Wrong Pass   | safari  |
#      | Blank eMail  | safari  |
#      | Blank Pass   | safari  |
