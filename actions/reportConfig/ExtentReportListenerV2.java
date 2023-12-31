// package reportConfig;
//
// import java.io.File;
// import java.util.Calendar;
// import java.util.Date;
// import java.util.List;
// import java.util.Map;
//
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.testng.IReporter;
// import org.testng.IResultMap;
// import org.testng.ISuite;
// import org.testng.ISuiteResult;
// import org.testng.ITestContext;
// import org.testng.ITestListener;
// import org.testng.ITestResult;
// import org.testng.Reporter;
// import org.testng.xml.XmlSuite;
// import com.relevantcodes.extentreports.ExtentReports;
// import com.relevantcodes.extentreports.ExtentTest;
// import com.relevantcodes.extentreports.LogStatus;
//
// import commons.BaseTest;
//
// public class ExtentReportListenerV2 extends BaseTest implements ITestListener {
// private ExtentReports extent;
// private ExtentTest test;
//
// public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
// extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReportV2/ExtentReport.html", true);
// for (ISuite suite : suites) {
// Map<String, ISuiteResult> result = suite.getResults();
//
// for (ISuiteResult r : result.values()) {
// ITestContext context = r.getTestContext();
// buildTestNodes(context.getPassedTests(), LogStatus.PASS);
// buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
// buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
// }
// }
// extent.flush();
// extent.close();
// }
//
// private void buildTestNodes(IResultMap tests, LogStatus status) {
// if (tests.size() > 0) {
// for (ITestResult result : tests.getAllResults()) {
// test = extent.startTest(result.getMethod().getMethodName());
//
// test.setStartedTime(getTime(result.getStartMillis()));
// test.setEndedTime(getTime(result.getEndMillis()));
//
// for (String group : result.getMethod().getGroups())
// test.assignCategory(group);
//
// if (result.getThrowable() != null) {
// test.log(status, result.getThrowable());
// } else {
// test.log(status, "Test " + status.toString().toLowerCase() + "ed");
// }
//
// extent.endTest(test);
// }
// }
// }
//
// private Date getTime(long millis) {
// Calendar calendar = Calendar.getInstance();
// calendar.setTimeInMillis(millis);
// return calendar.getTime();
// }
//
// public void extendLog(String message) {
// test.log(LogStatus.INFO, message);
// Reporter.log(message);
// }
//
// @Override
// public void onStart(ITestContext context) {
// context.setAttribute("WebDriver", this.getDriverInstance());
// }
//
// @Override
// public void onFinish(ITestContext context) {
// ExtentManager.endTest();
// ExtentManager.getReporter().flush();
// }
//
// @Override
// public void onTestStart(ITestResult result) {
//
// }
//
// @Override
// public void onTestSuccess(ITestResult result) {
// ExtentManager.getTest().log(LogStatus.PASS, "Test Passed");
// }
//
// @Override
// public void onTestFailure(ITestResult result) {
// Object testClass = result.getInstance();
// WebDriver webDriver = ((BaseTest) testClass).getDriverInstance();
// String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
// ExtentManager.getTest().log(LogStatus.FAIL, "Test Failed", ExtentManager.getTest().addBase64ScreenShot(base64Screenshot));
// }
//
// @Override
// public void onTestSkipped(ITestResult result) {
// ExtentManager.getTest().log(LogStatus.SKIP, "Test Skipped");
// }
//
// @Override
// public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// }
//
// }