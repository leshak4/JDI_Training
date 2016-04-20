package com.epam.jdi.uitests.web.selenium.elements.complex.table;
/*
 * Copyright 2004-2016 EPAM Systems
 *
 * This file is part of JDI project.
 *
 * JDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JDI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JDI. If not, see <http://www.gnu.org/licenses/>.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman_Iovlev on 10/9/2015.
 */
public class TableSettings {
    public boolean columnHasHeaders = true;
    public boolean rowHasHeaders = false;
    public List<String> columnHeaders;
    public List<String> rowHeaders;
    public int columnsCount;
    public int rowsCount;

    public TableSettings() {
    }

    public TableSettings(boolean columnHasHeaders, boolean rowHasHeaders) {
        this.columnHasHeaders = columnHasHeaders;
        this.rowHasHeaders = rowHasHeaders;
    }

    public TableSettings(List<String> columnHeaders, List<String> rowHeaders) {
        this.columnHeaders = new ArrayList<>(columnHeaders);
        this.rowHeaders = new ArrayList<>(rowHeaders);
    }

    public TableSettings(int columnsCount, int rowsCount) {
        this.columnsCount = columnsCount;
        this.rowsCount = rowsCount;
    }
}