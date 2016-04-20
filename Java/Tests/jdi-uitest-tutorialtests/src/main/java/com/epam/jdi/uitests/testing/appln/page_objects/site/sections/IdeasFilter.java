package com.epam.jdi.uitests.testing.appln.page_objects.site.sections;

import com.epam.jdi.uitests.testing.appln.page_objects.enums.IdeasFilterEnum;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.web.matcher.testng.Check;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Aleksei_Abramenko on 4/13/2016.
 */
public class IdeasFilter extends Form {

    @FindBy(xpath = "//*[@for = 'tag_All']")
    public CheckBox chbAll = new CheckBox() {
        protected boolean isCheckedAction() {
            return new Element(By.xpath("//*[@for = 'tag_All']/../input"))
                    .getInvisibleElement().getAttribute("checked") != null;
        }
    };

    @FindBy(xpath = "//*[@for = 'tag_Video']")
    public CheckBox chbVideos = new CheckBox() {
        protected boolean isCheckedAction() {
            return new Element(By.xpath("//*[@for = 'tag_Video']/../input"))
                    .getInvisibleElement().getAttribute("checked") != null;
        }
    };

    @FindBy(xpath = "//*[@for = 'tag_Analyst Report']")
    public CheckBox chbAnalystReports = new CheckBox() {
        protected boolean isCheckedAction() {
            return new Element(By.xpath("//*[@for = 'tag_Analyst Report']/../input"))
                    .getInvisibleElement().getAttribute("checked") != null;
        }
    };

    @FindBy(xpath = "//*[@for = 'tag_White Paper']")
    public CheckBox chbWhitePapers = new CheckBox() {
        protected boolean isCheckedAction() {
            return new Element(By.xpath("//*[@for = 'tag_White Paper']/../input"))
                    .getInvisibleElement().getAttribute("checked") != null;
        }
    };

    @FindBy(xpath = "//*[@for = 'tag_Blog Article']")
    public CheckBox chbBlog = new CheckBox() {
        protected boolean isCheckedAction() {
            return new Element(By.xpath("//*[@for = 'tag_Blog Article']/../input"))
                    .getInvisibleElement().getAttribute("checked") != null;
        }
    };

    @FindBy(xpath = "//*[@for = 'tag_Case Study']")
    public CheckBox chbCaseStudies = new CheckBox() {
        protected boolean isCheckedAction() {
            return new Element(By.xpath("//*[@for = 'tag_Case Study']/../input"))
                    .getInvisibleElement().getAttribute("checked") != null;
        }
    };

    @FindBy(xpath = "//*[@for = 'tag_Brochure']")
    public CheckBox chbBrochures = new CheckBox() {
        protected boolean isCheckedAction() {
            return new Element(By.xpath("//*[@for = 'tag_Brochure']/../input"))
                    .getInvisibleElement().getAttribute("checked") != null;
        }
    };

    public void removeAll() {
        CheckBox[] checkBoxes = {chbAll,
                                chbAnalystReports,
                                chbBlog,
                                chbBrochures,
                                chbCaseStudies,
                                chbVideos,
                                chbWhitePapers};
        for (CheckBox chb : checkBoxes) {
            chb.uncheck();
        }
    }

    public void filterBy(IdeasFilterEnum filter) {
        CheckBox chb = null;
        switch (filter.toString()) {
            case "Videos":
                chb = chbVideos;
                break;
            case "All":
                chb = chbAll;
                break;
        }
        chbAll.uncheck();
        new Check("Checkbox is defined").isTrue(chb != null);
        chb.check();
    }

}
