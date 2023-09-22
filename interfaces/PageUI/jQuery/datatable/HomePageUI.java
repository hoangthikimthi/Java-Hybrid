package PageUI.jQuery.datatable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]//a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String COLUM_INDEX_BY_NAME = "xpath=//tr//th[text()='%s']//preceding-sibling::th";
	public static final String ROW_TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String ROW_DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String ROW_CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public static final String ROW_BUTTON_BY_COLUM_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]//button[@title='%s']";
	public static final String LOAD_DATA_BUTTON = "css=button#load";
}
