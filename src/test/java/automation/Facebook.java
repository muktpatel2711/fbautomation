package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void signUp_Facebook() {
		driver.get("https://www.facebook.com/");
		WebElement newAccount = driver.findElement(By.linkText("Create new account"));
		newAccount.click();
		WebElement firstname = driver.findElement(By.name("firstname"));
		WebElement lastname = driver.findElement(By.name("lastname"));
		WebElement email = driver.findElement(By.name("reg_email__"));
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		WebElement repass = driver.findElement(By.name("reg_email_confirmation__"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.name("birthday_day"));
		WebElement year = driver.findElement(By.name("birthday_year"));

		firstname.sendKeys("abc");
		lastname.sendKeys("zyx");
		email.sendKeys("abc@gmail.com");
		password.sendKeys("1234567890");
		repass.sendKeys("1234567890");

		Select drpmonth = new Select(month);
		drpmonth.selectByVisibleText("May");

		Select drpday = new Select(day);
		drpday.selectByVisibleText("2");
		Select drpyear = new Select(year);
		drpyear.selectByValue("2001");
		WebElement radio1 = driver.findElement(By.xpath("//label[text()='Female']"));
		WebElement radio2 = driver.findElement(By.xpath("//label[text()='Male']"));

		radio1.click();
		radio2.click();

		WebElement radio3 = driver.findElement(By.xpath("//label[text()='Custom']"));
		radio3.click();
		WebElement wish = driver.findElement(By.name("preferred_pronoun"));

		Select hope = new Select(wish);
		hope.selectByVisibleText("He: \"Wish him a happy birthday!\"");
		WebElement we = driver.findElement(By.name("custom_gender"));
		we.sendKeys("any");
	}

	@AfterTest
	public void tearDown() {

	}

}