# LLD Approach Framework

## Why This Matters

Starting with requirements and use cases prevents premature class design.

## Core Idea

Use this order: clarify scope, identify actors and use cases, identify entities and relationships, introduce services, then discuss state, edge cases, concurrency, and extension points.

## Key Terminology

- **Entity:** an object with identity and lifecycle, such as `Vehicle` or `Ticket`.
- **Use case:** a user-visible action the system supports, such as parking a vehicle.
- **Extension:** a likely future capability that should not make today’s design rigid.

## Simple Example

For a parking lot, determine vehicle support and slot rules before deciding how `Vehicle` and `ParkingSlot` should interact.

## Common Mistakes

- Naming classes before clarifying the scope.
- Treating a behavior, such as pricing calculation, as a core entity without deciding its responsibility.
- Omitting the end-to-end exit and payment flow.

## Mini Exercise

Topic: LLD Approach Framework

Goal: Apply the first design steps to a Parking Lot.

Prompt: Write five clarifying questions, five core entities, three use cases, and two future extensions.

## My Answer

### Clarifying Questions

1. What vehicle types are allowed?
2. Does each vehicle type require a dedicated slot, or can any vehicle use any slot?
3. What is the pricing strategy?
4. How many floors and slots per floor exist for each vehicle type?
5. Should customer details, parked vehicles, and parking history be stored?

### Core Entities

1. ParkingLot
2. ParkingFloor
3. ParkingSlot
4. Ticket
5. Pricing
6. Vehicle

### Main Use Cases

1. Park a vehicle and provide a ticket ID.
2. Unpark a vehicle and calculate charges from its ticket.

### Future Extensions

1. Offers and discounts.

## Review Notes

- The clarifying questions are specific and expose the important capacity, allocation, pricing, and history decisions.
- `ParkingLot`, `ParkingFloor`, `ParkingSlot`, `Ticket`, and `Vehicle` are strong core entities.
- `Pricing` is better framed as a `PricingStrategy` (varying behavior) or a `FeeCalculator` service than an entity, unless the domain has a persistent pricing-rule record with its own identity.
- The unparking flow should close or mark the ticket as paid/completed; “expire” is ambiguous because expiry can also mean a ticket became invalid.
- One more main use case, such as checking availability, makes the scope clearer.
- Offers and discounts are a valid future extension; reservation or payment-provider support are other plausible examples.

## Improved Design Answer

### Refined Core Entities

1. `ParkingLot`
2. `ParkingFloor`
3. `ParkingSlot`
4. `Vehicle`
5. `ParkingTicket`

`PricingStrategy` is an interface/service used to calculate fees, rather than a core entity in the first version.

### Refined Main Use Cases

1. Find an eligible available slot, park the vehicle, and issue a ticket.
2. Retrieve a ticket at exit, calculate the fee, take payment, and close the parking session.
3. View available slots by vehicle type or floor.

### Additional Future Extensions

1. Reservation and pre-booked slots.
2. Multiple payment providers or membership discounts.

## Cheat Sheet

1. Clarify scope.
2. Identify actors and use cases.
3. Identify core entities and relationships.
4. Keep variable behavior behind an interface or service.
5. Name one edge case and one future extension.

## Related Topics

- Entity vs value object
- Class relationships
- Strategy pattern
