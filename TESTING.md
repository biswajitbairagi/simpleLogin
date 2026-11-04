# Testing

## Automated validation regression tests

Run `python3 tools/run_validation_tests.py` with Python 3 and a JDK installed.
The runner builds FormValidator.java and FormValidatorTest.java into a temporary
directory, executes the tests, and removes the generated classes afterward.
There is no dependency installation and no Android SDK requirement for this check.

Coverage includes missing and whitespace-only fields, malformed email input,
password mismatches, exact password comparison, missing phone input, and a Bengali
name. These tests do not validate email ownership or phone-number formatting.

## Device checklist after the Android build is restored

Use sample data such as `guest@example.com` and `sample-only`.

| Action | Expected behavior |
| --- | --- |
| Preview with an empty or malformed email | Field error; profile does not open. |
| Preview with a blank password | Field error; profile does not open. |
| Preview with valid sample values | Demo notice; email and demo status appear; no password appears. |
| Return to login after preview | Password field is empty. |
| Tap registration with different passwords | Confirmation field error; no completion notice. |
| Tap registration with all valid sample fields | Notice explicitly says no account was created; both password fields clear. |
| Recreate login or registration after typing a password | Password fields are not restored from view state. |
| Open profile internally without extras | Fallback email text; no crash. |
| Change device language to English, Bengali, and the default language | Visible text is readable and actions remain usable. |

Also inspect the outgoing preview Intent: only the demo email should be present.
Inspect logs and screenshots to ensure no password is exposed. Test small screens,
large text, and keyboard visibility during the layout-accessibility milestone.

## Verification record for the initial maintenance revision

The Java validation regression suite was run locally. XML parsing and resource
references were checked. The Android SDK/build environment was unavailable, so
no APK build, emulator run, or on-device verification is claimed.
