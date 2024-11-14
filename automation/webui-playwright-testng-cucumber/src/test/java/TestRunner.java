import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    plugin = {
        "pretty",
        "rerun:target/failed_scenarios.txt",
        "json:target/cucumber-report/cucumber.json"  // Add JSON report for better reporting
    },
    monochrome = true,
    tags = "${cucumber.filter.tags}",  // Filter tags passed as parameters
    glue = "steps"  // Path to your step definitions
)
public class TestRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
