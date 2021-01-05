package test1adminpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tes1adminbase.TestBase;

public class Users extends TestBase{
	
	public Users() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[contains(text(),'Users')]")
	WebElement users;
	@FindBy(xpath="//span[contains(text(), 'Add Staff')]")
	WebElement addstaff;
	@FindBy(xpath="//a[contains(text(),'Add Employee')]")
	WebElement addemployee;
	@FindBy(xpath="//select[@id='Role']")
	WebElement Role;
	@FindBy(xpath="//input[@name='UserName']")
	WebElement username;
	@FindBy(xpath="//input[@name='MobileNo']")
	WebElement Mobileno;
	@FindBy(xpath="//input[@name='EmailId']")
	WebElement EmailID;
	@FindBy(xpath="//input[@name='Address[Street]']")
	WebElement street;
	@FindBy(xpath="//input[@name='Address[City]']")
	WebElement city;
	@FindBy(xpath="//input[@name='Address[Country]']")
	WebElement country;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//body/div[@id='pcoded']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[6]/div[1]/input[1]")
	WebElement DOB;
	@FindBy(xpath="//body/div[@id='pcoded']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[6]/div[2]/input[1]")
	WebElement DOJ;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement save;
	@FindBy(xpath="//button[@class='confirm']")
	WebElement Ok;
	
	public void clickOnUsers() {
		users.click();
	}
	
	public void clickOnAddStaff() {
		addstaff.click();
	}

	public void clickOnAddEmployee() {
		addemployee.click();
	}
	public void AddStaff() {
		
	}
	public void staffDetails(String role, String name,String No,String email, String Street,String City, String Country,String pass) throws InterruptedException {
		Select select=new Select(Role);
		select.selectByVisibleText(role);
		username.sendKeys(name);
		Mobileno.sendKeys(No);
		EmailID.sendKeys(email);
		street.sendKeys(Street);
		city.sendKeys(City);
		country.sendKeys(Country);
		password.sendKeys(pass);
		//DOB.click();
		//save.click();
		//Ok.click();
		Thread.sleep(3000);
	}
	
}





