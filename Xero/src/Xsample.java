import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xsample extends XReusable {

	@BeforeClass
	public void IntializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		CreateReport();
	}

	@Test
	public static void CorrectLogin() throws InterruptedException {
		logger = report.startTest("CorrectLogin");
		OpenUrl("https://login.xero.com");
		logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.id("email"));
		EnterText(un, "rajyok05@gmail.com", "UserName");
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "tekarch123", "PW");
		WebElement lbtn = driver.findElement(By.id("submitButton"));
		lbtn.click();
		// System.out.println("LoginIn Page Opened With Correct UserName & PassWord");
		String expectedTitle = "Login | Xero Accounting Software";
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle))
		{
			logger.log(LogStatus.PASS, "User is on home page");
				}
		else {
			logger.log(LogStatus.FAIL, "home page is not Lunched");
		}
		
	}

	@Test
	public static void LoginErrorPasswordPage() throws InterruptedException {
		logger = report.startTest("LoginErrorPassWordPage");
		OpenUrl("https://login.xero.com");
		logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.id("email"));
		EnterText(un, "rajyok05@gmail.com", "UserName");
		Thread.sleep(2000);
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "", "PW");
		Thread.sleep(2000);
		WebElement lbtn = driver.findElement(By.id("submitButton"));
		lbtn.click();
		Thread.sleep(2000);
		String errormessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]")).getText();
		if (errormessage.equals("Please enter your password.")) {
			System.out.println("Error message cannot be displayed");
			logger.log(LogStatus.INFO, "Login Sucessful");
				} 
		else {
			System.out.println("Error message is been be displayed");
			logger.log(LogStatus.ERROR, "Please enter your password");
		}
		Thread.sleep(3000);
	}

	@Test
	public static void LoginErrorUserPage() throws InterruptedException {
		logger = report.startTest("LoginErrorUserPage");
		OpenUrl("https://login.xero.com");
		logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.id("email"));
		EnterText(un, "", "UserName");
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "tekarch123", "PW");
		Thread.sleep(2000);
		WebElement lbtn = driver.findElement(By.id("submitButton"));
		lbtn.click();
		Thread.sleep(2000);
		String errormessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]")).getText();

		if (errormessage.equals("Plear Enter UserName")) {
			System.out.println("Erro Message Cannot be Diplayed");
			logger.log(LogStatus.INFO, "Login Successful");
		} else {
			System.out.println("Erro Message is be Diplayed");
			logger.log(LogStatus.ERROR, "Please Enter Your UserName");
			
		}
		Thread.sleep(2000);
	}
	
	@Test
	public static void ForgotPassword() throws InterruptedException {
		logger = report.startTest("ForgotPassword");
		OpenUrl("https://login.xero.com");
		logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.id("email"));
		EnterText(un, "rajyok05@gmail.com", "UserName");
		WebElement fpwd = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/a[1]"));
		Click(fpwd, "forgotpassword");
		Thread.sleep(2000);
		WebElement un1 = driver.findElement(By.id("UserName"));
		EnterText(un1, "rajyok05@gmail.com", "email");
		Thread.sleep(2000);
		WebElement sl = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div/div[1]/a/span"));
	sl.click();
	Thread.sleep(2000);
	}
	@Test
	public static void Signup() throws InterruptedException {
		logger = report.startTest("Signup");
		OpenUrl("https://www.xero.com/us");
		logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
		Thread.sleep(2000);
		WebElement ft = driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		ft.click();
		Thread.sleep(1500);
		WebElement fn = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[2]/label/input"));
		EnterText(fn, "raj", "FirstName");
		Thread.sleep(1500);
		WebElement ln = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[3]/label/input"));
		EnterText(ln, "raja", "LastName");
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[4]/label/input"));
		EnterText(e, "ryrewards05@gmail.com", "email");
		Thread.sleep(1500);
		WebElement pn = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[5]/label/input"));
		EnterText(pn, "4084106418", "phoneno");
		Thread.sleep(2000);
		 Select country = new Select(driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[6]/label/span/select")));
				 List<WebElement> dropdown = country.getOptions();
				 for (int i = 0; i < dropdown.size(); i++) {
				 String drop_down_values = dropdown.get(i).getText();
				 System.out.println("dropdown values are " + drop_down_values);
				 if (drop_down_values.equals("United States")) {
				 country.selectByIndex(i);
				 System.out.println("Country United States chosen");
				 }
				 }
				 Thread.sleep(3000);
		WebElement agree = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[8]/div/label/input"));
		agree.click();
		Thread.sleep(2000);
		WebElement getstarted = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[9]/span"));
		getstarted.click();
		Thread.sleep(2000);
		WebElement notrobort = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]"));
		notrobort.click();
		Thread.sleep(2000);
		}
@Test
	public static void getstarted() throws InterruptedException {
		logger = report.startTest("getstarted");
		OpenUrl("https://www.xero.com/us");
		logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
		Thread.sleep(2000);
		WebElement ft = driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
		ft.click();
		Thread.sleep(2000);
		WebElement getstarted = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[9]/span"));
		getstarted.click();
		Thread.sleep(2000);
}
@Test
public static void TermsPrivacy() throws InterruptedException {
	logger = report.startTest("TermsPrivacy");
	OpenUrl("https://www.xero.com/us");
	logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement ft = driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
	ft.click();
	Thread.sleep(2000);
	WebElement t = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[8]/div/label/a[1]"));
	t.click();
	Thread.sleep(2000);
   	WebElement p = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[8]/div/label/a[2]"));
	p.click();
	Thread.sleep(3000);
}
@Test
public static void OfferDetails() throws InterruptedException {
	logger = report.startTest("OfferDetails");
	OpenUrl("https://www.xero.com/us");
	logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement ft = driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
	ft.click();
	Thread.sleep(2000);
	WebElement of = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[8]/div/label/a[3]"));
	of.click();
	Thread.sleep(2000);
}
@Test
public static void accountantbookkeeper() throws InterruptedException {
	logger = report.startTest("accountantbookkeeper");
	OpenUrl("https://www.xero.com/us");
	logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement ft = driver.findElement(By.xpath("/html/body/div[4]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
	ft.click();
	Thread.sleep(2000);
	WebElement ab = driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div/div/div/p/a"));
	ab.click();
	Thread.sleep(2000);
}
@Test
public static void TestallTabs() throws InterruptedException {
	logger = report.startTest("TestallTabs");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	Thread.sleep(2000);
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(2000);
	WebElement dash = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[1]/a"));
	dash.click();   
	Thread.sleep(2000);
	WebElement acc = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[3]/button"));
	acc.click();
	Thread.sleep(2000);
	WebElement rep = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[3]/div/div[2]/div/ol[1]/li[2]/a"));
	rep.click();
	Thread.sleep(2000);
	WebElement contacts = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[1]/li[4]/button"));
	contacts.click();
	Thread.sleep(3000);
//	Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/svg/path")));
//	dropdown.selectByIndex(1);
//	Thread.sleep(2000);
	WebElement xyz = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/svg/path"));
	xyz.click();
	Thread.sleep(2000);
	WebElement set = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[2]/ol/li[2]/a"));
	set.click();
	Thread.sleep(2000);
	WebElement add = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[3]/ol/li[2]/a"));
	add.click();
	Thread.sleep(2000);
	WebElement f = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div/div[2]/div[2]/ol/li[1]/a"));
	f.click();
	Thread.sleep(2000);
	WebElement not = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[3]/button/div/svg/path"));
	not.click();
	Thread.sleep(2000);
	WebElement s = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[2]/button/div/svg"));
	s.click();
	Thread.sleep(2000);
	WebElement h = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[4]/button/div/svg"));
	h.click();
	Thread.sleep(2000);
	}
@Test
public static void LogOut() throws InterruptedException {
	logger = report.startTest("LogOut");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPENED SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(2000);
	WebElement ry = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/button/div/abbr"));
	ry.click();
	Thread.sleep(2000);
	WebElement lo = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/div/div[2]/div/ol/li[5]/a"));
	lo.click();
	Thread.sleep(2000);
	WebElement un1 = driver.findElement(By.id("email"));
	EnterText(un1, "rajyok05@gmail.com", "UserName");
}
@Test
public static void Image() throws InterruptedException {
	logger = report.startTest("Image");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	Thread.sleep(2000);
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(2000);
	WebElement ry = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/button/div/abbr"));
	ry.click();
	Thread.sleep(2000);
	WebElement p = driver.findElement(By.xpath("/html/body/div[1]/header/div/ol[2]/li[5]/div/div[2]/div/ol/li[1]/a"));
	p.click();
	Thread.sleep(2000);
	WebElement ui = driver.findElement(By.xpath("//*[@id=\"button-1041\"]"));
	ui.click();
	Thread.sleep(2000);
	WebElement br = driver.findElement(By.xpath("//*[@id=\"filefield-1216-button-fileInputEl\"]"));
	br.click();
	Thread.sleep(2000);
	//C:\Users\Public\Pictures\Sample Pictures
	WebElement ul = driver.findElement(By.xpath("//*[@id=\"button-1206-btnWrap\"]"));
	ul.click();
	Thread.sleep(2000);
	
}
@Test
public static void Addorg() throws InterruptedException {
	logger = report.startTest("Addorg");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	Thread.sleep(2000);
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(4000);
	Select self = new Select(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/span")));
	///html/body/div[1]/header/div/div[1]/div/div[2]/div[5]/ol/li/a
	 List<WebElement> dropdown = self.getOptions();
	 for (int i = 0; i < dropdown.size(); i++) {
	 String drop_down_values = dropdown.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("My Xero")) {
	 self.selectByIndex(i);
	 System.out.println("My Xero chosen");
	 }
	 }
	 Thread.sleep(3000);
	WebElement ao = driver.findElement(By.xpath("//*[@id=\"ext-gen1042\"]"));
	ao.click();
	Thread.sleep(2000);
	WebElement o = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div/div"));
	EnterText(o,"self1","Nameof organization");
	Thread.sleep(2000);
	 Select opt = new Select(driver.findElement(By.xpath("//*[@id=\"258ca223-6576-4fe1-93e6-bbdd3f4926df-control\"]")));
	 List<WebElement> dropdown1 = opt.getOptions();
	 for (int i = 0; i < dropdown1.size(); i++) {
	 String drop_down_values = dropdown1.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("United States")) {
	 opt.selectByIndex(i);
	 System.out.println("Organization Pay Taxes United States chosen");
	 }
	 }
	 Thread.sleep(3000);
	 Select tz = new Select(driver.findElement(By.xpath("//*[@id=\"6e53e54d-be50-4e23-8b27-ec667394ca53-control\"]")));
	 List<WebElement> dropdown2 = tz.getOptions();
	 for (int i = 0; i < dropdown2.size(); i++) {
	 String drop_down_values = dropdown2.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("(UTC-05:00) Eastern Time (US & Canada)")) {
	 tz.selectByIndex(i);
	 System.out.println("US & Canada chosen");
	 }
	 }
	 Thread.sleep(3000);
	 WebElement od = driver.findElement(By.xpath("//*[@id=\"f4f6899a-23b3-4389-8a0d-0e980333c459-control\"]"));
		EnterText(od,"Accounting","Organization Do");
		Thread.sleep(2000);
		WebElement st = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[8]/div/button[1]"));
		st.click();
		Thread.sleep(2000);
		
	 }
@Test
public static void AddorgPaidVersion() throws InterruptedException {
	logger = report.startTest("AddorgPaidVersion");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	Thread.sleep(2000);
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(4000);
	Select self = new Select(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/span")));
	///html/body/div[1]/header/div/div[1]/div/div[2]/div[5]/ol/li/a
	 List<WebElement> dropdown = self.getOptions();
	 for (int i = 0; i < dropdown.size(); i++) {
	 String drop_down_values = dropdown.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("My Xero")) {
	 self.selectByIndex(i);
	 System.out.println("My Xero chosen");
	 }
	 }
	 Thread.sleep(3000);
	WebElement ao = driver.findElement(By.xpath("//*[@id=\"ext-gen1042\"]"));
	ao.click();
	Thread.sleep(2000);
	WebElement o = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div/div"));
	EnterText(o,"self2","Nameof organization");
	Thread.sleep(2000);
	 Select opt = new Select(driver.findElement(By.xpath("//*[@id=\"258ca223-6576-4fe1-93e6-bbdd3f4926df-control\"]")));
	 List<WebElement> dropdown1 = opt.getOptions();
	 for (int i = 0; i < dropdown1.size(); i++) {
	 String drop_down_values = dropdown1.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("United States")) {
	 opt.selectByIndex(i);
	 System.out.println("Organization Pay Taxes United States chosen");
	 }
	 }
	 Thread.sleep(3000);
	 Select tz = new Select(driver.findElement(By.xpath("//*[@id=\"6e53e54d-be50-4e23-8b27-ec667394ca53-control\"]")));
	 List<WebElement> dropdown2 = tz.getOptions();
	 for (int i = 0; i < dropdown2.size(); i++) {
	 String drop_down_values = dropdown2.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("(UTC-05:00) Eastern Time (US & Canada)")) {
	 tz.selectByIndex(i);
	 System.out.println("US & Canada chosen");
	 }
	 }
	 Thread.sleep(3000);
	 WebElement od = driver.findElement(By.xpath("//*[@id=\"f4f6899a-23b3-4389-8a0d-0e980333c459-control\"]"));
		EnterText(od,"Accounting","Organization Do");
		Thread.sleep(2000);
		WebElement bn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/form/div[8]/div/button[1]"));
		bn.click();
		Thread.sleep(2000);
		
	 }
@Test
public static void AddorgStarterPlan() throws InterruptedException {
	logger = report.startTest("AddorgStarterPlan");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	Thread.sleep(2000);
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(4000);
	Select self = new Select(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/span")));
	///html/body/div[1]/header/div/div[1]/div/div[2]/div[5]/ol/li/a
	 List<WebElement> dropdown = self.getOptions();
	 for (int i = 0; i < dropdown.size(); i++) {
	 String drop_down_values = dropdown.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("My Xero")) {
	 self.selectByIndex(i);
	 System.out.println("My Xero chosen");
	 }
	 }
	 Thread.sleep(3000);
	WebElement ao = driver.findElement(By.xpath("//*[@id=\"ext-gen1042\"]"));
	ao.click();
	Thread.sleep(2000);
	WebElement o = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div/div"));
	EnterText(o,"self3","Nameof organization");
	Thread.sleep(2000);
	 Select opt = new Select(driver.findElement(By.xpath("//*[@id=\"258ca223-6576-4fe1-93e6-bbdd3f4926df-control\"]")));
	 List<WebElement> dropdown1 = opt.getOptions();
	 for (int i = 0; i < dropdown1.size(); i++) {
	 String drop_down_values = dropdown1.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("United States")) {
	 opt.selectByIndex(i);
	 System.out.println("Organization Pay Taxes United States chosen");
	 }
	 }
	 Thread.sleep(3000);
	 Select tz = new Select(driver.findElement(By.xpath("//*[@id=\"6e53e54d-be50-4e23-8b27-ec667394ca53-control\"]")));
	 List<WebElement> dropdown2 = tz.getOptions();
	 for (int i = 0; i < dropdown2.size(); i++) {
	 String drop_down_values = dropdown2.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("(UTC-05:00) Eastern Time (US & Canada)")) {
	 tz.selectByIndex(i);
	 System.out.println("US & Canada chosen");
	 }
	 }
	 Thread.sleep(3000);
	 WebElement od = driver.findElement(By.xpath("//*[@id=\"f4f6899a-23b3-4389-8a0d-0e980333c459-control\"]"));
		EnterText(od,"Accounting","Organization Do");
		Thread.sleep(2000);
		WebElement bn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/form/div[8]/div/button[1]"));
		bn.click();
		Thread.sleep(2000);
		List<WebElement> early=driver.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/section[1]/div[1]/div/label/div"));
	     early.get(0).click();
		WebElement c = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[4]/div/button/span"));
		c.click();
		Thread.sleep(2000);
		WebElement cn = driver.findElement(By.xpath("//*[@id=\"contactName\"]"));
		EnterText(cn, "S1", "Name To Bill");
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[4]/label/input"));
		EnterText(e, "ryrewards05@gmail.com", "email");
		Thread.sleep(1500);
		WebElement pn = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[5]/label/input"));
		EnterText(pn, "4084106418", "phoneno");
		Thread.sleep(2000);
		 Select country = new Select(driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[6]/label/span/select")));
				 List<WebElement> ddown = country.getOptions();
				 for (int i = 0; i < ddown.size(); i++) {
				 String drop_down_values = ddown.get(i).getText();
				 System.out.println("dropdown values are " + drop_down_values);
				 if (drop_down_values.equals("United States")) {
				 country.selectByIndex(i);
				 System.out.println("Country United States chosen");
				 }
				 }
				 Thread.sleep(3000);
		WebElement sn = driver.findElement(By.xpath("//*[@id=\"contactAddress\"]"));
		EnterText(sn, "3450 granada ave", "Street Name");
		Thread.sleep(2000);
		WebElement cy = driver.findElement(By.xpath("//*[@id=\"contactCity\"]"));
		EnterText(cy, "santa clara", "City");
		Thread.sleep(2000);
		Select state = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/div/div/div/form/div[5]/div[4]/div/button/div/span")));
		 List<WebElement> d1down = state.getOptions();
		 for (int i = 0; i < d1down.size(); i++) {
		 String drop_down_values = d1down.get(i).getText();
		 System.out.println("dropdown values are " + drop_down_values);
		 if (drop_down_values.equals("California")) {
		 state.selectByIndex(i);
		 System.out.println("States California chosen");
		 }
		 }
		 Thread.sleep(3000);
WebElement zc = driver.findElement(By.xpath("//*[@id=\"contactPostalCode\"]"));
EnterText(zc, "95051", "ZipCode");
Thread.sleep(2000);
WebElement cr = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/div/div/div/div/button/span"));
cr.click();
Thread.sleep(2000);
WebElement cr1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/label/span/span"));
cr1.click();
Thread.sleep(2000);
WebElement cno = driver.findElement(By.xpath("/html/body/div/form/span[2]/div/div[2]/span/input"));
EnterText(cno, "", "Card Number");
Thread.sleep(2000);
WebElement ed = driver.findElement(By.xpath("/html/body/div/form/span[2]/span/input"));
EnterText(ed, "", "Expiry Date");
Thread.sleep(2000);
WebElement sc = driver.findElement(By.xpath("/html/body/div/form/span[2]/span/input"));
EnterText(sc, "", "Security Code");
Thread.sleep(2000);
WebElement nc = driver.findElement(By.xpath("//*[@id=\"stripe-cardholder-name\"]"));
EnterText(nc, "", "Name on Card");
Thread.sleep(2000);
WebElement cp = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div[5]/button/span"));
cp.click();
Thread.sleep(2000);

	 }
@Test
public static void AddorgStandardPlan() throws InterruptedException {
	logger = report.startTest("AddorgStandardPlan");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	Thread.sleep(2000);
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(4000);
	Select self = new Select(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/span")));
	///html/body/div[1]/header/div/div[1]/div/div[2]/div[5]/ol/li/a
	 List<WebElement> dropdown = self.getOptions();
	 for (int i = 0; i < dropdown.size(); i++) {
	 String drop_down_values = dropdown.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("My Xero")) {
	 self.selectByIndex(i);
	 System.out.println("My Xero chosen");
	 }
	 }
	 Thread.sleep(3000);
	WebElement ao = driver.findElement(By.xpath("//*[@id=\"ext-gen1042\"]"));
	ao.click();
	Thread.sleep(2000);
	WebElement o = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div/div"));
	EnterText(o,"self4","Nameof organization");
	Thread.sleep(2000);
	 Select opt = new Select(driver.findElement(By.xpath("//*[@id=\"258ca223-6576-4fe1-93e6-bbdd3f4926df-control\"]")));
	 List<WebElement> dropdown1 = opt.getOptions();
	 for (int i = 0; i < dropdown1.size(); i++) {
	 String drop_down_values = dropdown1.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("United States")) {
	 opt.selectByIndex(i);
	 System.out.println("Organization Pay Taxes United States chosen");
	 }
	 }
	 Thread.sleep(3000);
	 Select tz = new Select(driver.findElement(By.xpath("//*[@id=\"6e53e54d-be50-4e23-8b27-ec667394ca53-control\"]")));
	 List<WebElement> dropdown2 = tz.getOptions();
	 for (int i = 0; i < dropdown2.size(); i++) {
	 String drop_down_values = dropdown2.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("(UTC-05:00) Eastern Time (US & Canada)")) {
	 tz.selectByIndex(i);
	 System.out.println("US & Canada chosen");
	 }
	 }
	 Thread.sleep(3000);
	 WebElement od = driver.findElement(By.xpath("//*[@id=\"f4f6899a-23b3-4389-8a0d-0e980333c459-control\"]"));
		EnterText(od,"Accounting","Organization Do");
		Thread.sleep(2000);
		WebElement bn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/form/div[8]/div/button[1]"));
		bn.click();
		Thread.sleep(2000);
		List<WebElement> early=driver.findElements(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/section[1]/div[1]/div/label/div"));
	     early.get(1).click();
		WebElement c = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[4]/div/button/span"));
		c.click();
		Thread.sleep(2000);
		WebElement cn = driver.findElement(By.xpath("//*[@id=\"contactName\"]"));
		EnterText(cn, "S1", "Name To Bill");
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[4]/label/input"));
		EnterText(e, "ryrewards05@gmail.com", "email");
		Thread.sleep(1500);
		WebElement pn = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[5]/label/input"));
		EnterText(pn, "4084106418", "phoneno");
		Thread.sleep(2000);
		 Select country = new Select(driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[6]/label/span/select")));
				 List<WebElement> ddown = country.getOptions();
				 for (int i = 0; i < ddown.size(); i++) {
				 String drop_down_values = ddown.get(i).getText();
				 System.out.println("dropdown values are " + drop_down_values);
				 if (drop_down_values.equals("United States")) {
				 country.selectByIndex(i);
				 System.out.println("Country United States chosen");
				 }
				 }
				 Thread.sleep(3000);
		WebElement sn = driver.findElement(By.xpath("//*[@id=\"contactAddress\"]"));
		EnterText(sn, "3450 granada ave", "Street Name");
		Thread.sleep(2000);
		WebElement cy = driver.findElement(By.xpath("//*[@id=\"contactCity\"]"));
		EnterText(cy, "santa clara", "City");
		Thread.sleep(2000);
		Select state = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/div/div/div/form/div[5]/div[4]/div/button/div/span")));
		 List<WebElement> d1down = state.getOptions();
		 for (int i = 0; i < d1down.size(); i++) {
		 String drop_down_values = d1down.get(i).getText();
		 System.out.println("dropdown values are " + drop_down_values);
		 if (drop_down_values.equals("California")) {
		 state.selectByIndex(i);
		 System.out.println("States California chosen");
		 }
		 }
		 Thread.sleep(3000);
WebElement zc = driver.findElement(By.xpath("//*[@id=\"contactPostalCode\"]"));
EnterText(zc, "95051", "ZipCode");
Thread.sleep(2000);
WebElement cr = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/div/div/div/div/button/span"));
cr.click();
Thread.sleep(2000);
WebElement cr1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/label/span/span"));
cr1.click();
Thread.sleep(2000);
WebElement cno = driver.findElement(By.xpath("/html/body/div/form/span[2]/div/div[2]/span/input"));
EnterText(cno, "", "Card Number");
Thread.sleep(2000);
WebElement ed = driver.findElement(By.xpath("/html/body/div/form/span[2]/span/input"));
EnterText(ed, "", "Expiry Date");
Thread.sleep(2000);
WebElement sc = driver.findElement(By.xpath("/html/body/div/form/span[2]/span/input"));
EnterText(sc, "", "Security Code");
Thread.sleep(2000);
WebElement nc = driver.findElement(By.xpath("//*[@id=\"stripe-cardholder-name\"]"));
EnterText(nc, "", "Name on Card");
Thread.sleep(2000);
WebElement cp = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div[5]/button/span"));
cp.click();
Thread.sleep(2000);

	 }
@Test
	public static void AddorgPremiumPlan() throws InterruptedException {
		logger = report.startTest("AddorgPremiumPlan");
		OpenUrl("https://login.xero.com");
		logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.id("email"));
		EnterText(un, "rajyok05@gmail.com", "UserName");
		Thread.sleep(2000);
		WebElement pwd = driver.findElement(By.id("password"));
		EnterText(pwd, "tekarch123", "PW");
		Thread.sleep(2000);
		WebElement lbtn = driver.findElement(By.id("submitButton"));
		lbtn.click();
		Thread.sleep(4000);
		Select self = new Select(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/span")));
		/// html/body/div[1]/header/div/div[1]/div/div[2]/div[5]/ol/li/a
		List<WebElement> dropdown = self.getOptions();
		for (int i = 0; i < dropdown.size(); i++) {
			String drop_down_values = dropdown.get(i).getText();
			System.out.println("dropdown values are " + drop_down_values);
			if (drop_down_values.equals("My Xero")) {
				self.selectByIndex(i);
				System.out.println("My Xero chosen");
			}
		}
		Thread.sleep(3000);
		WebElement ao = driver.findElement(By.xpath("//*[@id=\"ext-gen1042\"]"));
		ao.click();
		Thread.sleep(2000);
		WebElement o = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div/div"));
		EnterText(o, "self3", "Nameof organization");
		Thread.sleep(2000);
		Select opt = new Select(
				driver.findElement(By.xpath("//*[@id=\"258ca223-6576-4fe1-93e6-bbdd3f4926df-control\"]")));
		List<WebElement> dropdown1 = opt.getOptions();
		for (int i = 0; i < dropdown1.size(); i++) {
			String drop_down_values = dropdown1.get(i).getText();
			System.out.println("dropdown values are " + drop_down_values);
			if (drop_down_values.equals("United States")) {
				opt.selectByIndex(i);
				System.out.println("Organization Pay Taxes United States chosen");
			}
		}
		Thread.sleep(3000);
		Select tz = new Select(
				driver.findElement(By.xpath("//*[@id=\"6e53e54d-be50-4e23-8b27-ec667394ca53-control\"]")));
		List<WebElement> dropdown2 = tz.getOptions();
		for (int i = 0; i < dropdown2.size(); i++) {
			String drop_down_values = dropdown2.get(i).getText();
			System.out.println("dropdown values are " + drop_down_values);
			if (drop_down_values.equals("(UTC-05:00) Eastern Time (US & Canada)")) {
				tz.selectByIndex(i);
				System.out.println("US & Canada chosen");
			}
		}
		Thread.sleep(3000);
		WebElement od = driver.findElement(By.xpath("//*[@id=\"f4f6899a-23b3-4389-8a0d-0e980333c459-control\"]"));
		EnterText(od, "Accounting", "Organization Do");
		Thread.sleep(2000);
		WebElement bn = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/form/div[8]/div/button[1]"));
		bn.click();
		Thread.sleep(2000);
		List<WebElement> early = driver.findElements(
				By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/section[1]/div[1]/div/label/div"));
		early.get(2).click();
		WebElement c = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[4]/div/button/span"));
		c.click();
		Thread.sleep(2000);
		WebElement cn = driver.findElement(By.xpath("//*[@id=\"contactName\"]"));
		EnterText(cn, "S1", "Name To Bill");
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[4]/label/input"));
		EnterText(e, "ryrewards05@gmail.com", "email");
		Thread.sleep(1500);
		WebElement pn = driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[5]/label/input"));
		EnterText(pn, "4084106418", "phoneno");
		Thread.sleep(2000);
		Select country = new Select(
				driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/form/div[6]/label/span/select")));
		List<WebElement> ddown = country.getOptions();
		for (int i = 0; i < ddown.size(); i++) {
			String drop_down_values = ddown.get(i).getText();
			System.out.println("dropdown values are " + drop_down_values);
			if (drop_down_values.equals("United States")) {
				country.selectByIndex(i);
				System.out.println("Country United States chosen");
			}
		}
		Thread.sleep(3000);
		WebElement sn = driver.findElement(By.xpath("//*[@id=\"contactAddress\"]"));
		EnterText(sn, "3450 granada ave", "Street Name");
		Thread.sleep(2000);
		WebElement cy = driver.findElement(By.xpath("//*[@id=\"contactCity\"]"));
		EnterText(cy, "santa clara", "City");
		Thread.sleep(2000);
		Select state = new Select(driver.findElement(By.xpath(
				"/html/body/div[2]/div/div/div/div[2]/div[3]/div/div/div/form/div[5]/div[4]/div/button/div/span")));
		List<WebElement> d1down = state.getOptions();
		for (int i = 0; i < d1down.size(); i++) {
			String drop_down_values = d1down.get(i).getText();
			System.out.println("dropdown values are " + drop_down_values);
			if (drop_down_values.equals("California")) {
				state.selectByIndex(i);
				System.out.println("States California chosen");
			}
		}
		Thread.sleep(3000);
		WebElement zc = driver.findElement(By.xpath("//*[@id=\"contactPostalCode\"]"));
		EnterText(zc, "95051", "ZipCode");
		Thread.sleep(2000);
		WebElement cr = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/div/div/div/div/button/span"));
		cr.click();
		Thread.sleep(2000);
		WebElement cr1 = driver.findElement(By.xpath(
				"/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/label/span/span"));
		cr1.click();
		Thread.sleep(2000);
		WebElement cno = driver.findElement(By.xpath("/html/body/div/form/span[2]/div/div[2]/span/input"));
		EnterText(cno, "", "Card Number");
		Thread.sleep(2000);
		WebElement ed = driver.findElement(By.xpath("/html/body/div/form/span[2]/span/input"));
		EnterText(ed, "", "Expiry Date");
		Thread.sleep(2000);
		WebElement sc = driver.findElement(By.xpath("/html/body/div/form/span[2]/span/input"));
		EnterText(sc, "", "Security Code");
		Thread.sleep(2000);
		WebElement nc = driver.findElement(By.xpath("//*[@id=\"stripe-cardholder-name\"]"));
		EnterText(nc, "", "Name on Card");
		Thread.sleep(2000);
		WebElement cp = driver.findElement(By
				.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div[5]/button/span"));
		cp.click();
		Thread.sleep(2000);

	}
@Test
public static void AddorgQuickBooks8f() throws InterruptedException {
	logger = report.startTest("AddorgQuickBooks8f");
	OpenUrl("https://login.xero.com");
	logger.log(LogStatus.INFO, "URL OPEN SUCCESSFULLY");
	Thread.sleep(2000);
	WebElement un = driver.findElement(By.id("email"));
	EnterText(un, "rajyok05@gmail.com", "UserName");
	Thread.sleep(2000);
	WebElement pwd = driver.findElement(By.id("password"));
	EnterText(pwd, "tekarch123", "PW");
	Thread.sleep(2000);
	WebElement lbtn = driver.findElement(By.id("submitButton"));
	lbtn.click();
	Thread.sleep(4000);
	Select self = new Select(driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/button/div/span")));
	///html/body/div[1]/header/div/div[1]/div/div[2]/div[5]/ol/li/a
	 List<WebElement> dropdown = self.getOptions();
	 for (int i = 0; i < dropdown.size(); i++) {
	 String drop_down_values = dropdown.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("My Xero")) {
	 self.selectByIndex(i);
	 System.out.println("My Xero chosen");
	 }
	 }
	 Thread.sleep(3000);
	WebElement ao = driver.findElement(By.xpath("//*[@id=\"ext-gen1042\"]"));
	ao.click();
	Thread.sleep(2000);
	WebElement o = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div/div"));
	EnterText(o,"self5","Nameof organization");
	Thread.sleep(2000);
	 Select opt = new Select(driver.findElement(By.xpath("//*[@id=\"258ca223-6576-4fe1-93e6-bbdd3f4926df-control\"]")));
	 List<WebElement> dropdown1 = opt.getOptions();
	 for (int i = 0; i < dropdown1.size(); i++) {
	 String drop_down_values = dropdown1.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("United States")) {
	 opt.selectByIndex(i);
	 System.out.println("Organization Pay Taxes United States chosen");
	 }
	 }
	 Thread.sleep(3000);
	 Select tz = new Select(driver.findElement(By.xpath("//*[@id=\"6e53e54d-be50-4e23-8b27-ec667394ca53-control\"]")));
	 List<WebElement> dropdown2 = tz.getOptions();
	 for (int i = 0; i < dropdown2.size(); i++) {
	 String drop_down_values = dropdown2.get(i).getText();
	 System.out.println("dropdown values are " + drop_down_values);
	 if (drop_down_values.equals("(UTC-05:00) Eastern Time (US & Canada)")) {
	 tz.selectByIndex(i);
	 System.out.println("US & Canada chosen");
	 }
	 }
	 Thread.sleep(3000);
	 WebElement od = driver.findElement(By.xpath("//*[@id=\"f4f6899a-23b3-4389-8a0d-0e980333c459-control\"]"));
		EnterText(od,"Accounting","Organization Do");
		Thread.sleep(2000);
		WebElement qbf = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[7]/div/div/div[1]/div[2]/div/div/div"));
		qbf.click();
		Thread.sleep(2000);
		WebElement qb = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[7]/div/div/div[2]/div/div[2]/div/div/div/label/div"));
		qb.click();
		Thread.sleep(2000);
		WebElement bn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/form/div[8]/div/button[1]"));
		bn.click();
		Thread.sleep(2000);
}
@AfterClass
public static void CloseBrowser() {
	driver.quit();
}
}