package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common_things.Before_After_Login;

public class ForgetUsername extends Before_After_Login {

	// VALID EMAIL
	@Test(priority = 1)
	public void Valid_email() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("FORGET USERNAME VALIDATION BEGINS..");
		System.out.println("VALID EMAIL VALIDATION");

		WebElement forget_uname = driver.findElement(By.linkText("Forgot Username"));
		forget_uname.click();

		Thread.sleep(5000);
		WebElement uname_tab = driver
				.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]"));

		if (uname_tab.isEnabled()) {
			System.out.println("Reset Password Window Loaded Successfully");
		} else {
			System.out.println("Reset Password Window Loading Failed");
		}

		WebElement email_id = driver.findElement(By.id("email1"));
		email_id.sendKeys("vinoth.x@intulogic.in");

		WebElement chkbox_id = driver.findElement(By.xpath("//form[@id='loginIdForm']//input[@id='check']"));
		chkbox_id.click();

		WebElement sub_button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		sub_button.click();
		Thread.sleep(5000);
		WebElement Tmsg_warn = driver.findElement(By.xpath("//body/app-root[1]/div[1]"));
		Tmsg_warn.click();
		System.out.println("Valid Email Validation Success: " + Tmsg_warn.getText());

		Thread.sleep(5000);

		driver.navigate().refresh();
	}

//INVALID EMAIL
	@Test(priority = 2)
	public void Invalid_email() throws InterruptedException {

		Thread.sleep(5000);
		System.out.println("INVALID EMAIL VALIDATION");

		WebElement forget_ukey = driver.findElement(By.linkText("Forgot Username"));
		forget_ukey.click();

		Thread.sleep(5000);
		WebElement uname_tabmenu = driver
				.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]"));

		if (uname_tabmenu.isEnabled()) {
			System.out.println("Reset Password Window Loaded Successfully");
		} else {
			System.out.println("Reset Password Window Loading Failed");
		}

		Thread.sleep(3000);

		WebElement email_name = driver.findElement(By.id("email1"));
		email_name.sendKeys("nila@gmail.com");
		Thread.sleep(1000);
		WebElement chkbox_name = driver.findElement(By.xpath("//form[@id='loginIdForm']//input[@id='check']"));
		chkbox_name.click();
		Thread.sleep(1000);
		WebElement sub_clik = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		sub_clik.click();

		WebElement Tmsg_alert = driver.findElement(By.xpath("//body/app-root[1]/div[2]"));

		System.out.println("Invalid Email");

		System.out.println("InValid Email Validation Success " + Tmsg_alert.getText());

		Thread.sleep(5000);

	}

//EMPTY EMAIL
	@Test(priority = 3)
	public void empty_email() throws InterruptedException {

		Thread.sleep(5000);

		System.out.println("EMPTY EMAIL VALIDATION");

		WebElement empty_uname = driver.findElement(By.linkText("Forgot Username"));
		empty_uname.click();

		Thread.sleep(1000);
		WebElement empty_tab2 = driver
				.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]"));

		if (empty_tab2.isEnabled()) {
			System.out.println("Reset Password Window Loaded Successfully");
		} else {
			System.out.println("Reset Password Window Loading Failed");
		}

		Thread.sleep(1000);
		WebElement email_empty = driver.findElement(By.id("email1"));
		email_empty.clear();
		Thread.sleep(1000);

		email_empty.sendKeys("   ");
		Thread.sleep(5000);
		WebElement chkbox_empty = driver.findElement(By.xpath("//form[@id='loginIdForm']//input[@id='check']"));
		chkbox_empty.click();
		Thread.sleep(5000);
		WebElement sub_butemp = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));

		Thread.sleep(5000);
		if (sub_butemp.isEnabled()) {

			System.out.println("Empty Field Validation Failed");
		} else {
			WebElement msgalt_warn = driver.findElement(By.xpath("//div[contains(text(),'! Email is required')]"));
			msgalt_warn.click();
			System.out.println("Empty Field Validation Success: " + msgalt_warn.getText());
		}

		Thread.sleep(5000);

	}

}
