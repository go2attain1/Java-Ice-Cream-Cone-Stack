# Ice Cream Cone: Stack Adapter

A Java project demonstrating the Adapter design pattern and the stack data structure.
`IceCreamCone` wraps a `java.util.Stack<String>` and exposes it through the
`IceCreamConeADT` interface, so scoops behave like a last-in, first-out stack.

## Overview

| Type | Kind | Description |
|------|------|-------------|
| `IceCreamConeADT` | Interface | Defines the cone operations: add, eat, peek, contains, count, empty check |
| `IceCreamCone` | Class | Implements the interface by adapting a `Stack<String>` |
| `IceCreamConeTest` | Test class | JUnit tests for every method and exception path |

## How It Works

Scoops are pushed onto and popped from the top of the stack, so the last scoop
added is the first one eaten. The cone also tracks a `numScoops` counter that is
updated on every add and eat.

addScoop("chocolate") -> [chocolate]
addScoop("vanilla") -> [chocolate, vanilla]
currentScoop() -> "vanilla"
eatScoop() -> "vanilla" // cone is now [chocolate]


## Exceptions

| Scenario | Exception |
|----------|-----------|
| `addScoop(null)` | `IllegalArgumentException` |
| `contains(null)` | `IllegalArgumentException` |
| `eatScoop()` on an empty cone | `IllegalStateException` |
| `currentScoop()` on an empty cone | `IllegalStateException` |

## Concepts Demonstrated

- **Adapter pattern**: converting the `Stack` API into the interface the client expects
- **Stack (LIFO) behavior**: push, pop, peek, empty
- **Overriding `equals()`**: two cones are equal only if they hold the same flavors in
  the same order
- **Overriding `toString()`**: output like `[Vanilla, Chocolate, Rocky Road]`
- **Defensive programming**: preconditions enforced with exceptions
- **Unit testing**: exception paths verified with try/catch, plus equals() edge cases
  (null, self, different type, equal, different length, different order)

## Project Structure

icecream/

├── IceCreamConeADT.java

├── IceCreamCone.java

└── IceCreamConeTest.java


## Running the Tests

The tests extend `student.TestCase`, so `student.jar` must be on your classpath.

1. Create a Java project and a package named `icecream`
2. Place all three `.java` files in that package
3. Add `student.jar` to the project's build path
4. Run `IceCreamConeTest` as a JUnit test

## Example Usage

```java
IceCreamCone cone = new IceCreamCone();
cone.addScoop("chocolate");
cone.addScoop("vanilla");

cone.numScoops();          // 2
cone.contains("vanilla");  // true
cone.toString();           // "[chocolate, vanilla]"
cone.eatScoop();           // "vanilla"
cone.emptyCone();          // false
```
