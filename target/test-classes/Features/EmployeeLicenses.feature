Feature: Add employee's licenses in qualifications

Background:
When user enters valid admin username and password
And user clicks on login button
Then admin user is successfully logged in
When user clicks on PIM option
And user clicks on Employee list button
And user clicks on any employee
Then Personal Details page displayed


  Scenario: Add employee's licenses in qualifications
  When user clicks on Qualification button
  Then Qualification page is displayed