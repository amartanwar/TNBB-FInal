package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public  class AssetListPage extends BasePage
{


	@FindBy(id="ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id="ctl00_ctl04_lnkSignOut")
	private WebElement pageTitle;
	
	@FindBy(id="ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr1")
	private WebElement assetAlias;
	
	@FindBy(id="igtxtctl00_FC_PH_schSearchControl_bshBasicSearch_OneInt32ctl00_FC_PH_schSearchControlrRrrRrrRr1rRr0")
	private WebElement unitnumber;

	@FindBy(id="ctl00_FC_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(id="ctl00_FC_PH_grdList_lnkAllCP")
	private WebElement currentpage;
	
	@FindBy(id="ctl00_FT_PH_cmdSelect_cmdButtonControl")
	private WebElement selectButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement selectExportButton;
	
	//newly added to aid Asset value change list page
	@FindBy(xpath="//input[@class='igtbl_checkBox']")
	private WebElement gridCheckBox;

	@FindBy(id="ctl00_FC_PH_grdList_lnkAllCP")
	private WebElement selectAll;
	
	@FindBy(id="ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement select;
	
	
	public AssetListPage(WebDriver driver,ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnSelectAll()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(selectAll));
		selectAll.click();	
	}
	public void clickOnSelectButton(String leaseTransactionAssetsWindow)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(select));
		select.click();	
		driver.switchTo().window(leaseTransactionAssetsWindow);
	}
	
	public void clickOnaddButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();	
	}
	
	public void searchByAlias(String alias) throws InterruptedException
	{
		WebDriverWait wt1=new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(assetAlias));
		assetAlias.clear();
		assetAlias.sendKeys(alias);
	}
	
	public void searchByUnitNumber(String unNumber) throws InterruptedException
	{
		WebDriverWait wt1=new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.visibilityOf(unitnumber));
		unitnumber.clear();
		unitnumber.sendKeys(unNumber);
	}
	
	public void clickOnSearchButton() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
	}
	
	public void clickOnCurrentAll()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(currentpage));
		currentpage.click();
		
	}
	
	public void clickONSelectButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
	}
	
	public void clickOnSelectExportButton(String beforewindow) 
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectExportButton));
		selectExportButton.click();
		driver.switchTo().window(beforewindow);	
	}
	
	public void selectGridCheckBox()
	{
		WebDriverWait wt= new WebDriverWait(driver,60);
		wt.until(ExpectedConditions.visibilityOf(gridCheckBox));
		gridCheckBox.click();
	}
	
}
