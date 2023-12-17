package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOtomasyonuStepdefinitions
{
    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
    //class seviyesinde oluşturduk, tekrar çağırabilmek için.

    Sheet sayfa2;
    int actualStokMiktari;

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }
    @Then("arama kutusuna phone yazarak enter tuşuna basar")
    public void arama_kutusuna_phone_yazarak_enter_tuşuna_basar() {

        testOtomasyonuPage.aramaKutusu.sendKeys("phone", Keys.ENTER);

    }
    @Then("arama sonucunda ürün bulunabildiğini test eder")
    public void arama_sonucunda_ürün_bulunabildiğini_test_eder() {

        int sonuSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(sonuSayisi>0);

    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {

        Driver.closeDriver();

    }


    @Then("arama kutusuna {string} yazarak enter tusuna basar")
    public void aramaKutusunaYazarakEnterTusunaBasar(String istenenUrun) {

        testOtomasyonuPage.aramaKutusu.sendKeys(istenenUrun,Keys.ENTER);

    }

    @And("arama sonucunda ürün bulunamadigini test eder")
    public void aramaSonucundaÜrünBulunamadıginiTestEder() {
        int sonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertFalse(sonucSayisi>0);
    }

    @Then("arama kutusuna shoes yazarak enter tusuna basar")
    public void aramaKutusunaShoesYazarakEnterTusunaBasar() {
        testOtomasyonuPage.aramaKutusu.sendKeys("shoes",Keys.ENTER);
    }

    @Then("arama kutusuna nutella yazarak enter tuşuna basar")
    public void aramaKutusunaNutellaYazarakEnterTuşunaBasar() {
        testOtomasyonuPage.aramaKutusu.sendKeys("nutella",Keys.ENTER);
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String gidilecekUrl) {

        //gidilecek Url : gitmek istediğimiz sayfanın configuration.properties deki ismidir
        Driver.getDriver().get(ConfigReader.getProperty(gidilecekUrl));
    }

    @Then("account butonuna basar")
    public void account_butonuna_basar() {
        testOtomasyonuPage.accountButonu.click();
    }
    @Then("email olarak {string} girer")
    public void email_olarak_girer(String emailTuru) {
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty(emailTuru));
    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String passwordTuru) {
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty(passwordTuru));
    }
    @Then("signIn butonuna basar")
    public void sign_ın_butonuna_basar() {
        testOtomasyonuPage.signInButonu.click();
    }
    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {
       Assert.assertTrue(testOtomasyonuPage.logoutButon.isDisplayed());
    }


    @And("sisteme giris yapamadigini test eder")
    public void sistemeGirisYapamadiginiTestEder() {

        Assert.assertTrue(testOtomasyonuPage.signInButonu.isDisplayed());
    }


    @When("email olarak listede verilen {string} girer")
    public void emailOlarakListedeVerilenGirer(String verilenEmail) {

        testOtomasyonuPage.emailKutusu.sendKeys(verilenEmail);
    }

    @And("password olarak listede verilen {string} girer")
    public void passwordOlarakListedeVerilenGirer(String verilenPassword) {
        testOtomasyonuPage.passwordKutusu.sendKeys(verilenPassword);
    }

    @Then("stok excelindeki {string} daki urun miktarini bulur")
    public void stokExcelindekiDakiUrunMiktariniBulur(String satirNo) {
        String dosyaYolu = "src/test/resources/stok.xlsx";
        Workbook workbook;
        try {
           FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sayfa2 = workbook.getSheet("Sayfa2");
        String urunIsmi = sayfa2.getRow(Integer.parseInt(satirNo)-1).getCell(0).toString();
        //istenen satirdaki ürün ismini bu şekilde buluruz.

        testOtomasyonuPage.aramaKutusu.sendKeys(urunIsmi,Keys.ENTER);
        actualStokMiktari = testOtomasyonuPage.bulunanUrunElementleriList.size();

    }

    @And("stok miktarinin {string} da verilen stok miktarindan fazla oldugunu test eder")
    public void stokMiktarininDaVerilenStokMiktarindanFazlaOldugunuTestEder(String verilenSatir) {

        String dosyaYolu = "src/test/resources/stok.xlsx";
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        sayfa2 = workbook.getSheet("Sayfa2");
        String minStokMiktariStr = sayfa2.getRow(Integer.parseInt(verilenSatir)-1)
                                   .getCell(1).toString();
        int minStokMiktari = (int) Double.parseDouble(minStokMiktariStr);

        Assert.assertTrue(actualStokMiktari>=minStokMiktari);



    }

    @Then("stok excelindeki tum urunleri aratip, min stok miktarinda urun olanlari listeler")
    public void stokExcelindekiTumUrunleriAratipMinStokMiktarindaUrunOlanlariListeler() {

        String dosyaYolu = "src/test/resources/stok.xlsx";
        Workbook workbook;
        try {
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sayfa2 = workbook.getSheet("Sayfa2");

        int stokExceliSonSatirNo = sayfa2.getLastRowNum();

        String satirdakiUrunIsmi;
        int satirdakiUrunMinStok;
        int arananUrunUygulamadaBulunanSonucSayisi;
        List<String> yeterliStokOlanlarListesi = new ArrayList<>();
        List<String> yeterliStokOlmayanlarListesi = new ArrayList<>();

        for (int i = 1; i <= stokExceliSonSatirNo; i++) {

            satirdakiUrunIsmi = sayfa2
                    .getRow(i)
                    .getCell(0)
                    .toString();

            satirdakiUrunMinStok = (int) Double.parseDouble(sayfa2
                    .getRow(i)
                    .getCell(1)
                    .toString());

            testOtomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
            arananUrunUygulamadaBulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

            if (arananUrunUygulamadaBulunanSonucSayisi >= satirdakiUrunMinStok) {
                yeterliStokOlanlarListesi.add(satirdakiUrunIsmi);
            } else {
                yeterliStokOlmayanlarListesi.add(satirdakiUrunIsmi);
            }

        }

        System.out.println("Yeterli stok olan urunler : " + yeterliStokOlanlarListesi);
        System.out.println("Yeterli stok OLMAYAN urunler : " + yeterliStokOlmayanlarListesi);
    }
}
