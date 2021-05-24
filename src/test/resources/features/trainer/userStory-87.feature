Scenario: A trainer is logging in to their account

Given That a trainer is on the base website-page

When that trainer enters their valid information

And tries to login to the website

Then that trainer should successfully sign in

Scenario: A trainer is trying to login with invalid credentials

Given That a trainer is on the base website-page

When that trainer enters their invalid information

And tries to login to the website

Then that trainer should be unable to sign in