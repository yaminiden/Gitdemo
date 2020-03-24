import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class XReusable {
	static ExtentTest logger;
	static ExtentReports report;
	static WebDriver driver;
			public static void OpenUrl(String url) {
				driver.get(url);
			}
			public static void CloseReport() {
				report.flush();
			}
	/*	public static void OpenUrl(String url) {
			driver.get(url);
			// driver.manage().window().maximize();
		}

			public static void CloseBrowser() {
			driver.quit();
		}

		public static void CloseReport() {
			report.flush();
		}*/
	public static void CreateReport() {
		String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmm'.html'").format(new Date());
		String path = "C:\\Users\\rrajaram\\yamini\\Xero\\test-output\\Suite\\" + fileName;
		report = new ExtentReports(path);
	}
	public static void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Textbox is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Textbox is found");
			element.sendKeys(text);
		}
	}

	public static void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName + " Element is not found.");
		} else {
			logger.log(LogStatus.INFO, objName + " Element is found");
			element.click();
		}
	}
}
