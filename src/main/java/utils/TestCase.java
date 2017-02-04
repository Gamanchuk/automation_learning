package utils;

import java.lang.annotation.*;

/**
 * Created by vnaksimenko on 27.11.16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TestCase {
    String value();
}