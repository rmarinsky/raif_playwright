package io.testomat.web;

import io.qameta.allure.Step;

import static io.testomat.common.pw.PlaywrightWrapper.find;

public class ProjectsPage {

    @Step("Create project {targetProjectName}")
    public ProjectsPage createProject(String targetProjectName) {
        find("#project_title").fill(targetProjectName);

        find("[name=commit]").click();
        return this;
    }

}
