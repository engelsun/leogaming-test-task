package com.engelsun.leogamingtesttask.dto.response;

import com.engelsun.leogamingtesttask.dto.AttributeDTO;
import com.engelsun.leogamingtesttask.util.ZonedDateTimeAdapter;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
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
    private Integer finale;

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
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    private ZonedDateTime serverTime;

    @XmlElement(name = "attribute")
    private List<AttributeDTO> attributeDTO;
}
