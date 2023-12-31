package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SauceDemoPage;
import utilities.Driver;

public class SauceStepdefinitions
{
    SauceDemoPage sauceDemoPage = new SauceDemoPage();
    String ilkUrunIsim;

    @Then("saucedemo username kutusuna {string} yazar")
    public void saucedemo_username_kutusuna_yazar(String kullaniciUsername) {

        sauceDemoPage.userName.sendKeys(kullaniciUsername);

    }

    @Then("saucedemo password kutusuna {string} yazar")
    public void saucedemo_password_kutusuna_yazar(String kullaniciPassword) {

        sauceDemoPage.password.sendKeys(kullaniciPassword);

    }

    @Then("saucedemo login tusuna basar")
    public void saucedemo_login_tusuna_basar() {

        sauceDemoPage.loginButton.click();
    }

    @Then("ilk urunun ismini kaydeder ve bu urunun sayfasina gider")
    public void ilk_urunun_ismini_kaydeder_ve_bu_urunun_sayfasina_gider() {

        ilkUrunIsim = sauceDemoPage.ilkUrunIsim.getText();
        sauceDemoPage.ilkUrunIsim.click();


    }

    @When("saucedemo add to Cart butonuna basar")
    public void saucedemo_add_to_cart_butonuna_basar() {

        sauceDemoPage.addToCart.click();

    }

    @Then("saucedemo alisveris sepetine tiklar")
    public void saucedemo_alisveris_sepetine_tiklar() {

        sauceDemoPage.basket.click();

    }

    @Then("sectigi urunun basarili olarak sepete eklendigini test eder")
    public void sectigi_urunun_basarili_olarak_sepete_eklendigini_test_eder() {


        String actualUrun = sauceDemoPage.eklenenUrun.getText();
        Assert.assertEquals(ilkUrunIsim,actualUrun);
    }
}

