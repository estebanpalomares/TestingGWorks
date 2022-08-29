@REGRESSION @UI

  @MASTER_LOGIN
  Feature: Test all the scenarios of the Log In Master site

    @MASTER_LOGIN_SUCCESS
    Scenario Outline: Do a Master success log in on "<browser>" browser
      Given A user has the Master Log In page open in "<browser>" browser
      When The user uses a "valid" credentials in Master page
      Then The user is logged in

      Examples:
      | browser |
      | chrome  |
      | firefox |
      | edge    |
#      | safari  |

    @MASTER_LOGIN_FAIL
    Scenario Outline: "<testCase>" scenario of Master Log In on "<browser>" browser
      Given A user has the Master Log In page open in "<browser>" browser
      When The user uses a "<testCase>" credentials in Master page
      Then The user is not logged in

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
