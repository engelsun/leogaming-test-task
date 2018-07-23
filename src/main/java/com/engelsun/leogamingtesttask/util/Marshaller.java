package com.engelsun.leogamingtesttask.util;

import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.io.StringWriter;

public class Marshaller {
    public static RequestDTO stringToRequest(String massage) {
        return JAXB.unmarshal(new StringReader(massage), RequestDTO.class);
    }

    public static ResponseDTO stringToResponse(String massage) {
        return JAXB.unmarshal(new StringReader(massage), ResponseDTO.class);
    }

    public static String requestToString(RequestDTO requestDTO) {
        return marshal(requestDTO, RequestDTO.class);
    }

    public static String responseToString(ResponseDTO responseDTO) {
        return marshal(responseDTO, ResponseDTO.class);
    }

    private static <T> String marshal(T object, Class<T> tClass) {
        String xmlString = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
            javax.xml.bind.Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty("jaxb.fragment", Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(object, sw);
            xmlString = sw.toString();
            return xmlString;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString;
    }
}