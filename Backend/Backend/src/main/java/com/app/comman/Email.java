package com.app.comman;

import java.util.Arrays;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Email {

	// this is resposnsible to send message
	public static void sendEmail(String to) { // TODO Auto-generated method stub

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("shivrajdesai24@gmail.com", "uzulyayiaybkjojc");
			}
		});

		session.setDebug(true); // composing Message
		MimeMessage m = new MimeMessage(session);
		try {
			m.setFrom("shivrajdesai24@gmail.com");

			// add recepient
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			char[] otp = OTP.generateOTP(6);
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < otp.length; i++) {
				str.append(otp[i]);
			}
			m.setSubject("This is Regarding Password Change");
			m.setText("OTP for Change password is" + " " + str);

			// sending a Message using Transport class
			Transport.send(m);
			System.out.println("Email Sent Successfully....");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
