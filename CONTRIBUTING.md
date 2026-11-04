# Contributing

This project is an Android form-validation learning demo. Contributions should
solve a specific problem and explain the resulting behavior.

## First contribution

1. Read the README, including the demo, build, and license limitations.
2. Pick one item from the roadmap that you can reproduce and understand.
3. Create a branch and make one coherent change. Preserve upstream attribution.
4. Run `python3 tools/run_validation_tests.py` if validation behavior changes.
5. For UI changes, follow TESTING.md and report the Android version and locale.
6. Describe the problem, the change, and the checks actually performed in your
   pull request. Say when a check could not be run. Disclose material AI assistance.

Translation review and clear reproduction steps are useful contributions too.
Only claim work, tests, adoption, and contributions that actually happened.

## Reporting a bug

Include the device or emulator, Android version, app language, steps using sample
input, expected behavior, and observed behavior. Do not include real passwords,
guest information, phone numbers, or other personal data in reports or screenshots.

## Current boundaries

This demo does not have a backend, authentication, account storage, or password
recovery. Implementing these would require a separately reviewed design and tests;
do not treat local form validation as identity verification.

The Android build and upstream license status need attention before broader reuse.
