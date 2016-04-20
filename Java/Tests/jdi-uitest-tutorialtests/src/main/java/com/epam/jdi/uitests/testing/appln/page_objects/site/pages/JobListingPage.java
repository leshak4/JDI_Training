package com.epam.jdi.uitests.testing.appln.page_objects.site.pages;

import com.epam.commons.map.MapArray;
import com.epam.jdi.uitests.testing.appln.page_objects.enums.JobListHeaders;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Column;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ICell;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.web.selenium.elements.complex.table.Column.column;

/**
 * Created by Roman_Iovlev on 10/22/2015.
 */
public class JobListingPage extends WebPage {

    @FindBy(className = "search-result-list")
    public ITable jobsList = new Table(null,
            By.xpath(".//li[%s]//div"),
            By.xpath(".//li//div[%s]"))
            .hasColumnHeaders(JobListHeaders.class);

    public void getJobRowByName(String jobName) {
        MapArray<String, ICell> row = jobsList.row(jobName, Column.column(JobListHeaders.JOB_NAME.toString()));
        row.get(JobListHeaders.APPLY.toString()).select();
    }
}
