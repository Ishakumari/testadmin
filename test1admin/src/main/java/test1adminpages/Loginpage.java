package test1adminpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tes1adminbase.TestBase;

public class Loginpage extends TestBase{
		
	//initializing the page objects
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}



@FindBy(xpath="//input[@name=\"email\"]")
WebElement Storecode;
@FindBy(xpath="//input[@name=\"password\"]")
WebElement Password;
@FindBy(xpath="//span[@style=\"font-size:0.9rem;\"]")
WebElement showpassword;
@FindBy(xpath="//button[@type=\"submit\"]")
WebElement login;
@FindBy(xpath="//p[@id=\"forget-btn\"]")
WebElement forgetpassword;
@FindBy(xpath="//h3[@class=\"text-left txt-primary\"]")
WebElement loginheader;
@FindBy(xpath="//img[@class='logo_img']")
WebElement Logo;
@FindBy(tagName="a")
List<WebElement>totallink;


public Dashboardpage Login(String sc, String pd) {
	Storecode.sendKeys(sc);
	Password.sendKeys(pd);
	showpassword.click();
	login.click();
	return new Dashboardpage();
}

public  String title() {
     return driver.getTitle();


}
public void clkforgetpassword() throws InterruptedException {
	forgetpassword.click();
	Thread.sleep(4000);
}
public String Loginheader() {
	String Text;
	return Text= loginheader.getText();
	
}

public int totalLinkOnLoginPage() {
	//List<WebElement>totallink=driver.findElements(By.tagName("a"));
	return totallink.size();
}
public List<WebElement> geturl() {
	List<WebElement> linktext = totallink;
	return linktext;
	
}





	//if (loginheader.getText().equalsIgnoreCase("Login to Your Account")) {
        //System.out.println("Header text exists");} else
        //System.out.println("Header text deoes not exists");}

public boolean logo() {
	boolean logo=Logo.isDisplayed();
return logo;

}
}
