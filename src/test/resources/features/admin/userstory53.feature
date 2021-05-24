Feature:
  Scenario: Admin account is logged in and admin  removes trainers

    Given I am on the admin home page

    When I click on the trainer AND I click on the remove trainer button

    Then the removed trainer will not appear on the admin home page