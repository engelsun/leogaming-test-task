package com.engelsun.leogamingtesttask.util;

import com.engelsun.leogamingtesttask.dto.request.PaymentDTO;
import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.request.StatusDTO;
import com.engelsun.leogamingtesttask.dto.request.VerifyDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.dto.response.ResultDTO;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;

import static com.engelsun.leogamingtesttask.util.Props.POINT;
import static com.engelsun.leogamingtesttask.util.Props.SERVICE;

public class TestData {

    public static VerifyDTO verifyDTO = VerifyDTO.builder()
            .service(SERVICE)
            .account("12345")
            .build();

    public static PaymentDTO paymentDTO1 = PaymentDTO.builder()
            .id(1L)
            .sum(1000)
            .check(999)
            .service(SERVICE)
            .account("12345")
//            .date(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .date(ZonedDateTime.now())
            .build();
    public static PaymentDTO paymentDTO2 = PaymentDTO.builder()
            .id(2L)
            .sum(1000)
            .check(1000)
            .service(SERVICE)
            .account("12346")
//            .date(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .date(ZonedDateTime.now())
            .build();

    public static StatusDTO statusDTO1 = StatusDTO.builder()
            .id(1L)
            .build();
    public static StatusDTO statusDTO2 = StatusDTO.builder()
            .id(2L)
            .build();

    public static ResultDTO resultDTO1 = ResultDTO.builder()
            .id(1L)
            .state(60)
            .subState(0)
            .code(0)
            .finale(1)
            .trans(123456789)
//            .serverTime(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .serverTime(ZonedDateTime.now())
            .build();
    public static ResultDTO resultDTO2 = ResultDTO.builder()
            .id(2L)
            .state(60)
            .subState(0)
            .code(30)
            .finale(1)
            .trans(123456799)
//            .serverTime(ZonedDateTime.parse("2018-07-23T08:38:10+03:00"))
            .serverTime(ZonedDateTime.now())
            .build();

    public static RequestDTO requestVerifyDTO = RequestDTO.builder()
            .point(POINT)
            .body(Collections.singletonList(verifyDTO))
            .build();

    public static RequestDTO requestPaymentDTO = RequestDTO.builder()
            .point(POINT)
            .body(Arrays.asList(paymentDTO1, paymentDTO2))
            .build();

    public static RequestDTO requestStatusDTO = RequestDTO.builder()
            .point(POINT)
            .body(Arrays.asList(statusDTO1, statusDTO2))
            .build();

    public static ResponseDTO responseVerifyDTO = ResponseDTO.builder()
            .result(Collections.singletonList(resultDTO1))
            .build();
    public static ResponseDTO responsePaymentDTO = ResponseDTO.builder()
            .result(Arrays.asList(resultDTO1, resultDTO2))
            .build();
    public static ResponseDTO responseStatusDTO = ResponseDTO.builder()
            .result(Arrays.asList(resultDTO1, resultDTO2))
            .build();
}