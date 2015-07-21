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


public class Step2_PartnerAndRelationship_PageObjects extends BaseClass{
	public WebDriver driver;
	static String specialText="This is <test> #1" ;
	boolean Errorcheckresult;
	// The element is now looked up using the name/ID/XPATH attribute

	//Partner Information
	@FindBy(how=How.XPATH, using = "//label[@for='currentPartner1']")
	public WebElement NoCurrentPartnerRadioButton ;
	@FindBy(how=How.XPATH, using = "//label[@for='currentPartner2']")
	public WebElement YesCurrentPartnerRadioButton ;
	@FindBy(how=How.ID, using = "CurrentPartner_GivenName")
	public WebElement CurrentPartnerGivenName ;
	@FindBy(how=How.ID, using = "CurrentPartner_Surname")
	public WebElement CurrentPartnerSurname ;
	@FindBy(how=How.ID, using = "CurrentPartner_PreviousName")
	public WebElement CurrentPartnerPreviousName ;
	@FindBy(how=How.XPATH, using = "//label[@for='gender1']")
	public WebElement MaleCurrentPartenrRadioButton ;
	@FindBy(how=How.XPATH, using = "//label[@for='gender2']")
	public WebElement FemaleCurrentPartenrRadioButton ;
	@FindBy(how = How.ID, using = "CurrentPartner_DayOfBirth")
	public WebElement CurrentPartnerDayOfBirth;
	@FindBy(how = How.ID, using = "CurrentPartner_MonthOfBirth")
	public WebElement CurrentPartnerMonthOfBirth;
	@FindBy(how = How.ID, using = "CurrentPartner_YearOfBirth")
	public WebElement CurrentPartnerYearOfBirth;
	@FindBy(how = How.ID, using = "CurrentPartner_CountryOfBirth")
	public WebElement CurrentPartnerCountryOfBirth;
	@FindBy(how = How.ID, using = "CurrentPartner_StateOfBirth")
	public WebElement CurrentPartnerStateOfBirth;
	@FindBy(how = How.ID, using = "CurrentPartner_CityOfBirth")
	public WebElement CurrentPartnerCityOfBirth;
	@FindBy(how = How.ID, using = "CurrentPartner_DayPartnershipCommenced")
	public WebElement CurrentPartnerDayPartnershipCommenced;
	@FindBy(how = How.ID, using = "CurrentPartner_MonthPartnershipCommenced")
	public WebElement CurrentPartnerMonthPartnershipCommenced;
	@FindBy(how = How.ID, using = "CurrentPartner_YearPartnershipCommenced")
	public WebElement CurrentPartnerYearPartnershipCommenced;
	@FindBy(how = How.ID, using = "CurrentPartner_NatureOfRelationship")
	public WebElement CurrentPartnerNatureOfRelationship;

	//Significant Relationships Information
	@FindBy(how=How.XPATH, using = "//label[@for='sRelationship1']")
	public WebElement NoSigPartnerRadioButton ;
	@FindBy(how=How.XPATH, using = "//label[contains(@for,'sRelationship2')]")
	public WebElement YesSigPartnerRadioButton ;
	@FindBy(how=How.ID, using = "Relationship[0].PartnerInformation.GivenName")
	public WebElement SigPartnerInformationGivenName ;
	@FindBy(how=How.ID, using = "Relationship[0].PartnerInformation.Surname")
	public WebElement SigPartnerInformationSurname ;
	@FindBy(how=How.ID, using = "Relationship[0].PartnerInformation.PreviousName")
	public WebElement SigPartnerInformationPreviousName ;
	@FindBy(how=How.XPATH, using = "//label[@for='sRelationshipGender1[1]']") 
	public WebElement MaleSigPartenrRadioButton ;
	@FindBy(how=How.XPATH, using = "//label[@for='sRelationshipGender2[1']")
	public WebElement FemaleSigPartenrRadioButton ;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.DayOfBirth")
	public WebElement SigPartnerInformationDayOfBirth;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.MonthOfBirth")
	public WebElement SigPartnerInformationMonthOfBirth;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.YearOfBirth")
	public WebElement SigPartnerInformationYearOfBirth;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.CountryOfBirth")
	public WebElement SigPartnerInformationCountryOfBirth;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.StateOfBirth")
	public WebElement SigPartnerInformationStateOfBirth;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.CityOfBirth")
	public WebElement SigPartnerInformationCityOfBirth;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.DayPartnershipCommenced")
	public WebElement SigPartnerInformationDayPartnershipCommenced;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.MonthPartnershipCommenced")
	public WebElement SigPartnerInformationMonthPartnershipCommenced;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.YearPartnershipCommenced")
	public WebElement SigPartnerInformationYearPartnershipCommenced;
	@FindBy(how = How.ID, using = "Relationship[0].PartnerInformation.NatureOfRelationship")
	public WebElement SigPartnerInformationNatureOfRelationship;


	@FindBy(how = How.XPATH, using = "//a[contains(.,' Add another relationship')]")
	public WebElement AddAnotherRelationshipButton;
	@FindBy(how = How.XPATH, using = "//input[@value='Save & Continue']")
	public WebElement SaveAndContinueButton;




	public boolean FillFormStandard() throws InterruptedException
	{
		try{
			//Thread.sleep(5000);
			//Partner Information
			click(YesCurrentPartnerRadioButton);
			enterText(CurrentPartnerGivenName, "TestName");
			enterText(CurrentPartnerSurname, "TestSurname");
			enterText(CurrentPartnerPreviousName, "TestPreviousname");
			click(MaleCurrentPartenrRadioButton);
			selectDropDown(CurrentPartnerDayOfBirth, "23");
			selectDropDown(CurrentPartnerMonthOfBirth, "March");
			selectDropDown(CurrentPartnerYearOfBirth, "1980");
			enterText(CurrentPartnerCountryOfBirth, "TestCountry");
			enterText(CurrentPartnerCityOfBirth, "TestCity");
			enterText(CurrentPartnerStateOfBirth, "TestState");
			selectDropDown(CurrentPartnerDayPartnershipCommenced, "15");
			selectDropDown(CurrentPartnerMonthPartnershipCommenced, "March");
			selectDropDown(CurrentPartnerYearPartnershipCommenced, "1980");
			selectDropDown(CurrentPartnerNatureOfRelationship, "Married");
			//Significant Relationships Information
			click(YesSigPartnerRadioButton);
			enterText(SigPartnerInformationGivenName, "TestSigName");
			enterText(SigPartnerInformationSurname, "TestSigSurname");
			enterText(SigPartnerInformationPreviousName, "TestSigPreviousname");
			click(MaleSigPartenrRadioButton);
			selectDropDown(SigPartnerInformationDayOfBirth, "21");
			selectDropDown(SigPartnerInformationMonthOfBirth, "April");
			selectDropDown(SigPartnerInformationYearOfBirth, "1982");
			enterText(SigPartnerInformationCountryOfBirth, "TestSigCountry");
			enterText(SigPartnerInformationCityOfBirth, "TestSigCity");
			enterText(SigPartnerInformationStateOfBirth, "TestSigState");
			selectDropDown(SigPartnerInformationDayPartnershipCommenced, "11");
			selectDropDown(SigPartnerInformationMonthPartnershipCommenced, "March");
			selectDropDown(SigPartnerInformationYearPartnershipCommenced, "1980");
			selectDropDown(SigPartnerInformationNatureOfRelationship, "Defacto");
			click(SaveAndContinueButton);
			//Thread.sleep(5000);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean FillFormSubStandard() throws InterruptedException
	{
		try{
			//Thread.sleep(5000);
			//Partner Information
			
			click(YesCurrentPartnerRadioButton);
			enterText(CurrentPartnerGivenName,specialText);
			enterText(CurrentPartnerSurname, specialText);
			enterText(CurrentPartnerPreviousName, specialText);
			click(MaleCurrentPartenrRadioButton);
			selectDropDown(CurrentPartnerDayOfBirth, "23");
			selectDropDown(CurrentPartnerMonthOfBirth, "March");
			selectDropDown(CurrentPartnerYearOfBirth, "1980");
			enterText(CurrentPartnerCountryOfBirth, specialText);
			enterText(CurrentPartnerCityOfBirth, specialText);
			enterText(CurrentPartnerStateOfBirth, specialText);
			selectDropDown(CurrentPartnerDayPartnershipCommenced, "15");
			selectDropDown(CurrentPartnerMonthPartnershipCommenced, "March");
			selectDropDown(CurrentPartnerYearPartnershipCommenced, "1980");
			selectDropDown(CurrentPartnerNatureOfRelationship, "Married");
			//Significant Relationships Information
			click(YesSigPartnerRadioButton);
			enterText(SigPartnerInformationGivenName, specialText);
			enterText(SigPartnerInformationSurname, specialText);
			enterText(SigPartnerInformationPreviousName, specialText);
			click(MaleSigPartenrRadioButton);
			selectDropDown(SigPartnerInformationDayOfBirth, "21");
			selectDropDown(SigPartnerInformationMonthOfBirth, "April");
			selectDropDown(SigPartnerInformationYearOfBirth, "1982");
			enterText(SigPartnerInformationCountryOfBirth, specialText);
			enterText(SigPartnerInformationCityOfBirth, specialText);
			enterText(SigPartnerInformationStateOfBirth, specialText);
			selectDropDown(SigPartnerInformationDayPartnershipCommenced, "11");
			selectDropDown(SigPartnerInformationMonthPartnershipCommenced, "March");
			selectDropDown(SigPartnerInformationYearPartnershipCommenced, "1980");
			selectDropDown(SigPartnerInformationNatureOfRelationship, "Defacto");
			click(SaveAndContinueButton);
			Thread.sleep(2000);
			click(YesCurrentPartnerRadioButton);
			enterText(CurrentPartnerGivenName, "TestName");
			enterText(CurrentPartnerSurname, "TestSurname");
			enterText(CurrentPartnerPreviousName, "TestPreviousname");
			click(MaleCurrentPartenrRadioButton);
			selectDropDown(CurrentPartnerDayOfBirth, "23");
			selectDropDown(CurrentPartnerMonthOfBirth, "March");
			selectDropDown(CurrentPartnerYearOfBirth, "1980");
			enterText(CurrentPartnerCountryOfBirth, "TestCountry");
			enterText(CurrentPartnerCityOfBirth, "TestCity");
			enterText(CurrentPartnerStateOfBirth, "TestState");
			selectDropDown(CurrentPartnerDayPartnershipCommenced, "15");
			selectDropDown(CurrentPartnerMonthPartnershipCommenced, "March");
			selectDropDown(CurrentPartnerYearPartnershipCommenced, "1980");
			selectDropDown(CurrentPartnerNatureOfRelationship, "Married");
			//Significant Relationships Information
			click(YesSigPartnerRadioButton);
			enterText(SigPartnerInformationGivenName, "TestSigName");
			enterText(SigPartnerInformationSurname, "TestSigSurname");
			enterText(SigPartnerInformationPreviousName, "TestSigPreviousname");
			click(MaleSigPartenrRadioButton);
			selectDropDown(SigPartnerInformationDayOfBirth, "21");
			selectDropDown(SigPartnerInformationMonthOfBirth, "April");
			selectDropDown(SigPartnerInformationYearOfBirth, "1982");
			enterText(SigPartnerInformationCountryOfBirth, "TestSigCountry");
			enterText(SigPartnerInformationCityOfBirth, "TestSigCity");
			enterText(SigPartnerInformationStateOfBirth, "TestSigState");
			selectDropDown(SigPartnerInformationDayPartnershipCommenced, "11");
			selectDropDown(SigPartnerInformationMonthPartnershipCommenced, "March");
			selectDropDown(SigPartnerInformationYearPartnershipCommenced, "1980");
			selectDropDown(SigPartnerInformationNatureOfRelationship, "Defacto");
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
			System.out.println("Reviewed Relationship Page");
			return true;
	
	}
	public boolean FillFormShort() throws InterruptedException
	{
		try{
			//Thread.sleep(5000);
			//Partner Information
			click(NoCurrentPartnerRadioButton);
			//Significant Relationships Information
			click(NoSigPartnerRadioButton);
			click(SaveAndContinueButton);
			//Thread.sleep(5000);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean FillFormNonStandard() throws InterruptedException
	{
		try{
			//Thread.sleep(5000);
			//Partner Information
			click(YesCurrentPartnerRadioButton);
			enterText(CurrentPartnerGivenName, "TestName1");
			enterText(CurrentPartnerSurname, "TestSurname1");
			enterText(CurrentPartnerPreviousName, "TestPreviousname1");
			click(MaleCurrentPartenrRadioButton);
			selectDropDown(CurrentPartnerDayOfBirth, "23");
			selectDropDown(CurrentPartnerMonthOfBirth, "March");
			selectDropDown(CurrentPartnerYearOfBirth, "1980");
			enterText(CurrentPartnerCountryOfBirth, "TestCountry1");
			enterText(CurrentPartnerCityOfBirth, "TestCity1");
			enterText(CurrentPartnerStateOfBirth, "TestState1");
			selectDropDown(CurrentPartnerDayPartnershipCommenced, "15");
			selectDropDown(CurrentPartnerMonthPartnershipCommenced, "March");
			selectDropDown(CurrentPartnerYearPartnershipCommenced, "1980");
			selectDropDown(CurrentPartnerNatureOfRelationship, "Married");
			//Significant Relationships Information
			click(YesSigPartnerRadioButton);
			enterText(SigPartnerInformationGivenName, "TestSigName1");
			enterText(SigPartnerInformationSurname, "TestSigSurname1");
			enterText(SigPartnerInformationPreviousName, "TestSigPreviousname1");
			click(MaleSigPartenrRadioButton);
			selectDropDown(SigPartnerInformationDayOfBirth, "21");
			selectDropDown(SigPartnerInformationMonthOfBirth, "April");
			selectDropDown(SigPartnerInformationYearOfBirth, "1982");
			enterText(SigPartnerInformationCountryOfBirth, "TestSigCountry1");
			enterText(SigPartnerInformationCityOfBirth, "TestSigCity1");
			enterText(SigPartnerInformationStateOfBirth, "TestSigState1");
			selectDropDown(SigPartnerInformationDayPartnershipCommenced, "11");
			selectDropDown(SigPartnerInformationMonthPartnershipCommenced, "March");
			selectDropDown(SigPartnerInformationYearPartnershipCommenced, "1980");
			selectDropDown(SigPartnerInformationNatureOfRelationship, "Defacto");
			click(SaveAndContinueButton);
			//Thread.sleep(5000);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean MultiSignificantPartnerFiller(WebDriver Driver, int partners) throws InterruptedException
	{

		try{//Significant Relationships Information
			click(YesSigPartnerRadioButton);
			enterText(SigPartnerInformationGivenName, "TestSigName");
			enterText(SigPartnerInformationSurname, "TestSigSurname");
			enterText(SigPartnerInformationPreviousName, "TestSigPreviousname");
			click(MaleSigPartenrRadioButton);
			selectDropDown(SigPartnerInformationDayOfBirth, "20");
			selectDropDown(SigPartnerInformationMonthOfBirth, "April");
			selectDropDown(SigPartnerInformationYearOfBirth, "1982");
			enterText(SigPartnerInformationCountryOfBirth, "TestSigCountry");
			enterText(SigPartnerInformationCityOfBirth, "TestSigCity");
			enterText(SigPartnerInformationStateOfBirth, "TestSigState");
			selectDropDown(SigPartnerInformationDayPartnershipCommenced, "10");
			selectDropDown(SigPartnerInformationMonthPartnershipCommenced, "March");
			selectDropDown(SigPartnerInformationYearPartnershipCommenced, "1980");
			selectDropDown(SigPartnerInformationNatureOfRelationship, "Defacto");
			try{
				for(int i=1;i<partners;i++)
				{
					click(AddAnotherRelationshipButton);
					Thread.sleep(1000);
					enterText(Driver.findElement(By.xpath("//*[@name='Relationship["+i+"].PartnerInformation.GivenName']")),"MultitestName");
					enterText(Driver.findElement(By.xpath("//*[@name='Relationship["+i+"].PartnerInformation.Surname']")),"MultitestSurname");
					enterText(Driver.findElement(By.xpath("//*[@name='Relationship["+i+"].PartnerInformation.PreviousName']")),"MultitestPerviousname");
					//System.out.println("Total elements found: "+Driver.findElements(By.xpath("//label[@for='sRelationshipGender11']")).size());
					click(Driver.findElement(By.xpath("//label[@for='sRelationshipGender1["+i+"0"+i+"3]']")));
					selectDropDown(Driver.findElement(By.xpath("//select[@name='Relationship["+i+"].PartnerInformation.DayOfBirth']")),"22");
					selectDropDown(Driver.findElement(By.xpath("//select[@name='Relationship["+i+"].PartnerInformation.MonthOfBirth']")),"April");
					selectDropDown(Driver.findElement(By.xpath("//select[@name='Relationship["+i+"].PartnerInformation.YearOfBirth']")),"1980");
					enterText(Driver.findElement(By.xpath("//*[@name='Relationship["+i+"].PartnerInformation.CountryOfBirth']")),"MultitestCountryOfBirth");
					enterText(Driver.findElement(By.xpath("//*[@name='Relationship["+i+"].PartnerInformation.CityOfBirth']")),"MultitestCityOfBirth");
					enterText(Driver.findElement(By.xpath("//*[@name='Relationship["+i+"].PartnerInformation.StateOfBirth']")),"MultitestStateOfBirth");
					selectDropDown(Driver.findElement(By.xpath("//select[@name='Relationship["+i+"].PartnerInformation.DayPartnershipCommenced']")),"11");
					selectDropDown(Driver.findElement(By.xpath("//select[@name='Relationship["+i+"].PartnerInformation.MonthPartnershipCommenced']")),"August");
					selectDropDown(Driver.findElement(By.xpath("//select[@name='Relationship["+i+"].PartnerInformation.YearPartnershipCommenced']")),"1980");
					selectDropDown(Driver.findElement(By.xpath("//select[@name='Relationship["+i+"].PartnerInformation.NatureOfRelationship']")),"Defacto");
				}
			}
			catch (Exception E)
			{

				System.out.println("Could not find element");
				return false;
			}
			Thread.sleep(5000);
			click(SaveAndContinueButton);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean FillFormMultipartner(WebDriver Driver,int Partners) throws InterruptedException
	{
		try
		{//Thread.sleep(5000);
		//Partner Information
		click(YesCurrentPartnerRadioButton);
		enterText(CurrentPartnerGivenName, "TestName");
		enterText(CurrentPartnerSurname, "TestSurname");
		enterText(CurrentPartnerPreviousName, "TestPreviousname");
		click(MaleCurrentPartenrRadioButton);
		selectDropDown(CurrentPartnerDayOfBirth, "12");
		selectDropDown(CurrentPartnerMonthOfBirth, "March");
		selectDropDown(CurrentPartnerYearOfBirth, "1980");
		enterText(CurrentPartnerCountryOfBirth, "TestCountry");
		enterText(CurrentPartnerCityOfBirth, "TestCity");
		enterText(CurrentPartnerStateOfBirth, "TestState");
		selectDropDown(CurrentPartnerDayPartnershipCommenced, "19");
		selectDropDown(CurrentPartnerMonthPartnershipCommenced, "March");
		selectDropDown(CurrentPartnerYearPartnershipCommenced, "1980");
		selectDropDown(CurrentPartnerNatureOfRelationship, "Married");

		//Significant Relationships Information
		MultiSignificantPartnerFiller(Driver,Partners);
		Thread.sleep(1000);
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
			click(YesCurrentPartnerRadioButton);
			click(YesSigPartnerRadioButton);
			selectDropDown(SigPartnerInformationNatureOfRelationship, "Other");
			selectDropDown(CurrentPartnerNatureOfRelationship, "Other");
			Errorcheckresult=errorChecker(Driver,Path,Section,Errors);
			
			//Partner Information
			click(YesCurrentPartnerRadioButton);
			enterText(CurrentPartnerGivenName, "TestName");
			enterText(CurrentPartnerSurname, "TestSurname");
			enterText(CurrentPartnerPreviousName, "TestPreviousname");
			click(MaleCurrentPartenrRadioButton);
			selectDropDown(CurrentPartnerDayOfBirth, "23");
			selectDropDown(CurrentPartnerMonthOfBirth, "March");
			selectDropDown(CurrentPartnerYearOfBirth, "1980");
			enterText(CurrentPartnerCountryOfBirth, "TestCountry");
			enterText(CurrentPartnerCityOfBirth, "TestCity");
			enterText(CurrentPartnerStateOfBirth, "TestState");
			selectDropDown(CurrentPartnerDayPartnershipCommenced, "15");
			selectDropDown(CurrentPartnerMonthPartnershipCommenced, "March");
			selectDropDown(CurrentPartnerYearPartnershipCommenced, "1980");
			selectDropDown(CurrentPartnerNatureOfRelationship, "Married");
			//Significant Relationships Information
			click(YesSigPartnerRadioButton);
			enterText(SigPartnerInformationGivenName, "TestSigName");
			enterText(SigPartnerInformationSurname, "TestSigSurname");
			enterText(SigPartnerInformationPreviousName, "TestSigPreviousname");
			click(MaleSigPartenrRadioButton);
			selectDropDown(SigPartnerInformationDayOfBirth, "21");
			selectDropDown(SigPartnerInformationMonthOfBirth, "April");
			selectDropDown(SigPartnerInformationYearOfBirth, "1982");
			enterText(SigPartnerInformationCountryOfBirth, "TestSigCountry");
			enterText(SigPartnerInformationCityOfBirth, "TestSigCity");
			enterText(SigPartnerInformationStateOfBirth, "TestSigState");
			selectDropDown(SigPartnerInformationDayPartnershipCommenced, "11");
			selectDropDown(SigPartnerInformationMonthPartnershipCommenced, "March");
			selectDropDown(SigPartnerInformationYearPartnershipCommenced, "1980");
			selectDropDown(SigPartnerInformationNatureOfRelationship, "Defacto");
			click(SaveAndContinueButton);
			//Thread.sleep(5000);
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

