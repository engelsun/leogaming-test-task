package com.engelsun.leogamingtesttask.dto.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
public class ResponseDTO {
    @XmlElement
    private List<ResultDTO> result;
}
