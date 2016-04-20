package com.epam.jdi.uitests.testing.appln.common.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderMenu.ABOUT;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderMenu.IDEAS;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderSolutionsMenu.EVENTS;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.Preconditions.HOME_PAGE;
import static com.epam.jdi.uitests.testing.appln.page_objects.site.EpamSite.*;

/**
 * Created by Aleksei_Abramenko on 4/13/2016.
 */
public class MenuTests extends TestsBase {

    private final Logger log = Logger.getLogger(this.getClass());

    @BeforeMethod
    public void before(Method method) throws IOException {
        isInState(HOME_PAGE, method);
    }

    @Test
    public void openIdeasPage() {
        log.info("=== Test: Open Ideas page from header menu");
        topMenu.select(IDEAS);
        ideasPage.checkOpened();
    }

    @Test
    public void open_About_Then_Events_Page() {
        log.info("=== Test: Open About --> Events page from header menu");
        topMenu.selectSubItem(ABOUT, EVENTS);
        eventsPage.checkOpened();
    }

}
