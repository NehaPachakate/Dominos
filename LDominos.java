package dominosP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import repository.LoginD1;

public class LDominos {

		public static void main(String[] args) throws IOException 
		{
			/*WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();*/
			
			WebDriverManager.edgedriver().setup();
			WebDriver driver= new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://pizzaonline.dominos.co.in");
			
			File fs= new File("Data\\Dominos.xlsx");
			FileInputStream fis= new FileInputStream(fs); 
			
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sh1= wb.getSheet("Sheet1");
			Actions act=new Actions(driver);
			for(int i=1; i<=4; i++)
			{
				String mobno=sh1.getRow(i).getCell(0).toString();
				System.out.println(mobno);
				LoginD1.login(driver).click();
				try
				{
					LoginD1.mobno(driver).sendKeys(mobno);
					//act.moveToElement(LoginRepo.submit(driver)).click().build().perform();
					//LoginRepo.submit(driver).click();
					Thread.sleep(70000);
					JavascriptExecutor js= (JavascriptExecutor)driver;
					
					js.executeScript("arguments[0].click();",LoginD1.submit(driver) );
					System.out.println("Clicked on Submit");
				    try
				    {
				    	LoginD1.okbutton(driver).click();
				    }
				    catch(Exception e)
				    {
				    	LoginD1.otp(driver).sendKeys("123456");
						
						js.executeScript("arguments[0].click();", LoginD1.Submit(driver));
				    }
					
					Thread.sleep(3000);
					
					
					try
					{
						LoginD1.Logout(driver).click();
						LoginD1.Logout1(driver).click();
					}
					catch(Exception e)
					{
						
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
					System.out.println("Invalid mobile number");
					System.out.println();
				}
			}
			
			driver.close();
		}

	}

