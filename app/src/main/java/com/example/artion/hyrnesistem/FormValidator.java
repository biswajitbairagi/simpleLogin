package com.example.artion.hyrnesistem;

import java.util.regex.Pattern;

/** Android-independent checks for a demo form, not an authentication service. */
public final class FormValidator {
    // Basic syntax checking only; this does not establish email ownership.
    private static final Pattern EMAIL = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    public enum Error {
        NONE, NAME_REQUIRED, EMAIL_REQUIRED, EMAIL_INVALID, PASSWORD_REQUIRED,
        CONFIRMATION_REQUIRED, PASSWORD_MISMATCH, PHONE_REQUIRED
    }

    private FormValidator() {
    }

    public static Error validateLogin(String email, String password) {
        if (isBlank(email)) {
            return Error.EMAIL_REQUIRED;
        }
        if (!EMAIL.matcher(email.trim()).matches()) {
            return Error.EMAIL_INVALID;
        }
        if (isBlank(password)) {
            return Error.PASSWORD_REQUIRED;
        }
        return Error.NONE;
    }

    public static Error validateRegistration(String name, String email,
            String password, String confirmation, String phone) {
        if (isBlank(name)) {
            return Error.NAME_REQUIRED;
        }
        Error loginError = validateLogin(email, password);
        if (loginError != Error.NONE) {
            return loginError;
        }
        if (isBlank(confirmation)) {
            return Error.CONFIRMATION_REQUIRED;
        }
        // Compare exactly; do not silently trim or normalize passwords.
        if (!password.equals(confirmation)) {
            return Error.PASSWORD_MISMATCH;
        }
        if (isBlank(phone)) {
            return Error.PHONE_REQUIRED;
        }
        return Error.NONE;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
