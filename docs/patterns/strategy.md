# Strategy Pattern

## Why This Matters

Strategy removes growing conditional logic when one business action can follow several algorithms.

## Core Idea

Put each interchangeable algorithm behind one shared interface. A service chooses a strategy and delegates the variable calculation to it.

## Key Terminology

- **Strategy:** the common algorithm contract.
- **Concrete strategy:** one implementation of that contract.
- **Context:** the service that uses a strategy.

## Simple Example

`ExpenseService` delegates share calculation to a `SplitStrategy`. Equal, exact, and percentage splits implement the same contract with different calculations.

## Common Mistakes

- Keeping all algorithm branches in one service with a large `if/else` or `switch`.
- Giving the strategy the full responsibility for saving an expense or sending notifications.
- Naming the method too broadly when the strategy only calculates allocations.

## Mini Exercise

Design the Splitwise split-strategy interface, one method, three implementations, and its caller.

## My Answer

```text
Interface: SplitStrategy
Method: splitExpense()
Implementations: EqualSplitStrategy, ExactSplitStrategy, PercentageSplitStrategy
Used by: Main service which wants to split an expense provided the split type
```

## Review Notes

The interface and implementation names are correct. `splitExpense()` communicates the intent, but a strategy should focus on calculating allocations, not the complete expense workflow. The caller should be named explicitly as `ExpenseService` or `SplitService`. Strategy selection can be based on split type; a later Factory can encapsulate that selection.

## Improved Design Answer

```text
Interface: SplitStrategy
Method: calculateSplits(totalAmount, participants)
Implementations:
- EqualSplitStrategy
- ExactSplitStrategy
- PercentageSplitStrategy
Used by: ExpenseService (or SplitService)
```

`ExpenseService` selects the applicable strategy, asks it to calculate participant shares, then validates and saves the expense. The strategy owns only the varying split algorithm.

## Cheat Sheet

```text
Same goal, different algorithm → Strategy
Stable workflow, variable calculation → delegate to a strategy
```

## Strategy vs Factory

```text
Strategy decides how work is done.
Factory decides which object to create or select.
```

Splitwise example:

```text
ExpenseService needs to calculate shares          → Strategy
EqualSplitStrategy / ExactSplitStrategy / PercentageSplitStrategy
contain the different calculations.

splitType = PERCENTAGE                            → Factory
SplitStrategyFactory returns PercentageSplitStrategy.
```

Together:

```text
ExpenseService → SplitStrategyFactory → PercentageSplitStrategy
ExpenseService → calculateSplits(...) on the returned strategy
```

A Strategy does not always require a Factory. If a strategy is already selected and injected into a service, use Strategy alone. Add a Factory when a runtime type/configuration choice must be centralized.

## Related Topics

- Factory pattern
- Open/Closed Principle
- Dependency Inversion Principle
