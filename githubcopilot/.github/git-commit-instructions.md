---
applyTo: '**'
description: 'description'
---
When generating commit messages:

1. **Follow Conventional Commits:**
    - `feat(type): description` for new features. Example: `feat(update): update config file`
    - `fix(type): description` for bug fixes. Example: `fix(bug): correct issue`
    - `refactor(type): description` for code refactoring.
    - `test(type): description` for adding or modifying tests.
    - `docs(type): description` for documentation updates.

2. **Structure:**
    - Use the format: `<type>(<scope>): <description>`
    - The scope (in parentheses) is optional but recommended to clarify the area of change.
    - The description should be concise and use the imperative mood (e.g., "update config file").

3. **Examples:**
    - `feat(api): add new endpoint for user login`
    - `fix(controller): handle null pointer exception`
    - `refactor(service): simplify logic in payment processing`
    - `test(model): add tests for customer entity`
    - `docs(readme): update installation instructions`
