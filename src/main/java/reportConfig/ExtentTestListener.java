package reportConfig;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import commons.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static reportConfig.ExtentTestManager.getTest;

public class ExtentTestListener extends BaseTest implements ITestListener {

	@Override
	public void onStart(ITestContext iTestContext) {
		iTestContext.setAttribute("WebDriver", this.getDriver());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		ExtentManager.extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		getTest().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() + " - Passed", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();

		String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		getTest().log(Status.FAIL, "Screenshot and Exception", iTestResult.getThrowable(), getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
		getTest().log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " - Failed", ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		getTest().log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName() + " - Skipped", ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		getTest().log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " - Failed with Percentage", ExtentColor.RED));
	}
}