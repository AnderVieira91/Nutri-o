package edu.fatec.sjc.envio;

import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

// https://www.google.com/settings/security/lesssecureapps

public class Envio {

	public void impressao(String texto) {
		try {
			PrintService impressora = null;
			Boolean encontrou = false;
			PrintService[] printServices = PrinterJob.lookupPrintServices();

			for (PrintService printService : printServices) {
				String nomeImpressora = printService.getName();
				if (nomeImpressora.equals("DTC4000 Card Printer")) {
					impressora = printService;
					encontrou = true;
				}
			}
	
			String textoImpressao = texto + "\f";
			InputStream is = new ByteArrayInputStream(textoImpressao.getBytes());
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

			// Procurar o serviço de impressora padrão
			PrintService service = PrintServiceLookup.lookupDefaultPrintService();
			System.out.println(service);

			// Criar um serviço de impressao
			DocPrintJob job = service.createPrintJob();
			Doc doc = new SimpleDoc(is, flavor, null);

			//Monitorar eventos de impressora
			PrintJobWatcher printJob = new PrintJobWatcher(job);

			// Imprimir
			job.print(doc, null);

			// Esperar terminar de imprimir
			printJob.waitForDone();

			// fechar input stream
			is.close();
		} catch (PrintException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void enviarEmail(String from, String password, String to, String sub, String msg) {
		//Propriedades do servidor
		final String de = from;
		final String senha = password;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// Sessao
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(de, senha);
			}
		});
		// Compor mensagem
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	static class PrintJobWatcher {
		// true iff it is safe to close the print job's input stream
		boolean done = false;

		PrintJobWatcher(DocPrintJob job) {
			// Add a listener to the print job
			job.addPrintJobListener(new PrintJobAdapter() {
				public void printJobCanceled(PrintJobEvent pje) {
					allDone();
				}

				public void printJobCompleted(PrintJobEvent pje) {
					allDone();
				}

				public void printJobFailed(PrintJobEvent pje) {
					allDone();
				}

				public void printJobNoMoreEvents(PrintJobEvent pje) {
					allDone();
				}

				void allDone() {
					synchronized (PrintJobWatcher.this) {
						done = true;
						PrintJobWatcher.this.notify();
					}
				}
			});
		}

		public synchronized void waitForDone() {
			try {
				while (!done) {
					wait();
				}
			} catch (InterruptedException e) {
			}
		}
	}
	
	

}
