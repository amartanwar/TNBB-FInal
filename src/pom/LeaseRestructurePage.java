package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseRestructurePage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_cboGLTemplateID_cboGLTransaction")
	private WebElement glTempalte;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="igtxtctl00_FC_PH_txtLeaseAssetsNBVImpairment_txtWebCurrencyEdit")
	private WebElement nbvImpairment;
	
	
	

	public LeaseRestructurePage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void selectGLTemplate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(glTempalte));
		
		Select sc= new Select(glTempalte);
		sc.selectByIndex(1);
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	public void enterNBVImpairmentValue(String amount)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(nbvImpairment));
		nbvImpairment.clear();
		nbvImpairment.sendKeys(amount);
	}
	
	
	
	
	
	
}
