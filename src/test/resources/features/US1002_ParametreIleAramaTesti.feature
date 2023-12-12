Feature: US1002 Kullanıcı parametre ile verdiği ürünü aratabilmeli

  Scenario: TC04_Kullanıcı java arattığında sonuç bulamamalı
    Given kullanici testotomasyonu anasayfaya gider
    Then arama kutusuna "java" yazarak enter tusuna basar
    And arama sonucunda ürün bulunamadigini test eder
    And 2 saniye bekler
    Then sayfayi kapatir

  @ilk
  Scenario: TC05_Kullanıcı cucumber arattığında sonuç bulamamalı
    Given kullanici "toUrl" anasayfaya gider
    Then arama kutusuna "cucumber" yazarak enter tusuna basar
    And arama sonucunda ürün bulunamadigini test eder
    And 2 saniye bekler
    Then sayfayi kapatir