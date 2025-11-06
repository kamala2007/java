# 🧠 Clean Code Copilot Instructions for Java
_Based on "Clean Code: A Handbook of Agile Software Craftsmanship" by Robert C. Martin_

---

## 🧩 Chapter 1: Clean Code
**Principle:** Code should be simple, readable, and intentional.

```java
// Write a simple, self-explanatory Java method.
// Avoid clever tricks. Prefer clarity and correctness.
```

**Guidelines:**
- Prioritize readability over cleverness.
- Each method/class should communicate its purpose clearly.
- Eliminate unnecessary complexity.

## 🏷️ Chapter 2: Meaningful Names
**Principle:** Names should reveal intent.

```java
// Rename variables and methods to clearly describe their purpose.
// Use domain-specific terms, not abbreviations or placeholders.
```

**Guidelines:**
- Classes → nouns (e.g. InvoiceService, UserRepository)
- Methods → verbs (e.g. calculateTotal(), validateUser())
- Avoid meaningless names like data, tmp, foo, helper.

## 🧠 Chapter 3: Functions
**Principle:** Functions should be small, focused, and expressive.

```java
// Extract logic into small, single-purpose methods.
// Keep methods short (<20 lines) and avoid side effects.
// Use clear, descriptive method names.
```

**Guidelines:**
- One responsibility per method.
- Limit parameters (prefer objects or value objects).
- Avoid deeply nested logic.

## 💬 Chapter 4: Comments
**Principle:** Use comments to explain why, not what.

```java
// Remove redundant comments and improve code clarity instead.
// Add comments only for intent or business rules.
```

**Guidelines:**
- Code should explain what it does.
- Comments should explain why it’s needed.
- Keep comments up to date.

## 🧱 Chapter 5: Formatting
**Principle:** Maintain visual and structural consistency.

```java
// Format code with consistent indentation and spacing.
// Group related statements and add blank lines for readability.
```

**Guidelines:**
- 4-space indentation, braces aligned.
- One class per file.
- Keep line length ≤ 120 chars.

## 🧩 Chapter 6: Objects and Data Structures
**Principle:** Hide data and expose behavior.

```java
// Hide internal fields with private access and expose intent via methods.
// Avoid exposing mutable public fields.
```

**Guidelines:**
- Use private and final where possible.
- Prefer behavior methods over getters/setters.
- Keep objects cohesive and encapsulated.

## ⚠️ Chapter 7: Error Handling
**Principle:** Use exceptions, not error codes or nulls.

```java
// Replace null checks and error codes with exceptions or Optional.
// Use clear, descriptive exception messages.
```

**Guidelines:**
- Use try-with-resources for cleanup.
- Avoid returning null.
- Use domain-specific exceptions.

## 🔌 Chapter 8: Boundaries
**Principle:** Isolate third-party and external code.

```java
// Wrap external API calls in adapter or gateway classes.
// Keep external dependencies separate from core logic.
```

**Guidelines:**
- Create adapter classes for libraries.
- Avoid scattering library calls across the domain.
- Keep boundaries clear and testable.

## 🧪 Chapter 9: Unit Tests
**Principle:** Write clean, independent, readable tests.

```java
// Write a JUnit 5 test using Arrange-Act-Assert.
// Each test should verify one behavior clearly.
```

**Guidelines:**
- Use meaningful test names (shouldCalculateTotal_whenItemsAdded()).
- Avoid dependencies between tests.
- Keep tests fast, isolated, and repeatable.

## 🏗️ Chapter 10: Classes
**Principle:** Classes should be small, cohesive, and focused.

```java
// Refactor this class to follow the Single Responsibility Principle.
// Each class should have one clear reason to change.
```

**Guidelines:**
- Split large classes into smaller ones.
- Prefer composition over inheritance.
- Limit the number of fields.

## ⚙️ Chapter 11: Systems
**Principle:** Separate construction from usage.

```java
// Inject dependencies rather than creating them inside the class.
// Use constructors or frameworks for dependency injection.
```

**Guidelines:**
- Avoid new inside business logic.
- Use dependency injection (Spring, Guice, manual).
- Keep system assembly code separate.

## 🧩 Chapter 12: Emergence
**Principle:** Follow the four rules of simple design.

```java
// Simplify the code by removing duplication and improving clarity.
// Ensure all tests pass and intent is clear.
```

**Rules of Simple Design:**
- All tests pass
- Code expresses intent
- No duplication
- Minimal number of classes and methods

## 🧵 Chapter 13: Concurrency
**Principle:** Make concurrency safe and simple.

```java
// Use ExecutorService or parallel streams instead of manual threads.
// Favor immutability and minimize shared mutable state.
```

**Guidelines:**
- Synchronize only necessary code blocks.
- Use ConcurrentHashMap, CopyOnWriteArrayList, etc.
- Test concurrency behavior explicitly.

## 🚫 Chapter 14+: Code Smells & Heuristics
**Principle:** Identify and remove common code smells.

```java
// Identify and refactor long methods, large classes, and duplicate logic.
// Use Extract Method / Extract Class to simplify design.
```

**Common Smells:**
- Long functions or classes
- Duplicated code
- Too many parameters
- Inconsistent naming
- Dead or commented-out code

**Remedies:**
- Extract smaller components.
- Rename for clarity.
- Remove unused or redundant logic.

---

## ✅ Clean Code Copilot Checklist for Java
Use this as Copilot’s behavioral guide when generating or reviewing code:
- Use descriptive, domain-based names
- Write small, single-purpose methods
- Replace nulls with Optional or exceptions
- Favor composition over inheritance
- Hide data, expose intent
- Write clean, isolated tests
- Format consistently
- Encapsulate external APIs
- Eliminate duplication and unclear logic
- Simplify until intent is obvious
