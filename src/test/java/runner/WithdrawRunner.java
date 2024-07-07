package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/java/features/withdraw_cash.feature",
glue = {"stepDefs", "hooks"},
plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
dryRun = !true,
snippets = SnippetType.CAMELCASE,
monochrome = true)

public class WithdrawRunner extends AbstractTestNGCucumberTests{

}
