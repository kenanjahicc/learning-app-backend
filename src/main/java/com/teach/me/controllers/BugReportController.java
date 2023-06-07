package com.teach.me.controllers;

import com.teach.me.models.BugReportDto;
import com.teach.me.services.BugReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
