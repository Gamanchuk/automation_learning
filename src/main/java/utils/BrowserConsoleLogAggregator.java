package utils;

import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BrowserConsoleLogAggregator {

    private static org.apache.commons.logging.Log log = LogFactory.getLog(JiraHelper.class);
    private static Process adbLogcatProcess = null;

    public static void startCapturing() {
        startAdbLogcat();
    }

    public static void stopCapturing() {
        String pid = (String) TestGlobalsManager.getTestGlobal("AGGREGATOR_PID");
        if(adbLogcatProcess != null) {
            adbLogcatProcess.destroy();
        }
        if(pid != null) {
            ProcessBuilder builder = new ProcessBuilder("kill", "-9", pid);
            try {
                builder.start();
            } catch (IOException e) {
                e.printStackTrace();
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
            log.info("adb logcat doesn't started. See error message: ");
            log.info(e.getMessage());
        }

    }
}
