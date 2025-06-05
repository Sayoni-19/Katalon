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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebElement

WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), '00dfj00000fdkisuah_john1234@yopmail.com')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'OJK6S0ghyhhqC323vSRvDg==')
WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// Click Permit tab using JavaScript workaround
TestObject permitTab = findTestObject('Object Repository/Page_My Company  Salesforce/span_Permit')
WebUI.waitForElementVisible(permitTab, 15)
WebElement permitElement = WebUI.findWebElement(permitTab, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(permitElement))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(permitElement))

WebUI.click(findTestObject('Object Repository/Page_Permit  Salesforce/span_Create Permit'))
WebUI.switchToWindowTitle('New Permit | Salesforce')
WebUI.click(findTestObject('Object Repository/Page_New Permit  Salesforce/span_Next'))

WebUI.setText(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/input__Rhythm__Number__c'), ' vx bnxvcnbv')
WebUI.setText(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/input__Rhythm__Permit_Name__c'), 'bxnxcvnxn ')

WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/input__Rhythm__Issue_Date__c'))
WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/span_21'))

// Handle intercepted click on Category dropdown via JavaScript
TestObject categoryDropdown = findTestObject('Object Repository/Page_New Permit Certification  Salesforce/div_Category--None--')
WebElement categoryElement = WebUI.findWebElement(categoryDropdown, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(categoryElement))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(categoryElement))

WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_--None--'))
WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/span_Import licensed product'))

WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_--None--_1'))
WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/span_Renewable'))

WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_Draft'))
WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/lightning-base-combobox-item_Active'))
WebUI.click(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_Save'))