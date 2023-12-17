

Feature: 1012 Excel olarak verilen urunler ve min. stok miktarlari testi

 Scenario Outline: TC18 excel olarak verilen lsitedeki urunler min. stok bulundurmali

    Given kullanici "toUrl" anasayfaya gider
    Then stok excelindeki "<istenenSatir>" daki urun miktarini bulur
    And stok miktarinin "<istenenSatir>" da verilen stok miktarindan fazla oldugunu test eder
    And sayfayi kapatir

    Examples:
   |istenenSatir|
   |2           |
   |3           |
   |4           |
   |5           |
   |6           |
   |7           |
   |8           |
   |9           |


