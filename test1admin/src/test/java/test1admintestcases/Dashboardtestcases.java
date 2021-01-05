package test1admintestcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tes1adminbase.TestBase;
import test1adminpages.Dashboardpage;
import test1adminpages.Loginpage;

public class Dashboardtestcases extends TestBase{

	Loginpage loginpage;
	Dashboardpage dashboardpage;

	Dashboardtestcases(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialize();
		loginpage=new Loginpage();
		//dashboardpage=new Dashboardpage();

		dashboardpage=loginpage.Login(prop.getProperty("storecode"), prop.getProperty("password"));
	}

	@Test
	public void verifyCrossfunction() throws InterruptedException{
		dashboardpage.clickOnCross();
		dashboardpage.clickOnThreeHorizantalline();
	}

	@Test(enabled=false)
	public void verifyClickOn3Horizantalline() throws InterruptedException	{
		dashboardpage.clickOnThreeHorizantalline();

	}
	@Test
	public void verifydashboardTitle() {
		String dasboardtitle=dashboardpage.verifyTitle();
		System.out.println(dasboardtitle);
		Assert.assertEquals(dasboardtitle, "Cravrr Admin");
		
	}
	@Test
	public void TotalLinksOnHomePage() throws IOException, InterruptedException {
		System.out.println("The count of links is:"+ dashboardpage.totalLinkOnHomePage());
	for(int i=0;i<dashboardpage.totalLinkOnHomePage();i++) {
                 //System.out.println(loginpage.geturl());
		//by using href attribute, we can get URL of required link
		String url= dashboardpage.geturl().get(i).getAttribute("href");
		System.out.println(url);
		if(url == null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");
			                continue;
			            }
			            
//			            if(!url.startsWith(url)){
//			                System.out.println("URL belongs to another domain, skipping it.");
//			                continue;
//			            }
		verifyLinks(url);}}
		
	public void verifyLinks(String url) throws IOException {
		try {
		URL link=new URL(url);
		//create a connection using url object 'link'
		HttpURLConnection httpconn=(HttpURLConnection)link.openConnection();
		httpconn.setConnectTimeout(5000);
		httpconn.connect();
		
		if(httpconn.getResponseCode()>=400)
        {
        	System.out.println(url+" - "+httpconn.getResponseMessage()+"is a broken link");
        }    
   
        //Fetching and Printing the response code obtained
        else{
            System.out.println(url+" - "+httpconn.getResponseMessage());
        }
    }catch (Exception e) {
        e.printStackTrace();
    }


	}

	@Test(enabled=false)
	public void verifyStoresCount() {
		System.out.println(dashboardpage.totalStores());
		System.out.println(dashboardpage.totalStoresCount());
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
