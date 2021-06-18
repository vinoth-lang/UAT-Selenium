package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common_things.Before_After_Login;

public class Tcare_Login_Testcase extends Before_After_Login {

	// validation give user name & password empty


	//Empty Fields Validation	
	@Test(priority = 1)
	public void Empty_Fields_login() throws InterruptedException {
		
		Thread.sleep(8000);
		
		System.out.println("LOGIN VALIDATION BEGINS...");
		
		System.out.println("1. EMPTY FIELDS LOGIN VALIDATION");		
		
		WebElement empty_click = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		empty_click.click();
		
		Thread.sleep(1000);
		WebElement warn_usmsg = driver.findElement(By.xpath("//*[@id='UserLoginForm']/div[1]/div[2]"));
		warn_usmsg.click();
		Thread.sleep(1000);
		WebElement warn_pwdmsg = driver.findElement(By.xpath("//*[@id='UserLoginForm']/div[1]/div[4]"));
		warn_pwdmsg.click();

		if (warn_usmsg.isDisplayed() && warn_pwdmsg.isDisplayed()) {
			System.out.println(warn_usmsg.getText());
			System.out.println(warn_pwdmsg.getText());
			System.out.println("Empty Username/Password Fields Login Validation Success");
			
		} else {
			System.out.println("Empty Username/Password Fields Login Validation Failed");
		}

		Thread.sleep(1000);
	}
	
	//Empty Password Field Validation
		@Test(priority = 2)
		public void Empty_password_login() throws InterruptedException

		{
			Thread.sleep(1000);
			System.out.println("2. EMPTY PASSWORD FIELD LOGIN VALIDATION");
			

			WebElement valid_ukey = driver.findElement(By.id("email"));
			valid_ukey.sendKeys("vinoth");
			
			
			
			WebElement key_click = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
			key_click.click();
			
			Thread.sleep(5000);	
			WebElement warn_pwdmsg = driver.findElement(By.xpath("//*[@id='UserLoginForm']/div[1]/div[3]"));
			warn_pwdmsg.click();
			
			if (warn_pwdmsg.isDisplayed()) {
			System.out.println("Empty Password Field Login Validation Success: " + warn_pwdmsg.getText() );
			}
			else {
				System.out.println("Empty Password Field Login Validation Failed");	
			}
			
			Thread.sleep(1000);
			valid_ukey.clear();
			
			Thread.sleep(5000);

		}
	
	// Incorrect Fields Validation
	@Test(priority = 3)
	public void Incorrect_fields_login() throws InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("3. INCORRECT FIELDS LOGIN VALIDATION");
		
		WebElement incorrect_uname = driver.findElement(By.id("email"));
		incorrect_uname.sendKeys("vinothsb");
		WebElement incorrect_pwd = driver.findElement(By.id("password"));
		incorrect_pwd.sendKeys("anto#12344");

		WebElement login_btn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		login_btn.click();
		
        Thread.sleep(2000);
		WebElement warn_altmsg = driver.findElement(By.xpath("/html/body/app-root/div[2]"));
		warn_altmsg.click();	

		if (warn_altmsg.isDisplayed()) {
			System.out.println("Incorrect Username/Password Login Validation Success: " + warn_altmsg.getText());
		} else {
			System.out.println("Incorrect Username/Password Login Validation Failed");
		}
		Thread.sleep(1000);
		incorrect_uname.clear();
		incorrect_pwd.clear();
		Thread.sleep(2000);
	}

	//Invalid Username field Validation
	@Test(priority = 4)
	public void Invalid_username_login() throws InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("4. INVALID USERNAME FIELD LOGIN VALIDATION");
		

		WebElement invalid_uname = driver.findElement(By.id("email"));
		invalid_uname.sendKeys("vinothuat123");
		WebElement valid_paword = driver.findElement(By.id("password"));
		valid_paword.sendKeys("Pass@123");

		WebElement button = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		button.click();
		Thread.sleep(2000);
		WebElement warn_altmsg = driver.findElement(By.xpath("/html/body/app-root/div[2]"));
		warn_altmsg.click();

		if (warn_altmsg.isDisplayed()) {
			System.out.println("Invalid Username Login Validation Success: " + warn_altmsg.getText());
		} else {
			System.out.println("Invalid Username Login Validation Failed");
		}
		Thread.sleep(1000);

		invalid_uname.clear();
		valid_paword.clear();
		Thread.sleep(2000);
		
	}

	// Invalid Password Field Validation

	@Test(priority = 5)
	public void Invalid_password_login() throws InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("5. INVALID PASSWORD FIELD LOGIN VALIDATION");
		
		WebElement valid_uname = driver.findElement(By.id("email"));
		valid_uname.sendKeys("vinoth");
		WebElement invalid_pass = driver.findElement(By.id("password"));
		invalid_pass.sendKeys("anto");

		WebElement inv_button = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		inv_button.click();
		Thread.sleep(2000);
		
		WebElement warn_altmsg = driver.findElement(By.xpath("/html/body/app-root/div[2]"));
		warn_altmsg.click();

		if (warn_altmsg.isDisplayed()) {
			System.out.println("Invalid Password Login Validation Success: " + warn_altmsg.getText());
		} else {
			System.out.println("Invalid Password Login Validation Failed");
		}
		Thread.sleep(1000);
		valid_uname.clear();
		invalid_pass.clear();
		Thread.sleep(1000);
		
	}
	
	// Valid Username & Password Validation

	@Test(priority = 6)
	public static void Valid_TCARE_login() throws InterruptedException {
		
		
		Thread.sleep(5000);
		System.out.println("6. VALID FIELDS LOGIN VALIDATION");
		
		WebElement valid_usr = driver.findElement(By.id("email"));
		 valid_usr.clear();
		valid_usr.sendKeys("deepa");

		WebElement valid_pwd = driver.findElement(By.id("password"));
		valid_pwd.clear();
		valid_pwd.sendKeys("Pass@123");

		// validate alert
				try {
					WebElement click_login_btn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
					click_login_btn.click();
					WebDriverWait wait = new WebDriverWait(driver, 50);
				    wait.until(ExpectedConditions.alertIsPresent());
					Alert alert111 = driver.switchTo().alert();
					alert111.accept();
					System.out.println("Login Alert accepted");
					Thread.sleep(1000);
					WebElement click_user1 = driver.findElement(By.xpath("/html/body/app-root/div[1]"));
					click_user1.click();
					System.out.println(click_user1.getText());
				} 	catch (Exception e) {
					e.printStackTrace();
				}
				
				Thread.sleep(20000);
				if(driver.findElement(By.xpath("//h3[contains(text(),'DASHBOARD')]")).isDisplayed()) {
					System.out.println("Valid Username/Password Login Validation Success: ");	
				}else {
					System.out.println("Valid Username/Password Login Validation Failed");	
				}
				Thread.sleep(5000);
			}
	
	// Logout Validation
	@Test(priority = 7)
	public static void TCARE_Logout() throws InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("7. LOGOUT VALIDATION");
		
		
		WebElement click_user1 = driver.findElement(By.xpath("//span[@data-toggle='modal']"));
		click_user1.click();
		
		Thread.sleep(2000);
		
		WebElement click_logout = driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
		click_logout.click();
		Thread.sleep(2000);
		WebElement login_pg = driver.findElement(By.id("email"));
		login_pg.click();
		if (login_pg.isDisplayed()) {
			System.out.println("Logout Validation Success");
		}
		else {
			System.out.println("Logout Validation Failed");
		}
		

	}


}
