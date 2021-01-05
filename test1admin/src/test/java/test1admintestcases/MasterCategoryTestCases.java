package test1admintestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tes1adminbase.TestBase;
import test1adminpages.Dashboardpage;
import test1adminpages.Loginpage;
import test1adminpages.MasterCategorypage;

public class MasterCategoryTestCases extends TestBase{
	Loginpage loginpage;
	Dashboardpage dashboardpage;
	MasterCategorypage mastercategorypage;
	MasterCategoryTestCases()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginpage=new Loginpage();
		mastercategorypage=new MasterCategorypage();
		dashboardpage=loginpage.Login(prop.getProperty("storecode"), prop.getProperty("password"));
		
	}
	
	
		@Test
	public void validateAddMasterCategory() throws InterruptedException {
		mastercategorypage.clickonitemMaster();
			mastercategorypage.clickonMasterCategory();
			mastercategorypage.clickonAddMasterCategory();
			
		mastercategorypage.addMasterCategory("Furniture1","0");
		
		//String headermastercategory=mastercategorypage.headerofMasterCategoriesmodule();
		//System.out.println(headermastercategory);
		

	
		
		}
		@AfterMethod
	    public void teardown()
	    {
	    	driver.quit();
	   }

}
