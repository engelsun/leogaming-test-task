package com.engelsun.leogamingtesttask.util;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.security.PrivateKey;
import java.security.PublicKey;

import static org.junit.Assert.*;

public class EncryptionKeysTest {
    @Test
    public void publicKeyNotNull() throws Exception {
        PublicKey publicKey = EncryptionKeys.getPublic();
        assertNotNull(publicKey);
    }

    @Test
    public void privateKeyNotNull() throws Exception {
        PrivateKey privateKey = EncryptionKeys.getPrivate();
        assertNotNull(privateKey);
    }

}