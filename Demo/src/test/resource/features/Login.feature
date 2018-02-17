Feature: ITAP Login

  #Scenario: Login to the site
  # Given Open ITAP
  # When User enters Username and Password
  # And User clicks on login button
  # Then User is successfully logged in
  # Then User clicks on logout
  #Scenario: Login to the site with Incorrect username/password
  #Given Open ITAP
  #When User enters incorrect Username and Password
  #And User clicks on login button
  #But Authentication failed message is displayed on the screen
  Scenario: Login to the site with Incorrect username/password
    Given Open ITAP
    When User enters Username and Password
    And User clicks on login button
    Then User is successfully logged in
    Then User navigates to Employee search

  Scenario Outline: Search for multiple employees
    Given Search for "<employees>"

    Examples: 
      | employees |
      | A566313   |
