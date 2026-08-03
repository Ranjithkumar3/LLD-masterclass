# Association, Aggregation, and Composition

## Why This Matters

Relationship choice makes ownership, lifecycle, and responsibilities clear in an object model.

## Core Idea

- **Association:** objects know or use each other, but neither owns the other.
- **Aggregation:** a weak whole-part relationship; the part can exist independently.
- **Composition:** a strong whole-part relationship; the part belongs to and shares the whole's lifecycle.

## Simple Example

A user creates a booking, so `User` and `Booking` are associated. A theatre groups screens, so `Theatre` aggregates `Screen`. A screen owns its seat layout, so `Screen` composes `Seat`.

## Common Mistakes

- Calling every has-a relationship composition.
- Deciding from a database foreign key instead of the domain lifecycle.
- Treating aggregation and composition as absolute facts when the system’s lifecycle assumptions differ.

## Mini Exercise

Classify BookMyShow relationships as association, aggregation, or composition.

## My Answer

1. Theatre — Screen: Aggregation — weak whole-part relationship.
2. Screen — Seat: Composition — strong whole-part relationship.
3. Movie — Show: Association — both can be independent.
4. User — Booking: Association — both can be independent.
5. Booking — Payment: Composition — every booking should have a payment.

## Review Notes

All classifications are correct for the stated model. For the final relationship, the stronger reason is lifecycle: the payment record belongs to the booking in this simplified model and is created, retained, or removed as part of that booking. A booking can begin in a pending-payment state, so “every booking should have a payment” is not always true.

## Improved Design Answer

| Relationship | Classification | Reason |
|---|---|---|
| Theatre — Screen | Aggregation | A theatre groups screens, while a screen can be modelled independently or reassigned. |
| Screen — Seat | Composition | A seat layout exists only within its screen. |
| Movie — Show | Association | A show refers to a movie; each has an independent lifecycle. |
| User — Booking | Association | A user makes bookings, but neither object owns the other's lifecycle. |
| Booking — Payment | Composition | In this simplified model, payment is owned by and tied to the booking lifecycle. |

## Cheat Sheet

```text
uses/knows → Association
weak whole-part → Aggregation
strong ownership and shared lifecycle → Composition
```

## Relationship Decision Rule

Use these sentences as a quick distinction:

```text
User makes a Booking             → association: they are connected but live independently
Theatre has Screens              → aggregation: a weak whole-part relationship
Screen owns its Seats            → composition: strong ownership and shared lifecycle
```

Ask these questions in order:

```text
Do the objects simply know or use each other? → Association
Is one a whole made of parts that can still exist independently? → Aggregation
Does the whole create/control a part that has no meaning without it? → Composition
```

Composition describes domain ownership, not necessarily physical database deletion. Retained audit/history data can outlive the domain object that originally owned it.

## Related Topics

- OOP modeling
- Interface vs abstract class
- State pattern
