# Parking Lot

## Scope and Assumptions

- The lot has a variable number of floors.
- Each floor has a fixed number of slots for each vehicle type.
- Pricing is fixed per vehicle type per hour.
- A vehicle can park only in an available compatible slot.
- A ticket is issued at entry and presented at exit.

## Core Entities

- `ParkingLot`
- `ParkingFloor`
- `ParkingSlot`
- `Vehicle`
- `ParkingTicket`

## Relationships

- `ParkingLot` contains `ParkingFloor` objects.
- `ParkingFloor` contains `ParkingSlot` objects.
- `ParkingSlot` supports one or more `VehicleType` values and holds at most one `Vehicle` while occupied.
- `ParkingTicket` refers to the parked `Vehicle`, assigned `ParkingSlot`, and entry/exit times.

## Services

- `ParkingLotService` coordinates entry and exit.
- `SlotAllocationService` finds and reserves an eligible slot.
- `PricingStrategy` calculates the parking fee.
- `PaymentService` accepts payment at exit.

## Patterns

- **Strategy:** `PricingStrategy` supports future changes such as vehicle-based or time-based prices. With genuinely fixed pricing, a simple calculator is also sufficient for the first version.
- **Factory:** optional for creating an appropriate `Vehicle` or `ParkingSlot` subtype from a vehicle/slot type.

## Edge Case

- Two vehicles attempt to take the final eligible slot at the same time. Slot allocation must reserve the slot atomically so only one ticket is issued for it.

## Mini Exercise

Design Parking Lot in a two-minute format: assumptions, classes, relationships, services, patterns, and an edge case.

## My Answer

```text
Assumptions:
- Variable number of floors but fixed number of slots per floor per vehicle type.
- Fixed pricing per vehicle per hour.
- Park a vehicle only if a slot in any floor for its vehicle type is free.
- Provide a ticket that is returned at exit.

Classes:
- ParkingLot, ParkingFloor, ParkingSlot, Vehicle, ParkingTicket

Relationships:
- ParkingLot has ParkingFloors.
- ParkingFloor has ParkingSlots.
- ParkingSlot has a VehicleType.

Services:
- ParkingLotService, PaymentService, PricingStrategy
```

## Review Notes

- The assumptions establish capacity, compatibility, pricing, and the entry/exit ticket flow well.
- The core entities are correct.
- Add the active relationships: a slot temporarily holds a vehicle; a ticket links the vehicle, slot, and parking times.
- Add `SlotAllocationService` to isolate the search-and-reservation responsibility.
- `PricingStrategy` is a useful extension point, although a simple fee calculator is enough while the rate is truly fixed.
- The missing edge case should address the final available slot being requested concurrently.

## Improved Design Answer

```text
Assumptions:
- Support bike, car, and truck; each needs a compatible slot.
- Charge hourly by vehicle type.
- No reservations in version one.
- Issue a ticket at entry; use it to calculate payment at exit.

Classes:
- ParkingLot, ParkingFloor, ParkingSlot, Vehicle, ParkingTicket

Relationships:
- ParkingLot → ParkingFloor → ParkingSlot
- ParkingSlot holds one Vehicle when occupied.
- ParkingTicket links Vehicle, ParkingSlot, entry time, and exit time.

Services:
- ParkingLotService: coordinates park/unpark.
- SlotAllocationService: finds and reserves a compatible slot.
- PricingStrategy/FeeCalculator: calculates parking fee.
- PaymentService: accepts payment and closes the ticket.

Patterns:
- Strategy for variable pricing rules; optional Factory for type-specific vehicle/slot creation.

Edge case:
- Concurrent requests for the final compatible slot must result in one successful reservation and ticket only.
```
