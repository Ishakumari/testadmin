package tes1adminbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest logger;
	

	public TestBase() {
		//how to read properties file
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Cravver\\Desktop\\Selenium\\test1admin\\src\\main\\java\\Test1adminConfig\\config.properties");		
			prop.load(ip);	
		}catch(FileNotFoundException e) {
         e.printStackTrace();}
		catch(IOException e) {
			e.printStackTrace();
		}}
	

	public static void initialize() {

		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cravver\\Desktop\\Selenium\\test1admin\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Cravrr\\Desktop\\Selenium\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();}
driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));}


@BeforeSuite
public void setExtent() {
	
	htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/test-output/Report/testadmin.html"));
	htmlReporter.config().setDocumentTitle("Automation Report");
	htmlReporter.config().setReportName("Functional Report");
	htmlReporter.config().setTheme(Theme.DARK);
	
	extentReports =new ExtentReports();
	extentReports.attachReporter(htmlReporter);
	extentReports.setSystemInfo("Hostname", "LocalHost");
	extentReports.setSystemInfo("OS", "Windows10");
	extentReports.setSystemInfo("Tester Name", "Isha");
	extentReports.setSystemInfo("Browser", "Chrome");}


@AfterTest
public void endReport() {
	extentReports.flush();
	driver.quit();
}

@AfterMethod
public void verifyResults(ITestResult results) {
if(results.getStatus()==ITestResult.FAILURE) {


logger.log(Status.FAIL, "Test Case is Fail" + results.getName());
logger.log(Status.FAIL, "Test Case is Fail" + results.getThrowable());}

else if(results.getStatus()==ITestResult.SKIP) {
	logger.log(Status.SKIP, "Test Case is Skipped" +results.getName());}
else{
	logger.log(Status.PASS, "Test Case is Pass"+results.getName());}
}


}







//logger=Logger.getLogger("Logintestcase");
//PropertyConfigurator.configure("Log4j.properties");
//public static Logger logger;


//@AfterMethod
//public void verifyResults(ITestResult results) {
//if(results.getStatus()==ITestResult.FAILURE) {
//Reporter.log("Test Case is Fail"+results.getName());}
//else if(results.getStatus()==ITestResult.SKIP) {
//Reporter.log("Test Case is Skipped"+results.getName());}
//else{
//Reporter.log("Test Case is Pass"+results.getName());

//}

//@AfterClass
// Test cleanup 
// public void TeardownTest() { 
//driver.quit(); 
//} 	

