import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths
import java.util.Arrays as Arrays

// ===============================
// FILE PATH
// ===============================
String frontImagePath = 'C:\\katalon-upload\\netflix.png'

String backImagePath = 'C:\\katalon-upload\\netflix2.png'

// Validasi file image harus ada
assert Files.exists(Paths.get(frontImagePath))

assert Files.exists(Paths.get(backImagePath))

// ===============================
// OPEN BROWSER AND LOGIN
// ===============================
WebUI.openBrowser('')

WebUI.navigateToUrl('http://103.196.155.126:3011/login')

WebUI.setText(findTestObject('CARD_001/Page_Admin TCG/input_admingoldentcg.com'), 'admin@goldentcg.com')

WebUI.setEncryptedText(findTestObject('CARD_001/Page_Admin TCG/input_'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/button_admin-login-submit-button'))

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/button_vertical-nav-toggle-btn'))

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/span_Master Card'))

WebUI.waitForElementClickable(findTestObject('CARD_001/Page_Admin TCG/i_bx-plus v-icon notranslate v-theme-dark v-icon'), 
    10)

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/i_bx-plus v-icon notranslate v-theme-dark v-icon'))

// ===============================
// UPLOAD CARD IMAGES
// ===============================
// Membuat TestObject langsung berdasarkan input type=file
// Input pertama = Kartu Depan
// Input kedua = Kartu Belakang
TestObject frontFileInput = new TestObject('frontFileInput')

frontFileInput.addProperty('xpath', ConditionType.EQUALS, '(//input[@type="file"])[1]')

TestObject backFileInput = new TestObject('backFileInput')

backFileInput.addProperty('xpath', ConditionType.EQUALS, '(//input[@type="file"])[2]')

// Tunggu input file tersedia
WebElement frontInputElement = WebUiCommonHelper.findWebElement(frontFileInput, 10)

WebElement backInputElement = WebUiCommonHelper.findWebElement(backFileInput, 10)

// Buat input file terlihat/aktif
WebUI.executeJavaScript('\n    arguments[0].style.display = \'block\';\n    arguments[0].style.visibility = \'visible\';\n    arguments[0].style.opacity = \'1\';\n    arguments[0].style.position = \'relative\';\n    arguments[0].style.zIndex = \'9999\';\n    arguments[0].style.width = \'300px\';\n    arguments[0].style.height = \'40px\';\n', 
    Arrays.asList(frontInputElement))

WebUI.executeJavaScript('\n    arguments[0].style.display = \'block\';\n    arguments[0].style.visibility = \'visible\';\n    arguments[0].style.opacity = \'1\';\n    arguments[0].style.position = \'relative\';\n    arguments[0].style.zIndex = \'9999\';\n    arguments[0].style.width = \'300px\';\n    arguments[0].style.height = \'40px\';\n', 
    Arrays.asList(backInputElement))

// Upload file langsung ke input type=file
frontInputElement.sendKeys(frontImagePath)

backInputElement.sendKeys(backImagePath)

// Trigger event change agar aplikasi mendeteksi file yang sudah dipilih
WebUI.executeJavaScript('\n    arguments[0].dispatchEvent(new Event(\'input\', { bubbles: true }));\n    arguments[0].dispatchEvent(new Event(\'change\', { bubbles: true }));\n', 
    Arrays.asList(frontInputElement))

WebUI.executeJavaScript('\n    arguments[0].dispatchEvent(new Event(\'input\', { bubbles: true }));\n    arguments[0].dispatchEvent(new Event(\'change\', { bubbles: true }));\n', 
    Arrays.asList(backInputElement))

WebUI.setText(findTestObject('CARD_001/Page_Admin TCG/input_Contoh_ Pikachu Holo'), 'Katalon')

// Select Game
WebUI.click(findTestObject('CARD_001/Page_Admin TCG/div_v-field_input'))

WebUI.delay(1)

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/i_bx-chevron-down v-icon notranslate v-theme-dar'))

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/div_Katalon'))

// Select Rarity
WebUI.click(findTestObject('CARD_001/Page_Admin TCG/i_bx-chevron-down v-icon notranslate v-theme-dar_1'))

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/div_Katalon Rarity'))

// Select Condition
WebUI.click(findTestObject('CARD_001/Page_Admin TCG/i_bx-chevron-down v-icon notranslate v-theme-dar_2'))

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/div_Katalon_1'))

// Card Number
WebUI.setText(findTestObject('CARD_001/Page_Admin TCG/input_Contoh_ 025_102'), '001/001')

// Status
WebUI.click(findTestObject('CARD_001/Page_Admin TCG/div_v-field_input_1'))

WebUI.click(findTestObject('CARD_001/Page_Admin TCG/div_Tersedia'))

// Description
WebUI.setText(findTestObject('CARD_001/Page_Admin TCG/textarea_Deskripsi kartu'), 'Test Katalon')

// ===============================
// SUBMIT
// ===============================
WebUI.click(findTestObject('CARD_001/Page_Admin TCG/span_Simpan'))

WebUI.closeBrowser()

