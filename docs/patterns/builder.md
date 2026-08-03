# Builder Pattern

## Core Idea

Use a Builder to construct one object with many fields, particularly optional fields, in a readable and valid way.

```text
Booking.Builder
  required: user, show, selected seats
  optional: coupon, payment details, special request, notification preference
  build() validates and returns the Booking
```

## Mini Exercise Reference

For BookMyShow, use a Builder for `Booking`, not necessarily for `User`. The Booking has several required and optional construction details and can benefit from validation at build time.
