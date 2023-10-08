package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gh-search-input")
	WebElement searchButton;
	
	

	public void clickSearchButton() {
		click(searchButton);
		
	}
	public void inputText() {
		input(searchButton);
	}
}

/*
 * searchButton.click(); Thread.sleep(3000); searchButton.sendKeys("Laptop");
 * Thread.sleep(3000);?
 */
