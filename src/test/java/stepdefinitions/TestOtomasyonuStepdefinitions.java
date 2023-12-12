package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.FacebookPage;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestOtomasyonuStepdefinitions
{
    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
    //class seviyesinde oluşturduk, tekrar çağırabilmek için.

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


}
