package utils;

import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by vmaksimenko on 27.04.17.
 */
public class BrowserConsoleLogAggregator {

    private static org.apache.commons.logging.Log log = LogFactory.getLog(JiraHelper.class);

    public static void startCapturing() {
        startAdbLogcat();
    }

    public static void stopCapturing() {
        String pid = (String) TestGlobalsManager.getTestGlobal("AGGREGATOR_PID");
        if(pid != null) {
            ProcessBuilder builder = new ProcessBuilder("kill", "-9", pid);
            try {
                Process process = builder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startAdbLogcat() {
        try {
            ProcessBuilder builder = new ProcessBuilder("/bin/bash", "grep_android_logs.sh");
            Process process = builder.start();

            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String pid = br.readLine();

            process.destroy();

            TestGlobalsManager.setTestGlobal("AGGREGATOR_PID", pid);
            log.info("adb logcat pid: " + pid);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
