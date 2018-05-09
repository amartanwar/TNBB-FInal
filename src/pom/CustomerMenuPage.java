package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class CustomerMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_1")
	private WebElement customerMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_1_1']/td/div")
	private WebElement profile;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_1_5']/td/div")
	private WebElement collectionGroup;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_1_5_1']/td/div")
	private WebElement collectionGroupSetup;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_1_4']/td/div")
	private WebElement invoiceGroup;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_1_4_1']/td/div")
	private WebElement invoiceGroupSetup;
	
	
	public CustomerMenuPage( WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void openCustomerProfile()
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(customerMenu));
		Actions ac=new Actions(driver);
		ac.moveToElement(customerMenu).click().perform();
		
		WebDriverWait wt1= new WebDriverWait(driver, 500);
		wt1.until(ExpectedConditions.elementToBeClickable(profile));
		ac.moveToElement(profile).click().perform();
	}
	
	public void openCollectionGroupSetup()
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(customerMenu));
		Actions ac=new Actions(driver);
		ac.moveToElement(customerMenu).perform();
		
		WebDriverWait wt1= new WebDriverWait(driver, 500);
		wt1.until(ExpectedConditions.elementToBeClickable(collectionGroup));
		ac.moveToElement(collectionGroup).click().perform();
		ac.moveToElement(collectionGroupSetup).click().perform();
	}
	
	public void openInvoiceGroupSetup()
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(customerMenu));
		Actions ac=new Actions(driver);
		ac.moveToElement(customerMenu).perform();
		
		WebDriverWait wt1= new WebDriverWait(driver, 500);
		wt1.until(ExpectedConditions.elementToBeClickable(invoiceGroup));
		ac.moveToElement(invoiceGroup).click().perform();
		ac.moveToElement(invoiceGroupSetup).click().perform();
	}

	
}
