package com.am.telegram.groupstat.user.report.excel;

import com.am.telegram.groupstat.user.report.statistic.BasicGroupStatistic;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;

public class ExcelReport {

    private final Sheet sheet;

    public ExcelReport(Workbook workbook) {
        this.sheet = new Sheet((XSSFSheet) workbook.createSheet(""));
    }

    public void generate(List<BasicGroupStatistic> groupStatistics) {
        sheet.addHeader();
        sheet.addData(groupStatistics);
    }
}
