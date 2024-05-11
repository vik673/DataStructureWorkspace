package com.app.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.MouseAction.Button;

/**
 * 
 * @author Dell
 * 
 *
 */
public class SeleniumBasic {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","F:\\e_DAC\\Software Engineering\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		String url="http://localhost:8080/VotersAssignment/";
		driver.get(url);
		System.out.println(driver.getTitle());
		//driver.close(); //closes the windor created by the extecusion
		//driver.quit(); //closes all windows created by this execution
		WebElement txtBox = driver.findElement(By.id("user"));
		//name, xpath, linkText, className, tagName 
		//findelements() which returns a list<webElements>
		
		
		System.out.println(txtBox.toString());
		txtBox.sendKeys("Random");
		WebElement submitButton=driver.findElement(By.id("subform"));
		submitButton.click();
			
		
		//driver.quit();
	
	}
}
