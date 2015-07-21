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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.DFATPageObjects.Careers.Roles_VacanciesPageObjects;
import com.DFAT_Australia.BaseClass;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FullSiteChromeLoremIpsumTest {
	@Rule public TestName name = new TestName();
	static String TestResults;
	static String ResultReport;
	static String myURL="http://124.47.154.22";
	List<WebElement> myURLsList = new ArrayList <WebElement>();
	static List <String> myUniqueURLString = new ArrayList <String>();
	static List <String> loremipsumlist = new ArrayList <String>();
	static List <String> bannedWordlist = new ArrayList <String>();
	static List <String> four0Four = new ArrayList<String>();
	static List <String> pageTitle = new ArrayList<String>();
	static String SearchText="DFAT";

	static String reportContent="";
	boolean answer ;
	static WebDriver driver;
	static List<Boolean> Results = new ArrayList<Boolean>();
	static List<String> TcaseName = new ArrayList<String>();
	static String path="src/com/DFATReports/";
	static String CurrentPath;
	static String errorlog ;
	static int count =0;
	static String colour="B6B6B4";
	//public Class<?> enclosingClass = getClass().getEnclosingClass();

	@BeforeClass
	public static void Setup() throws IOException, InterruptedException
	{
		CurrentPath=BaseClass.createDateFolder(path);
		ResultReport=CurrentPath+"Screenshot.html";
		errorlog =CurrentPath+"Error_List.txt";
		BaseClass.myWriteSOF(errorlog);
		BaseClass.SOHTMLGENERAL(ResultReport);
		myUniqueURLString.add(myURL);
		Roles_VacanciesPageObjects RolesAndVacanciesPage = PageFactory.initElements(driver,Roles_VacanciesPageObjects.class);
		driver = RolesAndVacanciesPage.DFATMainPageChrome(driver);
		/*driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

	}


	@Test
	public void A_DFAT_Crawler() throws InterruptedException, IOException
	{
		driver.get(myURL);
		for(int i=0;i<myUniqueURLString.size();i++)
		{
			//driver.get(myUniqueURLString.get(i));
			//System.out.println("Getting: "+myUniqueURLString.get(i));
			myURLsList=driver.findElements(By.xpath("//a[contains(@href,'')]"));
			for( WebElement URL: myURLsList)
			{
				try{
				if((!myUniqueURLString.contains(URL.getAttribute("href")))&&(URL.getAttribute("href")!= null)&&(URL.getAttribute("href").contains(myURL))&& (!URL.getAttribute("href").isEmpty())&&(!URL.getAttribute("href").endsWith("#")))
				{
					myUniqueURLString.add(URL.getAttribute("href"));
					//	System.out.println("Added: "+URL.getAttribute("href"));
					count=count+1;
				}
				}
				catch (Exception e){
					
				}
			}
			System.out.println("Browsing URL #"+(i+1)+" & Extracted:"+count+" URLS from :"+myUniqueURLString.get(i));
			//System.out.println(myUniqueURLString.toString());
			count=0;
			driver.get(myUniqueURLString.get(i));
			//Thread.sleep(1000);
			if (driver.getPageSource().contains("Lorem")|| driver.getPageSource().contains("Ipsum")|| driver.getPageSource().contains("lorem")||driver.getPageSource().contains("ipsum"))
			{
				loremipsumlist.add(myUniqueURLString.get(i)+" contains Lorem Ipsum");
				//		System.out.println(myUniqueURLString.get(i)+" contains Lorem Ipsum");
			}
			if (driver.getPageSource().contains(SearchText)|| driver.getPageSource().contains(SearchText)|| driver.getPageSource().contains(SearchText))
			{
				bannedWordlist.add(myUniqueURLString.get(i)+" contains "+SearchText);
				//		System.out.println(myUniqueURLString.get(i)+" contains Lorem Ipsum");
			}
			//System.out.println(myUniqueURLString.size()+" URLS Discovered");
			if (driver.getPageSource().contains("404")|| driver.getTitle().contains("404")|| driver.getCurrentUrl().contains("404")||driver.getPageSource().contains("Page not found")|| driver.getTitle().contains("Page not found")|| driver.getCurrentUrl().contains("Page not found"))
			{
				four0Four.add(myUniqueURLString.get(i)+" Has a 404/Error");
				//		System.out.println(myUniqueURLString.get(i)+" contains Lorem Ipsum");
			}
			if ((driver.getTitle().isEmpty()||driver.getTitle().contains(SearchText)))
			{
				pageTitle.add(myUniqueURLString.get(i)+" Has a No Title or contains "+SearchText);
				//		System.out.println(myUniqueURLString.get(i)+" contains Lorem Ipsum");
			}
			System.out.println("Current URL List Size: "+myUniqueURLString.size());
		}
		System.out.println("Total URLs Crawled: "+myUniqueURLString.size());
		BaseClass.myWriteAppend(errorlog,"Total URLs Crawled: "+myUniqueURLString.size());
		
		if(loremipsumlist.size()>0)
		{
			System.out.println("Lorem Ipsum found "+loremipsumlist.size()+" on the following URLs:");
			for (String loremIpsum: loremipsumlist )
			{
				System.out.println(loremIpsum);
				BaseClass.myWriteAppend(errorlog,loremIpsum);

			}
		}
		else{
			System.out.println("No Lorem Ipsum found on the site");
			BaseClass.myWriteAppend(errorlog,"No Lorem Ipsum found on the site");
		}
		if(bannedWordlist.size()>0)
		{
			System.out.println(SearchText+" found "+bannedWordlist.size()+" on the following URLs:");
			for (String bannedWord: bannedWordlist )
			{
				System.out.println(bannedWord);
				BaseClass.myWriteAppend(errorlog,bannedWord);

			}
		}
		else{
			System.out.println("No "+SearchText+" found on the site");
			BaseClass.myWriteAppend(errorlog,"No "+SearchText+" found on the site");

		}
		if(four0Four.size()>0)
		{
			System.out.println("404 error found on "+four0Four.size()+" URLs:");
			for (String e404: four0Four )
			{
				System.out.println(e404);
				BaseClass.myWriteAppend(errorlog,e404);

			}
		}
		else{
			System.out.println("No \"page not found\" errors on the site");
			BaseClass.myWriteAppend(errorlog,"No \"page not found\" errors on the site" );
		}
		if(pageTitle.size()>0)
		{
			System.out.println(" "+pageTitle.size()+" URLs:");
			for (String blankTitle: pageTitle )
			{
				System.out.println(blankTitle);
				BaseClass.myWriteAppend(errorlog,blankTitle );

			}
		}
		else{
			System.out.println("No blank page titles on the site");
			BaseClass.myWriteAppend(errorlog, "No blank page titles on the site");
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
