package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import common_things.Before_After_Login;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Normal_Low_High_Flow extends Before_After_Login {
	/**
	 * Login Scenario 
	 * UAT Server
	 * AND click to Add care Giver Button 
	 * @throws InterruptedException
	 */
	
	@Test(priority = 1)
// add care giver
	public void add_caregiver() throws InterruptedException {
		
		Tcare_Login_Testcase.Valid_TCARE_login();
		Thread.sleep(8000);

		WebElement click_Add_New = driver.findElement(By.xpath("//button[contains(text(),' Add New')]"));
		click_Add_New.click();		
		Thread.sleep(2000);
		Boolean US_tit = driver.findElement(By.xpath("//h5[contains(text(),'CAREGIVER')]")).isDisplayed();		
		if(US_tit) {
			System.out.println("Caregiver Demographic Form loaded sucessfully");
		}
		else {
			System.out.println("Caregiver Demographic Form loaded failed");
		}  		
		Thread.sleep(1000);
		
	}

	/***
	 * Validation  for  Required Field
	 * @throws InterruptedException
	 */
	@Test(priority = 2)

	public void mandatory() throws InterruptedException {
		Thread.sleep(2000);
		WebElement click_submit = driver.findElement(By.xpath("//button[@class='btn btn-primary col-sm-2']"));
		click_submit.click();		
	
        SoftAssert softAssert = new SoftAssert();
       
        WebElement Firstname = driver.findElement(By.xpath("//div[contains(text(),'First Name is required')]"));
        softAssert.assertEquals(Firstname.getText(), "First Name is required");
   
        WebElement LastName = driver.findElement(By.xpath("//div[contains(text(),'Last Name is required')]"));   
        softAssert.assertEquals(LastName.getText(), "Last Name is required");
       
        WebElement DOB = driver.findElement(By.xpath("//div[contains(text(),'Date of Birth is required')]"));       
        softAssert.assertEquals(DOB.getText(), "Date of Birth is required");       
       
        WebElement MobileNumber = driver.findElement(By.xpath("//div[contains(text(),'Mobile Number is required')]"));   
        softAssert.assertEquals(MobileNumber.getText(), "Mobile Number is required");
       
        WebElement State = driver.findElement(By.xpath("//div[contains(text(),'state is required')]"));   
        softAssert.assertEquals(State.getText(), "state is required");
       
        WebElement ZipCode = driver.findElement(By.xpath("//div[contains(text(),'zipcode is required')]"));   
        softAssert.assertEquals(ZipCode.getText(), "zipcode is required");   
        
        
        WebElement Relationship = driver.findElement(By.xpath("//select[@id='relationship']"));
        String Recolorcode = Relationship.getCssValue("border-bottom-color");
        String Reexpectedcolorcode = "rgba(220, 20, 60, 1)";        
        softAssert.assertEquals(Recolorcode, Reexpectedcolorcode);
       
        
        WebElement crfname = driver.findElement(By.xpath("//input[@id='crfirstName']"));
        String crcolorcode = crfname.getCssValue("border-bottom-color");
        String crexpectedcolorcode = "rgba(220, 20, 60, 1)";        
        softAssert.assertEquals(crcolorcode, crexpectedcolorcode);
        
        WebElement crlname = driver.findElement(By.xpath("//input[@id='crlastName']"));
        String crlcolorcode = crlname.getCssValue("border-bottom-color");
        String crlexpectedcolorcode = "rgba(220, 20, 60, 1)";        
        softAssert.assertEquals(crlcolorcode, crlexpectedcolorcode);
               
        System.out.println("Mandatary field validation success");
   
        softAssert.assertAll();          
       
        Thread.sleep(2000);
		
	}

/**
 * Create Case Scenario	& Validation on CareGiver Modules
 * @throws InterruptedException
 */

	@Test(priority = 3)
	// create case
	public void create_case() throws InterruptedException {
		
		
		Thread.sleep(1000);
		
		// CG FIRST NAME		
		WebElement fstname = driver.findElement(By.name("cgfirstName"));
		fstname.sendKeys("nivitha");	
		System.out.println("First Name: " + fstname.getAttribute("value"));
		Thread.sleep(1000);
		
		// CG MIDDLE NAME
		WebElement cgmidname = driver.findElement(By.name("cgmiddleName"));
		cgmidname.sendKeys("A");
		System.out.println("Middle Name: " + cgmidname.getAttribute("value"));
		Thread.sleep(1000);
		
		// CG LAST NAME
		WebElement lstname = driver.findElement(By.name("cglastName"));
		lstname.sendKeys("joseph");
		System.out.println("Last Name: " + lstname.getAttribute("value"));
		Thread.sleep(1000);
		
		// CG PREFERRED NAME
		WebElement prename = driver.findElement(By.name("preferredname"));
		prename.sendKeys("nivitha");
		System.out.println("Preferred Name: " + prename.getAttribute("value"));
		Thread.sleep(1000);
		
		// DATE PICKER
		WebElement selectdate = driver.findElement(By.name("dob"));
		selectdate.click();
		Boolean date_tit = driver.findElement(By.xpath("//body/bs-datepicker-container[1]")).isDisplayed();		
		if(date_tit) {
			System.out.println("Date picker displayed");			
			driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']")).sendKeys("10-12-1978");
		}
		else {
			System.out.println("Date picker failed");
		}  		
		selectdate.sendKeys(Keys.RETURN);
		System.out.println("DOB: " + selectdate.getAttribute("value"));
		Thread.sleep(2000);
		
		// SSN
		WebElement ssn = driver.findElement(By.name("ssn"));
		ssn.sendKeys("8523");
		System.out.println("SSN: " + ssn.getAttribute("value"));
		Thread.sleep(1000);
		
		//GENDER		
		WebElement sel_gender = driver.findElement(By.id("gender"));
		Select gensel = new Select(sel_gender);
		List <WebElement> gender_list = gensel.getOptions();
		 //Taking the count of items
		 int giCnt = gender_list.size();
		 //Using Random class to generate random values
		 Random gennum = new Random();
		 int giSelect = gennum.nextInt(giCnt);
		 //Selecting value from DropDownList
		 gensel.selectByIndex(giSelect);
		 //Selected Value
		 System.out.println("Gender: " + sel_gender.getAttribute("value"));
		 Thread.sleep(2000);
		 
		 //PRONOUNS
		 WebElement sel_pronoun = driver.findElement(By.id("pronouns"));
		 Select pnsel = new Select(sel_pronoun);
		 List <WebElement> pnlist = pnsel.getOptions();
		 int piCnt = pnlist.size();
		 Random pnnum = new Random();
		 int pniSelect = pnnum.nextInt(piCnt);
		 pnsel.selectByIndex(pniSelect);
		 System.out.println("Pronouns: " + sel_pronoun.getAttribute("value"));
		 Thread.sleep(2000); 	
		 
		//Race/Ethinicity
		WebElement sel_raceethinicity = driver.findElement(By.xpath("//select[@formcontrolname='raceEthnicity']"));
		Select racesel = new Select(sel_raceethinicity);
		List <WebElement> race_list = racesel.getOptions();
		 //Taking the count of items
		 int riCnt = race_list.size();
		 //Using Random class to generate random values
		 Random racenum = new Random();
		 int riSelect = racenum.nextInt(riCnt);
		 //Selecting value from DropDownList
		 racesel.selectByIndex(riSelect);
		 //Selected Value
		 System.out.println("Race/Ethnicity: " + sel_raceethinicity.getAttribute("value"));
		 Thread.sleep(1000);
		 
		//Martial status
		 WebElement sel_martial = driver.findElement(By.xpath("//select[@formcontrolname='maritalStatus']"));
		Select martsel = new Select(sel_martial);
		List <WebElement> martlist = martsel.getOptions();
		int miCnt = martlist.size();
		 Random martnum = new Random();
		 int miSelect = martnum.nextInt(miCnt);
		 martsel.selectByIndex(miSelect);
		 System.out.println("MartialStatus: " + sel_martial.getAttribute("value"));
		 Thread.sleep(3000);
		 
		//Education
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='educationLevel']")));
		 WebElement sel_education = driver.findElement(By.xpath("//select[@formcontrolname='educationLevel']"));
		Select edusel = new Select(sel_education);
		List <WebElement> edulist = edusel.getOptions();
		int eiCnt = edulist.size();
		 Random edunum = new Random();
		 int eiSelect = edunum.nextInt(eiCnt);
		 edusel.selectByIndex(eiSelect);
		 System.out.println("Education: " + sel_education.getAttribute("value"));
		  Thread.sleep(3000);

		  //Employment status
		 WebElement sel_employment = driver.findElement(By.xpath("//select[@formcontrolname='employment']"));
		Select empsel = new Select(sel_employment);
		List <WebElement> emplist = empsel.getOptions();
		int emiCnt = emplist.size();
		 Random empnum = new Random();
		 int emiSelect = empnum.nextInt(emiCnt);
		 empsel.selectByIndex(emiSelect);
		 System.out.println("Employment: " + sel_employment.getAttribute("value"));
		  Thread.sleep(2000);
		  
		//Household income
		 WebElement sel_holdincome = driver.findElement(By.xpath("//select[@formcontrolname='totalHouseHoldIncome']"));
		Select holdsel = new Select(sel_holdincome);
		List <WebElement> holdlist = holdsel.getOptions();
		int hiCnt = holdlist.size();
		 Random holdnum = new Random();
		 int hiSelect = holdnum.nextInt(hiCnt);
		 holdsel.selectByIndex(hiSelect);
		 System.out.println("Household Income: " + sel_holdincome.getAttribute("value"));
		 Thread.sleep(1000);
		 
		 //Language Preference
		 WebElement sel_langpref = driver.findElement(By.xpath("//select[@formcontrolname='langPreference']"));
		 Select langsel = new Select(sel_langpref);
		 langsel.selectByIndex(1);
		 System.out.println("Language: " + sel_langpref.getAttribute("value"));
		 Thread.sleep(1000);
		 		 
		 
		// phone number
		 WebElement phone = driver.findElement(By.name("phNumber"));
		phone.sendKeys("8122011743");
		System.out.println("MobilePhone: " + phone.getAttribute("value"));
		Thread.sleep(1000);
		
		// phone number
		 WebElement Homephone = driver.findElement(By.name("homePhone"));
		Homephone.sendKeys("4983242128");
		System.out.println("HomePhone: " + Homephone.getAttribute("value"));
		Thread.sleep(1000);
				
		//Email
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("");		
		System.out.println("Email: " + email.getAttribute("value"));
		Thread.sleep(2000);
		
		
		// check box
		WebElement chkBox = driver.findElement(By.xpath("//label[contains(text(),'Consented to be contacted')]"));
		Thread.sleep(1000);
		if (!chkBox.isSelected()) {
			chkBox.click();
			System.out.println("Consented to be contacted Toggled ON");
			// perform actions
		} else {
			// perform actions
			System.out.println("Consented to be contacted Toggled Off");
		}

		Thread.sleep(2000);
		// Address1
		WebElement addrr1 = driver.findElement(By.name("addressL1"));
		addrr1.sendKeys("#45");
		System.out.println("Address1: " + addrr1.getAttribute("value"));
		Thread.sleep(1000);
		
		//Address2
		WebElement addrr2 = driver.findElement(By.name("addressL2"));
		addrr2.sendKeys("NEW QUEEN ST");
		System.out.println("Address2: " + addrr2.getAttribute("value"));
		Thread.sleep(1000);
		
		// city
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Austin");
		System.out.println("City: " + city.getAttribute("value"));
		
		
		
		// state
		WebElement sel_state = driver.findElement(By.xpath("//select[@formcontrolname='state']"));
		Select stsel = new Select(sel_state);
		List <WebElement> stlist = stsel.getOptions();
		int siCnt = stlist.size();
		 Random stnum = new Random();
		 int siSelect = stnum.nextInt(siCnt);
		 stsel.selectByIndex(siSelect);
		 System.out.println("State: " + sel_state.getAttribute("value"));
		  Thread.sleep(2000);
		  
		 //Zipcode
		 WebElement zipcode = driver.findElement(By.name("zipCode"));
		zipcode.sendKeys("75001");
		System.out.println("Zipcode: " + zipcode.getAttribute("value"));
		Thread.sleep(1000);
		
		//Insurance Checkbox
		String gender_valid = sel_gender.getAttribute("value");
		
		
		if ( gender_valid.equals("Male")) {
			Thread.sleep(2000);
			WebElement sel_chk1 = driver.findElement(By.xpath("//span[contains(text(),'Medicaid')]"));
			WebElement chk1_obj = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']"));
			chk1_obj.click();
			 System.out.println(sel_chk1.getText() + " Insurance selected" );
			 Thread.sleep(2000);
			WebElement sel_chk2 = driver.findElement(By.xpath("//span[contains(text(),'Medicare')]"));
			WebElement chk2_obj = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-2']"));
			chk2_obj.click();
			System.out.println(sel_chk2.getText() + " Insurance selected" );
		} else if (gender_valid.equals("Female")) {
			Thread.sleep(2000);
			WebElement sel_chk1 = driver.findElement(By.xpath("//span[contains(text(),'Medicaid')]"));
			WebElement chk1_obj = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']"));
			chk1_obj.click();
			System.out.println(sel_chk1.getText() + " Insurance selected" );
			Thread.sleep(2000);
			WebElement sel_chk3 = driver.findElement(By.xpath("//span[contains(text(),'Tricare')]"));
			WebElement chk3_obj = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-3']"));
			chk3_obj.click();
			System.out.println(sel_chk3.getText() + " Insurance selected" );
		} else {
			Thread.sleep(5000);
			WebElement sel_chk4 = driver.findElement(By.xpath("//span[contains(text(),'Other Insurer')]"));
			WebElement chk4_obj = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-4']"));
			chk4_obj.click();
			System.out.println(sel_chk4.getText() + " Insurance selected" );
			Thread.sleep(2000);
			WebElement sel_chk5 = driver.findElement(By.xpath("//span[contains(text(),'Uninsured')]"));
			WebElement chk5_obj = driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-5']"));
			chk5_obj.click();
			System.out.println(sel_chk5.getText() + " Insurance selected" );
			
		}
		Thread.sleep(5000);		
		
		
		// create care receiver
		WebElement sel_crrel = driver.findElement(By.id("relationship"));
		Select crrelsel = new Select(sel_crrel);
		List <WebElement> crrellist = crrelsel.getOptions();
		int ciCnt = crrellist.size();
		Random crrelnum = new Random();
		 int ciSelect = crrelnum.nextInt(ciCnt);
		 crrelsel.selectByIndex(ciSelect);
		 System.out.println("CR Relationship: " + sel_crrel.getAttribute("value"));
		 Thread.sleep(2000);
		
		 // first name
		 WebElement crfirst = driver.findElement(By.id("crfirstName"));
		crfirst.sendKeys("Joshan");
		System.out.println("CR First Name: " + crfirst.getAttribute("value"));
		Thread.sleep(1000);
		
		// Second name
		WebElement crlast = driver.findElement(By.id("crlastName"));
		crlast.sendKeys("Peter");
		System.out.println("CR Last Name: " + crlast.getAttribute("value"));
		Thread.sleep(2000);
		
		// submit
		WebElement sub = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		sub.click();		
		Thread.sleep(5000);
		
		WebElement msgalt =  driver.findElement(By.xpath("//body/app-root[1]/div[1]"));
		boolean lot = msgalt.isDisplayed();
		if(lot) {
		System.out.println("New Case Creation success:"+msgalt.getText());
		}
		else {
			System.out.println("New Case Creation Sucess:Notification not Captured");	
		}
			
		Thread.sleep(5000);

	}
	/**
	 * Create Assessment 
	 * @throws InterruptedException
	 */
	
	@Test(priority = 4)
// create Assessment
	public void create_assessment() throws InterruptedException {
		
		WebElement chk_caseid = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-secure[1]/div[1]/div[2]/app-case-details[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]"));
		String case_id = chk_caseid.getText().substring(8, 12);
		System.out.println("case id : " +  case_id );
	//	caseid_search(case_id);
		Thread.sleep(3000);
		WebElement clk_ass1 = driver.findElement(By.xpath("//div[contains(text(), 'Create New Assessment')]"));
		clk_ass1.click();
		Thread.sleep(3000);
		
		WebElement msgalt_Assessment_create =  driver.findElement(By.xpath("//body/app-root[1]/div[1]"));
		boolean lot_create_Assess = msgalt_Assessment_create.isDisplayed();
		if(lot_create_Assess) {
		System.out.println("Assessment Creation success:"+msgalt_Assessment_create.getText());
		}
		else {
			System.out.println("Assessment Creation Sucess:Notification not Captured");	
		}
			
		Thread.sleep(5000);
	}

	@Test(priority = 5)
// print paper form ass question
	public void PrintPaper_Form() throws InterruptedException {
		Thread.sleep(1000);
		WebElement print_paper = driver.findElement(By.xpath("//button[contains(text(), 'Print Paper Form')]"));
		print_paper.click();
		Thread.sleep(2000);
		// validate alert

		Alert alert_print_assessment = driver.switchTo().alert();
		//System.out.println(alert_print_assessment.getText());
		alert_print_assessment.accept();
		
		Thread.sleep(3000);
		WebElement msgalt_Assessment_download_Pdf =  driver.findElement(By.xpath("//body/app-root[1]/div[1]"));
		boolean lot_create_Assess = msgalt_Assessment_download_Pdf.isDisplayed();
		if(lot_create_Assess) {
		System.out.println("Assessment PrintPdf success:"+msgalt_Assessment_download_Pdf.getText());
		}
		else {
			System.out.println("Assessment PrintPdf:Notification not Captured");	
		}
			
		Thread.sleep(5000);
	}
/**
 * Page 1 (Caregiver Details)
 * @throws InterruptedException
 */
	@Test(priority = 6)
	public void assessment_page1() throws InterruptedException {
		
		// first
		WebElement caregiver_response = driver.findElement(By.xpath(
				"//div[@class='row ng-star-inserted']//div[1]//app-radio[1]//div[1]//div[1]//span[2]//input[1]"));
		caregiver_response.click();
		
		// second
		WebElement res_family_member = driver.findElement(By.xpath(
				"//div[@class='row assessment-form-wrapper']//div[2]//app-radio[1]//div[1]//div[1]//span[1]//input[1]"));
		res_family_member.click();
		
		// third
		WebElement relaive_cg = driver
				.findElement(By.xpath("//div[3]//app-radio[1]//div[1]//div[1]//span[2]//input[1]"));
		relaive_cg.click();
		
		// fourth
		WebElement fourth = driver.findElement(By.xpath("//div[4]//app-radio[1]//div[1]//div[1]//span[5]//input[1]"));
		fourth.click();
		
		// fifth
		WebElement drop_home11 = driver.findElement(By.xpath("//div[5]//app-select[1]//div[1]//select[1]"));
		Select index = new Select(drop_home11);
		index.selectByIndex(4);
		
		// sixth
		WebElement any_dieases = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-multi[1]/div[1]/span[6]/input[1]"));

		any_dieases.click();

		// seventh
		WebElement Miltary = driver.findElement(By.xpath("//div[7]//app-radio[1]//div[1]//div[1]//span[2]//input[1]"));
		Miltary.click();
		
		//Miltary2
		WebElement retired_member_of_the_military = driver.findElement(By.xpath("//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[8]/app-radio[1]/div[1]/div[1]/span[2]/input[1]"));
		retired_member_of_the_military.click();


		

		// eighth
		WebElement present1 = driver.findElement(By.xpath("//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[9]/app-select[1]/div[1]/select[1]"));
		Select health1 = new Select(present1);
		health1.selectByIndex(1);

		// nine
		WebElement employment = driver.findElement(By.xpath("//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[10]/app-select[1]/div[1]/select[1]"));
		Select status = new Select(employment);
		status.selectByIndex(3);

		// ten
		WebElement dep_adult1 = driver.findElement(By.xpath("//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[12]/app-text[1]/div[1]/input[1]"));
		dep_adult1.sendKeys("1");

		// eleven
		WebElement dep_children = driver.findElement(By.xpath("//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[13]/app-text[1]/div[1]/input[1]"));
		dep_children.sendKeys("0");
		// twelve

		WebElement eleven = driver.findElement(By.xpath("//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[14]/app-radio[1]/div[1]/div[1]/span[5]/input[1]"));
		eleven.click();

		// click next
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement pagenext1 = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		pagenext1.click();

		System.out.println("Page 1 (Caregiver Details)");
		Thread.sleep(3000);
	}


/**
 * Page 2 (Caregiver Details)
 * @throws InterruptedException
 */
	@Test(priority = 7)
	public void caregiver_details1() throws InterruptedException {

		// select2

		WebElement housework = driver.findElement(By.xpath("//div[3]//app-select[1]//div[1]//select[1]"));
		Select launtry = new Select(housework);
		launtry.selectByIndex(1);

		// select3
		WebElement appoint = driver.findElement(By.xpath("//div[4]//app-select[1]//div[1]//select[1]"));
		Select shopping = new Select(appoint);
		shopping.selectByIndex(2);

		// select4
		WebElement money = driver.findElement(By.xpath("//div[5]//app-select[1]//div[1]//select[1]"));
		Select banking = new Select(money);
		banking.selectByIndex(2);

		// text last

		WebElement inc_cr = driver.findElement(By.xpath("//input[@type='text']"));
		inc_cr.sendKeys("3");

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next

		WebElement pg2_next = driver.findElement(By.xpath("//button[contains(text(), 'Next')]"));
		pg2_next.click();

		System.out.println("Page 2 (Caregiver Details)");

		Thread.sleep(3000);
	}

	/**
	 * Page 3 (Problem Behavior)
	 * @throws InterruptedException
	 */
	@Test(priority = 8)
	public void problem_behaviour() throws InterruptedException {
		// first
		WebElement night = driver.findElement(By.xpath(
				"//div[@class='row assessment-form-wrapper']//div[2]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		night.click();

		// second
		WebElement repeat = driver.findElement(By
				.xpath("//div[3]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//input[1]"));
		repeat.click();
		// third

		WebElement wrong = driver.findElement(By
				.xpath("//div[4]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		wrong.click();

		// fourth

		WebElement accident = driver.findElement(By
				.xpath("//div[5]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//input[1]"));
		accident.click();

		// five

		WebElement forget = driver.findElement(By
				.xpath("//div[6]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		forget.click();

		WebElement hide = driver.findElement(By
				.xpath("//div[7]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		hide.click();

		WebElement cry_easily = driver.findElement(By
				.xpath("//div[8]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		cry_easily.click();

		WebElement downhearted = driver.findElement(By
				.xpath("//div[9]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[3]//span[1]//input[1]"));
		downhearted.click();

		WebElement cling = driver.findElement(By
				.xpath("//div[10]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[3]//span[1]//input[1]"));
		cling.click();

		WebElement restless = driver.findElement(By
				.xpath("//div[11]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[3]//span[1]//input[1]"));
		restless.click();

		WebElement irritable = driver.findElement(By
				.xpath("//div[12]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		irritable.click();

		WebElement language = driver.findElement(By
				.xpath("//div[13]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		language.click();

		WebElement harm = driver.findElement(By
				.xpath("//div[14]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[3]//span[1]//input[1]"));
		harm.click();

		WebElement thrat_people = driver.findElement(By
				.xpath("//div[15]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		thrat_people.click();

		WebElement wander = driver.findElement(By
				.xpath("//div[16]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//input[1]"));
		wander.click();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next

		WebElement pg3_next = driver.findElement(By.xpath("//button[contains(text(), 'Next')]"));
		pg3_next.click();
		System.out.println("Page3 (Problem Behavior)");

		Thread.sleep(3000);
	}

	/**
	 * Page 4 (Identity Discrepancy)
	 * @throws InterruptedException
	 */
	
	@Test(priority = 9)
	public void Identity_discrepancy() throws InterruptedException

	{

		WebElement disagree = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[2]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		disagree.click();

		WebElement strongly = driver.findElement(By
				.xpath("//div[3]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//input[1]"));
		strongly.click();

		WebElement person_little1 = driver.findElement(By
				.xpath("//div[4]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		person_little1.click();

		WebElement partner = driver.findElement(By
				.xpath("//div[5]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[3]//span[1]//input[1]"));
		partner.click();

		WebElement relete = driver.findElement(By
				.xpath("//div[6]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[2]//span[1]//input[1]"));
		relete.click();

		WebElement assume = driver.findElement(By
				.xpath("//div[7]//app-survey-question[1]//div[1]//div[1]//div[2]//div[1]//div[5]//span[1]//input[1]"));
		assume.click();


		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next

		WebElement pg4_next = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		pg4_next.click();
		System.out.println("Page4 (Identity Discrepancy)");
		Thread.sleep(3000);
	}

	/**
	 * Page 5 (Intention to Place / Identity Discrepancy)
	 * @throws InterruptedException
	 */
	
	@Test(priority = 10)
	public void inten_place() throws InterruptedException

	{

		WebElement current_connection1 = driver.findElement(By.xpath(
				"//div[@class='row ng-star-inserted']//div[1]//app-radio[1]//div[1]//div[1]//span[1]//input[1]"));
		current_connection1.click();

		WebElement long_term = driver.findElement(By.xpath(
				"//div[@class='row assessment-form-wrapper']//div[2]//app-radio[1]//div[1]//div[1]//span[1]//input[1]"));
		long_term.click();

		WebElement relative = driver.findElement(By.xpath("//div[3]//app-radio[1]//div[1]//div[1]//span[2]//input[1]"));
		relative.click();


		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next

		WebElement pg5_next5 = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		pg5_next5.click();
		System.out.println("Page 5 (Intention to Place / Identity Discrepancy)");

		Thread.sleep(3000);
	}
	
	/**
	 * Page 7 (CG Burden)
	 * @throws InterruptedException
	 */

	@Test(priority = 11)
	public void cg_burden() throws InterruptedException

	{

		WebElement not_all = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[2]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		not_all.click();

		WebElement a_little = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[3]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]/input[1]"));
		a_little.click();

		WebElement Moderately = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[4]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		Moderately.click();

		WebElement lot = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[5]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		lot.click();

		WebElement great_deal = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		great_deal.click();

		WebElement kept = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[7]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		kept.click();

		WebElement nervous = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[8]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]/input[1]"));
		nervous.click();

		WebElement made_relationship = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[9]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		made_relationship.click();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next

		WebElement pg6_net = driver.findElement(By.xpath("//button[contains(text(), 'Next')]"));

		pg6_net.click();
		System.out.println("Page 7 (CG Burden)");
		Thread.sleep(3000);

	}

/**
 * Page 8 (CG Burden)
 * @throws InterruptedException
 */
	@Test(priority = 12)
	public void cg_res() throws InterruptedException

	{

		WebElement cg_feel = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[2]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		cg_feel.click();

		WebElement suffer = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[3]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		suffer.click();

		WebElement depressed = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[4]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]/input[1]"));
		depressed.click();

		WebElement fulfillment = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[5]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		fulfillment.click();

		WebElement advantage = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/input[1]"));
		advantage.click();

		WebElement routine = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[7]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		routine.click();

		WebElement anixous = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[8]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		anixous.click();

		WebElement feeling_good = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[9]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]/input[1]"));
		feeling_good.click();

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next

		WebElement pg8_next = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));

		pg8_next.click();

		System.out.println("Page 8 (CG Burden)");
		Thread.sleep(3000);
	}
	
/**
 * Page 9 (CG Burden)
 * @throws InterruptedException
 */
	@Test(priority = 13)
	public void cr_res1() throws InterruptedException {

		// question

		WebElement manipulate = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[2]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		manipulate.click();

		WebElement little_time12 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[3]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		little_time12.click();

		WebElement caused_worry = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[4]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		caused_worry.click();

		WebElement enjoy_being = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[5]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		enjoy_being.click();

		WebElement relex = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]/input[1]"));
		relex.click();

		WebElement cherish = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[7]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		cherish.click();


		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next
		WebElement pg9_next9 = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		pg9_next9.click();
		System.out.println("Page9 (CG Burden)");
		Thread.sleep(3000);
	}

	/**
	 * Page 11 (Depression)
	 * @throws InterruptedException
	 */
	@Test(priority = 14)
	public void depression() throws InterruptedException

	{

		WebElement useually = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[2]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		useually.click();

		WebElement trouble = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[3]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		trouble.click();

		WebElement felt_depressed = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[4]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		felt_depressed.click();

		WebElement felt_effort = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[5]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/input[1]"));
		felt_effort.click();

		WebElement hopeful_future = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		hopeful_future.click();

		WebElement fearful = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[7]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		fearful.click();

		WebElement restless = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[8]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		restless.click();

		WebElement was_happy = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[9]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		was_happy.click();

		WebElement longly = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[10]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		longly.click();

		WebElement get_going = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[11]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		get_going.click();


		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,140)");

		// click next
		WebElement pg10_next10 = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));

		pg10_next10.click();
		
		System.out.println("Page11 (Depression)");
		Thread.sleep(3000);
	}
/**
 * Page 12 (Caregiver Details)
 * @throws InterruptedException
 */
	@Test(priority = 15)
	public void caregiver_details() throws InterruptedException

	{

		// first

		WebElement alcohl = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[1]/app-radio[1]/div[1]/div[1]/span[1]/input[1]"));
		alcohl.click();



		// fourth
		WebElement graph = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[4]/app-radio[1]/div[1]/div[2]/span[3]/input[1]"));
		graph.click();
		// fifth
		WebElement total_income = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[5]/app-radio[1]/div[1]/div[1]/span[1]/input[1]"));
		total_income.click();

		WebElement race1_ass = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-multi[1]/div[1]/span[1]/input[1]"));
		race1_ass.click();
		// sixth

		WebElement pay_ass = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[7]/app-radio[1]/div[1]/div[1]/span[2]/input[1]"));
		pay_ass.click();
//seventh

		WebElement past_month = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[8]/app-multi[1]/div[1]/span[7]/input[1]"));
		past_month.click();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// click next

		WebElement pg12_next12 = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		pg12_next12.click();

		System.out.println("Page12 (Caregiver Details)");
		Thread.sleep(3000);
	}
/**
 * Page 13 (ADL/IADL)
 * @throws InterruptedException
 */
	// page13
	@Test(priority = 16)
	public void adl() throws InterruptedException

	{
		WebElement eating = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[2]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		eating.click();

		WebElement outofbed = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[3]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/input[1]"));
		outofbed.click();

		WebElement aroundinside = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[4]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		aroundinside.click();

		WebElement dressing = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[5]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		dressing.click();

		WebElement bathing = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		bathing.click();

		WebElement usingtoilet = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[7]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		usingtoilet.click();

		WebElement heavywork = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[8]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		heavywork.click();

		WebElement lightwork = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[9]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		lightwork.click();

		WebElement laundry = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[10]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		laundry.click();

		WebElement preparing_meals = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[11]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/input[1]"));
		preparing_meals.click();

		WebElement clothsfoods = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[12]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		clothsfoods.click();

		WebElement aroundoutside = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[13]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		aroundoutside.click();

		WebElement walkingdistance = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[14]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/input[1]"));
		walkingdistance.click();

		WebElement money = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[15]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		money.click();

		WebElement medicine = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[16]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/input[1]"));
		medicine.click();

		WebElement usingtelephone = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[17]/app-survey-question[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]"));
		usingtelephone.click();

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,140)");

		// click next
		WebElement pg13_next13 = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		pg13_next13.click();
		System.out.println("Page13 (ADL/IADL)");
		Thread.sleep(3000);
	}
/**
 *Page 16 (Care Receiver Details)
 * @throws InterruptedException
 */
	
	@Test(priority = 17)
	public void carereciver_details() throws InterruptedException

	{
		// CR FIRST
		WebElement cr_dieases = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[1]/app-multi[1]/div[1]/span[1]/input[1]"));
		cr_dieases.click();

		WebElement describes = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[2]/app-radio[1]/div[1]/div[1]/span[1]/input[1]"));
		describes.click();

		WebElement hospialized = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[3]/app-radio[1]/div[1]/div[1]/span[2]/input[1]"));
		hospialized.click();

		WebElement hospialized_caregiver = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[4]/app-radio[1]/div[1]/div[1]/span[2]/input[1]"));
		hospialized_caregiver.click();
		Thread.sleep(1000);

		// WebElement cg_hos_days =
		// driver.findElement(By.xpath("//input[@placeholder='No of Days']"));
		// cg_hos_days.sendKeys("4");

		WebElement house_hold = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[5]/app-radio[1]/div[1]/div[1]/span[1]/input[1]"));
		house_hold.click();

		WebElement cr_ethinicity_last = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-assessment[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/app-assessment-page[1]/div[1]/div[6]/app-multi[1]/div[1]/span[5]/input[1]"));
		cr_ethinicity_last.click();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		// submit

		WebElement ass_submit = driver
				.findElement(By.xpath("//button[@class='btn btn-white pull-right ng-star-inserted']"));
		ass_submit.click();
		System.out.println("Page16 (Care Receiver Details)");
		

        Thread.sleep(5000);
		
		WebElement msgalt_ass_save =  driver.findElement(By.xpath("//body/app-root[1]/div[1]"));
		boolean lot_create_Ass_save = msgalt_ass_save.isDisplayed();
		if(lot_create_Ass_save) 
		{
		System.out.println("Assessment Saved success:"+msgalt_ass_save.getText());
		}
		else
		{
			System.out.println("Assessment Saved Sucess: Notification Message Not Displyed");	
		
	}
		Thread.sleep(5000);		
	}

/**
 * SUMMARY
 * Create careplan 
 * @throws InterruptedException
 */
	@Test(priority = 18)
	public void summary() throws InterruptedException

	{
		WebElement print_pdf1 = driver.findElement(By.xpath("//button[contains(text(),'Print PDF')]"));
		print_pdf1.click();
        Thread.sleep(2000);

		// other useful information

		WebElement text_area1 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-summary[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/textarea[1]"));
		text_area1.sendKeys("testing");

		WebElement text_area3 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-summary[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[4]/div[2]/div[1]/textarea[1]"));
		text_area3.sendKeys("care receiver");

		WebElement level_need = driver.findElement(By.xpath("//div[6]//div[1]//select[1]"));
		Select quest1 = new Select(level_need);
		quest1.selectByIndex(2);

		WebElement safe = driver.findElement(By.xpath("//div[7]//div[1]//select[1]"));
		Select manner = new Select(safe);
		manner.selectByIndex(1);

		WebElement health_care = driver.findElement(By.xpath("//div[8]//div[1]//select[1]"));
		Select quest3 = new Select(health_care);
		quest3.selectByIndex(2);

		WebElement provide = driver.findElement(By.xpath("//div[9]//div[1]//select[1]"));
		Select care = new Select(provide);
		care.selectByIndex(1);

		// SAVE SUMMARY

		WebElement save_summary = driver.findElement(By.xpath("//span[contains(text(),'Save Summary')]"));
		save_summary.click();
        Thread.sleep(5000);
		
		WebElement msgalt_summary_save =  driver.findElement(By.xpath("//body/app-root[1]/div[1]/p[1]"));
		boolean lot_save_sum = msgalt_summary_save.isDisplayed();
		if(lot_save_sum) 
		{
		System.out.println("Summary Save:"+msgalt_summary_save.getText());
		}
		else
		{
			System.out.println("Other UserFul Info Notification Not Displayed");			
	}
		Thread.sleep(3000);
		
		// Pending plan

		WebElement create_cp = driver.findElement(By.xpath("//button[@class='status ng-star-inserted']"));
		create_cp.click();
		Thread.sleep(5000);
		
		WebElement create_cp_notif_msg =  driver.findElement(By.xpath("//body/app-root[1]/div[1]"));
		boolean lot_create_cp_msg = create_cp_notif_msg.isDisplayed();
		if(lot_create_cp_msg) 
		{
		System.out.println("Careplan Create:"+ create_cp_notif_msg.getText());
		}
		else
		{
			System.out.println("Careplan Creation Notification Not Captured");	
		
	}

		Thread.sleep(3000);

	}
/**
 * Goals & Resources 
 * @throws InterruptedException
 */
	@Test(priority = 19)

	public void goals() throws InterruptedException {
		// desire out come

		WebElement desire_outcome1 = driver
				.findElement(By.xpath("//div[@class='strategy-1']//div[1]//div[1]//div[1]//div[2]//input[1]"));
		desire_outcome1
				.sendKeys(" Assessing the health of the workforce will help determine which programs to implement. "
						+ "Several laws affect the use of health risk assessments, therefore, "
						+ "consulting with legal counsel is recommended");
		Thread.sleep(1000);

		// CLICK AT MAT
		WebElement mat_expansion_header1 = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/mat-expansion-panel-header[1]/span[1]/mat-panel-title[1]"));
		mat_expansion_header1.click();
		Thread.sleep(1000);

		WebElement check = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/i[1]"));
		check.click();
		Thread.sleep(1000);
		
		 //Select The Resource Wellness Program Select single & multiple resources To
		 // Delete Resource	

		WebElement hiddencheckbox = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/input[1]"));
		hiddencheckbox.click();
		Thread.sleep(1000);

		// search

		WebElement careplan_search = driver.findElement(By.xpath("//button[@class='btn btn-secondary'][1]"));
		careplan_search.click();
		// Thread.sleep(1000);

		// Select Three Resources

		List<WebElement> li = driver.findElements(By.xpath("//div[@class='ng-star-inserted']//h5"));
	//	System.out.println(li.size());
		for (int i = 0; i <= li.size() - 1; i++) {

			if (i < 3)

				li.get(i).click();

		}

		Thread.sleep(1000);

		WebElement add_resource_1 = driver.findElement(By.xpath(
				"//div[@id='searchTab']//button[@class='btn btn-success ng-star-inserted'][contains(text(),'Add to CarePlan')]"));
		add_resource_1.click();
		Thread.sleep(1000);

		WebElement comment1 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/textarea[1]"));
		comment1.sendKeys(
				"LHSA holds just over 100 collections of twentieth-century folder-based patient case notes (comprising in total approximately 1 million individual case notes).  "
						+ "The majority of them relate to the Royal Infirmary of Edinburgh, but other hospitals are represented. "
						+ " As a whole, the collections cover a wide variety of medical specialties and were produced by numerous practitioners. "
						+ "LHSA holds just over 100 collections of twentieth-century folder-based patient case notes (comprising in total approximately 1 million individual case notes). "
						+ " The majority of them relate to the Royal Infirmary of Edinburgh, but other hospitals are represented. "
						+ " As a whole, the collections cover a wide variety of medical specialties and were produced by numerous practitioners."
						+ " LHSA holds just over 100 collections of twentieth-century folder-based patient case notes (comprising in total approximately 1 million individual case notes). "
						+ " The majority of them relate to the Royal Infirmary of Edinburgh, but other hospitals are represented. "
						+ " As a whole, the collections cover a wide variety of medical specialties and were produced by numerous practitioners."
						+ " LHSA holds just over 100 collections of twentieth-century folder-based patient case notes"
						+ " (comprising in total approximately 1 million individual case notes).  "
						+ "The majority of them relate to the Royal Infirmary of Edinburgh, but other hospitals are represented. "
						+ " As a whole, the collections cover a wide variety of medical specialties and were produced by nume");

		WebElement comment2 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/textarea[1]"));
		comment2.sendKeys("As the collections date from within the last 100 years, "
				+ "strict restictions on access apply, however, there are procedures in place to allow access to these records for research purposes. "
				+ " Under appropriate access conditions, " + "LHSA actively promotes research into these collections, "
				+ "and special facilities can be made available to assist in the intensive use of large numbers of case notes.");

		WebElement comment3 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/textarea[1]"));
		comment3.sendKeys("Case notes can be difficult and time-consuming to use, "
				+ "and great care must be taken when handling them, however,"
				+ " they are an extraordinarily rich primary archival source relevant to a variety of historical, social, scientific and medical disciplines.  "
				+ "Many case notes have significant links to other LHSA records, for example general registers of patients, ward and operations books and bound case notes. "
				+ " LHSA staff can assist you in establishing these links."
				+ "Case notes can be difficult and time-consuming to use, "
				+ "and great care must be taken when handling them, however,"
				+ " they are an extraordinarily rich primary archival source relevant to a variety of historical, "
				+ "social, scientific and medical disciplines. "
				+ " Many case notes have significant links to other LHSA records,"
				+ " for example general registers of patients, ward and operations books and bound case notes.  "
				+ "LHSA staff can assist you in establishing these links."
				+ "Case notes can be difficult and time-consuming to use,"
				+ " and great care must be taken when handling them, "
				+ "however, they are an extraordinarily rich primary archival source relevant to a variety of historical, "
				+ "social, scientific and medical disciplines.  "
				+ "Many case notes have significant links to other LHSA records,"
				+ " for example general registers of patients, ward and operations books and bound case notes. "
				+ " LHSA staff can assist you in establishing these links.Case notes can be difficult and time-consuming to use,"
				+ " and great care must be taken when handling them, however, they ar");

//Desiredoutcome2

		WebElement desiredoutcome2 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/input[1]"));
		desiredoutcome2.sendKeys("Reduce low birth weight rate in the community as a whole.");

		Thread.sleep(1000);
//Click Mat	

		WebElement Mat_Counseling = driver.findElement(By.xpath(
				"//body[1]/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/mat-expansion-panel-header[1]/span[1]/mat-panel-title[1]"));
		Mat_Counseling.click();
		Thread.sleep(1000);

//CLick Service

		WebElement Stress_mgnt_tech = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/mat-accordion[1]/mat-expansion-panel[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/i[1]"));
		Stress_mgnt_tech.click();

		Thread.sleep(2000);

//Click keyword

		WebElement Caregiver_Education_Classes = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[1]/input[1]"));
		Caregiver_Education_Classes.click();

//search	

		WebElement careplan_search_last = driver.findElement(By.xpath("//button[@class='btn btn-secondary'][1]"));
		careplan_search_last.click();

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='pop-suggest col-8']//h5"));
	//	System.out.println(list.size());
		for (int i = 0; i <= list.size() - 1; i++) {

			if (i < 3)

				list.get(i).click();

		}

		WebElement add_resource_2 = driver.findElement(By.xpath(
				"//body/app-root[1]/app-secure[1]/div[1]/div[2]/app-latestcp[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/button[1]"));
		add_resource_2.click();
		Thread.sleep(1000);

		// care plan save

		WebElement save_cpresource1 = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		save_cpresource1.click();
		System.out.println("Careplan Saved Sucess!");
		Thread.sleep(8000);					

	}
	
@Test(priority=20)	
 public void moved_next() throws InterruptedException
{
	
	/**
	 * Moved to Finalized CarePlan Page
	 */	
			WebElement care_next1 = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
			care_next1.click();	
			System.out.println("Moved Finalized Careplan page");
			Thread.sleep(5000);
}
	/**
	 * Final careplan page
	 * @throws InterruptedException
	 */
	@Test(priority = 21)

	public void final_careplan() throws InterruptedException {

		// Care plan print Download
        Thread.sleep(1000);
		WebElement printpaperform_careplan = driver.findElement(By.xpath("//button[contains(text(),'Print Paper Form')]"));
		printpaperform_careplan.click();
		Thread.sleep(5000);

		Alert careplan_print_finalize1 = driver.switchTo().alert();
		careplan_print_finalize1.accept();
		Thread.sleep(8000);

		WebElement care_manager1 = driver.findElement(By.xpath("//textarea[@placeholder='TCARE Specialist’s Responsibilities *']"));
		care_manager1.sendKeys("testing");

		WebElement care_giverres1 = driver.findElement(By.xpath("//textarea[@placeholder='TCARE Caregiver’s Responsibilities *']"));
		care_giverres1.sendKeys("testing");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement finalize_save1 = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		finalize_save1.click();
		System.out.println("Careplan updated Sucess!");
		Thread.sleep(5000);

		WebElement finalize = driver.findElement(By.xpath("//button[contains(text(),'Finalize')]"));
		finalize.click();
		System.out.println("Careplan Finalized Sucess!");
		Thread.sleep(5000);
		
		Tcare_Login_Testcase.TCARE_Logout();
		Thread.sleep(5000);		
	}
/**
 * 	
 * @param caseid
 * Case_Id Searching for caselist
 * @throws InterruptedException
 */
		
	public static void caseid_search(String caseid) throws InterruptedException {

		// search case id
		Thread.sleep(3000);
		
		WebElement casedt_span = driver.findElement(By.xpath("//body/app-root[1]/app-secure[1]/div[1]/div[1]/span[3]"));
		casedt_span.click();
		
		
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		
		Thread.sleep(1000);

		WebElement casedt_search = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		casedt_search.click();
		casedt_search.sendKeys(caseid);
		
				
		WebElement case_table = driver.findElement(By.tagName("mat-table"));
		List <WebElement> rows_table = case_table.findElements(By.tagName("mat-row"));
		int rows_count = rows_table.size();
		
		for (int i=0;i<rows_count;i++) {
			List < WebElement > Columns_row = rows_table.get(i).findElements(By.tagName("mat-cell"));
			int columns_count = Columns_row.size();
			   System.out.println("Number of cells In Row " + i  + " are " + columns_count);
			 //Loop will execute till the last cell of that specific row.
			   for (int j = 0; j < columns_count; j++) {
			    //To retrieve text from the cells.
			    String celltext = Columns_row.get(j).getText();
			    System.out.println("Cell Value Of row number " + i + " and column number " + j + " Is " + celltext);
			   }
			  }
		System.out.println("Case Details getting Displayed in the Case-List");
		WebElement case_Lid = driver.findElement(By.xpath("//a[contains(text(), '"+ caseid + "')]"));
		case_Lid.click();
		return;
				
	}
	
}
