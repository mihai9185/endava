package pages;

import com.microsoft.playwright.Page;

public class AddEmployeePage {
    private final Page page;

    public AddEmployeePage(Page page) {
        this.page = page;
    }

    public void clickAddButton() {
        page.locator("button.oxd-button.oxd-button--medium.oxd-button--secondary").nth(1).click();
    }

    public void fillEmployeeForm(String firstName, String lastName, String employeeId) {
        page.fill("input[placeholder='First Name']", firstName);
        page.fill("input[name='lastName']", lastName);
        page.locator("input.oxd-input").nth(4).fill(employeeId);
    }

    public void clickSave() {
        page.click("button[type='submit']");
    }

    public boolean errorIsDisplayed(String expectedResults) {
        return page.getByText(expectedResults).isVisible();
    }
}