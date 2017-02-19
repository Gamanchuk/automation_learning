package utils;

import com.google.common.base.Preconditions;

import java.util.HashMap;

public class TestGlobalsManager {
    private static ThreadLocal<HashMap<String, Object>> testGlobals = new ThreadLocal<>();

    private static HashMap<String, Object> getGlobals() {
        return testGlobals.get();
    }

    private static void initTestGlobals() {
        testGlobals.set(new HashMap<String, Object>());
    }

    public static Object getTestGlobal(String name) {
        Preconditions.checkNotNull(getGlobals());
        return getGlobals().get(name);
    }

    public static boolean hasTestGlobal(String name) {
        return getGlobals() != null && getGlobals().containsKey(name);
    }

    public static void setTestGlobal(String name, Object value) {
        if (null == getGlobals()) initTestGlobals();
        getGlobals().put(name, value);
    }
}
