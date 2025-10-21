package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features",
  glue = { "steps", "hooks" },
  plugin = {
    "pretty",
    "html:target/cucumber-report.html",
    "json:target/cucumber-report.json",
  },
  monochrome = true,
  tags = "not @Ignore"
)
public class TestRunner {}
