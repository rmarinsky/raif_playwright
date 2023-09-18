package io.testomat.common.pw.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import io.testomat.common.pw.Configuration;
import io.testomat.common.pw.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class IsHiddenCondition implements Condition {

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).isHidden(new LocatorAssertions.IsHiddenOptions().setTimeout(
                Configuration.defaultTimeout)
        );
    }

}
