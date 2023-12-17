
@wip
Feature: US1014 Scenario failed olduğunda fotoğraf çekilmeli

  Scenario: TC20 Kullanici testotomasyonu sayfasinda nutella bulabilmeli
    Given kullanici "toUrl" anasayfaya gider
    Then arama kutusuna "nutella" yazarak enter tusuna basar
    And arama sonucunda ürün bulunamadigini test eder
    And sayfayi kapatir
