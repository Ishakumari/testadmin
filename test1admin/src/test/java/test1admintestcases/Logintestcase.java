package test1admintestcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;

import tes1adminbase.TestBase;
import test1adminpages.Dashboardpage;
import test1adminpages.Loginpage;
public class Logintestcase extends TestBase{
	public Loginpage loginpage;
	Dashboardpage dashboardpage;

	
	public Logintestcase(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){	
		initialize();
		loginpage=new Loginpage();
	}
	
	@Test
	public void TotalValidLinksOnLoginPage() throws IOException, InterruptedException {
		System.out.println("The count of links is:"+ loginpage.totalLinkOnLoginPage());
	for(int i=0;i<loginpage.totalLinkOnLoginPage();i++) {
                 //System.out.println(loginpage.geturl());
		//by using href attribute, we can get URL of required link
		String url= loginpage.geturl().get(i).getAttribute("href");
		URL link=new URL(url);
		//create a connection using url object 'link'
		HttpURLConnection httpconn=(HttpURLConnection)link.openConnection();
		Thread.sleep(2000);
		httpconn.connect();
		int rescode=httpconn.getResponseCode();
		if(rescode>=400) {
			System.out.println(url +"-"+ "is broken link");}
			else{
				System.out.println(url +"-"+ "is valid link");
			}
		}
	logger=extentReports.createTest("TotalValidLinksOnLoginPage");
	}
	
		
	
	
	@Test(priority=4)
	public void validatelogin() throws InterruptedException
	{	 	

		dashboardpage=loginpage.Login(prop.getProperty("storecode"), prop.getProperty("password"));
	//if(driver.getTitle().equals("Cravrr Admin")) {
		//System.out.println("Logined Successfully");}
	//else {
		//System.out.println("Login Failed");}
		logger=extentReports.createTest("validatelogin");

	}
	
	
	
	@Test(priority=3)
	public void verifyforgetpassword() throws InterruptedException {
		loginpage.clkforgetpassword();
		Thread.sleep(3000);
		logger=extentReports.createTest("verifyforgetpassword");



	}

	@Test(priority=2)
	public void Verifyloginheader() {
		logger=extentReports.createTest("Verifyloginheader");

		Loginpage loginpage=PageFactory.initElements(driver, Loginpage.class);
		String actualHeader=loginpage.Loginheader();
		System.out.println("Header is: "+actualHeader);
		if(actualHeader.equals("Login to Your Account")) {
			System.out.println("The actual and expected result are same "+actualHeader);
		}
		else {
			System.out.println("The actual and expected result are not same "+actualHeader);

		}

	}
	@Test(enabled=true)
public void verifyTitle() {
		//Loginpage loginpage=PageFactory.initElements(driver, Loginpage.class);
String actualTitle= loginpage.title();
		Assert.assertEquals(actualTitle, "Cravrr Admin");
		logger=extentReports.createTest("verifyTitle");

		
	}
    @Test(priority=1)
	public void verifylogo() {
	//Loginpage loginpage=PageFactory.initElements(driver, Loginpage.class);
		boolean displaylogo=loginpage.logo();
		if(displaylogo) {
			System.out.println("login logo is displaying");}
		else {
			System.out.println("login logo is not displaying");}
		logger=extentReports.createTest("verifylogo");

}
    
   



}