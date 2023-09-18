package io.testomat.web.pw;

import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.testng.annotations.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PWRawTEst {


    static Playwright playwright;
    static Browser browser;

    Faker faker = new Faker();

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeClass
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500)
        );
    }

    @AfterClass
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();

        page.navigate("https://uat.testomat.io/users/sign_in");

        assertThat(page.locator("#content-desktop #new_user")).isVisible(
                new LocatorAssertions.IsVisibleOptions().setTimeout(20000));

        page.locator("#content-desktop #user_email").fill("newromka@gmail.com");
        Locator passwordField = page.locator("#content-desktop #user_password");
        passwordField.fill("3y77b7HzrL2ebwQ!");
        passwordField.press("Enter");

        isHidden(passwordField);

        page.navigate("https://uat.testomat.io/projects/new");

    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

//    @Test
    void firstTestOnPlaywrigh() {
        page.locator("#grid li", new Page.LocatorOptions().setHasText("")).click();

        page.locator("#project_title").fill(faker.book().title());

        page.locator("[name='commit']").click();

        Locator preloader = page.locator("#app-loader");
        isHidden(preloader);

        page.locator(".back").click();

        String targetTestSuiteName = faker.commerce().department();

        assertThat(page.locator((".list-group-wrapper a[href*='suite']"))).hasText(targetTestSuiteName);

    }

    public void isHidden(Locator locator) {
        assertThat(locator).isHidden(new LocatorAssertions.IsHiddenOptions().setTimeout(10000));

    }

}
