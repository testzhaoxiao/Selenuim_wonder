package action;

import org.openqa.selenium.WebDriver;

import page.Longinpage;

public class LoginAction {
	
		private WebDriver driver;
		//构造方法，初始化
		public LoginAction(WebDriver driver){
			this.driver = driver;
			
		}
		//登录方法
		public void Login(String user,String pw){
			Longinpage.userName(driver).sendKeys(user);
			Longinpage.passWord(driver).sendKeys(pw);
			Longinpage.loginButton(driver).click();								
		}

}
