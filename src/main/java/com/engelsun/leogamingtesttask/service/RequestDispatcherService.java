package com.engelsun.leogamingtesttask.service;

import com.engelsun.leogamingtesttask.dto.request.PaymentDTO;
import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.dto.response.ResultDTO;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Collections;

@Component
public class RequestDispatcherService {

    public ResponseDTO redirect(RequestDTO requestDTO) {
        PaymentDTO requestBodyDTO = (PaymentDTO) requestDTO.getBody().get(0);
        return ResponseDTO.builder()
                .result(Collections.singletonList(
                        ResultDTO.builder()
                                .id(requestBodyDTO.getId())
                                .state(60)
                                .subState(0)
                                .code(0)
                                .finale(1)
                                .trans(123456789)
                                .service(requestBodyDTO.getService())
                                .serverTime(ZonedDateTime.now())
                                .build()
                        )
                )
                .build();
    }
}