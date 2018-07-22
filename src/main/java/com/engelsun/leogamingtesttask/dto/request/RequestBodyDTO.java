package com.engelsun.leogamingtesttask.dto.request;

import com.engelsun.leogamingtesttask.dto.AttributeDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({VerifyDTO.class, PaymentDTO.class, StatusDTO.class, AttributeDTO.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class RequestBodyDTO {
    @XmlElement
    private AttributeDTO attribute;
}
