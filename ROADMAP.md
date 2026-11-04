# Development roadmap

Progress is based on working behavior and useful feedback, not a fixed number of
commits. A milestone is complete only when its acceptance criteria are met.

| Milestone | Work | Acceptance criteria |
| --- | --- | --- |
| Initial maintenance | Fix form checks and credential exposure; add translations and regression tests. | Java tests pass; full Android build and device checks are tracked separately. |
| License clarification | Establish the original author's licensing intentions. | An appropriate license and upstream attribution are documented with the required permission. Currently unresolved. |
| Reproducible Android build | Migrate Gradle, Android plugin, repositories, and libraries in a separate change. | A clean checkout builds in documented Android Studio/JDK/SDK versions; automated build passes. |
| Accessible layouts | Support small screens, keyboard scrolling, large text, and screen readers. | Device checks pass in each supported language; before/after evidence uses sample data. |
| Translation review | Have Bengali, English, and default-language text reviewed by fluent speakers. | Reported wording and truncation problems are fixed and checked on-device. |
| Useful release | Publish a tagged learning-demo release with setup instructions and known limitations. | A second person can build and follow the demo from a clean checkout. |
| Ongoing maintenance | Reproduce real reports, fix defects, and keep build instructions current. | Releases and issue resolutions link to actual changes and checks. |

## Working with other projects

Read each project's contribution guide first. Choose a reproducible issue you
understand, such as a documentation error, translation problem, missing test, or
bug. Prepare a focused fix and validate it before asking maintainers to review it.
A maintainer's acceptance is their decision; a pull request is not a promised
merge. No messages or pull requests have been sent to other projects as part of
this initial maintenance revision.

## A separate project using hospitality experience

After the basic workflow is understood, consider an original, separately licensed
hotel promotion toolkit. Start with one concrete need, such as validating contact
details in a campaign CSV, using fictional examples. First confirm the need with
actual users, then build and test a small tool. Keep it separate from this Android
fork, retain a clear license, and document feedback and adoption accurately.
