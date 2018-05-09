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

public class LeaseIDCSetupPage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_cboIDCTemplateName_cboComboBoxControl")
	private WebElement idcTemplate;
	
	@FindBy(id="ctl00_FC_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	//@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3\']")
	@FindBy(id = "ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_3")
	private WebElement Amount;
	
	@FindBy(id = "igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2")
	private WebElement enterAmount;
	
	@FindBy(id="ctl00_FT_PH_cmdRecalculate_cmdButtonControl")
	private WebElement recalculateIDC;

	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(className= "igtbl_checkBox")
	private WebElement checkBox;
	
	@FindBy(xpath= "//*[@id=\"ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_1_6\"]/nobr")
	private WebElement userDefinedBookExpenseMode;

	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	
	@FindBy(id="ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_10")
	private WebElement fixedPortionAmount;
	
	
	@FindBy(id="igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls2")
	private WebElement fixedPortionAmountClick;
	

	@FindBy(id="ctl00xFCxPHxgrdLeaseIDCxgrdList_rc_0_12")
	private WebElement variablePortionPercentage;
	
	
	@FindBy(id="igtxtctl00_FC_PH_grdLeaseIDC_grdLeaseIDCLWGridEditor_Controls11")
	private WebElement variablePortionPercentageClick;
	
	
	
	
	
	public LeaseIDCSetupPage(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnCloseButton()
	{ 
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}
	
	
	
	

	public void selectUserDefinedBookExpenseMode(String mode)
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(userDefinedBookExpenseMode));
		Select select = new Select(userDefinedBookExpenseMode);
		select.selectByVisibleText(mode);
		
		
	}
	
	
	
	
	
	
	
	
	
	public void selectIDCTemplate(String index)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(idcTemplate));
		Select se = new Select(idcTemplate);
		///String in = index;
		//int index1 = Integer.parseInt(in);
		se.selectByVisibleText(index);
	}
	
	public void clickOnAddButton()
	{ 
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public void clickIDCAmount() throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(Amount));
		Amount.click();
	}
	
	
	public void enterIDCAmount(String amount) throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(enterAmount));
		enterAmount.clear();
		enterAmount.sendKeys(amount);
	}
	public void clickOnSaveButton()
	{
		String title = driver.getTitle();
		System.out.println(title);
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void clickOnRecalculateIDCButton()
	{
		recalculateIDC.click();
	}
	
	public void selectCheckBox()
	{
		checkBox.click();
	}
	
	
	public void enterFixedPortionAmount(String fpamount) throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(fixedPortionAmount));
		fixedPortionAmount.click();
		fixedPortionAmountClick.clear();
		fixedPortionAmountClick.sendKeys(fpamount);
	}
	
	
	public void enterVariablePortionPercentage(String vppercentage) throws InterruptedException
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(variablePortionPercentage));
		variablePortionPercentage.click();
		variablePortionPercentageClick.clear();
		variablePortionPercentageClick.sendKeys(vppercentage);
	}
	

}
