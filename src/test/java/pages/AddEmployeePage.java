package pages;

import com.microsoft.playwright.Page;

public class AddEmployeePage {
    private final Page page;


    public AddEmployeePage(Page page) {
        this.page = page;
    }

    public void clickButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("+ Add")) {
            page.locator("button.oxd-button.oxd-button--medium.oxd-button--secondary").nth(1).click();
        } else if (buttonName.equalsIgnoreCase("save")) {
            page.locator("button[type='submit']").click();
        } else {
            throw new IllegalArgumentException("Unknown button");
        }
    }

    public void fillEmployeeForm(String firstName, String lastName, String employeeId) {
        page.fill("input[placeholder='First Name']", firstName);
        page.fill("input[name='lastName']", lastName);
        page.locator("input.oxd-input").nth(4).fill(employeeId);
    }

    public boolean errorIsDisplayed(String expectedResults) {
        return page.getByText(expectedResults).isVisible();
    }
}
