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


public class Step1_Personal_PageObjects extends BaseClass{
	public WebDriver driver;
	static String specialText="This is <test> #1" ;
	String imageURL="http://1.bp.blogspot.com/_aLNA1ox5acg/TIAbwsOsqlI/AAAAAAAAB4Y/woHUwwEMfWI/s400/machetePoster.jpg";
	String imageURL1="http://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Abraham_Lincoln_head_on_shoulders_photo_portrait.jpg/780px-Abraham_Lincoln_head_on_shoulders_photo_portrait.jpg";
	String cvURL="http://www.oracle.com/us/support/library/057419.pdf";
	boolean Errorcheckresult;
	// The element is now looked up using the name/ID/XPATH attribute


	//Form Startup
	@FindBy(how=How.XPATH, using = "//label[@for='termsconditions']")
	public WebElement AcknowledgementCheckbox ;

	@FindBy(how=How.XPATH, using = "//input[@value='I UNDERSTAND']")
	public WebElement IUnderstandButton ;
	@FindBy(how=How.XPATH, using = "//a[contains(.,' CANCEL')]")
	public WebElement CancelButton ;

	//Profile Photo Section
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[1]/form/div[1]/div/div/div[2]/div/div/div[4]/fieldset/label")
	public WebElement UploadPhotoFromComputerRadioButton;

	@FindBy(how = How.XPATH, using = "//a[contains(.,' Attach photo')]")
	public WebElement UploadPhotoFromComputerButton;

	@FindBy(how = How.ID, using = "UploadImage")
	public WebElement UploadPhotoBrowseTextBox;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[1]/form/div[1]/div/div/div[2]/div/div/div[5]/fieldset/label")
	public WebElement DownloadPhotoFromURLRadioButton;

	@FindBy(how = How.XPATH, using = "//input[@id='DownloadProfileImageUrl']")
	public WebElement DownloadPhotoFromURLTextBox;

	//CV Section
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[1]/form/div[1]/div/div/div[2]/div/div/div[9]/fieldset/label")
	public WebElement UploadCVFromComputerRadioButton;

	@FindBy(how = How.ID, using = "UploadedCv")
	public WebElement UploadCVBrowseTextBox;

	@FindBy(how = How.XPATH, using = "//a[contains(.,' Attach CV')]")
	public WebElement UploadCVFromComputerButton;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[1]/form/div[1]/div/div/div[2]/div/div/div[10]/fieldset/label")
	public WebElement DownloadCVFromURLRadioButton;

	@FindBy(how = How.XPATH, using = "//input[@id='DownloadCvUrl']")
	public WebElement DownloadCVFromURLTextBox;

	//Personal Information Section
	@FindBy(how = How.ID, using = "PersonsTitle")
	public WebElement TitleDropDown;
	@FindBy(how = How.ID, using = "GivenName")
	public WebElement GivenNameTextbox;
	@FindBy(how = How.ID, using = "MiddleName")
	public WebElement MiddleNameTextbox;
	@FindBy(how = How.ID, using = "Surname")
	public WebElement SurnameTextbox;
	@FindBy(how = How.ID, using = "PreferredName")
	public WebElement PreferredNameTextbox;
	@FindBy (how=How.XPATH, using ="//label[@for='myDriversCheck1']")
	public WebElement CurrentLicenseCheckBox;
	@FindBy(how = How.ID, using = "DriveLicenseNumber")
	public WebElement DLNumberTextbox;
	@FindBy(how = How.ID, using = "TypeOfLicence")
	public WebElement DLTypeDropDown;
	@FindBy (how=How.XPATH, using ="//label[@for='myPassportCheck1']")
	public WebElement CurrentPassportCheckBox;
	@FindBy (how=How.XPATH, using ="//input[@title='Australian Passport Number']")
	public WebElement PassportNumberTextBox;
	@FindBy(how = How.XPATH, using = "//label[@for='gender1']")
	public WebElement GenderMaleRadioButton;
	@FindBy(how = How.ID, using = "//label[@for='gender2']")
	public WebElement GenderFemaleRadioButton;
	@FindBy(how = How.ID, using = "BirthDay")
	public WebElement DOBDayDropDown;
	@FindBy(how = How.ID, using = "BirthMonth")
	public WebElement DOBMonthDropDown;
	@FindBy(how = How.ID, using = "BirthYear")
	public WebElement DOBYearDropDown;
	@FindBy(how = How.ID, using = "CountryOfBirth")
	public WebElement COBTextbox;
	@FindBy(how = How.ID, using = "StateOfBirth")
	public WebElement SOBTextbox;
	@FindBy(how = How.ID, using = "CityOfBirth")
	public WebElement CityOBTextbox;

	//Contact Details Section
	@FindBy(how = How.ID, using = "HomePhone")
	public WebElement HomePhoneTextbox;
	@FindBy(how = How.ID, using = "WorkPhone")
	public WebElement WorkPhoneTextbox;
	@FindBy(how = How.ID, using = "MobilePhone")
	public WebElement MobilePhoneTextbox;
	@FindBy(how = How.ID, using = "Email")
	public WebElement EmailTextbox;
	@FindBy(how = How.ID, using = "ResidentialStreetAddress1")
	public WebElement StreetAddress1Textbox;
	@FindBy(how = How.ID, using = "ResidentialStreetAddress2")
	public WebElement StreetAddress2Textbox;
	@FindBy(how = How.ID, using = "ResidentialPostcode")
	public WebElement PostcodeTextbox;
	@FindBy(how = How.ID, using = "ResidentialState")
	public WebElement StateTextbox;
	@FindBy(how = How.ID, using = "ResidentialCountry")
	public WebElement CountryTextbox;
	@FindBy(how = How.ID, using = "ResidentialNearestCapitalCity")
	public WebElement NearestCapitalCityDropDown;
	@FindBy(how = How.XPATH, using = "//label[@for='myPostalCheck1']")
	public WebElement SamePostalAddressCheckBox;
	@FindBy(how = How.ID, using = "OtherContactNotes")
	public WebElement FurtherContactNotesTextbox;
	

	//Citizenship Details Section
	@FindBy(how = How.ID, using = "AustralianCitizenshipStatus")
	public WebElement CitizenshipDropDown;
	@FindBy(how = How.ID, using = "YearsResideInAustralia")
	public WebElement YearsInAustarliaTextBox;
	@FindBy(how = How.XPATH, using = "//label[@for='otherCitz2']")
	public WebElement YESOtherCurrentCitizenshipRadioButton;
	@FindBy(how = How.XPATH, using = "//input[@id='OtherCitizenshipCountry']")
	public WebElement OtherCurrentCitizenshipTextbox;
	@FindBy(how = How.XPATH, using = "//label[@for='otherCitz1']")
	public WebElement NOOtherCurrentCitizenshipRadioButton;
	@FindBy(how = How.XPATH, using = "//label[@for='otherPrevCitz2']")
	public WebElement YESOtherPreviousCitizenshipRadioButton;
	@FindBy(how = How.ID, using = "PreviousCitizenshipCountry")
	public WebElement OtherPreviousCitizenshipTextbox;
	@FindBy(how = How.ID, using = "PreviousCitizenshipFromMonth")
	public WebElement FromMonthOtherPreviousCitizenshipDropDown;
	@FindBy(how = How.ID, using = "PreviousCitizenshipFromYear")
	public WebElement FromYearOtherPreviousCitizenshipDropDown;
	@FindBy(how = How.ID, using = "PreviousCitizenshipToMonth")
	public WebElement ToMonthOtherPreviousCitizenshipDropDown;
	@FindBy(how = How.ID, using = "PreviousCitizenshipToYear")
	public WebElement ToYearOtherPreviousCitizenshipDropDown;	
	@FindBy(how = How.XPATH, using = "//label[@for='otherPrevCitz1']")
	public WebElement NOOtherPreviousCitizenshipRadioButton;
	@FindBy(how = How.XPATH, using = "//input[@value='Save & Continue']")
	public WebElement SaveAndContinueButton;



	public boolean FillFormStandard() throws InterruptedException
	{
		try{//Thread.sleep(5000);
			click(AcknowledgementCheckbox);
			click(IUnderstandButton);
			//Profile Photo section
			//click(UploadPhotoFromComputerRadioButton);
			try{
			click(UploadPhotoFromComputerButton);
			
			Thread.sleep(2000);
			Runtime.getRuntime().exec(picFilePath);
			System.out.println(picFilePath);
			Thread.sleep(7000);
			}
			catch (Exception e)
			{System.out.println("No Upload Photo Option");}
			//uploadFile(UploadPhotoBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/Upload Pics/mypic.jpg");
			//Curriculum Vitae (CV) section
			//click(UploadCVFromComputerRadioButton);
			try
			{click(UploadCVFromComputerButton);
			Thread.sleep(2000);
			Runtime.getRuntime().exec(cvFilePath);
			Thread.sleep(7000);
			}
			catch (Exception e)
			{
				System.out.println("No Upload Cv Option");
			}
			//uploadFile(UploadCVBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/20140806_Isobar_DFAT_JobVacancies_SOW_v2.1_APPROVED.pdf");
			//Personal Information section
			selectDropDown(TitleDropDown, "Mr");
			enterText(GivenNameTextbox,"Gaurav");
			enterText(MiddleNameTextbox, "SpecialChar");
			enterText(SurnameTextbox,"Sharma");
			enterText(PreferredNameTextbox,"Gaurav");
			click(CurrentPassportCheckBox);
			enterText(PassportNumberTextBox, "N2314478");
			click(CurrentLicenseCheckBox);
			enterText(DLNumberTextbox, "1234567890");
			selectDropDown(DLTypeDropDown, "Full");
			click(GenderMaleRadioButton);
			selectDropDown(DOBDayDropDown, "1");
			selectDropDown(DOBMonthDropDown, "January");
			selectDropDown(DOBYearDropDown, "1985");
			enterText(COBTextbox, "Libya");
			enterText(CityOBTextbox, "Tarhunah");
			enterText(SOBTextbox,"Benghazi");
			enterText(HomePhoneTextbox, "+61412685762");
			enterText(WorkPhoneTextbox, "+61412685762");
			enterText(MobilePhoneTextbox, "+61412685762");
			enterText(EmailTextbox, "gaurav.sharma@isobar.com");
			enterText(StreetAddress1Textbox, "Unit 3");
			enterText(StreetAddress2Textbox, "32 Wellington Street");
			enterText(PostcodeTextbox, "3032");
			enterText(StateTextbox, "Victoria");
			enterText(CountryTextbox, "Australia");
			selectDropDown(NearestCapitalCityDropDown, "Melbourne");
			click(SamePostalAddressCheckBox);
			enterText(FurtherContactNotesTextbox,"this & this is a test !" );
			selectDropDown(CitizenshipDropDown, "Yes, I have an Australian Citizenship.");
			enterText(YearsInAustarliaTextBox, "12");
			click(NOOtherCurrentCitizenshipRadioButton);
			//Thread.sleep(10000);
			click(NOOtherPreviousCitizenshipRadioButton);
			//click(NOOtherPreviousCitizenshipRadioButton);
			Thread.sleep(1000);
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
		try{//Thread.sleep(5000);
			click(AcknowledgementCheckbox);
			click(IUnderstandButton);
			//Profile Photo section
			//click(UploadPhotoFromComputerRadioButton);
			try{
				click(UploadPhotoFromComputerButton);
			
			Thread.sleep(5000);
			Runtime.getRuntime().exec(picFilePath);
			System.out.println(picFilePath);
			Thread.sleep(4000);
			}
			catch (Exception e)
			{System.out.println("No Upload Photo Option");}
			//uploadFile(UploadPhotoBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/Upload Pics/mypic.jpg");
			//Curriculum Vitae (CV) section
			//click(UploadCVFromComputerRadioButton);
			try
			{click(UploadCVFromComputerButton);
			Thread.sleep(4000);
			Runtime.getRuntime().exec(cvFilePath);
			Thread.sleep(7000);
			}
			catch (Exception e)
			{
				System.out.println("No Upload Cv Option");
			}
			//uploadFile(UploadCVBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/20140806_Isobar_DFAT_JobVacancies_SOW_v2.1_APPROVED.pdf");
			//Personal Information section
			selectDropDown(TitleDropDown, "Mr");
			enterText(GivenNameTextbox,specialText);
			enterText(MiddleNameTextbox, specialText);
			enterText(SurnameTextbox,specialText);
			enterText(PreferredNameTextbox,specialText);
			click(CurrentPassportCheckBox);
			enterText(PassportNumberTextBox, specialText);
			click(CurrentLicenseCheckBox);
			enterText(DLNumberTextbox, specialText);
			selectDropDown(DLTypeDropDown, "Full");
			click(GenderMaleRadioButton);
			selectDropDown(DOBDayDropDown, "1");
			selectDropDown(DOBMonthDropDown, "January");
			selectDropDown(DOBYearDropDown, "1985");
			enterText(COBTextbox,specialText);
			enterText(CityOBTextbox,specialText);
			enterText(SOBTextbox,specialText);
			enterText(HomePhoneTextbox, specialText);
			enterText(WorkPhoneTextbox, specialText);
			enterText(MobilePhoneTextbox, specialText);
			enterText(EmailTextbox, specialText+"@isobar.com");
			enterText(StreetAddress1Textbox, specialText);
			enterText(StreetAddress2Textbox, specialText);
			enterText(PostcodeTextbox, specialText);
			enterText(StateTextbox, specialText);
			enterText(CountryTextbox, specialText);
			selectDropDown(NearestCapitalCityDropDown, "Melbourne");
			click(SamePostalAddressCheckBox);
			enterText(FurtherContactNotesTextbox,specialText );
			selectDropDown(CitizenshipDropDown, "Yes, I have an Australian Citizenship.");
			enterText(YearsInAustarliaTextBox, specialText);
			click(YESOtherCurrentCitizenshipRadioButton);
			enterText(OtherCurrentCitizenshipTextbox,specialText);
			click(YESOtherPreviousCitizenshipRadioButton);
			enterText(OtherPreviousCitizenshipTextbox,specialText);
			selectDropDown(ToYearOtherPreviousCitizenshipDropDown,"2000");
			selectDropDown(FromMonthOtherPreviousCitizenshipDropDown,"January");
			selectDropDown(FromYearOtherPreviousCitizenshipDropDown,"2002");
			selectDropDown(ToMonthOtherPreviousCitizenshipDropDown,"January");
			//click(NOOtherPreviousCitizenshipRadioButton);
			Thread.sleep(1000);
			click(SaveAndContinueButton);
			Thread.sleep(2000);
			selectDropDown(TitleDropDown, "Mr");
			enterText(GivenNameTextbox,"Gau'rav");
			enterText(MiddleNameTextbox, "Gman-DaMan");
			enterText(SurnameTextbox,"Sharma'o Sharma");
			enterText(PreferredNameTextbox,"Gaurav");
			//click(CurrentPassportCheckBox);
			enterText(PassportNumberTextBox, "N2314478");
			//click(CurrentLicenseCheckBox);
			enterText(DLNumberTextbox, "1234567890");
			selectDropDown(DLTypeDropDown, "Full");
			click(GenderMaleRadioButton);
			selectDropDown(DOBDayDropDown, "1");
			selectDropDown(DOBMonthDropDown, "January");
			selectDropDown(DOBYearDropDown, "1985");
			enterText(COBTextbox, "Libya");
			enterText(CityOBTextbox, "Tarhunah");
			enterText(SOBTextbox,"Benghazi");
			enterText(HomePhoneTextbox, "0412685762");
			enterText(WorkPhoneTextbox, "0412685762");
			enterText(MobilePhoneTextbox, "0412685762");
			enterText(EmailTextbox, "gaurav.sharma@isobar.com");
			enterText(StreetAddress1Textbox, "Unit 3");
			enterText(StreetAddress2Textbox, "32 Wellington Street");
			enterText(PostcodeTextbox, "3032");
			enterText(StateTextbox, "Victoria");
			enterText(CountryTextbox, "Australia");
			selectDropDown(NearestCapitalCityDropDown, "Melbourne");
			//click(SamePostalAddressCheckBox);
			enterText(FurtherContactNotesTextbox,"Blah" );
			selectDropDown(CitizenshipDropDown, "Yes, I have an Australian Citizenship.");
			enterText(YearsInAustarliaTextBox, "12");
			click(NOOtherCurrentCitizenshipRadioButton);
			//Thread.sleep(10000);
			click(NOOtherPreviousCitizenshipRadioButton);
			//click(NOOtherPreviousCitizenshipRadioButton);
			Thread.sleep(1000);
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
			System.out.println("Reviewed Personal Page");
			return true;
	
	}
	public boolean FillFormStandard(String Title,
			String Fname,String Mname,
			String Lname,String Prefname,
			String Passport,String Licence,
			String LicenceType,String	DOBDay,
			String DOBMonth,String DOBYear,
			String COB,String COBCity,
			String COBState,String HomePhone,
			String WorkPhone,String	MobilePhone,
			String	Email,String AddressLine1,
			String AddressLine2,String Postcode,
			String State,String Country,
			String NearestCity,	String CitizenshipDropdown,
			String CitizenshipYears) throws InterruptedException
	{
		try{//Thread.sleep(5000);
			click(AcknowledgementCheckbox);
			click(IUnderstandButton);
			//Profile Photo section
			//click(UploadPhotoFromComputerRadioButton);
			try{
				click(UploadPhotoFromComputerButton);
			
			Thread.sleep(2000);
			Runtime.getRuntime().exec(picFilePath);
			System.out.println(picFilePath);
			Thread.sleep(7000);
			}
			catch (Exception e)
			{System.out.println("No Upload Photo Option");}
			//uploadFile(UploadPhotoBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/Upload Pics/mypic.jpg");
			//Curriculum Vitae (CV) section
			//click(UploadCVFromComputerRadioButton);
			try
			{click(UploadCVFromComputerButton);
			Thread.sleep(2000);
			Runtime.getRuntime().exec(cvFilePath);
			Thread.sleep(7000);
			}
			catch (Exception e)
			{
				System.out.println("No Upload Cv Option");
			}
			//uploadFile(UploadCVBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/20140806_Isobar_DFAT_JobVacancies_SOW_v2.1_APPROVED.pdf");
			//Personal Information section
			selectDropDown(TitleDropDown, Title);
			enterText(GivenNameTextbox,Fname);
			enterText(MiddleNameTextbox, Mname);
			enterText(SurnameTextbox,Lname);
			enterText(PreferredNameTextbox,Prefname);
			click(CurrentPassportCheckBox);
			enterText(PassportNumberTextBox, Passport);
			click(CurrentLicenseCheckBox);
			enterText(DLNumberTextbox, Licence);
			selectDropDown(DLTypeDropDown, LicenceType);
			click(GenderMaleRadioButton);
			selectDropDown(DOBDayDropDown, DOBDay);
			selectDropDown(DOBMonthDropDown, DOBMonth);
			selectDropDown(DOBYearDropDown, DOBYear);
			enterText(COBTextbox, COB);
			enterText(CityOBTextbox, COBCity);
			enterText(SOBTextbox,COBState);
			enterText(HomePhoneTextbox, HomePhone);
			enterText(WorkPhoneTextbox, WorkPhone);
			enterText(MobilePhoneTextbox, MobilePhone);
			enterText(EmailTextbox, Email);
			enterText(StreetAddress1Textbox, AddressLine1);
			enterText(StreetAddress2Textbox, AddressLine2);
			enterText(PostcodeTextbox, Postcode);
			enterText(StateTextbox, State);
			enterText(CountryTextbox, Country);
			selectDropDown(NearestCapitalCityDropDown, NearestCity);
			click(SamePostalAddressCheckBox);
			selectDropDown(CitizenshipDropDown, CitizenshipDropdown);
			enterText(YearsInAustarliaTextBox, CitizenshipYears);
			click(NOOtherCurrentCitizenshipRadioButton);
			//Thread.sleep(10000);
			click(NOOtherPreviousCitizenshipRadioButton);
			//click(NOOtherPreviousCitizenshipRadioButton);
			Thread.sleep(1000);
			click(SaveAndContinueButton);

			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean FillFormStandardFirefox() throws InterruptedException
	{
		try{//Thread.sleep(5000);
			click(AcknowledgementCheckbox);
			click(IUnderstandButton);
			//Profile Photo section
			click(UploadPhotoFromComputerRadioButton);
			//click(UploadPhotoFromComputerButton);
			//Runtime.getRuntime().exec("src/com/DFATTestData/mypic.jpg");
			//Thread.sleep(5000);
			uploadFile(UploadPhotoBrowseTextBox,"src/com/DFATTestData/mypic.jpg");
			//Curriculum Vitae (CV) section
			click(UploadCVFromComputerRadioButton);
			//click(UploadCVFromComputerButton);
			//Runtime.getRuntime().exec("src/com/DFATTestData/CV.pdf");
			//Thread.sleep(5000);
			uploadFile(UploadCVBrowseTextBox,"src/com/DFATTestData/CV.pdf");
			//Personal Information section
			selectDropDown(TitleDropDown, "Mr");
			enterText(GivenNameTextbox,"Gaurav");
			enterText(MiddleNameTextbox, "Gman");
			enterText(SurnameTextbox,"Sharma");
			enterText(PreferredNameTextbox,"Gaurav");
			click(CurrentPassportCheckBox);
			enterText(PassportNumberTextBox, "N2314478");
			click(CurrentLicenseCheckBox);
			enterText(DLNumberTextbox, "1234567890");
			selectDropDown(DLTypeDropDown, "Full");
			click(GenderMaleRadioButton);
			selectDropDown(DOBDayDropDown, "1");
			selectDropDown(DOBMonthDropDown, "January");
			selectDropDown(DOBYearDropDown, "1985");
			enterText(COBTextbox, "Libya");
			enterText(CityOBTextbox, "Tarhunah");
			enterText(SOBTextbox,"Tarhunah");
			enterText(HomePhoneTextbox, "0412685762");
			enterText(WorkPhoneTextbox, "0412685762");
			enterText(MobilePhoneTextbox, "0412685762");
			enterText(EmailTextbox, "gaurav.sharma@isobar.com");
			enterText(StreetAddress1Textbox, "Unit 3");
			enterText(StreetAddress2Textbox, "32 Wellington Street");
			enterText(PostcodeTextbox, "3032");
			enterText(StateTextbox, "Victoria");
			enterText(CountryTextbox, "Australia");
			selectDropDown(NearestCapitalCityDropDown, "Melbourne");
			click(SamePostalAddressCheckBox);
			selectDropDown(CitizenshipDropDown, "Yes, I have an Australian Citizenship.");
			enterText(YearsInAustarliaTextBox, "12");
			click(NOOtherCurrentCitizenshipRadioButton);
			//Thread.sleep(10000);
			click(NOOtherPreviousCitizenshipRadioButton);
			//click(NOOtherPreviousCitizenshipRadioButton);
			Thread.sleep(1000);
			click(SaveAndContinueButton);

			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	public boolean FillFormWithURLsStandard() throws InterruptedException
	{
		try{//Thread.sleep(5000);
			click(AcknowledgementCheckbox);
			click(IUnderstandButton);
			//Profile Photo section
			click(DownloadPhotoFromURLRadioButton);
			enterText(DownloadPhotoFromURLTextBox,imageURL);
			//uploadFile(UploadPhotoBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/Upload Pics/mypic.jpg");
			//Curriculum Vitae (CV) section
			click(DownloadCVFromURLRadioButton);
			enterText(DownloadCVFromURLTextBox,cvURL);
			//uploadFile(UploadCVBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/20140806_Isobar_DFAT_JobVacancies_SOW_v2.1_APPROVED.pdf");
			//Personal Information section
			selectDropDown(TitleDropDown, "Mr");
			enterText(GivenNameTextbox,"Gaurav");
			enterText(MiddleNameTextbox, "Gman");
			enterText(SurnameTextbox,"Sharma");
			enterText(PreferredNameTextbox,"Gaurav");
			click(CurrentLicenseCheckBox);
			enterText(DLNumberTextbox, "1234567890");
			selectDropDown(DLTypeDropDown, "Full");
			click(CurrentPassportCheckBox);
			Thread.sleep(1000);
			enterText(PassportNumberTextBox, "N2310476");
			click(GenderMaleRadioButton);
			selectDropDown(DOBDayDropDown, "20");
			selectDropDown(DOBMonthDropDown, "January");
			selectDropDown(DOBYearDropDown, "1985");
			enterText(COBTextbox, "Libya");
			enterText(CityOBTextbox, "Tarhunah");
			enterText(SOBTextbox,"Tarhunah");
			enterText(HomePhoneTextbox, "0412685762");
			enterText(WorkPhoneTextbox, "0412685762");
			enterText(MobilePhoneTextbox, "0412685762");
			enterText(EmailTextbox, "gaurav.sharma@isobar.com");
			enterText(StreetAddress1Textbox, "Unit 3");
			enterText(StreetAddress2Textbox, "32 Wellington Street");
			enterText(PostcodeTextbox, "3032");
			enterText(StateTextbox, "Victoria");
			enterText(CountryTextbox, "Australia");
			selectDropDown(NearestCapitalCityDropDown, "Melbourne");
			click(SamePostalAddressCheckBox);
			selectDropDown(CitizenshipDropDown, "Yes, I have an Australian Citizenship.");
			enterText(YearsInAustarliaTextBox, "12");
			click(NOOtherCurrentCitizenshipRadioButton);
			//Thread.sleep(10000);
			click(NOOtherPreviousCitizenshipRadioButton);
			//click(NOOtherPreviousCitizenshipRadioButton);
			Thread.sleep(1000);
			click(SaveAndContinueButton);

			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	// Error Checking function on a page
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
			//Thread.sleep(5000);

			click(AcknowledgementCheckbox);
			click(IUnderstandButton);
			//Error Checker
			click(CurrentPassportCheckBox);
			click(CurrentLicenseCheckBox);
			click(YESOtherCurrentCitizenshipRadioButton);
			click(YESOtherPreviousCitizenshipRadioButton);
			Errorcheckresult=errorChecker(Driver,Path,Section,Errors);
			//Profile Photo section
			/*click(DownloadPhotoFromURLRadioButton);
			enterText(DownloadPhotoFromURLTextBox,imageURL);
			//Curriculum Vitae (CV) section
			click(DownloadCVFromURLRadioButton);
			enterText(DownloadCVFromURLTextBox,cvURL);*/
			//Profile Photo section
			//click(UploadPhotoFromComputerRadioButton);
			try{
				click(UploadPhotoFromComputerButton);
			
			Thread.sleep(2000);
			Runtime.getRuntime().exec(picFilePath);
			System.out.println(picFilePath);
			Thread.sleep(7000);
			}
			catch (Exception e)
			{System.out.println("No Upload Photo Option");}
			//uploadFile(UploadPhotoBrowseTextBox,"C:/Users/gsharma/Desktop/DFAT/Upload Pics/mypic.jpg");
			//Curriculum Vitae (CV) section
			//click(UploadCVFromComputerRadioButton);
			try
			{click(UploadCVFromComputerButton);
			Thread.sleep(2000);
			Runtime.getRuntime().exec(cvFilePath);
			Thread.sleep(7000);
			}
			catch (Exception e)
			{
				System.out.println("No Upload Cv Option");
			}
			//Personal Information section
			selectDropDown(TitleDropDown, "Mr");
			enterText(GivenNameTextbox,"Gaurav");
			enterText(MiddleNameTextbox, "Gman");
			enterText(SurnameTextbox,"Sharma");
			enterText(PreferredNameTextbox,"Gaurav");
			//click(CurrentLicenseCheckBox);
			enterText(DLNumberTextbox, "1234567890");
			selectDropDown(DLTypeDropDown, "Full");
			//click(CurrentPassportCheckBox);
			Thread.sleep(1000);
			enterText(PassportNumberTextBox, "N2310476");
			click(GenderMaleRadioButton);
			selectDropDown(DOBDayDropDown, "20");
			selectDropDown(DOBMonthDropDown, "January");
			selectDropDown(DOBYearDropDown, "1985");
			enterText(COBTextbox, "Libya");
			enterText(CityOBTextbox, "Tarhunah");
			enterText(SOBTextbox,"Tarhunah");
			enterText(HomePhoneTextbox, "0412685762");
			enterText(WorkPhoneTextbox, "0412685762");
			enterText(MobilePhoneTextbox, "0412685762");
			enterText(EmailTextbox, "gaurav.sharma@isobar.com");
			enterText(StreetAddress1Textbox, "Unit 3");
			enterText(StreetAddress2Textbox, "32 Wellington Street");
			enterText(PostcodeTextbox, "3032");
			enterText(StateTextbox, "Victoria");
			enterText(CountryTextbox, "Australia");
			selectDropDown(NearestCapitalCityDropDown, "Melbourne");
			click(SamePostalAddressCheckBox);
			selectDropDown(CitizenshipDropDown, "Yes, I have an Australian Citizenship.");
			enterText(YearsInAustarliaTextBox, "12");
			click(NOOtherCurrentCitizenshipRadioButton);
			click(NOOtherPreviousCitizenshipRadioButton);
			//click(NOOtherPreviousCitizenshipRadioButton);
			Thread.sleep(1000);
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
	public boolean consentFormStandard()
	{
		
			click(AcknowledgementCheckbox);
			click(IUnderstandButton);
			click(UploadPhotoFromComputerButton);
			return true;
		
	}
}

