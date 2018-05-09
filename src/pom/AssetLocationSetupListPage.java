package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class AssetLocationSetupListPage extends BasePage {

	public AssetLocationSetupListPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(id = "ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;

	@FindBy(id = "ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement selectButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	public void clickOnAddButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public void clickOnSelectButton(String lcurrentWindow)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
		driver.switchTo().window(lcurrentWindow);
	}
	
	public void clickOnCloseButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}


}
