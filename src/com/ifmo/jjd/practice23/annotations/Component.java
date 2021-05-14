package com.ifmo.jjd.practice23.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // в качестве параметром можно использовать
    // строки, примитивы, enum
    String fileName(); // обязательный параметр
    long version() default 1; // необязательный параметр
}
