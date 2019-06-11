package com.ido.luffy;


import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(LuffyAutoConfig.class)
public @interface EnableLuffy {

    @AliasFor("value")
    String[] basePackages() default "";

    @AliasFor("basePackages")
    String[] value() default "";


}