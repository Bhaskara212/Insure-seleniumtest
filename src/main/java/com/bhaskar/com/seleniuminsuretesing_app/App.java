package com.bhaskar.com.seleniuminsuretesing_app;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	//System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver13\\chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-usage");
       // DesiredCapabilities cp = new DesiredCapabilities();
       // cp.setCapability(ChromeOptions.CAPABILITY, options);
        //options.merge(cp);
        WebDriver driver = new ChromeDriver(options);
        
        System.out.println("Selenium Test Scripts Execution Started..");
       
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         //driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
         //driver.manage().window().maximize();
         driver.get("http://172.31.86.28:8081/contact.html");
         
         
        //driver.findElement(By.className("nav-link")).click();
         driver.findElement(By.id("inputName")).sendKeys("Bhaskar");
         Thread.sleep(2000);
         
         driver.findElement(By.id("inputNumber")).sendKeys("99121916");
         Thread.sleep(2000);
         
         driver.findElement(By.id("inputMail")).sendKeys("pitchikas.212@gmail.com");
         Thread.sleep(2000);
         
         driver.findElement(By.id("inputMessage")).sendKeys("I want full info about personal insurance.");
         Thread.sleep(2000);
         
         driver.findElement(By.id("my-button")).click();
         Thread.sleep(2000);
         
         
         TakesScreenshot scrShot = ((TakesScreenshot)driver);
         File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
         File destFile = new File("screenshot.png");
         FileUtils.copyFile(srcFile, destFile);
         System.out.println("reports stored at : " + destFile.getAbsolutePath().toString());
         Thread.sleep(7000);
         driver.quit();
        // System.out.println("Script executed successfully");
    }
}
