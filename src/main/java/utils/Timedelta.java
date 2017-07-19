package utils;

class Timedelta {
    private static long timeout;

    private Timedelta(long timeout) {
        Timedelta.timeout = timeout;
    }

    static Timedelta ofMinutes(int minutes) {
        return new Timedelta(minutes * 60000);
    }

    static Timedelta ofSeconds(int seconds) {
        return new Timedelta(seconds * 1000);
    }

    long asSeconds() {
        return timeout / 1000;
    }

    long asMillis() {
        return timeout;
    }

    static Timedelta now() {
        return new Timedelta(System.currentTimeMillis());
    }

    double diff(Timedelta started) {
        return (timeout - started.asMillis()) / 1000.0;
    }
}
