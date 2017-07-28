package utils;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.DriverFactory.getDriver;

public class CommonFunctions {
    private static Log log = LogFactory.getLog(CommonFunctions.class.getSimpleName());

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

    @Attachment(value = "Test failed. See Attached Dom tree", type = "text/html")
    public static String attachDomThree(String dom) {
        return dom;
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "Screen Recording Video", type = "video/mp4")
    public static byte[] attachScreenVideo(String name) {
        File file = new File(System.getProperty("user.dir") + "/target/" + Config.DEVICE_UID + ".mp4");
        log.info("screen file: " + file.getAbsolutePath());
        return readFile(file);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static byte[] attachFile(String attachmentName, File file) {
        return readFile(file);
    }

    private static byte[] readFile(File file) {
        byte[] byteVideo = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byteVideo = IOUtils.toByteArray(fileInputStream);
        } catch (FileNotFoundException e) {
            log.error("File not found.");
        } catch (IOException e1) {
            log.error("Error reading the file.");
        }

        log.info(byteVideo);
        return byteVideo;
    }

    public static void writeFile(File file, String data) {
        if (file.exists()) {
            try {
                FileUtils.write(file, data, Charset.forName("UTF-8"));
            } catch (IOException e) {
                log.error("We have problem with write data in to file.");
                log.error(e.getMessage());
            }
        } else {
            log.error("Looks like we cant write data in file because file doesn't.");
        }
    }

    public static float getCurrency(String str) {
        Pattern pattern = Pattern.compile("\\$(\\d+\\.?\\d{0,2})");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String currency = matcher.group(1);
            return Float.parseFloat(currency);
        } else {
            throw new Error("Can't get currency from string " + str + "");
        }
    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void saveOrder(String order) {
        try {
            FileUtils.writeStringToFile(new File("orders.txt"), order, CharEncoding.UTF_8, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int runShell(String command, String arguments) {
        CommandLine commandLine = new CommandLine(command).addArguments(arguments);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

        DefaultExecuteResultHandler executeResultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(streamHandler);
        executor.setExitValue(0);

        try {
            log.info(String.format("Running: %s %s", command, arguments));
            executor.execute(commandLine, executeResultHandler);
            executeResultHandler.waitFor();

            int exitCode = executeResultHandler.getExitValue();
            String output = outputStream.toString();

            log.info("Command executed. Exit code: " + exitCode);
            log.info("Message: " + output);

            TestGlobalsManager.setTestGlobal("OUTPUT", output);
        } catch (IOException | InterruptedException e) {
            log.error("Cannot execute command: " + e.toString());
        }

        return executeResultHandler.getExitValue();
    }

    public static void startVideoRecording() {
        String arguments = String.format("video -a start -p %s -u %s -e true", Config.PLATFORM_NAME.toLowerCase(), Config.DEVICE_UID);
        CommonFunctions.runShell("flick", arguments);
    }

    public static void stopScreenVideo() {
        String arguments = String.format("video -a stop -p %s -u %s -e true -o %s -f mp4 -t",
                Config.PLATFORM_NAME.toLowerCase(),
                Config.DEVICE_UID,
                System.getProperty("user.dir") + "/target");
        CommonFunctions.runShell("flick", arguments);
    }

    public static void executeJavaScript(String command) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String result = (String) js.executeScript(command);
            log.info("Execute JS result: " + result);
        } catch (JavascriptException js) {
            log.error("Execute JS error: " + js.getMessage());
        }

    }
}
