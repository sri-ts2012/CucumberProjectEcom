Feature: Registration Functionality Scenarios

@Register @One
Scenario: Verify whether the user is able to register into the application by providing all the fields
Given I launch the application
And I navigate to account registration page
When I fill all the below valid details
|FirstName	|Hima								|
|LastName		|Ts									|
|Email			|hima.tsri@gmail.com|
|Telephone	|343435454434				|
|Password		|himats							|
And I select the Privacy Policy
And I click on Continue button
Then I should see that the User Account has successfully created

@Register @Two
Scenario: Verify whether the user is not allowed to register on skipping mandatory fields
Given I launch the application
And I navigate to account registration page
And I click on Continue button
Then I should see the user account is not created
And I should see the error message informing the user to enter the mandatory fields


@Register @Three
  Scenario: Verify whether the user is able to register into the application by opting for Newsletter subscription
  Given I launch the application
And I navigate to account registration page
When I fill all the below valid details
    	| FirstName | Ravi 									|
    	| LastName  | Kiran 								|
    	| Email			| Ravi.kiran2@gmail.com |
    	| Telephone	| 9212345678						|
    	| Password	| rkiran								|
    And I subscribe to Newsletter
    And I select the Privacy Policy
And I click on Continue button
Then I should see that the User Account has successfully created

@Register @Four
  Scenario: Verify whether the user is able to register into the application by opting for Newsletter subscription
  Given I launch the application
And I navigate to account registration page
When I provide the below duplicate details
    	| FirstName | Ravi 									|
    	| LastName  | Kiran 								|
    	| Email			| Ravi.kiran2@gmail.com |
    	| Telephone	| 9212345678						|
    	| Password	| rkiran								|
    	    And I select the Privacy Policy
And I click on Continue button
Then I should see that the user is restricted from creating duplicate account


