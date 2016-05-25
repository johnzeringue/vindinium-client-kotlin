vindinium-client-kotlin
=======================

A Kotlin client for [Vindinium][]. See `sample/` for basic usage.

To run the sample, first replace

```kotlin
val client: Client? = null
```

with

```kotlin
val client: Client? = Client("YOUR-SECRET-KEY")
```

in `Main.kt`. A new secret key can be generated
[here](http://vindinium.org/register).

Then, run `./gradlew run` in a terminal.

[Vindinium]: https://github.com/ornicar/vindinium
