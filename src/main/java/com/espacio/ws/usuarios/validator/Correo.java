package com.espacio.ws.usuarios.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CorreoValidator.class)
@Documented
public @interface Correo {

	String message() default "email no permitido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
