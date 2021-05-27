## Our Team

- **Jakub Matyjewicz** - SCRUM Master and SDET
- **Alasdair Malcolm** - SCRUM Master and SDET
- **Jack Ingham** - SDET
- **Alex Sikorski** - SDET
- **Golam Choudhury** - SDET
- **Abdul Makba** - SDET
- **Patrick Walsh** - SDET

## Tools

- JDK 11
- Maven
- IntelliJ
- JUnit 5
- Git
- Selenium
- SeleniumIDE
- Cucumber
- JIRA

## Rules

- Do not touch the **master** branch.

- The **feature branches** include software features that then merge in to the **dev** branch.

- Follow **SOLID** principles.

- Strictly adhere to **OOP** for scalability, maintainability, testability, and general robustness.

## GitHub Branch Rules

-Naming Convention: f(ticket number)-(small description) e.g. f76-prevWeekAccess

-Pushing code from a feature branch to the dev branch requires approval and review by 2 members of the team.

-Pushing code from the dev branch to the master branch requires approval and review by 1 member of the team and the scrum master.

## Our Definition of Done :heavy_check_mark:
-Minimum documentation per feature

-Code review

-Framework Unit tests passed

-Acceptance criteria met

-Product owner review / approval

## Project Architecture

This project uses a POM design pattern.

### Pages
- Every page within the website is created as an object. These objects all extend superior interfaces and abstract classes to minimise the repetition of common functionality.

