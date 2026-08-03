# Observer Pattern

## Core Idea

Publish an event when something meaningful happens, then let independent listeners react without the publisher knowing their concrete implementations.

## BookMyShow Example

```text
BookingService publishes BookingConfirmedEvent
  → EmailNotificationListener
  → SmsNotificationListener
  → TicketGenerationListener
  → AnalyticsListener
```

Use Observer when one event has multiple independent reactions. In production, event handling commonly needs retry and idempotency so failed or duplicate deliveries do not create duplicate notifications, tickets, or refunds.
