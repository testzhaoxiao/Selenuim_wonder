package action;

import org.openqa.selenium.WebDriver;

import page.Querypage;

public class QueryAction {
	
	private WebDriver driver;
	//构造方法，初始化
	public QueryAction(WebDriver driver){
		this.driver = driver;
	}
	//动作类方法
	public void QueryButton() throws InterruptedException{
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

}
