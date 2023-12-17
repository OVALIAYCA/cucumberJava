package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/raporYeni.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features", //çalışacak feature veya scenario'lar nerede?
        glue = {"stepdefinitions", "hooks"}, //çalışacak feature ve scenario kodları nerede?
        tags = "@wip", //hangi feature /scenario'lar çalışacak
        dryRun = false
)
public class Runner

{


}

