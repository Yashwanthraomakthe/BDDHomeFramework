package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/java/features/login.feature",
glue = {"stepDefs", "hooks"},
//tags="@runthis",
plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
dryRun = !true,
snippets = SnippetType.CAMELCASE,
monochrome = true)

public class LoginTestRunner extends AbstractTestNGCucumberTests{
	
//	@DataProvider(parallel = true)
//    @Override
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
