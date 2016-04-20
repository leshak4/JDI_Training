package com.epam.jdi.uitests.testing.appln.page_objects.site.sections;

import com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderMenu;
import com.epam.jdi.uitests.testing.appln.page_objects.enums.HeaderSolutionsMenu;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.epam.commons.EnumUtils.getEnumValue;
import static com.epam.jdi.uitests.testing.appln.page_objects.site.EpamSite.topSubMenu;

/**
 * Created by Aleksei_Abramenko on 4/13/2016.
 */
public class TopMenu extends Menu {

    private final Logger log = Logger.getLogger(this.getClass());

    public void selectSubItem(HeaderMenu item, HeaderSolutionsMenu subItem) {

        String menuItemsXpath = "//*[@class='tile-menu']/li/a";
        String itemText = getEnumValue(item);
        int itemIndex = HeaderMenu.valueOf(itemText).ordinal();
        log.info("Index of " + item + " is " + itemIndex);

        Actions action = new Actions(getDriver());
        WebElement menuItemEl = getDriver().findElements(By.xpath(menuItemsXpath)).get(itemIndex);

        action.moveToElement(menuItemEl).clickAndHold().build().perform();
        topSubMenu.select(subItem);
        action.release();

    }
}
