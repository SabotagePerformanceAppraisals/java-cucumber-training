Feature: Electric bartender can work the beer kegs
  Background:
    Given Our bar uses 50 liter kegs
    And Our bar uses 300ml beer glasses

  Scenario: Guest wants an ale
    Given the bar has a full keg of ale
    When guest orders an ale
    Then guest's beer glass has ale

  Scenario: Guest wants another another ale
    Given the bar has enough ale
    When guest orders an ale
    Then guest's beer glass has ale

  Scenario Outline: Bar tracks ale inventory reduction
    Given the bar has a full keg of ale
    When guest orders <number> glasses of ale
    Then keg will have <remaining> liters left
    Examples:
      | number | remaining   |
      | 1 | 49.7 |
      | 3 | 49.1 |
