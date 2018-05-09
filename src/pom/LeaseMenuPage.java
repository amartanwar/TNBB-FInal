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

public class LeaseMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_2")
	private WebElement leaseMenu;

	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_1\']/td/div")
	private WebElement newLease;

	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_5\']/td/div")
	private WebElement rebook;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_6\']/td/div")
	private WebElement modifications;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_6_1\']/td/div")
	private WebElement restructure;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_6_3\']/td/div")
	private WebElement residualImpairment;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_6_2\']/td/div")
	private WebElement nbvImpairment;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_6_4\']/td/div")
	private WebElement salvageValue;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_25\']/td/div")
	private WebElement assumption;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_25_1\']/td/div")
	private WebElement newassumption;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_20\']/td/div")
	private WebElement accrualScreen;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_21\']/td/div")
	private WebElement nonAccrualScreen;
	
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_8\']/td/div")
	private WebElement payOff;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_8_1\']/td/div")
	private WebElement quote;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_8_2\']/td/div")
	private WebElement invoice;
	
	@FindBy(xpath="//*[@id=\'ctl00ctl04WebMenuControl_2_8_3\']/td/div")
	private WebElement activate;
	
	
	
	
	
	public LeaseMenuPage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void clickOnLeaseMenu()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
		leaseMenu.click();
	}
	
	public void clickOnNewLease()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(newLease));
		newLease.click();
	}
	
	public void openLeaseRebookPage() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	    
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).perform();
		Thread.sleep(2000);
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.elementToBeClickable(rebook));
		action.moveToElement(rebook).click().perform();
	}
	
	public void openLeaseRestructurePage() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(modifications));
		action.moveToElement(modifications).click().perform();
		
		 wt1.until(ExpectedConditions.elementToBeClickable(restructure));
		 action.moveToElement(restructure).click().perform();
	}
	
	public void openResidualImpairmentPage() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(modifications));
		action.moveToElement(modifications).click().perform();
		
		 wt1.until(ExpectedConditions.elementToBeClickable(residualImpairment));
		 action.moveToElement(residualImpairment).click().perform();
	}
	
	
	public void openNBVImpairmentPage() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(modifications));
		action.moveToElement(modifications).click().perform();
		
		 wt1.until(ExpectedConditions.elementToBeClickable(nbvImpairment));
		 action.moveToElement(nbvImpairment).click().perform();
	}
	
	public void openSalvageValueImpairment() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(modifications));
		action.moveToElement(modifications).click().perform();
		
		 wt1.until(ExpectedConditions.elementToBeClickable(salvageValue));
		 action.moveToElement(salvageValue).click().perform();
	}
	
	public void openPayOffQuote() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(payOff));
		action.moveToElement(payOff).click().perform();
		
		 wt1.until(ExpectedConditions.elementToBeClickable(quote));
		 action.moveToElement(quote).click().perform();
	}
	
	public void openPayoffInvoice() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(payOff));
		action.moveToElement(payOff).click().perform();
		
		wt1.until(ExpectedConditions.elementToBeClickable(quote));
		action.moveToElement(quote).perform();
		
		 wt1.until(ExpectedConditions.elementToBeClickable(invoice));
		 action.moveToElement(invoice).click().perform();
	}
	
	
	public void openPayoffActivate() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(payOff));
		action.moveToElement(payOff).click().perform();
		
		wt1.until(ExpectedConditions.elementToBeClickable(quote));
		action.moveToElement(quote).perform();
		
		 wt1.until(ExpectedConditions.elementToBeClickable(activate));
		 action.moveToElement(activate).click().perform();
	}
	
	public void opennewAsseumption() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(assumption));
		action.moveToElement(assumption).click().perform();
		
		wt1.until(ExpectedConditions.elementToBeClickable(newassumption));
		action.moveToElement(newassumption).click().perform();

	}
	
	public void openAccrualScreen() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(accrualScreen));
		action.moveToElement(accrualScreen).click().perform();

	}
	
	public void openNonAccrualScreen() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(leaseMenu));
	 
	    Actions action= new Actions(driver);
		action.moveToElement(leaseMenu).click().perform();

	    wt1.until(ExpectedConditions.elementToBeClickable(nonAccrualScreen));
		action.moveToElement(nonAccrualScreen).click().perform();

	}


	
}
