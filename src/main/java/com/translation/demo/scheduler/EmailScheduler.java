package com.translation.demo.scheduler;

import com.translation.demo.config.AdminConfig;
import com.translation.demo.domain.Mail;
import com.translation.demo.service.SimpleEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: Once a day email";

    private SimpleEmailService simpleEmailService;
    private AdminConfig adminConfig;

    public EmailScheduler(SimpleEmailService simpleEmailService, AdminConfig adminConfig) {
        this.simpleEmailService = simpleEmailService;
        this.adminConfig = adminConfig;
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, "Test Mail", null));
    }
}