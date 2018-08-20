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
	  //���ùȸ������λ��
	  System.setProperty("webdriver.chrome.driver",".\\Tools\\chromedriver.exe");
	  //driver = new ChromeDriver();
	 //��ʼ�������  
	  login = new LoginAction(driver);
	  //���ʵ�ַ
	  driver.get("http://10.20.1.91:8081/login");
	  //�Ŵ����������
	  driver.manage().window().maximize();
	  //���õȴ�5��ʱ��
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  
  //���õ�¼����
  @Test(priority=1)
  public void login() throws InterruptedException{
	  login.Login("zhaoxiao", "zx991314");

  }
  
  
  //����ִ�ж����෽��
  @Test(priority=2)
  public void query_keys() throws InterruptedException{
	//��ʼ�������  
	query = new QueryAction(driver);
	query.QueryButton();
	
  }

  

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  } 	

}
