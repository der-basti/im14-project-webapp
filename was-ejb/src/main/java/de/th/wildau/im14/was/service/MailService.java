package de.th.wildau.im14.was.service;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class MailService implements Serializable {

	private static final long serialVersionUID = 7345551127477024503L;

	protected static final String LINE_BREAK = System
			.getProperty("line.separator");

	@Inject
	protected Logger log;

	@Resource(name = "java:jboss/mail/wasMail")
	private Session session;

	public void send(String address, String topic, String textMessage) {
		// this.session.getProperties().put("mail.smtp.host",
		// "smtp.der-basti.com");
		// this.session.getProperties().put("mail.smtp.auth", "true");
		// this.session.getProperties().put("mail.smtp.port", "587");
		// this.session.getProperties().put("mail.smtp.starttls.enable",
		// "true");
		// this.session.getProperties().put("mail.smtp.socketFactory.class",
		// "javax.net.ssl.SSLSocketFactory");
		MimeMessage m = new MimeMessage(this.session);
		try {
			// m.setFrom(from);
			m.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(address));
			m.setSentDate(new java.util.Date());
			m.setSubject(topic);
			m.setContent(textMessage, "text/plain");
			Transport.send(m);// throws exception
		} catch (final MessagingException e) {
			e.printStackTrace();
			this.log.warning("Cannot send mail" + e);
		}
	}
}
