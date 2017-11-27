package br.com.vitrinegastronomica.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
	
	public String generateHash(String arg) {
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(arg.getBytes(), 0, arg.length());
		/*
		 * SETA A SENHA PARA UM HASHCODE MD5
		 */
		return arg = new BigInteger(1, m.digest()).toString(16);
	}
	
}
