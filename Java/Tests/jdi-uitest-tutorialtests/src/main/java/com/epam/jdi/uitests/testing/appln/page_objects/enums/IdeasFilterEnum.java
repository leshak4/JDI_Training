package com.epam.jdi.uitests.testing.appln.page_objects.enums;

public enum IdeasFilterEnum {
    ALL("All", "All"),
    ANALYST_REPORTS("Analyst Reports", "Analyst Report"),
    WHITE_PAPERS("White Papers", "White Paper"),
    VIDEOS("Videos", "Video"),
    BLOG("Blog", "Blog Article"),
    CASE_STUDIES("Case Studies", "Case Study"),
    BROCHURES("Brochures", "Brochure");

    public String value;
    public String tag;
    IdeasFilterEnum(String value, String tag) {
        this.value = value;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getTag() {
        return tag;
    }
}
