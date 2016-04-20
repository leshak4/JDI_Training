package com.epam.jdi.uitests.testing.appln.page_objects.site.pages;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.web.matcher.testng.Check;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.jdi.uitests.testing.appln.page_objects.site.EpamSite.eventsPage;
import static com.epam.jdi.uitests.testing.appln.utils.Utils.getCurrentYear;

public class EventsPage extends WebPage {

    String viewByYearSelectorId = "select-box--container";
    String viewByYearSelectorItemsXpath = "//*[@id='select-box--results']/li";
    // String crumbsXpath = "//*[@class='header-menu-crumbs']/li/a";

    private String prevYear = "" + (Integer.parseInt(getCurrentYear()) - 1);

    @FindBy(xpath = "//*[@class='header-menu-crumbs']/li/a")
    public List<Link> crumbsLinks;

    public IDropDown yearsSelector = new Dropdown<>(By.id(viewByYearSelectorId),
            By.xpath(viewByYearSelectorItemsXpath));

    public String getSelectedYear() {
        WebElement viewByYearSelector = getDriver().findElement(By.id(viewByYearSelectorId));
        return viewByYearSelector.getText();
    }

    public String getYearFromCrumbs() {
        int lastIndex = crumbsLinks.toArray().length - 1;
        return crumbsLinks.get(lastIndex).getText();
    }

    public void checkCurrentYearIsSelected() {
        checkSelectedYear(getCurrentYear());
    }

    public void checkPreviousYearIsSelected() {
        checkSelectedYear(prevYear);
    }

    public void checkSelectedYear(String year) {
        new Check("URL contains correct year: " + year).
                contains(eventsPage.getUrl(), "/about/news-and-events/events/" + year);

        new Check("Title is the correct year: " + year).
                areEquals(eventsPage.getTitle(), year);

        new Check("Correct year is selected in dropdown: " + year).
                areEquals(eventsPage.getSelectedYear(), year);

        new Check("Correct year in crumbs: " + year).
                areEquals(eventsPage.getYearFromCrumbs(), year);
    }

    public void selectPreviousYear() {
        yearsSelector.select(prevYear);
    }
}
