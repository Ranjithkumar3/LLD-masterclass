# PROGRESS.md

# LLD Masterclass/Lab Progress

## Goal

Build a public, long-term Low-Level Design knowledge base.

The repo starts with a 3-hour focused sprint and later expands into a complete LLD masterclass.

Target outcome:

```text
I should be able to approach LLD problems with a clear structure, correct object modeling, useful design patterns, and practical design tradeoffs.
```

## Current Level

Initial diagnostic rating: `3/10`

Current strengths:

- understands basic idea of classes/entities
- knows repository communicates with DB
- understands SRP at a basic level
- can identify some obvious entities in Parking Lot
- knows concurrency issues may require locking

Current gaps:

- entity vs value object
- interface vs abstract class
- association vs aggregation vs composition
- Open/Closed Principle
- Strategy, Factory, State, Observer
- how to start an LLD problem
- how to design class relationships
- how to explain concurrency beyond “use locks”

## Phase 1: 3-Hour Sprint

| Time | Topic | Status |
|---|---|---|
| 00:00 - 00:15 | LLD approach framework | Completed |
| 00:15 - 00:30 | Entity, value object, DTO, repository | Completed |
| 00:30 - 00:45 | Interface vs abstract class, composition | Completed |
| 00:45 - 01:00 | Association, aggregation, composition | Completed |
| 01:00 - 01:15 | SRP, OCP, DIP | Completed |
| 01:15 - 01:30 | Strategy pattern | Completed |
| 01:30 - 01:45 | Factory and Builder patterns | Completed |
| 01:45 - 02:00 | State and Observer patterns | Completed |
| 02:00 - 02:20 | Parking Lot mini design | Completed |
| 02:20 - 02:40 | BookMyShow mini design | Not Started |
| 02:40 - 03:00 | Splitwise mini design and final checklist | Not Started |

## Phase 2: Core Masterclass Expansion

| Module | Topic | Status |
|---|---|---|
| 1 | LLD fundamentals | Not Started |
| 2 | OOP modeling | Not Started |
| 3 | SOLID principles | Not Started |
| 4 | Class relationships | Not Started |
| 5 | UML basics | Not Started |
| 6 | Design patterns | Not Started |
| 7 | Concurrency in LLD | Not Started |
| 8 | API and service design | Not Started |
| 9 | Common design mistakes | Not Started |
| 10 | Full cheat sheet | Not Started |

## Phase 3: Pattern Deep Dives

| Pattern | Status |
|---|---|
| Strategy | Not Started |
| Factory | Not Started |
| Builder | Not Started |
| State | Not Started |
| Observer | Not Started |
| Chain of Responsibility | Not Started |
| Decorator | Not Started |
| Adapter | Not Started |
| Singleton | Not Started |

## Phase 4: Problem Catalog

| Problem | Status |
|---|---|
| Parking Lot | Not Started |
| BookMyShow | Not Started |
| Splitwise | Not Started |
| Vending Machine | Not Started |
| Rate Limiter | Not Started |
| Logger | Not Started |
| Elevator System | Not Started |
| Cache | Not Started |

## Sprint Topic Checklist

### 1. LLD Approach Framework

Status: Completed

Exercise:

```text
For Parking Lot, write:
1. 5 clarifying questions
2. 5 core entities
3. 3 main use cases
4. 2 future extensions
```

My Answer:

```text
Clarifying questions:
1. What are the types of vehicles allowed?
2. Does each vehicle type require a dedicated slot, or can any vehicle park in any slot?
3. What is the pricing strategy?
4. How many floors and slots per floor exist by vehicle type?
5. Should customer details, parked vehicles, and parking history be stored?

Core entities:
ParkingLot, ParkingFloor, ParkingSlot, Ticket, Pricing, Vehicle

Main use cases:
1. Park a vehicle and provide a ticket ID.
2. Unpark a vehicle, calculate charges using the ticket, and close the ticket.

Future extensions:
Offers and discounts.
```

Review:

```text
Strong requirement questions and core domain entities. Pricing is usually a strategy or service, not an entity. Add availability as a third use case and describe unparking as closing a paid/completed ticket rather than expiring it.
```

Improved Design Answer:

```text
Core entities: ParkingLot, ParkingFloor, ParkingSlot, Vehicle, ParkingTicket.
Variable behavior: PricingStrategy/FeeCalculator.
Main use cases: park and issue ticket; calculate, pay, and close ticket at exit; view availability.
Future extensions: reservations; multiple payment providers or membership discounts.
```

### 2. Entity, Value Object, DTO, Repository

Status: Completed

Exercise:

```text
For Splitwise, classify:
User
Group
Expense
Money
Split
Balance
ExpenseRequest
```

My Answer:

```text
User - Entity - has a unique identity
Group - Entity - has a unique identity
Expense - Value object - can be used to store data values
Money - Value object - kind of an enum
Split - Value object - does not require a unique identity
Balance - DTO - can be calculated from repository and entity
ExpenseRequest - Repository - fetched from DB
```

Review:

```text
User, Group, and Split were correctly classified. Expense is an entity because it has identity and history. Money is a value object but not an enum. Balance is usually a value object/read-model value. ExpenseRequest is a DTO; a repository is a class such as ExpenseRepository that persists expenses.
```

Improved Design Answer:

```text
Entities: User, Group, Expense.
Value objects: Money, Split, Balance.
DTO: ExpenseRequest.
Repository examples (not listed): UserRepository, GroupRepository, ExpenseRepository.
```

### 3. Interface vs Abstract Class And Composition

Status: Completed

Exercise:

```text
For payment methods like UPI, Card, Wallet, Cash:
1. Would you use interface or abstract class?
2. Why?
3. Where would composition help?
```

My Answer:

```text
1. Interface. They all pay differently and share only the behavior.
2. Add an abstract class called OnlinePayment. UpiPayment, CardPayment, and WalletPayment extend it because they share transactionId and createReceipt() logic. CashPayment does not extend it.
3. UpiPayment has a UpiGateway. CardPayment has a CardValidator.
```

Review:

```text
Correct. PaymentMethod is the common interface. OnlinePayment is an optional abstract class for shared online-payment state and behavior. Both composition examples are clear has-a relationships.
```

Improved Design Answer:

```text
PaymentMethod: interface for pay(amount).
OnlinePayment: abstract class only when online payment types share transactionId and receipt logic.
Composition: UpiPayment has UpiGateway; CardPayment has CardValidator.
```

### 4. Class Relationships

Status: Completed

Exercise:

```text
Classify these BookMyShow relationships:
1. Theatre - Screen
2. Screen - Seat
3. Movie - Show
4. User - Booking
5. Booking - Payment
```

My Answer:

```text
1. Theatre - Screen: Aggregation - whole-part relationship but weak.
2. Screen - Seat: Composition - strong whole-part relationship.
3. Movie - Show: Association - both can be independent.
4. User - Booking: Association - both can be independent.
5. Booking - Payment: Composition - every booking should have a payment.
```

Review:

```text
All classifications are correct. For Booking-Payment, use lifecycle as the reason: payment belongs to the booking in this simplified model. A booking may be pending payment, so payment is not necessarily present at creation.
```

Improved Design Answer:

```text
Theatre-Screen: aggregation; Screen-Seat: composition; Movie-Show: association; User-Booking: association; Booking-Payment: composition in the simplified model.
```

### 5. SOLID

Status: Completed

Exercise:

```text
A BookingService selects seats, calculates price, accepts payment, saves booking, and sends notification.

Split responsibilities into better classes and mention which SOLID principles improve.
```

My Answer:

```text
BookingService - saves a booking
PricingService - calculates price
PaymentService - accepts payment
NotificationService - sends notification

SRP - all four classes
OCP - PricingStrategy, NotificationSender
DIP - PaymentMethod, PricingStrategy, SeatSelectionService, BookingRepo, NotificationSender
```

Review:

```text
Good responsibility split. Add seat reservation and repository responsibilities. OCP means adding new implementations without modifying BookingService. DIP requires BookingService to depend on abstractions; services/repositories on the list need contracts/interfaces when their implementation may vary.
```

Improved Design Answer:

```text
BookingService coordinates; SeatSelectionService reserves seats; PricingStrategy calculates price; PaymentMethod processes payment; BookingRepository persists bookings; NotificationSender confirms the booking.

SRP: one focused responsibility each.
OCP: add new pricing/payment/notification implementations without editing the coordinator.
DIP: BookingService depends on PricingStrategy, PaymentMethod, BookingRepository, and NotificationSender abstractions.
```

### 6. Strategy Pattern

Status: Completed

Exercise:

```text
For Splitwise split types:
EqualSplit
ExactSplit
PercentageSplit

Design the strategy interface name and implementations.
No full code required.
```

My Answer:

```text
Interface: SplitStrategy
Method: splitExpense()
Implementations: EqualSplitStrategy, ExactSplitStrategy, PercentageSplitStrategy
Used by: Main service that splits an expense based on split type
```

Review:

```text
Correct pattern structure. Name the caller ExpenseService or SplitService. Refine the method to calculate allocations because saving the expense is the service's responsibility, not the strategy's.
```

Improved Design Answer:

```text
Interface: SplitStrategy
Method: calculateSplits(totalAmount, participants)
Implementations: EqualSplitStrategy, ExactSplitStrategy, PercentageSplitStrategy
Used by: ExpenseService/SplitService
```

### 7. Factory And Builder Patterns

Status: Completed

Exercise:

```text
Where would you use Factory and Builder in these systems?
1. Parking Lot
2. Notification System
3. BookMyShow Booking
```

My Answer:

```text
Parking Lot: Factory for various payment methods.
Notification System: Factory for different notification systems.
BookMyShow: Both; Factory for booking information sent by phone/email, Builder for building a user with optional fields.
```

Review:

```text
The Factory choices are valid. For BookMyShow, use the Builder for the complex Booking object rather than User; booking can have required and optional details.
```

Improved Design Answer:

```text
Parking Lot: Factory for vehicle, slot, payment, or pricing implementations by type.
Notification System: Factory for EmailSender, SmsSender, or PushSender by channel.
BookMyShow: NotificationFactory chooses a sender; Booking.Builder constructs a Booking with required user/show/seats and optional coupon, payment, notes, or preferences.
```

### 8. State And Observer Patterns

Status: Completed

Exercise:

```text
For BookMyShow booking:
1. List valid booking states.
2. List valid transitions.
3. Where would Observer help?
```

My Answer:

```text
States: Booking_progress, Booking_completed, Booking_failed
Transitions: not answered
Observer: post booking to trigger notifications, update analytics, etc.
```

Review:

```text
Observer use case is correct. Use business lifecycle states such as PENDING_PAYMENT and CONFIRMED rather than generic progress/completion labels. Explicitly list allowed transitions.
```

Improved Design Answer:

```text
States: PENDING_PAYMENT, CONFIRMED, PAYMENT_FAILED, EXPIRED, CANCELLED.
Transitions: pending payment can become confirmed, payment failed, expired, or cancelled; confirmed can become cancelled under policy.
Observer: publish BookingConfirmedEvent to email/SMS/push notification, ticket generation, and analytics listeners.
```

### 9. Parking Lot Mini Design

Status: Completed

Exercise:

```text
Design Parking Lot in 2-minute format.
Include:
1. assumptions
2. classes
3. relationships
4. services
5. patterns
6. edge case
```

My Answer:

```text
Assumptions: variable number of floors; fixed slots per floor by vehicle type; fixed vehicle-type hourly pricing; park only when a matching slot is free; issue a ticket and present it at exit.
Classes: ParkingLot, ParkingFloor, ParkingSlot, Vehicle, ParkingTicket.
Relationships: ParkingLot has ParkingFloors; ParkingFloor has ParkingSlots; ParkingSlot has a VehicleType.
Services: ParkingLotService, PaymentService, PricingStrategy.
Edge case: not answered.
```

Review:

```text
Strong assumptions and core entities. Add a ticket's links to vehicle, slot, and parking time; add a SlotAllocationService; and cover concurrent requests for the final available compatible slot.
```

Improved Design Answer:

```text
ParkingLot contains floors, floors contain slots, occupied slots hold vehicles, and a ticket links vehicle, slot, entry time, and exit time. ParkingLotService coordinates the flow; SlotAllocationService reserves a compatible slot; PricingStrategy/FeeCalculator calculates fees; PaymentService closes payment. Edge case: atomically reserve the final compatible slot to prevent double allocation.
```

### 10. BookMyShow Mini Design

Status: Not Started

Exercise:

```text
Design BookMyShow seat booking in 2-minute format.
Focus especially on preventing double booking.
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

### 11. Splitwise Mini Design

Status: Not Started

Exercise:

```text
Design Splitwise in 2-minute format.
Include equal, exact, and percentage split handling.
```

My Answer:

```text
TODO
```

Review:

```text
TODO
```

Improved Design Answer:

```text
TODO
```

## Final LLD Checklist

Status: Not Started

Before approaching any LLD problem:

```text
1. Do not jump directly to classes.
2. Clarify scope first.
3. Mention assumptions.
4. Identify actors and use cases.
5. Identify core entities.
6. Define relationships.
7. Add services for business logic.
8. Use interfaces where behavior varies.
9. Mention useful patterns naturally.
10. Discuss state transitions.
11. Discuss edge cases.
12. Discuss concurrency if shared resources exist.
13. Explain one end-to-end flow.
14. Mention extensibility.
```

## Final Self-Rating

Before sprint: `3/10`

After sprint: `TODO`

Notes:

```text
TODO
```
