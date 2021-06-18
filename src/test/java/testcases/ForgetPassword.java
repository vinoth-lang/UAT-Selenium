package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common_things.Before_After_Login;

public class ForgetPassword extends Before_After_Login {

	//Invalid Username
	@Test(priority = 1)
	public void Invalid_UName() throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println("FORGET PASSWORD VALIDATION BEGINS..");
		System.out.println("INVALID USERNAME VALIDATION");
		Thread.sleep(1000);
		WebElement forget_Pass = driver.findElement(By.linkText("Forgot Password"));
		forget_Pass.click();
		Thread.sleep(5000);
		WebElement pass_tab = driver.findElement(By.linkText("Password"));
		
		if (pass_tab.isEnabled()){
			System.out.println("Reset Password Window Loaded Successfully");
		}
		else {
			System.out.println("Reset Password Window Loading Failed");
		}
			Thread.sleep(5000);
			WebElement usrname = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='email']"));
		usrname.sendKeys("tes456t");
		
		WebElement chk_btn = driver.findElement(By.xpath("//form[@id='passwordForm']//input[@id='check']"));
		chk_btn.click();
		Thread.sleep(5000);
		WebElement reset_pass = driver.findElement(By.xpath("//button[contains(text(),'Reset Password')]"));
		reset_pass.click();	
		
		Thread.sleep(5000);
		
		WebElement msg_warn = driver.findElement(By.xpath("//body/app-root[1]/div[2]/p[1]"));
		msg_warn.click();
		System.out.println("Invalid Username Validation Success:"+ msg_warn.getText());	
				
		Thread.sleep(5000);
		driver.navigate().refresh();	
	}
	
	//Valid Username
	@Test(priority = 2)

	public void Valid_UName() throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println("VALID USERNAME VALIDATION");
		
		WebElement forget_Pass1 = driver.findElement(By.linkText("Forgot Password"));
		forget_Pass1.click();
		Thread.sleep(3000);
		WebElement pass_tab1 = driver.findElement(By.linkText("Password"));
		if (pass_tab1.isEnabled()) {
			System.out.println("Reset Password Window Loaded Successfully");
		}
		else {
			System.out.println("Reset Password Window Loading Failed");
		}
			Thread.sleep(5000);
			WebElement usrname1 = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='email']"));
			usrname1.sendKeys("vinoth");

		WebElement chk_btn1 = driver.findElement(By.xpath("//form[@id='passwordForm']//input[@id='check']"));
			chk_btn1.click();
			Thread.sleep(5000);
			WebElement reset_pass1 = driver.findElement(By.xpath("//button[contains(text(),'Reset Password')]"));
			reset_pass1.click();	
				Thread.sleep(5000);
			WebElement msg_warn1 = driver.findElement(By.xpath("//body/app-root[1]/div[1]/p[1]"));
			msg_warn1.click();
			System.out.println("Valid Username Validation Success:"+msg_warn1.getText());			
		Thread.sleep(5000);
		driver.navigate().refresh();
	
}
	//Empty Fields
	@Test(priority = 3)

	public void Empty_Fields() throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println("EMPTY USERNAME VALIDATION");

		
		WebElement forget_Pass2 = driver.findElement(By.linkText("Forgot Password"));
		forget_Pass2.click();
		Thread.sleep(5000);
		WebElement pass_tab2 = driver.findElement(By.linkText("Password"));
		if (pass_tab2.isEnabled()) {
			System.out.println("Reset Password Window Loaded Successfully");
		}
		else {
			System.out.println("Reset Password Window Loading Failed");
		}
		Thread.sleep(5000);	
		WebElement usrname2 = driver.findElement(By.xpath("//div[@class='form-group']//input[@id='email']"));
		usrname2.sendKeys("");
		Thread.sleep(5000);
		WebElement chk_btn2 = driver.findElement(By.xpath("//form[@id='passwordForm']//input[@id='check']"));
		chk_btn2.click();		
		Thread.sleep(5000);
		WebElement reset_pass2 = driver.findElement(By.xpath("//button[contains(text(),'Reset Password')]"));
		if (reset_pass2.isEnabled()) {
			
			System.out.println("Empty Field Validation Failed" );
		}
		else
		{
			WebElement msg1_warn = driver.findElement(By.xpath("//div[contains(text(),'! Please enter valid username')]"));
			msg1_warn.click();
			System.out.println("Empty Field Validation Success: " +  msg1_warn.getText());	
		}
						
		Thread.sleep(1000);
		

	}
		
		
}