Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should successfully logged in
Examples:
|username									|password|
|kbalachandram@yahoo.com	|1234	|
|kbalachandram@yahoo1.com	|1234	|
|kbalachandram@yashoo.com	|12345|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field 
And User enters invalid password "XXXX" into password field
And User clicks on Login button
Then User should not be logged in and should display credentials mismatch error message

Scenario: Login with valid email and invalid password credentials
Given User navigates to login page
When User enters valid email address "kbalachandram@yahoo.com" into email field 
And User enters invalid password "XXXX" into password field
And User clicks on Login button
Then User should not be logged in and should display credentials mismatch error message

Scenario: Login with invalid email and valid password credentials
Given User navigates to login page
When User enters invalid email address into email field 
And User enters valid password "1234" into password field
And User clicks on Login button
Then User should not be logged in and should display credentials mismatch error message

Scenario: Login without any credentials
Given User navigates to login page
When User clicks on Login button
Then User should not be logged in and should display credentials mismatch error message