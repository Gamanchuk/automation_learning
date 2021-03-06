import gherkin.formatter.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;
import utils.Config;
import utils.DriverFactory;
import utils.TestGlobalsManager;

import java.util.ArrayList;

import static utils.CommonFunctions.attachScreenshot;

public class AllureReporterExt extends AllureReporter {
    private static Log log = LogFactory.getLog(DriverFactory.class.getSimpleName());
    private Scenario scenario;
    private Background background;

    @Override
    public void background(Background background) {
        this.background = background;
    }

    @Override
    public void scenario(Scenario scenario) {
        this.scenario = scenario;
        if (scenario != null) {
            if (Config.PROJECT_TRACKING) {
                getTestCaseIDs();
            }
            TestGlobalsManager.setTestGlobal("caseName", scenario.getName());
        }
    }

    @Override
    public void before(Match match, Result result) {
    }

    @Override
    public void result(Result result) {
        if (scenario != null) {
            if (result.getStatus().equals("failed")) {
                // Attach failed screenshot in to Allure
                attachScreenshot("Failed screenshot: " + scenario.getName());
            }
        }
        super.result(result);
    }

    private ArrayList<String> getTestCaseIDs() {

        ArrayList<String> ids = new ArrayList<>();
        for (Tag tag : scenario.getTags()) {
            if (tag.getName().contains("@TestCaseId"))
                ids.add(tag.getName().split("\"")[1]);
        }

        log.info("Count @TestCase found: " + ids.size());
        for (String s : ids) {
            log.info("@TestCaseId: " + s);
        }

        TestGlobalsManager.setTestGlobal("testCaseIds", ids);
        return ids;
    }

//    private boolean checkIgnored() {
//
//        boolean isIgnored = false;
//        for (Tag tag : feature.getTags()) {
//            if (tag.getName().contains("@Ignored"))
//                isIgnored = true;
//        }
//
//        log.info("Tag @Ignored found in case: " + scenario);
//
//        TestGlobalsManager.setTestGlobal("Ignored", isIgnored);
//        return isIgnored;
//    }
}
