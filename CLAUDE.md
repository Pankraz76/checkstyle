# CLAUDE.md - Checkstyle Configuration Guide

## Project Structure
- Checkstyle configuration: `/config/checkstyle/checkstyle.xml`
- Suppressions file: `/config/checkstyle/suppressions.xml`
- Custom checks: `/src/main/java/com/company/checkstyle/`

## Key Configuration Rules
- Line length: 120 characters max
- Indentation: 4 spaces (no tabs)
- Naming conventions: CamelCase for classes, camelCase for methods
- Javadoc required for all public methods and classes

## Commands
- Run Checkstyle: `./gradlew checkstyleMain` or `mvn checkstyle:check`
- Generate report: `./gradlew checkstyleMain -Dcheckstyle.generateReport=true`
- Fix issues: Use `./gradlew spotlessApply` for auto-formatting

## Common Checkstyle Exceptions
- Tests are more lenient (use suppressions.xml)
- Generated code is excluded
- Builder pattern classes may suppress certain warnings