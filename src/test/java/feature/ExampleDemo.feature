Feature: Login Functionality

  Background:
    Given validate the browser
    When browser is triggered
    Then check if browser is started

  @Regression
  Scenario Outline: Validate Login Functionality of Wealthy Users
    Given the user has access to <URL>
    When the user enters <UserName> and <Password>
    Then validate login is successful

    Examples:
    |URL   | UserName |  Password |
    |google| user1    |  passwrd1 |
    |yahoo | user2    |  passwrd2 |
    |bing  | user3    |  passwrd3 |

    @SanityTest
    Scenario Outline: Validate Login Functionality for Admin Users
      Given the user has access to <URL>
      When the user enters <UserName> and <Password>
      Then validate login is successful

      Examples:
        |URL   | UserName |  Password |
        |google| user3    |  passwrd1 |
        |yahoo | user4    |  passwrd2 |
        |bing  | user5    |  passwrd3 |


  @SanityTest @SmokeTest
  Scenario Outline: Validate Login Functionality for Non-Admin Users
    Given the user has access to <URL>
    When the user enters <UserName> and <Password>
    Then validate login is successful

    Examples:
      |URL   | UserName |  Password |
      |google| user6    |  passwrd1 |
      |yahoo | user7    |  passwrd2 |
      |bing  | user8    |  passwrd3 |