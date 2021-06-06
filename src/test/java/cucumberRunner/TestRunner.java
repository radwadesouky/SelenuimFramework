package cucumberRunner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src/test/java/features"
,glue= {"stepsdefinition"}
,plugin= {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase{

}
