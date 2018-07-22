package com.engelsun.leogamingtesttask.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@XmlRootElement(name = "status")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusDTO extends RequestBodyDTO {
    @XmlAttribute
    private Long id;
}
