import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import java.util.Arrays

// ✅ Utility: Safe Click with fallback to JS
def safeClick(TestObject obj) {
    try {
        WebUI.waitForElementClickable(obj, 10)
        WebUI.click(obj)
    } catch (Exception e) {
        WebElement el = WebUI.findWebElement(obj, 10)
        WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(el))
        WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
    }
}

// ===== LOGIN (Unchanged) =====
WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')
WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), '00dfj00000fdkisuah_john1234@yopmail.com')
WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'Rhythm@123')
WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// ===== Post-login Navigation =====
WebUI.waitForPageLoad(30)
safeClick(findTestObject('Object Repository/Page_My Company  Salesforce/span_More'))
safeClick(findTestObject('Object Repository/Page_My Company  Salesforce/span_Permit'))
safeClick(findTestObject('Object Repository/Page_Permit  Salesforce/span_Create Permit'))

WebUI.switchToWindowTitle('New Permit | Salesforce')

// ===== Fill Form - Step 1 =====
safeClick(findTestObject('Object Repository/Page_New Permit  Salesforce/span_Certification_slds-radio--faux'))
safeClick(findTestObject('Object Repository/Page_New Permit  Salesforce/span_Next'))

WebUI.setText(findTestObject('Object Repository/Page_New Permit License  Salesforce/input__Rhythm__Number__c'), '1234567892')
WebUI.setText(findTestObject('Object Repository/Page_New Permit License  Salesforce/input__Rhythm__Permit_Name__c'), 'katalon license')

// ===== Date Picker =====
TestObject dateIcon = findTestObject('Object Repository/Page_New Permit License  Salesforce/lightning-primitive-icon')
WebElement dateEl = WebUI.findWebElement(dateIcon, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(dateEl))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(dateEl))

TestObject dateVal = findTestObject('Object Repository/Page_New Permit License  Salesforce/span_6')
WebElement dateBtn = WebUI.findWebElement(dateVal, 10)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(dateBtn))

// ===== Dropdowns =====
safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/div_Category--None--'))
safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/button_--None--'))
safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/span_Business License'))

safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/button_--None--_1'))
safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/span_Non-Renewable'))

// ===== Status =====
safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/button_Draft'))
safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/span_Active'))

// ===== Save & Close =====
safeClick(findTestObject('Object Repository/Page_New Permit License  Salesforce/button_Save'))
WebUI.closeBrowser()
