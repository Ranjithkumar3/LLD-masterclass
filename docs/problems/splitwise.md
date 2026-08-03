# Splitwise

## Scope and Assumptions

- Users register and can create or join groups.
- A group member can create an expense and choose equal, exact, or percentage splitting.
- The system calculates each participant's share and updates balances.
- Users can settle outstanding balances with a payment/settlement record.

## Core Entities

- `User`
- `Group`
- `Expense`
- `Split`
- `Money`
- `Balance`
- `Settlement`

## Relationships

- `Group` has members (`User` objects); a user can belong to multiple groups.
- `Group` contains expenses.
- `Expense` is created by one user and contains one `Split` per participant.
- `Balance` represents an amount one user owes another, optionally within a group.
- `Settlement` reduces or closes a balance between users.

## Services

- `ExpenseService` validates and records expenses.
- `SplitService` chooses a split strategy and calculates shares.
- `BalanceService` updates balances after an expense or settlement.
- `SettlementService` records settlement payments.

## Split Handling

- **Equal:** divide the total among participants, with a defined rounding rule for remaining minor units.
- **Exact:** accept individual amounts and validate that their sum equals the total expense.
- **Percentage:** calculate shares by percentage and validate that percentages total 100.

## Patterns

- **Strategy:** `EqualSplitStrategy`, `ExactSplitStrategy`, and `PercentageSplitStrategy` implement `SplitStrategy`.
- **Factory:** optional to select the strategy from the requested split type.

## Edge Case

- Exact split amounts do not total the expense, or percentage values do not total 100. Reject the request before creating the expense. Also define a rounding rule for equal/percentage splits to avoid losing money's smallest unit.

## Mini Exercise

Design Splitwise in two-minute format, including equal, exact, and percentage split handling.

## My Answer

```text
Assumptions: users register/login, create groups, post expenses, select exact/equal/percentage strategies, join groups, and settle an expense.

Classes: User, Group, Expense.

Relationships: Group has users; Group has expense; User has expense balance.

Patterns: Strategy for split.

Edge case: User-friends association.
```

## Review Notes

- The scope, core three entities, group relationships, and Strategy choice are correct.
- Add `Split` to represent each participant's allocation, and `Balance` to represent an amount owed. `Money` makes amounts/currency explicit; `Settlement` records reducing a balance.
- Add services for expense validation, split calculation, balance updates, and settlements.
- “User-friends association” is a possible future relationship but not an edge case. An edge case is an invalid or unusual condition, such as exact amounts not summing to the expense.
- State the validation needed by all three strategies.

## Improved Design Answer

```text
Assumptions:
- Users belong to groups and can add expenses.
- An expense has a payer, total Money amount, participants, and split type.
- Users settle balances, not an individual expense directly.

Classes:
- User, Group, Expense, Split, Money, Balance, Settlement

Relationships:
- Group has many Users and Expenses.
- Expense has one payer and many Splits.
- Each Split represents one User's share.
- Balance represents what one User owes another.

Services:
- ExpenseService, SplitService, BalanceService, SettlementService

Split handling:
- Equal: divide total and handle rounding.
- Exact: validate split total equals expense total.
- Percentage: validate percentages total 100, then calculate amounts.

Patterns:
- SplitStrategy with EqualSplitStrategy, ExactSplitStrategy, PercentageSplitStrategy.
- Optional SplitStrategyFactory selects the implementation.

Edge case:
- Reject exact amounts that do not add up to the total, and percentages that do not total 100.
```
