package io.testomat.common.pw;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;
import io.testomat.common.pw.conditions.Condition;
import lombok.Data;

@Data
public class LocatorActions {

    private final Locator locator;

    @Step("Fill {text}")
    public LocatorActions fill(String text) {
        locator.fill(text);
        return this;
    }

    @Step("Fill {text}")
    public LocatorActions setValue(String text) {
        locator.fill(text);
        return this;
    }

    @Step("Press {key}")
    public LocatorActions press(String key) {
        locator.press(key);
        return this;
    }

    @Step("click")
    public LocatorActions click() {
        locator.click();
        return this;
    }

    @Step("Get parent element")
    public LocatorActions parent() {
        locator.locator("xpath=..");
        return this;
    }

    @Step("Should be {condition}")
    public LocatorActions shouldBe(Condition condition) {
        condition.verify(this);
        return this;
    }

    @Step("Should be {condition}")
    public LocatorActions should(Condition condition) {
        condition.verify(this);
        return this;
    }

    @Step("Should have {condition}")
    public LocatorActions shouldHave(Condition condition) {
        condition.verify(this);
        return this;
    }

    @Step("Should has {condition}")
    public LocatorActions shouldHas(Condition condition) {
        condition.verify(this);
        return this;
    }

}
