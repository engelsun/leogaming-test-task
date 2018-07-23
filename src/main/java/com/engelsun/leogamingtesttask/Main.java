package com.engelsun.leogamingtesttask;

import com.engelsun.leogamingtesttask.service.RequestDispatcherService;
import com.engelsun.leogamingtesttask.util.Logger;
import com.engelsun.leogamingtesttask.util.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.security.SignatureException;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) throws SignatureException {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RequestDispatcherService service = context.getBean(RequestDispatcherService.class);

        Logger.info("");
        service.redirect(TestData.requestVerifyDTO);
        Logger.info("");
        service.redirect(TestData.requestPaymentDTO);
        Logger.info("");
        service.redirect(TestData.requestStatusDTO);
    }
}
