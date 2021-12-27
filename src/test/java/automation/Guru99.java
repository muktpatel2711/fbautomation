package automation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Guru99 {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void accessWebTable() {
		driver.get("https://www.guru99.com/uft-qtp-automation-testing.html");

		List<WebElement> webTableRow = driver
				.findElements(By.xpath("//*[@id=\"post-72\"]/div/div/div[3]/table/tbody/tr"));

		int totalRow = webTableRow.size();

		for (int i = 2; i <= totalRow; i++) {

			String rowCol1 = driver
					.findElement(By.xpath("//*[@id=\"post-72\"]/div/div/div[3]/table/tbody/tr[" + i + "]/td[1]/ul/li"))
					.getText();
			String rowCol2 = driver
					.findElement(
							By.xpath("//*[@id=\"post-72\"]/div/div/div[3]/table/tbody/tr[" + i + "]/td[2]/ul/li[1]"))
					.getText();

			System.out.println(rowCol1 + rowCol2);
		}

		driver.quit();

	}

	@Test
	public void ByVisibleElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Launch the application
		driver.get("http://demo.guru99.com/test/guru99home/");

		// Find element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.linkText("Linux"));

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void signup_guru99() {

		driver.get("http://demo.guru99.com/popup.php");

		driver.findElement(By.xpath("/html/body/p/a")).click();

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();

		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {

			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");

				driver.findElement(By.name("btnLogin")).click();

				// Closing the Child Window.
				driver.close();
			}
		}

		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);
	}

}