package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ContactAddressListPage extends BasePage {

	public ContactAddressListPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement selectButton;
	
	
	//No need to switch window, because this page will be closed upon click of ADD button
	public void clickOnAddButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	
	public void clickOnSelectButton(String contactpersonsetupWindow)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		driver.switchTo().window(contactpersonsetupWindow);
	}
	
	
}
