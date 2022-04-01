Feature: Editlead of Leaftaps
Background: 
Given A Chrome browser is launched
#And Load the Leaftaps url
And Load the Leaftaps url 'http://leaftaps.com/opentaps/'
And Maximize the browser

Scenario Outline: TC002 Edit Lead

Given Enter the username as <username>
And Enter the password as <password>
When The Login button is clicked
Given Click on 'CRMSFA link
Then The Welcome Page should be displayed
Given Click on Leads 
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


