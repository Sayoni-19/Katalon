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

WebUI.click(findTestObject('Object Repository/Page_Permit  Salesforce/span_Permit List'))

WebUI.switchToWindowTitle('All | Permits | Salesforce')

WebUI.click(findTestObject('Object Repository/Page_All  Permits  Salesforce/a_Certification3'))

WebUI.click(findTestObject('Object Repository/Page_RI-Permit-0024  Permit  Salesforce/a_Tasks'))

WebUI.click(findTestObject('Object Repository/Page_RI-Permit-0024  Permit  Salesforce/button_New Task'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/input__combobox-input-273'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/span_Call'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/input_Due Date_input-280'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/lightning-primitive-icon'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/span_23'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/a_Normal'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/a_High'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/a_High_1'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_RI-Permit-0024  Permit  Salesforce/a_Tasks'))

