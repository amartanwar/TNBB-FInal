package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class PayoffQuoteListPage extends BasePage {
	
	
	@FindBy(id="igtxtctl00_FC_PH_schSearchControl_bshBasicSearch_OneInt32ctl00_FC_PH_schSearchControlrRrrRrrRr0rRr1")
	private WebElement payoffQuoteID;
	
	@FindBy(id="ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr2")
	private WebElement payoffQuoteName;
	
	@FindBy(id="ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;

	@FindBy(id="ctl00_FT_PH_cmdGenerateInvoice_cmdButtonControl")
	private WebElement generateInvoiceButton;
	
	@FindBy(id="ctl00_FC_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(id="ctl00_FC_PH_grdList_lnkAllCP")
	private WebElement selectAllButton;
	
	
	@FindBy(id="ctl00_FC_PH_SchedulerUC1_rdoImmediately")
	private WebElement runImmediatelyRadioButton;
	
	
	@FindBy(xpath ="//*[@id=\"ctl00_GlobalInstructionBox_DisplayArea\"]/font/a" )
	private WebElement jobID;

	@FindBy(id="ctl00_FT_PH_cmdSelect_cmdButtonControl")
	private WebElement selectButton;
	
	
	@FindBy(xpath="//*[@id='ctl00xFCxPHxgrdListxgrdList_rc_0_7']/nobr")      //tr[@id='ctl00xFxPHxgrdListxgrdList_r_0']/td[4]/nobr
	private WebElement payOffQuoteStatus;
	
	
	public PayoffQuoteListPage(WebDriver driver,ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnAddButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		
	}
	
	
	public void enterPayoffQuoteName(String name)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(payoffQuoteName));
		payoffQuoteName.clear();
		payoffQuoteName.sendKeys(name);
		
	}
	
	public void clickOnGenerateInvoiceButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(generateInvoiceButton));
		generateInvoiceButton.click();
		
	}
	
	public void clickOnSearchButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		
	}
	
	public void clickOnSelectAllButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectAllButton));
		selectAllButton.click();
		
	}
	
	public void clickOnRunImmediatelyRadioButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(runImmediatelyRadioButton));
		runImmediatelyRadioButton.click();
		
	}
	
	public void clickOnJobID()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(jobID));
		jobID.click();	
	}
	
	public void clickOnSelectButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();	
	}
	
	public String validateJobStatus()
	{
		
		WebDriverWait wt= new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(searchButton));
	
		String PayOffQuoteStatus = payOffQuoteStatus.getText();	

		return PayOffQuoteStatus;
	}
}
