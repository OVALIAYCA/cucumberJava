package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.FacebookPage;
import utilities.Driver;

import java.security.Key;

public class FaceobookStepdefinitions
{

    FacebookPage facebookPage = new FacebookPage();


    @Then("facebook cookies kabul eder")
    public void facebookCookiesKabulEder() {
    facebookPage.cookiesKabulButonu.click();

    }

    @And("facebook’da yeni hesap olustur butonuna basar")
    public void facebookDaYeniHesapOlusturButonunaBasar() {

    facebookPage.yeniHesapOlusturButonu.click();

    }

    @When("Faker class’indan bilgilerle facebook kayit formunu doldurur")
    public void fakerClassIndanBilgilerleFacebookKayitFormunuDoldurur() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("11")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

    }

    @And("facebook kayit ol tusuna basar")
    public void facebookKayitOlTusunaBasar() {

        facebookPage.yeniKayitKaydolButonu.click();
    }
}
