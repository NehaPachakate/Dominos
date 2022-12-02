package dominosP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.CouponRp;

public class Coupon {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://pizzaonline.dominos.co.in/menu");
		//driver.get("https://pizzaonline.dominos.co.in/cart");
	    Thread.sleep(70000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions act=new Actions(driver);
		
		File fs= new File("Data\\Mobnum.xlsx");
		FileInputStream fis= new FileInputStream(fs);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sh6= wb.getSheet("Sheet1");
		
		for(int i=1; i<=1; i++)
		{
			//String Code=sh6.getRow(i).getCell(0).toString();
			String Area=sh6.getRow(i).getCell(1).toString();
			
			//CouponRp.AdvClose(driver).click();
			//CouponRp.Paneer(driver).click();
			act.moveToElement(CouponRp.Paneer(driver)).click().build().perform();
			js.executeScript("window.scrollBy(0,2000)");		
			Thread.sleep(2000);
			CouponRp.Adv(driver).click();
			Thread.sleep(2000);
			CouponRp.Check(driver).click();
			Thread.sleep(2000);
			/*CouponRp.Offer(driver).click();
			Thread.sleep(2000);
			CouponRp.Code(driver).sendKeys(Code);
			Thread.sleep(2000);
			CouponRp.Apply(driver).click();
			Thread.sleep(2000);
			//act.moveToElement(CouponRp.Strips(driver)).click().build().perform();
			//CouponRp.Strips(driver).click();
			Thread.sleep(2000);*/
			CouponRp.Placeholder(driver).click();
			Thread.sleep(2000);
			CouponRp.Area(driver).sendKeys(Area);
			Thread.sleep(2000);
			CouponRp.Locateme(driver).click();
			Thread.sleep(2000);
			//CouponRp.Loc(driver).click();
			//Thread.sleep(2000);
			CouponRp.Placeholder1(driver).click();
			Thread.sleep(2000);
			
			for(int j=1; j<=6; j++)
			{
				String FirstNm=sh6.getRow(j).getCell(2).toString();
				String LastNm=sh6.getRow(j).getCell(3).toString();
				String MobileNo=sh6.getRow(j).getCell(4).toString();
				String Email=sh6.getRow(j).getCell(5).toString();
				String Address=sh6.getRow(j).getCell(6).toString();
				String HouseNo=sh6.getRow(j).getCell(7).toString();
				
				CouponRp.FirstNm(driver).sendKeys(FirstNm);
				Thread.sleep(2000);
				CouponRp.LastNm(driver).sendKeys(LastNm);
				Thread.sleep(2000);
				CouponRp.MobileNo(driver).sendKeys(MobileNo);
				Thread.sleep(2000);
				CouponRp.Email(driver).sendKeys(Email);
				Thread.sleep(2000);
				CouponRp.Address(driver).sendKeys(Address);
				Thread.sleep(2000);
				CouponRp.HouseNo(driver).sendKeys(HouseNo);
				Thread.sleep(2000);
				CouponRp.Save(driver).click();
				Thread.sleep(2000);
			}
			CouponRp.UPI(driver).click();
		}
		driver.close();

	}

}
