# PROGRESS.md

# LLD Masterclass/Lab Progress

## Goal

Build a public, long-term Low-Level Design knowledge base.

The repo starts with a 3-hour focused sprint and later expands into a complete LLD masterclass.

Target outcome:

```text
I should be able to approach LLD problems with a clear structure, correct object modeling, useful design patterns, and practical design tradeoffs.
```

## Current Level

Initial diagnostic rating: `3/10`

Current strengths:

- understands basic idea of classes/entities
- knows repository communicates with DB
- understands SRP at a basic level
- can identify some obvious entities in Parking Lot
- knows concurrency issues may require locking

Current gaps:

- entity vs value object
- interface vs abstract class
- association vs aggregation vs composition
- Open/Closed Principle
- Strategy, Factory, State, Observer
- how to start an LLD problem
- how to design class relationships
- how to explain concurrency beyond “use locks”

## Phase 1: 3-Hour Sprint

| Time | Topic | Status |
|---|---|---|
| 00:00 - 00:15 | LLD approach framework | Not Started |
| 00:15 - 00:30 | Entity, value object, DTO, repository | Not Started |
| 00:30 - 00:45 | Interface vs abstract class, composition | Not Started |
| 00:45 - 01:00 | Association, aggregation, composition | Not Started |
| 01:00 - 01:15 | SRP, OCP, DIP | Not Started |
| 01:15 - 01:30 | Strategy pattern | Not Started |
| 01:30 - 01:45 | Factory and Builder patterns | Not Started |
| 01:45 - 02:00 | State and Observer patterns | Not Started |
| 02:00 - 02:20 | Parking Lot mini design | Not Started |
| 02:20 - 02:40 | BookMyShow mini design | Not Started |
| 02:40 - 03:00 | Splitwise mini design and final checklist | Not Started |

## Phase 2: Core Masterclass Expansion

| Module | Topic | Status |
|---|---|---|
| 1 | LLD fundamentals | Not Started |
| 2 | OOP modeling | Not Started |
| 3 | SOLID principles | Not Started |
| 4 | Class relationships | Not Started |
| 5 | UML basics | Not Started |
| 6 | Design patterns | Not Started |
| 7 | Concurrency in LLD | Not Started |
| 8 | API and service design | Not Started |
| 9 | Common design mistakes | Not Started |
| 10 | Full cheat sheet | Not Started |

## Phase 3: Pattern Deep Dives

| Pattern | Status |
|---|---|
| Strategy | Not Started |
| Factory | Not Started |
| Builder | Not Started |
| State | Not Started |
| Observer | Not Started |
| Chain of Responsibility | Not Started |
| Decorator | Not Started |
| Adapter | Not Started |
| Singleton | Not Started |

## Phase 4: Problem Catalog

| Problem | Status |
|---|---|
| Parking Lot | Not Started |
| BookMyShow | Not Started |
| Splitwise | Not Started |
| Vending Machine | Not Started |
| Rate Limiter | Not Started |
| Logger | Not Started |
| Elevator System | Not Started |
| Cache | Not Started |

## Sprint Topic Checklist

### 1. LLD Approach Framework

Status: Not Started

Exercise:

```text
For Parking Lot, write:
1. 5 clarifying questions
2. 5 core entities
3. 3 main use cases
4. 2 future extensions
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 2. Entity, Value Object, DTO, Repository

Status: Not Started

Exercise:

```text
For Splitwise, classify:
User
Group
Expense
Money
Split
Balance
ExpenseRequest
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 3. Interface vs Abstract Class And Composition

Status: Not Started

Exercise:

```text
For payment methods like UPI, Card, Wallet, Cash:
1. Would you use interface or abstract class?
2. Why?
3. Where would composition help?
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 4. Class Relationships

Status: Not Started

Exercise:

```text
Classify these BookMyShow relationships:
1. Theatre - Screen
2. Screen - Seat
3. Movie - Show
4. User - Booking
5. Booking - Payment
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 5. SOLID

Status: Not Started

Exercise:

```text
A BookingService selects seats, calculates price, accepts payment, saves booking, and sends notification.

Split responsibilities into better classes and mention which SOLID principles improve.
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 6. Strategy Pattern

Status: Not Started

Exercise:

```text
For Splitwise split types:
EqualSplit
ExactSplit
PercentageSplit

Design the strategy interface name and implementations.
No full code required.
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 7. Factory And Builder Patterns

Status: Not Started

Exercise:

```text
Where would you use Factory and Builder in these systems?
1. Parking Lot
2. Notification System
3. BookMyShow Booking
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 8. State And Observer Patterns

Status: Not Started

Exercise:

```text
For BookMyShow booking:
1. List valid booking states.
2. List valid transitions.
3. Where would Observer help?
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 9. Parking Lot Mini Design

Status: Not Started

Exercise:

```text
Design Parking Lot in 2-minute format.
Include:
1. assumptions
2. classes
3. relationships
4. services
5. patterns
6. edge case
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 10. BookMyShow Mini Design

Status: Not Started

Exercise:

```text
Design BookMyShow seat booking in 2-minute format.
Focus especially on preventing double booking.
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 11. Splitwise Mini Design

Status: Not Started

Exercise:

```text
Design Splitwise in 2-minute format.
Include equal, exact, and percentage split handling.
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

## Final LLD Checklist

Status: Not Started

Before approaching any LLD problem:

```text
1. Do not jump directly to classes.
2. Clarify scope first.
3. Mention assumptions.
4. Identify actors and use cases.
5. Identify core entities.
6. Define relationships.
7. Add services for business logic.
8. Use interfaces where behavior varies.
9. Mention useful patterns naturally.
10. Discuss state transitions.
11. Discuss edge cases.
12. Discuss concurrency if shared resources exist.
13. Explain one end-to-end flow.
14. Mention extensibility.
```

## Final Self-Rating

Before sprint: `3/10`

After sprint: `TODO`

Notes:

```text
TODO
```