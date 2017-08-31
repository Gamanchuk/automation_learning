package utils;

import java.util.HashMap;

public class TestGlobalsManager {
    private static HashMap<String, Object> testGlobals = new HashMap<>();

    private static HashMap<String, Object> getGlobals() {
        return testGlobals;
    }

    public static Object getTestGlobal(String name) {
        if (getGlobals() != null) {
            return getGlobals().get(name);
        } else {
            return null;
        }
    }

    public static boolean hasTestGlobal(String name) {
        return getGlobals() != null && getGlobals().containsKey(name);
    }

    public static void setTestGlobal(String name, Object value) {
        getGlobals().put(name, value);
    }

    public static void clearTestGlobal() {
        if (getGlobals() != null) {
            getGlobals().clear();
        }
    }
}
