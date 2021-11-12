package com.espacio.ws.usuarios.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	//private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9]{2})(?=.*[a-z])(?=.*[A-Z]).{4,20}$";

	private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	public static boolean isValid(final String password) {
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
