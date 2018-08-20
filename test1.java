package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.Longinpage;
import page.Querypage;

public class test1 {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass(){
	  
	  System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://10.20.1.91:8081/login");
	 
	  
  }

  @Test(priority=1)
  public void login() throws InterruptedException{
	Longinpage.userName(driver).sendKeys("zhaoxiao");
	Longinpage.passWord(driver).sendKeys("zx991314");
	Thread.sleep(1000);
	Longinpage.loginButton(driver).click();
	
  }
  
  @Test(priority=2)
  public void query_keys() throws InterruptedException{
	  Thread.sleep(1000);
	  Querypage.kehuguanli(driver).click();
	  Thread.sleep(1000);
	  Querypage.kehuxinxi(driver).click();
	  Thread.sleep(1000);
	  driver.switchTo().frame(1);
	  Thread.sleep(1000);
	  Querypage.showName(driver).clear();
	  Thread.sleep(1000);
	  Querypage.showName(driver).sendKeys("赵孝");
	  Thread.sleep(1000);
	  Querypage.selectButton(driver).click();
	  Thread.sleep(1000);
	  Querypage.showName(driver).clear();
	  Thread.sleep(1000);
	  Querypage.showName(driver).sendKeys("赵");
	  Thread.sleep(1000);
	  Querypage.selectButton(driver).click();
	
  }

  

  @AfterTest
  public void afterClass() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
