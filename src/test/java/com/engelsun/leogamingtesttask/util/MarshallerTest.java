package com.engelsun.leogamingtesttask.util;

import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import org.junit.Test;

import static com.engelsun.leogamingtesttask.util.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarshallerTest {

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