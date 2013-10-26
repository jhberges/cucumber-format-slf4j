package cucumber.formatter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class Slf4jFormatter implements Reporter, Formatter {
	private static final char PAD = '*';
	private static final String LINE = Strings.padStart("", 80, PAD);
	private static final String PFIX = PAD + " ";
	private final Logger logger = LoggerFactory.getLogger(Slf4jFormatter.class);
	private final Appendable out;
	private final Configuration configuration;

	public Slf4jFormatter(final Appendable out) {
		this.out = out;
		configuration = new Configuration();
		configuration.setClassForTemplateLoading(Slf4jFormatter.class,
				"/freemarker");
	}

	@Override
	public void after(final Match match, final Result result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("match", match);
		model.put("result", result);
		logIfHasOutcome(makeString("after", model));
	}

	@Override
	public void background(final Background background) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("background", background);
		logIfHasOutcome(makeString("background", model));
	}

	@Override
	public void before(final Match match, final Result result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("match", match);
		model.put("result", result);
		logIfHasOutcome(makeString("before", model));
	}

	@Override
	public void done() {
		logIfHasOutcome("*** DONE. ");
	}

	@Override
	public void feature(final Feature feature) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("feature", feature);
		logIfHasOutcome(makeString("feature", model));
	}

	@Override
	public void scenario(final Scenario scenario) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("scenario", scenario);
		logIfHasOutcome(makeString("scenario", model));
	}

	@Override
	public void uri(final String uri) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("uri", uri);
		logIfHasOutcome(makeString("uri", model));
	}

	@Override
	public void scenarioOutline(final ScenarioOutline scenarioOutline) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("scenarioOutline", scenarioOutline);
		logIfHasOutcome(makeString("scenarioOutline", model));
	}

	@Override
	public void examples(final Examples examples) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("examples", examples);
		logIfHasOutcome(makeString("examples", model));
	}

	@Override
	public void step(final Step step) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("step", step);
		logIfHasOutcome(makeString("step", model));
	}

	@Override
	public void eof() {
		logIfHasOutcome(makeString("eof", new HashMap<String, Object>()));
	}

	@Override
	public void syntaxError(final String state, final String event,
			final List<String> legalEvents, final String uri, final Integer line) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("state", state);
		model.put("event", event);
		model.put("legalEvents", legalEvents);
		model.put("uri", uri);
		model.put("line", line);
		logIfHasOutcome(makeString("syntaxError", model));
	}

	@Override
	public void close() {
		logIfHasOutcome(makeString("close", new HashMap<String, Object>()));
	}

	@Override
	public void result(final Result result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", result);
		logIfHasOutcome(makeString("result", model));
	}

	@Override
	public void match(final Match match) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("match", match);
		logIfHasOutcome(makeString("match", model));
	}

	@Override
	public void embedding(final String mimeType, final byte[] data) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("mimeType", mimeType);
		model.put("data", data);
		logIfHasOutcome(makeString("embedding", model));
	}

	@Override
	public void write(final String text) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("write", text);
		logIfHasOutcome(makeString("write", model));
	}

	private void logIfHasOutcome(String toLog) {
		if (null != toLog) {
			logger.info(toLog);
		}
	}

	private String makeString(String templateName, Map<String, Object> model) {
		Template template = configuration.getTemplate(templateName + ".ftl");
		StringWriter stringWriter = new StringWriter();
		template.process(model, stringWriter);
		return stringWriter.toString();
	}
}
