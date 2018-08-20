package testng;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import action.LoginAction;
import action.QueryAction;


public class test2 {

  LoginAction login = null;
  QueryAction query = null;
  WebDriver driver = new ChromeDriver();
  
  @BeforeClass
  public void beforeClass(){
	  //设置谷歌浏览器位置
	  System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
	  //driver = new ChromeDriver();
	 //初始化浏览器  
	  login = new LoginAction(driver);
	  //访问地址
	  driver.get("http://10.20.1.91:8081/login");
	  //放大浏览器窗口
	  driver.manage().window().maximize();
	  //设置等待5秒时间
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  
  //调用登录方法
  @Test(priority=1)
  public void login() throws InterruptedException{
	  login.Login("zhaoxiao", "zx991314");

  }
  
  
  //调用执行动作类方法
  @Test(priority=2)
  public void query_keys() throws InterruptedException{
	//初始化浏览器  
	query = new QueryAction(driver);
	query.QueryButton();
	
  }

  

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  } 	

}
