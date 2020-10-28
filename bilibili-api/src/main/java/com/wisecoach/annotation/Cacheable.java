package com.wisecoach.annotation;

/**
 * @author wisecoach
 */
public @interface Cacheable {
    String value() default "";
}
