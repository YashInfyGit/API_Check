Feature: Application login

 @tag1
  Scenario: Home page default login
    Given User is on netbanking landing page 
    When User logging into app using credentials
    Then Home is populated    