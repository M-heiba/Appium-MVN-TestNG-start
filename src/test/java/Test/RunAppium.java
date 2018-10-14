package Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class RunAppium {
	
	public MobileDriver  driver;
	public String  DeviceName =	"PLEGAR1790202346"; //DeviceId from "adb devices" command
	public String  AndroidVersion =	"8.1.0";
				
	@BeforeTest
	public void setup() throws MalformedURLException {
//		File f=new File("src");
		File fs= new File("CRD-v2.9.2-Dialer-mea-debug-app-2.8.3-2830-000.apk");
		
		DesiredCapabilities cap =new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName); // Mandatory
//      caps.setCapability("udid", "WUJ01N4RQ3");       //DeviceId from "adb devices" command
		
		cap.setCapability("platformName","Android"); // Mandatory
		
//		cap.setCapability("platformVersion", AndroidVersion);
//		cap.setCapability("VERSION", "4.4.2");
		
		cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath()); // Mandatory
		
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Uiautomato2");
//		cap.setCapability("BROWSER_NAME", "Android");   //When testing a web application on a browser, for example, "browserName", "safari" or "Chrome".
 
//		cap.setCapability("deviceName",);     // when using emulator
//		caps.setCapability("deviceName", "Galaxy Nexut API 24");   //May not be used if UDID is specified
//      caps.setCapability("udid", "WUJ01N4RQ3");       //DeviceId from "adb devices" command

        cap.setCapability("skipUnlock","true");        
        cap.setCapability("noReset","false");
		
		cap.setCapability("appPackage", "com.orange.phone.mea");
		cap.setCapability("appActivity","com.orange.phone.DialtactsActivity");

//        cap.setCapability("AutomationName", "UiAutomator2"); // options : Appium (Default), UiAutomator, UiAutomator2, XCUITest
        // Drivers to run appium with
        // For iOS (versions 9.3 and higher):
        	//The standard Appium behavior for automation is to use XCUITest. 
        	//If you explicitly wish to use UI Automation, set this capability to uiAutomation.
        	//If you are running a pure Appium script, XCUITest requires a Mac Connector. 
        	//UIAutomation does not require a Mac connector for a pure Appium execution.

        //For Android:
        	//The uiautomator2 driver uses Google's UiAutomator2 technology to allow automation on a device or emulator.
        	//To use automation for your Android apps, set the automationName capability to “uiautomator2”. 
        	//To use Uiautomator1, the default value, set the value to "android".
        
        
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            
//        Installing application by appium
//        driver.installApp(fs.getAbsolutePath());
        
//        if is_application_installed(application) then
//        return true
//        else install_application()
//
//        is_application_installed(application)
//        fill out this method with code from http://stackoverflow.com/questions/11392183/how-to-check-programmatically-if-an-application-is-installed-or-not-in-android*
//
//        install_application(application_to_install)
//        adb install -r application_to_install
	
	
	}
	
	@Test
	public void Dummy() {
		System.out.println("This is the test");
	}
	
	
	@AfterTest
	public void Teardown() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("this is the end");
		driver.quit();
//		Remove application after end of test
//		driver.removeApp("<<packageName as String>>");
	}
}



//Working with elements as wait untill and perform action

// adding waits to setup
	// Create a wait object instance in order to verify expected conditions.
	//   WebDriverWait waitController = new WebDriverWait(driver, 60);   
	// Create an implicitly wait instance to define the timeout for 'findElement' commands
	//   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

// in the test script
//   waitController.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='MONEY TRANSFER']")));
//   WebElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='MONEY TRANSFER']");
//   Transfer.click();