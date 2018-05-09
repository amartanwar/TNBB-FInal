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

public class UpdatesMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_6")
	private WebElement updateMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_1']/td/div")
	private WebElement receivables;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_1_1']/td/div")
	private WebElement sundryRecurringUpdate;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_6_4_9']/td/div")
	private WebElement salesUseTax;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_6_4_9_1']/td/div")
	private WebElement taxAssessment;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2']/td/div")
	private WebElement invoicing;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2_1']/td/div")
	private WebElement invoiceGroupUpdate;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2_2']/td/div")
	private WebElement invoiceDateUpdate;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_2_3']/td/div")
	private WebElement invoiceGeneration;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_6_4']/td/div")
	private WebElement lease;

	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_6_4_1']/td/div")
	private WebElement movingLongTermToShortTerm;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_6_4_3']/td/div")
	private WebElement incomeRecognition;

	@FindBy(xpath="id('ctl00ctl04WebMenuControl_6_4_6')/td[1]/div[1]")
	private WebElement interimRent;

	@FindBy(xpath=".//*[@id = 'ctl00ctl04WebMenuControl_6_4_6_1']/td/div")
	private WebElement interimRentUpdate;

	@FindBy(xpath="id('ctl00ctl04WebMenuControl_6_4_7')/td[1]/div[1]")
	private WebElement interimInterest;

	@FindBy(xpath="id('ctl00ctl04WebMenuControl_6_4_7_1')/td[1]/div[1]")
	private WebElement interimInterestUpdate;

	
	public UpdatesMenuPage(WebDriver driver,ExtentTest test)
	{
		super(driver,test);

		PageFactory.initElements(driver, this);
	}
	
	public void runLTRtoARUpdate()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 500);
	    wt1.until(ExpectedConditions.elementToBeClickable(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		

		wt1.until(ExpectedConditions.elementToBeClickable(lease));
		action.moveToElement(lease).click().perform();

		
		wt1.until(ExpectedConditions.elementToBeClickable(movingLongTermToShortTerm));
		action.moveToElement(movingLongTermToShortTerm).click().perform();

	}
	
	public void runIncomeRecognitionUpdate()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 15);
	    wt1.until(ExpectedConditions.elementToBeClickable(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		

		wt1.until(ExpectedConditions.elementToBeClickable(lease));
		action.moveToElement(lease).click().perform();

		
		wt1.until(ExpectedConditions.elementToBeClickable(movingLongTermToShortTerm));
		action.moveToElement(movingLongTermToShortTerm).perform();
		
		wt1.until(ExpectedConditions.elementToBeClickable(incomeRecognition));
		action.moveToElement(incomeRecognition).click().perform();
	
	}
	
	public void openInvoiceDateUpdatePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(invoicing));
		action.moveToElement(invoicing).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(invoiceGroupUpdate));
		action.moveToElement(invoiceGroupUpdate).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(invoiceDateUpdate));
		action.moveToElement(invoiceDateUpdate).click().perform();
	}

	public void openInvoiceGroupUpdatePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(invoicing));
		action.moveToElement(invoicing).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(invoiceGroupUpdate));
		action.moveToElement(invoiceGroupUpdate).click().perform();	
	}
	
	public void openSalesTaxUpdatePage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 15);
	    wt1.until(ExpectedConditions.elementToBeClickable(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		

		wt1.until(ExpectedConditions.elementToBeClickable(lease));
		action.moveToElement(lease).click().perform();

		
		wt1.until(ExpectedConditions.elementToBeClickable(movingLongTermToShortTerm));
		action.moveToElement(movingLongTermToShortTerm).perform();

		wt1.until(ExpectedConditions.elementToBeClickable(salesUseTax));
		action.moveToElement(salesUseTax).click().perform();
	

		wt1.until(ExpectedConditions.elementToBeClickable(taxAssessment));
		action.moveToElement(taxAssessment).click().perform();	
	}

	public void openInvoiceGenerationPage()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(invoicing));
		action.moveToElement(invoicing).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(invoiceGroupUpdate));
		action.moveToElement(invoiceGroupUpdate).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(invoiceGeneration));
		action.moveToElement(invoiceGeneration).click().perform();	
	}
	
	public void runinterimRentUpdate() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 15);
	    wt1.until(ExpectedConditions.elementToBeClickable(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		

		wt1.until(ExpectedConditions.elementToBeClickable(lease));
		action.moveToElement(lease).click().perform();

		wt1.until(ExpectedConditions.elementToBeClickable(movingLongTermToShortTerm));
		action.moveToElement(movingLongTermToShortTerm).perform();

		wt1.until(ExpectedConditions.elementToBeClickable(interimRent));
		action.moveToElement(interimRent).click().perform();

		wt1.until(ExpectedConditions.elementToBeClickable(interimRentUpdate));
		action.moveToElement(interimRentUpdate).click().perform();
		
	}

	public void runinterimInterestUpdate() throws InterruptedException
	{
		WebDriverWait wt1= new WebDriverWait(driver, 15);
	    wt1.until(ExpectedConditions.elementToBeClickable(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		

		wt1.until(ExpectedConditions.elementToBeClickable(lease));
		action.moveToElement(lease).click().perform();

		
		wt1.until(ExpectedConditions.elementToBeClickable(movingLongTermToShortTerm));
		action.moveToElement(movingLongTermToShortTerm).perform();

		wt1.until(ExpectedConditions.elementToBeClickable(interimInterest));
		action.moveToElement(interimInterest).click().perform();
	

		wt1.until(ExpectedConditions.elementToBeClickable(interimInterestUpdate));
		action.moveToElement(interimInterestUpdate).click().perform();
		
	}


	
}
