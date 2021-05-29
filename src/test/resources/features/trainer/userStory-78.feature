Scenario: Trainees automatically lose access to the forms of previous weeks.

Given I am a trainer

And I have submitted a previous week’s form

When the trainee views the form

Then they are not able to edit the form