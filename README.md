# LLD Masterclass/Lab

A practical Low-Level Design knowledge base for learning, revising, and practicing object-oriented software design.

This repo starts as a focused 3-hour LLD sprint and grows into a complete masterclass covering fundamentals, design principles, patterns, modeling techniques, and practical system design exercises.

## What Is LLD?

Low-Level Design is the process of converting requirements into clean, maintainable, extensible code-level design.

It focuses on:

- classes
- objects
- interfaces
- relationships
- responsibilities
- design patterns
- state transitions
- business rules
- extensibility
- maintainability

In simple words:

```text
HLD explains how the system works at architecture level.
LLD explains how the system works at code design level.
```

## Why This Repo Exists

LLD can feel scattered because it combines many things:

- OOP
- SOLID
- UML
- design patterns
- domain modeling
- Java design
- services and repositories
- concurrency decisions
- problem-solving structure

This repo brings those pieces together in one clean, practical learning path.

## Learning Path

### Phase 1: 3-Hour Sprint

A fast, high-impact revision path.

| Module | Topic | File |
|---|---|---|
| 1 | LLD approach framework | [00-roadmap.md](docs/00-roadmap.md) |
| 2 | LLD fundamentals | [01-lld-fundamentals.md](docs/01-lld-fundamentals.md) |
| 3 | OOP modeling | [02-oop-modeling.md](docs/02-oop-modeling.md) |
| 4 | SOLID principles | [03-solid-principles.md](docs/03-solid-principles.md) |
| 5 | Class relationships | [04-class-relationships.md](docs/04-class-relationships.md) |
| 6 | Design patterns | [06-design-patterns.md](docs/06-design-patterns.md) |
| 7 | Concurrency in LLD | [07-concurrency-in-lld.md](docs/07-concurrency-in-lld.md) |
| 8 | Final cheat sheet | [10-cheatsheet.md](docs/10-cheatsheet.md) |

### Phase 2: Core Masterclass

A deeper, structured study path.

| Area | What It Covers |
|---|---|
| Fundamentals | LLD meaning, goals, terminology, design flow |
| OOP Modeling | entities, value objects, services, interfaces |
| SOLID | SRP, OCP, LSP, ISP, DIP |
| Relationships | association, aggregation, composition, inheritance |
| UML | class diagrams and sequence diagrams |
| Patterns | Strategy, Factory, Builder, State, Observer, and more |
| Concurrency | locking, race conditions, idempotency, state safety |
| APIs and Services | controllers, services, repositories, DTOs |
| Problems | Parking Lot, BookMyShow, Splitwise, Rate Limiter, and more |

## Must-Know LLD Terms

### Entity

An object with identity and lifecycle.

Example:

```text
User
Booking
Expense
Vehicle
```

Even if two users have the same name, they are different users because they have different identities.

### Value Object

An object identified by its values, not identity.

Example:

```text
Money
Address
DateRange
SeatNumber
```

Two `Money(100, INR)` objects can be considered equal if their values are the same.

### DTO

A Data Transfer Object used to move data between layers or across APIs.

Example:

```text
CreateBookingRequest
UserResponse
ExpenseRequest
```

DTOs should not contain core business logic.

### Service

A class that contains business logic or coordinates use cases.

Example:

```text
BookingService
PaymentService
ExpenseService
ParkingLotService
```

### Repository

A class responsible for persistence operations.

Example:

```text
UserRepository
BookingRepository
ExpenseRepository
```

Repositories should not contain business rules.

### Interface

A contract for behavior.

Use it when multiple implementations are possible.

Example:

```text
PaymentMethod
SplitStrategy
NotificationSender
FeeCalculator
```

### Abstract Class

A base class with shared state or partial behavior.

Use it when related classes share common implementation.

### Composition

Building objects by combining other objects.

Example:

```text
Car has an Engine
ParkingLot has Floors
Booking has Payment
```

Prefer composition when inheritance would make the design rigid.

## Core LLD Thinking Framework

Use this structure for any LLD problem:

```text
1. Clarify the scope.
2. Identify actors and main use cases.
3. Define core entities.
4. Define relationships between entities.
5. Introduce services for business logic.
6. Use interfaces where behavior can vary.
7. Discuss state transitions and edge cases.
8. Discuss concurrency and extensibility.
```

## SOLID Cheat Sheet

| Principle | Meaning | Simple Signal |
|---|---|---|
| SRP | One class should have one reason to change | Class is doing too many jobs |
| OCP | Open for extension, closed for modification | New behavior should not break old code |
| LSP | Subclasses should safely replace parent classes | Inheritance should not surprise callers |
| ISP | Prefer small focused interfaces | Classes should not implement unused methods |
| DIP | Depend on abstractions, not concrete classes | Services should depend on interfaces |

## Design Pattern Cheat Sheet

| Pattern | Use When | Example |
|---|---|---|
| Strategy | Behavior or algorithm varies | Split calculation, pricing, payment |
| Factory | Object creation depends on type | Create vehicle, notification sender |
| Builder | Object creation has many optional fields | Booking, Order, Invoice |
| State | Behavior changes based on state | Booking lifecycle, vending machine |
| Observer | Others need to react to an event | Notify user after booking |
| Chain of Responsibility | Request passes through handlers | Logger levels, approval flow |
| Decorator | Add behavior dynamically | Add-ons, toppings, features |
| Adapter | Make incompatible interfaces work together | External payment provider |
| Singleton | Exactly one shared instance is needed | App config, registry |

## Class Relationship Cheat Sheet

| Relationship | Meaning | Example |
|---|---|---|
| Association | One class uses or knows another | User places Booking |
| Aggregation | Whole-part, but part can exist independently | Theatre has Screens |
| Composition | Strong ownership, part depends on whole | Screen has Seats |
| Inheritance | Is-a relationship | Car is a Vehicle |
| Implementation | Class follows interface contract | UpiPayment implements PaymentMethod |

## Problem Catalog

| Problem | Focus Area | File |
|---|---|---|
| Parking Lot | OOP, SOLID, Strategy, Factory | [parking-lot.md](docs/problems/parking-lot.md) |
| BookMyShow | State, concurrency, locking | [bookmyshow.md](docs/problems/bookmyshow.md) |
| Splitwise | Domain modeling, Strategy | [splitwise.md](docs/problems/splitwise.md) |
| Vending Machine | State pattern | [vending-machine.md](docs/problems/vending-machine.md) |
| Rate Limiter | Strategy, concurrency | [rate-limiter.md](docs/problems/rate-limiter.md) |
| Logger | Chain of Responsibility | [logger.md](docs/problems/logger.md) |
| Elevator System | State, scheduling, queues | [elevator-system.md](docs/problems/elevator-system.md) |
| Cache | Eviction strategy, data structures | [cache.md](docs/problems/cache.md) |

## Recommended Repo Structure

```text
lld-masterclass-lab/
  README.md
  AGENTS.md
  PROGRESS.md

  docs/
    00-roadmap.md
    01-lld-fundamentals.md
    02-oop-modeling.md
    03-solid-principles.md
    04-class-relationships.md
    05-uml-basics.md
    06-design-patterns.md
    07-concurrency-in-lld.md
    08-api-service-design.md
    09-common-mistakes.md
    10-cheatsheet.md

  docs/patterns/
    strategy.md
    factory.md
    builder.md
    state.md
    observer.md
    chain-of-responsibility.md
    decorator.md
    adapter.md
    singleton.md

  docs/problems/
    parking-lot.md
    bookmyshow.md
    splitwise.md
    vending-machine.md
    rate-limiter.md
    logger.md
    elevator-system.md
    cache.md

  docs/templates/
    problem-template.md
    topic-template.md
    design-review-template.md

  src/main/java/
    com/example/lld/

  src/test/java/
    com/example/lld/
```

## How To Study

For each topic:

```text
1. Read the concept.
2. Understand the terminology.
3. Do the mini exercise.
4. Write your own answer.
5. Review and improve it.
6. Add the final version to the notes.
```

For each problem:

```text
1. Clarify requirements.
2. Identify actors.
3. Identify entities.
4. Define relationships.
5. Add services.
6. Apply useful patterns.
7. Discuss state and edge cases.
8. Discuss concurrency if needed.
9. Explain one end-to-end flow.
```

## Quality Goals

This repo should be:

- simple enough to revise quickly
- deep enough to explain design choices
- practical enough to apply to real problems
- clean enough to share publicly
- structured enough to grow over time

## Current Status

The repo begins with a 3-hour sprint.

Progress is tracked in [PROGRESS.md](PROGRESS.md).