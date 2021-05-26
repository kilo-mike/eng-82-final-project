Feature: Checking if  trainee profile page works correctly
  Scenario: The Trainee wants to view feedback progress over time
  Given I am logged in as a trainee, non-submitting
  When The trainee views their profile
  Then The trainee will be able to see their average grades over time
