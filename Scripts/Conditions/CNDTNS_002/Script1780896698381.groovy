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

WebUI.openBrowser(null)

WebUI.navigateToUrl('http://103.196.155.126:3011/login')

WebUI.setText(findTestObject('CONDITIONS_002/Page_Admin TCG/input_admingoldentcg.com'), 'admin@goldentcg.com')

WebUI.setEncryptedText(findTestObject('CONDITIONS_002/Page_Admin TCG/input_'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.sendKeys(findTestObject('CONDITIONS_002/Page_Admin TCG/input_'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('CONDITIONS_002/Page_Admin TCG/i_bx-menu v-icon notranslate v-theme-dark'))

WebUI.click(findTestObject('CONDITIONS_002/Page_Admin TCG/span_Master Condition'))

WebUI.click(findTestObject('CONDITIONS_002/Page_Admin TCG/a_admin-conditions-toolbar-create-button'))

WebUI.setText(findTestObject('CONDITIONS_002/Page_Admin TCG/input_Contoh_ 95'), '60')

WebUI.click(findTestObject('CONDITIONS_002/Page_Admin TCG/span_Simpan'))

WebUI.closeBrowser()

