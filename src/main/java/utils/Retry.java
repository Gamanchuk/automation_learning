package utils;

import org.testng.ITestResult;
import utils.retries.AbstractAllureRetryAnalyzer;

public class Retry extends AbstractAllureRetryAnalyzer {
    private int MAX_RETRY_COUNT = 1;   // RETRIES number
    private int CURRENT_RETRY_COUNT = 0;

    @Override
    public boolean retry(ITestResult result, boolean getRetryAbilityOnly) {
        if (CURRENT_RETRY_COUNT < MAX_RETRY_COUNT) {
            if (!getRetryAbilityOnly)
                CURRENT_RETRY_COUNT++;
            return true;
        }
        return false;
    }
}