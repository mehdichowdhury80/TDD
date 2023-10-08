package common;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import reports.Loggers;

public class CommonActions {
public static void input(WebElement element , String inputValue ) {
	try {
		element.sendKeys(inputValue);
		Loggers.log(element + "Input Value" + inputValue);
	} catch (NoSuchElementException e) {
	 Loggers.log(element + "Not Present" + e.getMessage());
	 Assert.fail();
		
	}
	public static void click(WebElement element) {
		try {
		element.click();
		Loggers.log(element + "Click done");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + "Not Found");
			Assert.fail();
		}
		
	}
}
}
