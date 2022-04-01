Feature: Editlead of Leaftaps
Background: 
Given A Chrome browser is launched
#And Load the Leaftaps url
And Load the Leaftaps url 'http://leaftaps.com/opentaps/'
And Maximize the browser

Scenario Outline: TC004 DuplicateLead

Given Enter the username as <username>
And Enter the password as <password>
When The Login button is clicked
Given Click on CRMSFA link
Then The Welcome Page should be displayed
Given Click on Leads 
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
