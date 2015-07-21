package com.DFATPageObjects.MyApplications;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.DFAT_Australia.BaseClass;


public class LoginPageObjects extends BaseClass{
	public WebDriver driver;
	boolean Errorcheckresult;
	String SecurityKey ;
	// Credentials for staging server	
	/*String Username="Tester12345";
	String Password="Welcome12345!";		
	String SecureKey= "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";
	*///Credentials for live
	String Username="Tester12345";
	String Password="Welcome12345!";		
	String SecureKey= "lQO+BFTikH0BCADPu3TpEjaqAJ/IFM8OFXMy3gtk/pqh1hOcXvXQHCVUkjCVOQHbOMCEJ5cEvZ7Onw7RSULCVMGSwVK99lUPdFdXM3WLlv+xH07E6vfvjg30gEbHfBmJavg0F3k0SJrCH2lRgIMMZR71e2HTSKpINAgCJlWarT8wzxCQBSkpa60ygzxtxk1eeKxumle9Lhl9jT5VxNvdN1yqfkze3t6wJC/pC8g5c/YH74b+2VQx7oyPnNySCOv9Wge8ectUb4Vpw8injzA3J50+ztk51MWHtIp1o1F4wR94FM21wswQE+J+6+g3i7KnOPLjgEaPmyTntA0uJvWTZeENqb90mn36sWenABEBAAH+AwMCJTxyz85V5v1gdiKdV0ntB25DmovNKY3yyaa3/FL6n6xZxk0NeKubXS/EPsF3OzA+Bok1pJf3HSY1tMYTtTqHJ8T8aaTRxl5CFp25NaLz3SWyeiIhi77HOMkaMaFsFEFH3zyXGgWmgyiVs+rofY9ye1PIUFFdft7Ov24g0bJMNzzfZVHNkmXZ2ZvaVoxSMx3KRdSq/maUJIIzMawnVxLyrgGrr34HQ0CcIUds1uWkc3LKXZ0OaXBUv7QhbWhIcrzOup6f6pR2xgtSymA9Re8+URLFfTm9ViHZrg7cFPxrD7s1utZgojP+G+ptfntVT/j7QuHK+egYQBQfxuMlEsoaSgF+TH13+QlQkN4tsz6WpQ79rrP4hslrY8gqWAruZsBF0Rb3fUbLGz/upu7b1yWAEfWbpzEaqDHY5ZaWLwYJWlnSEtkeo1FZTg/EyRYdLN48mZJdp0Uhl2ksfRbqqEcJFCKrOlVW6QTar5IlM0AlIiv7FXML9kvV9c+anKqweuvjOgxbSga89h/pZd3ociqB8oUoo9s16agvdgJJndtTwZp9zMUtPhCXeAUgV7Sdy1arsDcrvq6f60SToozHZYgGtWXF6G4WQ2jFE4+0jeEUgsK0Y2zfnn7BtAcVQGSV6XzZc6Sc6UmUXZ8FeT16y7mZJXfebtWKVdFAyKScqbxifd3vlKJiWPihyrjciAdSgnhYhiGiuuDaQ2cPGv9ijssihqq2yf8BHbtYEAto6C6Y30ol3eM0pya4awWC9yChkXKeN3itDMCBSzygVXCvAnFaD2kT3WABAdebufC+Eyjh00WUZ+qsu7QPw3EgYVqGDW9cHWP07N161XdRCWNw04al62EW3XnjGPKmFLn2pPPnb2+nA9Q9UVZaCgK0/TIBPJZtnCayvltpjqi7MD+C/7QoNEU0MEU1QjZDMDVBMTk5QjM4RDNFRUQ0MkJFMkM0OEZDQUY2MkIyNokBIgQTAQIADAUCVOKQggIbAwIZAQAKCRDhnEUm1p8hUwFBCACT2LxgIMwaz6nKh/FIqGlSYL5QFRJudhJn6w0qKSKiisRya5sr/64JhDPdkyME+q4CuOZdanM+llo9R6is4KcpOGs4vwnQKiUByYSoF287qxYeNdZtN2/UFqU4ks/D+olt53MIQP1KThZDwTFm+uVrXmeFR+9eEIMjl9mpctwzIb7FddszuwlrfKeMdCZnsTHs2HazdfHul/Wj+i/5VM8Ftrr18PGVGpa9CUqMZYFD3nrFvYGEonD1EZylw/iFiM576VJh3DYGjJVL62JC67exVcJtWZxDYkujntydeNbPk9oKxCjuHsjmS9c1YE19xczTQ4O1muZG6YC+/mEQC0VTnQO+BFTikH0BCACSFzoWub9QXtR9iGaa635SbaaT/VLw9jcnOojqdE578Bvx5ghCE9RsTkidX4p/CRo70NzjFuM1kCh9td2/MTvcpdyVS2G9+wLlO6lmGtdRsNYhDYET+/AEq16BOC25FFG8hPbG29hX4ZtgsY0KtHeaIoBxUsn2j0MckadwyZ1ClbTjclCzmVgeBaebw8Oe3QZ5qLJI1Y1iywSPdOAXGEOECpDgLL7jUyZQoxlzfN5oTy6+8fsifWlgtZRKLNcA8zsGdMQOQPQ16zQT7u0sz+tnZt9YCIj2nN9MWT+OO7xbk5e4KcgVM33gw7YAC4O+UholzPvNkdw+HJ3UuN5q7sw/ABEBAAH+AwMCtxlKGQNM4GRgLm4hoeJUXPTpHASjXsIGzQ5vRPCceejOMBZ6QgylIQP0LGCx7vh+y5lJhNfyslg1wExMbIGv/yNHBdVXFB8gzcfzfxl6HMSGAbfcl3Mu5lTsssCMgEarbB4OaS2OZ4tzq8k+9EhnPnFH4XVxRjJ4bd/ZGraF85gANNXPCw2ZKGq+SKedMaO6E7WsTInvPcVvdkWnn4M9691NZELI3GcHNlLGAkkbh/wofRUZS6HDDvTvKOxlUuVfZi6U7lXwNH+bK32sRGIrDfMupKa8ylrHZv8Gc9hvjmYu9gJXEDKyiRnMTscKO+RcbQe5VMO7loLVSSgPayJ6dYBMNESSkEUi9BL853BjeVhrSi65pMkmZeXZMC+K0MnTVr388Gat8OfMJDFl8drYgYUKNapmvHYKKplnWIedbP8KJ9+8hNK9ElslFtnkxyhJ9imchc82JaQVNfO2RxYH1FO82wLrVpGGKXFtRxbT0syIIq0XNBKmsOnWjkOcXUDmufqI0QY3To3BfS+/8i3DBE8T30yQ7xTMk/wta0r+/Q6xxyaMcqWSY+wuofuXrXMaNb2dJ+o//thzjPExVddzlbbbOweZetJX7mZZDXnZKInXr5XZH291bVcP5o9a+M7JVwxZYMgYdAenUxrF9OaEe6r/ns6+p7ZD2mgQeKgvYKhGaoKPm1fIMTrMHwbHaEPmgqJARDNIvLW9eeWMI0/heqviSofVMnGJUUmAqdY86x66pW7PhWgneRV5YiZhlOwJpWmtPySznpu6xWk9EoXHwDYyXWjz2dWbY5QJFu24YnI7o7EbnextdHc2zmtJHSW400Y/Ytqd3hN6bvvqkyi8RsfUexxvl5StA8Q9YKQbH5l7bysx6KLKNyYBmFTdb95BdKEgL+mGJxUu4F1pU4kBHwQYAQIACQUCVOKQgwIbDAAKCRDhnEUm1p8hU9xIB/0fmkShWlTCJoxqKrwSY9W3490BmV+90uYBU4e28vfi/w/yDQquJLCZdiEw87eCxxnFhjQ61K4J9Nyln/vr2cvB8+6Vnv1Q87Hi9ujeHVp15hHBpYCzg1q6C/hVVcKzPP7Xla4n9O9Ev36XrFvOBPPyPYbgrZxdjHvNjWW9fDzZOUrk0PIIV378jeX1tVcePB8tpynnm7yycuPwj0gOPcGzI+s+Z/uoZ03CoezKuES6sORVZBvjCPow45eQ7xsxHoFAQO6M4CZt9tON63wTuYcGibgaaEXFBQXBSYgXlAWTIs5ZacszLeHDLMGApZiU0UUglK3/vKAVBJ01yEXwtPe7";
	
	
	//The element is now looked up using the name/ID/XPATH attribute

	@FindBy(how = How.XPATH, using = "//strong[contains(.,'Create new account')]")
	public WebElement CreateNewAccountTextBoxRadioButton;

	@FindBy(how = How.XPATH, using = "//strong[contains(.,'Login to existing account')]")
	public WebElement LoginToExistingAccountRadioButton;

	@FindBy(how=How.ID, using="UserName")
	public WebElement UsernameTextBox;

	@FindBy(how = How.ID, using ="Password")
	public WebElement PasswordTextBox ;
	
	@FindBy(how = How.ID, using ="passwordcheck")
	public WebElement PasswordTextBox1 ;
		
	@FindBy(how = How.ID, using ="ConfirmPassword") //input[@id='ConfirmPassword']
	public WebElement PasswordTextBox2 ;

	@FindBy(how=How.ID, using ="Privatekey")
	public WebElement KeyTextBox;
	
	@FindBy(how=How.XPATH, using ="//div[@class='icon--error']")
	public WebElement ErrorIcon;
	
	@FindBy(how=How.XPATH, using ="//input[@value='Create Account']")
	public WebElement CreateAccountButton;

	@FindBy(how=How.XPATH, using ="//textarea[@name='securitykey_output']")
	public WebElement SecurityKeyTextBox;
	
	@FindBy(how=How.XPATH, using ="//label[@for='copyClipboardKey1']")
	public WebElement CopyConfirmationCheckBox;
	
	@FindBy(how=How.XPATH, using ="//input[@value='BEGIN APPLICATION']")
	public WebElement BeginApplicationButton;
	
	
	
	@FindBy(how=How.XPATH, using ="//input[@value='Login']")
	public WebElement LoginButton;



	public boolean FillForm()
	{try{
		click(LoginToExistingAccountRadioButton);
		enterText(UsernameTextBox,Username);
		enterText(PasswordTextBox, Password);
		enterText(KeyTextBox,SecureKey);
		click(LoginButton);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	}
	public boolean FillForm(String Username,String Password,String SecureKey,String Path)
	{try{
		click(LoginToExistingAccountRadioButton);
		enterText(UsernameTextBox,Username);
		enterText(PasswordTextBox, Password);
		enterText(KeyTextBox,SecureKey);
		click(LoginButton);
		Thread.sleep(2000);
		if (ErrorIcon.isDisplayed()){
		try{
			
				System.out.println("Need to create new credentials");
				click(CreateNewAccountTextBoxRadioButton);
				enterText(UsernameTextBox, Username);
				enterText(PasswordTextBox1, Password);
				enterText(PasswordTextBox2, Password);
				click(CreateAccountButton);
				SecurityKey=getTextPresent(SecurityKeyTextBox);
				System.out.println("SecurityKey is "+SecurityKey);
				UpdateExcel(SecurityKey, Path);
				click(CopyConfirmationCheckBox);
				click(BeginApplicationButton);
				
			}
			
		catch (Exception e)
		{
			return false;
		}
		
		
		}
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
		click(LoginButton);
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
			click(LoginToExistingAccountRadioButton);
			click(LoginButton);
			Errorcheckresult=errorChecker(Driver,Path,Section,Errors);
			//Fill Form
			enterText(UsernameTextBox, Username);
			enterText(PasswordTextBox, Password);
			enterText(KeyTextBox,SecureKey);
			click(LoginButton);
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
	public void UpdateExcel(String Key, String Path) throws IOException
	{
		try{
		FileInputStream file = new FileInputStream(new File(Path));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
	    HSSFSheet sheet = workbook.getSheetAt(0);
	    Cell cell = null;
	    cell = sheet.getRow(1).getCell(2);
	    cell.setCellValue(Key);
	    file.close();
	    FileOutputStream outFile =new FileOutputStream(new File(Path));
	    workbook.write(outFile);
	    outFile.close();
	    System.out.println("Updated Excel Successfully ");
	    workbook.close();
		}
		catch(Exception e)
		{
			System.out.println("Unable to update key");
		}
		
	}

} 

