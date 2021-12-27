package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		// setting the driver executable
		System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\drivers\\chromedriver.exe");

		// Initiating your chrome driver
		driver = new ChromeDriver();

		// Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// maximize window
		driver.manage().window().maximize();
	}

	@Test
	public void amazon() {
		// product search
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pendrive");
		driver.findElement(By.id("nav-search-submit-button")).click();

		// price
		String exp = driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span/span[1]"))
				.getAttribute("innerHTML");

		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a"))
				.click();
		// price
		String act = driver
				.findElement(By.xpath("//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr/td[2]/span[1]/span[2]"))
				.getAttribute("innerHTML");

		// assertion
		AssertJUnit.assertEquals(exp, act, "Price does not change");

	}

}