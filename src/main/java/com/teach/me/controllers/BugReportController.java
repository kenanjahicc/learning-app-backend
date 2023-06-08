package com.teach.me.controllers;

import com.teach.me.models.BugReportDto;
import com.teach.me.services.BugReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bug-report")
@RestController
public class BugReportController {
    private final BugReportService bugReportService;

    BugReportController(BugReportService bugReportService) {
        this.bugReportService = bugReportService;
    }

    @GetMapping("/{id}")
    public BugReportDto getBugReport(@PathVariable long id) {
        return bugReportService.getBugReport(id);
    }

}
