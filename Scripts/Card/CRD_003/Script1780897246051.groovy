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

// Validasi file image harus ada
assert Files.exists(Paths.get(frontImagePath))

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

WebUI.delay(2)

// ===============================
// UPLOAD CARD IMAGES
// ===============================
// Membuat TestObject langsung berdasarkan input type=file
// Input pertama = Kartu Depan
// Input kedua = Kartu Belakang
TestObject frontFileInput = new TestObject('frontFileInput')

frontFileInput.addProperty('xpath', ConditionType.EQUALS, '(//input[@type="file"])[1]')

// Tunggu input file tersedia
WebElement frontInputElement = WebUiCommonHelper.findWebElement(frontFileInput, 10)

// Upload file langsung ke input type=file
frontInputElement.sendKeys(frontImagePath)

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

// Price
WebUI.setText(findTestObject('CARD_001/Page_Admin TCG/input_Contoh_ 150000'), '10000')

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

