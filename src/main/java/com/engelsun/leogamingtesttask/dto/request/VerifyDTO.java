package com.engelsun.leogamingtesttask.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@XmlRootElement(name = "verify")
public class VerifyDTO extends RequestBodyDTO {
    @XmlAttribute
    private Integer service;

    @XmlAttribute
    private String account;
}