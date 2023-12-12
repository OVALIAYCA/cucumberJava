package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-reports/rapor2_SauceDemo.html",
        features = "src/test/resources/features", //çalışacak feature veya scenario'lar nerede?
        glue = "stepdefinitions", //çalışacak feature ve scenario kodları nerede?
        tags = "@wip", //hangi feature /scenario'lar çalışacak
        dryRun = false
)
public class Runner

{


}

