package com.DFATTests.Firefox;


import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.DFATPageObjects.Careers.Roles_VacanciesPageObjects;
import com.DFATPageObjects.Careers.Roles_Vacancies_IntelligenceOfficePageObjects;
import com.DFATPageObjects.MyApplications.LoginPageObjects;
import com.DFATPageObjects.MyApplications.Step1_Personal_PageObjects;
import com.DFATPageObjects.MyApplications.Step2_PartnerAndRelationship_PageObjects;
import com.DFATPageObjects.MyApplications.Step3_EducationaAndEmployment_PageObjects;
import com.DFATPageObjects.MyApplications.Step4_ExtraCurrAndForeignExp_PageObjects;
import com.DFATPageObjects.MyApplications.Step5_ExtendedResponse_PageObjects;
import com.DFATPageObjects.MyApplications.Step6_ReviewAndSubmit_PageObjects;
import com.DFAT_Australia.BaseClass;
import com.DFAT_Australia.SpreadSheetData;



@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParaIntelligenceOfficerFullForm {
	@Rule public TestName name = new TestName();
	protected static String workingDir = System.getProperty("user.dir").replace("\\","/");
	static String TestResults;
	String myKey;
	String username;
	String password;
	String Title;
	String Fname;String Mname;
	String Lname;String Prefname;
	String Passport;String Licence;
	String LicenceType;String	DOBDay;
	String DOBMonth;String DOBYear;
	String COB;String COBCity;
	String COBState;String HomePhone;
	String WorkPhone;String	MobilePhone;
	String	Email;String AddressLine1;
	String AddressLine2;String Postcode;
	String State;String Country;
	String NearestCity;	String CitizenshipDropdown;
	String CitizenshipYears;
	static String ResultReport;
	static String reportContent="";
	boolean answer ;
	static WebDriver driver;
	static List<Boolean> Results = new ArrayList<Boolean>();
	static List<String> TcaseName = new ArrayList<String>();
	static String path="src/com/DFATReports/";
	static String CurrentPath;
	static String colour="B6B6B4";
	static String excelPath;
	//public Class<?> enclosingClass = getClass().getEnclosingClass();

	@Parameters(name = "Data Row #: {index}")
	public static Collection<Object[]> spreadsheetData() throws IOException {

		return new SpreadSheetData(new FileInputStream(workingDir+"/src/test/resource/com/DFATTestData/DFAT_DataDriven.xls")).getData();
	}

	public ParaIntelligenceOfficerFullForm(
			String User, String Pass,
			String Key,String Title,
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
			String CitizenshipYears
			)
	{
		this.username=User;
		this.password=Pass;
		this.myKey =Key ;
		this.Title=Title;
		this.Fname=Fname;
		this.Mname=Mname;
		this.Lname=Lname;
		this.Prefname=Prefname;
		this.Passport=Passport;
		this.Licence=Licence;
		this.LicenceType=LicenceType;
		this.DOBDay=DOBDay;
		this.DOBMonth=DOBMonth;
		this.DOBYear=DOBYear;
		this.COB=COB;
		this.COBCity=COBCity;
		this.COBState=COBState;
		this.HomePhone=HomePhone;
		this.WorkPhone=WorkPhone;
		this.MobilePhone=MobilePhone;
		this.Email=Email;
		this.AddressLine1=AddressLine1;
		this.AddressLine2=AddressLine2;
		this.Postcode=Postcode;
		this.State=State;
		this.Country=Country;
		this.NearestCity=NearestCity;
		this.CitizenshipDropdown=CitizenshipDropdown;
		this.CitizenshipYears=CitizenshipYears;

	}

	@BeforeClass
	public static void Setup() throws IOException, InterruptedException
	{
		excelPath=workingDir+"/src/test/resource/com/DFATTestData/DFAT_Key.xls";
		Roles_VacanciesPageObjects RolesAndVacanciesPage = PageFactory.initElements(driver,Roles_VacanciesPageObjects.class);
		CurrentPath=BaseClass.createDateFolder(path);
		ResultReport=CurrentPath+"Screenshot.html";
		BaseClass.SOHTMLGENERAL(ResultReport);
		driver = RolesAndVacanciesPage.DFATPageFirefox(driver);

	}


	@Test
	public void A_NavigateToIntelligenceOfficerApplicationTest() throws InterruptedException
	{
		Roles_Vacancies_IntelligenceOfficePageObjects IORolesPage = PageFactory.initElements(driver,Roles_Vacancies_IntelligenceOfficePageObjects.class);
		Roles_VacanciesPageObjects RolesAndVacanciesPage = PageFactory.initElements(driver,Roles_VacanciesPageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(RolesAndVacanciesPage.ClickViewAndApplyIOfficerButton());
		Results.add(IORolesPage.ClickApplyNowButton());
	}

	@Test
	public void B_LoginAsUserTest() throws InterruptedException
	{
		LoginPageObjects LoginPage = PageFactory.initElements(driver,LoginPageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(LoginPage.FillForm(username,password,myKey,excelPath));	

	}

	@Test
	public void C_FillFormFormPersonalSectionComplete() throws InterruptedException 
	{
		Step1_Personal_PageObjects FormPersonalSection = PageFactory.initElements(driver,Step1_Personal_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormPersonalSection.FillFormStandard(Title,
				 Fname, Mname,Lname, Prefname,Passport, Licence,LicenceType,DOBDay,DOBMonth, DOBYear,
				 COB, COBCity,COBState, HomePhone,WorkPhone,MobilePhone,Email, AddressLine1,AddressLine2, Postcode,
				 State, Country,NearestCity,CitizenshipDropdown,CitizenshipYears));
	}
	@Test
	public void D_FillFormPartnerAndRelationshipSectionComplete() throws InterruptedException
	{
		Step2_PartnerAndRelationship_PageObjects FormPartnerAndRelationshipSection = PageFactory.initElements(driver, Step2_PartnerAndRelationship_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormPartnerAndRelationshipSection.FillFormStandard());

	}
	@Test
	public void E_FillFormEducationAndEmploymentSectionComplete() throws InterruptedException
	{
		Step3_EducationaAndEmployment_PageObjects FormEducationAndEmploymentSection = PageFactory.initElements(driver, Step3_EducationaAndEmployment_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormEducationAndEmploymentSection.FillFormStandard());

	}
	@Test
	public void F_FillFormExtraCurrAndForeignExpSectionComplete() throws InterruptedException
	{
		Step4_ExtraCurrAndForeignExp_PageObjects FormExtraCurrAndForeignExpSection = PageFactory.initElements(driver, Step4_ExtraCurrAndForeignExp_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormExtraCurrAndForeignExpSection.FillFormStandard());
	}

	@Test
	public void G_FillFormExtendedResponseSectionComplete() throws InterruptedException
	{
		Step5_ExtendedResponse_PageObjects FormExtendedResponseSection = PageFactory.initElements(driver, Step5_ExtendedResponse_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormExtendedResponseSection.FillFormStandard(driver));
	}

	@Test
	public void H_SubmitFormSection() throws InterruptedException, IOException
	{
		Step6_ReviewAndSubmit_PageObjects ReviewAndSubmitSection = PageFactory.initElements(driver, Step6_ReviewAndSubmit_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(ReviewAndSubmitSection.ReviewFormStandard(driver,CurrentPath));
	}



	@AfterClass
	public static void teardown() throws IOException
	{
		BaseClass.tearDown(driver,Results,TcaseName,ResultReport);
		File htmlFile = new File(ResultReport);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}


}
