package com.engelsun.leogamingtesttask.controller;

import com.engelsun.leogamingtesttask.dto.request.PaymentDTO;
import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.dto.response.ResultDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Collections;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @PostMapping(path = "/accept", produces = "application/xml")
    public ResponseDTO redirect(@RequestBody RequestDTO requestDTO) {
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