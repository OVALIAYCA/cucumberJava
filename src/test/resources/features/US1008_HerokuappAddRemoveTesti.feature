


Feature: US1008 kullanici sayfadaki butonlari test eder

  Scenario:TC14 kullanici add ve remove butonlarinin calistigini test eder

    Given kullanici "heroUrl" anasayfaya gider
    When kullanici Add Element butonuna basar
    And Delete butonu’nun gorunur oldugunu test eder
    Then Delete tusuna basar
    And Add Remove Elements yazisinin gorunur oldugunu test eder
    And 2 saniye bekler
    And sayfayi kapatir