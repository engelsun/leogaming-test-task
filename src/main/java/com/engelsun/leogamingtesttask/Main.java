package com.engelsun.leogamingtesttask;

import com.engelsun.leogamingtesttask.service.RequestDispatcherService;
import com.engelsun.leogamingtesttask.util.Logger;
import com.engelsun.leogamingtesttask.util.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.security.SignatureException;

@ComponentScan("com.engelsun.leogamingtesttask")
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

        service.redirect(TestData.requestVerifyDTO);
        service.redirect(TestData.requestPaymentDTO);
        service.redirect(TestData.requestStatusDTO);
    }
}
