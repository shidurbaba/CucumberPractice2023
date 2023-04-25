Feature: Login Functionality

  Scenario Outline: Validate Login Functionality of Wealthy Users
    Given the user has access to <URL>
    When the user enters <UserName> and <Password>
    Then validate login is successful

    Examples:
    |URL   | UserName |  Password |
    |google| user1    |  passwrd1 |
    |yahoo | user2    |  passwrd2 |
    |bing  | user3    |  passwrd3 |