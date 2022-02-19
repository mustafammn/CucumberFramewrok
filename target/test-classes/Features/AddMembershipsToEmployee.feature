Feature: Add Memberships To Employee


Background:
  When user enters valid admin username and password
  And user clicks on login button
  Then admin user is successfully logged in
  When user clicks on PIM option
  And user clicks on Employee list button
  And user clicks on any employee
  Then Personal Details page displayed


  @project
  Scenario: Add membership to any employee

    When user clicks on memberships button
    And user clicks on Add Membership button
    Then Add Membership page is displayed

    When user clicks on Membership dropdown
    Then dropdown is displayed and user select values from the dropdown

    When user clicks on Subscription Paid By dropdown
    Then dropdown is displayed and user can select values from the dropdown

    When user clicks on Subscription Amount text box
    Then text box is displayed and user can enter the amount there

    When user clicks on Currency dropdown
    Then dropdown is displayed and user selected values from the dropdown

    When user clicks on Subscription Commence Date field
    Then field is displayed and user can select date from there

    When user clicks on Subscription Renewal Date
    Then calendar is displayed and user can pick date from there

    When user clicks on save button after all step
    Then the membership added to the employee

