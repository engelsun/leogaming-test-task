package com.engelsun.leogamingtesttask.dto.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment")
public class PaymentDTO extends RequestBodyDTO {
    @XmlAttribute
    private Long id;

    @XmlAttribute
    private Integer sum;

    @XmlAttribute
    private Integer check;

    @XmlAttribute
    private Integer service;

    @XmlAttribute
    private String account;

    @XmlAttribute
    private String date;
}
