package com.engelsun.leogamingtesttask.util;

import com.engelsun.leogamingtesttask.dto.request.PaymentDTO;
import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.request.StatusDTO;
import com.engelsun.leogamingtesttask.dto.request.VerifyDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.dto.response.ResultDTO;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class MarshallerTest {

    private VerifyDTO verifyDTO = VerifyDTO.builder()
            .service(4390)
            .account("12345")
            .build();

    private PaymentDTO paymentDTO1 = PaymentDTO.builder()
            .id(1L)
            .sum(1000)
            .check(999)
            .service(4390)
            .account("12345")
            .date(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .build();
    private PaymentDTO paymentDTO2 = PaymentDTO.builder()
            .id(2L)
            .sum(1000)
            .check(1000)
            .service(4390)
            .account("12346")
            .date(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .build();

    private StatusDTO statusDTO1 = StatusDTO.builder()
            .id(1L)
            .build();
    private StatusDTO statusDTO2 = StatusDTO.builder()
            .id(2L)
            .build();

    private ResultDTO resultDTO1 = ResultDTO.builder()
            .id(1L)
            .state(60)
            .subState(0)
            .code(0)
            .finale(1)
            .trans(123456789)
            .serverTime(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .build();
    private ResultDTO resultDTO2 = ResultDTO.builder()
            .id(2L)
            .state(60)
            .subState(0)
            .code(30)
            .finale(1)
            .trans(123456799)
            .serverTime(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .build();

    private RequestDTO requestVerifyDTO = RequestDTO.builder()
            .point(327)
            .body(Collections.singletonList(verifyDTO))
            .build();

    private RequestDTO requestPaymentDTO = RequestDTO.builder()
            .point(327)
            .body(Arrays.asList(paymentDTO1, paymentDTO2))
            .build();

    private RequestDTO requestStatusDTO = RequestDTO.builder()
            .point(327)
            .body(Arrays.asList(statusDTO1, statusDTO2))
            .build();

    private ResponseDTO responseVerifyDTO = ResponseDTO.builder()
            .result(Collections.singletonList(resultDTO1))
            .build();
    private ResponseDTO responsePaymentDTO = ResponseDTO.builder()
            .result(Arrays.asList(resultDTO1, resultDTO2))
            .build();
    private ResponseDTO responseStatusDTO = ResponseDTO.builder()
            .result(Arrays.asList(resultDTO1, resultDTO2))
            .build();

    @Test
    public void requestVerifyToStringNotNull() {
        String request = Marshaller.requestToString(requestVerifyDTO);
        assertNotNull(request);
    }

    @Test
    public void responseVerifyToStringNotNull() {
        String request = Marshaller.responseToString(responseVerifyDTO);
        assertNotNull(request);
    }

    @Test
    public void requestPaymentToStringNotNull() {
        String request = Marshaller.requestToString(requestPaymentDTO);
        assertNotNull(request);
    }

    @Test
    public void responsePaymentToStringNotNull() {
        String request = Marshaller.responseToString(responsePaymentDTO);
        assertNotNull(request);
    }

    @Test
    public void requestStatusToStringNotNull() {
        String request = Marshaller.requestToString(requestStatusDTO);
        assertNotNull(request);
    }

    @Test
    public void responseStatusToStringNotNull() {
        String request = Marshaller.responseToString(responseStatusDTO);
        assertNotNull(request);
    }

    @Test
    public void requestVerifyDTOEqualsToRequestVerifyString() {
        String requestString = Marshaller.requestToString(requestVerifyDTO);
        RequestDTO requestDTO = Marshaller.stringToRequest(requestString);
        assertEquals(requestVerifyDTO, requestDTO);
    }

    @Test
    public void requestPaymentDTOEqualsToRequestPaymentString() {
        String requestString = Marshaller.requestToString(requestPaymentDTO);
        RequestDTO requestDTO = Marshaller.stringToRequest(requestString);
        assertEquals(requestPaymentDTO, requestDTO);
    }

    @Test
    public void requestStatusDTOEqualsToRequestStatusString() {
        String requestString = Marshaller.requestToString(requestStatusDTO);
        RequestDTO requestDTO = Marshaller.stringToRequest(requestString);
        assertEquals(requestStatusDTO, requestDTO);
    }

    @Test
    public void responseVerifyDTOEqualsToResponseVerifyString() {
        String responseString = Marshaller.responseToString(responseVerifyDTO);
        ResponseDTO responseDTO = Marshaller.stringToResponse(responseString);
        assertEquals(responseVerifyDTO, responseDTO);
    }

    @Test
    public void responsePaymentDTOEqualsToResponsePaymentString() {
        String responseString = Marshaller.responseToString(responsePaymentDTO);
        ResponseDTO responseDTO = Marshaller.stringToResponse(responseString);
        assertEquals(responsePaymentDTO, responseDTO);
    }

    @Test
    public void responseStatusDTOEqualsToResponseStatusString() {
        String responseString = Marshaller.responseToString(responseStatusDTO);
        ResponseDTO responseDTO = Marshaller.stringToResponse(responseString);
        assertEquals(responseStatusDTO, responseDTO);
    }
}