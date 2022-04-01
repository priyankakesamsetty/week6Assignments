Feature: create lead

Background:
Given A Chrome browser is launched
#And Load the Leaftaps url
And Load the Leaftaps url 'http://leaftaps.com/opentaps/'
And Maximize the browser


Scenario: TC002 Create Lead
//Given ->The user to provide precondition
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And The Login button is clicked
When Click on 'CRMSFA' link
Then 'My Home' page is displayed
Then The Welcome Page should be displayed
When Click on 'Leads' link
Then 'My Leads' page is displayed
And Click on Create Lead
And Enter companyname as 'TechMahindra'
And Enter Firstname as 'priyanka'
And Enter lastname as '123'
And click on submit button
Then lead should be created
But lead is not created
