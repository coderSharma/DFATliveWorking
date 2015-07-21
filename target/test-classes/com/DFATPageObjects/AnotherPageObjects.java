package com.DFATPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.DFAT_Australia.BaseClass;


public class AnotherPageObjects extends BaseClass{

	@FindBy(how= How.ID, using="")
	public WebElement myElement;
	
	public AnotherPageObjects(WebElement myElement)
	{
	this.myElement=myElement;	
	}
}
