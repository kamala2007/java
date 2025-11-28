---
applyTo: ['*']
description: "Instructions for migrating Java code from JDK 17 to JDK 21."
---

# Java 17 to Java 21 Migration Instructions

## 1. Update Build Tools

- Ensure Maven/Gradle supports JDK 21.
- Update toolchain configuration to use Java 21.

## 2. Adopt New Language Features

### Pattern Matching for switch
- Convert `instanceof` chains to switch expressions.
- Use pattern matching for type checks and destructuring.

**Bad Example (Java 17):**
```java
if (obj instanceof String) {
    String s = (String) obj;
    // ...
}
```
**Good Example (Java 21):**
```java
if (obj instanceof String s) {
    // use s directly
}
```

### Pattern Matching for switch

**Bad Example (Java 17):**
```java
if (obj instanceof Integer) {
    Integer i = (Integer) obj;
    // process i
} else if (obj instanceof String) {
    String s = (String) obj;
    // process s
}
```
**Good Example (Java 21):**
```java
switch (obj) {
    case Integer i -> {
        // process i
    }
    case String s -> {
        // process s
    }
    default -> {
        // handle other types
    }
}
```

## 3. Use Record Patterns

- Use record patterns for destructuring records in switch and instanceof.

**Bad Example (Java 17):**
```java
record Point(int x, int y) {}
Object obj = new Point(1, 2);
if (obj instanceof Point) {
    Point p = (Point) obj;
    int x = p.x();
    int y = p.y();
    // use x and y
}
```
**Good Example (Java 21):**
```java
record Point(int x, int y) {}
Object obj = new Point(1, 2);
if (obj instanceof Point(int x, int y)) {
    // use x and y directly
}
```

## 4. Utilize Sequenced Collections

- Prefer `SequencedCollection`, `SequencedSet`, and `SequencedMap` for collections with defined order.

**Bad Example (Java 17):**
```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
String first = list.get(0);
```
**Good Example (Java 21):**
```java
SequencedCollection<String> sc = new ArrayList<>();
sc.add("A");
sc.add("B");
String first = sc.getFirst();
```

## 5. Virtual Threads (Project Loom)

- Use `Executors.newVirtualThreadPerTaskExecutor()` for lightweight concurrency.

**Bad Example (Java 17):**
```java
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(() -> { /* task */ });
```
**Good Example (Java 21):**
```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> { /* task */ });
}
```

## 6. Remove Deprecated APIs

- Refactor code to avoid deprecated methods/classes removed in JDK 21.

**Bad Example:**
```java
Date date = new Date();
int year = date.getYear(); // Deprecated
```
**Good Example:**
```java
LocalDate date = LocalDate.now();
int year = date.getYear();
```

## 7. Update Third-Party Dependencies

- Ensure all dependencies are compatible with Java 21.

## 8. Test Thoroughly

- Run all unit and integration tests after migration.
- Check for runtime issues and warnings.

## 9. Review Preview Features

- If using preview features, update code to use finalized APIs or enable preview in build tools.

## 10. Documentation

- Update documentation to reflect Java 21 usage and new language features.

## 11. Simplify Code with Java 21 Features

- Use pattern matching for switch and instanceof to reduce boilerplate.
- Replace anonymous classes with lambdas for brevity and clarity.
- Use records for immutable data classes.
- Prefer concise collection APIs (e.g., `SequencedCollection#getFirst()`).
- Remove unnecessary null checks and redundant code where possible.

## 12. Use Records for Data Classes

- Replace verbose data classes with Java records for immutability and conciseness.

**Bad Example (Java 17):**
```java
public static class Employee {
    private final String name;
    private final String role;
    private final double salary;

    public Employee(String name, String role, double salary) {
        this.name = Objects.requireNonNull(name);
        this.role = Objects.requireNonNull(role);
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
}
```
**Good Example (Java 21):**
```java
public record Employee(String name, String role, double salary) {}
```
