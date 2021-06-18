package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common_things.Before_After_Login;

public class Userblock_Scenerio extends Before_After_Login{
	

	/**
	 * Logic for Clicking 5 times 
	 * @throws InterruptedException
	 */

	@Test(priority = 1)
	public void authentication_error() throws InterruptedException {

		WebElement uname = driver.findElement(By.id("email"));
		WebElement upass = driver.findElement(By.id("password"));
		WebElement uclick = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		
		for (int i = 0; i <= 5; i++) {
			uname.sendKeys("vinoth");
			upass.sendKeys("pass");
			uclick.click();			
			Thread.sleep(2000);			
			WebElement userblock_notification =  driver.findElement(By.xpath("//body/app-root[1]/div[2]"));
			userblock_notification.click();
			Thread.sleep(1000);
			boolean lot = userblock_notification.isDisplayed();
			if(lot) {
			System.out.println("Wrong UserName:"+userblock_notification.getText());
			}
			else {
				System.out.println("UserName&Password:Notification not Captured");	
			}	
			Thread.sleep(2000);
			uname.clear();
			upass.clear();
	
			
		}
/**
 * Verified & Print  UserBlcok Notification Msg		
 */
		
		WebElement User_Block_Msg = driver.findElement(By.xpath("//body/app-root[1]/div[2]"));
		User_Block_Msg.click();

		if (User_Block_Msg.isDisplayed())
		{
			System.out.println("User Block Msg:"+User_Block_Msg.getText());
		}
		else 
		{
			System.out.println("Getting Error");
		}
		Thread.sleep(2000);
			
	}
	

	@Test(priority = 2)

	public void click_here() throws InterruptedException {

		WebElement click_link = driver.findElement(By.xpath("//span[@class='link']"));
		click_link.click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 3)
	public void unblock() throws InterruptedException {

		WebElement verify_email = driver.findElement(By.id("email"));
		verify_email.sendKeys("vinoth.x@intulogic.in");
	
		WebElement check = driver.findElement(By.id("check"));
		check.click();
	
		WebElement verify_id = driver.findElement(By.xpath("//button[@class='btn btn-primary col-8']"));
		verify_id.click();

		Thread.sleep(1000);
		
		WebElement userblock=  driver.findElement(By.xpath("body:nth-child(2) app-root:nth-child(1) div.custom-notification.error:nth-child(2) > p:nth-child(1)"));
		boolean lot_un = userblock.isDisplayed();
		if(lot_un) {
		System.out.println("UserUnblock:"+userblock.getText());
		}
		else {
			System.out.println("Getting Error");	
		}
			
		Thread.sleep(5000);
	}	
}
