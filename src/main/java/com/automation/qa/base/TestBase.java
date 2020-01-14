package com.automation.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.qa.constants.Constants;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(Constants.PROPERTYFILELOCATION);
					
			prop.load(ip);

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVERPATH);
			driver = new FirefoxDriver();

		} else {

			System.out.println("Driver is not found");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.WAITTIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.WAITTIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	public static void quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}
