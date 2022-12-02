package dominosP;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.EveryDayRepo;

public class EveryDayDom {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://pizzaonline.dominos.co.in/menu");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Actions act=new Actions(driver);
		
		EveryDayRepo.Day(driver).click();
		Thread.sleep(70000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		EveryDayRepo.Order(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Arrow(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Crust(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Select(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Addition1(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.AddtoCard(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Checkout(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Placeorder(driver).click();
		Thread.sleep(2000);
		
		EveryDayRepo.Pick(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.City(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.City1(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.SelectCity(driver).click();
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		EveryDayRepo.Store(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Store2(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Storenm(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Ok(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Pro(driver).click();
		Thread.sleep(2000);
		EveryDayRepo.Add(driver).click();
		EveryDayRepo.Placeorder1(driver).click();
	/*	File fs= new File("Data\\Mobnum.xlsx");
		FileInputStream fis= new FileInputStream(fs);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sh5= wb.getSheet("Sheet5");

		for(int i=1; i<=4; i++)
		{
			String Area=sh5.getRow(i).getCell(0).toString();

			String FirstNm=sh5.getRow(i).getCell(1).toString();
			String LastNm=sh5.getRow(i).getCell(2).toString();
			String MobileNo=sh5.getRow(i).getCell(3).toString();
			String Email=sh5.getRow(i).getCell(4).toString();
			
			EveryDayRepo.Area(driver).sendKeys(Area);
			//EveryDayRepo.City(driver).click();
			EveryDayRepo.LoacteMe(driver).click();
		//	driver.switchTo().alert().accept();
			EveryDayRepo.SelectLoc(driver).click();
			//act.moveToElement(EveryDayRepo.Loc(driver)).click().build().perform();
			
			/*EveryDayRepo.FirstNm(driver).sendKeys(FirstNm);
			Thread.sleep(2000);
			EveryDayRepo.LastNm(driver).sendKeys(LastNm);
			Thread.sleep(2000);
			EveryDayRepo.MobileNo(driver).sendKeys(MobileNo);
			Thread.sleep(2000);
			EveryDayRepo.Email(driver).sendKeys(Email);
			Thread.sleep(2000);*/
		//}
		driver.close();
	}

	}


