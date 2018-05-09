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
import generic.SwitchControlToNextWindow;

public class AssetLocationSetupPage extends BasePage {

	public AssetLocationSetupPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(id = "ctl00_FC_PH_cboEntityTypeID")
	private WebElement entityType;
	
	@FindBy(id = "ctl00_FC_PH_txtEntityID")
	private WebElement entityUniqueID;
	
	@FindBy(id = "ctl00_FC_PH_txtLocationCode")
	private WebElement locationCode;
	
	@FindBy(id = "ctl00_FC_PH_UCAddressDetails_txtAddress")
	private WebElement address;
	
	@FindBy(id = "ctl00_FC_PH_UCAddressDetails_txtCity")
	private WebElement city;
	
	@FindBy(id = "ctl00_FC_PH_UCAddressDetails_cboStateLongName")
	private WebElement state;
	
	@FindBy(id = "igtxtctl00_FC_PH_UCAddressDetails_txtZIP")
	private WebElement postalCode;
	
	@FindBy(id = "ctl00_FC_PH_UCAddressDetails_txtCounty")
	private WebElement county;
	
	@FindBy(id = "ctl00_FC_PH_UCAddressDetails_cboCountryName")
	private WebElement country;
	
	@FindBy(id = "ctl00_FC_PH_chkIsDefault")
	private WebElement isDefault;
	
	@FindBy(id = "ctl00_FC_PH_cmdImportArea_cmdImportButton")
	private WebElement taxAreaIDImportButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id = "ctl00_FC_PH_txtTaxEffectiveDate_input")
	private WebElement taxAreadLocationEffectiveDate;
	
	
	
	public void selectEntityType(String entitytype)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(entityType));
		Select se = new Select(entityType);
		se.selectByVisibleText(entitytype);
	}
	
	public void selectSatate(String State)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(state));
		Select se = new Select(state);
		se.selectByVisibleText(State);
	}
	
	public void enterEntityUniqueID(String entityuniqueID)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(entityUniqueID));
		entityUniqueID.clear();
		entityUniqueID.sendKeys(entityuniqueID);
	}
	
	
	public void enterTaxAreaLocationEffectiveDate(String date)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(taxAreadLocationEffectiveDate));
		taxAreadLocationEffectiveDate.clear();
		taxAreadLocationEffectiveDate.sendKeys(date);
	}
	
	
	public void enterLocationCode(String locationcode)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(locationCode));
		locationCode.clear();
		locationCode.sendKeys(locationcode);
	}
	
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
	
	
	public void enterPostalCode(String postalcode)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(postalCode));
		postalCode.clear();
		postalCode.sendKeys(postalcode);
	}
	
	public void enterCounty(String County)
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(postalCode));
		county.clear();
		county.sendKeys(County);
	}
	
	public String clickOnTaxAreaIDImportButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(taxAreaIDImportButton));
		String assetlocationsetupwindow = driver.getWindowHandle();
		taxAreaIDImportButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		sc.waitForWndows(driver, assetlocationsetupwindow); //Control is being changed to new window
		return assetlocationsetupwindow;
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void clickOnDefaultButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(isDefault));
		isDefault.click();
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
