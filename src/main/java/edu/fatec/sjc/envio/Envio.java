package edu.fatec.sjc.envio;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;

public class Envio {

	public void impressao(String textoimp) {

		// /n/r para novas linhas e /f para fim da pagina
		try {
			InputStream prin = new ByteArrayInputStream(textoimp.getBytes());
			DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			SimpleDoc documentoTexto = new SimpleDoc(prin, docFlavor, null);
			PrintService impressora = PrintServiceLookup.lookupDefaultPrintService(); // pega
																						// a
																						// //impressora
																						// padrao
			PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
			printerAttributes.add(new JobName("Impressao", null));
			printerAttributes.add(OrientationRequested.PORTRAIT);
			printerAttributes.add(MediaSizeName.ISO_A4); // informa o tipo de
															// folha
			DocPrintJob printJob = impressora.createPrintJob();

			try {
				printJob.print(documentoTexto, (PrintRequestAttributeSet) printerAttributes); // tenta
																								// imprimir
			} catch (PrintException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro",
						JOptionPane.ERROR_MESSAGE); // mostra //mensagem de erro
			}
			prin.close();
		} catch (Exception e) {
		}
	}

	public void enviarEmail(String emailRemetenteA, String senhaA, String emailDestinatarioA, String textoA){
		// Recipient's email ID needs to be mentioned.
	      String to = emailDestinatarioA;

	      // Sender's email ID needs to be mentioned
	      String from = "nutricional@nutricao";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system propertiese
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
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Orientação Nutricional");

	         // Now set the actual message
	         message.setText(textoA);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
  }

	public static void main(String[] args){
		Envio e = new Envio();
		e.enviarEmail("a", "a", "arthurr.sa@hotmail.com", "teste");
	}
	

}
