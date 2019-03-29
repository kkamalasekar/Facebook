#Author: Karthik.kamalsekar@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Testing Facebook SignUp 
  This Feature is to test different scenarios with respect to signing up in to Facebook.
  
  Background:
  	Given user navigates to Facebook homepage

  @Positive
  Scenario: Creating a new Facebook account with valid details
  	Given user enters the Firstname and Surname
    And keys in valid email address
    And enters a valid password
    Then keys in DOB as "Date", "Month", "Year"
    ###Assumption - DOB is made to select in random in code###Negative cases can be added accordingly 
    Then selects the Sex as "feMale"
    #And clicks on the signup button
