package test1adminpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tes1adminbase.TestBase;

public class Dashboardpage extends TestBase{




	public Dashboardpage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//div[@class='hamburger-box']")
	WebElement cross;
	@FindBy(xpath="//div[@class=\"hamburger hamburger--slider js-hamburger sidebar_toggle\"]")
	WebElement threehorizantalline;
	@FindBy(xpath="//h6[contains(text(),'Total Stores')]")
	WebElement TotalStores;
	@FindBy(xpath="//h6[contains(text(),'Total Customers')]")
	WebElement TotalCustomers;
	@FindBy(xpath="//h6[contains(text(),'Feedback')]")
	WebElement TotalFeedback;
	@FindBy(xpath="//h6[contains(text(),\"Today's Sales\")]")
	WebElement TodaySales;
	@FindBy(xpath="//h6[contains(text(),\"Last Week's Sales\")]")
	WebElement LastWeekSale;
	@FindBy(xpath="//h6[contains(text(),\"Last Month's Sales\")]")
	WebElement LastMonthSales;
	@FindBy(xpath="//h4[contains(text(),'1')]")
	WebElement TotalStoresCount;
	@FindBy(xpath="//body/div[@id='pcoded']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h4[1]")
	WebElement TotalCustomersCount;
	@FindBy(xpath="")
	WebElement TotalFeebackCount;
	@FindBy(xpath="")
	WebElement TotalSalesCount;
	@FindBy(xpath="")
	WebElement TotallastWeekCount;
	@FindBy(tagName="a")
	List<WebElement> totalLinks;
	
	
	
	
	public void clickOnCross() throws InterruptedException {
		cross.click();
		Thread.sleep(3000);
	}
	public void clickOnThreeHorizantalline() throws InterruptedException {
		
		threehorizantalline.click();
		Thread.sleep(3000);

	}
	public String verifyTitle() {
		return driver.getTitle();
		
	}
	public String totalStores() {
		return TotalStores.getText();
		
	}
	public String totalStoresCount() {
		return TotalStoresCount.getAttribute("value");

	}
	public int totalLinkOnHomePage() {
		int TotalLink= totalLinks.size();
		return TotalLink;
	}
	
	public List<WebElement> geturl() {
		List<WebElement> link= totalLinks;
		return link;
		
	}
	
}
