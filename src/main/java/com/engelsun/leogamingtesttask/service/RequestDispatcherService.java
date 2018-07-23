package com.engelsun.leogamingtesttask.service;

import com.engelsun.leogamingtesttask.dto.request.RequestDTO;
import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.util.Logger;
import com.engelsun.leogamingtesttask.util.Marshaller;
import com.engelsun.leogamingtesttask.util.Props;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.SignatureException;

@Service
public class RequestDispatcherService {

    private EncryptionService encryptionService;
    private RestTemplate restTemplate;
    private ResponseHandler responseHandler;

    @Autowired
    public RequestDispatcherService(EncryptionService encryptionService, RestTemplate restTemplate, ResponseHandler responseHandler) {
        this.encryptionService = encryptionService;
        this.restTemplate = restTemplate;
        this.responseHandler = responseHandler;
    }

    public ResponseDTO redirect(RequestDTO requestDTO) throws SignatureException {
        String massage = Marshaller.requestToString(requestDTO);
        String signature = encryptionService.sign(massage);

        printRequest(massage, signature);

        HttpEntity<String> requestEntity = makeRequestEntity(massage, signature);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                Props.URL,
                requestEntity,
                String.class);

        return responseHandler.handle(responseEntity);
    }

    private HttpEntity<String> makeRequestEntity(String request, String signature) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(Props.HEADER, signature);
        headers.setContentType(MediaType.APPLICATION_XML);

        return new HttpEntity<>(request, headers);
    }

    private void printRequest(String request, String signature) {
        Logger.info("\n#################################################");
        Logger.info("# REQUEST SIGNATURE: " + signature);
        Logger.info("####  REQUEST:  ####################################");
        Logger.info(request);
    }
}