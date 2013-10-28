package cucumber.formatter;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/cucumber/formatter/Formatter.feature"},
		format = {"cucumber.formatter.Slf4jFormatter"})
public class Slf4JFormatterTest {
}
