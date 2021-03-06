package com.crud.travel.agency.service;

import com.crud.travel.agency.domain.Mail;
import com.crud.travel.agency.domain.MailToCustomers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail) {
        LOGGER.info("Starting email preparation");
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            javaMailSender.send(mailMessage);
            LOGGER.info("Email has benn sent.");
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        return mailMessage;
    }

    public void sendToAllCustomers(final MailToCustomers mailToCustomers) {
        LOGGER.info("Starting email preparation");
        try {
            SimpleMailMessage mailMessage = createMailMessage(mailToCustomers);
            javaMailSender.send(mailMessage);
            LOGGER.info("Email has benn sent.");
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(final MailToCustomers mailToCustomers) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(String.valueOf(mailToCustomers.getMailTo()));
        mailMessage.setSubject(mailToCustomers.getSubject());
        mailMessage.setText(mailToCustomers.getMessage());

        return mailMessage;
    }
}
