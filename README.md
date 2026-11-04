# Simple Login Demo

A small Android learning project for checking login and registration form input.
The original project is [artionh/simpleLogin](https://github.com/artionh/simpleLogin).
This fork preserves its history and adds validation, credential-handling fixes,
English and Bengali translations, and regression tests.

**This is a local demonstration, not a working authentication system.** It does
not verify identities, create accounts, contact a server, or save passwords.
Use sample information only. The profile is a demo preview.

## What the current revision changes

- Checks required input and basic email syntax before opening the preview.
- Checks password confirmation on every normal registration-button tap.
- Keeps passwords out of Toast messages, Intent extras, and the profile screen.
- Disables password-field state saving and clears passwords after valid forms.
- Handles a profile opened without email data without crashing.
- Provides English and Bengali strings alongside the original default language.

## Run the validation tests

Install a Java Development Kit (JDK) and Python 3, then run this command from the
repository folder:

```sh
python3 tools/run_validation_tests.py
```

On Windows, use `py tools/run_validation_tests.py` if `python3` is unavailable.
The test runner compiles the actual Java validation code and runs regression
cases without downloading dependencies or requiring an Android SDK. A Java
runtime without a compiler is insufficient.

These tests cover validation logic. They do **not** establish that the Android
application builds, renders correctly, or provides secure authentication.
See [TESTING.md](TESTING.md) for device checks.

## Android build status

The inherited build uses Android Gradle Plugin 2.3.1, Gradle 3.3, Android SDK 25,
Build Tools 25.0.2, legacy Android support libraries, and JCenter. It has not been
migrated to the current Android toolchain. Do not assume it will build in current
Android Studio or that its old dependencies remain downloadable.

The full Android build and device tests have **not** been verified for this
revision. Updating the toolchain is a separate milestone in [ROADMAP.md](ROADMAP.md).

## Contributing

Start with [CONTRIBUTING.md](CONTRIBUTING.md) and the
[development roadmap](ROADMAP.md). Useful improvements include reproducible bug
reports, tested fixes, accessible layouts, and native-language translation review.

## Attribution and license status

Original Android application: [artionh](https://github.com/artionh).
Fork: [biswajitbairagi](https://github.com/biswajitbairagi).
The initial maintenance revision was prepared with AI assistance; review its
changes and test results as you would any other contribution.

No LICENSE file was present in the upstream snapshot inspected for this revision.
This revision does not assign a new license to the inherited source. Clarifying
the project's license with its original author remains an outstanding task.
