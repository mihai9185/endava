package pages;

import com.microsoft.playwright.Page;

public class CreatePostPage {
    private final Page page;

    public CreatePostPage(Page page) {
        this.page = page;
    }

    public void clickBuzzModule() {
        page.click("text=Buzz");
    }

    public void fillEmptyPost() {
        page.locator("textarea.oxd-buzz-post-input").click();
        page.fill("textarea.oxd-buzz-post-input", " ");
    }

    public void clickPostButton() {
        page.click("button[type='submit'].oxd-button--main");
    }

    public boolean emptyPostError(String expectedResults) {
        return page.getByText(expectedResults).isVisible();
    }
}
