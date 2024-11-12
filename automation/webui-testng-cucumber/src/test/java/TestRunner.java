import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
    "pretty",
    "rerun:target/failed_scenarios.txt"},
    monochrome = true,
    tags = "${cucumber.filter.tags}"
)
public class TestRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
