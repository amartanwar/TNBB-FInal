package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class PortFolioManagementMenu extends BasePage {

	public PortFolioManagementMenu(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="id(\"lnkMenuLA\")")
	private WebElement portfolioManagement;
	
	public void clickPortFolioManagement()
	{
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOf(portfolioManagement));
		portfolioManagement.click();
	}
	
}

