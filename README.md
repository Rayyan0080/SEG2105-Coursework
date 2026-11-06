# SEG2105 – Introduction to Software Engineering

Labs, assignments and in-class exercises for SEG2105 at the University of Ottawa (Fall 2025), written in Java and Android.

- **Student:** Rayyan Omar
- **Course project:** [OTAMS tutoring app (Group 7)](https://github.com/Rayyan0080/project-group-7), kept in its own repository

## Repository layout

```text
labs/
  lab-1-git-workflow/            team repository and Git basics
  lab-2-pointcp/                 PointCP design exercise (polar / cartesian points)
  lab-3-calculator/              Android calculator app
  lab-4-team-logo/               Android multi-activity app with intents
  lab-5-espresso-tests/          Espresso UI tests for a registration screen
  lab-firebase-product-catalog/  Android app backed by Firebase Realtime Database
assignments/
  simpleChat/                    client-server chat built on OCSF
  OCSF/                          Object Client-Server Framework (provided by the course)
exercises/
  exercise-1/                    vehicle class hierarchy
  exercise-2/                    event handlers through an interface
  exercise-3/                    sorting students with comparators
```

---

## Labs

### Lab 1: Team Git workflow
`labs/lab-1-git-workflow`

The team set up a shared GitHub repository and practised cloning, committing, pushing and resolving merge conflicts. Each member added their own file and their name to `team.txt`.

**Concepts:** Git clone/commit/push/pull, merge conflicts, team collaboration on GitHub

### Lab 2: PointCP design
`labs/lab-2-pointcp`

`PointCP` stores a point in either polar or cartesian form and converts between them. `PointCPTest` reads a coordinate type and two values from the command line, or prompts for them, and prints the point in both forms. The lab uses this deliberately imperfect design to discuss design trade-offs between storing one representation and converting on demand.

**Concepts:** class design, encapsulation, alternative internal representations, design trade-offs

### Lab 3: Calculator app
`labs/lab-3-calculator`

An Android calculator. Digit buttons build the current number, and operator buttons (`+`, `-`, `×`, `÷`, `=`) are handled with an `Operator` enum that tracks the pending operation.

**Concepts:** Android Studio project setup, XML layouts, button click handlers, keeping UI state in an Activity

### Lab 4: Team logo app
`labs/lab-4-team-logo`

A multi-screen Android app. The user enters a team name and postal code, picks a logo on a second screen (`LogoSelectorActivity` returns the choice through `setResult`), opens the postal code in Google Maps with an implicit intent, and sees a confirmation screen. The team is passed between screens as a `Serializable` `Team` object.

**Concepts:** explicit and implicit intents, `startActivityForResult` / `onActivityResult`, passing objects between activities, drawable resources

### Lab 5: Espresso UI tests
`labs/lab-5-espresso-tests`

Instrumented UI tests written with Espresso for a student registration screen. They type into the name and email fields, press the register button, and check that the right validation errors appear (for example, "Please enter a valid email address").

**Concepts:** Android instrumented testing, `ActivityScenarioRule`, Espresso `onView` / `perform` / `check`, input validation

### Firebase lab: Product catalog
`labs/lab-firebase-product-catalog`

An Android product catalog backed by Firebase Realtime Database. Products (name and price) are added from a form, listed live with a `ValueEventListener` on the `products` node, and updated or deleted from a dialog that opens when a product is long-pressed.

**Concepts:** Firebase Realtime Database, create/read/update/delete operations, real-time listeners, custom list adapters, dialogs

> `google-services.json` is not committed. To run the app, create a Firebase project, enable Realtime Database and place your own `google-services.json` in `app/`.

---

## Assignments

### simpleChat: client-server chat
`assignments/simpleChat` (uses `assignments/OCSF`)

A console chat application built on the course's Object Client-Server Framework (OCSF), based on the textbook *Object-Oriented Software Engineering* (Lethbridge and Laganière). The assignment extends the provided base code:

- `ChatClient` / `ClientConsole`: a client that needs a login ID and reports when it can't connect
- `EchoServer` / `ServerConsole`: a server that listens on port 5555 by default and accepts console commands
- `tests/SemiAutoChatRunner.java` runs the course's semi-automatic test cases, and `tests/test run outcome` is a recorded run (server start-up, client without login, client with no server, and so on)

**Concepts:** client-server architecture, sockets, the framework/hook-method pattern, console UI, test-driven verification

The original fork with its commit history is at [Rayyan0080/simpleChat](https://github.com/Rayyan0080/simpleChat).

---

## In-class exercises

### Exercise 1: Vehicle hierarchy
`exercises/exercise-1`

A `Vehicle` base class with `LandVehicle` and `AirVehicle` branches, concrete `Car`, `Bike`, `Plane` and `Helicopter` classes, and a `Printable` interface, exercised by `VehicleTest`.

**Concepts:** inheritance, abstract classes, interfaces, polymorphism

### Exercise 2: Event handlers
`exercises/exercise-2`

An `EventHandler` interface with `Logger`, `Alerter` and `Notifier` implementations, which `EventManagerTest` applies to prioritized `Event` objects.

**Concepts:** programming to an interface, polymorphic dispatch

### Exercise 3: Sorting students
`exercises/exercise-3`

A `Student` class sorted by last name and by average grade using two `Comparator` classes, with a demo program.

**Concepts:** `Comparator`, the strategy pattern, sorting collections

---

## Running the code

- **Plain Java** (lab 2, exercises, simpleChat): compile with `javac` and run with `java`, or open the folder in Eclipse or IntelliJ. simpleChat needs `assignments/OCSF/src` on the classpath.
- **Android** (labs 3, 4 and Firebase): open the lab folder in Android Studio and let Gradle sync.

## Credits

Lab 1, the Firebase lab and other team labs were done with my lab team (Abdurrahman, Taha Rashid, Roheen Ghafuri). PointCP, OCSF and the simpleChat base code were provided by the course and textbook authors, and keep their original headers.
