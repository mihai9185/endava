package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @After
    public void tearDown() {
        if (page != null && !page.isClosed()) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public static Page getPage() {
        return page;
    }
}