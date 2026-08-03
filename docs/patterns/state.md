# State Pattern

## Core Idea

Use State when valid actions and transitions depend on an object's current lifecycle state.

## BookMyShow Example

```text
PENDING_PAYMENT → CONFIRMED → CANCELLED
       │
       ├→ PAYMENT_FAILED
       └→ EXPIRED
```

`PENDING_PAYMENT` can accept payment or be cancelled. `CONFIRMED` can deliver a ticket and may be cancelled under a cancellation policy. `PAYMENT_FAILED`, `EXPIRED`, and `CANCELLED` normally reject further payment attempts for that booking.

Use an enum and transition validation for a simple lifecycle. Introduce state classes such as `PendingPaymentState` and `ConfirmedState` only when state-specific behavior becomes substantial.

## Mini Exercise: Review

### My Answer

```text
States: Booking_progress, Booking_completed, Booking_failed
Transitions: ?
Observer: Post booking to trigger notifications, update analytics, etc.
```

### Review Notes

The Observer use case is correct. Booking states should state what is happening in the business lifecycle—especially payment and expiry—rather than generic progress/completion labels. A transition list tells us which state changes are allowed.

### Reference Answer

```text
States:
- PENDING_PAYMENT
- CONFIRMED
- PAYMENT_FAILED
- EXPIRED
- CANCELLED

Transitions:
- PENDING_PAYMENT → CONFIRMED: payment succeeds
- PENDING_PAYMENT → PAYMENT_FAILED: payment fails
- PENDING_PAYMENT → EXPIRED: payment time limit elapses
- PENDING_PAYMENT → CANCELLED: customer cancels
- CONFIRMED → CANCELLED: customer cancels within policy

Observer:
- Event: BookingConfirmedEvent
- Observers: EmailNotificationListener, Sms/PushNotificationListener,
  TicketGenerationListener, AnalyticsListener
```
