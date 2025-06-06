import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.configuration.RunConfiguration
import java.util.Arrays

// --- Detect Headless Mode ---
boolean isHeadless = RunConfiguration.getExecutionProperties().get("execution")?.toString()?.toLowerCase()?.contains("headless")

// -------- Login (DO NOT TOUCH) --------
WebUI.openBrowser('')
WebUI.navigateToUrl('https://rhythm-qa-enterprise.my.salesforce.com/')
WebUI.setText(findTestObject('Object Repository/Page_Login  Salesforce/input_Username_username'), '00dfj00000fdkisuah_john1234@yopmail.com')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_pw'), 'OJK6S0ghyhhqC323vSRvDg==')
WebUI.click(findTestObject('Object Repository/Page_Login  Salesforce/input_Password_Login'))

// -------- Navigate to Permit Tab --------
TestObject moreBtn = findTestObject('Object Repository/Page_My Company  Salesforce/span_More')
WebUI.waitForElementClickable(moreBtn, 15)
try {
    WebUI.click(moreBtn)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(moreBtn, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}
if (isHeadless) WebUI.delay(1)

TestObject permitLink = findTestObject('Object Repository/Page_My Company  Salesforce/a_Permit')
WebUI.waitForElementVisible(permitLink, 15)
WebUI.waitForElementClickable(permitLink, 10)
WebElement permitEl = WebUI.findWebElement(permitLink, 10)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(permitEl))
if (isHeadless) WebUI.delay(1)

// -------- Click Create Permit --------
TestObject createPermit = findTestObject('Object Repository/Page_Permit  Salesforce/span_Create Permit')
boolean isVisible = false
for (int i = 0; i < 3; i++) {
    if (WebUI.verifyElementVisible(createPermit, FailureHandling.OPTIONAL)) {
        isVisible = true
        break
    }
    WebUI.comment("Waiting for 'Create Permit' button to appear... Retry #${i+1}")
    WebUI.delay(2)
}
if (!isVisible) {
    WebUI.comment("❌ 'Create Permit' button not visible even after retry.")
    WebUI.takeScreenshot()
    WebUI.closeBrowser()
    assert false : "'Create Permit' button not found — check page load or selector."
}
try {
    WebUI.waitForElementClickable(createPermit, 10)
    WebUI.click(createPermit)
} catch (Exception e) {
    WebElement el = WebUI.findWebElement(createPermit, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
}

WebUI.delay(2)
WebUI.switchToWindowIndex(1)

// -------- Fill Permit Form --------
TestObject licenseRadio = findTestObject('Object Repository/Page_New Permit  Salesforce/span_License_slds-radio--faux')
WebUI.waitForElementClickable(licenseRadio, 10)
WebUI.click(licenseRadio)

TestObject nextBtn = findTestObject('Object Repository/Page_New Permit  Salesforce/span_Next (1)')
WebUI.waitForElementClickable(nextBtn, 10)
WebUI.click(nextBtn)

WebUI.setText(findTestObject('Object Repository/Page_New Permit Permit  Salesforce/input__Rhythm__Number__c'), 'fhndn')
WebUI.setText(findTestObject('Object Repository/Page_New Permit Permit  Salesforce/input__Rhythm__Permit_Name__c'), 'nffdn')

// --- Date Picker ---
TestObject dateIcon = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/lightning-primitive-icon')
WebElement dateEl = WebUI.findWebElement(dateIcon, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(dateEl))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(dateEl))
if (isHeadless) WebUI.delay(1)

// --- Calendar Date ---
TestObject dateCell = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/span_22')
WebUI.waitForElementClickable(dateCell, 10)
WebElement dateSpan = WebUI.findWebElement(dateCell, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(dateSpan))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(dateSpan))
if (isHeadless) WebUI.delay(1)

// --- Category Dropdown ---
TestObject catDropdown = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/button_--None--')
WebUI.waitForElementVisible(catDropdown, 10)
WebElement catDropdownEl = WebUI.findWebElement(catDropdown, 10)
WebUI.executeJavaScript('arguments[0].scrollIntoView(true);', Arrays.asList(catDropdownEl))
WebUI.delay(1)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(catDropdownEl))

TestObject catOption = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/lightning-base-combobox-item_Environmental Permits')
WebUI.waitForElementClickable(catOption, 10)
WebUI.click(catOption)

// --- Type Dropdown ---
TestObject typeDropdown = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/button_--None--_1')
WebUI.waitForElementVisible(typeDropdown, 10)
WebElement typeEl = WebUI.findWebElement(typeDropdown, 10)
WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(typeEl))
WebUI.delay(1)

TestObject typeOption = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/lightning-base-combobox-item_Renewable')
WebUI.waitForElementClickable(typeOption, 10)
WebUI.click(typeOption)

// --- Save Permit ---
TestObject saveBtn = findTestObject('Object Repository/Page_New Permit Permit  Salesforce/button_Save')
WebUI.waitForElementClickable(saveBtn, 10)
try {
    WebUI.click(saveBtn)
} catch (Exception e) {
    WebElement saveEl = WebUI.findWebElement(saveBtn, 10)
    WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(saveEl))
}

// -------- Close Browser --------
WebUI.closeBrowser()
