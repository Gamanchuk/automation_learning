package utils;

/**
 * Created by vnaksimenko on 25.11.16.
 */
public enum TestRailStatus {
    PASSED(1), BLOCKED(2), UNTESTED(3), RETEST(4), FAILED(5);

    int statusId;

    TestRailStatus(int statusId) {
        this.statusId = statusId;
    }
}
