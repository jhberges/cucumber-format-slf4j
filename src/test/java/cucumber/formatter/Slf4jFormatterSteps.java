package cucumber.formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Slf4jFormatterSteps {
	private final Logger logger = LoggerFactory.getLogger(Slf4jFormatterSteps.class);

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



}
