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
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import java.util.Arrays

// --- LOGIN SECTION (Unchanged) ---
WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')
WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), '00dfj00000fdkisuah_john1234@yopmail.com')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'OJK6S0ghyhhqC323vSRvDg==')
WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// --- Post-login actions with visibility + fallback ---
WebUI.waitForPageLoad(30)
WebUI.delay(3)

// Click "Parts Compliance"
TestObject partsTab = findTestObject('Object Repository/Page_My Company  Salesforce/span_Parts Compliance')
WebUI.waitForElementVisible(partsTab, 10)
WebUI.waitForElementClickable(partsTab, 10)
try {
    WebUI.click(partsTab)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(partsTab, 10)
    WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(el))
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}

// Click "New"
TestObject newBtn = findTestObject('Object Repository/Page_Parts Compliance  Salesforce/div_New')
WebUI.waitForElementVisible(newBtn, 10)
WebUI.waitForElementClickable(newBtn, 10)
try {
    WebUI.click(newBtn)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(newBtn, 10)
    WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(el))
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}

// Click "Material" radio
TestObject materialRadio = findTestObject('Object Repository/Page_New Product  Salesforce/span_Material_slds-radio--faux')
WebUI.waitForElementVisible(materialRadio, 10)
WebUI.waitForElementClickable(materialRadio, 10)
try {
    WebUI.click(materialRadio)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(materialRadio, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}

// Click "Next"
TestObject nextBtn = findTestObject('Object Repository/Page_New Product  Salesforce/button_Next')
WebUI.waitForElementVisible(nextBtn, 10)
WebUI.waitForElementClickable(nextBtn, 10)
try {
    WebUI.click(nextBtn)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(nextBtn, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}

// Fill "Name" field
TestObject nameInput = findTestObject('Object Repository/Page_New Product Parts  Salesforce/input__Name')
WebUI.waitForElementVisible(nameInput, 10)
WebUI.setText(nameInput, 'katalon')

// Click "Status" dropdown
TestObject statusDropdown = findTestObject('Object Repository/Page_New Product Parts  Salesforce/button_--None--')
WebUI.waitForElementVisible(statusDropdown, 10)
WebUI.waitForElementClickable(statusDropdown, 10)
try {
    WebUI.click(statusDropdown)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(statusDropdown, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}

// Select "Active" option
TestObject activeOption = findTestObject('Object Repository/Page_New Product Parts  Salesforce/span_Active')
WebUI.waitForElementVisible(activeOption, 10)
WebUI.waitForElementClickable(activeOption, 10)
try {
    WebUI.click(activeOption)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(activeOption, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}

// Click "Save"
TestObject saveBtn = findTestObject('Object Repository/Page_New Product Parts  Salesforce/button_Save')
WebUI.waitForElementVisible(saveBtn, 10)
WebUI.waitForElementClickable(saveBtn, 10)
try {
    WebUI.click(saveBtn)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(saveBtn, 10)
    WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(el))
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}
