package com.example.check_backend.global.security.jwt;

import com.example.check_backend.domain.user.controller.dto.reponse.TokenResponse;
import com.example.check_backend.global.exception.ExpiredTokenException;
import com.example.check_backend.global.exception.InvalidTokenException;
import com.example.check_backend.global.security.auth.CustomUserDetailsService;
import com.example.check_backend.global.security.jwt.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    public TokenResponse getToken(String accountId) {
        String accessToken = generateToken(accountId, jwtProperties.getAccessExp());
        LocalDateTime expiredAt = LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp());
        return new TokenResponse(accessToken, expiredAt);
    }

    private String generateToken(String accountId, Long expiration) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey()).setSubject(accountId).setHeaderParam("typ", "access").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expiration * 1000)).compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperties.getHeader());
        return parseToken(bearer);
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            return bearerToken.replace("Bearer", "");
        } else return null;
    }

    public UsernamePasswordAuthenticationToken authorization(String token) {
        if (token != null) {
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(getTokenSubject(token));
            return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        }
        return null;
    }

    private String getTokenSubject(String subject) {
        return getTokenBody(subject).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException();
        } catch (InvalidClaimException e) {
            throw new InvalidTokenException();
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }
}

