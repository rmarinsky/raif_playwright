package io.testomat.web;

import io.qameta.allure.Step;

import static io.testomat.common.pw.PlaywrightWrapper.find;
import static io.testomat.common.pw.conditions.Condition.hidden;
import static io.testomat.common.pw.conditions.Condition.visible;

public class TestSuitesPage {



    @Step("Test suites page is loaded")
    public TestSuitesPage isLoaded() {
        find("[placeholder='First Suite']").shouldBe(visible);
        return this;
    }

    @Step("Close readme modal")
    public TestSuitesPage closeReadmeModal() {
        find(".back").click();

        return this;
    }

    @Step("Create first test suite {targetTestSuite}")
    public TestSuitesPage createFirstTestSuite(String targetTestSuite) {
        find("[placeholder='First Suite']")
                .fill(targetTestSuite)
                .press("Enter")
                .shouldBe(hidden);

        return this;
    }

    @Step("Test suite {targetTestSuite} is created")
    public TestSuitesPage testSuiteIsCreated(String targetTestSuite) {
        find(".list-group-wrapper .dragSortList a span", targetTestSuite).shouldBe(visible);

        return this;
    }

}
