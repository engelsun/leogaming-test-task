package com.engelsun.leogamingtesttask.service;

import com.engelsun.leogamingtesttask.dto.response.ResponseDTO;
import com.engelsun.leogamingtesttask.util.Logger;
import com.engelsun.leogamingtesttask.util.Marshaller;
import com.engelsun.leogamingtesttask.util.PrettyPrintResponse;
import com.engelsun.leogamingtesttask.util.Props;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.SignatureException;
import java.util.Optional;

/**
 * Service class that provides handle of responses from remote server and
 * returns handled response to {@link RequestDispatcherService} class
 */
@Service
public class ResponseHandler {
    @Autowired
    private EncryptionService encryptionService;

    ResponseDTO handle(ResponseEntity<String> responseEntity, PrettyPrintResponse prettyPrintResponse) throws SignatureException {
        if (responseEntity.hasBody()) {
            String massage = responseEntity.getBody();

            HttpHeaders headers = responseEntity.getHeaders();
            if (headers.containsKey(Props.HEADER)) {
                boolean isTrue = verifySignature(massage, headers);
                if (isTrue) {
                    Logger.info("############  ....VERIFYING IS CONFIRMED  ##############");
                    ResponseDTO responseDTO = Marshaller.stringToResponse(massage);
                    if (prettyPrintResponse == PrettyPrintResponse.TRUE) {
                        massage = Marshaller.responseToString(responseDTO);
                    }
                    printResponse(massage);
                    return responseDTO;
                } else {
                    Logger.info("############  ....VERIFYING IS UNCONFIRMED  ##############");
                }
            }
        }
        return null;
    }

    private boolean verifySignature(String massage, HttpHeaders headers) throws SignatureException {
        Optional<String> signature = Optional.ofNullable(headers.get(Props.HEADER).get(0));
        Logger.info("##################################################");
        Logger.info("#  RESPONSE SIGNATURE = " + signature.get());
        Logger.info("#  VERIFYING....  ####################################");
        return encryptionService.verify(massage, signature.orElse(""));
    }

    private void printResponse(String massage) {
        Logger.info("####  RESPONSE:  ####################################");
        Logger.info(massage);
        Logger.info("##################################################");
    }
}