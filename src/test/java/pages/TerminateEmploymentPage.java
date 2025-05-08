package pages;

import com.microsoft.playwright.Page;

public class TerminateEmploymentPage {
    private final Page page;

    public TerminateEmploymentPage(Page page) {
        this.page = page;
    }

    public void clickEditIcon() {
        page.locator("i.bi-pencil-fill").first().click();
    }

    public void selectJobTab() {
        page.click("text=Job");
    }

    public void clicksButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Terminate Employment")) {
            page.click("button:has-text('Terminate Employment')");
        } else if (buttonName.equalsIgnoreCase("Save")) {
            page.locator("form:has-text('Termination Reason') button:has-text('Save')").click();
        } else {
            throw new IllegalArgumentException("Unknown button");
        }
    }

    public void fillTerminationForm(String date, String reason) {
        page.locator("form:has-text('Termination Date') input[placeholder='yyyy-dd-mm']").fill(date);
        page.locator("form:has-text('Termination Reason')").locator("text=-- Select --").click();
        page.getByText(reason).click();
    }

    public boolean informMessage(String expectedResults) {
        return page.getByText(expectedResults).isVisible();
    }
}