package com.engelsun.leogamingtesttask.service;

import org.junit.Before;
import org.junit.Test;

import java.security.SignatureException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EncryptionServiceTest {
    private static String signature = "";
    private final static String massage = "helloworld";
    private static EncryptionService encryptionService = new EncryptionService();

    @Before
    public void setSignature() throws SignatureException {
        signature = encryptionService.sign(massage);
    }

    @Test
    public void signNotNull() throws SignatureException {
        assertNotNull(signature);
    }

    @Test
    public void verifyThatSignIsTrue() throws SignatureException {
        boolean isConfirm = encryptionService.verify(massage, signature);
        assertTrue(isConfirm);
    }

    @Test(expected = SignatureException.class)
    public void signPastNull() throws SignatureException {
        signature = encryptionService.sign(null);
        assertNotNull(signature);
    }
}