<h1 align="center">Engineering 82 Final Project</h1>
<img alt="Project Sparta Badge" src="https://img.shields.io/badge/project-sparta-%23e43560?label=project&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAMAAADW3miqAAABZVBMVEVAIFHkNWBBH1FDHlHiNmBBH1LON2DlNWBcHVH+/v////3FNmFAHlRAG08/H1A+IFFhIU5BHlL9/fxBH05EHVL///xAHlH9//3//v3Y0dnjNl9LLFhCHVRDG08+IU79//v7//vMwtD4+Pi8scF6ZITjNmLfOF5BI1JDHU/28/ZuV3pGKFZEI1FnH08/HU339veDbI7kNV7iN11NHlE/HEv//////P/7/PrVOGPdN2JiIVE8IVFAHU8/H05UHk1AGU1HHUxNHEy8scCklamjk6iCa4p3YYDRNmbKNmLHNmHBNWHnNGCvMGBTH1NAHFHy7PLt6e/Vy9iwpLWwpLSoma6jkKaXf5t6ZoFvVnpgRG1hS2lYPWW1M11NMFqMLViLJ1iVLFd2KVd7JVR2IFOHKFJeIVFaH009GUjg2ePDuMfAucKzqLqxpbiQeZeMe5HaOGTQN2CqNGCmLF+dLFuEKllJJ1lGKFVpXQQhAAACNUlEQVR42qXQhXajWACAYZyQwmVxSrwtbNzdU7fU3X3c5fmHCHMgDcfmj4ePa9A4XBQ50GBxZzQqAMgW28BpWkYccVwwaDdCMNAreP5zVk+l+rg1CBREAu3HH1cbxKvuWQuJXPdhu2pgGAaT9raw2r1sTdUo3H3F8vkBckRqa3VujJDuXS2XN4xXKKdt9v0jIqI/q8NRdFjXHEjb2i4MEYLLL5ukhuVIUqutrc842rgRhmeA0umn2haskXr16inlcdYu0NCgKN3b1nUsp63dtqMcJ3P0IM7vH3ywAB+OJID2DGZmfO+x/mbw/1HJZBKxH7X8vG4avfoIgLD6YX7Y4uL8SsuOkDqBma0/s+nzt4p3FFVaTkO2xBSBGXltwyMzCxmFokIURalh5diO2EaKMIwcOeMBzMKceZ2vVCp8hT8u2geS6wQJY/oIlVV+cSU76BzYR/L3b75tEl/GKMSfvOl00szODm5HEN7tvaQebgt/UbFYZBgOmghncdBtQaPpIstLS0vLK78mFEv7ab/IscOFU6okSd5S7FNrAiFRVAAox6xmeIoKK4qi8uF3SWhq4HJWMg+yVPKGKG8kMd1ArfjRweHB4ftM2BUFg/5mOtpsFi/2XBBiJiAM0wkEOu4IRdHodXzQ2edddyQyq7uxQRmeHyB5OjrNhFRVCYVUhQ9HfkMuaC4kDfMq/JHggs72Z8ftf7wE0xcuJH1W18kdfPoRQLIcDZhFAyjOOc3kgIMQd/Fv6A8ksVwk6PNPnQAAAABJRU5ErkJggg=="/>


##About
An agile Java group project completed as our final project at Sparta. The deliverable of the project was to produce a testing framework suitable for testing the Sparta 1-1 tracker website created by a previous Java Development group and to Implement BDD, using JUnit5 and Cucumber. The aim was to verify the integrity of the code before it was actually implemented at Sparta.



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

