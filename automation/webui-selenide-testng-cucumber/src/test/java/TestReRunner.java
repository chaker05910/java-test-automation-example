import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
    "pretty"},
    monochrome = true,
    features = "@target/failed_scenarios.txt"
)
public class TestReRunner extends AbstractTestNGCucumberTests {

  @BeforeClass
  public void checkIfFailedScenariosExist() {
    if (!Files.exists(Paths.get("target/failed_scenarios.txt"))) {
      throw new SkipException("No failed scenarios to rerun.");
    }
  }

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
