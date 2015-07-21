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


public class Step4_ExtraCurrAndForeignExp_PageObjects extends BaseClass{
	public WebDriver driver;
	static String specialText="This is <test> #1" ;
	String longText="This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again.This is a test to make sure we can enter some random text over and over again. ";
	String shortText="This is a test to make sure we can enter some random text over and over again.";
	boolean Errorcheckresult;
	// The element is now looked up using the name/ID/XPATH attribute

	//Foreign Language Information Section
	@FindBy (how =How.XPATH, using="//label[@for='foreignLanguages1']")
	WebElement YesForeignLanguageProficiencyRadioButton;
	@FindBy (how =How.XPATH, using="//label[@for='foreignLanguages2']")
	WebElement NoForeignLanguageProficiencyRadioButton;
	@FindBy(how=How.ID,using="ForeignLanguageList[0].Language")
	WebElement ForeignLanguageTextbox;
	@FindBy(how=How.ID,using="ForeignLanguageList[0].Institution")
	WebElement ForeignLanguageInstitutionTextbox;
	@FindBy(how=How.ID,using="ForeignLanguageList[0].SpeakingAbility")
	WebElement ForeignLanguageSpeakingAbilityDropDown;
	@FindBy(how=How.ID,using="ForeignLanguageList[0].ReadingAbility")
	WebElement ForeignLanguageReadingAbilityDropDown;
	@FindBy(how=How.XPATH, using="//a[contains(.,' Add another Foreign Language')]")
	WebElement AddAnotherForeignLanguageButton;

	//Overseas Travel Information Section
	@FindBy(how=How.XPATH,using="//label[@for='oTravel1']")
	WebElement YesTravelOverseasRadioButton;
	@FindBy(how=How.ID,using="OverseasTravelList[0].Country")
	WebElement TravelOverseasCountryTextBox;
	@FindBy(how=How.ID,using="OverseasTravelList[0].Reason")
	WebElement TravelOverseasReasonTextBox;
	@FindBy(how=How.ID,using="OverseasTravelList[0].FromMonth")
	WebElement TravelOverseasOverseasFromMonthDropDown;
	@FindBy(how=How.ID,using="OverseasTravelList[0].FromYear")
	WebElement TravelOverseasOverseasFromYearDropDown;
	@FindBy(how=How.ID,using="OverseasTravelList[0].ToMonth")
	WebElement TravelOverseasOverseasToMonthDropDown;
	@FindBy(how=How.ID,using="OverseasTravelList[0].ToYear")
	WebElement TravelOverseasOverseasToYearDropDown;	
	@FindBy(how=How.XPATH,using="//label[@for='oTravel2']")
	WebElement NoTravelOverseasRadioButton;
	@FindBy(how=How.XPATH,using="//a[contains(.,' Add another International Destination')]")
	WebElement AddAnotherInternationalDestinationButton;

	//Club or Society Membership Information Section
	@FindBy(how=How.XPATH,using="//label[@for='cORsMembership1']")
	WebElement YesMemberClubSocietyRadioButton;
	@FindBy(how=How.ID,using="ClubOrSocietyMembershipList[0].Organisation")
	WebElement ClubOrSocietyOrganisationTextBox ;
	@FindBy(how=How.ID,using="ClubOrSocietyMembershipList[0].Purpose")
	WebElement ClubOrSocietyPurposeTextBox ;
	@FindBy(how=How.ID,using="ClubOrSocietyMembershipList[0].FromMonth")
	WebElement ClubOrSocietyMembershipFromMonthDropDown ;
	@FindBy(how=How.ID,using="ClubOrSocietyMembershipList[0].FromYear")
	WebElement ClubOrSocietyMembershipFromYearDropDown ;
	@FindBy(how=How.ID,using="ClubOrSocietyMembershipList[0].ToMonth")
	WebElement ClubOrSocietyMembershipToMonthDropDown ;
	@FindBy(how=How.ID,using="ClubOrSocietyMembershipList[0].ToYear")
	WebElement ClubOrSocietyMembershipToYearDropDown ;
	@FindBy(how=How.ID,using="ClubOrSocietyMembershipList[0].ReasonForLeaving")
	WebElement ClubOrSocietyReasonForLeavingTextBox ;
	@FindBy(how=How.XPATH,using="//label[@for='cORsMembership2']")
	WebElement NoMemberClubSocietyRadioButton;
	@FindBy(how=How.XPATH,using="//a[contains(.,' Add another Club / Society')]")
	WebElement AddAnotherClubSocietyButton;

	//Additional Information Section
	@FindBy(how=How.ID,using= "AdditionalInformation")
	WebElement AdditionalInformationTextBox;

	@FindBy(how=How.XPATH,using="//input[@value='Save & Continue']")
	WebElement SaveAndContinueButton;

	public boolean FillFormStandard() throws InterruptedException
	{
		try{
			//Foreign Language Information
			click(YesForeignLanguageProficiencyRadioButton);
			enterText(ForeignLanguageTextbox,"French");
			enterText(ForeignLanguageInstitutionTextbox,"TOFFL PTY LTD");
			selectDropDown(ForeignLanguageSpeakingAbilityDropDown, "S3 Professional Proficiency");
			selectDropDown(ForeignLanguageReadingAbilityDropDown, "R1 Elementary Proficiency");
			//Overseas Travel Information
			click(YesTravelOverseasRadioButton);
			enterText(TravelOverseasCountryTextBox,"South America");
			enterText(TravelOverseasReasonTextBox,"Had business to attend");
			selectDropDown(TravelOverseasOverseasFromMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasFromYearDropDown,"2005");
			selectDropDown(TravelOverseasOverseasToMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasToYearDropDown, "2006");
			//Club or Society Membership Information
			click(YesMemberClubSocietyRadioButton);
			enterText(ClubOrSocietyOrganisationTextBox,"IEEE Australia");
			enterText(ClubOrSocietyPurposeTextBox,"To make this a better place");
			selectDropDown(ClubOrSocietyMembershipFromMonthDropDown,"October");
			selectDropDown(ClubOrSocietyMembershipFromYearDropDown,"1990");
			selectDropDown(ClubOrSocietyMembershipToMonthDropDown,"January");
			selectDropDown(ClubOrSocietyMembershipToYearDropDown, "2014");
			enterText(ClubOrSocietyReasonForLeavingTextBox,"The club ceased to exist.");
			//Additional Information
			enterText(AdditionalInformationTextBox,shortText);
			//Save and Continue		
			click(SaveAndContinueButton);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean FillFormSubStandard() throws InterruptedException
	{
		try{//Foreign Language Information
			click(YesForeignLanguageProficiencyRadioButton);
			enterText(ForeignLanguageTextbox,specialText);
			enterText(ForeignLanguageInstitutionTextbox,specialText);
			selectDropDown(ForeignLanguageSpeakingAbilityDropDown, "S3 Professional Proficiency");
			selectDropDown(ForeignLanguageReadingAbilityDropDown, "R1 Elementary Proficiency");
			//Overseas Travel Information
			click(YesTravelOverseasRadioButton);
			enterText(TravelOverseasCountryTextBox,specialText);
			enterText(TravelOverseasReasonTextBox,specialText);
			selectDropDown(TravelOverseasOverseasFromMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasFromYearDropDown,"2005");
			selectDropDown(TravelOverseasOverseasToMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasToYearDropDown, "2006");
			//Club or Society Membership Information
			click(YesMemberClubSocietyRadioButton);
			enterText(ClubOrSocietyOrganisationTextBox,specialText);
			enterText(ClubOrSocietyPurposeTextBox,specialText);
			selectDropDown(ClubOrSocietyMembershipFromMonthDropDown,"October");
			selectDropDown(ClubOrSocietyMembershipFromYearDropDown,"1990");
			selectDropDown(ClubOrSocietyMembershipToMonthDropDown,"January");
			selectDropDown(ClubOrSocietyMembershipToYearDropDown, "2014");
			enterText(ClubOrSocietyReasonForLeavingTextBox,specialText);
			//Additional Information
			enterText(AdditionalInformationTextBox,specialText);
			//Save and Continue		
			click(SaveAndContinueButton);
			
			
			
			//Foreign Language Information
			click(YesForeignLanguageProficiencyRadioButton);
			enterText(ForeignLanguageTextbox,"French");
			enterText(ForeignLanguageInstitutionTextbox,"TOFFL PTY LTD");
			selectDropDown(ForeignLanguageSpeakingAbilityDropDown, "S3 Professional Proficiency");
			selectDropDown(ForeignLanguageReadingAbilityDropDown, "R1 Elementary Proficiency");
			//Overseas Travel Information
			click(YesTravelOverseasRadioButton);
			enterText(TravelOverseasCountryTextBox,"South America");
			enterText(TravelOverseasReasonTextBox,"Had business to attend");
			selectDropDown(TravelOverseasOverseasFromMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasFromYearDropDown,"2005");
			selectDropDown(TravelOverseasOverseasToMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasToYearDropDown, "2006");
			//Club or Society Membership Information
			click(YesMemberClubSocietyRadioButton);
			enterText(ClubOrSocietyOrganisationTextBox,"IEEE Australia");
			enterText(ClubOrSocietyPurposeTextBox,"To make this a better place");
			selectDropDown(ClubOrSocietyMembershipFromMonthDropDown,"October");
			selectDropDown(ClubOrSocietyMembershipFromYearDropDown,"1990");
			selectDropDown(ClubOrSocietyMembershipToMonthDropDown,"January");
			selectDropDown(ClubOrSocietyMembershipToYearDropDown, "2014");
			enterText(ClubOrSocietyReasonForLeavingTextBox,"The club ceased to exist.");
			//Additional Information
			enterText(AdditionalInformationTextBox,shortText);
			//Save and Continue		
			click(SaveAndContinueButton);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean FillFormReview() throws InterruptedException
	{
		
			Thread.sleep(1000);
			click(SaveAndContinueButton);
			System.out.println("Reviewed Foreign Experience Page");
			return true;
	
	}
	
	public boolean FillFormShort() throws InterruptedException
	{
		try{
			//Foreign Language Information
			click(NoForeignLanguageProficiencyRadioButton);
			//Overseas Travel Information
			click(NoTravelOverseasRadioButton);
			//Club or Society Membership Information
			click(NoMemberClubSocietyRadioButton);
			//Additional Information
			enterText(AdditionalInformationTextBox,shortText);
			//Save and Continue		
			click(SaveAndContinueButton);
			return true;
		}catch(Exception e)
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
			click(YesForeignLanguageProficiencyRadioButton);
			click(YesTravelOverseasRadioButton);
			click(YesMemberClubSocietyRadioButton);
			Errorcheckresult=errorChecker(Driver,Path,Section,Errors);
			//Foreign Language Information
			click(YesForeignLanguageProficiencyRadioButton);
			enterText(ForeignLanguageTextbox,"French");
			enterText(ForeignLanguageInstitutionTextbox,"TOFFL PTY LTD");
			selectDropDown(ForeignLanguageSpeakingAbilityDropDown, "S3 Professional Proficiency");
			selectDropDown(ForeignLanguageReadingAbilityDropDown, "R1 Elementary Proficiency");
			//Overseas Travel Information
			click(YesTravelOverseasRadioButton);
			enterText(TravelOverseasCountryTextBox,"South America");
			enterText(TravelOverseasReasonTextBox,"Had business to attend");
			selectDropDown(TravelOverseasOverseasFromMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasFromYearDropDown,"2005");
			selectDropDown(TravelOverseasOverseasToMonthDropDown,"January");
			selectDropDown(TravelOverseasOverseasToYearDropDown, "2006");
			//Club or Society Membership Information
			click(YesMemberClubSocietyRadioButton);
			enterText(ClubOrSocietyOrganisationTextBox,"IEEE Australia");
			enterText(ClubOrSocietyPurposeTextBox,"To make this a better place");
			selectDropDown(ClubOrSocietyMembershipFromMonthDropDown,"October");
			selectDropDown(ClubOrSocietyMembershipFromYearDropDown,"1990");
			selectDropDown(ClubOrSocietyMembershipToMonthDropDown,"January");
			selectDropDown(ClubOrSocietyMembershipToYearDropDown, "2014");
			enterText(ClubOrSocietyReasonForLeavingTextBox,"The club ceased to exist.");
			//Additional Information
			enterText(AdditionalInformationTextBox,shortText);
			//Save and Continue		
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


