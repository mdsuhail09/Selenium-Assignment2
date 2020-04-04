package introduction;



import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class harishAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String HomePageTitle ="Welcome: Mercury Tours";
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\suhail\\\\Music\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		
		//*********Title Validation***************************
		String PageTitle= driver.getTitle();
		if(PageTitle.equalsIgnoreCase(HomePageTitle))
		{
			System.out.println(PageTitle);
		}
		
		//*********************validate the date******************
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
		int dat= cal.get(cal.DAY_OF_MONTH);
		String date = Integer.toString(dat);
		simpleformat = new SimpleDateFormat("MMM");
	      String month= simpleformat.format(new Date());
		int yr = cal.get(cal.YEAR);
		String Year =Integer.toString(yr);
		String todayDate ="";
		todayDate =month+" "+date+","+" "+Year;
		
		System.out.println(todayDate);
		
		String pageDate=
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/font/b")).getText();
		
		if(todayDate.equalsIgnoreCase(pageDate))
		{
			System.out.println("The page date and today  is  same:" + pageDate);
		}
		else
		{
			System.out.println("Date error");
		}
	
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		//********************validate select flight screen****************
		//WebElement validation1 =driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img"));
		WebElement validation1 = driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']"));
	String ff =	validation1.getText();
		System.out.println(ff);
		
		if(validation1.isEnabled())
		{
			System.out.println("Flight finder screen appears");
		}
		else
		{
			System.out.println("Flight finder screen not appears");
		}
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
		Select dep = new Select(driver.findElement(By.name("fromPort")));
		dep.selectByIndex(2);
		Thread.sleep(2000L);
		Select mon = new Select(driver.findElement(By.name("fromMonth")));
		Thread.sleep(2000L);
		mon.selectByValue("4");
		Thread.sleep(2000L);
		Select arr = new Select(driver.findElement(By.name("toPort")));
		arr.selectByValue("New York");
		Select toda = new Select(driver.findElement(By.name("toMonth")));
		toda.selectByValue("5");
		Thread.sleep(2000L);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).click();
		Thread.sleep(2000L);
		Select arrli = new Select(driver.findElement(By.name("airline")));
		arrli.selectByIndex(2);
		driver.findElement(By.name("findFlights")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000L);
		
		//************Select flight screen validation*******************
		WebElement validation2 = driver.findElement(By.xpath("//img[@src='/images/masts/mast_selectflight.gif']"));
		if(validation2.isEnabled())
		{
			System.out.println("Select Flight  screen appears");
		}
		else
		{
			System.out.println("Select Flight  screen not appears");
		}
		
		WebElement Element = driver.findElement(By.name("reserveFlights"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
		Thread.sleep(2000L);
		//***********Book a flight screen ***********************
		WebElement validation3=driver.findElement(By.xpath("//*[@src='/images/masts/mast_book.gif']"));
		if(validation3.isEnabled())
		{
			System.out.println("Book a  Flight screen appears");
		}
		else
		{
			System.out.println("Book a  Flight screen not appears");
		}
		driver.findElement(By.name("passFirst0")).sendKeys("John");
		
		driver.findElement(By.name("passLast0")).sendKeys("Peter");
		
		
		driver.findElement(By.name("creditnumber")).sendKeys("123456");
		WebElement Element1 = driver.findElement(By.name("buyFlights"));
		js.executeScript("arguments[0].scrollIntoView();", Element1);
		Element1.click();
		Thread.sleep(2000L);
		driver.close();
		
		
		
		
		
	}

}
