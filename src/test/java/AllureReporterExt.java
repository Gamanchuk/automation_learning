import gherkin.formatter.model.Background;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;
import utils.DriverFactory;
import utils.JiraHelper;
import utils.TestRailRunHelper;
import utils.TestRailStatus;

import java.io.IOException;

import static utils.CommonFunctions.attachScreenshot;

public class AllureReporterExt extends AllureReporter {
    private static Log log = LogFactory.getLog(DriverFactory.class);
    private Scenario scenario;
    private Background background;

    @Override
    public void background(Background background) {
        this.background = background;
    }

    @Override
    public void scenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Override
    public void result(Result result) {
        String caseName = null;

        if (scenario != null) {
            caseName = scenario.getName();
        } else {
            caseName = background.getName();
        }

        if ("failed".equals(result.getStatus())) {
            log.info("Test failed. Step name: " + caseName);
            attachScreenshot("Failed screenshot: " + caseName);

            if (Boolean.valueOf(System.getProperty("projectTracking"))) {
                String ticketId = setJiraIssues(String.valueOf(result.getError()));
                setTestResult(TestRailStatus.FAILED, String.valueOf(result.getError()), ticketId);
            }

            DriverFactory.quitDriver();

        } else if ("passed".equals(result.getStatus())) {
            log.info("passed: " + caseName);
            if (Boolean.valueOf(System.getProperty("projectTracking")))
                setTestResult(TestRailStatus.PASSED, "", "");
        }

        super.result(result);
    }

    private int getTestCaseID() {

        String id = null;
        for (Tag tag : scenario.getTags()) {
            if (tag.getName().contains("@TestCaseId"))
                id = tag.getName().split("\"")[1];
        }
        assert id != null;
        return Integer.parseInt(id);
    }

    private void setTestResult(TestRailStatus status, String error, String issuesLink) {
        try {
            TestRailRunHelper.getInstance().setTestResult(getTestCaseID(), status, error, issuesLink);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String setJiraIssues(String result) {
        String ticketId = null;
        String caseName = null;
        String caseId = null;

        if (scenario != null) {
            caseName = scenario.getName();
            caseId = scenario.getId();
        } else {
            caseName = background.getName();
            caseId = null;
        }

        try {
            ticketId = JiraHelper.publishJira(
                    "Automation - \"" + caseName + "\" failed",
                    "{noformat}" + result + "\n" + caseId + "{noformat}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ticketId;
    }

}
