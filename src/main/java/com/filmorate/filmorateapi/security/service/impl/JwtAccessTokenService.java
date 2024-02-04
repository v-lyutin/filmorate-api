package com.filmorate.filmorateapi.security.service.impl;

import com.filmorate.filmorateapi.security.exception.JwtAccessTokenServiceException;
import com.filmorate.filmorateapi.security.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtAccessTokenService implements AccessTokenService {
    private final JwtEncoder jwtEncoder;

    @Override
    public String generateToken(Authentication authentication) {
        UserDetails userDetails = getUserDetailsFromAuthentication(authentication);
        List<String> roles = getAuthorities(userDetails);
        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(1, ChronoUnit.DAYS);

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .claim("scope", roles)
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .subject(userDetails.getUsername())
                .build();

        return jwtEncoder
                .encode(JwtEncoderParameters.from(claimsSet))
                .getTokenValue();
    }

    private UserDetails getUserDetailsFromAuthentication(Authentication authentication) {
        return Optional.of(authentication.getPrincipal())
                .filter(UserDetails.class::isInstance)
                .map(UserDetails.class::cast)
                .orElseThrow(() -> new JwtAccessTokenServiceException(
                        "Не удалось сформировать объект UserDetails из объекта Authentication")
                );
    }

    private List<String> getAuthorities(UserDetails userDetails) {
        return userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }
}
