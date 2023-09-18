package io.testomat.web;

import io.qameta.allure.Step;
import io.testomat.common.pw.conditions.Condition;

import static io.testomat.common.pw.PlaywrightWrapper.find;

public class SignInPage extends BasePage {

    @Step("Login page")
    public SignInPage loginUser() {
        $("#user_email").fill("newromka@gmail.com");
        $("#user_password")
                .fill("3y77b7HzrL2ebwQ!")
                .press("Enter")
                .shouldBe(Condition.hidden);
        return this;
    }

}
