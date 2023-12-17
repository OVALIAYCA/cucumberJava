
@P2
Feature: US1003 kullanici bastaki ortak adimlari tek seferde yazabilmeli

Background: baslangictaki ortak adimlar buraya yazilabilir
  Given kullanici "toUrl" anasayfaya gider


  Scenario: TC06_Kullanıcı java arattığında sonuç bulamamalı

    Then arama kutusuna "java" yazarak enter tusuna basar
    And arama sonucunda ürün bulunamadigini test eder
    And 2 saniye bekler
    Then sayfayi kapatir


  Scenario: TC07_Kullanıcı cucumber arattığında sonuç bulamamalı

    Then arama kutusuna "cucumber" yazarak enter tusuna basar
    And arama sonucunda ürün bulunamadigini test eder
    And 2 saniye bekler
    Then sayfayi kapatir