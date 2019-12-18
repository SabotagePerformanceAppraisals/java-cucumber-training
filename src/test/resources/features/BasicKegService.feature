Feature: 電子バーテンダーはビールの操作を可能である
#Feature: Electric bartender can work the beer kegs
   Background:
　　Given 私達のバーでは５０リットルの樽を使う
    #Given Our bar uses 50 liter kegs
　　And ３００MLのビールグラスを使う
    #And Our bar uses 300ml beer glasses


　Scenario: ゲストはエールを飲みたがっている
   #Scenario: Guest wants an ale
  　#Given バーテンダーは満タンの樽を持っている    // incorrect translation 翻訳が間違っています
    Given the bar has a full keg of ale
    When ゲストがエールををオーダーする
     #When guest orders an ale
    #Then バーテンダーはエールを提供する
     Then bartender will serve an ale


  Scenario Outline: バーはエールの在庫を減らす為に管理する
  #Scenario Outline: Bar tracks ale inventory reduction
    #Given バーは満タンの樽を持っている         // incorrect translation 翻訳が間違っています
    Given the bar has a full keg of ale
    When お客様が <number> 杯のエールを注文する
     #When guest orders <number> glasses of ale
    #Then 樽には <remaining> リットルが残っている
     Then keg will have <remaining> liters left
     Examples:
    #| 数  | 残り |
       | number  | remaining |
       |   1 | 49.7  |
       |   3 | 49.1  |