package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ContactPersonListPage extends BasePage {

	public ContactPersonListPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(id = "ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr1")
	private WebElement firstName;
	
	@FindBy(id = "ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr4")
	private WebElement lastName;
	
	@FindBy(id = "ctl00_FC_PH_schSearchControl_bshBasicSearch_OneStringctl00_FC_PH_schSearchControlrRrrRrrRr0rRr3")
	private WebElement department;	
	
	@FindBy(id = "ctl00_FC_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id = "ctl00_FT_PH_cmdSelectClient_cmdExportButton")
	private WebElement selectButton;
	
	
	
	//No need to switch window, because this page will be closed upon click of ADD button
	public void clickOnAddButon()
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public void clickOnSelectButton(String customerprofilewindow) 
	{
		WebDriverWait wt= new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.elementToBeClickable(selectButton));
		selectButton.click();
		driver.switchTo().window(customerprofilewindow);	
	}
	
}
