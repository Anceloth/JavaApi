package com.ionix.rest.core.usecases;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.stereotype.Component;

@Component
public class CodeParamUsingDESUseCase implements UseCase<String, String>{

	@Override
	public String ejecutar(String param) throws Exception {
		DESKeySpec keySpec = new DESKeySpec("ionix123456".getBytes("UTF8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey ks = keyFactory.generateSecret(keySpec);
		
		byte[] cleartext = param.getBytes("UTF8");
		Cipher cipher = Cipher.getInstance("DES");
		
		cipher.init(Cipher.ENCRYPT_MODE, ks);
		byte[] bloque_cifrado = cipher.doFinal(cleartext);
		
		// String encryptedRut = new String(bloque_cifrado, "UTF8");
		
		String encryptedRut = Base64.getEncoder().encodeToString(bloque_cifrado);
		return encryptedRut;
	}

}
