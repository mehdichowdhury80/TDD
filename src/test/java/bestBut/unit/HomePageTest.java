package bestBut.unit;

import org.testng.annotations.Test;

import base.TestBase;

public class HomePageTest extends TestBase {

@Test
public void clickInputSearchBtnTest() {
	hp.clickSearchButton();
	hp.inputText();
}
	}

