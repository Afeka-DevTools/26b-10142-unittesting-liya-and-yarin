# Homework 2 – Unit Testing with Gradle

## Team Members

* Yarin Luder (212948376)
* Liya Bash (214695173)

---

## Project Description

This project was developed as part of the **Development Tools** course.

The purpose of the project is to write **JUnit 5 unit tests** for the methods provided in `App.java` using **Gradle** as the build system.

---

## Project Structure

```text
app/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/App.java
│   └── test/
│       └── java/
│           └── org/example/AppTest.java
├── build.gradle.kts
└── gradlew
```

---

## Requirements

Before running the project, make sure the following software is installed:

* Java JDK 21 or newer
* Gradle (optional, the Gradle Wrapper is included)
* Git

---

## Clone the Repository

Clone the project to your local machine:

```bash
git clone <repository-url>
```

Move into the project directory:

```bash
cd <repository-folder>
```

---

## Running the Unit Tests

### Windows

Run:

```powershell
.\gradlew test
```

### Linux / macOS

Run:

```bash
./gradlew test
```

Gradle will:

1. Compile the application.
2. Compile the unit tests.
3. Execute all JUnit tests.
4. Display the test results.

---

## Test Report

After the tests finish, a detailed HTML report is generated at:

```text
app/build/reports/tests/test/index.html
```

Open `index.html` in your browser to view:

* Passed tests
* Failed tests
* Execution time
* Error details (if any)

---

## Technologies Used

* Java 21
* Gradle
* JUnit 5
* Git
* GitHub

---

## Additional Files

The repository also contains:

* `LEARNING.md` – Documentation of the learning process using an LLM.
* `COPILOT.md` – Documentation of AI-assisted unit test development.
