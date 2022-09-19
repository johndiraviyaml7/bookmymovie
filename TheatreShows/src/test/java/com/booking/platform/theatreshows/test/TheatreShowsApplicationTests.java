package com.booking.platform.theatreshows.test;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TheatreShowsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Value("${mybookingshow.app.pass.jasypt.key}")
	private String jasyptSecret;
	
	@Test
	public void passwordTestEncryptor() {
		PooledPBEStringEncryptor encryptor= new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config= new SimpleStringPBEConfig();
		config.setPassword(jasyptSecret); //encryptor's private key
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1"); 
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config);
		
		String plainText="bkpm0ng04b";
		System.out.println("** The encrypt bookingticketsdb bkpm0ng04b :::"+encryptor.encrypt(plainText));
		String plainTextPw="bkp2s3sh";
		System.out.println("** The encrypt passowrd:::"+encryptor.encrypt(plainTextPw));
		System.out.println("**  : The encrypt passowrd:::"+encryptor.decrypt("RG700sydhRN7cPY9+5ShBg=="));
		
		
		
	}
}
