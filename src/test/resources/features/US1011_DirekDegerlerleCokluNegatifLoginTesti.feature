
Feature:US1011 scenario'da verilen yanlis bilgilerle negatif login testi

  Scenario Outline: TC17 liste olarak verilen yanlis kullanici bilgileri ile giris yapilamamali

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    When email olarak listede verilen "<verilenEmail>" girer
    And password olarak listede verilen "<verilenPassword>" girer
    Then signIn butonuna basar
    And sisteme giris yapamadigini test eder
    And 1 saniye bekler
    Then sayfayi kapatir


    Examples:
      |verilenEmail|verilenPassword|
      |esra@fmail.com|1234556      |
      |gamze@gmail.com|33445566    |
      |zehra@zmail.com|1234543     |
      |ayca@amail.com|etc123       |
      |gulnur@tmail.com|kkv48695   |
