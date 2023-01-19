package Reliance;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reliance_test {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.ril.com/");
		System.out.println(driver.getTitle());
		String window = driver.getWindowHandle();
		driver.findElement(By.linkText("Jio")).click();

		Set<String> windows = driver.getWindowHandles();
		for (String handles : windows) {

			if (!handles.equalsIgnoreCase(window)) {
				driver.switchTo().window(handles);
				System.out.println("=================");
				System.out.println(driver.getCurrentUrl());
				driver.findElement(By.xpath("//a[@id='Sign-In']")).click();

			} else
				System.out.println("driver not switched");

		}
		driver.quit();

	}

	@Test
	public void date() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.apsrtconline.in/oprs-web/");
		driver.findElement(By.id("txtJourneyDate")).click();
		List<WebElement> dates = driver
				.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//td"));
		for (int i = 0; i < dates.size(); i++) {
			String reqdate = dates.get(i).getText();
			if (reqdate.equals("15")) {
				dates.get(i).click();
				Thread.sleep(3000);
				break;
				
			}
		}

	}

}
