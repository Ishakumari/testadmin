package test1adminpages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tes1adminbase.TestBase;

public class Tools extends TestBase{
	public Tools() {
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//span[contains(text(),'Tools')]")
	WebElement tools;
	@FindBy(xpath="//button[@class='confirm']")
	WebElement Okbtn;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Save;


	@FindBy(xpath="//*[@id=\"mCSB_1_container\"]/ul/li[5]/ul/li[1]/a/span")
	WebElement TableInfo;
	@FindBy(xpath="//input[@type='text']")
	WebElement TableCode;
	@FindBy(xpath="//input[@name='SeatCapacity']")
	WebElement SeatingCapacity;
//	@FindBy(xpath="//*[@id='e-product-list']/tbody/tr")
//	List<WebElement> rowCount;


	//Order Type
	@FindBy(xpath="//*[@id=\"mCSB_1_container\"]/ul/li[5]/ul/li[2]/a/span")
	WebElement OrderType;
	//@FindBy(xpath="//li[@class='nav-item'][2]/child::a")
	//	@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div[1]/ul/li[2]/a")
	//	WebElement AddOrderType;
	@FindBy(xpath="//ul[@class='nav nav-tabs md-tabs']/child::li[1]")
	WebElement OrderTypeList;
	@FindBy(xpath="//input[@type='text' and @name='OrderType']")
	WebElement orderType;
	@FindBy(xpath="//button[@type='submit']")
	WebElement OrderTypeSavebtn;
	//Feedback Report
	@FindBy(xpath= " ")
	WebElement FeedbackReport;

	//Payment Type
	@FindBy(xpath="//*[@id=\"mCSB_1_container\"]/ul/li[5]/ul/li[3]/a/span")
	WebElement PaymentType;
	@FindBy(xpath="//*[@id=\"pcoded\"]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/ul/li[2]/a")

	WebElement PaymentMode;
	@FindBy(xpath="//input[@name=\"Name\"]")
	WebElement AdditionalName;
	@FindBy(xpath="//input[@name='Percentage']")
	WebElement Percentage;
	//discount
	@FindBy(xpath="//*[@id=\"mCSB_1_container\"]/ul/li[5]/ul/li[5]/a/span")
	WebElement Discount;

	@FindBy(xpath="//input[@name='Discount_Name']")
	WebElement DiscountName;
	@FindBy(xpath="//select[@name='Discount_Type']")
	WebElement DiscountType;
	@FindBy(xpath="//input[@name=\"Percentage\"]")
	WebElement DiscountPercentage;
	@FindBy(xpath="//input[@name=\"Fixed_Amount\"]")
	WebElement FixedAmount;
	@FindBy(xpath="//input[@name=\"Discount_value\"]")
	WebElement DiscountValue;
	@FindBy(xpath="//input[@name=\"Minimum_Amount\"]")
	WebElement MinimumAmount;
	@FindBy(xpath="//input[@name='Start_Date']")
	WebElement StartDate;
	@FindBy(xpath="//input[@name='End_Date']")
	WebElement EndDate;
	@FindBy(xpath="//button[@title='Master Category']/child::span[@class='multiselect-selected-text']")
	WebElement MasterCategory;
	@FindBy(xpath="//button[@title=\"Sub Category\"]/child::span[@class=\"multiselect-selected-text\"]")
	WebElement Category;
	@FindBy(xpath="//button[@title=\"Item\"]/child::span[@class=\"multiselect-selected-text\"]")
	WebElement Item;
	//Delivery Setup
	@FindBy(xpath="//*[@id=\"mCSB_1_container\"]/ul/li[5]/ul/li[6]/a/span")
	WebElement DeliverySetup;

	@FindBy(xpath="//*[@name=\"ZipCode\"]")
	WebElement Zipcode;
	@FindBy(xpath="//*[@name=\"DeliveryCharge\"]")
	WebElement DeliveryCharge;
	//PaymentGateway
	@FindBy(xpath="//*[@id=\"mCSB_1_container\"]/ul/li[5]/ul/li[7]/a/span")
	WebElement PaymentGateway;

	@FindBy(xpath="//*[@class=\"col-sm-12 form-control required checkExist \"]")
	WebElement POSId;
	@FindBy(xpath="//*[@class=\"col-sm-12 form-control gateway required\"]")
	WebElement paymentGateway;
//	@FindBy(xpath="//table[@id='e-product-list']/thead/tr/th")
//	List<WebElement> Table;

	public void clickOnTools() {
		tools.click();
	}
	public void clickonTableInfo() {
		TableInfo.click();
	}
	public void clickOnAddNewTable() throws InterruptedException {
		//		WebDriverWait wait = new WebDriverWait(driver, 10);
		//		wait.until(ExpectedConditions.visibilityOf(AddNewTable)); 
		//		wait.until(ExpectedConditions.elementToBeClickable(AddNewTable));
		//		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		//	javascript.executeScript("var element = document.querySelector('AddNewTable'); element.value = 'Add New Table';");
		//	Actions actions=new Actions(driver);
		//		actions.moveToElement(AddNewTable).click().build().perform()();
		driver.findElement(By.partialLinkText("Add New Tab")).click();
		Thread.sleep(3000);

	}

	public void addTable(String Tc, String Sc) throws InterruptedException {
		
		TableCode.sendKeys(Tc);
		SeatingCapacity.sendKeys(Sc);
		Save.click();
		Okbtn.click();
		Thread.sleep(6000);}
		
		public int  RowCount(){
			List<WebElement> tableNo=driver.findElements(By.xpath("//*[@id='e-product-list']/tbody/tr/td[1]"));
			int tableno= tableNo.size();
			return tableno;

		}
		public String getTextofTableNoColumn() {
		List<WebElement> tableNo=driver.findElements(By.xpath("//*[@id='e-product-list']/tbody/tr/td[1]"));
		int i = 0;
		String Table_No= tableNo.get(i).getText();
		return Table_No;
		}
		
	



	//String beforexpathTableNo="//*[@id=\"e-product-list\"]/thead/tr[";
	//String afterxpathTableNo="]/th[1]";
	//String actualxpath=beforexpathTableNo+i+afterxpathTableNo;



	public void clickOnOrderType() {
		OrderType.click();
	}
	public void clickOnAddOrderType() {
		WebElement AddOrderType=driver.findElement(By.xpath("//a[contains(text(),'Add')]"));

		AddOrderType.click();
	}

	public void addOrderType(String name) throws InterruptedException {
		orderType.sendKeys(name);
		Save.click(); 
		Thread.sleep(2000);
		Okbtn.click();
		Thread.sleep(2000);
	}
	public void clickOnPaymentType() {
		PaymentType.click();
	}
	public void clickOnAddPaymentType() {
		driver.findElement(By.partialLinkText("Add Payment Ty")).click();

	}

	public void addPaymentType( String name, String Per) throws InterruptedException {
		//		Actions actions1=new Actions(driver);
		//		actions1.moveToElement(tools).click().build().perform();
		//		Thread.sleep(3000);
		//		actions1.moveToElement(PaymentType).click().build().perform();
		//		Thread.sleep(3000);
		//		actions1.moveToElement(AddPaymentType).click().build().perform();
		//		Thread.sleep(3000);
		PaymentMode.sendKeys(name);
		Percentage.sendKeys(Per);
		Save.click(); 
		Okbtn.click();
		Thread.sleep(2000);

	}
	public void clickOnDiscount() {
		Discount.click();
	}
	public void clickOnCreateDiscount() {
		WebElement CreateDiscount=driver.findElement(By.xpath("//a[contains(text(),'Create Discount')]"));

		CreateDiscount.click();
	}

	public void addDiscount(String name, String value) throws InterruptedException {
		DiscountName.sendKeys(name);
		Select select=new Select(DiscountType);
		select.selectByVisibleText(value);
		Save.click(); 
		Okbtn.click();
		Thread.sleep(2000);

	}
	public void clickOnDeliverySetup() {
		DeliverySetup.click();
	}
	public void clickOnAddZipCode() {
		WebElement AddZipCode=driver.findElement(By.xpath("//a[contains(text(),'Add Zip Code')]"));

		AddZipCode.click();
	}

	public void addDeliverySetup(String ZC, String DC) throws InterruptedException {

		Zipcode.sendKeys(ZC);
		DeliveryCharge.sendKeys(DC);
		Save.click(); 
		Okbtn.click();
		Thread.sleep(2000);}
	public void clickOnPaymentGateway() {
		PaymentGateway.click();
	}
	public void clickOnAddPaymentGateway() {
		WebElement AddPaymentGateway=driver.findElement(By.xpath("//a[contains(text(),'Add Payment Gateway')]"));
		AddPaymentGateway.click();
	}

	public void addPaymentGateaway(String value1, String value2) throws InterruptedException {
		Select select=new Select(POSId);
		select.selectByVisibleText(value1);
		select.selectByVisibleText(value2);
		Save.click(); 
		Okbtn.click();
		Thread.sleep(2000);

	}
}

















