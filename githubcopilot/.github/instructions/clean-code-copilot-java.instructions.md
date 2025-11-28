# 🧠 Clean Code Copilot Instructions for Java
_Based on "Clean Code: A Handbook of Agile Software Craftsmanship" by Robert C. Martin_

---

## 🧩 Chapter 1: Clean Code
**Principle:** Code should be simple, readable, and intentional.

**Good Example:**
```java
// Good: Simple, clear, and intentional
public int add(int a, int b) {
    return a + b;
}
```
```java
public class Rectangle {
private final double width;
private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive.");
        }
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[width=%.2f, height=%.2f]", width, height);
    }
}

```
**Bad Example:**
```java
// Bad: Unclear, unnecessary complexity
public int a(int x, int y) {
    int z = x + y;
    return z;
}
```
```java
public class PasswordValidator {

    public static boolean check(String s) {
        if (s != null && !s.equals("")) {
            if (s.length() > 7) {
                if (s.matches(".*[A-Z].*")) {
                    if (s.matches(".*\\d.*")) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
```
**Guidelines:**
- Prioritize readability over cleverness.
- Each method/class should communicate its purpose clearly.
- Eliminate unnecessary complexity.

## 🏷️ Chapter 2: Meaningful Names
**Principle:** Names should reveal intent.

**Good Example:**
```java
// Good: Descriptive names
public class InvoiceService {
    public void calculateTotal() {}
}
```
```java
public class OrderService {

    public double calculateTotalPriceWithTax(List<OrderItem> items, double taxRate) {
        double subtotal = calculateSubtotal(items);
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    private double calculateSubtotal(List<OrderItem> items) {
        return items.stream()
                    .mapToDouble(OrderItem::price)
                    .sum();
    }
}

public record OrderItem(String name, double price) {}
```
**Bad Example:**
```java
// Bad: Vague, non-descriptive names
public class Data {
    public void doIt() {}
}
```

**Guidelines:**
- Classes → nouns (e.g. InvoiceService, UserRepository)
- Methods → verbs (e.g. calculateTotal(), validateUser())
- Avoid meaningless names like data, tmp, foo, helper.

## 🧠 Chapter 3: Functions
**Principle:** Functions should be small, focused, and expressive.

**Good Example:**
```java
// Good: Single responsibility, clear name
public boolean isAdult(int age) {
    return age >= 18;
}
```
**Bad Example:**
```java
// Bad: Does too much, unclear purpose
public boolean check(int a) {
    if (a >= 18) {
        System.out.println("Adult");
        return true;
    }
    return false;
}
```

**Guidelines:**
- One responsibility per method.
- Limit parameters (prefer objects or value objects).
- Avoid deeply nested logic.

## 💬 Chapter 4: Comments
**Principle:** Use comments to explain why, not what.

**Good Example:**
```java
// Good: Explains why
// We use a threshold of 18 because it's the legal adult age.
public boolean isAdult(int age) {
    return age >= 18;
}
```
**Bad Example:**
```java
// Bad: Redundant comment
// Check if age is greater than or equal to 18
public boolean isAdult(int age) {
    return age >= 18;
}
```

**Guidelines:**
- Code should explain what it does.
- Comments should explain why it’s needed.
- Keep comments up to date.

## 🧱 Chapter 5: Formatting
**Principle:** Maintain visual and structural consistency.

**Good Example:**
```java
// Good: Consistent formatting
public class User {
    private String name;

    public String getName() {
        return name;
    }
}
```
**Bad Example:**
```java
// Bad: Inconsistent formatting
public class User{private String name;public String getName(){return name;}}
```

**Guidelines:**
- 4-space indentation, braces aligned.
- One class per file.
- Keep line length ≤ 120 chars.

## 🧩 Chapter 6: Objects and Data Structures
**Principle:** Hide data and expose behavior.

**Good Example:**
```java
// Good: Encapsulated fields
public class Account {
    private double balance;
    public void deposit(double amount) {
        balance += amount;
    }
}
```
**Bad Example:**
```java
// Bad: Exposed mutable field
public class Account {
    public double balance;
}
```

**Guidelines:**
- Use private and final where possible.
- Prefer behavior methods over getters/setters.
- Keep objects cohesive and encapsulated.

## ⚠️ Chapter 7: Error Handling
**Principle:** Use exceptions, not error codes or nulls.

**Good Example:**
```java
// Good: Uses exceptions
public void withdraw(double amount) {
    if (amount > balance) {
        throw new IllegalArgumentException("Insufficient funds");
    }
    balance -= amount;
}
```
**Bad Example:**
```java
// Bad: Uses error codes
public int withdraw(double amount) {
    if (amount > balance) {
        return -1; // error code
    }
    balance -= amount;
    return 0;
}
```

**Guidelines:**
- Use try-with-resources for cleanup.
- Avoid returning null.
- Use domain-specific exceptions.

## 🔌 Chapter 8: Boundaries
**Principle:** Isolate third-party and external code.

**Good Example (Spring):**
```java
// Good: Use a service to wrap external API
@Service
public class PaymentGateway {
    private final RestTemplate restTemplate;
    public PaymentGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // ...
}
```
**Bad Example:**
```java
// Bad: Directly use RestTemplate everywhere
public class OrderService {
    public void pay() {
        new RestTemplate().postForObject(...);
    }
}
```

**Guidelines:**
- Create adapter classes for libraries.
- Avoid scattering library calls across the domain.
- Keep boundaries clear and testable.

## 🧪 Chapter 9: Unit Tests
**Principle:** Write clean, independent, readable tests.

**Good Example (JUnit 5):**
```java
// Good: Clear, isolated test
@Test
void shouldReturnAdultWhenAgeIs18OrMore() {
    assertTrue(isAdult(18));
}
```
**Bad Example:**
```java
// Bad: Vague, multiple assertions
@Test
void test1() {
    assertTrue(isAdult(18));
    assertFalse(isAdult(17));
}
```

**Guidelines:**
- Use meaningful test names (shouldCalculateTotal_whenItemsAdded()).
- Avoid dependencies between tests.
- Keep tests fast, isolated, and repeatable.

## 🏗️ Chapter 10: Classes
**Principle:** Classes should be small, cohesive, and focused.

**Good Example:**
```java
// Good: Single responsibility
public class EmailSender {
    public void send(String to, String message) {}
}
```
**Bad Example:**
```java
// Bad: Does too much
public class EmailSender {
    public void send(String to, String message) {}
    public void log(String msg) {}
    public void backup() {}
}
```

**Guidelines:**
- Split large classes into smaller ones.
- Prefer composition over inheritance.
- Limit the number of fields.

## ⚙️ Chapter 11: Systems
**Principle:** Separate construction from usage.

**Good Example (Spring):**
```java
// Good: Use dependency injection
@Service
public class OrderService {
    private final PaymentGateway paymentGateway;
    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```
**Bad Example:**
```java
// Bad: Manual instantiation
public class OrderService {
    private final PaymentGateway paymentGateway = new PaymentGateway();
}
```

**Guidelines:**
- Avoid new inside business logic.
- Use dependency injection (Spring, Guice, manual).
- Keep system assembly code separate.

## 🧩 Chapter 12: Emergence
**Principle:** Follow the four rules of simple design.

**Good Example:**
```java
// Good: No duplication, clear intent
public int sum(int a, int b) {
    return a + b;
}
```
**Bad Example:**
```java
// Bad: Duplicated logic
public int sum(int a, int b) {
    int result = a + b;
    return result;
}
```

**Rules of Simple Design:**
- All tests pass
- Code expresses intent
- No duplication
- Minimal number of classes and methods

## 🧵 Chapter 13: Concurrency
**Principle:** Make concurrency safe and simple.

**Good Example:**
```java
// Good: Use thread-safe collections
List<String> list = Collections.synchronizedList(new ArrayList<>());
```
**Bad Example:**
```java
// Bad: Not thread-safe
List<String> list = new ArrayList<>();
```

**Guidelines:**
- Synchronize only necessary code blocks.
- Use ConcurrentHashMap, CopyOnWriteArrayList, etc.
- Test concurrency behavior explicitly.

## 🚫 Chapter 14+: Code Smells & Heuristics
**Principle:** Identify and remove common code smells.

**Good Example:**
```java
// Good: No duplication, clear logic
public double calculateTotal(List<Double> prices) {
    return prices.stream().mapToDouble(Double::doubleValue).sum();
}
```
**Bad Example:**
```java
// Bad: Duplicated, unclear logic
public double calculateTotal(List<Double> prices) {
    double total = 0;
    for (Double price : prices) {
        total += price;
    }
    return total;
}
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
