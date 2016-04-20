package com.epam.jdi.uitests.testing.appln.common.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderMenu.ABOUT;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderSolutionsMenu.EVENTS;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.Preconditions.HOME_PAGE;
import static com.epam.jdi.uitests.testing.appln.page_objects.site.EpamSite.eventsPage;
import static com.epam.jdi.uitests.testing.appln.page_objects.site.EpamSite.topMenu;

/**
 * Created by Aleksei_Abramenko on 4/14/2016.
 */
public class EventsTests extends TestsBase {

    private final Logger log = Logger.getLogger(this.getClass());

    @BeforeMethod
    public void before(Method method) throws IOException {
        isInState(HOME_PAGE, method);
    }

    @Test
    public void checkCurrentYearByDefault() {
        log.info("=== Test: Events page shows current page by default");
        topMenu.selectSubItem(ABOUT, EVENTS);
        eventsPage.checkOpened();
        eventsPage.checkCurrentYearIsSelected();
    }

    @Test
    public void selectPreviousYear() {
        log.info("=== Test: Select previous year and check page");
        topMenu.selectSubItem(ABOUT, EVENTS);
        eventsPage.checkOpened();
        eventsPage.selectPreviousYear();
        eventsPage.checkPreviousYearIsSelected();
    }

}
