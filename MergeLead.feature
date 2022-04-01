Feature: Merge Lead

Background:
Given A Chrome browser is launched
#And Load the Leaftaps url
And Load the Leaftaps url 'http://leaftaps.com/opentaps/'
And Maximize the browser

Scenario: Merge lead
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When The Login button is clicked
Given Click on CRMSFA link
Then The Welcome Page should be displayed
And Click on Leads
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


