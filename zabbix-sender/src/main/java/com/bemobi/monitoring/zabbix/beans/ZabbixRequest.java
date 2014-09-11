/**
 * 
 */
package com.bemobi.monitoring.zabbix.beans;

import java.util.ArrayList;

/**
 * @author brcampos
 *
 */
public class ZabbixRequest {

	private String request;

	private ArrayList<ZabbixRequestData> data;

	/**
	 * @param request
	 * @param data
	 */
	public ZabbixRequest(String request, ArrayList<ZabbixRequestData> data) {
		super();
		this.request = request;
		this.data = data;
	}

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * @return the data
	 */
	public ArrayList<ZabbixRequestData> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(ArrayList<ZabbixRequestData> data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ZabbixRequest [request=").append(request).append(", data=");
		
		for (ZabbixRequestData zabbixRequestData : data) {
			sb.append("[").append(zabbixRequestData.toString()).append("]\n");
		}

		return sb.toString();
	}

}
