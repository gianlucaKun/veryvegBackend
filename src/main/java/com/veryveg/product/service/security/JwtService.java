package com.veryveg.product.service.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veryveg.product.entity.User;
import com.veryveg.product.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtService {

	private static final String SECRET_KEY = "laTuaChiaveSegreta";

	private static final long EXPIRATION_TIME = 3600000;

	@Autowired
	private UserRepository ur;

	@SuppressWarnings("deprecation")
	public String generateToken(String username) {
		System.out.println(username);
		User u = ur.findByUsername(username);
		System.out.println(u);

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

		return Jwts.builder().setSubject(username).setIssuedAt(now).claim("id", u.getId()).claim("role", u.getRole())
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
	}

	public boolean validateTokenAdmin(String token) {
		try {
			Claims claims = parseToken(token);
			System.out.println("sei nel validatore dell'admin");
			String role = claims.get("role").toString();
			System.out.println("ruolo: " + role.toString());
			if (role.equals("Amministratore")) {
				System.out.println("controllo superato");
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static Claims parseToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
}
