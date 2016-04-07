package com.flipkart.automation.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sanity {

	WebDriver driver;
	public static void main(String[] args) {
		
		
//		//1) Retrieve price of 
//		//Moto G (3rd Generation)(Black, 16 GB) from 
//		//"http://www.flipkart.com/"
//		
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\libs\\chromedriver_win32\\chromedriver.exe");
//		
		Sanity tests = new Sanity();
		tests.driver = new ChromeDriver();
		tests.runFlipKartDataDrivenExample();
		
		
	}
	
	public void runFlipKartDataDrivenExample(){
		
		driver.get("http://www.flipkart.com");
		
		//get search string from Excel Sheet
		
		String searchKey = ExcelReader.getDataFromExcel("C:\\automation\\Eclipse_WS\\PracticeSessions\\TestData.xlsx", 
				"searchdata", 2, 2);
		
		System.out.println(searchKey);
		
		driver.findElement(By.name("q")).sendKeys(searchKey);
		

		
	}
	
	public void mapExample(){
Map<String, String> student1 = new HashMap<String, String>();
		
		student1.put("id", "1");
		student1.put("name", "studen1");
		student1.put("age", "10");
		
		
		Map<String, String> student2 = new HashMap<String, String>();
		
		student2.put("id", "2");
		student2.put("name", "studen2");
		student2.put("age", "10");
		
		Map<String, String> student3 = new HashMap<String, String>();
		
		student3.put("id", "3");
		student3.put("name", "studen3");
		student3.put("age", "10");
		
		Map<String, Map<String,String>> students = new HashMap<String, Map<String,String>>();
		students.put("dataSet1", student1);
		students.put("dataSet2", student2);
		students.put("dataSet3", student3);
		
		
		
		
		
//		
//		for (int i = 1 ; i<= student.entrySet().size();i++){
//			System.out.println(student.get(i));
			
//			Map<Integer, String> student = new HashMap<Integer, String>();
//			
//			student.put(1, "student1");
//			student.put(2, "student2");
//			student.put(3, "student3");
//			
//			for (int i = 1 ; i<= student.entrySet().size();i++){
//				System.out.println(student.get(i));
//				
//			}
			
//			for (Map.Entry<Integer, String> entry : student.entrySet())
//			{
//			    System.out.println(entry.getKey() + "/" + entry.getValue());
//			}
			
			
//			System.setProperty("webdriver.chrome.driver", "C:/automation/libs/chromedriver_win32/chromedriver.exe");
//			tests.driver = new ChromeDriver();
//			
			
			
			
		}
	
	
	public void radioExample(){
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		List<WebElement> exp = driver.findElements(By.xpath("//input[@type='radio'][@name='exp']")); //will return
		
		for(int i = 0; i< exp.size();i++){
			String txt = exp.get(i).getAttribute("value");
			
			if(txt.equalsIgnoreCase("3")){
				if(! exp.get(i).isSelected())
				{
				 exp.get(i).click();
				 break;
				}
			}
			
		}
		
		
	}
	
	public void toosQATableExample(){
		driver.get("http://toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/");
		String str="";
		for(int row=1;row<=3;row++)
		{
			for (int col = 1 ; col<=3;col++)
			{
			WebElement element = driver.findElement(By.xpath("//*[@id='post-2924']/div[1]/div[2]/div[1]/div/table/tbody/tr["+row+"]/td["+col+"]"));
			
			str = element.getText();
			
			
			System.out.println(str);
			
			}
		}
		
		
		if (str.equalsIgnoreCase("SELENIUM")){
			System.out.println("Passed");
		}
		else{
			System.out.println("Failed");
		}
		
		
		
		
	}
	
	public void flipKart(){
		
		
		
				driver.get("http://www.flipkart.com");
				
				//driver.findElement(By.name("q")).sendKeys("Moto G");
				
//				WebElement element = driver.findElement(By.xpath("//input")); //only one
//				element.sendKeys("Moto G");
				
				List<WebElement> elements =driver.findElements(By.xpath("//input")); // will give 5 matching elements
				
				System.out.println("size" + elements.size() );
				
				if(elements.size()>0)
				{
					elements.get(1).sendKeys("Moto G");
				}
//				
//				
//				String s = driver.findElement(By.name("q")).getText();
		
	}
	

}