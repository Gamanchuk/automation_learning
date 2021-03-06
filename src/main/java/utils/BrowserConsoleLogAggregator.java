package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BrowserConsoleLogAggregator {

    private static Log log = LogFactory.getLog("BrowserConsoleLogAggregator");
    private static Process adbLogcatProcess = null;

    public static void startCapturing() {
        if (Config.DEVICE_NAME.equals("Android")) {
            startAdbLogcat();
        }
    }

    public static void stopCapturing() {

        if (Config.DEVICE_NAME.equals("Android")) {

            String pid = (String) TestGlobalsManager.getTestGlobal("AGGREGATOR_PID");
            if (adbLogcatProcess != null) {
                adbLogcatProcess.destroy();
            }
            if (pid != null) {
                ProcessBuilder builder = new ProcessBuilder("kill", "-9", pid);
                try {
                    builder.start();
                } catch (IOException e) {
                    log.error("adb logcat doesn't stopped. Error message: ");
                    log.error(e.getMessage());
                }
            }
        }
    }

    private static void startAdbLogcat() {
        try {
            ProcessBuilder builder = new ProcessBuilder("/bin/bash", "grep_android_logs.sh " + Config.DEVICE_UID);
            adbLogcatProcess = builder.start();

            InputStream is = adbLogcatProcess.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String pid = br.readLine();

            TestGlobalsManager.setTestGlobal("AGGREGATOR_PID", pid);
            log.info("adb logcat pid: " + pid);
        } catch (IOException e) {
            log.error("adb logcat doesn't started. Error message: ");
            log.error(e.getMessage());
        }
    }
}

