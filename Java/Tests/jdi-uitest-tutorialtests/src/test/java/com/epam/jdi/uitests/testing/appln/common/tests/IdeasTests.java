package com.epam.jdi.uitests.testing.appln.common.tests;

import com.epam.web.matcher.testng.Check;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderMenu.IDEAS;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.IdeasFilterEnum.VIDEOS;
import static com.epam.jdi.uitests.testing.appln.page_objects.enums.Preconditions.HOME_PAGE;
import static com.epam.jdi.uitests.testing.appln.page_objects.site.EpamSite.ideasPage;
import static com.epam.jdi.uitests.testing.appln.page_objects.site.EpamSite.topMenu;

/**
 * Created by Aleksei_Abramenko on 4/14/2016.
 */
public class IdeasTests extends TestsBase {

    private final Logger log = Logger.getLogger(this.getClass());

    @BeforeMethod
    public void before(Method method) throws IOException {
        isInState(HOME_PAGE, method);
    }

    @Test
    public void checkEmptyFilter() {
        log.info("=== Test: check appropriate message when there is no filter");
        topMenu.select(IDEAS);
        ideasPage.checkOpened();
        ideasPage.ideasFilter.removeAll();

         new Check("Message about no filtering is displayed").
                 isTrue(ideasPage.isNoFilterDisplayed());
         new Check("Message about no filtering has right text: " + ideasPage.noFilterMessageText).
                 areEquals(ideasPage.getTextOfFilterMessage(), ideasPage.noFilterMessageText);
    }

    @Test
    public void checkVideosFilter() {
        log.info("=== Test: filter by Videos and check page");
        topMenu.select(IDEAS);
        ideasPage.checkOpened();
        ideasPage.ideasFilter.filterBy(VIDEOS);
        ideasPage.pageDown();
        ideasPage.checkArticleTags(VIDEOS);
    }


}
