package pom;

import org.openqa.selenium.By;
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

public class TransactionLeaseAssetPage extends BasePage {

	public TransactionLeaseAssetPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_lnkAllCP")
	private WebElement selectAll;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_AssignmentListControl_fields")
	private WebElement dropDown;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_txtDate_ALBrRrrRrrRr0rRr3_input")
	private WebElement interimInterestStartDate;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_txtDate_ALBrRrrRrrRr0rRr3_input")
	private WebElement interimRentStartDate;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_txtCurrency_ALB15rRrrRrrRr0rRr5")
	private WebElement interimRentAmount;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_AssignmentListControl_entryButtons")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_cmdAssign_cmdButtonControl")
	private WebElement assignButton;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls13")
	private WebElement fmvAmountClick;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls41_input")
	private WebElement interimRentStartDateClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls42")
	private WebElement interimRentFactorClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls43")
	private WebElement interimRentAmountClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls44")
	private WebElement leaseRentFactorClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls43")
	private WebElement leaseRentAmountClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls43")
	private WebElement markUpAmountClick;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls40_input")
	private WebElement interimInterestStartDateClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls71")
	private WebElement interimInterestBasisPercentageClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls13")
	private WebElement customerResidualGuranteeClick;

	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls13")
	private WebElement thirdPartyTotalResidualGuranteeClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls13")
	private WebElement residualValueInsuranceClick;
	
	
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls43")
	private WebElement residualBookedAmountClick;
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls58")
	private WebElement residualBookedPercentageClick;
	
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls58")
	private WebElement residualExpectedPercentageClick;
	
				//igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls43
			//	igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls43
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls43")
	private WebElement residualExpectedAmountClick;

	
	@FindBy(id="ctl00_FC_PH_cmdImport_cmdImportButton")
	private WebElement importButton;
	
	@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdProfilexgrdList_rc_0_64\']/nobr/input")
	private WebElement primaryAsset;
	
	@FindBy(id="ctl00_FT_PH_cmdSaveContinue_cmdButtonControl")
	private WebElement saveAndContinue;
	
	
	
	public void clickSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void clickSaveAndContinueButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(saveAndContinue));
		saveAndContinue.click();
	}
	
	public void clickOnPrimaryAsset()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(primaryAsset));
		primaryAsset.click();
	}
	
	public void addInterimInterestStartDate(String IIdate)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestStartDate));
		interimInterestStartDate.sendKeys(IIdate);
	}
	
	public void addInterimRentStartDate(String IRdate)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestStartDate));
		interimInterestStartDate.sendKeys(IRdate);
	}
	
	public void addInterimRentAmount(String IRamount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimRentAmount));
		interimRentAmount.sendKeys(IRamount);
	}
	
	public void clickselectAllButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(selectAll));
		selectAll.click();
	}
	
	
	public void clicksAddButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	
	public void clicksAssignButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(assignButton));
		assignButton.click();
	}
	
	
	
	public void selectInterimInterestStartDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		Select se = new Select(dropDown);
		se.selectByVisibleText("Interim Interest Start Date");
	}
	
	
	public void selectInterimRentStartDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		Select se = new Select(dropDown);
		se.selectByVisibleText("Interim Rent Start Date");
	}
	
	
	
	public void selectInterimRentAmount()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dropDown));
		Select se = new Select(dropDown);
		se.selectByVisibleText("Interim Rent Amount");
	}

	
	public void enterFMVValue(String fmvValue, String inventoryAlias)
	{
	
		
		WebElement fmvAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[15]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(fmvAmount));
		fmvAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(fmvAmountClick));
		fmvAmountClick.clear();
		fmvAmountClick.sendKeys(fmvValue);
	}

	
	public void enterInterimRentStartDate(String interimRentStartDate, String inventoryAlias)
	{
	
		
		WebElement InterimRentStartDate = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[43]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(InterimRentStartDate));
		InterimRentStartDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(interimRentStartDateClick));
		interimRentStartDateClick.clear();
		interimRentStartDateClick.sendKeys(interimRentStartDate);
	}
	
	
	public void enterInterimRentFactor(String interimRentFactor, String inventoryAlias)
	{
	
		
		WebElement InterimRentFactor = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[44]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(InterimRentFactor));
		InterimRentFactor.click();
		wait.until(ExpectedConditions.elementToBeClickable(interimRentFactorClick));
		interimRentFactorClick.clear();
		interimRentFactorClick.sendKeys(interimRentFactor);
	}
	
	
	public void enterInterimRentAmount(String interimRentAmount, String inventoryAlias)
	{
	
			
		WebElement InterimRentAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[45]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(InterimRentAmount));
		InterimRentAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(interimRentAmountClick));
		interimRentAmountClick.clear();
		interimRentAmountClick.sendKeys(interimRentAmount);
	}
	
	
	public void enterLeaseRentFactor(String leaseRentFactor, String inventoryAlias)
	{
	
			
		WebElement LeaseRentFactor = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[46]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(LeaseRentFactor));
		LeaseRentFactor.click();
		wait.until(ExpectedConditions.elementToBeClickable(leaseRentFactorClick));
		leaseRentFactorClick.clear();
		leaseRentFactorClick.sendKeys(leaseRentFactor);
	}
	
	public void enterLeaseRentAmount(String leaseRentAmount, String inventoryAlias)
	{
	
			
		WebElement LeaseRentAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[47]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(LeaseRentAmount));
		LeaseRentAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(leaseRentAmountClick));
		leaseRentAmountClick.clear();
		leaseRentAmountClick.sendKeys(leaseRentAmount);
	}
	
	public void enterMarkUpAmount(String markUpAmount, String inventoryAlias)
	{
	
		
		WebElement MarkUpAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[66]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(MarkUpAmount));
		MarkUpAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(markUpAmountClick));
		markUpAmountClick.clear();
		markUpAmountClick.sendKeys(markUpAmount);
	}
	
	public void enterInterimInterestStartDate(String interimInterestStartDate, String inventoryAlias)
	{
	
		
		WebElement InterimInterestStartDate = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[72]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(InterimInterestStartDate));
		InterimInterestStartDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestStartDateClick));
		interimInterestStartDateClick.clear();
		interimInterestStartDateClick.sendKeys(interimInterestStartDate);
	}
	
	
	public void enterInterimInterestBasisPercentage(String interimInterestBasisPercentage, String inventoryAlias)
	{
	
		
		WebElement InterimInterestBasisPercentage = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[73]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(InterimInterestBasisPercentage));
		InterimInterestBasisPercentage.click();
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestBasisPercentageClick));
		interimInterestBasisPercentageClick.clear();
		interimInterestBasisPercentageClick.sendKeys(interimInterestBasisPercentage);
	}
	
	public void enterCustomerResidualGurantee(String customerResidualGurantee, String inventoryAlias)
	{
	
		
		WebElement CustomerResidualGurantee = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[75]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(CustomerResidualGurantee));
		CustomerResidualGurantee.click();
		wait.until(ExpectedConditions.elementToBeClickable(customerResidualGuranteeClick));
		customerResidualGuranteeClick.clear();
		customerResidualGuranteeClick.sendKeys(customerResidualGurantee);
	}
	
	
	
	public void enterThirdPartyTotalResidualGurantee(String thirdPartyTotalResidualGurantee, String inventoryAlias)
	{
	
			
		WebElement ThirdPartyTotalResidualGurantee = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[76]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ThirdPartyTotalResidualGurantee));
		ThirdPartyTotalResidualGurantee.click();
		wait.until(ExpectedConditions.elementToBeClickable(thirdPartyTotalResidualGuranteeClick));
		thirdPartyTotalResidualGuranteeClick.clear();
		thirdPartyTotalResidualGuranteeClick.sendKeys(thirdPartyTotalResidualGurantee);
	}
	
	
	
	
	public void enterResidualValueInsurance(String residualValueInsurance, String inventoryAlias)
	{
	
			
		WebElement ResidualValueInsurance = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[77]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ResidualValueInsurance));
		ResidualValueInsurance.click();
		wait.until(ExpectedConditions.elementToBeClickable(residualValueInsuranceClick));
		residualValueInsuranceClick.clear();
		residualValueInsuranceClick.sendKeys(residualValueInsurance);
	}
	
	
	public void enterResidualBookedAmount(String residualBookedAMount, String inventoryAlias)
	{
	
		
		WebElement ResidualBookedAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[59]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ResidualBookedAmount));
		ResidualBookedAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(residualBookedAmountClick));
		residualBookedAmountClick.clear();
		residualBookedAmountClick.sendKeys(residualBookedAMount);
	}
	
	
	
	public void enterResidualBookedpercentage(String residualBookedPercentage, String inventoryAlias)
	{
	
		
		WebElement ResidualBookedAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[60]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ResidualBookedAmount));
		ResidualBookedAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(residualBookedPercentageClick));
		residualBookedPercentageClick.clear();
		residualBookedPercentageClick.sendKeys(residualBookedPercentage);
	}
	
	
	
	public void enterResidualExpectedpercentage(String residualExpectedPercentage, String inventoryAlias)
	{
	
		
		WebElement ResidualExpectedAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[61]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ResidualExpectedAmount));
		ResidualExpectedAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(residualExpectedPercentageClick));
		residualExpectedPercentageClick.clear();
		residualExpectedPercentageClick.sendKeys(residualExpectedPercentage);
	}
	
	
	
	public void enterResidualExpectedAmount(String residualExpectedAMount, String inventoryAlias)
	{
	
		
		WebElement ResidualExpectedAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[62]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ResidualExpectedAmount));
		ResidualExpectedAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(residualExpectedAmountClick));
		residualExpectedAmountClick.clear();
		residualExpectedAmountClick.sendKeys(residualExpectedAMount);
	}
	
	public String clickOnImportButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(importButton));
		String leaseTransactionAssetsWindow = driver.getWindowHandle();
		importButton.click();
		SwitchControlToNextWindow switchcontroltonextwindow = new SwitchControlToNextWindow();
		switchcontroltonextwindow.waitForWndows(driver, leaseTransactionAssetsWindow);
		return leaseTransactionAssetsWindow;
	}

	
}
