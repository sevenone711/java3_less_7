package java3_less7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //область видимости компилируется и доступна всегда
@Target(ElementType.METHOD) // анотация для метода
public @interface AfterSuite {
}
