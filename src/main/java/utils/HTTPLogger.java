package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.DriverFactory.getDriver;

public class HTTPLogger {
    private static Log log = LogFactory.getLog(HTTPLogger.class.getSimpleName());

    public static List<LogEntry> getAllMessages() {
        return getDriver().manage().logs().get(LogType.PERFORMANCE).getAll();
    }


    public static String getMessageForURL(String url) {
        List<LogEntry> messages = getAllMessages();

        for (LogEntry message : messages) {
            if (message.getMessage().contains(url)) {
                return message.getMessage();
            }
        }
        return null;
    }

    public static String getURLFromMessage(String message) {
        String regexp = "\"url\":\"([\\w/:\\-.?=%&]*)";


        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public static String getEndPoint(String url) {
        String[] strs = url.split("/");
        String endpointWithParams = strs[strs.length - 1];
        return endpointWithParams.split("\\?")[0];
    }

    public static String getRequestParameter(String url, String parameterName) {
        if (url.contains("?")) {
            String paramsStr = url.split("\\?")[1];
            String[] params = paramsStr.split("&");
            for (String param : params) {
                if (param.contains(parameterName)) {
                    return param.split("=")[1];
                }
            }
        } else {
            // TODO: handle this situation
        }

        return null;
    }
}
