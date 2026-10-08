# Android 4 — device matrix

Foroom Training, debug build, `ConversationTests` (Espresso, Kotlin, POM).
Run date: 2026-10-08.

| # | Device / AVD | Android | API | Resolution | Type | sendMessageInJohnWeekChat | sendQuestionInOwnChat | continueConversationWithAnotherAccount |
| 1 | Pixel_6_API_33 | 13 | 33 | 1080x2400 | Emulator | Pass | Pass | Pass |
| 2 | Pixel_6a_API_34 | 14 | 34 | 1080x2400 | Emulator | Pass | Pass | Pass |
| 3 | Pixel_6a_API_35 | 15 | 35 | 1080x2400 | Emulator | Pass | Pass | Pass |

## Runs

- Full `ConversationTests` class, run on all three AVDs from Android Studio: 9 of 9 passed (3/3 on each device).
- Screenshots of the results are in `screenshots/`.

## Notes

- Each test registers `usera` and `userb` and creates the `johnWeek`, full-name and `something` chats in `@Before`, so no test depends on another.
- All devices are emulators; no physical device was used.