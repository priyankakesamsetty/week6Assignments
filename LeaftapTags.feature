Feature: create lead

Background:
Given A Chrome browser is launched
#And Load the Leaftaps url
And Load the Leaftaps url 'http://leaftaps.com/opentaps/'
And Maximize the browser


@functional
Scenario: TC002 Create Lead
//Given ->The user to provide precondition
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And The Login button is clicked
When Click on 'CRM/SFA' link
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
Scenario Outline: TC002 Edit Lead
Given Enter the username as <username>
And Enter the password as <password>
When The Login button is clicked
When Click on 'CRMSFA' link
Then The Welcome Page should be displayed
When Click on 'Leads' link
And Click on FindLead
And Click on phone
And Enter the phonenumber as <phonenum>
And Click on Find Leads
Then Click on first lead in the lead list
And Click on Edit Lead
And Enter the companyname as <companyname>
And Click on update button
Then View lead page is displayed
Examples:
|username|password|phonenum|companyname|
|'Demosalesmanager'|'crmsfa'|'99'|'xyz'|
|'Demosalesmanager'|'crmsfa'|'98'|'abc'|

Scenario: Delete Lead
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And The Login button is clicked
When Click on 'CRMSFA' link
Then The Welcome Page should be displayed
When Click on 'Leads' link
And Click on FindLead
And Click on phone
And Enter the phonenumber as '99'
And Click on Find Leads
Then Click on first lead in the lead list
And Click on Delete
And Click on FindLead
And Enter the stored LeadID 
And Click on Find Leads
Then Page with no records should be displayed

Scenario Outline: TC004 DuplicateLead

Given Enter the username as <username>
And Enter the password as <password>
When The Login button is clicked
Given Click on 'CRMSFA' link
Then The Welcome Page should be displayed
Given Click on 'Leads' link 
And Click on FindLead
And Click on phone
And Enter the phonenumber as <phonenum>
And Click on Find Leads
Then Click on first lead in the lead list
And Click on Duplicate button
And Click on Createlead button
Examples:
|username|password|phonenum|
|'Demosalesmanager'|'crmsfa'|'99'|


Scenario: Merge lead
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When The Login button is clicked
When Click on 'CRMSFA' link
Then The Welcome Page should be displayed
When Click on 'Leads' link
And Click on MergeLeads
And Click on From_lead icon
Then Handle new From window
And Enter newwindowFirstname as 'Priyanka'
And Click on Find Leads
And  Click on first lead in the lead list
Then Navigate to parent window
And Click on ToLead icon
Then Handle new To window
And Enter newwindowFirstname as 'abc'
And Click on Find Leads
And Click on first lead in the lead list
And Navigate to parent1 window
Then Click on Merge button
And Handle Alert
And Click on FindLead
And Enter the stored LeadID 
And Click on Find Leads
Then Page with no records should be displayed
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
Scenario Outline: TC002 Edit Lead
Given Enter the username as <username>
And Enter the password as <password>
When The Login button is clicked
When Click on 'CRMSFA' link
Then The Welcome Page should be displayed
When Click on 'Leads' link
And Click on FindLead
And Click on phone
And Enter the phonenumber as <phonenum>
And Click on Find Leads
Then Click on first lead in the lead list
And Click on Edit Lead
And Enter the companyname as <companyname>
And Click on update button
Then View lead page is displayed
Examples:
|username|password|phonenum|companyname|
|'Demosalesmanager'|'crmsfa'|'99'|'xyz'|
|'Demosalesmanager'|'crmsfa'|'98'|'abc'|

Scenario: Delete Lead
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And The Login button is clicked
When Click on 'CRMSFA' link
Then The Welcome Page should be displayed
When Click on 'Leads' link
And Click on FindLead
And Click on phone
And Enter the phonenumber as '99'
And Click on Find Leads
Then Click on first lead in the lead list
And Click on Delete
And Click on FindLead
And Enter the stored LeadID 
And Click on Find Leads
Then Page with no records should be displayed

Scenario Outline: TC004 DuplicateLead

Given Enter the username as <username>
And Enter the password as <password>
When The Login button is clicked
When Click on 'CRMSFA' link
Then The Welcome Page should be displayed
When Click on 'Leads' link
And Click on FindLead
And Click on phone
And Enter the phonenumber as <phonenum>
And Click on Find Leads
Then Click on first lead in the lead list
And Click on Duplicate button
And Click on Createlead button
Examples:
|username|password|phonenum|
|'Demosalesmanager'|'crmsfa'|'99'|


Scenario: Merge lead
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When The Login button is clicked
When Click on 'CRMSFA' link
Then The Welcome Page should be displayed
When Click on 'Leads' link
And Click on MergeLeads
And Click on From_lead icon
Then Handle new From window
And Enter newwindowFirstname as 'Priyanka'
And Click on Find Leads
And  Click on first lead in the lead list
Then Navigate to parent window
And Click on ToLead icon
Then Handle new To window
And Enter newwindowFirstname as 'abc'
And Click on Find Leads
And Click on first lead in the lead list
And Navigate to parent1 window
Then Click on Merge button
And Handle Alert
And Click on FindLead
And Enter the stored LeadID 
And Click on Find Leads
Then Page with no records should be displayed