package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class RestructureDetailsPage extends BasePage
{
	@FindBy(id="ctl00_FT_PH_cmdSelect_cmdButtonControl")
	private WebElement selectButton;
	
	
	public RestructureDetailsPage(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void clickOnSelectButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
	}
	
	public void selectPaymentNumber(String paymentnumber)
	{
		int effectivepaymentnumber = (Integer.parseInt(paymentnumber))-1;
						
		//String id = "ctl00xFCxPHxgrdRestructureDetailsxgrdList_1_"+effectivepaymentnumber+"";
		String id = "ctl00xFCxPHxgrdRestructureDetailsxgrdList_rc_"+effectivepaymentnumber+"_2";
		 Actions action= new Actions(driver);
		WebElement element = driver.findElement(By.id(id));
		action.moveToElement(element).click().perform();
		//element.click();
	}
	
	
	public void handleAlert()
	{
		
			try
			{
				
				WebDriverWait wt=new WebDriverWait(driver, 1);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		
	}
}


