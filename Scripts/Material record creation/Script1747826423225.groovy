import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

Map<String, Object> prefs = new HashMap<>()
prefs.put("profile.default_content_setting_values.notifications", 2)

List<String> arguments = [
	"--disable-notifications",
	"--start-maximized",
	"--disable-infobars"
]

ChromeOptions options = new ChromeOptions()
options.setExperimentalOption("prefs", prefs)
options.addArguments(arguments)

RunConfiguration.setWebDriverPreferencesProperty("prefs", prefs)
RunConfiguration.setWebDriverPreferencesProperty("args", arguments)

WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), '00dfj00000fdkisuah_john1234@yopmail.com')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'OJK6S0ghyhhqC323vSRvDg==')
WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// Click on Parts Compliance tab
TestObject partsTab = findTestObject('Object Repository/Page_My Company  Salesforce/span_Parts Compliance')
WebUI.waitForElementClickable(partsTab, 10)
try {
    WebUI.click(partsTab)
} catch (Exception e) {
    WebElement element = WebUI.findWebElement(partsTab, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(element))
}

// Click New button
TestObject newBtn = findTestObject('null')
WebUI.waitForElementClickable(newBtn, 10)
WebElement newBtnElem = WebUI.findWebElement(newBtn, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(newBtnElem))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(newBtnElem))

// Click Next button
TestObject nextBtn = findTestObject('Object Repository/Page_New Product  Salesforce/span_Next')
WebUI.waitForElementClickable(nextBtn, 10)
WebElement nextElem = WebUI.findWebElement(nextBtn, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(nextElem))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(nextElem))

// Fill out form
TestObject nameFieldTO = findTestObject('Object Repository/Page_New Product Material  Salesforce/input__Name')
WebElement nameField = WebUI.findWebElement(nameFieldTO, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(nameField))
WebUI.executeJavaScript("arguments[0].focus();", Arrays.asList(nameField))
nameField.sendKeys('dffdf')

TestObject statusDropdown = findTestObject('Object Repository/Page_New Product Material  Salesforce/button_--None--')
WebUI.waitForElementClickable(statusDropdown, 10)
WebElement statusDropdownElem = WebUI.findWebElement(statusDropdown, 10)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(statusDropdownElem))

TestObject activeOption = findTestObject('Object Repository/Page_New Product Material  Salesforce/span_Active')
WebUI.waitForElementClickable(activeOption, 10)
WebElement activeElem = WebUI.findWebElement(activeOption, 10)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(activeElem))

TestObject saveBtn = findTestObject('Object Repository/Page_New Product Material  Salesforce/button_Save')
WebUI.waitForElementClickable(saveBtn, 10)
WebElement saveBtnElem = WebUI.findWebElement(saveBtn, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(saveBtnElem))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(saveBtnElem))

WebUI.closeBrowser()