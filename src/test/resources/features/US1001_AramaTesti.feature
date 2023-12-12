Feature: US1001 Kullanıcı testotomasyonu sayfasında arama yapar

  @Regression @Smoke @E2E3
  Scenario: TC01_Kullanıcı phone aramasında sonuç bulmalı
    Given kullanici testotomasyonu anasayfaya gider
    Then arama kutusuna phone yazarak enter tuşuna basar
    And arama sonucunda ürün bulunabildiğini test eder
    And 2 saniye bekler
    Then sayfayi kapatir

  @Regression @E2E1
  Scenario: TC02_Kullanıcı shoes aramasında sonuç bulmalı
    Given kullanici testotomasyonu anasayfaya gider
    Then arama kutusuna shoes yazarak enter tusuna basar
    And arama sonucunda ürün bulunabildiğini test eder
    And 2 saniye bekler
    Then sayfayi kapatir


  Scenario: TC03 Kullanıcı nutella arattığında sonuç bulamamalı
    Given kullanici testotomasyonu anasayfaya gider
    Then arama kutusuna nutella yazarak enter tuşuna basar
    And arama sonucunda ürün bulunamadigini test eder
    And 2 saniye bekler
    Then sayfayi kapatir






