package jp.co.leadingsoft.demo;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HelloControllerST {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities abilities = DesiredCapabilities.chrome();
		abilities.setCapability("name", "Testing Selenium Remote WebDriver");

		driver = new RemoteWebDriver(new URL("http://key:secret@selenium-hub.aws.leadingsoft.net/wd/hub"), abilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		this.driver.quit();
	}

	@Test
	public void test() {
		this.driver.get("http://www.google.com");
		assertEquals("Google", this.driver.getTitle());
	}

}
