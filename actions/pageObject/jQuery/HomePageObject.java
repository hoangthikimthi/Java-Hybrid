package pageObject.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.jQuery.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);

	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		senkeysToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size= " + totalPage);

		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyet qua tat ca cac page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			sleepInSecond(1);

			// Get text cua all row moi page dua vao ArrayList
			List<WebElement> allRowElementEachPage = getListElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
			for (String value : allRowValueAllPage) {
				System.out.println(value);
			}
		}
		return allRowValueAllPage;
	}

	public void enterToTextboxByColumNameAtRowNumber(String columeName, String rowNumber, String Value) {
		int columeIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columeName) + 1;
		waitForElementVisible(driver, HomePageUI.ROW_TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columeIndex));
		senkeysToElement(driver, HomePageUI.ROW_TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, Value, rowNumber, String.valueOf(columeIndex));
	}

	public void enterToDropdownByColumNameAtRowNumber(String columeName, String rowNumber, String Value) {
		int columeIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columeName) + 1;
		waitForElementClickable(driver, HomePageUI.ROW_DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columeIndex));
		selectItemInDefautDropdown(driver, HomePageUI.ROW_DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, Value, rowNumber, String.valueOf(columeIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
	}

	public void checkToCheckBoxByColumnNameAtRowNumber(String columeName, String rowNumber) {
		int columeIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columeName) + 1;
		waitForElementClickable(driver, HomePageUI.ROW_CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columeIndex));
		checktoDefaulCheckboxOrRadio(driver, HomePageUI.ROW_CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columeIndex));
	}

	public void unCheckToCheckBoxByColumnNameAtRowNumber(String columeName, String rowNumber) {
		int columeIndex = getElementSize(driver, HomePageUI.COLUM_INDEX_BY_NAME, columeName) + 1;
		waitForElementClickable(driver, HomePageUI.ROW_CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columeIndex));
		unChecktoDefaulCheckboxRadio(driver, HomePageUI.ROW_CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columeIndex));

	}

	public void clickToIconByRowNumber(String rowNumber, String icon) {
		waitForElementClickable(driver, HomePageUI.ROW_BUTTON_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, icon);
		clickToElement(driver, HomePageUI.ROW_BUTTON_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, icon);
	}
}
