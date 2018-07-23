package com.engelsun.leogamingtesttask.dto.request;

import com.engelsun.leogamingtesttask.util.ZonedDateTimeAdapter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
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
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    private ZonedDateTime date;
}
