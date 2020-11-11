package com.knr.springapp.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptorMain {

	public static void main(String[] args) {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		enc.setPassword("dobbyisfree");
		System.out.println("ENC("+enc.encrypt("net.sf.log4jdbc.DriverSpy")+")");
		System.out.println("ENC("+enc.encrypt("jdbc:log4jdbc:oracle:thin:@localhost:1521/xe")+")");
		System.out.println("ENC("+enc.encrypt("hr")+")");
		System.out.println("ENC("+enc.encrypt("hr")+")");

	}

}
