package com.epam.jdi.uitests.testing.appln.page_objects.entities;

import com.epam.jdi.uitests.testing.appln.page_objects.enums.JobCategories;

import static org.openqa.selenium.Keys.RETURN;

/**
 * Created by Roman_Iovlev on 10/22/2015.
 */
public class JobSearchFilter {
    public CharSequence keywords = "QA" + RETURN;
    public JobCategories category = JobCategories.QA;
    //public String location;
}
