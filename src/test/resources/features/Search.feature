Feature: Search Functionality

Scenario: User search with valid product
When User opens application
And User enters valid product "HP" in search field
And User clicks on search button
Then User should be displayed with valid products in search result

Scenario: User search without any prouct in search field
When User opens application
And User clicks on search button
Then User should not be displayed with any products

Scenario: User search with invalid product
When User opens application
And User enters invalid product "Honda" in search field
And User clicks on search button
Then User should not be displayed with any products