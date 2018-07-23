package com.engelsun.leogamingtesttask.service;

import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.util.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.SignatureException;

@Service
public class RequestDispatcherService {
    @Value("${input-data.url}")
    private String URL;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseDTO redirect(RequestDTO requestDTO) throws SignatureException {
        String request = Marshaller.requestToString(requestDTO);
        String massage = encryptionService.sign(request);

        HttpHeaders headers = new HttpHeaders();
        headers.add("PayLogic-Signature", massage);
        headers.setContentType(MediaType.APPLICATION_XML);

        HttpEntity<String> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                URL,
                requestEntity,
                String.class
        );
        ResponseDTO responseDTO;
        if (responseEntity.hasBody()) {
            String body = responseEntity.getBody();
            System.out.println(" response " + body);
            responseDTO = Marshaller.stringToResponse(body);
            System.out.println("responedtO = " + responseDTO);
            return responseDTO;
        }
        return null;
    }
}