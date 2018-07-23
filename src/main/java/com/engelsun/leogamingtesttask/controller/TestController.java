package com.engelsun.leogamingtesttask.controller;

import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.service.RequestDispatcherService;
import com.engelsun.leogamingtesttask.util.PrettyPrintResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SignatureException;

@RestController
@RequestMapping(path = "/test")
public class TestController {
    private final RequestDispatcherService requestDispatcherService;

    @Autowired
    public TestController(RequestDispatcherService requestDispatcherService) {
        this.requestDispatcherService = requestDispatcherService;
    }

    @PostMapping(path = "/accept", produces = "application/xml")
    public ResponseDTO accept(@RequestBody RequestDTO requestDTO) throws SignatureException {
        return requestDispatcherService.redirect(requestDTO, PrettyPrintResponse.TRUE);
    }
}