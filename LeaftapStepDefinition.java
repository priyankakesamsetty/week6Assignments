package Steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeaftapStepDefinition {
ChromeDriver driver;
String leadID;
	
	@Given("A Chrome browser is launched")
	public void ChromeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	
	@And("Load the Leaftaps url {string}")
	public void loadURL(String url)
	{
		driver.get(url);
	}
	
	@And("Maximize the browser")
	public void maximizeBrowser() 
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Given("Enter the username as {string}")
	public void userName(String userName) 
	{
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	
	@And("Enter the password as {string}")
	public void password(String password) 
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@When("The Login button is clicked")
	public void login() 
	{
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("The Welcome Page should be displayed")
	public void welcome()
	{
		System.out.println("Welcome to the Home Page");
	}
	
	@But("The error message is displayed")
	public void error()
	{
		System.out.println("Error on the page");
	}
	
	@When("Click on {string} link")
	public void crmsfaLink(String linktext)
	{
		driver.findElement(By.linkText(linktext)).click();
	}
	@Then("{string} page is displayed")
	public void verifypage(String pagename)
	{
		boolean displayed =driver.findElement(By.xpath("//div[text()='"+pagename+"']")).isDisplayed();
		System.out.println(displayed);
	}
	
	
	@And("Click on Create Lead")
	public void createlead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@And("Enter companyname as {string}")
	public void Companyname(String companyname)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
	}
	@And("Enter Firstname as {string}")
	public void Firstname(String firstname)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
	}
	@And("Enter lastname as {string}")
	public void Lastname(String lastname)
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
	}
	@And("click on submit button")
	public void Submit()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("lead should be created")
	public void leadCreated()
	{
		System.out.println("Lead");
	}
	
	@But("lead is not created")
	public void leadNotCreated()
	{
		System.out.println("Lead  Not Created");
	}
	@And("Click on FindLead")
	public void Findlead()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@And("Click on phone")
	public void Phone()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@And("Enter the phonenumber as {string}")
	public void EnterPhoneNumber(String phonenumber)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
	}
	@And("Click on Find Leads")
	public void ClickFindlead() throws InterruptedException
	{   
		Thread.sleep(100);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@Then("Click on first lead in the lead list")
	public void firstlead() throws InterruptedException
	{
		Thread.sleep(2000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@And("Click on Edit Lead")
	public void EditLead()
	{
		driver.findElement(By.linkText("Edit")).click();
	}
	@And("Enter the companyname as {string}")
	public void companyname(String companyname)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
	}
	@And("Click on update button")
	public void submit()
	{
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("View lead page is displayed")
	public void viewlead()
	{
		driver.findElement(By.xpath("//div[text()[normalize-space()='View Lead']]"));
	}
	@And("Enter the stored LeadID")
	public void LeadID()
	{
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}
	@And("Click on Delete")
	public void Delete()
	{
		driver.findElement(By.linkText("Delete")).click();
	}
	@Then("Page with no records should be displayed")
	public void noRecords()
	{
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
	//Duplicate lead
	@And("Click on Duplicate button")
	public void Duplicatelead()
	{
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@And("Click on Createlead button")
	public void createduplicatelead()
	{
		
		driver.findElement(By.name("submitButton")).click();
	}
	@And("Click on MergeLeads")
	public void MergeLead()
	{
			driver.findElement(By.linkText("Merge Leads")).click();
	}
	@And("Click on From_lead icon")
	public void From_leadicon()
	{
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();	
	}
	List <String> allhandles;
	@Then("Handle new From window")
	public void Fromwindow()
	{
		
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}
	@And("Enter newwindowFirstname as {string}")
	public void firstnameinfromwindow(String firstname)
	{
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
	}
   @And("Navigate to parent window")
    public void parentwindow()
    {
	   driver.switchTo().window(allhandles.get(0));
	}
   @And("Click on ToLead icon")
   public void ToLead()
	{
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}
   List<String> allhandles2;
   @Then("Handle new To window")
   public void newwindow()
   {
   	Set<String> allWindows2 = driver.getWindowHandles();
		allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
   }
   @And("Navigate to parent1 window")
   public void parent1window()
   {
	   driver.switchTo().window(allhandles2.get(0));
   }
   @Then("Click on Merge button")
   public void Mergebutton()
    {
	   driver.findElement(By.xpath("//a[text()='Merge']")).click();
    }
   @And("Handle Alert")
   public void HandleAlert()
   {
	   driver.switchTo().alert().accept();
   }
	}

