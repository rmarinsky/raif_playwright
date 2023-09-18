package io.testomat.common;

import io.qameta.allure.Allure;
import io.testomat.common.pw.Configuration;
import io.testomat.common.pw.PlaywrightWrapper;
import org.testng.*;

public class TracesListener implements ITestListener, IInvokedMethodListener {

    @Override
    public void onTestStart(ITestResult result) {
        PlaywrightWrapper.initTestContext(Configuration.saveTraces, getTestName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.getLifecycle().addAttachment("Screenshot for" + getTestName(result), "image/png", "png",
                PlaywrightWrapper.pwStage().getPage().screenshot()
        );
        PlaywrightWrapper.closeContext(Configuration.saveTraces, getTestName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.getLifecycle().addAttachment("Screenshot for" + getTestName(result), "image/png", "png",
                PlaywrightWrapper.pwStage().getPage().screenshot()
        );
        PlaywrightWrapper.pwStage().getPage().screenshot();
        PlaywrightWrapper.closeContext(Configuration.saveTraces, getTestName(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        PlaywrightWrapper.closeContext(Configuration.saveTraces, getTestName(result));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        PlaywrightWrapper.closeContext(Configuration.saveTraces, getTestName(result));
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // not implementing beforeInvocation as onTestStart should suffice
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // not implementing afterInvocation as onTestSuccess/onTestFailure should suffice
    }

    private String getTestName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

    //Other methods from these interfaces are not required, you can leave them as empty
    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

}
