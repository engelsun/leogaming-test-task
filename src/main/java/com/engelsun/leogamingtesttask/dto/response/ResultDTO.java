package com.engelsun.leogamingtesttask.dto.response;

import com.engelsun.leogamingtesttask.dto.AttributeDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultDTO {
    @XmlAttribute
    private Long id;

    @XmlAttribute(name = "state")
    private Integer state;

    @XmlAttribute(name = "substate")
    private Integer subState;

    @XmlAttribute
    private Integer code;

    @XmlAttribute(name = "final")
    private Integer fianle;

    @XmlAttribute
    private Integer trans;

    @XmlAttribute
    private Integer service;

    @XmlAttribute
    private Integer sum;

    @XmlAttribute
    private Integer commission;

    @XmlAttribute(name = "sum_prov")
    private Integer sumProv;

    @XmlAttribute(name = "server_time")
    private String serverTime;

    @XmlElement(name = "attribute")
    private List<AttributeDTO> attributeDTO;
}
