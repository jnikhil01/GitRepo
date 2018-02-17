Feature: Login to RecorderPlus

  Scenario: Login to RecorderPlus
    Given RecorderPlus login page 
    When User enters username and password
    Then User is successfully logged into RecorderPlus

