# Factory Pattern

## Core Distinction

```text
Factory: chooses/creates the appropriate object.
Strategy: executes one of several interchangeable algorithms.
```

Example: `SplitStrategyFactory` receives `PERCENTAGE` and returns `PercentageSplitStrategy`; that strategy then calculates percentage-based shares.

## Mini Exercise: Factory Usage

### My Answer

```text
Parking Lot: Factory for various payment methods.
Notification System: Factory for different notification systems.
BookMyShow: Both; Factory for sending booking information by phone or email.
```

### Review Notes

All Factory choices are valid. In Parking Lot, Factory can also select a vehicle, parking-slot, or pricing implementation. For BookMyShow, the Builder should target the `Booking` object rather than the `User` because the booking is the complex object with many optional/derived details.

### Reference Answer

```text
Parking Lot: Factory — choose a Vehicle, ParkingSlot, PaymentMethod, or PricingStrategy implementation based on type.

Notification System: Factory — choose EmailSender, SmsSender, or PushSender from the requested channel.

BookMyShow Booking: Both — a NotificationFactory chooses the confirmation channel; a Booking.Builder constructs a Booking with required user/show/seats and optional coupon, payment, notes, or preferences.
```
