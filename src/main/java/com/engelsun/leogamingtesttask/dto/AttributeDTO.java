package com.engelsun.leogamingtesttask.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attribute")
@XmlAccessorType(XmlAccessType.FIELD)
public class AttributeDTO {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private String value;
}
