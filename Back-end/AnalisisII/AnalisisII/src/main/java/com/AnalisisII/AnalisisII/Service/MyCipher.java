package com.AnalisisII.AnalisisII.Service;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

public class MyCipher {

	public static SecureRandom sr = new SecureRandom();

	public static String encrypted(String password) {
		String clave = "FooBar1234567890"; // 128 bit
		byte[] iv = new byte[16];

		// sr.nextBytes(iv);

		String encryptedPassword = encriptar(clave, iv, password);

		return encryptedPassword;
	}

	public static String encriptar(String clave, byte[] iv, String value) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, sks, new IvParameterSpec(iv));

			byte[] encriptado = cipher.doFinal(value.getBytes());

			return DatatypeConverter.printBase64Binary(encriptado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decriptar(String clave, byte[] iv, String encriptado) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
			cipher.init(Cipher.DECRYPT_MODE, sks, new IvParameterSpec(iv));

			byte[] dec = cipher.doFinal(DatatypeConverter.parseBase64Binary(encriptado));
			return new String(dec);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
