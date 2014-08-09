package prince.smtp_test;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FXMLController implements Initializable {

	@FXML
	private TextField emailTo;
	
	@FXML
	private TextField emailCC;
	
	@FXML
	private TextArea emailContent;
	
	@FXML
	private Button button_send;
	
	@FXML
	private void handleCancelAction(ActionEvent event) {
		System.out.println("test22");
	}
	
	@FXML
	private void handleSendEmailAction(ActionEvent event) {
		System.out.println("test11");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	private void _sendEmail(String host, String userName, String password,
			String to, String from, String subject, String content) {
      // Recipient's email ID needs to be mentioned.
//      String to = "yhjhoo@gmail.com";
//
//      // Sender's email ID needs to be mentioned
//      String from = "test@itrade.com";
//
//      // Assuming you are sending email from localhost
//      String host = "SMTP401";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(content);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
