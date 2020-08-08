Feature: Search for keywords in Google

  @SearchGoogle
  Scenario: User can search for keywords successfully
    Given Launch chrome browser
    When Open Google search app
    Then Search keywords successfully