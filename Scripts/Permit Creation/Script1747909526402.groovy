import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
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
WebElement permitEl = WebUI.findWebElement(permitLink, 10)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(permitEl))

// -------- Click Create Permit --------
TestObject createPermit = findTestObject('Object Repository/Page_Permit  Salesforce/span_Create Permit')
WebUI.waitForElementVisible(createPermit, 10)
WebUI.click(createPermit)

WebUI.delay(2)
WebUI.switchToWindowIndex(1)

// -------- Fill Permit Form --------
WebUI.click(findTestObject('Object Repository/Page_New Permit  Salesforce/span_License_slds-radio--faux'))
WebUI.click(findTestObject('Object Repository/Page_New Permit  Salesforce/span_Next (1)'))

WebUI.setText(findTestObject('Object Repository/Page_New Permit Permit  Salesforce/input__Rhythm__Number__c'), 'fhndn')
WebUI.setText(findTestObject('Object Repository/Page_New Permit Permit  Salesforce/input__Rhythm__Permit_Name__c'), 'nffdn')

// --- Click Date Picker Icon ---
TestObject dateIcon = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/lightning-primitive-icon')
WebElement dateEl = WebUI.findWebElement(dateIcon, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(dateEl))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(dateEl))
WebUI.delay(2)

// --- Click Calendar Date (span_22) via JS ---
TestObject dateCell = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/span_22')
WebUI.waitForElementVisible(dateCell, 10)
WebUI.waitForElementClickable(dateCell, 10)
WebElement dateSpan = WebUI.findWebElement(dateCell, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(dateSpan))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(dateSpan))

// --- Category Dropdown ---
TestObject catDropdown = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/button_--None--')
WebUI.waitForElementVisible(catDropdown, 10)
WebElement catDropdownEl = WebUI.findWebElement(catDropdown, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(catDropdownEl))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(catDropdownEl))

WebUI.click(findTestObject('Object Repository/Page_New Permit Permit  Salesforce/lightning-base-combobox-item_Environmental Permits'))

// --- Type Dropdown ---
TestObject typeDropdown = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/button_--None--_1')
WebUI.waitForElementVisible(typeDropdown, 10)
WebElement typeEl = WebUI.findWebElement(typeDropdown, 10)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(typeEl))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Page_New Permit Permit  Salesforce/lightning-base-combobox-item_Renewable'))

// --- Save Permit ---
WebUI.click(findTestObject('Object Repository/Page_New Permit Permit  Salesforce/button_Save'))

// -------- Close Browser --------
WebUI.closeBrowser()
