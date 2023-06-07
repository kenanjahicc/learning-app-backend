package com.teach.me.services;

import com.teach.me.models.BugReportDto;
import com.teach.me.models.entities.BugReport;
import com.teach.me.repositories.BugReportRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BugReportService {

    private final BugReportRepository bugReportRepository;

    public BugReportService(BugReportRepository bugReportRepository) {
        this.bugReportRepository = bugReportRepository;
    }


    public BugReportDto getBugReport(long id) {
        return toDto(getEntity(id));
    }

    private BugReport getEntity(long id) {
        Optional<BugReport> bugReportOptional = bugReportRepository.findById(id);
        if (bugReportOptional.isPresent()) {
            return bugReportOptional.get();
        }

        throw new RuntimeException("BugReport with id:" + id + " does not exist!");
    }

    private static BugReportDto toDto(BugReport bugReport) {
        return new BugReportDto(bugReport.getId(),
                bugReport.getTitle(),
                bugReport.getImage(),
                bugReport.getDescription());
    }

    private static BugReport toEntity(BugReportDto bugReportDto) {
        BugReport bugReport = new BugReport();
        bugReport.setTitle(bugReportDto.getTitle());
        bugReport.setImage(bugReportDto.getImage());
        bugReport.setDescription(bugReportDto.getDescription());
        return bugReport;
    }
}
