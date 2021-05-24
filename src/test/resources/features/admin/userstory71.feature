Feature:
  Scenario: Admin logged in and changes password

    Given I am on the profile page

    When I click the change password button AND add the relative information AND click the change button

    Then the password should be changed

