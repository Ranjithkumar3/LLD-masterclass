# SRP, OCP, and DIP

## Why This Matters

SOLID helps prevent a business-service class from becoming a rigid object that owns unrelated work and concrete implementation details.

## Core Idea

- **SRP:** one class has one clear responsibility and reason to change.
- **OCP:** add new behavior through new implementations instead of repeatedly modifying stable logic.
- **DIP:** high-level business logic depends on abstractions rather than concrete details.

## Simple Example

`BookingService` coordinates the flow. Seat reservation, pricing, payment, persistence, and notification each have their own focused collaborator.

## Common Mistakes

- Treating a class name alone as an OCP answer; explain what can be extended without modification.
- Depending directly on `UpiPayment` or `EmailNotificationSender` in a high-level service.
- Assuming every service must be an interface; introduce abstractions where variation, replacement, or test isolation needs them.

## Mini Exercise

A `BookingService` selects seats, calculates price, accepts payment, saves a booking, and sends a notification. Split responsibilities and identify SRP, OCP, and DIP improvements.

## My Answer

```text
BookingService - Save a Booking
PricingService - Calculates price
PaymentService - Accepts payment
NotificationService - Sends notification

SRP - All 4 classes
OCP - PricingStrategy, NotificationSender
DIP - PaymentMethod, PricingStrategy, SeatSelectionService, BookingRepo, NotificationSender
```

## Review Notes

- The responsibility split correctly identifies booking coordination, pricing, payment, and notification. Add seat selection/reservation and persistence as separate responsibilities.
- `PricingStrategy` and `NotificationSender` are useful OCP extension points, but OCP is the ability to add a new implementation without modifying the booking flow.
- The DIP list identifies appropriate collaborators. For DIP, high-level code should use abstractions such as `PaymentMethod`, `PricingStrategy`, `SeatSelectionService`, `BookingRepository`, and `NotificationSender`; the latter three must be interfaces/contracts when their implementations can vary.

## Improved Design Answer

```text
BookingService — coordinates the booking workflow.
SeatSelectionService — validates and reserves seats.
PricingStrategy — calculates the price.
PaymentMethod — processes payment.
BookingRepository — saves and retrieves bookings.
NotificationSender — sends the booking confirmation.

SRP: Each collaborator has one focused responsibility and reason to change.

OCP: Add a new pricing rule, payment option, or notification channel by adding a new strategy/implementation instead of changing BookingService.

DIP: BookingService depends on abstractions such as PricingStrategy, PaymentMethod, BookingRepository, and NotificationSender, not concrete UPI, database, email, or SMS classes.
```

## Cheat Sheet

```text
Too many jobs in one class? → SRP
New variant needs editing old if/else code? → OCP
Business service creates/uses concrete details directly? → DIP
```

## SRP, OCP, and DIP Decision Rule

Use these questions to identify the problem:

```text
Is one class selecting seats, taking payment, saving data, and notifying users?
→ SRP: split distinct responsibilities.

Would adding CardPayment require editing BookingService?
→ OCP: depend on a payment contract so a new implementation can be added.

Does BookingService directly create or depend on UpiPayment?
→ DIP: depend on PaymentMethod, not the concrete UpiPayment detail.
```

Dependency injection is a delivery technique, not DIP by itself:

```text
BookingService(UpiPayment payment)       → injected, but still concrete: not DIP
BookingService(PaymentMethod payment)    → injected abstraction: supports DIP
```

The abstraction used for DIP can be an interface or an abstract class. Interfaces are commonly chosen when behavior varies; abstract classes fit closely related implementations with genuine shared code or state.

## Related Topics

- Strategy pattern
- Interface vs abstract class
- Dependency injection
