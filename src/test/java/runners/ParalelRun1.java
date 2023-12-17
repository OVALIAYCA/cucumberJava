package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/html-reports/ParalelRapor1.html",
                    "json:target/json-reports/cucumber1.json",
                    "junit:target/xml-report/cucumber1.xml"},
            features = "src/test/resources/features", // calisacak Feature/Scenario'lar nerede ?
            glue = {"stepdefinitions", "hooks"},   // calisacak Feature/Scenario'larin kodlari nerede?
            tags = "@P1",  // hangi Feature/Scenario'lar calisacak ?
            dryRun = false // true yapilirsa testi calistirmadan eksik adimlari verir
            // testleri calistirirken dryRun = false olmalidir
    )
    public class ParalelRun1 {


    }

