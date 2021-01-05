package test1adminpages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tes1adminbase.TestBase;

public class Itemmastermodule extends TestBase{
	public Itemmastermodule() {
		PageFactory.initElements(driver, this);}

	@FindBy(xpath="//span[contains(text(),'Item Master')]")
	WebElement itemMaster;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement Save;

	//Category
	@FindBy(xpath="//body/div[@id='pcoded']/div[2]/nav[1]/div[1]/nav[1]/div[3]/div[1]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]")
	WebElement category;
	@FindBy(xpath="//*[contains(text(),'Add Category')]")
	WebElement addcategory;
	@FindBy(xpath="//select[@name=\"Parent_CategoryID\"]")
	WebElement MasterCategory;
	@FindBy(xpath="//input[@name=\"FoodCategory\"]")
	WebElement SubCategoryName;

	//Add Menu Item
	@FindBy(xpath="//span[contains(text(),'Menu Items')]")
	WebElement MenuItems;
	@FindBy(xpath="//a[contains(text(),'Add Item')]")
	WebElement AddItem;
	@FindBy(xpath="//input[@name=\"IsKitchenItem\"]")
	WebElement ItemType;
	@FindBy(xpath="//input[@name=\"ItemName\"]")
	WebElement ItemName;
	@FindBy(xpath="//select[@name=\"Parent_CategoryID\"]")
	WebElement SelectParentCategory;
	@FindBy(xpath="//select[@name=\"CategoryID\"]")
	WebElement SelectCategory;
	@FindBy(xpath="//textarea[@name=\"Description\"]")
	WebElement ItemDescription;
	@FindBy(xpath="//input[@name=\"Inventory_Quantity\"]")
	WebElement Inventory;
	@FindBy(xpath="//input[@name=\"SKU\"]")
	WebElement SKU;
	@FindBy(xpath="//input[@name=\"Price\"]")
	WebElement Price;
	@FindBy(xpath="//h3[@class=\"accordion-heading\"]")
	WebElement Advance;
	@FindBy(xpath="")
	WebElement StartDate;
	@FindBy(xpath="")
	WebElement ExpiryDate;
	@FindBy(xpath="")
	WebElement ItemPrinter;
	@FindBy(xpath="//input[@class=\"float form-control\"]")
	WebElement Delivery;
	@FindBy(xpath="//button[@class=\"btn btn-primary sData save-btn-k\"]")
	WebElement SaveItems;

	public void clickonItemMaster() {
		itemMaster.click();}
	
	public void clickoncategory() throws InterruptedException {
category.click();
Thread.sleep(2000);}
	
	public void clickonaddcategory() {
		addcategory.click();
		}

    public void addCategory(String MasterCategoryValue, String name) throws InterruptedException {
	//Actions actions=new Actions(driver);
	//actions.moveToElement(itemMaster).click().build().perform();
	//Thread.sleep(1000);
	//actions.moveToElement(category).click().build().perform();
	//Thread.sleep(1000);
	//actions.moveToElement(addcategory).click().build().perform();

	Select select=new Select(MasterCategory);
	Thread.sleep(1000);
	select.selectByVisibleText(MasterCategoryValue);
	Thread.sleep(2000);
	SubCategoryName.sendKeys(name);
	Thread.sleep(2000);
   Save.click();

     Thread.sleep(2000);}
    
    public void clickonMenuItems() {
    	MenuItems.click();}
    
    public void clickonAddItem() {
    	AddItem.click();}

public void addItem( String name, String PCvalue, String CValue, String price, String Damount) throws InterruptedException {
	//Actions actions=new Actions(driver);
	//actions.moveToElement(itemMaster).click().build().perform();
	//Thread.sleep(3000);
	//actions.moveToElement(MenuItems).click().build().perform();
	//Thread.sleep(2000);
	//actions.moveToElement(AddItem).click().build().perform();
	//Thread.sleep(2000);
	ItemName.sendKeys(name);
	Thread.sleep(2000);
	Price.sendKeys(price);
	Select select=new Select(SelectParentCategory);
	Thread.sleep(1000);
	select.selectByVisibleText(PCvalue);
	Select select1=new Select(SelectCategory);
	select1.selectByVisibleText(CValue);
	Delivery.sendKeys(Damount);
	Thread.sleep(2000);
	//SaveItems.click();
	//Thread.sleep(6000);

}








}
