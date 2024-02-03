package com.filmorate.filmorateapi.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class RsaKeyConfig {
    @Bean
    public RsaKeys generateRsaKey() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        }
        catch (Exception exception) {
            throw new IllegalStateException(exception);
        }
        return new RsaKeys(
                (RSAPublicKey) keyPair.getPublic(),
                (RSAPrivateKey) keyPair.getPrivate()
        );
    }
}
