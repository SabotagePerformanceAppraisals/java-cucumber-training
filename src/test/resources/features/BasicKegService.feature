Feature: Electric bartender can work the beer kegs

  @developing
  Scenario: Guest wants an ale
    Given the bar has a full keg of ale
    When guest orders an ale
    Then bartender will serve an ale
