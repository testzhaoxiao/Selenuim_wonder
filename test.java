package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://10.20.1.91:8081/login");
	  
	  Thread.sleep(2000);
	  
	  
  }

  @Test(priority=1)
  public void login() throws InterruptedException{
	  driver.findElement(By.name("username")).clear();
	  driver.findElement(By.name("username")).sendKeys("zhaoxiao");
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("zx991314");
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("button.layui-btn.larry-btn")).click();
	  Thread.sleep(1000);
	  
  }
  
  @Test(priority=2)
  public void query_keys() throws InterruptedException{
	  driver.findElement(By.linkText("客户管理")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText(("客户信息"))).click();
	  driver.switchTo().frame(1);
	  Thread.sleep(1000);
	  driver.findElement(By.id("searchcustomername")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("searchcustomername")).sendKeys("赵孝");
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("button.layui-btn.layui-btn-sm")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("searchcustomername")).clear();
	  Thread.sleep(1000);
	  driver.findElement(By.id("searchcustomername")).sendKeys("赵");
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("button.layui-btn.layui-btn-sm")).click();
	  Thread.sleep(1000);
	  
	
  }

  

  @AfterTest
  public void afterClass() throws InterruptedException {
	  Thread.sleep(2000);
	  //driver.quit();
  }

}
