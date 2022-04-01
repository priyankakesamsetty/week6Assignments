Feature: Delete Lead
Background:
Given A Chrome browser is launched
#And Load the Leaftaps url
And Load the Leaftaps url 'http://leaftaps.com/opentaps/'
And Maximize the browser

Scenario: Delete Lead
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And The Login button is clicked
Given Click on CRMSFA link
Then The Welcome Page should be displayed
And Click on Leads
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