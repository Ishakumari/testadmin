package test1admintestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tes1adminbase.TestBase;
import test1adminpages.Dashboardpage;
import test1adminpages.Loginpage;
import test1adminpages.Tools;

public class ToolsTestCases extends TestBase{
	Loginpage loginpage;
	Dashboardpage dashboardpage;
	Tools tools;
	
	public ToolsTestCases(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){	
		initialize();
		loginpage=new Loginpage();
		dashboardpage=loginpage.Login(prop.getProperty("storecode"), prop.getProperty("password"));
		tools=new Tools();
	}
	@Test(priority=1)
	public void validateAddTable() throws InterruptedException {
           tools.clickOnTools();
           tools.clickonTableInfo();
           tools.clickOnAddNewTable();
           tools.addTable("15", "4");
           
           tools.getTextofTableNoColumn();
           for(int i=0; i<tools.RowCount(); i++) {
   			String Table_No=tools.getTextofTableNoColumn();
   			System.out.println(Table_No);
   			if(Table_No.equalsIgnoreCase("7")) {
   				System.out.println("created table is available in the list"+ Table_No );}
   			else {
   				System.out.println("created table is not available in the list"+ Table_No );}

   		  
           }}
           //tools.rowCount();
           
     
	
	@Test(priority=2)
	public void validateAddOrderType() throws InterruptedException {
        tools.clickOnTools();
        tools.clickOnOrderType();
        tools.clickOnAddOrderType();
	    tools.addOrderType("Delivery1");
	    }
    @Test(priority=3)
	public void validateAddPaymentType() throws InterruptedException {
        tools.clickOnTools();
        tools.clickOnPaymentType();
        tools.clickOnAddPaymentType();
		tools.addPaymentType("Credit3", "10");
	}
    @Test(priority=4)
    public void validateCreateDiscount() throws InterruptedException {
        tools.clickOnTools();
        tools.clickOnDiscount();
        tools.clickOnCreateDiscount();
        tools.addDiscount("HNY offer1", "Percentage");
	}
    @Test(priority=5)
    public void validateDeliverySetup() throws InterruptedException {
        tools.clickOnTools();
        tools.clickOnDeliverySetup();
        tools.clickOnAddZipCode();
		tools.addDeliverySetup("201302", "80");
	}
    @Test(enabled=false)
    public void validatePaymentGateaway() throws InterruptedException {

        tools.clickOnTools();
        tools.clickOnPaymentGateway();
        tools.clickOnAddPaymentGateway();
		tools.addPaymentGateaway("2a113eaf7aaecde2", "Pax");
	}
    
    @AfterMethod
    public void teardown()
    {
    	driver.quit();
   }

}
