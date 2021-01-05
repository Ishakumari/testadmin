package test1admintestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tes1adminbase.TestBase;
import test1adminpages.Dashboardpage;
import test1adminpages.Itemmastermodule;
import test1adminpages.Loginpage;
import test1adminpages.MasterCategorypage;

public class ItemMasterTestCases extends TestBase{
	Loginpage loginpage;
	Dashboardpage dashboardpage;
	Itemmastermodule itemmastermodule;
	ItemMasterTestCases()
	{
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialize();
		loginpage=new Loginpage();
		dashboardpage = loginpage.Login(prop.getProperty("storecode"), prop.getProperty("password"));
		itemmastermodule=new Itemmastermodule();

	}

	@Test
	public void validateAddcategory() throws InterruptedException {
		//itemmastermodule=PageFactory.initElements(driver, Itemmastermodule.class);
		//itemmastermodule.clkMasterCategory();
		//itemmastermodule.clkAddMasterCategory();
		itemmastermodule.clickonItemMaster();
		itemmastermodule.clickoncategory();
		itemmastermodule.clickonaddcategory();
		itemmastermodule.addCategory("Burger", "Tequila");}

	@Test
	public void validateAddItem() throws InterruptedException {
		//Itemmastermodule itemmastermodule=PageFactory.initElements(driver, Itemmastermodule.class);
		itemmastermodule.clickonItemMaster();
		itemmastermodule.clickonMenuItems();
		itemmastermodule.clickonAddItem();
		itemmastermodule.addItem("Biryani", "Mains","Mains", "199", "30");

	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
