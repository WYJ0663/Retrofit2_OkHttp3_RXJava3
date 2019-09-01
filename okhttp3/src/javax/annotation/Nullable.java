package javax.annotation;

import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Nonnull(when = When.UNKNOWN)
@TypeQualifierNickname
@Retention(RetentionPolicy.RUNTIME)
public @interface Nullable {
}
