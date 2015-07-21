package com.DFATTests.Chrome;


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
import com.DFAT_Australia.BaseClass;
import com.DFAT_Australia.SpreadSheetData;



@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParaIntelligenceOfficerFormLogin {
	@Rule public TestName name = new TestName();
	protected static String workingDir = System.getProperty("user.dir").replace("\\","/");
	static String TestResults;
	String myKey;
	String username;
	String password;
	static String ResultReport;
	static String reportContent="";
	boolean answer ;
	static WebDriver driver;
	static List<Boolean> Results = new ArrayList<Boolean>();
	static List<String> TcaseName = new ArrayList<String>();
	static String path=workingDir+"/src/test/resources/com/DFATReports/";
	static String CurrentPath;
	static String colour="B6B6B4";
	static String excelPath;
	//public Class<?> enclosingClass = getClass().getEnclosingClass();
	
	@Parameters(name = "Data Row #: {index}")
	public static Collection<Object[]> spreadsheetData() throws IOException {

		return new SpreadSheetData(new FileInputStream(workingDir+"/src/test/resources/com/DFATTestData/DFAT_Key.xls")).getData();
	}

	public ParaIntelligenceOfficerFormLogin(String User, String Pass, String Key)	 {
		this.username=User;
		this.password=Pass;
		this.myKey =Key ;

	}

	@BeforeClass
	public static void Setup() throws IOException, InterruptedException
	{
		excelPath=workingDir+"/src/test/resources/com/DFATTestData/DFAT_Key.xls";
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
		Results.add(LoginPage.FillForm(username,password,myKey,excelPath));	

	}

	@Test
	public void C_FillFormFormPersonalSectionComplete() 
	{
		Step1_Personal_PageObjects FormPersonalSection = PageFactory.initElements(driver,Step1_Personal_PageObjects.class);
		TcaseName.add(name.getMethodName());
		Results.add(FormPersonalSection.consentFormStandard());
	}
	

	@AfterClass
	public static void teardown() throws IOException
	{
		BaseClass.tearDown(driver,Results,TcaseName,ResultReport);
		File htmlFile = new File(ResultReport);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}


}
