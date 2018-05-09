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

public class JarkFlowPage extends BasePage {

	public JarkFlowPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FC_PH_chkFolwChange")
	private WebElement flowChange;
	
	@FindBy(id="ctl00_FC_PH_rdoDefaultNextPath")
	private WebElement defualtNextPath;

	@FindBy(id="ctl00_FT_PH_cmdContinue_cmdButtonControl")
	private WebElement continueButton;
	
	@FindBy(id="ctl00_FC_PH_rdoAlternativePath")
	private WebElement alternatePath;
	
	@FindBy(id="ctl00_FC_PH_cboAlternativePath_cboComboBoxControl")
	private WebElement selectAlternatePath;
	
	
	public void clickOnFlowChange()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(flowChange));
		flowChange.click();
	}
	
	public void clickOnDefaultNextPath()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(defualtNextPath));
		defualtNextPath.click();
	}
	
	public void clickOnContinue(String beforewindow1)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		driver.switchTo().window(beforewindow1);
	}
	
	public void clickOnAlternatePath()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(alternatePath));
		alternatePath.click();
	}
	
	public void selectAlternatePath()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(selectAlternatePath));
		Select se = new Select(selectAlternatePath);
		se.selectByIndex(1);
	}
	
}
