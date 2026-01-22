package testBases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	public Logger log;
	
	@Parameters({"browser","os"})
	@BeforeClass
	public void Setup(String browser,String os) throws IOException
	 {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".//src//test//resources//config.properties");
		prop.load(fis);
		log= LogManager.getLogger(this.getClass());
		
		// For Browser Compatibility
		switch(browser.toLowerCase())
		{		
		case "chrome": driver= new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		case "default" : System.out.println("Not a Valid Browser"); return;
		}
		
		// For Navigating into the Application URL: -
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	 }
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String RandomString()
	{
		return RandomStringUtils.randomAlphanumeric(4);
	}
	
	public String RandomNum()
	{
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String CaptureScreen(String Name)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String TimeStamp = df.format(dt);
		
		String TargetFilePath = System.getProperty("user.dir")+"//screenShots//"+ TimeStamp+".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File TargetFile = new File(TargetFilePath);
		source.renameTo(TargetFile);
		return TargetFilePath;	
	}
}
