package com.crud.travel.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MailToCustomers {
    private String mailTo;
    private String subject;
    private String message;

}
