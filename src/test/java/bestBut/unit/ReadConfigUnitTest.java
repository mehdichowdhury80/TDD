package bestBut.unit;

import java.io.IOException;

import org.testng.annotations.Test;

import constant.KeyConfig;
import utils.ReadConfig;

public class ReadConfigUnitTest {// this is to test my configuration.We may not need to do it in real
  @Test
  public void getPropertiesTest() throws IOException {
	  ReadConfig config = new ReadConfig();
	  String urlString = config.getValue(KeyConfig.url);
	  System.out.println(urlString);
	  
	  
  }
}
