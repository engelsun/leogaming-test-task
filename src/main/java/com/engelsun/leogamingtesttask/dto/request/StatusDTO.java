package com.engelsun.leogamingtesttask.dto.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "status")
public class StatusDTO extends RequestBodyDTO {
    @XmlAttribute
    private Long id;
}
