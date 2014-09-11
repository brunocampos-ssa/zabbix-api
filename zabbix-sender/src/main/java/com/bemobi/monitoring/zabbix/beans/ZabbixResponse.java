/**
 * 
 */
package com.bemobi.monitoring.zabbix.beans;

/**
 * @author brcampos
 *
 */
public class ZabbixResponse {
	
	private String response;
	
	private String info;	
	

	/**
	 * 
	 */
	public ZabbixResponse() {
		super();
	}

	/**
	 * @param response
	 * @param info
	 */
	public ZabbixResponse(String response, String info) {
		super();
		this.response = response;
		this.info = info;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ZabbixResponse [response=" + response + ", info=" + info + "]";
	}

}
