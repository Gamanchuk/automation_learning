package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestResult;
import utils.retries.AbstractAllureRetryAnalyzer;

public class Retry extends AbstractAllureRetryAnalyzer {
    private int MAX_RETRY_COUNT = 1;   // RETRIES number
    private int CURRENT_RETRY_COUNT = 0;
    private static Log log = LogFactory.getLog(Retry.class.getSimpleName());

    @Override
    public boolean retry(ITestResult result, boolean getRetryAbilityOnly) {
        if (CURRENT_RETRY_COUNT < MAX_RETRY_COUNT) {
            if (!getRetryAbilityOnly)
            CURRENT_RETRY_COUNT++;
            log.info(String.format("Going to retry test case: \"%s\", %d out of %d", TestGlobalsManager.getTestGlobal("caseName"),
                    CURRENT_RETRY_COUNT, MAX_RETRY_COUNT));
            return true;
        }
        return false;
    }

    public boolean isRetryAvailable() {
        return (MAX_RETRY_COUNT > 0);
    }
}