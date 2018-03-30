package RestAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationCore.PageObjectBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestValidations extends PageObjectBase {
	
	
	@BeforeClass
	public void configurationSetting(){
		System.out.println("****"+System.getProperty(getBaselinedProperty().getProperty("driverpath")+"//IEDriverServer.exe"));
		System.setProperty("webdriver.ie.driver",getBaselinedProperty().getProperty("driverpath")+"//IEDriverServer.exe");
		DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		WebDriver driver=new InternetExplorerDriver(cap);
		driver.get("http://www.google.com");
	}
	@Test
	public void getData(){
		System.out.println("Testing..");
		Response response=RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");
		System.out.println("Status Codd"+response.getStatusCode());
		System.out.println("Actual Response: \n"+response.getContentType());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
