package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/html-reports/ParalelRapor2.html",
                    "json:target/json-reports/cucumber2.json",
                    "junit:target/xml-report/cucumber2.xml"},
            features = "src/test/resources/features", // calisacak Feature/Scenario'lar nerede ?
            glue = {"stepdefinitions", "hooks"},    // calisacak Feature/Scenario'larin kodlari nerede?
            tags = "@P2",  // hangi Feature/Scenario'lar calisacak ?
            dryRun = false // true yapilirsa testi calistirmadan eksik adimlari verir
            // testleri calistirirken dryRun = false olmalidir
    )
    public class ParalelRun2
    {


    }



