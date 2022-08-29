@REGRESSION @UI

  @CITY_LOGIN
  Feature: Test all the scenarios of the Log In City site

    @CITY_LOGIN_SUCCESS
    Scenario Outline: Do a FrontDesk success log in on "<browser>" browser
      Given A user has the FrontDesk Log In page open in "<browser>" browser
      When The user uses a "valid" credentials in FrontDesk page
      Then The user is logged in FrontDesk

      Examples:
        | browser |
        | chrome  |
        | firefox |
        | edge    |
#        | safari  |

    @CITY_LOGIN_FAIL
    Scenario Outline: "<testCase>" scenarios of City Log In on "<browser>" browser
      Given A user has the FrontDesk Log In page open in "<browser>" browser
      When The user uses a fail "<testCase>" credentials in FrontDesk page
      Then The user is not logged in FrontDesk

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
