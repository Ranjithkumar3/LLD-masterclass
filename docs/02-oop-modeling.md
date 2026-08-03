# Entity, Value Object, DTO, and Repository

## Why This Matters

Separating identity, domain values, transport data, and persistence responsibilities keeps the model easier to change and test.

## Core Idea

- An **entity** has identity and lifecycle.
- A **value object** is defined by its values.
- A **DTO** carries data across a boundary, such as an API request.
- A **repository** retrieves and stores domain entities.

## Key Terminology

- **Identity:** a stable identifier that distinguishes one object from another.
- **Lifecycle:** the object can be created, modified, and retained over time.
- **Persistence:** saving and retrieving data from storage.

## Simple Example

`Expense` is an entity because it represents one recorded expense. `Money(100, INR)` is a value object because identical amount-and-currency values are equivalent. `ExpenseRequest` is a DTO carrying client input.

## Common Mistakes

- Calling every data-holding class a value object.
- Treating a DTO as a database object.
- Putting business logic in a repository.

## Mini Exercise

Classify `User`, `Group`, `Expense`, `Money`, `Split`, `Balance`, and `ExpenseRequest` as an entity, value object, DTO, or repository.

## My Answer

| Item | Classification | Reason |
|---|---|---|
| User | Entity | Has a unique identity. |
| Group | Entity | Has a unique identity. |
| Expense | Value object | Can be used to store data values. |
| Money | Value object | Kind of an enum. |
| Split | Value object | Does not require a unique identity. |
| Balance | DTO | Can be calculated from repository and entity. |
| ExpenseRequest | Repository | Fetched from DB. |

## Review Notes

- `User`, `Group`, and (for the first design) `Split` are correctly classified.
- An `Expense` needs identity and history, so it is an entity rather than a value object.
- `Money` is a value object, but it is not an enum: it combines an amount with a currency.
- A calculated `Balance` is usually a value object or read-model value, not a DTO merely because it is calculated.
- `ExpenseRequest` is incoming API data, so it is a DTO. A repository is a class such as `ExpenseRepository` that reads and writes `Expense` entities.

## Improved Design Answer

| Item | Classification | Reason |
|---|---|---|
| User | Entity | It has a stable user ID and lifecycle. |
| Group | Entity | It has an ID, members, and a lifecycle. |
| Expense | Entity | Each recorded expense has its own ID, creator, participants, and history. |
| Money | Value object | It is defined by amount and currency, not its own identity. |
| Split | Value object | It represents a participant's amount or percentage within an expense. |
| Balance | Value object | It represents an amount owed; identical values are interchangeable. |
| ExpenseRequest | DTO | It carries input from an API/controller to the application layer. |

No item in this list is a repository. Examples: `UserRepository`, `GroupRepository`, and `ExpenseRepository`.

## Cheat Sheet

- Needs a stable ID and history? Start by considering an entity.
- Equal values mean the same thing? Consider a value object.
- Carries request/response data across layers? It is likely a DTO.
- Saves or retrieves entities? It is a repository.

## Related Topics

- Interface vs abstract class
- Class relationships
- Repository and service boundaries

## Interface, Abstract Class, and Composition Decision Rule

Use the relationship sentence to choose the design tool:

```text
UpiPayment is a PaymentMethod       → interface
UpiPayment is an OnlinePayment      → abstract class, if shared online-payment code/state exists
UpiPayment has a UpiGateway         → composition
```

Start with an interface for a shared capability. Add an abstract class only when closely related implementations have real shared state or code. Use composition when one object needs another object's capability.

## Interface vs Abstract Class and Composition Exercise

### My Answer

1. **Main abstraction:** Interface. The payment types all pay differently and share only the behavior.
2. **Shared online behavior:** Add an abstract class called `OnlinePayment`. `UpiPayment`, `CardPayment`, and `WalletPayment` extend it because they share `transactionId` and `createReceipt()` logic. `CashPayment` does not extend it.
3. **Composition:** `UpiPayment` has a `UpiGateway`; `CardPayment` has a `CardValidator`.

### Review Notes

All three decisions are correct. An interface is the right main abstraction because Cash, UPI, Card, and Wallet share a capability but do not necessarily share stable state or code. The abstract class is an optional second layer for online methods only. Both composition examples express a clear has-a relationship.

### Reference Answer

```text
PaymentMethod is an interface because every method must pay, but each does it differently.

OnlinePayment is an abstract class only if UPI, Card, and Wallet share fields such as transactionId and implementation such as createReceipt().

UpiPayment has a UpiGateway.
CardPayment has a CardValidator.
```
