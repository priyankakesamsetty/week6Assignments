package retryAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RetryAnalyzer extends BaseClass{
	@Test(priority = -1, retryAnalyzer = RetryFailedcases.class)
	public void createIncident() throws InterruptedException
	{
		//2. Login with valid credentials
		 // 2.1. Check for frame
		 WebElement frame = driver.findElement(By.id("gsft_main"));
		 driver.switchTo().frame(frame);
		 
		 // 2.2. Enter username 
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 
		 // 2.3. Enter password 
		 driver.findElement(By.id("user_password")).sendKeys("HjeS4XrQw=6*");
		 
		 // 2.4. Enter login
		 driver.findElement(By.id("sysverb_login")).click();		 
		 Thread.sleep(2000);
		 
		//3. Enter Incident in filter navigator and press enter"
		 // 3.1. Search “incident “ Filter Navigator
		 driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		 
		//4. Click on Create new option and fill the mandatory fields
		 //4.1. Click on create new option
		 driver.findElement(By.xpath("//div[text()='Create New']")).click();
		 Thread.sleep(2000);
		 
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);
		  
		 //4.3. Select a value for Caller from another window list
		 driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		 
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		 
		 // Switch to new window
		 driver.switchTo().window(windowHandlesList.get(1));
		 Thread.sleep(2000);
		 
		 //4.4. Select a value for Caller 
		 driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		 
		 // Switch back to old window and frame
		 driver.switchTo().window(windowHandlesList.get(0));
		 driver.switchTo().frame(0);
		 Thread.sleep(2000);
		 
		 //4.5. Enter value for short_description
		 driver.findElement(By.xpath("//input[@aria-label = 'Short description']")).sendKeys("Issue with a web page");
		 		 
		 //4.6. Read the incident number and save it a variable
		 String text = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		 System.out.println("Number: "+ text);
		 
		 //4.7. Click on Submit button
		 driver.findElement(By.id("sysverb_insert_bottom")).click();
		 Thread.sleep(2000);
		 
		//5. Verify the newly created incident
		 //5.1. Search the same incident number in the next search screen
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(text,Keys.ENTER);
		 Thread.sleep(2000);
		 
		 //5.2. Verify the incident is created successful
		 String text2 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		 
		 if(text.equals(text2))
		 {
			 System.out.println("Incident is created successfully");
			 incident = text2;
		 }
		 else
		 {
			 System.out.println("Incident is not created successfully");
		 }	
		 
		 throw new NoSuchElementException();
	}
	
	@Test(priority = 0)
	public void updateIncident() throws InterruptedException
	{
		//2. Login with valid credentials
		 // 2.1. Check for frame
		 WebElement frame = driver.findElement(By.id("gsft_main"));
		 driver.switchTo().frame(frame);
		 
		 // 2.2. Enter username 
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 
		 // 2.3. Enter password 
		 driver.findElement(By.id("user_password")).sendKeys("Raja@1985");
		 
		 // 2.4. Enter login
		 driver.findElement(By.id("sysverb_login")).click();		 
		 Thread.sleep(2000);
		 
		//3. Enter Incident in filter navigator and press enter"
		 // 3.1. Search “incident “ Filter Navigator
		 driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		 
		//4. Search for the existing incident and click on the incident
		 // 4.1. Search the existing incidents
		 driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		 Thread.sleep(2000);
		 
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);

		 //4.4. Search for existing incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 Thread.sleep(2000);
		 
		//4.3. Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 Thread.sleep(2000);
		 
		//5. Update the incidents with Urgency as High and State as In Progress
		 //5.1. Update the incidents with Urgency as High 
		 
		 Select dd1 = new Select(driver.findElement(By.id("incident.urgency")));
		 dd1.selectByValue("1");
		 Thread.sleep(2000);
		 
		 //5.2. State as In Progress
		 Select dd2 = new Select(driver.findElement(By.id("incident.state")));
		 dd2.selectByValue("2");
		 Thread.sleep(2000);
		 
		 //5.3. Work notes
		 driver.findElement(By.xpath("(//textarea[@placeholder='Work notes'])[1]")).sendKeys("Incident Update");
		  
		 //5.4. Click Update
		 driver.findElement(By.id("sysverb_update_bottom")).click();
		 Thread.sleep(2000);
		 
		 //5.5. Search the same incident number in the next search screen
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 Thread.sleep(2000);
		 
		 //5.6. Click on incident 
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 Thread.sleep(2000);
		 
		//6. Verify the priority and state
		 //6.1. Verify the urgency
		 String urgency = driver.findElement(By.xpath("//select[@name='incident.urgency']/option[@selected='SELECTED']")).getText();
		 if(urgency.contains("High"))
		 {
			 System.out.println("Urgency is : " + urgency);
		 }
		 else
		 {
			 System.out.println("Urgency is not : High");
		 }
		 
		//6.2. Verify the state
		 String state = driver.findElement(By.xpath("//select[@name='incident.state']/option[@selected='SELECTED']")).getText();
		 if(state.contains("Progress"))
		 {
			 System.out.println("State is : " + state);
		 }
		 else
		 {
			 System.out.println("State is not : In Progress");
		 }
	}
	
	@Test(priority = 1)
	public void assignIncident() throws InterruptedException
	{
		//2. Login with valid credentials
		 // 2.1. Check for frame
		 WebElement frame = driver.findElement(By.id("gsft_main"));
		 driver.switchTo().frame(frame);
		 
		 // 2.2. Enter username 
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 
		 // 2.3. Enter password 
		 driver.findElement(By.id("user_password")).sendKeys("Raja@1985");
		 
		 // 2.4. Enter login
		 driver.findElement(By.id("sysverb_login")).click();		 
		 Thread.sleep(2000);
		 
		//3. Enter Incident in filter navigator and press enter"
		 // 3.1. Search “incident “ Filter Navigator
		 driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		 
		//4. click on open and Search for the existing incident and click on  the incident
		 //4.1 click on open
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);

		 //4.4 Search for existing incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 
		 //4.3 Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 
		//5. Assign the incident to  Software group
		 driver.findElement(By.name("lookup.incident.assignment_group")).click();
		 
		 Thread.sleep(3000);
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> windowHandlesList = new ArrayList<String> (windowHandles);
		 
		 // Switch to new window
		 driver.switchTo().window(windowHandlesList.get(1));
		 Thread.sleep(4000);
		 
		 //5.1. Search for Software
		 driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Software",Keys.ENTER);
		 Thread.sleep(2000);
		 
		 //5.2. Click on Software
		 driver.findElement(By.xpath("//a[text()='Software']")).click();
		 Thread.sleep(2000);
		 
		 // Switch back to old window and frame
		 driver.switchTo().window(windowHandlesList.get(0));
		 driver.switchTo().frame(0);
		 Thread.sleep(2000);
		 
		 //6. Update the incident with Work Notes 
		 driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Incident Assigned");
		 Thread.sleep(2000);
		 
		//7. Verify the Assignment group and Assigned for the incident
		 //7.1. Click Update
		 driver.findElement(By.id("sysverb_update_bottom")).click();
		 Thread.sleep(2000);

		 //7.2. Search Incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 
		 //7.3. Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 
		 //7.4 Verify the Assignment group
		 String text = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		 System.out.println(text);
		 
		 if(text.contains("Software"))
		 {
			 System.out.println("Assignment group verified successfully");
		 }
		 else
		 {
			 System.out.println("Assignment group not verified successfully");
		 }
		 
		 String text2 = driver.findElement(By.xpath("(//span[@class='sn-widget-textblock-body sn-widget-textblock-body_formatted'])[1]")).getText();
		 System.out.println(text2);
		 
		 if(text2.contains("Incident"))
		 {
			 System.out.println("Work Notes verified successfully");
		 }
		 else
		 {
			 System.out.println("Work Notes not verified successfully");
		 } 
	}
	
	@Test(priority = 2)
	public void deleteIncident() throws InterruptedException
	{
		//2. Login with valid credentials
		 // 2.1. Check for frame
		 WebElement frame = driver.findElement(By.id("gsft_main"));
		 driver.switchTo().frame(frame);
		 
		 // 2.2. Enter username 
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 
		 // 2.3. Enter password 
		 driver.findElement(By.id("user_password")).sendKeys("Raja@1985");
		 
		 // 2.4. Enter login
		 driver.findElement(By.id("sysverb_login")).click();		 
		 Thread.sleep(2000);
		 
		//3. Enter Incident in filter navigator and press enter"
		 // 3.1. Search “incident “ Filter Navigator
		 driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		 
		//4. Search for the existing incident and navigate into the incident
		 // 4.1. Search the existing incidents
		 driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		 Thread.sleep(2000);
		 
		 //4.2. Switch to frame
		 driver.switchTo().frame(0);

		 //4.4 Search for existing incident
		 driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident,Keys.ENTER);
		 
		 //4.3 Click on incident
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 
		//5. Delete the incident
		 driver.findElement(By.id("sysverb_delete_bottom")).click(); 
		 Thread.sleep(2000);
		 
		 //5.1. Confirm Delete 
		 driver.findElement(By.id("ok_button")).click();
		 Thread.sleep(2000);
		 
		//6. Verify the deleted incident
		 String text = driver.findElement(By.xpath("//td[@colspan='13']")).getText();
		 System.out.println(text);
		 
		 if(text.contains("No records to display"))
		 {
			 System.out.println("Incident deleted successfully");
		 }
		 else
		 {
			 System.out.println("Incident not deleted successfully");
		 }
		 
		 throw new NoSuchElementException();
	}
}
