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

public class CustomerProfilePage extends BasePage {

	public CustomerProfilePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(id = "ctl00_FC_PH_txtAccountNumber")
	private WebElement accountNumber;
	
	@FindBy(id = "ctl00_FC_PH_txtCompanyName")
	private WebElement companyName;
	
	@FindBy(id = "ctl00_FC_PH_chkIndividual")
	private WebElement isIndividual;	
	
	@FindBy(id = "ctl00_FC_PH_txtFirstName")
	private WebElement firstName;
	
	@FindBy(id = "ctl00_FC_PH_txtLastName")
	private WebElement lastName;
	
	@FindBy(id = "ctl00_FC_PH_txtDOB_input")
	private WebElement dob;
	
	@FindBy(id = "igtxtctl00_FC_PH_txtSSN")
	private WebElement ssN;

	@FindBy(id = "ctl00_FC_PH_cboOriginationChannelID_cboComboBoxControl")
	private WebElement originationChannel;
		
	@FindBy(id = "ctl00_FC_PH_cboCIPDocumentSource_cboComboBoxControl")
	private WebElement cipDocumentSource;
	
	@FindBy(id = "ctl00_FC_PH_txtTaxID")
	private WebElement taxID;
	
	@FindBy(id = "ctl00_FC_PH_cboCustomerClassID_cboComboBoxControl")
	private WebElement customerClass;
	
	@FindBy(id = "ctl00_FC_PH_cboStatus_cboComboBoxControl")
	private WebElement status;
	
	@FindBy(id = "ctl00_FC_PH_ContactPersonAssignmentUC1_cmdImportContact_cmdImportButton")
	private WebElement contactPersonFirstNameImportButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id = "ctl00_FC_PH_cboNAICSCode_cboComboBoxControl")
	private WebElement naicsCode;
	
	@FindBy(id = "ctl00_FC_PH_cboSICCode_cboComboBoxControl")
	private WebElement sicCode;
	
	@FindBy(id = "ctl00_FC_PH_cboOwnershipPatternID_cboComboBoxControl")
	private WebElement ownerShipPattern;

	
	public void enterAccountNumber(String accountnumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(accountNumber));
		accountNumber.clear();
		accountNumber.sendKeys(accountnumber);
	}
	

	public void enterCompanyName(String companyname)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(companyName));
		companyName.clear();
		companyName.sendKeys(companyname);
	}
	
	
	public void checkIndividualCheckBox()
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(isIndividual));
		isIndividual.click();
	}
	
	public void enterFirstName(String firstname)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.clear();
		firstName.sendKeys(firstname);
	}
	
	public void enterDateOfBirth(String DOB)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(dob));
		dob.clear();
		dob.sendKeys(DOB);
	}
	
	public void enterLastName(String lastname)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.clear();
		lastName.sendKeys(lastname);
	}
	
	public void enterTaxID(String taxid)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(taxID));
		taxID.clear();
		taxID.sendKeys(taxid);
	}
	
	public void selectOriginationChannel(String originationchannel)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(originationChannel));
		Select se= new Select(originationChannel);
		se.selectByVisibleText(originationchannel);
	}
	
	public void selectOwnerShipPattern(String ownershippattern)
	{
		WebDriverWait wt= new WebDriverWait(driver, 600);
		wt.until(ExpectedConditions.elementToBeClickable(ownerShipPattern));
		Select se= new Select(ownerShipPattern);
		se.selectByVisibleText(ownershippattern);
		//se.selectByIndex(2);
	}
	
	public void enterSocialSecurityNumber(String ssn)
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(ssN));
		ssN.clear();
		ssN.sendKeys(ssn);
	}
	
	public void selectCIPDocumentSource(String cipdocumentsource)
	{
		WebDriverWait wt= new WebDriverWait(driver, 600);
		wt.until(ExpectedConditions.elementToBeClickable(cipDocumentSource));
		Select se= new Select(cipDocumentSource);
		se.selectByVisibleText(cipdocumentsource);
	}
	
	public void selectStatus(String Status)
	{
		WebDriverWait wt= new WebDriverWait(driver, 600);
		wt.until(ExpectedConditions.elementToBeClickable(status));
		Select se= new Select(status);
		se.selectByVisibleText(Status);
		
	}
	
	public String clickOnFirstNameImportButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(contactPersonFirstNameImportButton));
		String customerprofilewindow = driver.getWindowHandle();
		contactPersonFirstNameImportButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		sc.waitForWndows(driver, customerprofilewindow); //Control is being changed to new window
		return customerprofilewindow;
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 500);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void selectNAICSCode()
	{
		WebDriverWait wt= new WebDriverWait(driver, 600);
		wt.until(ExpectedConditions.elementToBeClickable(naicsCode));
		naicsCode.click();
		Select se= new Select(naicsCode);
		se.selectByIndex(2);
	}
	
	public void selectSICCode(String siccode)
	{
		WebDriverWait wt= new WebDriverWait(driver, 600);
		wt.until(ExpectedConditions.elementToBeClickable(sicCode));
		Select se= new Select(sicCode);
		se.selectByVisibleText(siccode);
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
