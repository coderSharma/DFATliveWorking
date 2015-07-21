package com.DFATPageObjects.MyApplications;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.DFAT_Australia.BaseClass;


public class Step3_EducationaAndEmployment_PageObjects extends BaseClass{
	public WebDriver driver;
	static String specialText="This is <test> #1" ;
	String longText="just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.just some random text that would fill up the form.";
	String shortText="this is short text";
	boolean Errorcheckresult;
	// The element is now looked up using the name/ID/XPATH attribute

	//Tertiary Education Information
	@FindBy(how=How.XPATH, using = "//label[@for='tEducation1']")
	public WebElement YesTertiaryEducationRadioButton ;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].Institution")
	public WebElement TertiaryEducationInstitutionTextBox;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].Qualification")
	public WebElement TertiaryEducationQualificationDropDown;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].MajorAreaOfStudy1")
	public WebElement TertiaryEducationMajorAreaOfStudy1TextBox;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].MajorAreaOfStudy2")
	public WebElement TertiaryEducationMajorAreaOfStudy2TextBox;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].TertiaryEducationFromMonth")
	public WebElement TertiaryEducationFromMonthDropDown;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].TertiaryEducationFromYear")
	public WebElement TertiaryEducationFromYearDropDown;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].TertiaryEducationToMonth")
	public WebElement TertiaryEducationToMonthDropDown;
	@FindBy(how = How.ID, using = "TertiaryEducation.TertiaryEducationList[0].TertiaryEducationToYear")
	public WebElement TertiaryEducationToYearDropDown;
	@FindBy(how=How.XPATH, using = "//label[@for='tEducation2']")
	public WebElement NoTertiaryEducationRadioButton ;
	@FindBy (how=How.XPATH, using= "//a[contains(.,' Add another Secondary Education')]")
	public WebElement AddAnotherTertiaryEducation ;


	//Secondary Education Information
	@FindBy(how=How.XPATH, using = "//label[@for='sEducation1']")
	public WebElement YesSecondryEducationRadioButton ;
	@FindBy(how = How.ID, using = "SecondaryEducation.SecondaryEducationList[0].SchoolName")
	public WebElement SecondaryEducationSchoolNameTextBox;
	@FindBy(how = How.ID, using = "SecondaryEducation.SecondaryEducationList[0].SecondaryEducationFromMonth")
	public WebElement SecondaryEducationFromMonthDropDown;
	@FindBy(how = How.ID, using = "SecondaryEducation.SecondaryEducationList[0].SecondaryEducationFromYear")
	public WebElement SecondaryEducationFromYearDropDown;
	@FindBy(how = How.ID, using = "SecondaryEducation.SecondaryEducationList[0].SecondaryEducationToMonth")
	public WebElement SecondaryEducationToMonthDropDown;
	@FindBy(how = How.ID, using = "SecondaryEducation.SecondaryEducationList[0].SecondaryEducationToYear")
	public WebElement SecondaryEducationToYearDropDown;
	@FindBy(how = How.ID, using = "SecondaryEducation.SecondaryEducationList[0].LevelAchieved")
	public WebElement SecondaryEducationLevelAchievedDropDown;
	@FindBy(how=How.XPATH, using = "//label[@for='sEducation2']")
	public WebElement NoSecondryEducationRadioButton ;
	@FindBy (how=How.XPATH, using= "//a[contains(.,' Add another Secondary Education')]")
	public WebElement AddAnotherSecondryEducationButton ;



	//Current Employment Information
	@FindBy(how=How.XPATH, using = "//label[@for='cEmployment1']")
	public WebElement YesCurrentlyEmployedRadioButton ;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].Occupation")
	public WebElement CurrentOccupationTextBox;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].EmployerName")
	public WebElement CurrentEmployerNameTextBox;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].LevelAchieved")
	public WebElement CurrentEmploymentLevelAchievedTextBox;
	@FindBy(how = How.NAME, using = "CurrentEmployment[0].Salary")
	public WebElement CurrentEmploymentSalaryTextBox;
	@FindBy(how = How.XPATH, using = "//select[@name='CurrentEmployment[0].EmploymentFromMonth']")
	public WebElement CurrentEmploymentFromMonthDropDown;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].EmploymentFromYear")
	public WebElement CurrentEmploymentFromYearDropDown;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].Address1")
	public WebElement CurrentEmploymentAddress1TextBox;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].Address2")
	public WebElement CurrentEmploymentAddress2TextBox;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].SupervisorName")
	public WebElement CurrentEmploymentSupervisorNameTextBox;
	@FindBy(how = How.ID, using = "CurrentEmployment[0].SupervisorContactInformation")
	public WebElement CurrentEmploymentSupervisorContactInformationTextBox;
	@FindBy(how=How.XPATH, using = "//label[@for='cEmployment2']")
	public WebElement NoCurrentlyEmployedRadioButton ;
	@FindBy (how=How.XPATH, using= "/html/body/div[4]/div/div[1]/form/div[1]/div/div/div[2]/div/div/div[13]/div[5]/div/div/a")
	public WebElement AddAnotherPositionButton ;

	//Previous Employment Information
	@FindBy(how=How.XPATH, using = "//label[@for='cEmploymentPrev1']")
	public WebElement YesPreviouslyEmployedRadioButton ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].Occupation")
	public WebElement PreviousEmploymentOccupationTextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].EmployerName")
	public WebElement PreviousEmploymentEmployerNameTextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].Address1")
	public WebElement PreviousEmploymentAddress1TextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].Address2")
	public WebElement PreviousEmploymentAddress2TextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].LevelAchieved")
	public WebElement PreviousEmploymentLevelTextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].Salary")
	public WebElement PreviousEmploymentSalaryTextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].EmploymentFromMonth")
	public WebElement PreviousEmploymentFromMonthDropDown ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].EmploymentFromYear")
	public WebElement PreviousEmploymentFromYearDropDown ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].EmploymentToMonth")
	public WebElement PreviousEmploymentToMonthDropDown ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].EmploymentToYear")
	public WebElement PreviousEmploymentToYearDropDown ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].ReasonForLeaving")
	public WebElement PreviousEmploymentReasonForLeavingTextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].SupervisorName")
	public WebElement PreviousEmploymentSupervisorNameTextBox ;
	@FindBy (how=How.ID, using= "PreviousEmployment[0].SupervisorContactInformation")
	public WebElement PreviousEmploymentSupervisorContactInformationTextBox ;
	@FindBy(how=How.XPATH, using = "//label[@for='cEmploymentPrev2']")
	public WebElement NoPreviouslyEmployedRadioButton ;
	@FindBy(how = How.ID, using = "//a[contains(.,' Add another Previous Position')]")
	public WebElement AddPreviousPositionButton;

	//Security Clearance Details
	@FindBy(how=How.XPATH, using = "//label[@for='sClearance1']")
	public WebElement YesSecurityClearanceRadioButton ;
	@FindBy (how=How.ID, using= "SecurityClearenceHistory_LevelOfClearence")
	public WebElement SecurityLevelOfClearenceTextBox ;
	@FindBy (how=How.ID, using= "SecurityClearenceHistory_SponsoringAgency")
	public WebElement SecuritySponsoringAgencyTextBox ;
	@FindBy(how=How.XPATH, using = "//label[@for='sClearance2']")
	public WebElement NoSecurityClearanceRadioButton ;
	@FindBy(how=How.XPATH, using = "//label[@for='sClearanceExpired1']")
	public WebElement YesClearanceExpiredRadioButton ;
	@FindBy(how=How.XPATH, using = "//select[@id='SecurityClearenceHistory_DateCeasedMonth']")
	public WebElement SecurityClearanceCeasedMonthDropDown ;
	@FindBy(how=How.XPATH, using = "//select[@id='SecurityClearenceHistory_DateCeasedYear']")
	public WebElement SecurityClearanceCeasedYearDropDown ;
	@FindBy(how=How.XPATH, using = "//label[@for='sClearanceExpired1']")
	public WebElement NoClearanceExpiredRadioButton ;
	@FindBy(how=How.XPATH, using = "//label[@for='sClearanceAIC1']")
	public WebElement YesClearanceAICRadioButton ;
	@FindBy (how=How.ID, using= "SecurityClearenceHistory.AicPositionInformation[0].EmploymentFromMonth")
	public WebElement SecurityPositionFromMonthDropDown ;
	@FindBy (how=How.ID, using= "SecurityClearenceHistory.AicPositionInformation[0].EmploymentFromYear")
	public WebElement SecurityPositionFromYearDropDown ;
	@FindBy (how=How.ID, using= "SecurityClearenceHistory.AicPositionInformation[0].Agency")
	public WebElement SecurityAicPositionInformationAgencyDropDown ;
	@FindBy (how=How.ID, using= "SecurityClearenceHistory.AicPositionInformation[0].Position")
	public WebElement SecurityAicPositionInformationPositionTextBox ;
	@FindBy(how=How.XPATH, using = "//label[@for='sClearanceAIC2']")
	public WebElement NoClearanceAICRadioButton ;
	@FindBy (how=How.XPATH, using= "/html/body/div[4]/div/div[1]/form/div[1]/div/div/div[2]/div/div/div[24]/div[4]/div/div/a")
	public WebElement AddAnotherPositionAppliedButton ;

	//Australian Public Service or Commonwealth Agency Employment Information
	@FindBy(how=How.XPATH, using = "//label[@for='apcOrCAEHistory1']")
	public WebElement YesAPCOrCAEHistoryRadioButton ;
	@FindBy(how=How.XPATH, using = "//label[@for='apcOrCAEHistory2']")
	public WebElement NoAPCOrCAEHistoryRadioButton ;
	@FindBy (how=How.ID, using= "ApsEmploymentHistory_AgsNumber")
	public WebElement AGSEmploymentHistoryAgsNumberTextBox ;
	@FindBy(how=How.XPATH, using = "//label[@for='redundancyBenefit1']")
	public WebElement YesRedundancyBenefit1RadioButton ;
	@FindBy (how=How.ID, using= "ApsEmploymentHistory_Agency")
	public WebElement ApsEmploymentHistoryAgencyTextBox ;
	@FindBy (how=How.ID, using= "ApsEmploymentHistory_ApplicationFromMonth")
	public WebElement ApsEmploymentHistoryApplicationFromMonthDropDown ;
	@FindBy (how=How.ID, using= "ApsEmploymentHistory_ApplicationFromYear")
	public WebElement ApsEmploymentHistoryApplicationFromYearDropDown ;
	@FindBy(how=How.XPATH, using = "//label[@for='redundancyBenefit2']")
	public WebElement NoRedundancyBenefit1RadioButton ;


	@FindBy(how = How.XPATH, using = "//input[@value='Save & Continue']")
	public WebElement SaveAndContinueButton;



	public boolean FillFormStandard() throws InterruptedException
	{
		try{
			//Tertiary Education
			//Thread.sleep(3000);
			click(YesTertiaryEducationRadioButton);
			enterText(TertiaryEducationInstitutionTextBox, "Institution1");
			selectDropDown(TertiaryEducationQualificationDropDown, "Diploma");
			enterText(TertiaryEducationMajorAreaOfStudy1TextBox, "Major1");
			enterText(TertiaryEducationMajorAreaOfStudy2TextBox, "Major2");
			selectDropDown(TertiaryEducationFromMonthDropDown, "August");
			selectDropDown(TertiaryEducationFromYearDropDown, "1999");
			selectDropDown(TertiaryEducationToMonthDropDown, "August");
			selectDropDown(TertiaryEducationToYearDropDown, "2001");
			//Secondary Education
			click(YesSecondryEducationRadioButton);
			enterText(SecondaryEducationSchoolNameTextBox,"SecondarySchoolName1");
			selectDropDown(SecondaryEducationFromMonthDropDown, "January");
			selectDropDown(SecondaryEducationFromYearDropDown, "1997");
			selectDropDown(SecondaryEducationToMonthDropDown, "December");
			selectDropDown(SecondaryEducationToYearDropDown, "1999");
			selectDropDown(SecondaryEducationLevelAchievedDropDown, "ACT Year 12 Certificate");
			//Current Employment
			click(YesCurrentlyEmployedRadioButton);
			enterText(CurrentOccupationTextBox, "CurrentOccupation");
			enterText(CurrentEmployerNameTextBox, "CurrentEmployer");
			enterText(CurrentEmploymentLevelAchievedTextBox, "CurrentLevel");
			enterText(CurrentEmploymentSalaryTextBox, "CurrentSalary");
			selectDropDown(CurrentEmploymentFromMonthDropDown, "March");
			selectDropDown(CurrentEmploymentFromYearDropDown, "2010");
			enterText(CurrentEmploymentAddress1TextBox, "CurrentAddress1");
			enterText(CurrentEmploymentAddress2TextBox, "CurrentAddress2");
			enterText(CurrentEmploymentSupervisorNameTextBox, "Supervisor");
			enterText(CurrentEmploymentSupervisorContactInformationTextBox, "0412100100");
			//Previous Employment
			click(YesPreviouslyEmployedRadioButton);
			enterText(PreviousEmploymentOccupationTextBox, "PreviousOccupation1");
			enterText(PreviousEmploymentEmployerNameTextBox,"PreviousEmployer1");
			enterText(PreviousEmploymentAddress1TextBox, "PreviousAddress1");
			enterText(PreviousEmploymentAddress2TextBox, "PreviousAddress2");
			enterText(PreviousEmploymentLevelTextBox, "PreviousEmploymentLevel");
			enterText(PreviousEmploymentSalaryTextBox, "170k");
			selectDropDown(PreviousEmploymentFromMonthDropDown, "March");
			selectDropDown(PreviousEmploymentFromYearDropDown, "2010");
			selectDropDown(PreviousEmploymentToMonthDropDown, "March");
			selectDropDown(PreviousEmploymentToYearDropDown, "2012");
			enterText(PreviousEmploymentReasonForLeavingTextBox,shortText);
			enterText(PreviousEmploymentSupervisorNameTextBox, "Supervisor");
			enterText(PreviousEmploymentSupervisorContactInformationTextBox, "0412100123");
			//Security Clearance History
			click(YesSecurityClearanceRadioButton);
			enterText(SecurityLevelOfClearenceTextBox,"SecurityLevel1");
			enterText(SecuritySponsoringAgencyTextBox, "SponsoringAgency1");
			click(YesClearanceExpiredRadioButton);
			selectDropDown(SecurityClearanceCeasedMonthDropDown, "January");
			selectDropDown(SecurityClearanceCeasedYearDropDown, "2000");
			click(YesClearanceAICRadioButton);
			selectDropDown(SecurityPositionFromMonthDropDown,"July");
			selectDropDown(SecurityPositionFromYearDropDown,"2004");
			selectDropDown(SecurityAicPositionInformationAgencyDropDown,"ASIO");
			enterText(SecurityAicPositionInformationPositionTextBox, "Skilled Assassin");
			click(YesAPCOrCAEHistoryRadioButton);
			enterText(AGSEmploymentHistoryAgsNumberTextBox,"007");
			click(YesRedundancyBenefit1RadioButton);
			enterText(ApsEmploymentHistoryAgencyTextBox,"WOWSignal");
			selectDropDown(ApsEmploymentHistoryApplicationFromMonthDropDown,"February");
			selectDropDown(ApsEmploymentHistoryApplicationFromYearDropDown, "2000");
			//Thread.sleep(3000);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean FillFormSubStandard() throws InterruptedException
	{
		try{//Tertiary Education
			//Thread.sleep(3000);
			click(YesTertiaryEducationRadioButton);
			enterText(TertiaryEducationInstitutionTextBox, specialText);
			selectDropDown(TertiaryEducationQualificationDropDown, "Diploma");
			enterText(TertiaryEducationMajorAreaOfStudy1TextBox, specialText);
			enterText(TertiaryEducationMajorAreaOfStudy2TextBox, specialText);
			selectDropDown(TertiaryEducationFromMonthDropDown, "August");
			selectDropDown(TertiaryEducationFromYearDropDown, "1999");
			selectDropDown(TertiaryEducationToMonthDropDown, "August");
			selectDropDown(TertiaryEducationToYearDropDown, "2001");
			//Secondary Education
			click(YesSecondryEducationRadioButton);
			enterText(SecondaryEducationSchoolNameTextBox,specialText);
			selectDropDown(SecondaryEducationFromMonthDropDown, "January");
			selectDropDown(SecondaryEducationFromYearDropDown, "1997");
			selectDropDown(SecondaryEducationToMonthDropDown, "December");
			selectDropDown(SecondaryEducationToYearDropDown, "1999");
			selectDropDown(SecondaryEducationLevelAchievedDropDown, "ACT Year 12 Certificate");
			//Current Employment
			click(YesCurrentlyEmployedRadioButton);
			enterText(CurrentOccupationTextBox, specialText);
			enterText(CurrentEmployerNameTextBox, specialText);
			enterText(CurrentEmploymentLevelAchievedTextBox, specialText);
			enterText(CurrentEmploymentSalaryTextBox, specialText);
			selectDropDown(CurrentEmploymentFromMonthDropDown, "March");
			selectDropDown(CurrentEmploymentFromYearDropDown, "2010");
			enterText(CurrentEmploymentAddress1TextBox, specialText);
			enterText(CurrentEmploymentAddress2TextBox, specialText);
			enterText(CurrentEmploymentSupervisorNameTextBox, specialText);
			enterText(CurrentEmploymentSupervisorContactInformationTextBox, specialText);
			//Previous Employment
			click(YesPreviouslyEmployedRadioButton);
			enterText(PreviousEmploymentOccupationTextBox, specialText);
			enterText(PreviousEmploymentEmployerNameTextBox,specialText);
			enterText(PreviousEmploymentAddress1TextBox, specialText);
			enterText(PreviousEmploymentAddress2TextBox, specialText);
			enterText(PreviousEmploymentLevelTextBox, specialText);
			enterText(PreviousEmploymentSalaryTextBox, specialText);
			selectDropDown(PreviousEmploymentFromMonthDropDown, "March");
			selectDropDown(PreviousEmploymentFromYearDropDown, "2010");
			selectDropDown(PreviousEmploymentToMonthDropDown, "March");
			selectDropDown(PreviousEmploymentToYearDropDown, "2012");
			enterText(PreviousEmploymentReasonForLeavingTextBox,specialText);
			enterText(PreviousEmploymentSupervisorNameTextBox, specialText);
			enterText(PreviousEmploymentSupervisorContactInformationTextBox, specialText);
			//Security Clearance History
			click(YesSecurityClearanceRadioButton);
			enterText(SecurityLevelOfClearenceTextBox,specialText);
			enterText(SecuritySponsoringAgencyTextBox, specialText);
			click(YesClearanceExpiredRadioButton);
			selectDropDown(SecurityClearanceCeasedMonthDropDown, "January");
			selectDropDown(SecurityClearanceCeasedYearDropDown, "2000");
			click(YesClearanceAICRadioButton);
			selectDropDown(SecurityPositionFromMonthDropDown,"July");
			selectDropDown(SecurityPositionFromYearDropDown,"2004");
			selectDropDown(SecurityAicPositionInformationAgencyDropDown,"ASIO");
			enterText(SecurityAicPositionInformationPositionTextBox, specialText);
			click(YesAPCOrCAEHistoryRadioButton);
			enterText(AGSEmploymentHistoryAgsNumberTextBox,specialText);
			click(YesRedundancyBenefit1RadioButton);
			enterText(ApsEmploymentHistoryAgencyTextBox,specialText);
			selectDropDown(ApsEmploymentHistoryApplicationFromMonthDropDown,"February");
			selectDropDown(ApsEmploymentHistoryApplicationFromYearDropDown, "2000");
			//Thread.sleep(3000);
			click(SaveAndContinueButton);
			
			
			//Tertiary Education
			//Thread.sleep(3000);
			click(YesTertiaryEducationRadioButton);
			enterText(TertiaryEducationInstitutionTextBox, "Institution1");
			selectDropDown(TertiaryEducationQualificationDropDown, "Diploma");
			enterText(TertiaryEducationMajorAreaOfStudy1TextBox, "Major1");
			enterText(TertiaryEducationMajorAreaOfStudy2TextBox, "Major2");
			selectDropDown(TertiaryEducationFromMonthDropDown, "August");
			selectDropDown(TertiaryEducationFromYearDropDown, "1999");
			selectDropDown(TertiaryEducationToMonthDropDown, "August");
			selectDropDown(TertiaryEducationToYearDropDown, "2001");
			//Secondary Education
			click(YesSecondryEducationRadioButton);
			enterText(SecondaryEducationSchoolNameTextBox,"SecondarySchoolName1");
			selectDropDown(SecondaryEducationFromMonthDropDown, "January");
			selectDropDown(SecondaryEducationFromYearDropDown, "1997");
			selectDropDown(SecondaryEducationToMonthDropDown, "December");
			selectDropDown(SecondaryEducationToYearDropDown, "1999");
			selectDropDown(SecondaryEducationLevelAchievedDropDown, "ACT Year 12 Certificate");
			//Current Employment
			click(YesCurrentlyEmployedRadioButton);
			enterText(CurrentOccupationTextBox, "CurrentOccupation");
			enterText(CurrentEmployerNameTextBox, "CurrentEmployer");
			enterText(CurrentEmploymentLevelAchievedTextBox, "CurrentLevel");
			enterText(CurrentEmploymentSalaryTextBox, "CurrentSalary");
			selectDropDown(CurrentEmploymentFromMonthDropDown, "March");
			selectDropDown(CurrentEmploymentFromYearDropDown, "2010");
			enterText(CurrentEmploymentAddress1TextBox, "CurrentAddress1");
			enterText(CurrentEmploymentAddress2TextBox, "CurrentAddress2");
			enterText(CurrentEmploymentSupervisorNameTextBox, "Supervisor");
			enterText(CurrentEmploymentSupervisorContactInformationTextBox, "0412100100");
			//Previous Employment
			click(YesPreviouslyEmployedRadioButton);
			enterText(PreviousEmploymentOccupationTextBox, "PreviousOccupation1");
			enterText(PreviousEmploymentEmployerNameTextBox,"PreviousEmployer1");
			enterText(PreviousEmploymentAddress1TextBox, "PreviousAddress1");
			enterText(PreviousEmploymentAddress2TextBox, "PreviousAddress2");
			enterText(PreviousEmploymentLevelTextBox, "PreviousEmploymentLevel");
			enterText(PreviousEmploymentSalaryTextBox, "170k");
			selectDropDown(PreviousEmploymentFromMonthDropDown, "March");
			selectDropDown(PreviousEmploymentFromYearDropDown, "2010");
			selectDropDown(PreviousEmploymentToMonthDropDown, "March");
			selectDropDown(PreviousEmploymentToYearDropDown, "2012");
			enterText(PreviousEmploymentReasonForLeavingTextBox,shortText);
			enterText(PreviousEmploymentSupervisorNameTextBox, "Supervisor");
			enterText(PreviousEmploymentSupervisorContactInformationTextBox, "0412100123");
			//Security Clearance History
			click(YesSecurityClearanceRadioButton);
			enterText(SecurityLevelOfClearenceTextBox,"SecurityLevel1");
			enterText(SecuritySponsoringAgencyTextBox, "SponsoringAgency1");
			click(YesClearanceExpiredRadioButton);
			selectDropDown(SecurityClearanceCeasedMonthDropDown, "January");
			selectDropDown(SecurityClearanceCeasedYearDropDown, "2000");
			click(YesClearanceAICRadioButton);
			selectDropDown(SecurityPositionFromMonthDropDown,"July");
			selectDropDown(SecurityPositionFromYearDropDown,"2004");
			selectDropDown(SecurityAicPositionInformationAgencyDropDown,"ASIO");
			enterText(SecurityAicPositionInformationPositionTextBox, "Skilled Assassin");
			click(YesAPCOrCAEHistoryRadioButton);
			enterText(AGSEmploymentHistoryAgsNumberTextBox,"007");
			click(YesRedundancyBenefit1RadioButton);
			enterText(ApsEmploymentHistoryAgencyTextBox,"WOWSignal");
			selectDropDown(ApsEmploymentHistoryApplicationFromMonthDropDown,"February");
			selectDropDown(ApsEmploymentHistoryApplicationFromYearDropDown, "2000");
			//Thread.sleep(3000);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public boolean FillFormReview() throws InterruptedException
	{
		
			Thread.sleep(1000);
			click(SaveAndContinueButton);
			System.out.println("Reviewed Education and Employment Page");
			return true;
	
	}
	
	public boolean FillFormShort() throws InterruptedException
	{
		try{
			//Tertiary Education
			//Thread.sleep(3000);
			click(NoTertiaryEducationRadioButton);
			//Secondary Education
			click(NoSecondryEducationRadioButton);
			//Current Employment
			click(NoCurrentlyEmployedRadioButton);
			//Previous Employment
			click(NoPreviouslyEmployedRadioButton);
			//Security Clearance History
			click(NoSecurityClearanceRadioButton);
			click(NoClearanceExpiredRadioButton);
			click(NoClearanceAICRadioButton);
			click(NoAPCOrCAEHistoryRadioButton);
			click(NoRedundancyBenefit1RadioButton);
			//Thread.sleep(3000);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	// Error Checking functions on a page
	public boolean errorChecker(WebDriver Driver,String Path,String Section,int Errors) throws IOException, InterruptedException
	{
		try
		{int count=0;
		click(SaveAndContinueButton);
		Thread.sleep(1000);
		List <WebElement> ErrorList = new ArrayList<WebElement>(); 
		ErrorList=Driver.findElements(By.xpath("//span[contains(@id,'-error')]"));
		BaseClass.myWriteAppend(Path,"");
		BaseClass.myWriteAppend(Path,Section);
		BaseClass.myWriteAppend(Path,"");
		//System.out.println("Error Message list");
		for (WebElement errrors: ErrorList)
		{
			if (!errrors.getText().isEmpty())
			{
				BaseClass.myWriteAppend(Path,"Error Text "+(count+1)+":"+errrors.getText());
				//System.out.println("Error Text "+(count+1)+":"+errrors.getText());
				count=count+1;
			}
		}
		System.out.println("Expected "+Errors+" Errors and Found "+count);
		BaseClass.myWriteAppend(Path,"");
		BaseClass.myWriteAppend(Path,"Expected "+Errors+" Errors and Found "+count);
		if (!(count==Errors))
		{
			System.out.println("Number of error Messages Inconsistant.");
			return false;

		}
		BaseClass.myWriteAppend(Path,"***********************************");
		BaseClass.myWriteAppend(Path,"");
		return true;
		}
		catch (Exception e)
		{
			return false;
		}

	}

	public boolean FillFormErrorChecker(WebDriver Driver,String Path,String Section, int Errors) throws InterruptedException, IOException
	{
		try{
			//Error Checker
			click(YesTertiaryEducationRadioButton);
			click(YesSecondryEducationRadioButton);
			selectDropDown(SecondaryEducationLevelAchievedDropDown, "Other");
			click(YesCurrentlyEmployedRadioButton);
			click(YesPreviouslyEmployedRadioButton);
			click(YesSecurityClearanceRadioButton);
			click(YesClearanceExpiredRadioButton);
			click(YesClearanceAICRadioButton);
			click(YesAPCOrCAEHistoryRadioButton);
			click(YesRedundancyBenefit1RadioButton);			
			Errorcheckresult=errorChecker(Driver,Path,Section,Errors);
			//Tertiary Education
			click(YesTertiaryEducationRadioButton);
			enterText(TertiaryEducationInstitutionTextBox, "Institution1");
			selectDropDown(TertiaryEducationQualificationDropDown, "Diploma");
			enterText(TertiaryEducationMajorAreaOfStudy1TextBox, "Major1");
			enterText(TertiaryEducationMajorAreaOfStudy2TextBox, "Major2");
			selectDropDown(TertiaryEducationFromMonthDropDown, "August");
			selectDropDown(TertiaryEducationFromYearDropDown, "1999");
			selectDropDown(TertiaryEducationToMonthDropDown, "August");
			selectDropDown(TertiaryEducationToYearDropDown, "2001");
			//Secondary Education
			click(YesSecondryEducationRadioButton);
			enterText(SecondaryEducationSchoolNameTextBox,"SecondarySchoolName1");
			selectDropDown(SecondaryEducationFromMonthDropDown, "January");
			selectDropDown(SecondaryEducationFromYearDropDown, "1997");
			selectDropDown(SecondaryEducationToMonthDropDown, "December");
			selectDropDown(SecondaryEducationToYearDropDown, "1999");
			selectDropDown(SecondaryEducationLevelAchievedDropDown, "ACT Year 12 Certificate");
			//Current Employment
			click(YesCurrentlyEmployedRadioButton);
			enterText(CurrentOccupationTextBox, "CurrentOccupation");
			enterText(CurrentEmployerNameTextBox, "CurrentEmployer");
			enterText(CurrentEmploymentLevelAchievedTextBox, "CurrentLevel");
			enterText(CurrentEmploymentSalaryTextBox, "CurrentSalary");
			selectDropDown(CurrentEmploymentFromMonthDropDown, "March");
			selectDropDown(CurrentEmploymentFromYearDropDown, "2010");
			enterText(CurrentEmploymentAddress1TextBox, "CurrentAddress1");
			enterText(CurrentEmploymentAddress2TextBox, "CurrentAddress2");
			enterText(CurrentEmploymentSupervisorNameTextBox, "Supervisor");
			enterText(CurrentEmploymentSupervisorContactInformationTextBox, "0412100100");
			//Previous Employment
			click(YesPreviouslyEmployedRadioButton);
			enterText(PreviousEmploymentOccupationTextBox, "PreviousOccupation1");
			enterText(PreviousEmploymentEmployerNameTextBox,"PreviousEmployer1");
			enterText(PreviousEmploymentAddress1TextBox, "PreviousAddress1");
			enterText(PreviousEmploymentAddress2TextBox, "PreviousAddress2");
			enterText(PreviousEmploymentLevelTextBox, "PreviousEmploymentLevel");
			enterText(PreviousEmploymentSalaryTextBox, "170k");
			selectDropDown(PreviousEmploymentFromMonthDropDown, "March");
			selectDropDown(PreviousEmploymentFromYearDropDown, "2010");
			selectDropDown(PreviousEmploymentToMonthDropDown, "March");
			selectDropDown(PreviousEmploymentToYearDropDown, "2012");
			enterText(PreviousEmploymentReasonForLeavingTextBox,shortText);
			enterText(PreviousEmploymentSupervisorNameTextBox, "Supervisor");
			enterText(PreviousEmploymentSupervisorContactInformationTextBox, "0412100123");
			//Security Clearance History
			click(YesSecurityClearanceRadioButton);
			enterText(SecurityLevelOfClearenceTextBox,"SecurityLevel1");
			enterText(SecuritySponsoringAgencyTextBox, "SponsoringAgency1");
			click(YesClearanceExpiredRadioButton);
			selectDropDown(SecurityClearanceCeasedMonthDropDown, "January");
			selectDropDown(SecurityClearanceCeasedYearDropDown, "2000");
			click(YesClearanceAICRadioButton);
			selectDropDown(SecurityPositionFromMonthDropDown,"July");
			selectDropDown(SecurityPositionFromYearDropDown,"2004");
			selectDropDown(SecurityAicPositionInformationAgencyDropDown,"ASIO");
			enterText(SecurityAicPositionInformationPositionTextBox, "Skilled Assassin");
			click(YesAPCOrCAEHistoryRadioButton);
			enterText(AGSEmploymentHistoryAgsNumberTextBox,"007");
			click(YesRedundancyBenefit1RadioButton);
			enterText(ApsEmploymentHistoryAgencyTextBox,"WOWSignal");
			selectDropDown(ApsEmploymentHistoryApplicationFromMonthDropDown,"February");
			selectDropDown(ApsEmploymentHistoryApplicationFromYearDropDown, "2000");
			//Thread.sleep(3000);
			click(SaveAndContinueButton);
			if (!(Errorcheckresult)){
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


} 

