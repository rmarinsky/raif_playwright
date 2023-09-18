package io.testomat.web;

import io.testomat.common.pw.Configuration;
import io.testomat.common.pw.LocatorActions;
import io.testomat.common.pw.PlaywrightWrapper;

public class BasePage {


    public String deviceSelector() {
        return Configuration.isMobile ? "#content-mobile " : "#content-desktop ";
    }

    public LocatorActions $(String childSelector) {
        return PlaywrightWrapper.find(deviceSelector() + childSelector);
    }

}
