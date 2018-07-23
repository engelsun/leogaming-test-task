package com.engelsun.leogamingtesttask.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptionKeys {
    private static final String PUBLIC_KEY_FILE = "public.pem";
    private static final String PRIVATE_KEY_FILE = "private.pem";

    public static PublicKey getPublic() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, URISyntaxException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(PUBLIC_KEY_FILE).toURI()));

        String publicKey = new String(keyBytes);
        publicKey = publicKey
                .replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(Base64.decodeBase64(publicKey));

        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public static PrivateKey getPrivate() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, URISyntaxException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(PRIVATE_KEY_FILE).toURI()));

        String privateKey = new String(keyBytes);
        privateKey = privateKey
                .replaceAll("(-+BEGIN PRIVATE KEY-+\\r?\\n|-+END PRIVATE KEY-+\\r?\\n?)", "");

        PKCS8EncodedKeySpec spec =
                new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));

        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}