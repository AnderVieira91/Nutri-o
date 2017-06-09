package edu.fatec.sjc.internet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Bula {

	// mudar na hora do envio, apenas exemplo
	private static final String PARAMS = "hddLetra=&txtMedicamento=dipirona&txtEmpresa=&txtNuExpediente=&txtDataPublicacaoI=&"
			+ "txtDataPublicacaoF=&txtPageSize=10&btnPesquisar=";
	private static final String METHOD_POST = "POST";
	private static final String METHOD_GET = "GET";
	private static final String METHOD_PUT = "PUT";
	private static final String METHOD_DELETE = "DELETE";
	private static final String URL = "http://www.anvisa.gov.br/datavisa/fila_bula/frmResultado.asp";
	private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
	private static final String USER_AGENT = "Mozzilla/5.0";

	public static String sendAbstractMethodRequest(Object params) throws IOException {

		URL obj = new URL(URL);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod(METHOD_POST);

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-Type", CONTENT_TYPE);
		con.setRequestProperty("charset", "utf-8");
		con.setRequestProperty("Host", " www.anvisa.gov.br");
		con.setRequestProperty("Accept-Language", " pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3");
		con.setRequestProperty("Referer", "http://www.anvisa.gov.br/datavisa/fila_bula/index.asp");
		con.setRequestProperty("Cookie",
				"ga=GA1.3.657687836.1488590154; ASPSESSIONIDQSDTTCSS=GJAMNMNAEDPLAOBJCOBIOKJJ; _gid=GA1.3.489430488.1496960200");
		con.setRequestProperty("Connection", "keep-alive");
		con.setRequestProperty("Upgrade-Insecure-Requests", "1");

		
		con.setDoOutput(true);
		
		if (params != null) {
			byte[] postData = params.toString().getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			con.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
				wr.write(postData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String s = String.valueOf(response).replace(new String("frmVisualizarBula.asp?pNuTransacao="), new String("http://www.anvisa.gov.br/datavisa/fila_bula/frmVisualizarBula.asp?pNuTransacao="));

		return s;
	}

}
