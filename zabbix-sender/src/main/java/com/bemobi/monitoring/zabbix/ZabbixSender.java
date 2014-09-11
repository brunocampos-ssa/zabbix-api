/**
 * 
 */
package com.bemobi.monitoring.zabbix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import com.bemobi.monitoring.zabbix.beans.ZabbixRequest;
import com.bemobi.monitoring.zabbix.beans.ZabbixRequestData;
import com.bemobi.monitoring.zabbix.beans.ZabbixResponse;

/**
 * @author brcampos
 *
 */
public class ZabbixSender {
	
	private static final String ZABBIX_RESPONSE_HEARDER = "ZBXD\1";
	private static final Integer SO_TIMEOUT = 60000;
	private static final String SOCKET_ENCODE = "US-ASCII";
	private static final String ZABBIX_REQUEST_SENDER_STRING = "sender data";
	private static final String ZABBIX_RESPONSE_SUCCESSFUL_STRING = "success";

	private ObjectMapper mapper = new ObjectMapper();

	private String zabbixServer;

	private Integer zabbixPort;

	public ZabbixSender(String zabbixServer, Integer zabbixPort) {

		this.zabbixServer = zabbixServer;
		this.zabbixPort = zabbixPort;

	}

	public ZabbixResponse send(ArrayList<ZabbixRequestData> zabbixData)
			throws UnknownHostException, IOException {

		Socket zabbixClient = null;
		OutputStreamWriter out = null;
		BufferedReader in = null;
		
		ZabbixResponse response = null;

		try {

			zabbixClient = new Socket(zabbixServer, zabbixPort);
			zabbixClient.setSoTimeout(ZabbixSender.SO_TIMEOUT);			

			ZabbixRequest request = new ZabbixRequest(ZabbixSender.ZABBIX_REQUEST_SENDER_STRING, zabbixData);

			StringWriter writer = new StringWriter();
			mapper.writeValue(writer, request);

			out = new OutputStreamWriter(zabbixClient.getOutputStream());
			out.write(writer.toString());
			out.flush();

			StringBuilder responseString = new StringBuilder("{");
			in = new BufferedReader(new InputStreamReader(
					zabbixClient.getInputStream(),
					ZabbixSender.SOCKET_ENCODE));
			String currentLine = in.readLine();

			if (!currentLine
					.contains(ZabbixSender.ZABBIX_RESPONSE_HEARDER)) {
				throw new IOException(
						"Zabbix server or proxy do not answer properly");
			}

			while ((currentLine = in.readLine()) != null) {
				responseString.append(currentLine);
			}

			response = mapper.readValue(
					responseString.toString(), ZabbixResponse.class);

			if (response == null
					|| !response
							.getResponse()
							.trim()
							.toLowerCase()
							.equals(ZabbixSender.ZABBIX_RESPONSE_SUCCESSFUL_STRING
									.toLowerCase())) {

				throw new IOException(
						"Zabbix server or proxy do not answer properly");
			}

		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			if (zabbixClient != null) {
				zabbixClient.close();
			}
		}
		
		return response;

	}

}