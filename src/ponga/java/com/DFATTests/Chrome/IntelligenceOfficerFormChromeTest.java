package com.DFATTests.Chrome;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
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



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IntelligenceOfficerFormChromeTest {
	@Rule public TestName name = new TestName();
	static String TestResults;
	static String ResultReport;
	static String reportContent="";
	boolean answer ;
	static WebDriver driver;
	static List<Boolean> Results = new ArrayList<Boolean>();
	static List<String> TcaseName = new ArrayList<String>();
	static String path="src/com/DFATReports/";
	static String CurrentPath;
	static String colour="B6B6B4";
	//public Class<?> enclosingClass = getClass().getEnclosingClass();

	@BeforeClass
	public static void Setup() throws IOException, InterruptedException
	{
		Roles_VacanciesPageObjects RolesAndVacanciesPage = PageFactory.initElements(driver,Roles_VacanciesPageObjects.class);
		CurrentPath=BaseClass.createDateFolder(path);
		ResultReport=CurrentPath+"Screenshot.html";
		BaseClass.SOHTMLGENERAL(ResultReport);
		driver = RolesAndVacanciesPage.DFATPageChrome(driver);
		
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
		Results.add(LoginPage.FillForm());	

	}

	@Test
	public void C_FillFormComplete() throws InterruptedException
	{
		Step1_Personal_PageObjects FormPersonalSection = PageFactory.initElements(driver,Step1_Personal_PageObjects.class);
		Step2_PartnerAndRelationship_PageObjects FormPartnerandRelationshipSection = PageFactory.initElements(driver, Step2_PartnerAndRelationship_PageObjects.class);
		TcaseName.add(name.getMethodName());
		FormPersonalSection.FillFormStandard();
		FormPartnerandRelationshipSection.FillFormMultipartner(driver,3);
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
