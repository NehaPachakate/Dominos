package dominosP;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.PickupRepo;

public class PickupD {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://pizzaonline.dominos.co.in/menu");
		JavascriptExecutor js=(JavascriptExecutor)driver;

		PickupRepo.Pickup(driver).click();
		Thread.sleep(3000);
		PickupRepo.City(driver).click();
		Thread.sleep(3000);
		PickupRepo.Arrow(driver).click();
		Thread.sleep(2000);
		PickupRepo.Name(driver).click();
		Thread.sleep(3000);
		PickupRepo.Store(driver).click();
		Thread.sleep(2000);
		PickupRepo.Storenm(driver).click();
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		driver.close();
	}

	}


