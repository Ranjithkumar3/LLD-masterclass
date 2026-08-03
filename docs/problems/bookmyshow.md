# BookMyShow

## Scope and Assumptions

- Customers can register/login, browse movies, choose a theatre and show, select seats, pay, and receive a ticket.
- Shows have fixed times and screens have a fixed physical seat layout.
- Pricing is fixed for the first version.
- A seat's availability is specific to a show, not global.

## Core Entities

- `Customer`
- `Movie`
- `Theatre`
- `Screen`
- `Seat`
- `Show`
- `ShowSeat`
- `Booking`
- `Payment`
- `Ticket`

## Relationships

- `Theatre` aggregates `Screen` objects; a `Screen` composes its physical `Seat` layout.
- `Show` links one `Movie`, one `Screen`, and a start time.
- `ShowSeat` links a physical `Seat` to a specific `Show` and owns availability state.
- `Customer` makes `Booking` objects.
- `Booking` contains selected `ShowSeat` objects and refers to a `Payment`; a confirmed booking generates a `Ticket`.

## Services

- `BookingService` coordinates the booking lifecycle.
- `SeatReservationService` atomically holds and confirms show seats.
- `PricingService` calculates the amount.
- `PaymentService` takes payment.
- `NotificationService` sends booking confirmation.
- `CancellationService` applies cancellation/refund policy.

## Booking Flow

1. Customer selects a movie, theatre, show, and available `ShowSeat` objects.
2. `SeatReservationService` atomically changes the requested show seats from `AVAILABLE` to `HELD` with a short expiry time.
3. `BookingService` creates a pending-payment booking and asks `PaymentService` to collect payment.
4. On successful payment, the held seats become `BOOKED`, the booking becomes confirmed, and a ticket is generated.
5. On failed payment, cancellation, or hold expiry, the seats return to `AVAILABLE`.

## Double-Booking Prevention

Do not hold a database lock open while the customer pays. Instead, atomically reserve the `ShowSeat` only if it is still `AVAILABLE` (using a conditional update/transaction or optimistic version check), mark it `HELD`, and assign an expiry. Only the customer owning that hold can confirm it. This ensures simultaneous requests result in a single successful hold.

## Patterns

- **State:** booking and show-seat lifecycles (`PENDING_PAYMENT`, `CONFIRMED`, `CANCELLED`; `AVAILABLE`, `HELD`, `BOOKED`).
- **Observer:** publish `BookingConfirmedEvent` for notifications, ticket delivery, and analytics.
- **Strategy:** optional pricing/cancellation variations in a future version.

## Edge Case

- Payment succeeds just after a hold expires. Make confirmation idempotent and confirm only a still-valid hold; otherwise release/refund safely according to payment reconciliation rules.

## Mini Exercise

Design BookMyShow seat booking in two-minute format, focusing on double-booking prevention.

## My Answer

```text
Assumptions: register/login; select movie, theatre/show, then available seats; pay and generate ticket; fixed pricing/show timings/show count.

Classes: Movie, Theatre, Screen, Seat, Customer, Ticket, Booking.

Relationships: Theatre has screens; screen has seats; Movie is associated with screen/theatre; Customer has a Booking; Customer gets a ticket after booking; Seat is booked or vacant.

Services: BookingService, PricingService, NotificationService, CancellationService, RegistrationService.

Double booking prevention: lock the seat until payment succeeds; otherwise release the lock.
```

## Review Notes

- The high-level user journey, venue classes, and services are a good start.
- Add `Show`, `ShowSeat`, and `Payment`. A movie plays through shows, and availability belongs to a seat for a particular show, not the physical seat globally.
- A temporary hold is the correct double-booking idea. Make the hold atomic and time-limited; do not keep a database lock open for the entire external payment call.

## Improved Design Answer

The sections above form the reference two-minute design. The central concurrency rule is:

```text
Atomically change ShowSeat from AVAILABLE to HELD with an expiry.
On valid payment, change HELD to BOOKED.
On failure or expiry, release HELD back to AVAILABLE.
```
