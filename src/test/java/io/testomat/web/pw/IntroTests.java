package io.testomat.web.pw;

import com.github.javafaker.Faker;
import io.testomat.common.TracesListener;
import io.testomat.common.pw.Configuration;
import io.testomat.web.ProjectsPage;
import io.testomat.web.SignInPage;
import io.testomat.web.TestSuitesPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.testomat.common.pw.PlaywrightWrapper.open;

@Listeners(TracesListener.class)
public class IntroTests {

    Faker faker = new Faker();


    static {
        Configuration.baseUrl = "https://uat.testomat.io";
        Configuration.poolingInterval = 0;
        Configuration.defaultTimeout = 10000;
        Configuration.headless = false;
        Configuration.saveTraces = true;
        Configuration.devTools = false;
        Configuration.isMobile = true;

    }


    @Test
    void prepareLoginTest() {
        open("/users/sign_in");

        new SignInPage().loginUser();

        open("/projects/new");

        String targetProjectName = faker.book().title();
        new ProjectsPage().createProject(targetProjectName);

        String targetTestSuite = faker.commerce().productName();

        new TestSuitesPage()
                .isLoaded()
                .closeReadmeModal()
                .createFirstTestSuite(targetTestSuite)
                .testSuiteIsCreated(targetTestSuite);
    }


}
