

Feature: US1009 Kullanici coklu arama yapar

 Scenario Outline: TC15 Kullanici bir listedeki elementleri aratabilmeli
    Given kullanici "toUrl" anasayfaya gider
    Then arama kutusuna "<aranacakKelimeler>" yazarak enter tusuna basar
    Then 1 saniye bekler
    Then arama sonucunda ürün bulunabildiğini test eder
    Then 1 saniye bekler
    And sayfayi kapatir

    Examples:
     | aranacakKelimeler |
     |   phone           |
     |   java            |
     |   dress           |
     |   nutella         |
     |   apple           |
     |   samsung         |


    #eger bir eleman degil, birden fazla eleman aratmak istiyorsak
    #Scenario yerine ScenariOutline kullaniriz.