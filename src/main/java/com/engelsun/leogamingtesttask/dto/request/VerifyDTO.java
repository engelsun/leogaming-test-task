package com.engelsun.leogamingtesttask.dto.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "verify")
public class VerifyDTO extends RequestBodyDTO {
    @XmlAttribute
    private Integer service;

    @XmlAttribute
    private String account;
}
