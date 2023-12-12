

Feature: US1006

  Scenario: TC12 Fake bilgilerle kayıt yapabilmeli
    Given kullanici "facebookUrl" anasayfaya gider
    Then facebook cookies kabul eder
    And facebook’da yeni hesap olustur butonuna basar
    When Faker class’indan bilgilerle facebook kayit formunu doldurur
    Then 3 saniye bekler
    And facebook kayit ol tusuna basar
    Then 3 saniye bekler
    And sayfayi kapatir


