package com.engelsun.leogamingtesttask.dto.request;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestDTO {
    @XmlAttribute
    private Integer point;

    @XmlElementRef
    private List<RequestBodyDTO> body;
}
