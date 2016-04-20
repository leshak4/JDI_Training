package com.epam.jdi.uitests.testing.appln.page_objects.site.pages;

import com.epam.jdi.uitests.testing.appln.page_objects.enums.IdeasFilterEnum;
import com.epam.jdi.uitests.testing.appln.page_objects.site.sections.IdeasFilter;
import com.epam.jdi.uitests.testing.appln.utils.Utils;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.web.matcher.testng.Check;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IdeasPage extends WebPage {

    public String noFilterMessageText = "Please make your selection in the filter";
    public String noFilterMessageXpath = "//*[@class='filterable-no-item']";
    public String tagsXpath = "//*[@class='tag-name']";
    public String articlesXpath = "//*[@class='filterable-item-description']/h4";

//    Why does not work ???
//    @FindBy(xpath = "//*[@class='filterable-no-item']")
//    WebElement noFilterMessage;

    @FindBy(xpath = "//*[@class='categories-wrapper']")
    public IdeasFilter ideasFilter;

    public Boolean isNoFilterDisplayed() {
        WebElement el = getDriver().findElement(By.xpath(noFilterMessageXpath));
        return el.isDisplayed();
    }

    public String getTextOfFilterMessage() {
        WebElement el = getDriver().findElement(By.xpath(noFilterMessageXpath));
        return el.getText();
    }

    public void checkArticleTags(IdeasFilterEnum tagName) {
        String actTagName;
        String actArticleName;
        String expTagName = tagName.getTag().toUpperCase();
        List<WebElement> tags = getDriver().findElements(By.xpath(tagsXpath));
        List<WebElement> articles = getDriver().findElements(By.xpath(articlesXpath));
        for (int i = 0; i <= tags.size() - 1; i ++) {
            actTagName = tags.get(i).getText();
            actArticleName = articles.get(i).getText();
            new Check("Tag name #" + (i + 1) + " for article '" + actArticleName +
                    "' is correct: " + tagName).areEquals(actTagName, expTagName);
        }
    }

    public void pageDown() {
        Utils.pressPageDown(5);
    }

}
