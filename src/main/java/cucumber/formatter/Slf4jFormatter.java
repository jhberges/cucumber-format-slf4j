package cucumber.formatter;

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

import java.util.List;
import java.util.logging.Logger;


public class Slf4jFormatter implements Reporter, Formatter {
   private static final char PAD = '*';
   private static final String LINE = Strings.padStart("", 80, PAD);
   private static final String PFIX = PAD + " ";
   private final Logger logger = LoggerFactory.getLogger(Slf4jFormatter.class);
   private final Appendable out;
   public Slf4jFormatter(final Appendable out) {
      this.out = out;
   }

   @Override
   public void after(final Match match, final Result result) {
      logger.info("*** AFTER:\n{}{}\n{}{}\n{}", PFIX, match.toMap(), PFIX, result.toMap(), LINE);
   }

   @Override
   public void background(final Background background) {
      logger.info("*** BACKGROUND:\n{}{}\n{}", PFIX, background.toMap(), LINE);
   }

   @Override
   public void before(final Match match, final Result result) {
      logger.info("*** BEFORE:\n{}{}\n{}{}\n{}", PFIX, match.toMap(), PFIX, result.toMap(), LINE);
   }

   @Override
   public void done() {
      logger.info("*** DONE. ");
   }

   @Override
   public void feature(final Feature feature) {
      logger.info("*** FEATURE:\n{}{}\n{}", PFIX, feature.toMap(), LINE);
   }

   @Override
   public void scenario(final Scenario scenario) {
      logger.info(" *** SCENARIO:\n{}{}\n{}",  PFIX, scenario.toMap(), LINE);
   }

   @Override
   public void uri(final String uri) {
      logger.info("URI? {}", uri);
   }

   @Override
   public void scenarioOutline(final ScenarioOutline scenarioOutline) {
      logger.info(" *** SCENARIO-OUTLINE:\n{}{}\n{}",  PFIX, scenarioOutline.toMap(), LINE);
   }

   @Override
   public void examples(final Examples examples) {
      logger.info(" *** EXAMPLES:\n{}{}\n{}",  PFIX, examples.toMap(), LINE);
   }

   @Override
   public void step(final Step step) {
      logger.info(" *** STEP:\n{}{}\n{}",  PFIX, step.toMap(), LINE);
   }

   @Override
   public void eof() {
      logger.info(" *** EOF?\n{}",  LINE);
   }

   @Override
   public void syntaxError(final String state, final String event,
         final List<String> legalEvents, final String uri, final Integer line) {
      logger.info(" *** FUBAR?"
            + "\n{}{}"
            + "\n{}{}"
            + "\n{}{}"
            + "\n{}{}"
            + "\n{}{}"
            + "\n{}",
            state,
            event,
            legalEvents,
            uri,
            line,
            LINE);
   }

   @Override
   public void close() {
      logger.info(" *** CLOSE?\n{}",  LINE);
   }

   @Override
   public void result(final Result result) {
      logger.info(" *** RESULT?\n{}{}\n{}",  PFIX, result.toMap(), LINE);
   }

   @Override
   public void match(final Match match) {
      logger.info(" *** match?\n{}{}\n{}",  PFIX, match.toMap(), LINE);
   }

   @Override
   public void embedding(final String mimeType, final byte[] data) {
      logger.info(" *** EMbEDDING?\n{}{}\n{}{}\n{}",  PFIX, mimeType, PFIX, data, LINE);
   }

   @Override
   public void write(final String text) {
      logger.info(" *** WRITE?\n{}{}\n{}",  PFIX, text, LINE);
   }
}
