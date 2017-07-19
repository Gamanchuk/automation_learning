package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UnixProcessHelpers {
    private static Log log = LogFactory.getLog(CommonFunctions.class.getSimpleName());

    public static void killProcessesGracefully(String name, String name1) {

    }

    public static boolean isProcessRunning(String name) {

        Process process = null;

        try {
            process = Runtime.getRuntime().exec(String.format("ps %s", name));
            process.waitFor();

            int exitCode = process.exitValue();
            String output = process.getOutputStream().toString();

            if (exitCode == 1)
                throw new Exception();

            log.info("Command executed. Exit code: " + exitCode);
            log.info("Message: " + output);

            return true;
        } catch (Exception e) {
            log.error("Cannot execute command: " + e.toString());
        }

        return false;
    }
}

