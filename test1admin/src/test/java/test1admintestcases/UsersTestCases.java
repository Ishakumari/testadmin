package test1admintestcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tes1adminbase.TestBase;
import test1adminpages.Dashboardpage;
import test1adminpages.Loginpage;
import test1adminpages.Users;

public class UsersTestCases extends TestBase{
	Loginpage loginpage;
	Dashboardpage dashboardpage;
	Users users;
	
	public UsersTestCases(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){	
		initialize();
		loginpage=new Loginpage();
		dashboardpage=loginpage.Login(prop.getProperty("storecode"), prop.getProperty("password"));
		users=new Users();
	}
	@Test
	public void validateAddStaff() throws InterruptedException {
		users.clickOnUsers();
	    users.clickOnAddStaff();
		users.clickOnAddEmployee();
		//users.addStaff("Manager", "Sonu", "9999999999", "abc@gmail.com", "Sec-2", "Noida", "India","123456");
	}

}
