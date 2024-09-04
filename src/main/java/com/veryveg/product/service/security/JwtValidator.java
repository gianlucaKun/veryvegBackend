package com.veryveg.product.service.security;


import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	
	private static final String SECRET_KEY = "laTuaChiaveSegreta";
	
	public boolean validateToken(String token) {
		System.out.println("sei nel validator  e il token passato è: " + token);
		try {
			Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
			Date expirationDate = claims.getExpiration();
			return expirationDate.after(new Date());
		} catch (Exception e ) {
			System.out.println("errore nel token");
            // Se si verifica un'eccezione durante il parsing del token, il token non è valido
            return false;
		}
	}
}
