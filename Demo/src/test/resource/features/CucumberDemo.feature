Feature: Login to ITAP

  #Scenario Outline: Login on Mercury page
  # Given Mercury tours login page "<userName>" and "<password>"
  # When Click on Login button
  # Then The search result page title should contain the "<search_term>"
  #Examples:
  # | userName | password    | search_term |
  #| a566317  | Monday@3010 | ITAP        |
  Scenario Outline: Search for employee details on ITAP
    Given Mercury tours login page "<userName>" and "<password>"
    When Click on Login button
    Then The search result page title should contain the "<search_term>"

    Examples: 
      | userName | password    | search_term |
      | a566317  | Monday@1112 | ITAP        |

  Scenario Outline: Search for multiple employees
    Given Employee search page
    Then User searches for the the "<employee>"

    Examples: 
      | employee |
      | a566317  |
      | a566313  |
