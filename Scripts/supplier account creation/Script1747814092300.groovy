import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// === Chrome Configuration: Disable Notifications ===
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

// === Start Test ===

WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')

// === Login ===
WebUI.setText(findTestObject('Object Repository/supplier creation/Page_Login  Salesforce/input_Username_username'), 
    '00dfj00000fdkisuah_john1234@yopmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/supplier creation/Page_Login  Salesforce/input_Password_pw'), 
    'OJK6S0ghyhhqC323vSRvDg==')

WebUI.click(findTestObject('Object Repository/supplier creation/Page_Login  Salesforce/input_Password_Login'))

// === Click "Suppliers" with JS fallback ===
TestObject supplierTab = findTestObject('Object Repository/supplier creation/Page_My Company  Salesforce/span_Suppliers')
WebUI.waitForElementClickable(supplierTab, 10)

try {
    WebUI.click(supplierTab)
} catch (Exception e) {
    WebElement element = WebUI.findWebElement(supplierTab, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(element))
}

// === Handle "New" Button Interception Safely ===
TestObject newButton = findTestObject('Object Repository/supplier creation/Page_Suppliers  Salesforce/div_New')
WebUI.waitForElementVisible(newButton, 15)
WebUI.waitForElementClickable(newButton, 15)

WebElement newButtonElement = WebUI.findWebElement(newButton, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(newButtonElement))

try {
    WebUI.click(newButton)
} catch (Exception e) {
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(newButtonElement))
}

// === Supplier Creation Steps ===
WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account  Salesforce/span_Supplier'))

// === Updated Click for "Next" Button ===
TestObject nextButtonTO = findTestObject('Object Repository/supplier creation/Page_New Account  Salesforce/button_Next')
WebUI.waitForElementVisible(nextButtonTO, 20)
WebUI.waitForElementClickable(nextButtonTO, 20)
WebElement nextButton = WebUI.findWebElement(nextButtonTO, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(nextButton))

try {
    nextButton.click()
} catch (Exception e) {
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(nextButton))
}

// === Fallback for missing Name field ===
WebElement nameField = WebUI.findWebElement(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/input__Name'), 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(nameField))
WebUI.executeJavaScript("arguments[0].focus();", Arrays.asList(nameField))
nameField.sendKeys('okok')

WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/button_--None--'))
WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/span_Indirect'))

WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/button_New'))
WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/span_Pending'))

WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/button_--None--_1'))
WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/span_Construction'))

WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/input_Billing Address_combobox-input-433'))

WebUI.setText(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/input_Billing City_city'), 'sfsf')
WebUI.setText(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/input_Billing StateProvince_province'), 'sffsf')
WebUI.setText(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/input_Billing ZipPostal Code_postalCode'), 'dfgdg')
WebUI.setText(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/input_Billing Country_country'), 'gfdg')

WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/input_Shipping Address same as Billing Addr_101001'))

WebUI.click(findTestObject('Object Repository/supplier creation/Page_New Account Supplier  Salesforce/button_Save'))

WebUI.closeBrowser()
