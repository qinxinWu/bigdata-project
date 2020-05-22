package pku.qingxin.common.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author qingxin
 * @create 2020-05-03 16:38
 */
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableRef {
    String value();
}
