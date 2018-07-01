package stepdefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
	 WebDriver driver;
	 @Given("^Open the Chrome and launch the application$")					
	    public void open_the_Chrome_and_launch_the_application() throws Throwable							
	    {	
		 
		File file = new File("lib" + File.separator + "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
       driver.get("https://www.findmyfare.com/account/login");					
	    }		

	    @When("^Enter the Username and Password$")					
	    public void enter_the_Username_and_Password() throws Throwable 							
	    {		
	       driver.findElement(By.name("uname")).sendKeys("Test@gmail.com");							
	       driver.findElement(By.name("password")).sendKeys("Test@123#");							
	    }		

	    @Then("^login should be successful")					
	    public void login_should_be_successful() throws Throwable 							
	    {		
	       driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/input")).click();
	       driver.quit();
	    }		
	}	
	




