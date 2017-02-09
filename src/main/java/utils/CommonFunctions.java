package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Attachment;



public class CommonFunctions {
    private static Log log = LogFactory.getLog(CommonFunctions.class);

    @Attachment("< {0} > message ")
    public static String log(Class clazz, String msg) {
        return clazz.getSimpleName() + ": " + msg;
    }

    @Attachment("< {0} > message ")
    public static String log(Class clazz, String msg, boolean useConsole) {
        if (useConsole) Reporter.log(clazz.getSimpleName() + ": " + msg, true);
        return clazz.getSimpleName() + ": " + msg;
    }

    @Attachment("< {0} > message ")
    public static String log(Class clazz, String subj, String msg, boolean useConsole) {
        if (useConsole) Reporter.log(clazz.getSimpleName() + ": " + subj + " - " + msg, true);
        return clazz.getSimpleName() + ": " + msg;
    }

    @Attachment("{0}")
    public static String log(String subj, String msg) {
        log.info(msg);
        return msg;
    }

    @Attachment("{0}")
    public static String log(String subj, String msg, boolean useConsole) {
        if (useConsole) Reporter.log(subj + ": " + msg, true);
        return msg;
    }

    @Attachment("{0}")
    public static String log(String msg) {
        Reporter.log(msg, true);
        return msg;
    }

    @Attachment("{0}")
    public static String log(String msg, boolean useConsole) {
        if (useConsole) Reporter.log(msg, true);
        return msg;
    }


    @Attachment(value = "ISSUES: {0}", type = "text/html")
    public static String attachIssuesLink(String id, String link) {
        return "<script language=javascript> window.location.href ='" + link + "'</script>";
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
