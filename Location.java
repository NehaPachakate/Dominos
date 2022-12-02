package dominosP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.LocationRepo;

public class Location {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://pizzaonline.dominos.co.in");
		
		File fs= new File("Data\\Dominos.xlsx");
		FileInputStream fis= new FileInputStream(fs);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sh3= wb.getSheet("Sheet3");
		XSSFSheet sh4= wb.getSheet("Sheet4");
		XSSFSheet sh5= wb.getSheet("Sheet5");

		for(int i=1; i<=3; i++)
		{
			String Address=sh3.getRow(i).getCell(0).toString();		
			System.out.println(Address);
			LocationRepo.Address(driver).sendKeys(Address);
			Thread.sleep(70000);
			LocationRepo.Locateme(driver).click();
			Thread.sleep(3000);
			LocationRepo.Addtocard(driver).click();
			Thread.sleep(3000);
			LocationRepo.Addition1(driver).click();
			Thread.sleep(3000);
			LocationRepo.Checkout(driver).click();
			Thread.sleep(3000);
			LocationRepo.Placeorder(driver).click();
			
			for(int j=1; j<=2; j++)
			{
				String FirstNm=sh4.getRow(j).getCell(0).toString();
				String LastNm=sh4.getRow(j).getCell(1).toString(); 
				String MobileNo=sh4.getRow(j).getCell(2).toString();
				String Email=sh4.getRow(j).getCell(3).toString();
				String Add=sh4.getRow(j).getCell(4).toString();
				String HouseNo=sh4.getRow(j).getCell(5).toString();

				LocationRepo.FirstNm(driver).sendKeys(FirstNm);
				Thread.sleep(2000);
				LocationRepo.LastNm(driver).sendKeys(LastNm);
				Thread.sleep(2000);
				LocationRepo.MobileNo(driver).sendKeys(MobileNo);
				Thread.sleep(2000);
				LocationRepo.Email(driver).sendKeys(Email);
				Thread.sleep(2000);
				LocationRepo.Add(driver).sendKeys(Add);
				Thread.sleep(2000);
				LocationRepo.HouseNo(driver).sendKeys(HouseNo);
				Thread.sleep(2000);
				LocationRepo.Save(driver).click();
				Thread.sleep(2000);
				LocationRepo.Card(driver).click();
				Thread.sleep(2000);
				
				for(int k=1; k<=3; k++)
				{
					String CardNo=sh5.getRow(k).getCell(0).toString();
					String NameOnCard=sh5.getRow(k).getCell(1).toString();
					String CvvNo=sh5.getRow(k).getCell(2).toString();
					
					LocationRepo.CardNo(driver).sendKeys(CardNo);
					Thread.sleep(2000);
					LocationRepo.MonthArrow(driver).click();
					Thread.sleep(2000);
					LocationRepo.MonthNo(driver).click();
					Thread.sleep(2000);
					LocationRepo.YearArrow(driver).click();
					Thread.sleep(2000);
					LocationRepo.YearNo(driver).click();
					Thread.sleep(2000);
					LocationRepo.NameOnCard(driver).sendKeys(NameOnCard);
					Thread.sleep(2000);
					LocationRepo.CvvNo(driver).sendKeys(CvvNo);
					Thread.sleep(2000);
					LocationRepo.PayNow(driver).click();
					
				}
			}
		}
		driver.close();
	}

}
