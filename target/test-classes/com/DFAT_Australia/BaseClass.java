package com.DFAT_Australia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class BaseClass {

	protected static WebDriver driver;
	protected static String workingDir = System.getProperty("user.dir").replace("\\","/");
	protected static String cvFilePath= workingDir+"/src/test/resources/com/DFATTestData/UploadCV.exe";
	protected static String picFilePath=workingDir+"/src/test/resources/com/DFATTestData/UploadImage.exe";
	String ReturnText;
	static DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
	static Date date = new Date();
	static int count=0;
	static String newdate = dateFormat.format(date).toString();
	public static File scrshot ;
	static String reportContent;

	public static String createDateFolder (String path) throws IOException {
		String FolderName=workingDir+path+newdate;
		@SuppressWarnings("unused")
		boolean fireup = (new File(FolderName)).mkdirs();
		File Folder=new File(FolderName);
		count =Folder.list().length;
		String CurrentRun=FolderName+"\\Run#"+(count+1)+"\\";		
		@SuppressWarnings("unused")
		boolean fireup2 = (new File(CurrentRun)).mkdirs();
		System.out.println("Folder Created "+CurrentRun);
		return CurrentRun;
	}
	public static Timestamp GetCurrentTimeStamp() 
	{
		
			java.util.Date date= new java.util.Date();
			return new Timestamp(date.getTime());
	}
	public static WebDriver browserSetup(String browserType)
	{

		if (browserType.contentEquals("firefox"))
		{
			driver	= new FirefoxDriver();
		}
		else if (browserType.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","src/test/resources/com/DFATTestData/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserType.contentEquals("ie"))
		{
			driver = new InternetExplorerDriver();
		}
		else if (browserType.contentEquals(""))
		{
			driver = new HtmlUnitDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;
	}

	public static WebDriver browserStackSetup(String browserType) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();	
		if (browserType.contentEquals("chrome")) {
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "36.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "7");

		} else if (browserType.contentEquals("firefox")) {
			caps.setCapability("browser", "Firefox");
			caps.setCapability("browser_version", "31.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "8");

		} else if (browserType.contentEquals("ie")) {
			caps.setCapability("browser", "IE");
			caps.setCapability("browser_version", "11.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "8.1");	
		}
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("browserstack.debug", "true");
		driver = new RemoteWebDriver(new URL("http://gauravsharma17:xYk9UH7Gh96zXx8dQecU@hub.browserstack.com/wd/hub"),caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}




	public static boolean getURL (String URL)
	{

		driver.get(URL);
		return true;

	}
	public boolean waitFor4Seconds () throws InterruptedException
	{

		Thread.sleep(4000);
		return true;

	}
	public static void browserTeardown()

	{
		driver.close();
		driver.quit();
	}



	public boolean startWaitingforElement(WebElement myElement) throws Exception
	{
		while (!myElement.isDisplayed());
		{
			Thread.sleep(1000);
		}
		System.out.println("Found Element:"+myElement.getTagName());
		return true;

	}

	public boolean click(WebElement myElement) 
	{try{
		Thread.sleep(50);
		assertTrue(myElement.isDisplayed());
		myElement.click();
		return true;}
	catch(Exception e)
	{
		System.out.println("Unable to Click WebElement:"+myElement.getTagName());
		return false;
	}

	}

	public boolean enterText(WebElement myElement, String textToEnter)
	{
		try{
			Thread.sleep(200);
			assertTrue(myElement.isDisplayed());
			myElement.clear();
			myElement.sendKeys(textToEnter);
			return true;}
		catch(Exception e)
		{
			System.out.println("Unable to Enter Text in WebElement:"+myElement.getTagName());
			return false;
		}
	}
	public boolean uploadFile(WebElement myElement, String textToEnter)
	{
		try{
			Thread.sleep(50);
			assertTrue(myElement.isDisplayed());
			//myElement.clear();
			myElement.sendKeys(textToEnter);
			return true;}
		catch(Exception e)
		{
			System.out.println("Unable to Enter Text in WebElement:"+myElement.getTagName());
			return false;
		}
	}
	public boolean selectDropDown(WebElement myElement, String value)
	{
		try{
			Thread.sleep(50);
			assertTrue(myElement.isDisplayed());
			Select mySelection = new Select(myElement);
			mySelection.selectByValue(value);
			return true;}	
		catch(Exception e)
		{
			System.out.println("Unable to Select Dropdown WebElement:"+myElement.getTagName());
			return false;
		}
	}
	public boolean checkTextPresent(WebElement myElement,String text)
	{
		//assertthat(text,IsEqualIgnoringCase(myElement.getText());
		assertTrue(myElement.isDisplayed());
		if (myElement.getText().contentEquals(text))
		{
			System.out.println("Text "+text+" present at specified element location");
			return true;
		}
		else 
		{
			System.out.println("Text "+text+" not Present at specified element location");
			return false;
		}
	}
	public String getTextPresent(WebElement myElement)
	{

		if (myElement.isDisplayed())

		{ReturnText=myElement.getText();
		return ReturnText;
		}
		else
			return "Unable to find Element";	


	}
	public static void tearDown(WebDriver driver,List<Boolean> resultArray, List<String> testCaseNames, String resultReport) throws IOException
	{
		int Tests=resultArray.size();
		//String htmlContent;
		String colour;
		for (int i=0;i<Tests;i++)
		{
			{
				if(i%2==0){	
					colour="B6B6B4";
				}
				else{
					colour="E5E4E2";
				}
			}
			if(resultArray.get(i).equals(true))
				if(i==0)
				{
					System.out.println("Environment Setup Passed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>1</td><td>Environment & Browser Setup</td><td><b>Passed</b></td><td><img src=\"../../images/pass.gif\"></td></tr>";
				}
				else {
					System.out.println(testCaseNames.get(i-1)+"Passed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>"+(i+1)+"</td><td>"+testCaseNames.get(i-1)+"</td><td><b>Passed</b></td><td><img src=\"../../images/pass.gif\"></td></tr>";
				}

			if(resultArray.get(i).equals(false))
			{
				if(i==0)
				{
					System.out.println("Environment Setup Failed");
					reportContent="<tr BGCOLOR= \"red\"><td>"+(i+1)+"</td><td>Environment & Browser Setup</td><td><Font color =\"yellow\"><b>Failed</b></font></td><td><img src=\"../../images/bullet.gif\"></td></tr>";
				}
				else {

					System.out.println(testCaseNames.get(i-1)+"Failed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>1</td><td>"+testCaseNames.get(i-1)+"</td><td><Font color =\"red\"><b>Failed</b></font></td><td><img src=\"../../images/bullet.gif\"></td></tr>";
				}
			}

			BaseClass.myWriteAppend(resultReport,reportContent);

		}
		myWriteAppend(resultReport,"<tr BGCOLOR= \"yellow\"><td>Screenshots</td><td><a href=\"ApplicationScreenshot.png\"><b>Application Screenshot</b></td>");
		myWriteAppend(resultReport,"<td><a href=\"SubmissionScreenshot.png\"><b>Submission Screenshot</b></td><td></td></tr>");
		myWriteAppend(resultReport,"</table>");
		myWriteAppend(resultReport,"</center>");
		myWriteAppend(resultReport,"<table border = \"0\" cellspacing = \"0\" cellpadding = \"10\"><tr>");
		EOHTMLGEN(resultReport);
		System.out.println(resultArray.toString());
		System.out.println(testCaseNames.toString());
		driver.quit();

	}
	public static void tearDownErrorLog(WebDriver driver,List<Boolean> resultArray, List<String> testCaseNames, String resultReport,String Errorlog,String URLlog) throws IOException
	{
		int Tests=resultArray.size();
		//String htmlContent;
		String colour;
		for (int i=0;i<Tests;i++)
		{
			{
				if(i%2==0){	
					colour="B6B6B4";
				}
				else{
					colour="E5E4E2";
				}
			}
			if(resultArray.get(i).equals(true))
				if(i==0)
				{
					System.out.println("Environment Setup Passed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>1</td><td>Environment & Browser Setup</td><td><b>Passed</b></td><td><img src=\"../../images/pass.gif\"></td></tr>";
				}
				else {
					System.out.println(testCaseNames.get(i-1)+"Passed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>"+(i+1)+"</td><td>"+testCaseNames.get(i-1)+"</td><td><b>Passed</b></td><td><img src=\"../../images/pass.gif\"></td></tr>";
				}

			if(resultArray.get(i).equals(false))
			{
				if(i==0)
				{
					System.out.println("Environment Setup Failed");
					reportContent="<tr BGCOLOR= \"red\"><td>"+(i+1)+"</td><td>Environment & Browser Setup</td><td><Font color =\"yellow\"><b>Failed</b></font></td><td><img src=\"../../images/bullet.gif\"></td></tr>";
				}
				else {

					System.out.println(testCaseNames.get(i-1)+"Failed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>1</td><td>"+testCaseNames.get(i-1)+"</td><td><Font color =\"red\"><b>Failed</b></font></td><td><img src=\"../../images/bullet.gif\"></td></tr>";
				}
			}

			BaseClass.myWriteAppend(resultReport,reportContent);

		}
		myWriteAppend(resultReport,"<tr BGCOLOR= \"yellow\"><td>Results</td><td><a href=\"ApplicationScreenshot.png\"><b>Application Screenshot</b></td>");
		myWriteAppend(resultReport,"<td><a href=\"SubmissionScreenshot.png\"><b>Submission Screenshot</b></td><td><a href=\"Error_List.txt\"><b>Error Txt</b></td></tr>");
		myWriteAppend(resultReport,"</table>");
		myWriteAppend(resultReport,"</center>");
		myWriteAppend(resultReport,"<table border = \"0\" cellspacing = \"0\" cellpadding = \"10\"><tr>");
		EOHTMLGEN(resultReport);
		myWriteEOF(Errorlog);
		myWriteEOF(URLlog);
		System.out.println(resultArray.toString());
		System.out.println(testCaseNames.toString());
		driver.quit();

	}

	public static void tearDownErrorLog(WebDriver driver,List<Boolean> resultArray, List<String> testCaseNames, String resultReport,String Errorlog) throws IOException
	{
		int Tests=resultArray.size();
		//String htmlContent;
		String colour;
		for (int i=0;i<Tests;i++)
		{
			{
				if(i%2==0){	
					colour="B6B6B4";
				}
				else{
					colour="E5E4E2";
				}
			}
			if(resultArray.get(i).equals(true))
				if(i==0)
				{
					System.out.println("Environment Setup Passed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>1</td><td>Environment & Browser Setup</td><td><b>Passed</b></td><td><img src=\"../../images/pass.gif\"></td></tr>";
				}
				else {
					System.out.println(testCaseNames.get(i-1)+"Passed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>"+(i+1)+"</td><td>"+testCaseNames.get(i-1)+"</td><td><b>Passed</b></td><td><img src=\"../../images/pass.gif\"></td></tr>";
				}

			if(resultArray.get(i).equals(false))
			{
				if(i==0)
				{
					System.out.println("Environment Setup Failed");
					reportContent="<tr BGCOLOR= \"red\"><td>"+(i+1)+"</td><td>Environment & Browser Setup</td><td><Font color =\"yellow\"><b>Failed</b></font></td><td><img src=\"../../images/bullet.gif\"></td></tr>";
				}
				else {

					System.out.println(testCaseNames.get(i-1)+"Failed");
					reportContent="<tr BGCOLOR= \""+colour+"\"><td>1</td><td>"+testCaseNames.get(i-1)+"</td><td><Font color =\"red\"><b>Failed</b></font></td><td><img src=\"../../images/bullet.gif\"></td></tr>";
				}
			}

			BaseClass.myWriteAppend(resultReport,reportContent);

		}
		myWriteAppend(resultReport,"<tr BGCOLOR= \"yellow\"><td>Results</td><td><a href=\"ApplicationScreenshot.png\"><b>Application Screenshot</b></td>");
		myWriteAppend(resultReport,"<td><a href=\"SubmissionScreenshot.png\"><b>Submission Screenshot</b></td><td><a href=\"Error_List.txt\"><b>Error Txt</b></td></tr>");
		myWriteAppend(resultReport,"</table>");
		myWriteAppend(resultReport,"</center>");
		myWriteAppend(resultReport,"<table border = \"0\" cellspacing = \"0\" cellpadding = \"10\"><tr>");
		EOHTMLGEN(resultReport);
		myWriteEOF(Errorlog);
		System.out.println(resultArray.toString());
		System.out.println(testCaseNames.toString());
		driver.quit();

	}

	public static void myWriteAppend (String txtfile, String content) throws IOException {
		File file=new File(txtfile);

		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append(content);
		bw.newLine();
		bw.close();
	}

	public static void myWriteEOF (String txtfile) throws IOException {
		File file=new File(txtfile);
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write("===== Run Completed=====");
		bw.newLine();
		bw.close();
	}

	public static void myWriteSOF (String txtfile) throws IOException {
		boolean fireup = (new File(txtfile)).mkdirs();
		if (!fireup)
		{
			System.out.println("Unable to locate Directory");
		}
		File file=new File(txtfile);
		if(file.exists()==true)
		{
			file.delete();
		}
		if(file.exists()== false)
		{
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("File Created on "+newdate);
			bw.newLine();
			bw.newLine();
			bw.close();
		}
	}


	public static void SOHTMLGENERAL(String path) throws IOException{
		String Script="<!DOCTYPE html><html>" +
				"<title>Automation Test Suite Results</title>" +
				"<body bgcolor =E5E4E2>" +
				"<font face = \"calibri\"><img src=\"http://docs.seleniumhq.org/images/big-logo.png\" />" +
				"<hr size=15 color= 48CCCD>" +
				"<center><H2>Test Results</H2><br>" +
				"<table border = \"0\" cellspacing = \"0\" cellpadding = \"0\" BGCOLOR =E5E4E2>" +
				"<font face = \"calibri\"><tr><td>" +
				"<table border = \"2\" cellspacing = \"0\" cellpadding = \"10\" BGCOLOR =53607E>" +
				"<tr align=\"center\">" +
				"<td><font size = 4 color=95B9C7><centre><b>#</td>" +
				"<td><font size = 4 color=95B9C7><b>Test Case</td>" +
				"<td><font size = 4 color=95B9C7><b>Test Step</td>" +
				"<td><font size = 4 color=95B9C7><b>Result</td>" +
				"</tr>";
		myWriteAppend(path, Script);
	}


	public static void graphHTML(String path) throws IOException{
		String Graph="</table><table BGCOLOR =#A0A0A0><tr><td><br><input type=\"button\" id=\"mySavebutton\" onclick=\"createData()\" value=\"Save Results\"></td><td></td><td></td><td><br><input type=\"button\" id=\"myEditbutton\" onclick=\"this.disabled=true;document.getElementById('mySavebutton').disabled=false;\" value=\"Edit Results\" disabled></td></FORM></tr></table></td><td width=\"30%\" ><table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\"BGCOLOR =\"white\"><tr><td><H2> Test Summary </H2></head><body style=\"font-family: verdana;border: 0 none;\"><div id=\"visualization\" style=\"width: 500px; height: 600px;\"></div></body></td></tr></table></td></font></font></table>";
		myWriteAppend(path, Graph);

	}

	public static void EOHTMLGEN(String path) throws IOException{
		String Content="<P align=right><font size =1><i>Report Compiled Using Java and Selenium Webdriver<a href=\"http://www.java.com\"><img width=\"90\" height=\"100\"src=\"http://www.youngwebbuilder.com/wp-content/uploads/2012/10/Java-logo.png\" /></a><i></font></p></table></head><br>===========================================================<br>Selenium Test Suite Complete<br>===========================================================</html>";
		myWriteAppend(path, Content);

	}

	public static File screenshot (WebDriver mydriver) {
		scrshot = ((TakesScreenshot)mydriver).getScreenshotAs(OutputType.FILE);
		return scrshot;
	}	
}