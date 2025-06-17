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

WebUI.click(findTestObject('Object Repository/Page_Permit  Salesforce/span_Permit List'))

WebUI.switchToWindowTitle('All | Permits | Salesforce')

WebUI.click(findTestObject('Object Repository/Page_All  Permits  Salesforce/a_Certification1'))

WebUI.click(findTestObject('Object Repository/Page_RI-Permit-0022  Permit  Salesforce/a_Tasks'))

WebUI.click(findTestObject('Object Repository/Page_RI-Permit-0022  Permit  Salesforce/button_New Task'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/input__combobox-input-241'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/span_Send Quote'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/lightning-primitive-icon'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/span_25'))

WebUI.click(findTestObject('Object Repository/Page_New Task  Salesforce/span_Save'))

