# COPILOT.md

# Homework 2 – AI Assisted Unit Testing

This document contains the conversations held with an AI coding assistant while developing the unit tests for `App.java`.

---

# Conversation 1 – Generating Unit Tests

## Me

Let's create unit tests for the functions in `App.java`. Please use JUnit assertions and write the tests in the existing `AppTest.java` file.

---

## ChatGPT

I finished updating `AppTest.java` with unit tests for all the functions in `App.java`.

The generated tests use several JUnit assertions, including:

* `assertEquals()`
* `assertTrue()`
* `assertFalse()`
* `assertThrows()`
* `assertIterableEquals()`

I also attempted to run the tests using:

```powershell
.\gradlew test
```

However, the build failed before executing the tests because Gradle was running with **Java 26.0.1**, which was incompatible with the Gradle Kotlin DSL configuration.

Additionally:

* JDK 21 could not be found in the common installation paths.
* Git was not available in the system `PATH`, so a Git diff could not be generated.

To execute the tests successfully, install JDK 21 (or configure `JAVA_HOME` to point to it) and run:

```powershell
.\gradlew test
```

---

# Conversation 2 – Running the Tests

## Me

I installed JDK 21. Please try running the tests again.

---

## ChatGPT

The tests completed successfully using JDK 21.

The following commands were executed:

```powershell
$env:JAVA_HOME="C:\Program Files\Java\jdk-21.0.11"
$env:Path="$env:JAVA_HOME\bin;$env:Path"

.\gradlew test
```

The process finished with:

```text
Exit code: 0
```

All unit tests in `AppTest.java` passed successfully.

---

# Conversation 3 – Evaluating Test Quality

## Me

How do I know if the tests are sufficient? How can I verify that every execution path has been tested?

---

## ChatGPT

To determine whether a test suite is sufficient, two main aspects should be evaluated.

### 1. Test Quality

The tests should cover:

* Normal use cases (Happy Path)
* Edge cases
* Invalid inputs
* Exception handling

For example, the generated tests include checks for methods such as:

* `add()`
* `reverse()`
* `average()`
* `isPrime()`
* `isPalindrome()`
* `isAnagram()`
* `factorial()`
* `fibonacciUpTo()`

The tests also verify negative values, empty collections, empty strings and exceptions using `assertThrows()`.

---

### 2. Code Coverage

To verify that all execution paths are covered, a coverage tool such as **JaCoCo** should be used.

Add the JaCoCo plugin to the Gradle configuration:

```kotlin
plugins {
    application
    jacoco
}
```

Then execute:

```powershell
.\gradlew test jacocoTestReport
```

The report will be generated under:

```text
app/build/reports/jacoco/test/html/index.html
```

The report shows:

* Covered lines.
* Uncovered lines.
* Partially covered branches.

---

### Coverage Types

* **Line Coverage** – verifies whether every line of code was executed.
* **Branch Coverage** – verifies both outcomes of conditional statements (`if`, `else`, loops, etc.).
* **Method Coverage** – verifies that every method was executed at least once.

---

### Example

For the `factorial()` method, one test validates a valid input:

```java
assertEquals(120, App.factorial(5));
```

Another verifies the exception path:

```java
assertThrows(IllegalArgumentException.class,
    () -> App.factorial(-1));
```

Together these tests cover both execution paths.

Similarly, `isPrime()` is tested using:

* Negative numbers
* Zero
* One
* Prime numbers
* Non-prime numbers
* Boundary values

---

### Conclusion

Although the current test suite covers normal cases, edge cases and exception handling, the professional way to verify completeness is by generating a **JaCoCo Code Coverage Report**. This report identifies any lines or branches that still require additional tests.
