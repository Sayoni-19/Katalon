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

// --- LOGIN SECTION --- DO NOT MODIFY
WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')
WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), '00dfj00000fdkisuah_john1234@yopmail.com')
WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'Rhythm@123')
WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// --- POST-LOGIN SECTION --- Updated for reliability
WebUI.waitForPageLoad(30)
WebUI.delay(3)

// Click on Parts Compliance tab
TestObject partsTab = findTestObject('Object Repository/Page_My Company  Salesforce/span_Parts Compliance')
WebUI.waitForElementClickable(partsTab, 15)
try {
    WebUI.click(partsTab)
} catch (Exception e) {
    WebElement partsElement = WebUI.findWebElement(partsTab, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(partsElement))
}

// Click New button
TestObject newBtn = findTestObject('Object Repository/Page_Parts Compliance  Salesforce/div_New')
WebUI.waitForElementClickable(newBtn, 15)
try {
    WebUI.click(newBtn)
} catch (Exception e) {
    WebElement newBtnElem = WebUI.findWebElement(newBtn, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(newBtnElem))
}

// Click Next
TestObject nextBtn = findTestObject('Object Repository/Page_New Product  Salesforce/span_Next')
WebUI.waitForElementClickable(nextBtn, 15)
try {
    WebUI.click(nextBtn)
} catch (Exception e) {
    WebElement nextElem = WebUI.findWebElement(nextBtn, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(nextElem))
}

// Enter Product Name
TestObject nameField = findTestObject('Object Repository/Page_New Product Material  Salesforce/input__Name')
WebUI.waitForElementVisible(nameField, 15)
WebElement nameInput = WebUI.findWebElement(nameField, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(nameInput))
WebUI.executeJavaScript("arguments[0].focus();", Arrays.asList(nameInput))
nameInput.sendKeys("hskdjcbjk")

// Click Status Dropdown
TestObject statusDropdown = findTestObject('Object Repository/Page_New Product Material  Salesforce/button_--None--')
WebUI.waitForElementClickable(statusDropdown, 15)
try {
    WebUI.click(statusDropdown)
} catch (Exception e) {
    WebElement dropdownElem = WebUI.findWebElement(statusDropdown, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(dropdownElem))
}

// Select "Available" option
TestObject availableOption = findTestObject('Object Repository/Page_New Product Material  Salesforce/span_Available')
WebUI.waitForElementClickable(availableOption, 15)
try {
    WebUI.click(availableOption)
} catch (Exception e) {
    WebElement availableElem = WebUI.findWebElement(availableOption, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(availableElem))
}

// Click Save
TestObject saveBtn = findTestObject('Object Repository/Page_New Product Material  Salesforce/button_Save')
WebUI.waitForElementClickable(saveBtn, 15)
try {
    WebUI.click(saveBtn)
} catch (Exception e) {
    WebElement saveElem = WebUI.findWebElement(saveBtn, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(saveElem))
}

// Click Attachments tab
TestObject attachmentsTab = findTestObject('Object Repository/Page_hskdjcbjk  Product  Salesforce/a_Attachments')
WebUI.waitForElementClickable(attachmentsTab, 15)
try {
    WebUI.click(attachmentsTab)
} catch (Exception e) {
    WebElement attachElem = WebUI.findWebElement(attachmentsTab, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(attachElem))
}

// Click Related tab
TestObject relatedTab = findTestObject('Object Repository/Page_hskdjcbjk  Product  Salesforce/a_Related')
WebUI.waitForElementClickable(relatedTab, 15)
try {
    WebUI.click(relatedTab)
} catch (Exception e) {
    WebElement relatedElem = WebUI.findWebElement(relatedTab, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(relatedElem))
}