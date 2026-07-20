# 🏥 Hospital Management System — Professional Edition

A complete, from-scratch rewrite of a single-file Java console prototype into a
properly layered, production-style application. Same core idea — manage
Doctors, Patients, Staff, Appointments, and Facilities from a terminal — now
built the way a real Java codebase should be.

---

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Before / After — What Changed and Why](#before--after--what-changed-and-why)
4. [Architecture](#architecture)
5. [Project Structure](#project-structure)
6. [Design Patterns Used](#design-patterns-used)
7. [Class Reference](#class-reference)
8. [Requirements](#requirements)
9. [Building & Running](#building--running)
10. [Usage Walkthrough](#usage-walkthrough)
11. [Sample Output](#sample-output)
12. [Data & File Export](#data--file-export)
13. [Error Handling & Validation](#error-handling--validation)
14. [Known Limitations](#known-limitations)
15. [Possible Future Improvements](#possible-future-improvements)
16. [License](#license)

---

## Overview

This project is a menu-driven, console-based Hospital Management System
written in plain Java (no external dependencies, no frameworks — just the
JDK standard library). It lets hospital staff register and browse doctors,
patients, staff members, appointments, and facilities, and export the staff
roster to a text file.

It began life as a single 450-line file with public mutable fields, fixed
25/100-element arrays, and duplicated `Scanner` instances. It has been
redesigned into ~30 small, single-purpose classes organized into standard
architectural layers, while keeping the exact same functional scope so it's
easy to compare the two versions.

---

## Features

- **Doctor Management** — register doctors with specialization, working
  hours, and qualifications; view the full roster in a formatted table.
- **Patient Management** — register patients with age, gender, diagnosis,
  and admission status (`Admitted` / `Outpatient` / `Discharged`).
- **Staff Management** — register support staff with designation, gender,
  and salary; view the roster; **export it to `Staff.txt`** at any time.
- **Appointment Management** — book an appointment by disease and requested
  speciality; the system automatically assigns a real on-staff doctor whose
  specialization matches, or generates a named on-call doctor if none is
  available.
- **Facility Management** — register and list hospital facilities/amenities
  (ambulance, canteen, ventilator unit, etc.).
- **Auto-generated, collision-free IDs** for every entity (`DOC-101`,
  `PAT-201`, `STF-301`, `APT-1001`, `FAC-401`, …).
- **Self-healing input** — every prompt rejects and re-asks on bad input
  instead of crashing the program.
- **Pre-seeded demo data** so the app is immediately explorable on first run.
- **Clean, auto-sized ASCII tables** and section banners with a live
  date/time header.

---

## Before / After — What Changed and Why

| Original | Rewrite | Why it matters |
|---|---|---|
| One 450-line `HospitalManagement.java` with everything inline | 25+ focused classes across `model / service / repository / util / io / app` | Each class has one job; changes stay local instead of rippling through a giant `switch`. |
| Fixed-size arrays (`doctor[25]`, `patient[100]`) — silently breaks past that limit | `InMemoryRepository<T>` backed by a `Map`, unbounded | No hidden capacity ceiling, O(1) lookup by ID. |
| Public mutable fields (`String pname;`) | Private fields, builders, getters | Encapsulation — objects can't be put into an invalid state. |
| A new `Scanner` created in almost every method | One shared `InputReader` | Avoids the classic "skipped input" bug from mixing multiple `Scanner`s on `System.in`. |
| No input validation — a bad number crashes the program (`InputMismatchException`) | Every read retries until valid | The app never crashes on bad user input. |
| Staff file export hand-writes `s[0]`…`s[6]` with a chain of `if (count3 == N)` | `StaffFileExporter.export(List<Staff>, path)` using try-with-resources | Works for any number of staff, not just up to 7. |
| Lowercase class names (`doctor`, `patient`, `staff`) violating Java conventions | `Doctor`, `Patient`, `Staff` — PascalCase throughout | Follows standard Java naming conventions. |
| `patient` / `staff` pointlessly `extends HospitalManagement` (the class holding `main`) | Clean inheritance from an abstract `Person` base | Removes an inheritance relationship that made no domain sense. |
| Appointment doctor assignment was always a random name, even if a real matching doctor was on staff | `AppointmentService` first checks registered doctors for a specialization match, falls back to a generated on-call name only if none exists | More realistic and useful behavior. |
| No package structure | `hms.model`, `hms.enums`, `hms.repository`, `hms.service`, `hms.io`, `hms.util`, `hms.app` | Standard layered architecture, similar to controller/service/repository in real-world Java apps. |
| Free-form strings for gender / admit status | `Gender`, `AdmitStatus`, `AppointmentStatus` enums | Compile-time safety — no more typos like `"Amditted"` silently accepted. |
| No exception types | `RecordNotFoundException`, `ValidationException` | Room to grow — future features can fail with meaningful, catchable errors instead of generic `RuntimeException`. |

---

## Architecture

The application follows a simple, unidirectional layered architecture:

```
 app (console UI / menu loop)
   │
   ▼
 service (business rules, ID generation, doctor matching)
   │
   ▼
 repository (storage abstraction)
   │
   ▼
 model (entities)
```

`util` (input reading, table rendering, banners, ID generation) and `io`
(file export, demo data seeding) are cross-cutting helpers used by the
layers above.

- **model** — immutable-by-default records built via the Builder pattern
  (`Doctor.builder().name(...).build()`), so an object can never be
  constructed half-filled.
- **repository** — a generic, swappable persistence contract
  (`Repository<T>`). Today it's in-memory; swapping in a database or
  file-backed implementation later only requires a new class implementing
  `Repository<T>`, with **zero changes** to `service` or `app`.
- **service** — all business rules (ID generation, doctor matching, staff
  export orchestration) live here, independent of the console UI. This is
  what you'd unit-test.
- **app** — the only layer that knows about `System.out` / `System.in`.
  Pure presentation/orchestration glue.

---

## Project Structure

```
HospitalManagementSystem-Pro/
├── README.md
└── src/
    └── hms/
        ├── Main.java                      Application entry point
        │
        ├── app/
        │   └── HospitalConsoleApp.java    Menu loop & presentation glue
        │
        ├── model/
        │   ├── Person.java                Abstract base (id, name)
        │   ├── Doctor.java
        │   ├── Patient.java
        │   ├── Staff.java
        │   ├── Appointment.java
        │   └── Facility.java
        │
        ├── enums/
        │   ├── Gender.java
        │   ├── AdmitStatus.java
        │   └── AppointmentStatus.java
        │
        ├── repository/
        │   ├── Repository.java            Generic CRUD contract
        │   └── InMemoryRepository.java     Map-backed implementation
        │
        ├── service/
        │   ├── DoctorService.java
        │   ├── PatientService.java
        │   ├── StaffService.java
        │   ├── AppointmentService.java
        │   └── FacilityService.java
        │
        ├── io/
        │   ├── StaffFileExporter.java      Writes Staff.txt
        │   └── DataSeeder.java             Loads demo records at startup
        │
        ├── exception/
        │   ├── RecordNotFoundException.java
        │   └── ValidationException.java
        │
        └── util/
            ├── InputReader.java            Shared, validating console input
            ├── ConsoleTable.java           Auto-sized ASCII table renderer
            ├── Banner.java                 Header/section banners
            ├── IdGenerator.java            Sequential, prefixed ID generator
            └── RandomNameGenerator.java    Fallback on-call doctor names
```

---

## Design Patterns Used

| Pattern | Where | Purpose |
|---|---|---|
| **Builder** | `Doctor`, `Patient`, `Staff`, `Appointment`, `Facility` | Construct immutable objects field-by-field with readable call sites and no telescoping constructors. |
| **Repository** | `Repository<T>` / `InMemoryRepository<T>` | Decouple business logic from how/where data is stored. |
| **Service Layer** | `hms.service.*` | Isolate business rules from the console UI so they can be reused or tested independently. |
| **Strategy-like fallback** | `AppointmentService.resolveDoctor()` | Try a "real doctor match" strategy first, fall back to a "generated name" strategy. |
| **Static Factory / Utility** | `Banner`, `ConsoleTable`, `RandomNameGenerator`, `StaffFileExporter` | Stateless helpers exposed as final classes with private constructors. |

---

## Class Reference

### model
- **`Person`** — abstract base class holding `id` and `name`, shared by `Doctor`, `Patient`, `Staff`, and `Facility`.
- **`Doctor`** — `specialization`, `workingHours`, `qualification`.
- **`Patient`** — `age`, `gender`, `disease`, mutable `admitStatus`.
- **`Staff`** — `gender`, `designation`, `salary`.
- **`Appointment`** — `patientName`, `age`, `disease`, `requestedSpeciality`, `assignedDoctor`, mutable `status`.
- **`Facility`** — `description`.

### enums
- **`Gender`** — `MALE`, `FEMALE`, `OTHER`.
- **`AdmitStatus`** — `ADMITTED`, `OUTPATIENT`, `DISCHARGED`.
- **`AppointmentStatus`** — `SCHEDULED`, `COMPLETED`, `CANCELLED`.

### repository
- **`Repository<T>`** — `save`, `findById`, `findAll`, `deleteById`, `count`.
- **`InMemoryRepository<T>`** — `LinkedHashMap`-backed implementation preserving insertion order.

### service
- **`DoctorService`** — registers/seeds doctors, generates `DOC-###` IDs.
- **`PatientService`** — registers/seeds patients, generates `PAT-###` IDs.
- **`StaffService`** — registers/seeds staff, generates `STF-###` IDs.
- **`AppointmentService`** — books appointments, generates `APT-####` IDs, matches a requested speciality against registered doctors before falling back to `RandomNameGenerator`.
- **`FacilityService`** — registers/seeds facilities, generates `FAC-###` IDs.

### io
- **`StaffFileExporter`** — writes the full staff roster to a plain-text file using `try-with-resources`.
- **`DataSeeder`** — loads the same illustrative demo records the original project shipped with (4 doctors, 4 patients, 4 staff, 4 facilities).

### util
- **`InputReader`** — the single `Scanner` for the whole app; exposes validating readers (`readNonEmptyString`, `readInt`, `readIntInRange`, `readPositiveDouble`, `readGender`, `readAdmitStatus`).
- **`ConsoleTable`** — computes column widths and renders a boxed ASCII table from any `String[]` rows.
- **`Banner`** — prints the app header, section dividers, and footer.
- **`IdGenerator`** — thread-safe, prefixed, sequential ID generator (`AtomicInteger` under the hood).
- **`RandomNameGenerator`** — produces a plausible on-call doctor name when no specialization match exists.

### exception
- **`RecordNotFoundException`**, **`ValidationException`** — typed exceptions ready for use as the system grows (e.g. update/delete flows, REST API error handling).

### app
- **`HospitalConsoleApp`** — owns the main menu loop and each entity's submenu; the only class that talks to `System.in`/`System.out`.

### root
- **`Main`** — one-line entry point that constructs and runs `HospitalConsoleApp`.

---

## Requirements

- **JDK 17 or later** (developed and tested on JDK 21). No external
  dependencies, build tools, or libraries are required — just the standard
  library.

---

## Building & Running

From the project root:

```bash
# Compile everything into ./out
javac -d out $(find src -name "*.java")

# Run
java -cp out hms.Main
```

On Windows (PowerShell):

```powershell
Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName } > sources.txt
javac -d out "@sources.txt"
java -cp out hms.Main
```

The app runs entirely in the terminal — no build tool (Maven/Gradle)
required, though the flat `src/hms/...` layout maps directly onto one if
you later want to add one.

---

## Usage Walkthrough

On launch, the app seeds itself with demo data and shows the main menu:

```
0. Exit
1. Doctor Management
2. Patient Management
3. Staff Management
4. Appointment Management
5. Facility Management
```

Each entity has its own submenu, typically:

```
0. Back to Main Menu
1. Register New <Entity>
2. View All <Entity>
```

Staff Management has a third option, **Export Staff List to Staff.txt**,
which writes the current roster to disk.

Booking an appointment (`4 → 1`) asks for patient name, age, disease, and a
requested speciality. Behind the scenes, `AppointmentService` looks for a
registered doctor whose `specialization` matches (case-insensitively); if
found, that doctor is assigned. Otherwise, a plausible on-call doctor name
is generated so the patient still gets a named point of contact.

---

## Sample Output

```
====================================================================================
                           HOSPITAL MANAGEMENT SYSTEM
                        Enterprise Console Edition  |  v2.0
====================================================================================
                     Monday, 20 July 2026  |  09:14:02
====================================================================================

------------------------------------------------------------------------------------
                                     MAIN MENU
------------------------------------------------------------------------------------
  0. Exit
  1. Doctor Management
  2. Patient Management
  3. Staff Management
  4. Appointment Management
  5. Facility Management
  Enter your choice:
```

Viewing doctors (`1 → 2`):

```
+---------+-------------------+--------------------+---------------------+---------------+
| ID      | Name              | Specialization      | Working Hours        | Qualification |
+---------+-------------------+--------------------+---------------------+---------------+
| DOC-101 | Dr. Ghanendra Rao | Neurosurgery         | 5:00 PM - 11:00 PM    | MBBS, MD      |
| DOC-102 | Dr. Vikram Sen    | General Physician    | 10:00 AM - 3:00 PM    | MBBS, MD      |
| DOC-103 | Dr. Rekha Nair    | Oncology             | 8:00 AM - 2:00 PM     | MBBS, MS      |
| DOC-104 | Dr. Pramod Iyer   | Orthopedics          | 10:00 AM - 4:00 PM    | MBBS, MS      |
+---------+-------------------+--------------------+---------------------+---------------+
```

Booking an appointment for a "General Physician":

```
Appointment booked successfully. ID: APT-1001 | Assigned Doctor: Dr. Vikram Sen
```

---

## Data & File Export

- All data is held **in memory** for the duration of the run (via
  `InMemoryRepository<T>`) — nothing persists automatically between runs,
  except:
- **`Staff.txt`**, written on demand from the Staff menu, e.g.:

  ```
  ID        Name                Designation       Gender    Salary
  -------------------------------------------------------------------------
  STF-301   Prakash Yadav       Ward Worker       Male      Rs. 5,000.00
  STF-302   Komal Sharma        Nurse             Female    Rs. 2,000.00
  STF-303   Raju Thakur         Ward Worker       Male      Rs. 5,000.00
  STF-304   Rani Desai          Senior Nurse      Female    Rs. 20,000.00
  ```

  This works for any number of staff members, unlike the original's
  hardcoded `if (count3 == 4/5/6)` blocks that only handled up to 7 records.

---

## Error Handling & Validation

- **Blank input** is rejected and re-prompted (`readNonEmptyString`).
- **Non-numeric input** where a number is expected is caught and
  re-prompted (`readInt`, `readPositiveDouble`) — the app never throws an
  uncaught `InputMismatchException` or `NumberFormatException`.
- **Out-of-range values** (e.g. an age outside 0–130) are rejected with a
  clear message (`readIntInRange`).
- **Restricted choices** (gender, admission status) only accept their valid
  option letters, looping until a valid one is entered.
- **File I/O failures** during staff export are caught and reported instead
  of crashing the program (`try { ... } catch (IOException e) { ... }`).

---

## Known Limitations

- Data is **not persisted** across runs except for the on-demand
  `Staff.txt` export — there is no database or serialized state file.
- No authentication/authorization — this is a single-operator console tool,
  not a multi-user system.
- No update/delete operations yet — you can register and view records, but
  not edit or remove them (the `RecordNotFoundException` type is already in
  place for when that's added).
- No automated test suite is included yet, though the layered design makes
  the `service` classes straightforward to unit test in isolation.

---

## Possible Future Improvements

- Add `update` / `delete` flows to each service, using the already-defined
  `RecordNotFoundException`.
- Swap `InMemoryRepository` for a JDBC- or file-backed implementation
  without touching `service` or `app`.
- Add a `JUnit` test suite around the `service` layer.
- Add a REST API (`Spring Boot` or plain `com.sun.net.httpserver`) reusing
  the exact same `service`/`repository`/`model` layers, with `app` replaced
  by controllers.
- Externalize the seeded demo data into a JSON/CSV file loaded by
  `DataSeeder`.

---

## License

This project is provided as-is for educational and portfolio purposes. Feel
free to fork, modify, and reuse it.
