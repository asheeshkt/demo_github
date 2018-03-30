package com.testRunner;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UserStrory_1 
{
	@Test()
	public void TC_001()
	{
		System.setProperty("webdriver.firefox.marionette", "D:\\selenium project\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.freecrm.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123",Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		WebElement checkbox=driver.findElement(By.xpath("//tr[td[a[contains(text(),'aaa')]]]/td/input[@type='checkbox']"));
		if(checkbox.isSelected())
		{
			System.out.println("element is selected");
		}
		else
			checkbox.click();
	}
	
	@Test(enabled=false)
	public void windowhandle()
	{
		System.setProperty("webdriver.firefox.marionette", "D:\\selenium project\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String parentid=driver.getWindowHandle();
		System.out.println(parentid);
		Set<String>windowIds=driver.getWindowHandles();
		//Iterator it=windowIds.iterator();
		System.out.println(windowIds);
		for(String child:windowIds)
		{
				
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				driver.close();
			
		}
		
		
		
		
		
		
		
		
		
	}
}
