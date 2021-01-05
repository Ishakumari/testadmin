package test1adminpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tes1adminbase.TestBase;

public class MasterCategorypage extends TestBase{
	public MasterCategorypage() {
		PageFactory.initElements(driver, this);}

	@FindBy(xpath="//span[contains(text(),'Item Master')]")
	WebElement itemMaster;

	//Master Category
	@FindBy(xpath="//span[contains(text(),'Master Categories')]")
	WebElement mastercategory;
	@FindBy(partialLinkText="Add Master Categori")
	WebElement addMasterCategory;
	@FindBy(xpath="//*[@id=\"FormMasterCategory\"]/div[2]/div/select")
	WebElement mastercategoryType;
	@FindBy(xpath="//input[@type=\"text\"]")
	WebElement masterCategoryName;
	@FindBy(xpath="//input[@class=\"form-control int\"]")
	WebElement sequenceNo;
	@FindBy(xpath="//button[@type='submit' and @class='btn btn-primary sData']")
	WebElement Savebtn;
	@FindBy(xpath="//button[@class='confirm']")
	WebElement Okbtn;
	@FindBy(xpath="//h4[contains(text(),'Master Categories')]")
	WebElement textMasterCategories;
	@FindBy(xpath="//a[contains(text(),' Master Categories List ')]")
	WebElement MasterCategoriesList;
	@FindBy(xpath="//thead/tr[1]/th")
	List<WebElement> ColumnNoOfTableHeader;
	@FindBy(xpath="//*[@id='e-product-list']/tbody/tr/td[1]")
	List<WebElement> RowCount;

	public void clickonitemMaster() {
		itemMaster.click();
	}
	public void clickonMasterCategory() {
		mastercategory.click();
	}
	public void clickonAddMasterCategory() throws InterruptedException {
		boolean addMasterCategoryDisplayed=addMasterCategory.isDisplayed();
		if(addMasterCategoryDisplayed==true) {
			System.out.println("Add Master Category is displaying");
		}
		boolean addMasterCategoryClickable=addMasterCategory.isEnabled();
		if(addMasterCategoryClickable==true) {
			System.out.println("Add Master Category is enabled");
		}
		addMasterCategory.click();	
		Thread.sleep(3000);
	}

	public void addMasterCategory(String name, String i) throws InterruptedException {
		//Actions actions=new Actions(driver);
		//actions.moveToElement(itemMaster);
		//Thread.sleep(4000);	
		//actions.moveToElement(mastercategory);
		//Thread.sleep(4000);	

		//actions.moveToElement(addMasterCategory);

		//actions.click().build().perform();
		//Thread.sleep(3000);	
		Select select=new Select(mastercategoryType);
		select.selectByVisibleText("A La Carte");
		masterCategoryName.sendKeys(name);
		sequenceNo.sendKeys(i);
		Savebtn.click();
		Thread.sleep(2000);	
		Okbtn.click();
		Thread.sleep(2000);
		List<WebElement> masterCategoryName=driver.findElements(By.xpath("//*[@id=\"e-product-list\"]/tbody/tr/td[1]"));
		int masterCategoryNameSize= masterCategoryName.size();
		for(int i1=1; i1<=masterCategoryNameSize; i1++) {
			String masterCategoryNameText= masterCategoryName.get(i1).getText();
			System.out.println(masterCategoryNameText);
			if(masterCategoryNameText.equalsIgnoreCase("Furniture")) {
	        	   System.out.println("created Master Category is available in the list"+ masterCategoryNameText );}
	        	   else{
		        	   System.out.println("Master Category has not been created"+ masterCategoryNameText );

	        		   
	        	   }
	           }}
		
	
	
	
	public String headerofMasterCategoriesmodule() {
		return textMasterCategories.getText();
	}

	public String mastercategorieslist() {
           MasterCategoriesList.getSize();
           //MasterCategoriesList.getCssValue(font-family)
		return null;
		
	}
	
	}
