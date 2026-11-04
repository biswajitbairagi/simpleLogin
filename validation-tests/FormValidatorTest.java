package com.example.artion.hyrnesistem;

/** Regression tests executable with a JDK, without an Android SDK or JUnit. */
public final class FormValidatorTest {
    private static int assertions;

    public static void main(String[] args) {
        expect("valid login", FormValidator.Error.NONE,
                FormValidator.validateLogin("guest@example.com", "sample-only"));
        expect("email padding", FormValidator.Error.NONE,
                FormValidator.validateLogin("  guest@example.com  ", "sample-only"));
        expect("null email", FormValidator.Error.EMAIL_REQUIRED,
                FormValidator.validateLogin(null, "sample-only"));
        expect("blank email", FormValidator.Error.EMAIL_REQUIRED,
                FormValidator.validateLogin(" \t ", "sample-only"));
        String[] invalidEmails = {"guest", "guest@", "@example.com", "a@@b.com",
                "guest@example", "guest @example.com", "guest@example.com\nother"};
        for (String email : invalidEmails) {
            expect("invalid email: " + email, FormValidator.Error.EMAIL_INVALID,
                    FormValidator.validateLogin(email, "sample-only"));
        }
        expect("null password", FormValidator.Error.PASSWORD_REQUIRED,
                FormValidator.validateLogin("guest@example.com", null));
        expect("blank password", FormValidator.Error.PASSWORD_REQUIRED,
                FormValidator.validateLogin("guest@example.com", " \t "));
        expect("valid registration", FormValidator.Error.NONE,
                registration("Guest", "guest@example.com", "sample-only", "sample-only", "+91 9000000000"));
        expect("null name", FormValidator.Error.NAME_REQUIRED,
                registration(null, "guest@example.com", "sample-only", "sample-only", "123"));
        expect("blank name", FormValidator.Error.NAME_REQUIRED,
                registration("   ", "guest@example.com", "sample-only", "sample-only", "123"));
        expect("registration invalid email", FormValidator.Error.EMAIL_INVALID,
                registration("Guest", "wrong", "sample-only", "sample-only", "123"));
        expect("registration missing email", FormValidator.Error.EMAIL_REQUIRED,
                registration("Guest", null, "sample-only", "sample-only", "123"));
        expect("registration missing password", FormValidator.Error.PASSWORD_REQUIRED,
                registration("Guest", "guest@example.com", null, "sample-only", "123"));
        expect("missing confirmation", FormValidator.Error.CONFIRMATION_REQUIRED,
                registration("Guest", "guest@example.com", "sample-only", null, "123"));
        expect("blank confirmation", FormValidator.Error.CONFIRMATION_REQUIRED,
                registration("Guest", "guest@example.com", "sample-only", "  ", "123"));
        expect("mismatched passwords", FormValidator.Error.PASSWORD_MISMATCH,
                registration("Guest", "guest@example.com", "first", "second", "123"));
        expect("passwords are case sensitive", FormValidator.Error.PASSWORD_MISMATCH,
                registration("Guest", "guest@example.com", "Sample", "sample", "123"));
        expect("password padding is significant", FormValidator.Error.PASSWORD_MISMATCH,
                registration("Guest", "guest@example.com", " sample ", "sample", "123"));
        expect("matching password padding is preserved", FormValidator.Error.NONE,
                registration("Guest", "guest@example.com", " sample ", " sample ", "123"));
        expect("null phone", FormValidator.Error.PHONE_REQUIRED,
                registration("Guest", "guest@example.com", "sample-only", "sample-only", null));
        expect("blank phone", FormValidator.Error.PHONE_REQUIRED,
                registration("Guest", "guest@example.com", "sample-only", "sample-only", "  "));
        expect("Bengali name", FormValidator.Error.NONE,
                registration("বিশ্বজিৎ", "guest@example.com", "sample-only", "sample-only", "123"));
        System.out.println("PASS: " + assertions + " validation regression cases");
    }

    private static FormValidator.Error registration(String name, String email,
            String password, String confirmation, String phone) {
        return FormValidator.validateRegistration(name, email, password, confirmation, phone);
    }

    private static void expect(String label, FormValidator.Error expected,
            FormValidator.Error actual) {
        if (expected != actual) {
            throw new AssertionError(label + ": expected " + expected + ", got " + actual);
        }
        assertions++;
    }
}
