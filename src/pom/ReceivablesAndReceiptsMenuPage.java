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

public class ReceivablesAndReceiptsMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_5")
	private WebElement receivablesAndReceiptsMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_9']/td/div")
	private WebElement postReceiptsMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_9_1']/td/div")
	private WebElement cashSubMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_11']/td/div")
	private WebElement receiptBatchManagement;
	

	
	public ReceivablesAndReceiptsMenuPage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void openRPostReceiptCash()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(receivablesAndReceiptsMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(receivablesAndReceiptsMenu).perform();

		wt1.until(ExpectedConditions.elementToBeClickable(postReceiptsMenu));
		action.moveToElement(postReceiptsMenu).click().perform();
		
		wt1.until(ExpectedConditions.elementToBeClickable(cashSubMenu));
		action.moveToElement(cashSubMenu).click().perform();
	
	}

	public void openReceiptBatchManagement()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(receivablesAndReceiptsMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(receivablesAndReceiptsMenu).perform();

		wt1.until(ExpectedConditions.elementToBeClickable(receiptBatchManagement));
		action.moveToElement(receiptBatchManagement).click().perform();

	
	}
	

}
