Feature: 電子バーテンダーはビールの操作を可能である
#Feature: Electric bartender can work the beer kegs
  Background:
    # Given Our bar uses 50 liter kegs
    # And Our bar uses 300ml beer glasses
    Given 私達のバーでは50リットルの樽を使う
    And 300MLのビールグラスを使う

  #Scenario: Guest wants an ale
    #Given the bar has a full keg of ale
    #When guest orders an ale
    #Then guest's beer glass has ale
  Scenario: ゲストはエールを飲みたがっている
    Given バーにエールが満タンの樽がある
    When ゲストがエールををオーダーする
    Then ゲストのビールグラスにエールが満タンである

  #Scenario Outline: Bar tracks ale inventory reduction
   #Given the bar has a full keg of ale
   #When guest orders <number> glasses of ale
   #Then keg will have <remaining> liters left
  Scenario Outline: バーはエールの在庫を減らす為に管理する
    Given バーにエールが満タンの樽がある
    When お客様が <数> 杯のエールを注文する
    Then 樽には <残り> リットルが残っている
    Examples:
      | 数 | 残り   |
      | 1 | 49.7 |
      | 3 | 49.1 |
