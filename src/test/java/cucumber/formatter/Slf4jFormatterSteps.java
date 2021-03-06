package cucumber.formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Slf4jFormatterSteps {
	private final Logger logger = LoggerFactory
			.getLogger(Slf4jFormatterSteps.class);

	@Given("^that the Cucumber tests are run in the same CI server$")
	public void that_the_Cucumber_tests_are_run_in_the_same_CI_server()
			throws Throwable {
		logger.info("that_the_Cucumber_tests_are_run_in_the_same_CI_server");
	}

	@Given("^the logging is set up correctly$")
	public void the_logging_is_set_up_correctly() throws Throwable {
		logger.info("the_logging_is_set_up_correctly");
	}

	@Before
	public void before() {
		logger.info("before");
	}

	@After
	public void after() {
		logger.info("after");
	}

	@Given("^that a logger has been installed$")
	public void that_a_logger_has_been_installed() throws Throwable {
		logger.info("that_a_logger_has_been_installed");
	}

	@When("^Cucumber executes$")
	public void Cucumber_executes() throws Throwable {
		logger.info("cucumber_executes");
	}

	@Then("^stuff is logged$")
	public void stuff_is_logged() throws Throwable {
		logger.info("stuff is logged");
	}

	@Given("^that theres data$")
	public void that_theres_data(DataTable arg1) throws Throwable {
		logger.info("that_theres_data: {}", arg1);
	}

	@Given("^some (\\d+)$")
	public void some(int arg1) throws Throwable {
		logger.info("some: {}", arg1);
	}

	@When("^\"([^\"]*)\" happens$")
	public void happens(String arg1) throws Throwable {
		logger.info("happens: {}", arg1);
	}

	@Then("^Aliens$")
	public void Aliens() throws Throwable {
		logger.info("Aliens");
	}
}
