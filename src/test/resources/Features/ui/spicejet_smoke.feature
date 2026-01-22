@ui @spicejet
Feature: SpiceJet homepage smoke

  Scenario: Open SpiceJet and verify homepage is loaded
    Given I open the SpiceJet website
    And I accept cookies if prompted
    Then the SpiceJet homepage should be displayed

