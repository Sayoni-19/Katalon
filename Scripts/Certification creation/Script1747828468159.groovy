import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
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
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'OJK6S0ghyhhqC323vSRvDg==')
WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// ===== Navigate to Permit =====
WebUI.waitForPageLoad(30)
safeClick(findTestObject('Object Repository/Page_My Company  Salesforce/span_More'))

TestObject permitTab = findTestObject('Object Repository/Page_My Company  Salesforce/span_Permit')
WebUI.waitForElementVisible(permitTab, 15)
WebElement permitEl = WebUI.findWebElement(permitTab, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(permitEl))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(permitEl))

// ===== Click Create Permit with Retry =====
TestObject createPermitBtn = findTestObject('Object Repository/Page_Permit  Salesforce/span_Create Permit')
boolean found = false
for (int i = 0; i < 3; i++) {
    if (WebUI.verifyElementPresent(createPermitBtn, 5, FailureHandling.OPTIONAL)) {
        safeClick(createPermitBtn)
        found = true
        break
    } else {
        WebUI.comment("Retry ${i+1}: Waiting for 'Create Permit' to appear...")
        WebUI.delay(2)
    }
}
if (!found) {
    WebUI.takeScreenshot()
    WebUI.closeBrowser()
    assert false : "'Create Permit' not found after retries. Check UI load or selectors."
}

WebUI.switchToWindowTitle('New Permit | Salesforce')

// ===== Fill Form - Certification Specific =====
safeClick(findTestObject('Object Repository/Page_New Permit  Salesforce/span_Next'))

WebUI.setText(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/input__Rhythm__Number__c'), 'vx bnxvcnbv')
WebUI.setText(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/input__Rhythm__Permit_Name__c'), 'bxnxcvnxn')

// ===== Date Picker =====
TestObject dateIcon = findTestObject('Object Repository/Page_New Permit Certification  Salesforce/input__Rhythm__Issue_Date__c')
WebElement dateEl = WebUI.findWebElement(dateIcon, 10)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(dateEl))

TestObject dateVal = findTestObject('Object Repository/Page_New Permit Certification  Salesforce/span_21')
WebElement dateBtn = WebUI.findWebElement(dateVal, 10)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(dateBtn))

// ===== Dropdowns =====
TestObject categoryDropdown = findTestObject('Object Repository/Page_New Permit Certification  Salesforce/div_Category--None--')
WebElement categoryEl = WebUI.findWebElement(categoryDropdown, 10)
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(categoryEl))
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(categoryEl))

safeClick(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_--None--'))
safeClick(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/span_Import licensed product'))

safeClick(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_--None--_1'))
safeClick(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/span_Renewable'))

// ===== Status =====
safeClick(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_Draft'))
safeClick(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/lightning-base-combobox-item_Active'))

// ===== Save & Exit =====
safeClick(findTestObject('Object Repository/Page_New Permit Certification  Salesforce/button_Save'))
WebUI.closeBrowser() 