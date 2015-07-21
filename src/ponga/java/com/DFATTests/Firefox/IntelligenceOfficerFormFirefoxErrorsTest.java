package com.DFATTests.Firefox;


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
public class IntelligenceOfficerFormFirefoxErrorsTest {
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
	static String errorlog ;
	static String colour="B6B6B4";
	//public Class<?> enclosingClass = getClass().getEnclosingClass();

	@BeforeClass
	public static void Setup() throws IOException, InterruptedException
	{
		Roles_VacanciesPageObjects RolesAndVacanciesPage = PageFactory.initElements(driver,Roles_VacanciesPageObjects.class);
		CurrentPath=BaseClass.createDateFolder(path);
		ResultReport=CurrentPath+"Screenshot.html";
		errorlog =CurrentPath+"Error_List.txt";
		BaseClass.myWriteSOF(errorlog);
		BaseClass.SOHTMLGENERAL(ResultReport);
		driver = RolesAndVacanciesPage.DFATPageChrome(driver);
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("RolesAndVacanciesPage contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" RolesAndVacanciesPage contains DFAT");
		}
		
	}


	@Test
	public void A_NavigateToIntelligenceOfficerApplicationTest() throws InterruptedException
	{
		Roles_Vacancies_IntelligenceOfficePageObjects IORolesPage = PageFactory.initElements(driver,Roles_Vacancies_IntelligenceOfficePageObjects.class);
		Roles_VacanciesPageObjects RolesAndVacanciesPage = PageFactory.initElements(driver,Roles_VacanciesPageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(RolesAndVacanciesPage.ClickViewAndApplyIOfficerButton());
		Results.add(IORolesPage.ClickApplyNowButton());
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("IORolesPage contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" IORolesPage contains DFAT");
		}
	}

	@Test
	public void B_LoginAsUserTest() throws InterruptedException, IOException
	{
		LoginPageObjects LoginPage = PageFactory.initElements(driver,LoginPageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(LoginPage.FillFormErrorChecker(driver,errorlog,"Login Section",3));	
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("LoginPage contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" LoginPage contains DFAT");
		}

	}

	@Test
	public void C_FillFormFormPersonalSectionComplete() throws InterruptedException, IOException
	{
		Step1_Personal_PageObjects FormPersonalSection = PageFactory.initElements(driver,Step1_Personal_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormPersonalSection.FillFormErrorChecker(driver,errorlog,"Personal Section",32));
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("FormPersonalSection contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" FormPersonalSection contains DFAT");
		}
	}
	@Test
	public void D_FillFormPartnerAndRelationshipSectionComplete() throws InterruptedException, IOException
	{
		Step2_PartnerAndRelationship_PageObjects FormPartnerAndRelationshipSection = PageFactory.initElements(driver, Step2_PartnerAndRelationship_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormPartnerAndRelationshipSection.FillFormErrorChecker(driver,errorlog,"Partner And Relationship Section",18));
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("FormPartnerAndRelationshipSection contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" FormPartnerAndRelationshipSection contains DFAT");
		}
	
	}
	@Test
	public void E_FillFormEducationAndEmploymentSectionComplete() throws InterruptedException, IOException
	{
		Step3_EducationaAndEmployment_PageObjects FormEducationAndEmploymentSection = PageFactory.initElements(driver, Step3_EducationaAndEmployment_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormEducationAndEmploymentSection.FillFormErrorChecker(driver,errorlog,"Education And Employment Section",37));
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("FormEducationAndEmploymentSection contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" FormEducationAndEmploymentSection contains DFAT");
		}
		
	}
	@Test
	public void F_FillFormExtraCurrAndForeignExpSectionComplete() throws InterruptedException, IOException
	{
		Step4_ExtraCurrAndForeignExp_PageObjects FormExtraCurrAndForeignExpSection = PageFactory.initElements(driver, Step4_ExtraCurrAndForeignExp_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormExtraCurrAndForeignExpSection.FillFormErrorChecker(driver,errorlog,"Extra Curricular And Foreign Experience Section",11));
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("FormExtraCurrAndForeignExpSection contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" FormExtraCurrAndForeignExpSection contains DFAT");
		}
	}
	
	@Test
	public void G_FillFormExtendedResponseSectionComplete() throws InterruptedException, IOException
	{
		Step5_ExtendedResponse_PageObjects FormExtendedResponseSection = PageFactory.initElements(driver, Step5_ExtendedResponse_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormExtendedResponseSection.FillFormErrorChecker(driver,errorlog,"Extended Response Section",13));
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("FormExtendedResponseSection contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" FormExtendedResponseSection contains DFAT");
		}
	}

	@Test
	public void H_SubmitFormSection() throws InterruptedException, IOException
	{
		Step6_ReviewAndSubmit_PageObjects ReviewAndSubmitSection = PageFactory.initElements(driver, Step6_ReviewAndSubmit_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(ReviewAndSubmitSection.FillFormErrorChecker(driver,errorlog,CurrentPath,"Submit Form Section",2));
		if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
		{
			System.out.println("ReviewAndSubmitSection contains Lorem Ipsum");
		}
		if (driver.getPageSource().contains("DFAT")|| driver.getPageSource().contains("dfat")|| driver.getPageSource().contains("Dfat"))
		{
			System.out.println(" ReviewAndSubmitSection contains DFAT");
		}
	}

	@AfterClass
	public static void teardown() throws IOException
	{
		BaseClass.tearDownErrorLog(driver,Results,TcaseName,ResultReport,errorlog);
		File htmlFile = new File(ResultReport);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}


}
