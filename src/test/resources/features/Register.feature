Feature: Register Functionality

Scenario: Register with mandatory fields
Given User navigates to Register page
When User enters below details with new email
|First Name|Balachandram|
|Last Name| Kandakatla|
|Telephone|1234567890|
|Password|1234|
|Password Confirm|1234|
And User selects Privacy Policy checkbox
And User clicks on Continue button
Then User Account should get created successfully 

Scenario: Register with All fields
Given User navigates to Register page
When User enters below details with new email
|First Name|Balachandram|
|Last Name| Kandakatla|
|Telephone|1234567890|
|Password|1234|
|Password Confirm|1234|
And User select Yes for newsletter
And User selects Privacy Policy checkbox
And User clicks on Continue button
Then User Account should get created successfully

Scenario: Register with existing email
Given User navigates to Register page
When User enters below details with existing email
|First Name|Balachandram|
|Last Name| Kandakatla|
|Email|kbalachandram@yahoo1.com|
|Telephone|1234567890|
|Password|1234|
|Password Confirm|1234|
And User select Yes for newsletter
And User selects Privacy Policy checkbox
And User clicks on Continue button
Then User already exists message should be displayed 

Scenario: Register without filling any details
Given User navigates to Register page
When User clicks on Continue button
Then User should be displayed with error messages for mandatory fields 