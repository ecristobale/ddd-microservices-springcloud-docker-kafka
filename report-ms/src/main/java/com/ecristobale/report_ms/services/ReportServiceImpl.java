package com.ecristobale.report_ms.services;

import com.ecristobale.report_ms.helpers.ReportHelper;
import com.ecristobale.report_ms.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String name) {
        this.reportHelper.readTemplate();
        return this.companiesRepository.getByName(name).orElseThrow().getName();
    }

    @Override
    public String saveReport(String nameReport) {
        return "Report " + nameReport + " has been saved";
    }

    @Override
    public void deleteReport(String name) {
        System.out.println("Report " + name + " has been deleted");
    }
}
