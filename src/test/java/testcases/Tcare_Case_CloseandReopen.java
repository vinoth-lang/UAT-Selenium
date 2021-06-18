package testcases;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import common_things.Before_After_Login;

public class Tcare_Case_CloseandReopen extends Before_After_Login {
	// Login
	@Test(priority = 1)
	public static void Tcare_login_case() throws InterruptedException {

		Tcare_Login_Testcase.Valid_TCARE_login();
		Thread.sleep(8000);
	}

	// CLOSE CASE
	@Test(priority = 2)
	public static void Tcare_CloseandReopen_case() throws InterruptedException {

		Thread.sleep(1000);
		String[] case1_id = new String[5];
		String[] case_status = new String[5];
		System.out.println("CLOSE CASE PROCESS BEGINS..");
		Thread.sleep(8000);
		WebElement caseList_Icon = driver.findElement(By.xpath("//i[@class='fas fa-suitcase']"));
		caseList_Icon.click();
		Thread.sleep(10000);

		WebElement case_table = driver.findElement(By.tagName("mat-table"));
		List<WebElement> rows_table = case_table.findElements(By.tagName("mat-row"));
		int rows_count = rows_table.size();

		for (int i = 0; i < 2; i++) {
			List<WebElement> Columns_row = rows_table.get(i).findElements(By.tagName("mat-cell"));
			int columns_count = Columns_row.size();
			List<WebElement> chk_list = driver.findElements(By.xpath("//label[@class='mat-checkbox-layout']"));
			int chk_count = chk_list.size();

			chk_list.get(i).click();
			case1_id[i] = Columns_row.get(0).getText();
			case_status[i] = Columns_row.get(7).getText();
			System.out.println("Case" + case1_id[i] + " is closed, " + " It's in " + case_status[i] + " Status ");

		}

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(8000);

		WebElement closecase_btn = driver.findElement(By.xpath("//button[contains(text(),'Close Case')]"));
		closecase_btn.click();

		Thread.sleep(5000);

		WebElement reason_options = driver.findElement(By.xpath("//select[@formcontrolname='reasonForClose']"));
		Select reason_sel = new Select(reason_options);
		List<WebElement> reason_list = reason_sel.getOptions();
		int riCnt = reason_list.size();
		int riSelect = ThreadLocalRandom.current().nextInt(1, riCnt - 1);

		reason_list.get(riSelect + 1).click();
		String sel_value = reason_options.getAttribute("value");
		System.out.println("Selected Reason: " + reason_options.getAttribute("value"));

		if (sel_value == "110") {
			Thread.sleep(2000);
			WebElement text_110 = driver.findElement(By.xpath("//input[@type='text']"));
			text_110.click();
			text_110.sendKeys("tested");
		}

		Thread.sleep(8000);

		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		Thread.sleep(1000);

		WebElement close_altmsg = driver.findElement(By.xpath("//body/app-root[1]/div[1]/p[1]"));
		close_altmsg.click();

		System.out.println(close_altmsg.getText());

		Thread.sleep(5000);
		closedCase_validation(case1_id);
		Thread.sleep(5000);
		ReopenedCase_validation(case1_id, case_status);

	}

	// VALIDATION OF CLOSED CASES

	public static void closedCase_validation(String[] cases_id) throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("CLOSED CASE VALIDATION BEGINS..");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(8000);

		WebElement ClosedCASE_Tab = driver.findElement(By.xpath("//a[contains(text(),'Closed Cases')]"));
		ClosedCASE_Tab.click();
		Thread.sleep(10000);

		WebElement srch_field = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		srch_field.click();
		for (int i = 0; i < 2; i++) {
			Thread.sleep(2000);
			String caseid1 = cases_id[i].substring(4, 8);
			srch_field.sendKeys(caseid1);

			Thread.sleep(3000);
			WebElement case_findid = driver.findElement(By.xpath("//a[contains(text(), '" + caseid1 + "')]"));
			if (case_findid.isDisplayed()) {
				System.out.println("Case " + caseid1 + " is displayed in the 'CLOSED CASE' - Verified");
			}
			Thread.sleep(1000);
			WebElement Reopen_caseid = driver.findElement(By.xpath(
					"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-caselist[1]/div[1]/div[1]/div[1]/div[2]/div[2]/mat-table[1]/mat-row[1]/mat-cell[1]/div[1]/div[1]/mat-checkbox[1]/label[1]/div[1]"));
			Reopen_caseid.click();
			srch_field.clear();
			Thread.sleep(3000);
		}
		
		System.out.println("REOPENED CASE VALIDATION BEGINS..");

		Thread.sleep(5000);
		WebElement btn_reopen = driver.findElement(By.xpath("//button[contains(text(), 'Reopen')]"));
		btn_reopen.click();
		System.out.println("Button Clicked....");
        Thread.sleep(5000);
		WebElement reopen_altmsg = driver.findElement(By.xpath("//body/app-root[1]/div[1]/p[1]"));
		reopen_altmsg.click();

		System.out.println(reopen_altmsg.getText());

	}

	// VALIDATION OF REOPENED CASES

	public static void ReopenedCase_validation(String[] recases_id, String[] recases_status)
			throws InterruptedException {

		Thread.sleep(15000);
		String Reopen_id[] = new String[5];
		String Reopen_status[] = new String[5];

		WebElement AllCASE_Tab = driver.findElement(By.xpath("//a[contains(text(),'All Cases')]"));
		AllCASE_Tab.click();
		Thread.sleep(10000);

		WebElement srch1_field = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		srch1_field.click();
		for (int i = 0; i < 2; i++) {
			String caseid2 = recases_id[i].substring(4, 8);
			srch1_field.sendKeys(caseid2);
			Thread.sleep(10000);

			WebElement case_findid = driver.findElement(By.xpath("//a[contains(text(), '" + caseid2 + "')]"));
			Thread.sleep(8000);
			if (case_findid.isDisplayed()) {
				System.out.println("Case " + caseid2 + " is displayed in the 'ALL CASES' - Verified");
			}

			Thread.sleep(5000);
			WebElement case_table = driver.findElement(By.tagName("mat-table"));
			List<WebElement> rows_table = case_table.findElements(By.tagName("mat-row"));
			int rows_count = rows_table.size();

			Thread.sleep(3000);

			List<WebElement> Columns_row = rows_table.get(0).findElements(By.tagName("mat-cell"));
			int columns_count = Columns_row.size();
			List<WebElement> chk_list = driver.findElements(By.xpath("//label[@class='mat-checkbox-layout']"));
			int chk_count = chk_list.size();
			Thread.sleep(3000);

			Reopen_id[i] = Columns_row.get(0).getText();
			Reopen_status[i] = Columns_row.get(7).getText();
			System.out.println("Case" + Reopen_id[i] + " is Reopened, " + " it's in " + Reopen_status[i] + " Status ");

			srch1_field.clear();

			Thread.sleep(3000);

			Tcare_Login_Testcase.TCARE_Logout();
			Thread.sleep(5000);

		}

	}
}
