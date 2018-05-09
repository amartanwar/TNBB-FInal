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

public class ContactAddressSetupPage extends BasePage {

	public ContactAddressSetupPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "ctl00_FC_PH_ContactAddressUC1_txtAddress")
	private WebElement address;
	
	@FindBy(id = "ctl00_FC_PH_ContactAddressUC1_txtCity")
	private WebElement city;
				
	@FindBy(id = "igtxtctl00_FC_PH_ContactAddressUC1_txtZIP")
	private WebElement postalCode;	
	
	@FindBy(id = "ctl00_FC_PH_ContactAddressUC1_cboStateLongName")
	private WebElement state;
	
	@FindBy(id = "ctl00_FC_PH_ContactAddressUC1_txtCounty")
	private WebElement county;
	
	@FindBy(id = "ctl00_FC_PH_ContactAddressUC1_cboCountryName")
	private WebElement country;
	
	@FindBy(id = "ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement saveAndSelect;
	
	
	
	public void enterAddress(String Address)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(address));
		address.clear();
		address.sendKeys(Address);
	}
	
	public void enterCity(String City)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(city));
		city.clear();
		city.sendKeys(City);
	}
	
	public void enterCounty(String County)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(county));
		county.clear();
		county.sendKeys(County);
	}
	
	public void enterState(String State)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(state));
		Select se = new Select(state);
		se.selectByVisibleText(State);
	}
	
	
	public void enterPostalCode(String postalcode)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(postalCode));
		postalCode.clear();
		postalCode.sendKeys(postalcode);
	}
	
	public void selectCountry(String Country)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(country));
		Select se = new Select(country);
		se.selectByVisibleText(Country);
	}
	
	public void clickOnSaveAndSelectButton(String contactaddresslistwindow)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(saveAndSelect));
		saveAndSelect.click();
		driver.switchTo().window(contactaddresslistwindow);
	}
	

}
