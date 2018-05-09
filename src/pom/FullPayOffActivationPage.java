package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class FullPayOffActivationPage extends BasePage{
	
	public FullPayOffActivationPage(WebDriver driver,ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_FC_PH_cboGLTemplate_cboGLTransaction")
	private WebElement glTemplate;
	
	
	@FindBy(id="ctl00_FT_PH_cmdActivate_cmdButtonControl")
	private WebElement activateButton;
	
	public void clickOnActivateButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(activateButton));
		activateButton.click();
		
	}
	
	public void selectGLTemplate(String template)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(glTemplate));
		Select se = new Select(glTemplate);
		//e.selectByVisibleText(template);
		se.selectByIndex(1);
		
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
