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
import java.util.Arrays

// -------- Login --------
WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')

WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'),
    '00dfj00000fdkisuah_john1234@yopmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'),
    'OJK6S0ghyhhqC323vSRvDg==')

WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// -------- Navigate to Permit Tab --------
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_My Company  Salesforce/span_More'), 15)
WebUI.click(findTestObject('Object Repository/Page_My Company  Salesforce/span_More'))
WebUI.delay(2)

TestObject permitLink = findTestObject('Object Repository/Page_My Company  Salesforce/a_Permit')
WebUI.waitForElementVisible(permitLink, 10)
WebUI.waitForElementClickable(permitLink, 10)
WebElement permitElement = WebUI.findWebElement(permitLink, 10)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(permitElement))

// -------- License Creation Flow --------
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Permit  Salesforce/span_Create Permit'), 10)
WebUI.click(findTestObject('Object Repository/Page_Permit  Salesforce/span_Create Permit'))

WebUI.delay(2)
WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('Object Repository/Page_New Permit  Salesforce/span_Certification_slds-radio--faux'))
WebUI.click(findTestObject('Object Repository/Page_New Permit  Salesforce/span_Next'))

WebUI.setText(findTestObject('Object Repository/Page_New Permit License  Salesforce/input__Rhythm__Number__c'), 'fgvsef')
WebUI.setText(findTestObject('Object Repository/Page_New Permit License  Salesforce/input__Rhythm__Permit_Name__c'), 'sayoni')

// -------- Fix: Date Picker Click Issue --------
TestObject issueDateIcon = findTestObject('Object Repository/Page_New Permit License  Salesforce/lightning-primitive-icon')
WebElement dateElement = WebUI.findWebElement(issueDateIcon, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(dateElement))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(dateElement))
WebUI.delay(1)

TestObject dateCell = findTestObject('Object Repository/Page_New Permit License  Salesforce/span_22')
WebUI.waitForElementVisible(dateCell, 10)
WebUI.waitForElementClickable(dateCell, 10)
WebUI.scrollToElement(dateCell, 5)
WebElement dateSpan = WebUI.findWebElement(dateCell, 10)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(dateSpan))

// -------- Select Category --------
TestObject categoryButton = findTestObject('Object Repository/Page_New Permit License  Salesforce/button_--None--')
WebElement categoryElement = WebUI.findWebElement(categoryButton, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(categoryElement))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(categoryElement))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Page_New Permit License  Salesforce/span_Business License'))

// -------- Select Type --------
WebUI.click(findTestObject('Object Repository/Page_New Permit License  Salesforce/button_--None--_1'))
WebUI.click(findTestObject('Object Repository/Page_New Permit License  Salesforce/lightning-base-combobox-item_Non-Renewable'))

// -------- Set Status and Expiration --------
WebUI.click(findTestObject('Object Repository/Page_New Permit License  Salesforce/button_Draft'))
WebUI.click(findTestObject('Object Repository/Page_New Permit License  Salesforce/span_Expired'))

// -------- Save --------
WebUI.click(findTestObject('Object Repository/Page_New Permit License  Salesforce/button_Save'))

// -------- Close Browser --------
WebUI.closeBrowser()
